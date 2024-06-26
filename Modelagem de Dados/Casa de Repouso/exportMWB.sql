-- MySQL Script generated by MySQL Workbench
-- Thu May 30 23:50:08 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema casaderepouso
-- -----------------------------------------------------
-- Schema para uma casa de repouso com:
-- idosos
-- cuidadores
-- funcionarios
-- funcionarios terceirizados

-- -----------------------------------------------------
-- Schema casaderepouso
--
-- Schema para uma casa de repouso com:
-- idosos
-- cuidadores
-- funcionarios
-- funcionarios terceirizados
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `casaderepouso` ;
USE `casaderepouso` ;

-- -----------------------------------------------------
-- Table `casaderepouso`.`idosos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `casaderepouso`.`idosos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `casaderepouso`.`responsaveis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `casaderepouso`.`responsaveis` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `id_idosos` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_responsaveis_idosos_idx` (`id_idosos` ASC) VISIBLE,
  CONSTRAINT `fk_responsaveis_idosos`
    FOREIGN KEY (`id_idosos`)
    REFERENCES `casaderepouso`.`idosos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `casaderepouso`.`medicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `casaderepouso`.`medicos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `crm` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `casaderepouso`.`atendimentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `casaderepouso`.`atendimentos` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `data` DATE NOT NULL,
  `idosos_id` INT NOT NULL,
  `medicos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_atendimentos_idosos1_idx` (`idosos_id` ASC) VISIBLE,
  INDEX `fk_atendimentos_medicos1_idx` (`medicos_id` ASC) VISIBLE,
  CONSTRAINT `fk_atendimentos_idosos1`
    FOREIGN KEY (`idosos_id`)
    REFERENCES `casaderepouso`.`idosos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_atendimentos_medicos1`
    FOREIGN KEY (`medicos_id`)
    REFERENCES `casaderepouso`.`medicos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `casaderepouso`.`enfermeiros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `casaderepouso`.`enfermeiros` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `coren` VARCHAR(45) NOT NULL,
  `atendimentos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_enfermeiros_atendimentos1_idx` (`atendimentos_id` ASC) VISIBLE,
  CONSTRAINT `fk_enfermeiros_atendimentos1`
    FOREIGN KEY (`atendimentos_id`)
    REFERENCES `casaderepouso`.`atendimentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
