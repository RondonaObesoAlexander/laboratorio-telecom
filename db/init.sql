-- Aseguramos la BD (aunque midPoint la crea sola, es buena práctica)
CREATE DATABASE IF NOT EXISTS midpoint_db;
USE midpoint_db;

-- Tabla de clientes (simula el origen de datos que alimentará a Asterisk)
CREATE TABLE IF NOT EXISTS clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    full_name VARCHAR(100),
    email VARCHAR(100),
    phone_extension VARCHAR(20),
    active BOOLEAN DEFAULT TRUE
);

-- Insertamos datos de prueba para que midPoint los lea y provisione en Asterisk
INSERT INTO clients (username, full_name, email, phone_extension) 
VALUES ('agente1', 'Carlos Pérez', 'cperez@financiera.com', '1010')
ON DUPLICATE KEY UPDATE full_name=VALUES(full_name);

-- Creamos usuario para que midPoint pueda leer la tabla (opcional)
CREATE USER IF NOT EXISTS 'reader_user'@'%' IDENTIFIED BY 'reader_pass';
GRANT SELECT ON midpoint_db.* TO 'reader_user'@'%';
FLUSH PRIVILEGES;