CREATE DATABASE ProyectoPOO;

CREATE TABLE Rol(
	id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50)
);

CREATE TABLE Departamento(
	id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Empleado(
    id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellidos VARCHAR(50) NOT NULL,
    idRol INT,
    idDepartamento INT,
    FOREIGN KEY (idRol) REFERENCES Rol(id),
    FOREIGN KEY (idDepartamento) REFERENCES Departamento(id)
);

create table usuarios(
    id_usuario int AUTO_INCREMENT PRIMARY KEY,
    nombres varchar(25),
    apellidos varchar(25),
    edad int,
    usuario varchar(20),
    password varchar(64),
    UNIQUE (usuario)
);
INSERT INTO Departamento VALUES (null,"Programacion");
INSERT INTO Empleado VALUES(null,'Alejandro','Alejo',1,1);

SELECT e.Nombre,r.Nombre AS Rol,d.Nombre AS Departamento
FROM Empleado e
INNER JOIN Rol r
ON e.idRol = r.id
INNER JOIN Departamento d
ON e.idDepartamento = d.id
WHERE e.Email = Usuario AND e.Contrasenia = Contrasenia;

CALL Loguearse ('alejandroalejo714@gmail.com','password');