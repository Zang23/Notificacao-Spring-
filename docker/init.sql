IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'notificacao_db')
BEGIN
    CREATE DATABASE notificacao_db;
END
GO