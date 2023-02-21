-- Set the default DB
USE master;
GO
IF EXISTS(SELECT * FROM sys.databases WHERE name = 'SQLInjectionDB')
BEGIN
  DROP DATABASE SQLInjectionDB;
END

CREATE DATABASE SQLInjectionDB;
GO
USE SQLInjectionDB;
GO
CREATE TABLE Users (
                       Id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
);


-- Insert data
INSERT INTO Users VALUES ('MrBurns', 'Hounds');
INSERT INTO Users VALUES ('Homer', 'Burger');
