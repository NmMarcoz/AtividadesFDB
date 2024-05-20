-- MySQL Script generated by MySQL Workbench
-- Sat May 18 16:06:34 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbMecanica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbMecanica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbMecanica` DEFAULT CHARACTER SET utf8 ;
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
-- Table `dbMecanica`.`carros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`carros` (
  `idCarro` INT NOT NULL AUTO_INCREMENT,
  `nomeCarro` VARCHAR(45) NOT NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`idCarro`),
  INDEX `fk_carros_clientes_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_carros_clientes`
    FOREIGN KEY (`idCliente`)
    REFERENCES `dbMecanica`.`clientes` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`peças`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`peças` (
  `idPeças` INT NOT NULL AUTO_INCREMENT,
  `nomePeça` VARCHAR(45) NOT NULL,
  `tipoPeça` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPeças`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`funcionarios` (
  `idfuncionario` INT NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` VARCHAR(45) NOT NULL,
  `emailFuncionario` VARCHAR(45) NULL,
  PRIMARY KEY (`idfuncionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`servicos` (
  `idServico` INT NOT NULL AUTO_INCREMENT,
  `nomeServico` VARCHAR(45) NOT NULL,
  `descServico` LONGTEXT NULL,
  `duraçao` FLOAT NOT NULL,
  `dataServico` DATE NOT NULL,
  `idFuncionario` INT NOT NULL,
  `idCarro` INT NOT NULL,
  PRIMARY KEY (`idServico`),
  INDEX `fk_servicos_funcionarios1_idx` (`idFuncionario` ASC) VISIBLE,
  INDEX `fk_servicos_carros1_idx` (`idCarro` ASC) VISIBLE,
  CONSTRAINT `fk_servicos_funcionarios1`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `dbMecanica`.`funcionarios` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicos_carros1`
    FOREIGN KEY (`idCarro`)
    REFERENCES `dbMecanica`.`carros` (`idCarro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbMecanica`.`pecasPorServico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbMecanica`.`pecasPorServico` (
  `idPeças` INT NOT NULL,
  `idServico` INT NOT NULL,
  PRIMARY KEY (`idPeças`, `idServico`),
  INDEX `fk_peças_has_servicos_peças1_idx` (`idPeças` ASC) VISIBLE,
  INDEX `idServico_idx` (`idServico` ASC) VISIBLE,
  CONSTRAINT `idPeca`
    FOREIGN KEY (`idPeças`)
    REFERENCES `dbMecanica`.`peças` (`idPeças`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idServico`
    FOREIGN KEY (`idServico`)
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