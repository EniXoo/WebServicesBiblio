CREATE TABLE IF NOT EXISTS Author
(
    authorid serial PRIMARY KEY,
    firstname varchar (50) NOT NULL,
    lastname varchar(50) NOT NULL
)