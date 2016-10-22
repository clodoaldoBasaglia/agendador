-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `agendador` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agendador` DEFAULT CHARACTER SET utf8 ;
USE `agendador` ;

-- -----------------------------------------------------
-- Table `agendador`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendador`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nome_usuario` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(15) NOT NULL,
  `dataCriacao` DATETIME NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agendador`.`log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendador`.`log` (
  `idlog` INT NOT NULL,
  `dataHorario` DATETIME NULL,
  `descricao` VARCHAR(45) NULL,
  `idusuario` INT NOT NULL,
  PRIMARY KEY (`idlog`, `idusuario`),
  INDEX `fk_log_usuario_idx` (`idusuario` ASC),
  CONSTRAINT `fk_log_usuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `agendador`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agendador`.`TipodaTarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendador`.`TipodaTarefa` (
  `idTipodaTarefa` INT NOT NULL,
  `descricao` VARCHAR(50) NULL,
  PRIMARY KEY (`idTipodaTarefa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agendador`.`Tarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendador`.`Tarefa` (
  `idTarefa` INT NOT NULL,
  `Descricao` VARCHAR(350) NULL,
  `dia` DATE NULL,
  `horario` TIME NULL,
  `local` VARCHAR(60) NULL,
  `isOpen` INT(10) NULL,
  `idTipodaTarefa` INT NOT NULL,
  PRIMARY KEY (`idTarefa`, `idTipodaTarefa`),
  INDEX `fk_Tarefa_TipodaTarefa1_idx` (`idTipodaTarefa` ASC),
  CONSTRAINT `fk_Tarefa_TipodaTarefa1`
    FOREIGN KEY (`idTipodaTarefa`)
    REFERENCES `agendador`.`TipodaTarefa` (`idTipodaTarefa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agendador`.`Tarefa_has_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendador`.`Tarefa_has_usuario` (
  `Tarefa_idTarefa` INT NOT NULL,
  `usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`Tarefa_idTarefa`, `usuario_idusuario`),
  INDEX `fk_Tarefa_has_usuario_usuario1_idx` (`usuario_idusuario` ASC),
  INDEX `fk_Tarefa_has_usuario_Tarefa1_idx` (`Tarefa_idTarefa` ASC),
  CONSTRAINT `fk_Tarefa_has_usuario_Tarefa1`
    FOREIGN KEY (`Tarefa_idTarefa`)
    REFERENCES `agendador`.`Tarefa` (`idTarefa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tarefa_has_usuario_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `agendador`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
