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
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;

-- @block
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;

-- OUTER JOIN
-- @block
SELECT column_name(s)
FROM table1
OUTER JOIN table2
ON table1.column_name = table2.column_name;

-- @block
SELECT column_name(s)
FROM table1
OUTER JOIN table2
ON table1.column_name = table2.column_name;

-- LEFT OUTER JOIN
-- @block
SELECT column_name(s)
FROM table1
LEFT JOIN table2
ON table1.column_name = table2.column_name;

-- @block
SELECT column_name(s)
FROM table1
LEFT JOIN table2
ON table1.column_name = table2.column_name;

-- RIGHT OUTER JOIN
-- @block
SELECT column_name(s)
FROM table1
RIGHT JOIN table2
ON table1.column_name = table2.column_name;

-- @block
SELECT column_name(s)
FROM table1
RIGHT JOIN table2
ON table1.column_name = table2.column_name;

-- FULL OUTER JOIN
-- @block
SELECT * FROM table1
FULL OUTER JOIN table2
ON table2.column_name = table1.column_name

-- @block
SELECT * FROM table1
FULL OUTER JOIN table2
ON table2.column_name = table1.column_name

-- UNION
-- @block
SELECT column_name(s) FROM table1
UNION
SELECT column_name(s) FROM table2;


-- @block
SELECT column_name(s) FROM table1
UNION ALL
SELECT column_name(s) FROM table2;

-- VIEWS
-- @block
CREATE VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;

-- VIEWS
-- @block
CREATE VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;

-- STORED PROCEDURES
-- @block
CREATE PROCEDURE procedure_name
AS
SELECT * FROM table_name
GO;

EXEC procedure_name;
-- @block
CREATE PROCEDURE procedure_name
AS
SELECT * FROM table_name
GO;

EXEC procedure_name;

-- @block
CREATE PROCEDURE procedure_name
AS
SELECT * FROM table_name
GO;

EXEC procedure_name;