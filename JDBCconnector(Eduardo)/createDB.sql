-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`lista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`lista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(10) NOT NULL,
  `limite` INT UNSIGNED NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`carta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`carta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `colecao` VARCHAR(45) NOT NULL,
  `energia` VARCHAR(45) NULL,
  `ps` INT UNSIGNED NULL,
  `descricao` VARCHAR(200) NULL,
  `recuo` INT UNSIGNED NULL,
  `fraqueza` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `colecao_UNIQUE` (`colecao` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cartas_lista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cartas_lista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_lista` INT NOT NULL,
  `id_carta` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
