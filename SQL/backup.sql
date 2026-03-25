-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.43 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para bdestudo
DROP DATABASE IF EXISTS `bdestudo`;
CREATE DATABASE IF NOT EXISTS `bdestudo` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdestudo`;

-- Copiando estrutura para tabela bdestudo.cidade
DROP TABLE IF EXISTS `cidade`;
CREATE TABLE IF NOT EXISTS `cidade` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `uf` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela bdestudo.cidade: ~18 rows (aproximadamente)
INSERT INTO `cidade` (`codigo`, `nome`, `uf`) VALUES
	(7, 'a', 'a'),
	(8, 'as', 'as'),
	(9, 'k', ''),
	(10, 's', 's'),
	(11, 'a', 'a'),
	(12, '', ''),
	(13, 'a', 'a'),
	(14, '', ''),
	(15, '', ''),
	(16, '', ''),
	(17, 'a', 'a'),
	(18, '', ''),
	(19, 'paraguacu', 'mg'),
	(20, '', ''),
	(21, 'a', 'a'),
	(22, 'Paraguaçu-MG', 'MG');

-- Copiando estrutura para tabela bdestudo.produto
DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  `precoVenda` double DEFAULT NULL,
  `precoCompra` double DEFAULT NULL,
  `quantidadeEstoque` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela bdestudo.produto: ~0 rows (aproximadamente)
INSERT INTO `produto` (`codigo`, `descricao`, `precoVenda`, `precoCompra`, `quantidadeEstoque`) VALUES
	(1, 'Agua', 20, 10, 30),
	(2, 'da', 2, 1, 2),
	(4, 'as', 2, 2, 2),
	(5, 's', 2, 1, 2),
	(6, 'Limonada', 20, 40, 90),
	(7, 'Maçaa', 10, 20, 12),
	(9, 'amilton ', 23, 12, 12);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
