-- Set the default DB
-- replace INITIALS with your username (the text before the @easv.dk symbol)
USE master;
GO
IF EXISTS(SELECT * FROM sys.databases WHERE name = '<INITIALS>_BankAccount')
BEGIN
DROP DATABASE <INITIALS>_BankAccount;
END

CREATE DATABASE <INITIALS>_BankAccount;
GO
USE <INITIALS>_BankAccount;
GO

CREATE TABLE Account
(
    [ID] int IDENTITY NOT NULL PRIMARY KEY,
    [Name] varchar(20) NULL,
    [Balance] int NOT NULL
)

INSERT INTO Account VALUES ('Spendings', 0);
INSERT INTO Account VALUES ('Savings', 1000);