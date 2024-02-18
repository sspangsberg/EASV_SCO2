-- Set the default DB
USE master;
GO
IF EXISTS(SELECT * FROM sys.databases WHERE name = '<PREFIX>_SQLInjectionDB')
BEGIN
  DROP DATABASE <PREFIX>_SQLInjectionDB;
END

CREATE DATABASE <PREFIX>_SQLInjectionDB;
GO
USE <PREFIX>_SQLInjectionDB;
GO
CREATE TABLE Users (
                       Id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
);


-- Insert data
INSERT INTO Users VALUES ('MrBurns', 'Hounds');
INSERT INTO Users VALUES ('Homer', 'Burger');
