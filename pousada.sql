-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22-Out-2020 às 21:28
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pousada`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `codigo_cliente` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `celular` varchar(30) NOT NULL,
  `profissao` varchar(255) NOT NULL,
  `nacionalidade` varchar(255) NOT NULL,
  `data_nasc` varchar(10) NOT NULL,
  `identidade` varchar(30) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `email` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `uf` varchar(100) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `genero` varchar(1) NOT NULL,
  `cdd` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`codigo_cliente`, `nome`, `celular`, `profissao`, `nacionalidade`, `data_nasc`, `identidade`, `cpf`, `email`, `endereco`, `uf`, `pais`, `genero`, `cdd`) VALUES
(17, 'Fernando Castilho Vargas', '(27) 9 6587-8563', 'Analista de Redes, Militar e Streamer', 'Brasileiro', '26/07/2020', '3.610.365-ES', '164.873.907-55', 'fecastilhovargas@gmail.com', 'Rua dos Alfeneiros, 4 - Howloes', 'RJ', 'Brasil', 'M', 'Armação dos Búzios'),
(18, 'Breno Lima na Rocha', '(22) 9 8256-6523', 'Estudante e Militar', 'Brasileiro', '23/01/2001', '6.541.321', '115.706.147-84', 'bmatematico11para12@gmail.com', 'Rua C, 56 - Lagoinha', 'Caminho de Búzios - Arraial do Cabo', 'Brasil', 'M', ''),
(19, 'Viviane Beatriz Ribeiro Pontes Nunes', '(22) 9 4002-8922', 'Streamer', 'Holandesa', '21/08/1969', '5.654.3-RJ', '106.989.707-80', 'vivibiaribeiro@gmail.com', 'Av Senador Dudu, 7 - Icaraí', 'Campos dos Goytacazes - RJ', 'Brasil', 'F', ''),
(21, 'Carlos Augusto Fernandes Filho', '(22) 9 9226 3256', 'Docente', 'Brasileiro', '21/08/1996', '3.365.654 - RJ', '056.855.617-84', 'augustomaneiro@oi.com.br', 'Rua dos Alfeneiros, 10 - Harry Potter', 'Serra - PE', 'Brasil', 'M', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `conhe_pousada`
--

CREATE TABLE `conhe_pousada` (
  `cod_cp` int(11) NOT NULL,
  `conhe_pousada` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `conhe_pousada`
--

INSERT INTO `conhe_pousada` (`cod_cp`, `conhe_pousada`) VALUES
(1, 'Site'),
(2, 'Facebook'),
(3, 'Instagram'),
(4, 'Booking'),
(5, 'Indicação');

-- --------------------------------------------------------

--
-- Estrutura da tabela `meio_transp`
--

CREATE TABLE `meio_transp` (
  `cod_mt` int(11) NOT NULL,
  `meio_transp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `meio_transp`
--

INSERT INTO `meio_transp` (`cod_mt`, `meio_transp`) VALUES
(1, 'Carro'),
(2, 'Ônibus'),
(3, 'Moto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `mot_viagem`
--

CREATE TABLE `mot_viagem` (
  `mot_viagem` varchar(255) NOT NULL,
  `cod_mv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `mot_viagem`
--

INSERT INTO `mot_viagem` (`mot_viagem`, `cod_mv`) VALUES
('Lazer', 1),
('Negócios', 2),
('Congresso', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `quarto`
--

CREATE TABLE `quarto` (
  `num_quarto` int(2) NOT NULL,
  `camas` int(11) NOT NULL,
  `armarios` int(11) NOT NULL,
  `frigobar` int(11) NOT NULL,
  `diaria` double NOT NULL,
  `obs` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `quarto`
--

INSERT INTO `quarto` (`num_quarto`, `camas`, `armarios`, `frigobar`, `diaria`, `obs`) VALUES
(1, 2, 1, 1, 300, ''),
(2, 2, 1, 1, 300, ''),
(3, 2, 1, 1, 300, 'Nada'),
(4, 2, 1, 1, 300, ''),
(5, 2, 1, 1, 300, ''),
(6, 3, 1, 1, 400, ''),
(7, 3, 1, 1, 400, ''),
(8, 3, 1, 1, 400, ''),
(9, 3, 1, 1, 400, ''),
(10, 4, 2, 2, 550, ''),
(11, 4, 2, 2, 550, ''),
(12, 4, 2, 2, 550, ''),
(13, 5, 3, 2, 700, ''),
(14, 2, 2, 1, 700, '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
--

CREATE TABLE `reserva` (
  `cpf` varchar(14) NOT NULL,
  `codigo` int(11) NOT NULL,
  `cod_quarto` int(2) NOT NULL,
  `check_in` date NOT NULL,
  `check_out` date NOT NULL,
  `placa_carro` varchar(20) NOT NULL,
  `reserva` double NOT NULL,
  `deposito` double NOT NULL,
  `inpag` double NOT NULL,
  `acompanhante1` varchar(255) NOT NULL,
  `acompanhante2` varchar(255) NOT NULL,
  `acompanhante3` varchar(255) NOT NULL,
  `acompanhante4` varchar(255) NOT NULL,
  `mot_viagem` int(11) NOT NULL,
  `meio_transp` int(11) NOT NULL,
  `conhe_pousada` int(11) NOT NULL,
  `forma_in` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `reserva`
--

INSERT INTO `reserva` (`cpf`, `codigo`, `cod_quarto`, `check_in`, `check_out`, `placa_carro`, `reserva`, `deposito`, `inpag`, `acompanhante1`, `acompanhante2`, `acompanhante3`, `acompanhante4`, `mot_viagem`, `meio_transp`, `conhe_pousada`, `forma_in`) VALUES
('164.873.907-55', 45, 1, '2020-10-06', '2020-10-08', 'KJO-6523', 300, 200, 100, '', '', '', '', 1, 1, 4, 'Dinheiro'),
('115.706.147-84', 46, 1, '2020-10-08', '2020-10-10', 'HJK-3652', 300, 300, 0, '', '', '', '', 2, 2, 3, 'Dinheiro'),
('106.989.707-80', 47, 1, '2020-10-10', '2020-10-12', 'LKO-6325', 300, 50, 250, '', '', '', '', 2, 2, 3, 'Transferência Bancária'),
('164.873.907-55', 48, 13, '2020-10-12', '2020-10-14', 'GHJ-2356', 700, 200, 500, 'Duda', 'Dona Arlinda', 'José Bonifácio', '', 2, 2, 3, 'Cartão de Débito'),
('115.706.147-84', 49, 13, '2020-10-14', '2020-10-16', 'GHJ-2356', 700, 500, 200, 'Carla Zambeli', 'Sara Winter', 'Carlos', 'Eduardo', 2, 3, 1, 'Transferência Bancária'),
('106.989.707-80', 50, 13, '2020-10-16', '2020-10-18', 'HGY-3265', 700, 500, 200, 'João Pedro', 'Joana D\'ark', 'Picasso', 'Pablo Marí', 1, 1, 3, 'Dinheiro'),
('056.855.617-84', 51, 14, '2020-10-14', '2020-10-18', 'HGF-9856', 700, 0, 700, 'Dilsinho do Gás', 'Flor de Lis', 'Ferrugem', 'Maria do Rosário', 2, 2, 3, 'Transferência Bancária'),
('056.855.617-84', 52, 14, '2020-10-18', '2020-10-20', 'UFH-5896', 700, 700, 0, '', '', '', '', 3, 1, 5, 'Cartão de Débito'),
('164.873.907-55', 53, 14, '2020-10-22', '2020-10-25', 'UHJ-6523', 700, 200, 200, '', '', '', '', 2, 2, 2, 'Cartão de Débito');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `codigo` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `privilegios` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`codigo`, `login`, `senha`, `privilegios`) VALUES
(11, 'breno', '123', 'Admin'),
(12, 'fernando', '123', 'Root'),
(14, 'vivi', '123', 'Comum'),
(19, '', '', 'Comum');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigo_cliente`);

--
-- Índices para tabela `conhe_pousada`
--
ALTER TABLE `conhe_pousada`
  ADD PRIMARY KEY (`cod_cp`);

--
-- Índices para tabela `meio_transp`
--
ALTER TABLE `meio_transp`
  ADD PRIMARY KEY (`cod_mt`);

--
-- Índices para tabela `mot_viagem`
--
ALTER TABLE `mot_viagem`
  ADD PRIMARY KEY (`cod_mv`);

--
-- Índices para tabela `quarto`
--
ALTER TABLE `quarto`
  ADD PRIMARY KEY (`num_quarto`);

--
-- Índices para tabela `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigo_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de tabela `conhe_pousada`
--
ALTER TABLE `conhe_pousada`
  MODIFY `cod_cp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `meio_transp`
--
ALTER TABLE `meio_transp`
  MODIFY `cod_mt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `mot_viagem`
--
ALTER TABLE `mot_viagem`
  MODIFY `cod_mv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `reserva`
--
ALTER TABLE `reserva`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
