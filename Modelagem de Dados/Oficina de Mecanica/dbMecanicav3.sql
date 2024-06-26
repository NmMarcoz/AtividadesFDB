-- MySQL Script generated by MySQL Workbench
-- Thu May 30 22:44:23 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbMecanica
-- -----------------------------------------------------
-- Schema para o problema proposto na atividade de MDE
-- Banco de dados para uma Oficina de mecânica, cadastrando veículos, peças e funcionarios.

-- -----------------------------------------------------
-- Schema dbMecanica
--
-- Schema para o problema proposto na atividade de MDE
-- Banco de dados para uma Oficina de mecânica, cadastrando veículos, peças e funcionarios.
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbMecanica` ;
USE `dbMecanica` ;

-- -----------------------------------------------------
-- Table `dbMecanica`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`clientes` (
  `idClientes` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(45) NOT NULL,
  `emailCliente` VARCHAR(45) NULL,
  `vip` TINYINT NOT NULL,
  PRIMARY KEY (`idClientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`veiculo` (
  `idVeiculo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `clientes_idClientes` INT NOT NULL,
  PRIMARY KEY (`idVeiculo`),
  INDEX `fk_veiculo_clientes1_idx` (`clientes_idClientes` ASC) VISIBLE,
  CONSTRAINT `fk_veiculo_clientes1`
    FOREIGN KEY (`clientes_idClientes`)
    REFERENCES `dbMecanica`.`clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`servicos` (
  `idServico` INT NOT NULL AUTO_INCREMENT,
  `nomeServico` VARCHAR(45) NOT NULL,
  `descServico` LONGTEXT NULL,
  `duracao` FLOAT NOT NULL,
  `dataServico` DATE NOT NULL,
  `preco` FLOAT NOT NULL,
  `idVeiculo` INT NOT NULL,
  PRIMARY KEY (`idServico`),
  INDEX `fk_servicos_carros1_idx` (`idVeiculo` ASC) VISIBLE,
  CONSTRAINT `fk_servicos_carros1`
    FOREIGN KEY (`idVeiculo`)
    REFERENCES `dbMecanica`.`veiculo` (`idVeiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`pecas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`pecas` (
  `idPeca` INT NOT NULL AUTO_INCREMENT,
  `nomePeca` VARCHAR(45) NOT NULL,
  `tipoPeca` VARCHAR(45) NOT NULL,
  `precoPeca` FLOAT NOT NULL,
  `servicos_idServico` INT NOT NULL,
  PRIMARY KEY (`idPeca`),
  INDEX `fk_pecas_servicos1_idx` (`servicos_idServico` ASC) VISIBLE,
  CONSTRAINT `fk_pecas_servicos1`
    FOREIGN KEY (`servicos_idServico`)
    REFERENCES `dbMecanica`.`servicos` (`idServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`funcionarios` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` VARCHAR(45) NOT NULL,
  `emailFuncionario` VARCHAR(45) NOT NULL,
  `servicos_idServico` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  INDEX `fk_funcionarios_servicos1_idx` (`servicos_idServico` ASC) VISIBLE,
  CONSTRAINT `fk_funcionarios_servicos1`
    FOREIGN KEY (`servicos_idServico`)
    REFERENCES `dbMecanica`.`servicos` (`idServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`ordemServico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`ordemServico` (
  `idordemServico` INT NOT NULL AUTO_INCREMENT,
  `idServico` INT NOT NULL,
  PRIMARY KEY (`idordemServico`),
  INDEX `fk_ordemServico_servicos1_idx` (`idServico` ASC) VISIBLE,
  CONSTRAINT `fk_ordemServico_servicos1`
    FOREIGN KEY (`idServico`)
    REFERENCES `dbMecanica`.`servicos` (`idServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
