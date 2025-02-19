DROP DATABASE IF EXISTS gimnasioExamen4;
CREATE DATABASE gimnasioExamen4;
USE gimnasioExamen4;

DROP TABLE IF EXISTS socios;
DROP TABLE IF EXISTS planes;
DROP TABLE IF EXISTS formaPago;


--
-- Estructura tabla planes
--
CREATE TABLE `planes` (
  `cod_plan` int(11) NOT NULL AUTO_INCREMENT,
  `nom_plan` varchar(10) NOT NULL,
  `cuota_plan` float NOT NULL,
  PRIMARY KEY (`cod_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Estructura tabla formaPago
--
CREATE TABLE `formaPago` (
  `cod_pago` int(11) NOT NULL AUTO_INCREMENT,
  `nom_pago` varchar(10) NOT NULL,
  PRIMARY KEY (`cod_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Estructura tabla socios
--
CREATE TABLE `socios` (
  `id_socio` int(11) NOT NULL AUTO_INCREMENT,
  `ape_socio` varchar(15) NOT NULL,
  `id_pago` int(11) NOT NULL,
  `id_plan` int(11) NOT NULL,
  `cuota_cli` float NOT NULL,
  PRIMARY KEY (`id_socio`),
  KEY `id_plan` (`id_plan`),
  FOREIGN KEY (`id_plan`) REFERENCES `planes` (`cod_plan`) ON DELETE CASCADE,
  KEY `id_pago` (`id_pago`),
  FOREIGN KEY (`id_pago`) REFERENCES `formaPago` (`cod_pago`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserción de filas en tabla planes
--
INSERT INTO planes (nom_plan, cuota_plan) VALUES 
('Estándar', 45.0), 
('Básico', 30), 
('Premium', 70.0);

--
-- Inserción de filas en tabla formaPago
--
INSERT INTO formaPago (nom_pago) VALUES 
('mensual'), 
('anual');

--
-- Inserción de filas en tabla socios
--
INSERT INTO socios (ape_socio, id_pago, id_plan, cuota_cli) VALUES 
('García', '1', 1, 45.0),
('López', '1', 2, 30.0),
('Martínez', '2', 1, 45.0),
('Fernández', '2', 3, 70.0),
('Pérez', '2', 2, 30.0),
('Sánchez', '2', 1, 45.0),
('Gómez', '1', 3, 70.0),
('Ruiz', '2', 2, 30.0),
('Hernández', '1', 1, 45.0),
('Jiménez', '2', 3, 70.0);


