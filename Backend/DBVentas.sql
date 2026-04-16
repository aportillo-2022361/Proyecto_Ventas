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
 
CREATE TABLE Register (
	codigo_register INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30),
    password VARCHAR(40),
    isAdmin BOOLEAN
);
 
CREATE TABLE Login (
	codigo_user INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30),
    password VARCHAR(40),
    isAdmin BOOLEAN
);
 
INSERT INTO Login(username, password, isAdmin) VALUES("Sniper", "123", TRUE);
INSERT INTO Login(username, password, isAdmin) VALUES("Kinal", "1234", FALSE);
 
SELECT * FROM Login;
 
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
	SELECT codigo_user, username, password, isAdmin
    FROM Login
    WHERE username = p_username AND password = p_password;
END $$
DELIMITER ;
 
-- CREATE REGISTER --
DELIMITER $$
CREATE PROCEDURE sp_Register_CREATE (
	IN p_codigo_register INT,
	IN p_username VARCHAR(30),
    IN p_password VARCHAR(40),
    IN p_isAdmin BOOLEAN
)
BEGIN
	INSERT INTO Login(username, password, isAdmin) VALUES(p_username, p_password, p_isAdmin);
END $$
DELIMITER ;
 
-- CREATE PRODUCT --
DELIMITER $$
CREATE PROCEDURE sp_Productos_Create (
    IN p_nombre_producto VARCHAR(60),
    IN p_precio DECIMAL(10,2),
    IN p_stock INT,
    IN p_estado INT
)
BEGIN
	INSERT INTO Productos(nombre_producto, precio, stock, estado)
    VALUES (p_nombre_producto, p_precio, p_stock, p_estado);
END $$
DELIMITER ;
 
-- READ PRODUCT --
DELIMITER $$
CREATE PROCEDURE sp_Productos_READ (
)
BEGIN
	SELECT * FROM Productos;
END $$
DELIMITER ;
 
-- UPDATE PRODUCT --
DELIMITER $$
CREATE PROCEDURE sp_Productos_Update (
	IN p_codigo_producto INT,
    IN p_nombre_producto VARCHAR(60),
    IN p_precio DECIMAL(10,2),
    IN p_stock INT,
    IN p_estado INT
)
BEGIN 
	UPDATE Productos 
    SET p_nombre_producto = nombre_producto,
		p_precio = precio,
		p_stock = stock,
		p_estado = estado
        WHERE codigo_producto = p_codigo_producto;
END $$
DELIMITER ;
 
-- DELETE PRODUCT --
DELIMITER $$
CREATE PROCEDURE sp_Productos_Delete (
	IN p_codigo_producto INT
)
BEGIN
	DELETE FROM Productos 
    WHERE codigo_producto = p_codigo_producto;
END $$
 
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
	INSERT INTO Usuarios (username, password, email, rol, estado)
    VALUES (p_username, p_password, p_email, p_rol, p_estado);
END $$
DELIMITER ;
 
-- READ USER --
 
DELIMITER $$
CREATE PROCEDURE sp_Usuario_READ (
)
BEGIN
	SELECT * FROM Usuarios;
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
	UPDATE Usuarios
    SET p_username = username,
        p_password = password,
		p_email = email,
		p_rol = rol,
		p_estado = estado
        WHERE codigo_usuario = p_codigo_usuario;
END $$
DELIMITER ;
 
-- DELETE USER --
 
DELIMITER $$
CREATE PROCEDURE sp_Usuario_Delete (
	IN p_codigo_usuario INT
)
BEGIN
	DELETE FROM Usuarios 
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
    VALUES (p_fecha_venta, p_total, p_estado, p_Clientes_dpi_cliente, p_Usuarios_codigo_usuario);
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
	INSERT INTO DetalleVenta(cantidad, precio_unitario, subtotal, Productos_codigo_producto, Ventas_codigo_venta) 
    VALUES (p_cantidad, p_precio_unitario, p_subtotal, p_Productos_codigo_producto, p_Ventas_codigo_venta);
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
 
-- REGISTROS --
CALL sp_Productos_Create('Laptop Dell', 8500.00, 15, 1);
CALL sp_Productos_Create('Monitor 24"', 1200.00, 20, 1);
CALL sp_Productos_Create('Teclado Mecánico', 450.00, 30, 1);
CALL sp_Productos_Create('Mouse Gamer', 300.00, 50, 1);
CALL sp_Productos_Create('Impresora HP', 1800.00, 10, 1);
CALL sp_Productos_Create('Disco Duro 1TB', 600.00, 25, 1);
CALL sp_Productos_Create('Memoria RAM 16GB', 750.00, 40, 1);
CALL sp_Productos_Create('Procesador i7', 3200.00, 12, 1);
CALL sp_Productos_Create('Gabinete ATX', 550.00, 18, 1);
CALL sp_Productos_Create('Fuente 750W', 900.00, 22, 1);
 
CALL sp_Usuario_Create('admin_central', 'admin123', 'admin@mail.com', 'ADMIN', 1);
CALL sp_Usuario_Create('cajero_01', 'pass1', 'cajero1@mail.com', 'USER', 1);
CALL sp_Usuario_Create('cajero_02', 'pass2', 'cajero2@mail.com', 'USER', 1);
CALL sp_Usuario_Create('supervisor', 'super456', 'super@mail.com', 'ADMIN', 1);
CALL sp_Usuario_Create('vendedor_01', 'ven1', 'ven1@mail.com', 'USER', 1);
CALL sp_Usuario_Create('vendedor_02', 'ven2', 'ven2@mail.com', 'USER', 1);
CALL sp_Usuario_Create('bodega_jefe', 'bodega789', 'bodega@mail.com', 'USER', 1);
CALL sp_Usuario_Create('gerente', 'gerente0', 'gerente@mail.com', 'ADMIN', 1);
CALL sp_Usuario_Create('soporte_ti', 'ti999', 'ti@mail.com', 'ADMIN', 1);
CALL sp_Usuario_Create('auxiliar', 'aux123', 'aux@mail.com', 'USER', 1);
 
CALL sp_Clientes_Create('Carlos', 'Mendoza', 'Ciudad de Guatemala', 1);
CALL sp_Clientes_Create('Ana', 'García', 'Antigua Guatemala', 1);
CALL sp_Clientes_Create('Luis', 'Pérez', 'Quetzaltenango', 1);
CALL sp_Clientes_Create('María', 'López', 'Escuintla', 1);
CALL sp_Clientes_Create('Jorge', 'Rodríguez', 'Chimaltenango', 1);
CALL sp_Clientes_Create('Sofía', 'Martínez', 'Cobán', 1);
CALL sp_Clientes_Create('Roberto', 'Sánchez', 'Zacapa', 1);
CALL sp_Clientes_Create('Elena', 'Gómez', 'Jutiapa', 1);
CALL sp_Clientes_Create('Fernando', 'Díaz', 'Petén', 1);
CALL sp_Clientes_Create('Laura', 'Castillo', 'Retalhuleu', 1);
 
CALL sp_Ventas_Create('2024-05-01', 8500.00, 1, 1, 1);
CALL sp_Ventas_Create('2024-05-02', 1200.00, 1, 2, 2);
CALL sp_Ventas_Create('2024-05-03', 450.00, 1, 3, 3);
CALL sp_Ventas_Create('2024-05-04', 300.00, 1, 4, 4);
CALL sp_Ventas_Create('2024-05-05', 1800.00, 1, 5, 5);
CALL sp_Ventas_Create('2024-05-06', 600.00, 1, 6, 6);
CALL sp_Ventas_Create('2024-05-07', 750.00, 1, 7, 7);
CALL sp_Ventas_Create('2024-05-08', 3200.00, 1, 8, 8);
CALL sp_Ventas_Create('2024-05-09', 550.00, 1, 9, 9);
CALL sp_Ventas_Create('2024-05-10', 900.00, 1, 10, 10);
 
CALL sp_Detalles_Ventas_Create(1, 8500.00, 8500.00, 1, 1);
CALL sp_Detalles_Ventas_Create(2, 1200.00, 2400.00, 2, 2);
CALL sp_Detalles_Ventas_Create(1, 450.00, 450.00, 3, 3);
CALL sp_Detalles_Ventas_Create(3, 300.00, 900.00, 4, 4);
CALL sp_Detalles_Ventas_Create(1, 1800.00, 1800.00, 5, 5);
CALL sp_Detalles_Ventas_Create(2, 600.00, 1200.00, 6, 6);
CALL sp_Detalles_Ventas_Create(4, 750.00, 3000.00, 7, 7);
CALL sp_Detalles_Ventas_Create(1, 3200.00, 3200.00, 8, 8);
CALL sp_Detalles_Ventas_Create(1, 550.00, 550.00, 9, 9);
CALL sp_Detalles_Ventas_Create(2, 900.00, 1800.00, 10, 10);