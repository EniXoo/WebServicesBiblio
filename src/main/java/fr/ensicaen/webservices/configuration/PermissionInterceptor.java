package fr.ensicaen.webservices.configuration;

import fr.ensicaen.webservices.annotation.HasPermission;
import fr.ensicaen.webservices.util.JWTUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler
    ) throws Exception {

        String authorization = request.getHeader("Authorization");
        if(null != authorization) {
            Claims claims = jwtUtils.verify(authorization);
            String role = claims.get("userRole", String.class);

            logger.info("Pre handler");

            if (!(handler instanceof HandlerMethod)) {
                logger.info("Preflight request");
                return true;
            }

            HandlerMethod handlerMethod = (HandlerMethod) handler;

            if (!handlerMethod.hasMethodAnnotation(HasPermission.class)) {
                logger.info("@HasPermission annotation not defined.");
                return true;
            }

            HasPermission hasPermission = handlerMethod.getMethodAnnotation(HasPermission.class);

            List<String> roles = null;
            if (hasPermission != null) {
                roles = !StringUtils.hasText(hasPermission.roles())
                        ? new ArrayList<>() : Arrays.asList(hasPermission.roles().split(","));
            }

            if (roles != null && roles.contains(role)) {
                return true;
            }
        }

        logger.info("UNAUTHORIZED");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }

}
