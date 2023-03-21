-- Set the default DB
-- replace INITIALS with your username (the text before the @easv.dk symbol)
USE master;
GO
IF EXISTS(SELECT * FROM sys.databases WHERE name = 'INITIALS_BankAccount')
BEGIN
DROP DATABASE INITIALS_BankAccount;
END

CREATE DATABASE INITIALS_BankAccount;
GO
USE SMSJ_BankAccount;
GO

CREATE TABLE Account
(
    [ID] int IDENTITY NOT NULL PRIMARY KEY,
    [Name] varchar(20) NULL,
    [Balance] int NOT NULL
)

    INSERT INTO Account VALUES ('Forbrug', 0);
INSERT INTO Account VALUES ('Opsparing', 1000);S ('Opsparing', 1000);