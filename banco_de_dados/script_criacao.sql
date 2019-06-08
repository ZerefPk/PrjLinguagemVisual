-- MySQL Script generated by MySQL Workbench
-- Fri May 31 19:53:04 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_cinema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_cinema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_cinema` DEFAULT CHARACTER SET utf8 ;
USE `db_cinema` ;

-- -----------------------------------------------------
-- Table `db_cinema`.`tb_user_auth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cinema`.`tb_user_auth` (
  `id_user_auth` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_user_auth`),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cinema`.`tb_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cinema`.`tb_categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `nome_categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE INDEX `nome_categoria_UNIQUE` (`nome_categoria` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cinema`.`tb_diretor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cinema`.`tb_diretor` (
  `id_diretor` INT NOT NULL AUTO_INCREMENT,
  `nom_diretor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_diretor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cinema`.`tb_filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cinema`.`tb_filme` (
  `id_filme` INT NOT NULL AUTO_INCREMENT,
  `titulo_filmes` VARCHAR(45) NOT NULL,
  `ano_lancamento` YEAR NOT NULL,
  `cod_diretor` INT NOT NULL,
  `cod_categoria` INT NOT NULL,
  PRIMARY KEY (`id_filme`),
  INDEX `fk_catj_idx` (`cod_categoria` ASC) ,
  INDEX `fk_dire_idx` (`cod_diretor` ASC) ,
  CONSTRAINT `fk_catj`
    FOREIGN KEY (`cod_categoria`)
    REFERENCES `db_cinema`.`tb_categoria` (`id_categoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_dire`
    FOREIGN KEY (`cod_diretor`)
    REFERENCES `db_cinema`.`tb_diretor` (`id_diretor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cinema`.`tb_sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cinema`.`tb_sala` (
  `id_sala` INT NOT NULL AUTO_INCREMENT,
  `numero_sala` VARCHAR(45) NOT NULL,
  `tipo_sala` ENUM('VIP', '3D', '2D') NOT NULL DEFAULT '2D',
  PRIMARY KEY (`id_sala`),
  UNIQUE INDEX `numero_sala_UNIQUE` (`numero_sala` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cinema`.`tb_sessao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cinema`.`tb_sessao` (
  `id_sessao` INT NOT NULL AUTO_INCREMENT,
  `sala_id_sala` INT NOT NULL,
  `filme_id_filme` INT NOT NULL,
  `data_sessao` DATE NOT NULL,
  `hora_sessao` TIME NOT NULL,
  PRIMARY KEY (`id_sessao`),
  INDEX `fk_filme_idx` (`filme_id_filme` ASC),
  INDEX `fk_sala_idx` (`sala_id_sala` ASC) ,
  CONSTRAINT `fk_filme`
    FOREIGN KEY (`filme_id_filme`)
    REFERENCES `db_cinema`.`tb_filme` (`id_filme`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_sala`
    FOREIGN KEY (`sala_id_sala`)
    REFERENCES `db_cinema`.`tb_sala` (`id_sala`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
