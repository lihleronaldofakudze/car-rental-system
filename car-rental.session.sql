
-- @block
CREATE DATABASE 902008012_902008049_902007983_902007972_902007943_902007900;

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

-- COMPARISON OPERATORS
-- @block
SELECT * FROM passengers
WHERE name='Khulani' OR username='Khuks';

-- @block
SELECT * FROM routes
WHERE name='MR3' AND type='HighWay';

-- @block
SELECT * FROM bookings
WHERE NOT ticket='LF8956' AND NOT booking_date='2022-12-12';



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
SELECT title, description
FROM roles
LEFT OUTER JOIN administrators
ON roles.id = administrators.role_id;

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
OUTER JOIN roles
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
SELECT *
FROM bookings
WHERE type = 'scheduled';

-- @block
CREATE VIEW specific_owner_id AS
SELECT car_number, type, category
FROM cars
WHERE owner_id = 24;

-- @block
CREATE VIEW admin_credentials AS
SELECT username, password
FROM administrators;

-- STORED PROCEDURES
-- @block
DELIMITER $$

CREATE PROCEDURE GetAllRoutes()
BEGIN
	SELECT *  FROM routes;
END $$

DELIMITER ;

-- @block
DELIMITER $$

CREATE PROCEDURE GetAllDrivers()
BEGIN
	SELECT *  FROM drivers;
END $$

DELIMITER ;

-- @block
DELIMITER $$

CREATE PROCEDURE GetAllRoles()
BEGIN
	SELECT *  FROM roles;
END $$

DELIMITER ;


-- TRIGGERS
CREATE TRIGGER deleting_booking
AFTER DELETE 
ON bookings FOR EACH ROW
SELECT * FROM bookings;
delimiter ;

CREATE TRIGGER inserting_cars
AFTER INSERT 
ON bookings FOR EACH ROW
SELECT * FROM cars;
delimiter ;

CREATE TRIGGER updating_passengers
BEFORE UPDATE 
ON bookings FOR EACH ROW
SELECT * FROM passengers;
delimiter ;