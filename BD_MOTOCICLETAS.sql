-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.33 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para ventamotocicletas
CREATE DATABASE IF NOT EXISTS `ventamotocicletas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ventamotocicletas`;

-- Volcando estructura para tabla ventamotocicletas.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `cod_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `ci` varchar(15) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cod_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ventamotocicletas.clientes: ~4 rows (aproximadamente)
INSERT INTO `clientes` (`cod_cliente`, `ci`, `nombres`, `apellidos`, `celular`) VALUES
	(2, '12607565', 'Dennis Oliver', 'Saravia Quino', '78858558'),
	(3, '1200098', 'Wilfredo ', 'APAZA SACA', '19928'),
	(4, '96456987', 'Maria', 'Salvatierra Saverdra', '78750080'),
	(6, '12345', 'JUANITO BRANDON', 'ARCOIRIS', '888888');

-- Volcando estructura para tabla ventamotocicletas.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `cod_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `ci` varchar(15) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `direccion` text,
  PRIMARY KEY (`cod_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ventamotocicletas.empleado: ~5 rows (aproximadamente)
INSERT INTO `empleado` (`cod_empleado`, `ci`, `nombres`, `apellidos`, `celular`, `direccion`) VALUES
	(1, '122Lp', 'Yulia', 'Torrez Quispe', '123', 'los andes'),
	(2, '9093707', 'Emanuel', 'Mamani Aliaga', '1614320', NULL),
	(3, '9093707', 'Emanuel', 'Mamani Aliaga', '1614320', 'boby'),
	(5, '9093707', 'Wilfredo ', 'Saravia Quispe', '6060686', 'alto lima'),
	(6, '12607565', 'DENNIS', 'OLIVER ', '78858558', 'ALTO LIMA');

-- Volcando estructura para tabla ventamotocicletas.motocicletas
CREATE TABLE IF NOT EXISTS `motocicletas` (
  `cod_moto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `placa` varchar(15) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `color` varchar(30) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `img` text,
  PRIMARY KEY (`cod_moto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ventamotocicletas.motocicletas: ~5 rows (aproximadamente)
INSERT INTO `motocicletas` (`cod_moto`, `descripcion`, `placa`, `marca`, `tipo`, `color`, `precio`, `img`) VALUES
	(1, 'MOTOCICLETA NINJA', '10093', 'trueno', 'ninja', 'rojo', 10000, NULL),
	(2, 'MOTO TEKEN', '5678', 'no hay', 'Teken', 'amarillo', 10000, NULL),
	(3, 'MOTO DEPORTIVA', '987Y67867', 'HONDA', 'DEPORTIVA', 'AZUL', 16000, NULL),
	(4, 'MOTO-TAXI', '76UII', 'SUZUKI', 'CARGA', 'ROJO', 15000, NULL),
	(5, 'MOTONETA', '789IJKO', 'PEGASUS', '', 'BLANCO', 7000, NULL);

-- Volcando estructura para tabla ventamotocicletas.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `email` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `id_emp` int(11) DEFAULT NULL,
  KEY `id_emp` (`id_emp`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_emp`) REFERENCES `empleado` (`cod_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ventamotocicletas.usuarios: ~1 rows (aproximadamente)
INSERT INTO `usuarios` (`email`, `PASSWORD`, `id_emp`) VALUES
	('oliver15quino@gmail.com', '5e70f7b575e789178f32ca3177265bc898bd242c', 1);

-- Volcando estructura para tabla ventamotocicletas.ventas
CREATE TABLE IF NOT EXISTS `ventas` (
  `cod_ventas` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_moto` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `total` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`cod_ventas`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_moto` (`id_moto`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`cod_empleado`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`cod_cliente`),
  CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`id_moto`) REFERENCES `motocicletas` (`cod_moto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla ventamotocicletas.ventas: ~4 rows (aproximadamente)
INSERT INTO `ventas` (`cod_ventas`, `id_empleado`, `id_cliente`, `id_moto`, `fecha`, `total`) VALUES
	(2, 1, 2, 2, '2023-06-25', 10000),
	(3, 5, 2, 1, '2025-12-14', 1900),
	(4, 6, 3, 1, NULL, 10000),
	(5, 6, 6, 2, '2023-06-28', 10000);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
