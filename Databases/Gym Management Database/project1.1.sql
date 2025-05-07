-- Team 4 - Gym Database SQL file
-- File: project.sql  
SPOOL project.txt
SET ECHO ON
/* 
Team 4 - Database Design Project
Beals, Sam
Inman, Lauren
Meadows, Steve
Spoehr, Cymbre
Young, Alex
*/

/* Create Tables */
CREATE TABLE Location (
locID INTEGER NOT NULL,
locName CHAR(30),
CONSTRAINT lIC1 PRIMARY KEY(locID)
);

CREATE TABLE LocationAmenities (
locID INTEGER NOT NULL,
amenityName CHAR(30) NOT NULL,
CONSTRAINT laIC1 PRIMARY KEY(locID, amenityName)
);

CREATE TABLE Employee (
ssn INTEGER NOT NULL,
name CHAR(30) NOT NULL,
age INTEGER,
locID INTEGER NOT NULL,
CONSTRAINT eIC1 PRIMARY KEY(ssn)
);

CREATE TABLE Class (
dateTime CHAR(20) NOT NULL,
locID INTEGER,
teacherID INTEGER,
title CHAR(30),
minimumAge INTEGER,
capacity INTEGER,
CONSTRAINT cIC1 PRIMARY KEY(dateTime, locID, teacherID)
);

CREATE TABLE Member (
mID INTEGER NOT NULL,
name CHAR(30),
age INTEGER,
membershipID INTEGER NOT NULL,
CONSTRAINT mIC1 PRIMARY KEY(mID)
);

CREATE TABLE ClassEnrolled (
mID INTEGER NOT NULL,
dateTime CHAR(20) NOT NULL,
locID INTEGER NOT NULL,
teacherID INTEGER NOT NULL,
CONSTRAINT ceIC1 PRIMARY KEY(mID, dateTime, locID, teacherID)
);

CREATE TABLE Membership (
membershipID INTEGER NOT NULL,
costPerMonth FLOAT,
tier CHAR(10),
paymentInfo CHAR(30),
CONSTRAINT msIC1 PRIMARY KEY(membershipID)
);

CREATE TABLE Commission (
membershipID INTEGER,
employeeSSN INTEGER,
comissionAmt FLOAT,
CONSTRAINT mcIC1 PRIMARY KEY(membershipID, employeeSSN)
);


SET FEEDBACK OFF
/* Populate Table Data */

-- location id, location name
INSERT INTO Location VALUES(1, 'Downtown');
INSERT INTO Location VALUES(2, 'Western');
INSERT INTO Location VALUES(3, 'County');

-- location id, amenity name
INSERT INTO LocationAmenities VALUES(1, 'Pool');
INSERT INTO LocationAmenities VALUES(1, 'Daycare');
INSERT INTO LocationAmenities VALUES(1, 'Sauna');
INSERT INTO LocationAmenities VALUES(3, 'Sauna');
INSERT INTO LocationAmenities VALUES(3, 'Juice Bar');
INSERT INTO LocationAmenities VALUES(4, 'Pool');

INSERT INTO Employee VALUES(3214326546, 'Jim Smith', 45, 1);
INSERT INTO Employee VALUES(1114254364, 'Kelly Jones', 21, 2);
INSERT INTO Employee VALUES(9769766432, 'Jackie Stevens', 78, 3);
INSERT INTO Employee VALUES(7543543643, 'Gus Johnson', 24, 1);

INSERT INTO Class VALUES('11/21/2022 8:00am', 1, 3214326546, 'Water Aerobics', NULL, 20);
INSERT INTO Class VALUES('11/23/2022 1:00pm', 2, 1114254364, 'Kickboxing', 18, 12);
INSERT INTO Class VALUES('11/23/2022 1:00pm', 1, 9769766432, 'Kickboxing', 18, 12);
INSERT INTO Class VALUES('11/23/2022 3:00pm', 3, 9769766432, 'Yoga', 18, 12);

INSERT INTO Member VALUES(1, 'Janet Green', 31, 1001);
INSERT INTO Member VALUES(2, 'Kyle Green', 33, 1001);
INSERT INTO Member VALUES(3, 'Amanda Johnson', 27, 1003);
INSERT INTO Member VALUES(4, 'Omar Little', 41, 1002);
INSERT INTO Member VALUES(5, 'Kelly Johnson', 57, 1003);

INSERT INTO Membership VALUES(1001, 32.99, 'Silver', 'Mastercard');
INSERT INTO Membership VALUES(1002, 32.99, 'Gold', 'Checking');
INSERT INTO Membership VALUES(1003, 32.99, 'Platinum', 'Bitcoin');

INSERT INTO ClassEnrolled VALUES(1, '11/21/2022 8:00am', 1, 3214326546);
INSERT INTO ClassEnrolled VALUES(2, '11/21/2022 8:00am', 1, 3214326546);
INSERT INTO ClassEnrolled VALUES(4, '11/23/2022 1:00pm', 2, 1114254364);
INSERT INTO ClassEnrolled VALUES(1, '11/23/2022 1:00pm', 2, 1114254364);

INSERT INTO Commission VALUES(1001, 3214326546, 45.59);

SET FEEDBACK ON
COMMIT;

/* Queries go here */
-- 1. A join involving at least four relations.
-- Finds the member id and name of 
SELECT DISTINCT M.mid, M.name
FROM Member M, Class C, ClassEnrolled E, Location L
WHERE M.mid = E.mid AND E.locID = L.locID AND C.title = 'Kickboxing' AND L.locID = 1;

-- 2. A self-join.
-- 3. UNION, INTERSECT, and/or MINUS.
SELECT L.locID, L.locName
FROM Location L, LocationAmenities A
WHERE A.locId = L.locID AND A.amenityName = 'Sauna'
UNION
SELECT L.locID, L.locName
FROM Location L, LocationAmenities A
WHERE A.locId = L.locID AND A.amenityName = 'Pool';

-- 4. SUM, AVG, MAX, and/or MIN.
SELECT AVG(age)
	FROM Member M;

-- 5. GROUP BY, HAVING, and ORDER BY, all appearing in the same query THIS CURRENTLY DOES NOT WORK
SELECT E.ssn, E.name
FROM   Employee E, Class C
WHERE  E.ssn = C.teacherID
GROUP BY E.ssn, E.name
HAVING C.capacity > 15
ORDER BY E.ssn, E.name;
-- 6. A correlated subquery.
SELECT M.mID, M.name
FROM Member M, ClassEnrolled CE
WHERE M.age > 49 AND EXISTS(SELECT *
				              FROM ClassEnrolled CE
				              WHERE M.mID = CE.mID);
-- 7. A non-correlated subquery.
SELECT L.locId, L.locName
FROM Location L, LocationAmenities A
WHERE L.locId = A.locID AND 
    A.amenityName = 'Daycare' 
    AND L.locID IN (SELECT C.locID FROM Class C);
    
-- 8. A relational DIVISION query.
-- 9. An outer join query.
SELECT M.mID, M.name, E.locID, E.dateTime
FROM Member M LEFT OUTER JOIN ClassEnrolled E ON M.mID=E.mID;


SELECT *
FROM Employee
WHERE age = 45;

COMMIT;
--
SPOOL OFF


