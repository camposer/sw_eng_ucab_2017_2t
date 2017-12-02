CREATE DATABASE persona_rest;
USE persona_rest;
CREATE TABLE persona (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	edad INT NULL
);
INSERT INTO persona VALUES(1, 'Rodolfo', 'Campos', 38);
INSERT INTO persona(id, nombre, apellido, edad) VALUES(2, 'Juan', 'P�rez', 30);
INSERT INTO persona(nombre, apellido, edad) VALUES('Roberto', 'Gonz�lez', 20);
INSERT INTO persona(apellido, nombre) VALUES('Ram�rez', 'F�lix');
SELECT * FROM persona;

