CREATE TABLE IF NOT EXISTS "user"
(
    userid serial PRIMARY KEY,
    login varchar (50) NOT NULL,
    hashpasswd varchar (64) NOT NULL,
    userrole varchar (100) NOT NULL,
    firstname varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    phonenumber varchar(15) NOT NULL,
    address varchar(100) NOT NULL
)