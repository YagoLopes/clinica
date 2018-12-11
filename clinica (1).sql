-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 07-Nov-2018 às 21:14
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda_consulta`
--

DROP TABLE IF EXISTS `agenda_consulta`;
CREATE TABLE IF NOT EXISTS `agenda_consulta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `retorno` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cancelado` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `motivo_cancelamento` text COLLATE utf8_swedish_ci,
  `usuarios_id` int(11) NOT NULL,
  `medicos_id` int(11) NOT NULL,
  `pacientes_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_agenda_consulta_usuarios_idx` (`usuarios_id`),
  KEY `fk_agenda_consulta_medicos1_idx` (`medicos_id`),
  KEY `fk_agenda_consulta_pacientes1_idx` (`pacientes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `convenios`
--

DROP TABLE IF EXISTS `convenios`;
CREATE TABLE IF NOT EXISTS `convenios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empresa` varchar(45) COLLATE utf8_swedish_ci NOT NULL,
  `cnpj` varchar(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  `telefone` varchar(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
CREATE TABLE IF NOT EXISTS `especialidades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Extraindo dados da tabela `especialidades`
--

INSERT INTO `especialidades` (`id`, `descricao`) VALUES
(6, 'Especialidade 01'),
(7, 'Especialidade 02'),
(8, 'Especialidade 03'),
(9, 'Especialidade 04'),
(10, 'Especialidade 05'),
(11, 'Especialidade 06'),
(12, 'Especialidade 07'),
(13, 'Especialidade 08'),
(14, 'Especialidade 09'),
(15, 'Especialidade 10'),
(16, 'Especialidade 11'),
(17, 'Especialidade 12'),
(18, 'Especialidade 13'),
(19, 'Especialidade 14'),
(20, 'Especialidade 15'),
(21, 'Especialidade 16'),
(22, 'Especialidade 17'),
(23, 'Especialidade 18'),
(24, 'Especialidade 19'),
(25, 'Especialidade 20'),
(26, 'Especialidade 21'),
(27, 'Especialidade 22'),
(28, 'Especialidade 23'),
(29, 'Especialidade 24'),
(30, 'Especialidade teste'),
(31, NULL),
(32, NULL),
(33, NULL),
(34, NULL),
(35, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
CREATE TABLE IF NOT EXISTS `funcionarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_swedish_ci NOT NULL,
  `rg` varchar(12) COLLATE utf8_swedish_ci DEFAULT NULL,
  `orgao_emissor` varchar(6) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cpf` varchar(14) COLLATE utf8_swedish_ci DEFAULT NULL,
  `endereco` varchar(50) COLLATE utf8_swedish_ci DEFAULT NULL,
  `numero` varchar(15) COLLATE utf8_swedish_ci DEFAULT NULL,
  `complemento` varchar(30) COLLATE utf8_swedish_ci DEFAULT NULL,
  `bairro` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cidade` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  `estado` varchar(2) COLLATE utf8_swedish_ci DEFAULT NULL,
  `telefone` varchar(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  `celular` varchar(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  `ctps` varchar(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  `pis` varchar(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`id`, `nome`, `rg`, `orgao_emissor`, `cpf`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `telefone`, `celular`, `ctps`, `pis`, `nascimento`) VALUES
(1, 'Luizinho IMEPAC', 'MG11.807.122', 'SSP', '051.814.566-12', 'Rua das coxas', '123', 'apartamento 123', 'Saraiva', 'Uberlândia', 'MG', '(34) 9925-9302', '(', 'null', 'null', '1981-01-21'),
(3, 'Marcos Paulo', '222222222', 'SSP', '111.111.111-11', 'Endereço', '122', 'APT', 'Saraiva', 'Araguari', 'MG', '(44) 4555-5542', '(44) 4444-4444', '09989098888', '878900998', '2017-01-11'),
(4, 'Teste', '', '', '099.277.726-62', '', '', '', '', '', '', '', '', '', '', '2018-01-08'),
(5, 'Funcionario', '', '', '112.123.123-12', '', '', '', '', '', '', '', '', '', '', '2018-01-08');

-- --------------------------------------------------------

--
-- Estrutura da tabela `medicos`
--

DROP TABLE IF EXISTS `medicos`;
CREATE TABLE IF NOT EXISTS `medicos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  `crm` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  `especialidades_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medicos_especialidades1_idx` (`especialidades_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Extraindo dados da tabela `medicos`
--

INSERT INTO `medicos` (`id`, `nome`, `crm`, `especialidades_id`) VALUES
(1, 'Medico 01', 'CRM 01', 6),
(2, 'Médico 1710201801', 'CRM1710201801', 6),
(3, 'Médico 1710201802', 'CRM1710201802', 12),
(4, 'Médico 1710201802', 'CRM1710201802', 12),
(5, 'Médico 1710201802', 'CRM1710201802', 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_swedish_ci NOT NULL,
  `rg` varchar(12) COLLATE utf8_swedish_ci DEFAULT NULL,
  `orgao_emissor` varchar(6) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cpf` varchar(14) COLLATE utf8_swedish_ci DEFAULT NULL,
  `endereco` varchar(50) COLLATE utf8_swedish_ci DEFAULT NULL,
  `numero` varchar(15) COLLATE utf8_swedish_ci DEFAULT NULL,
  `complemento` varchar(30) COLLATE utf8_swedish_ci DEFAULT NULL,
  `bairro` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cidade` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  `estado` varchar(2) COLLATE utf8_swedish_ci DEFAULT NULL,
  `telefone` varchar(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  `celular` varchar(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `sexo` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `tem_convenio` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `senha` varchar(100) COLLATE utf8_swedish_ci DEFAULT NULL,
  `pacientescol` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  `convenios_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pacientes_convenios1_idx` (`convenios_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prontuario_paciente`
--

DROP TABLE IF EXISTS `prontuario_paciente`;
CREATE TABLE IF NOT EXISTS `prontuario_paciente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `historico` text COLLATE utf8_swedish_ci,
  `receituario` text COLLATE utf8_swedish_ci,
  `exames` text COLLATE utf8_swedish_ci,
  `agenda_consulta_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prontuario_paciente_agenda_consulta1_idx` (`agenda_consulta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_swedish_ci NOT NULL,
  `senha` varchar(100) COLLATE utf8_swedish_ci NOT NULL,
  `cad_funcionario` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cad_usuario` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cad_paciente` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cad_especialidade` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cad_medico` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `cad_convenio` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `ag_consulta` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `can_consulta` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `mod_administrativo` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `mod_agendamento` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  `mod_atendimento` varchar(1) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `senha`, `cad_funcionario`, `cad_usuario`, `cad_paciente`, `cad_especialidade`, `cad_medico`, `cad_convenio`, `ag_consulta`, `can_consulta`, `mod_administrativo`, `mod_agendamento`, `mod_atendimento`) VALUES
(1, 'usuario01', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(2, 'usuario02', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(3, 'usuario03', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(4, 'usuario04', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(5, 'usuario05', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(6, 'usuario06', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(7, 'usuario07', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(8, 'usuario08', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(9, 'usuario09', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(10, 'usuario10', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(11, 'usuario11', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(12, 'usuario12', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(13, 'usuario13', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(14, 'usuario14', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(15, 'usuario15', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'),
(16, 'usuario16', '12345678', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `agenda_consulta`
--
ALTER TABLE `agenda_consulta`
  ADD CONSTRAINT `fk_agenda_consulta_medicos1` FOREIGN KEY (`medicos_id`) REFERENCES `medicos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_agenda_consulta_pacientes1` FOREIGN KEY (`pacientes_id`) REFERENCES `pacientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_agenda_consulta_usuarios` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `medicos`
--
ALTER TABLE `medicos`
  ADD CONSTRAINT `fk_medicos_especialidades1` FOREIGN KEY (`especialidades_id`) REFERENCES `especialidades` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `pacientes`
--
ALTER TABLE `pacientes`
  ADD CONSTRAINT `fk_pacientes_convenios1` FOREIGN KEY (`convenios_id`) REFERENCES `convenios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `prontuario_paciente`
--
ALTER TABLE `prontuario_paciente`
  ADD CONSTRAINT `fk_prontuario_paciente_agenda_consulta1` FOREIGN KEY (`agenda_consulta_id`) REFERENCES `agenda_consulta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
