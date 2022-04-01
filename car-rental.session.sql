CREATE DATABASE 902006542_902006542_902006542_902006542_902006542_902006542;

-- @block
CREATE TABLE Roles (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	title TEXT NOT NULL UNIQUE,
	description TEXT NULL
);

-- @block
CREATE TABLE Administrators (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	role_id INT NOT NULL,
	name TEXT NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE,
	address VARCHAR(255) NOT NULL,
	username VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL UNIQUE,
	FOREIGN KEY (role_id) REFERENCES Roles(id)
);

-- @block
CREATE TABLE Cars (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	car_number INT NOT NULL,
	type TEXT NOT NULL,
	category TEXT NOT NULL,
	description TEXT NOT NULL,
	owner_id int NOT NULL UNIQUE
);

-- @block
CREATE TABLE Bookings (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	title TEXT NOT NULL,
	description VARCHAR(255) NOT NULL,
	type TEXT NOT NULL,
	ticket VARCHAR(50) NOT NULL,
	booking_date VARCHAR(255) NOT NULL
);

-- @block
CREATE TABLE Passengers (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	name TEXT NOT NULL,
	phone_number INT NOT NULL,
	address VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);

-- @block
CREATE TABLE Routes (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	type TEXT NOT NULL,
	description VARCHAR(255) NOT NULL,
	name TEXT NOT NULL
);

-- @block
CREATE TABLE Drivers (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	name TEXT NOT NULL,
	driver_number INT NOT NULL,
	address VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);

-- INNER JOIN
-- @block
SELECT *
FROM administrators
INNER JOIN roles
ON administrators.role_id = roles.id;

-- @block
SELECT *
FROM roles
INNER JOIN administrators
ON roles.id = administrators.id;

-- OUTER JOIN
-- @block
SELECT title
FROM roles
LEFT OUTER JOIN administrators
ON roles.id = administrators.role_id;

-- @block
SELECT username, password
FROM administrators
RIGHT OUTER JOIN roles
ON administrators.role_id = roles.id;

-- LEFT OUTER JOIN
-- @block
SELECT email, address
FROM administrators
LEFT OUTER JOIN roles
ON administrators.role_id = roles.id;

-- @block
SELECT column_name(s)
FROM table1
LEFT OUTER JOIN table2
ON table1.column_name = table2.column_name;

-- RIGHT OUTER JOIN
-- @block
SELECT title, description
FROM roles
RIGHT JOIN administrators
ON roles.id = administrators.role_id;

-- @block
SELECT username, password
FROM administrators
RIGHT JOIN roles
ON administrators.role_id = roles.id;

-- FULL OUTER JOIN
-- @block
SELECT * FROM administrators
FULL OUTER JOIN roles
ON roles.id = administrators.role_id;

-- @block
SELECT * FROM roles
FULL OUTER JOIN administrators
ON administrators.role_id = roles.id;

-- UNION
-- @block
SELECT * FROM bookings
UNION
SELECT * FROM passengers;


-- @block
SELECT name, driver_number FROM drivers
UNION ALL
SELECT car_number FROM cars;

-- VIEWS*
-- @block
CREATE VIEW scheduled_bookings AS
SELECT *.
FROM bookings
WHERE type = 'scheduled';

-- VIEWS
-- @block
CREATE VIEW specific_owner_id AS
SELECT car_number, type, category
FROM cars
WHERE owner_id = 24;

-- STORED PROCEDURES
-- @block
CREATE PROCEDURE all_drivers
AS
SELECT * FROM drivers
GO;

EXEC all_drivers;
-- @block
CREATE PROCEDURE all_bookings
AS
SELECT * FROM bookings
GO;

EXEC all_bookings;

-- @block
CREATE PROCEDURE all_passengers
AS
SELECT * FROM passengers
GO;

EXEC all_passengers;