DROP DATABASE IF EXISTS DB_Ventas_in5cm;
CREATE DATABASE DB_Ventas_in5cm;
USE DB_Ventas_in5cm;
 
CREATE TABLE Productos (
	codigo_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre_producto VARCHAR(60),
    precio DECIMAL(10,2),
    stock INT,
    estado INT
);
 
DROP PROCEDURE IF EXISTS sp_ValidarLogin;

CREATE TABLE Login (
	codigo_user INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE,
    password VARCHAR(40) UNIQUE
);

INSERT INTO Login(username, password) VALUES("Sniper", "123");
 
 
CREATE TABLE Usuarios (
	codigo_usuario INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(45),
    password VARCHAR(45),
    email VARCHAR(50),
    rol VARCHAR(45),
    estado INT
);
 
CREATE TABLE Clientes (
	dpi_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre_cliente VARCHAR(50),
    apellido_cliente VARCHAR(50),
    direccion VARCHAR(100),
    estado INT
);
 
CREATE TABLE Ventas (
	codigo_venta INT PRIMARY KEY AUTO_INCREMENT,
    fecha_venta DATE,
    total DECIMAL(10,2),
    estado INT,
    Clientes_dpi_cliente INT,
    Usuarios_codigo_usuario INT,
    FOREIGN KEY (Clientes_dpi_cliente) REFERENCES Clientes(dpi_cliente) ON DELETE CASCADE,
    FOREIGN KEY (Usuarios_codigo_usuario) REFERENCES Usuarios(codigo_usuario) ON DELETE CASCADE
);
 
CREATE TABLE DetalleVenta (
	codigo_detalle_venta INT PRIMARY KEY AUTO_INCREMENT,
    cantidad INT,
    precio_unitario DECIMAL(10,2),
    subtotal DECIMAL(10,2),
    Productos_codigo_producto INT,
    Ventas_codigo_venta INT
);
 
-- READ LOGIN --
DELIMITER $$
CREATE PROCEDURE sp_Login_READ (
	IN p_username VARCHAR(30),
	IN p_password VARCHAR(40)
)
BEGIN
	SELECT codigoUser, username, password
    FROM Login 
    WHERE username = p_username
    AND password = p_password
	LIMIT 1;
END $$
DELIMITER ;
 
 
-- CREATE USER --
 
DELIMITER $$
CREATE PROCEDURE sp_Usuario_Create (
	IN p_username VARCHAR(45),
    IN p_password VARCHAR(45),
    IN p_email VARCHAR(50),
    IN p_rol VARCHAR(45),
    IN p_estado INT
)
BEGIN
	INSERT INTO Usuario (username, password, email, rol, estado)
    VALUES (p_username, p_password, p_email, p_rol, p_estado);
    SELECT last_insert_id() as codigo_usuario;
END $$
DELIMITER ;
 
-- READ USER --
 
DELIMITER $$
CREATE PROCEDURE sp_Usuario_READ (
)
BEGIN
	SELECT * FROM Usuario;
END $$
DELIMITER ;
 
-- UPDATE USER --
 
DELIMITER $$
CREATE PROCEDURE sp_Usuario_Update (
	IN p_codigo_usuario INT,
	IN p_username VARCHAR(45),
    IN p_password VARCHAR(45),
    IN p_email VARCHAR(50),
    IN p_rol VARCHAR(45),
    IN p_estado INT
)
BEGIN 
	UPDATE Usuario 
    SET p_username = username,
        p_password = password,
		p_email = email,
		p_rol = rol,
		p_estado = estado
        WHERE codigo_usuario = p_codigo_usuario;
        SELECT ROW_COUNT() AS filas_afectadas;
END $$
DELIMITER ;
 
-- DELETE USER --
 
DELIMITER $$
CREATE PROCEDURE sp_Usuario_Delete (
	IN p_codigo_usuario INT
)
BEGIN
	DELETE FROM Usuario 
    WHERE codigo_usuario = p_codigo_usuario;
END $$
 
-- CREATE CLIENT --
 
DELIMITER $$
CREATE PROCEDURE sp_Clientes_Create (
	IN p_nombre_cliente VARCHAR(50),
    IN p_apellido_cliente VARCHAR(50),
    IN p_direccion VARCHAR(100),
    IN p_estado INT
)
BEGIN
	INSERT INTO Clientes(nombre_cliente, apellido_cliente, direccion, estado)
    VALUES (p_nombre_cliente, p_apellido_cliente, p_direccion, p_estado);
    SELECT LAST_INSERT_ID() AS dpi_cliente;
END $$
DELIMITER ;
 
-- READ CLIENT --
 
DELIMITER $$
CREATE PROCEDURE sp_Clientes_Read (
)
BEGIN
	SELECT * FROM Clientes;
END $$
DELIMITER ;
 
-- UPDATE CLIENT --
 
DELIMITER $$
CREATE PROCEDURE sp_Clientes_Update (
	IN p_dpi_cliente INT,
	IN p_nombre_cliente VARCHAR(50),
    IN p_apellido_cliente VARCHAR(50),
    IN p_direccion VARCHAR(100),
    IN p_estado INT
)
BEGIN
	UPDATE Clientes
    SET nombre_cliente = p_nombre_cliente,
		apellido_cliente = p_apellido_cliente,
        direccion = p_direccion,
        estado = p_estado
        WHERE dpi_cliente = p_dpi_cliente;
        SELECT ROW_COUNT() AS filas_afectadas;
END $$
DELIMITER ;
 
-- DELETE CLIENT --
 
DELIMITER $$
CREATE PROCEDURE sp_Clientes_Delete (
	IN p_dpi_cliente INT
)
BEGIN
	DELETE FROM Clientes 
    WHERE dpi_cliente = p_dpi_cliente;
END $$
DELIMITER ;
 
-- CREATE SALES --
 
DELIMITER $$
CREATE PROCEDURE sp_Ventas_Create (
    IN p_fecha_venta DATE,
    IN p_total DECIMAL(10,2),
    IN p_estado INT,
    IN p_Clientes_dpi_cliente INT,
    IN p_Usuarios_codigo_usuario INT
)
BEGIN
	INSERT INTO Ventas(fecha_venta, total, estado, Clientes_dpi_cliente, Usuarios_codigo_usuario) 
    VALUES (p_codigo_venta, p_fecha_venta, p_total, p_estado, p_Clientes_dpi_cliente, p_Usuarios_codigo_usuario);
    SELECT LAST_INSERT_ID() AS codigo_venta;
END $$
DELIMITER ;
 
-- READ SALES --
 
DELIMITER $$ 
CREATE PROCEDURE sp_Ventas_Read (
)
BEGIN
	SELECT * FROM Ventas;
END $$
DELIMITER ;
 
-- UPDATE SALES --
 
DELIMITER $$
CREATE PROCEDURE sp_Ventas_Update (
	IN p_codigo_venta INT,
    IN p_fecha_venta DATE,
    IN p_total DECIMAL(10,2),
    IN p_estado INT,
    IN p_Clientes_dpi_cliente INT,
    IN p_Usuarios_codigo_usuario INT
)
BEGIN
	UPDATE Ventas
    SET fecha_venta = p_fecha_venta,
		total = p_total,
        estado = p_estado,
        Clientes_dpi_cliente = p_Clientes_dpi_cliente,
        Usuarios_codigo_usuario = p_Usuarios_codigo_usuario
	WHERE codigo_venta = p_codigo_venta;
    SELECT ROW_COUNT() AS filas_afectadas;
END $$
DELIMITER ;
 
-- DELETE SALES --
 
DELIMITER $$
CREATE PROCEDURE sp_Ventas_Delete (
	IN p_codigo_venta INT
)
BEGIN
	DELETE FROM Ventas
    WHERE codigo_venta = p_codigo_venta;
END $$
DELIMITER ;
 
-- CREATE SALES DETAILS --
 
DELIMITER $$
CREATE PROCEDURE sp_Detalles_Ventas_Create (
    IN p_cantidad INT,
    IN p_precio_unitario DECIMAL(10,2),
    IN p_subtotal DECIMAL(10,2),
    IN p_Productos_codigo_producto INT,
    IN p_Ventas_codigo_venta INT
)
BEGIN
	INSERT INTO Ventas(cantidad, precio_unitario, subtotal, Productos_codigo_producto, Ventas_codigo_venta) 
    VALUES (p_cantidad, p_precio_unitario, p_subtotal, p_Productos_codigo_producto, p_Ventas_codigo_venta);
    SELECT LAST_INSERT_ID() AS codigo_venta;
END $$
DELIMITER ;
 
-- READ SALES DETAILS --
 
DELIMITER $$ 
CREATE PROCEDURE sp_Detalles_Ventas_Read (
)
BEGIN
	SELECT * FROM DetalleVenta;
END $$
DELIMITER ;
 
-- UPDATE SALES DETAILS --
 
DELIMITER $$
CREATE PROCEDURE sp_Detalles_Ventas_Update (
	IN p_codigo_detalle_venta INT,
    IN p_cantidad INT,
    IN p_precio_unitario DECIMAL(10,2),
    IN p_subtotal DECIMAL(10,2),
    IN p_Productos_codigo_producto INT,
    IN p_Ventas_codigo_venta INT
)
BEGIN
	UPDATE DetalleVenta
    SET cantidad = p_cantidad,
		precio_unitario = p_precio_unitario,
        subtotal = p_subtotal,
        Productos_codigo_producto = p_Productos_codigo_producto,
        Ventas_codigo_venta = p_Ventas_codigo_venta
	WHERE codigo_detalle_venta = p_codigo_detalle_venta;
    SELECT ROW_COUNT() AS filas_afectadas;
END $$
DELIMITER ;
 
-- DELETE SALES DETAILS --
 
DELIMITER $$
CREATE PROCEDURE sp_Detalles_Ventas_Delete (
	IN p_codigo_detalle_venta INT
)
BEGIN
	DELETE FROM DetalleVenta
    WHERE codigo_detalle_venta = p_codigo_detalle_venta;
END $$
DELIMITER ;


















