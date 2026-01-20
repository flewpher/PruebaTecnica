-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Jan 20, 2026 at 07:07 PM
-- Server version: 11.4.9-MariaDB
-- PHP Version: 8.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pruebatecnica`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `codigo` VARCHAR(24) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `uq_cliente_codigo` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `codigo`) VALUES
(1, 'Empresa A', 'EMA01'),
(2, 'Empresa B', 'EMB02'),
(3, 'Empresa C', 'EMC03'),
(4, 'Empresa D', 'EMD04'),
(5, 'Empresa E', 'EME05'),
(6, 'Empresa F', 'EMF06'),
(7, 'Empresa G', 'EMG07'),
(8, 'Empresa H', 'EMH08'),
(9, 'Empresa I', 'EMI09'),
(10, 'Empresa J', 'EMJ10');

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cliente_id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `uq_producto_cliente` (`cliente_id`,`nombre`),
  KEY `fk_producto_cliente` (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id_producto`, `cliente_id`, `nombre`) VALUES
(1, 1, 'Leche entera marca A'),
(5, 1, 'Pan de molde blanco'),
(11, 1, 'Spaghetti clásicos'),
(2, 2, 'Leche 1L entera'),
(3, 3, 'Leche entera clásica'),
(14, 3, 'Leche entera MismaMarca'),
(8, 4, 'Arroz largo'),
(4, 4, 'Leche entera premium'),
(6, 5, 'Pan sandwich'),
(7, 6, 'Pan de molde familiar'),
(13, 6, 'Spaghetti nº5'),
(9, 8, 'Arroz grano largo'),
(10, 9, 'Arroz largo calidad extra'),
(12, 10, 'Pasta spaghetti');

-- --------------------------------------------------------

--
-- Table structure for table `producto_equivalencia`
--

DROP TABLE IF EXISTS `producto_equivalencia`;
CREATE TABLE IF NOT EXISTS `producto_equivalencia` (
  `id_equivalencia` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `producto_a` bigint(20) UNSIGNED NOT NULL,
  `producto_b` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_equivalencia`),
  UNIQUE KEY `uq_producto_pair` (`producto_a`,`producto_b`),
  KEY `fk_pe_producto_b` (`producto_b`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `producto_equivalencia`
--

INSERT INTO `producto_equivalencia` (`id_equivalencia`, `producto_a`, `producto_b`) VALUES
(1, 1, 2),
(11, 1, 14),
(2, 2, 3),
(3, 3, 4),
(4, 5, 6),
(5, 6, 7),
(6, 8, 9),
(7, 9, 10),
(8, 11, 12),
(9, 11, 13);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `producto_equivalencia`
--
ALTER TABLE `producto_equivalencia`
  ADD CONSTRAINT `fk_pe_producto_a` FOREIGN KEY (`producto_a`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pe_producto_b` FOREIGN KEY (`producto_b`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
