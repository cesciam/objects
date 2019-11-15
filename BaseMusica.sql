-- MySQL Script generated by MySQL Workbench
-- Fri Nov 15 17:37:26 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BibliotecaMusical
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BibliotecaMusical
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BibliotecaMusical` DEFAULT CHARACTER SET utf8 ;
USE `BibliotecaMusical` ;

-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `imagen` VARCHAR(45) NOT NULL,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `contrasenna` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `edad` INT NULL,
  `pais` VARCHAR(45) NULL,
  `cedula` INT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`listareproduccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`listareproduccion` (
  `idlistareproducciones` INT NOT NULL AUTO_INCREMENT,
  `canciones` VARCHAR(45) NOT NULL,
  `fechaCreacion` DATE NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `calificacion` DOUBLE NOT NULL,
  PRIMARY KEY (`idlistareproducciones`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`cancion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`cancion` (
  `idcancion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `artista` VARCHAR(45) NOT NULL,
  `fechaLanzamiento` DATE NOT NULL,
  `album` VARCHAR(45) NOT NULL,
  `calificacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcancion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`album` (
  `idalbum` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaLanzamiento` DATE NOT NULL,
  `artistas` VARCHAR(45) NOT NULL,
  `imagen` VARCHAR(45) NOT NULL,
  `canciones` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idalbum`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`listareproduccion_has_cancion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`listareproduccion_has_cancion` (
  `listareproduccion_idlistareproducciones` INT NOT NULL,
  `cancion_idcancion` INT NOT NULL,
  `album_idalbum` INT NULL,
  PRIMARY KEY (`listareproduccion_idlistareproducciones`, `cancion_idcancion`, `album_idalbum`),
  INDEX `fk_listareproduccion_has_cancion_cancion1_idx` (`cancion_idcancion` ASC) VISIBLE,
  INDEX `fk_listareproduccion_has_cancion_listareproduccion1_idx` (`listareproduccion_idlistareproducciones` ASC) VISIBLE,
  INDEX `fk_listareproduccion_has_cancion_album1_idx` (`album_idalbum` ASC) VISIBLE,
  CONSTRAINT `fk_listareproduccion_has_cancion_listareproduccion1`
    FOREIGN KEY (`listareproduccion_idlistareproducciones`)
    REFERENCES `BibliotecaMusical`.`listareproduccion` (`idlistareproducciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_listareproduccion_has_cancion_cancion1`
    FOREIGN KEY (`cancion_idcancion`)
    REFERENCES `BibliotecaMusical`.`cancion` (`idcancion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_listareproduccion_has_cancion_album1`
    FOREIGN KEY (`album_idalbum`)
    REFERENCES `BibliotecaMusical`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`usuario_has_listareproduccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`usuario_has_listareproduccion` (
  `usuario_idusuario` INT NOT NULL,
  `listareproduccion_idlistareproducciones` INT NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `listareproduccion_idlistareproducciones`),
  INDEX `fk_usuario_has_listareproduccion_listareproduccion1_idx` (`listareproduccion_idlistareproducciones` ASC) VISIBLE,
  INDEX `fk_usuario_has_listareproduccion_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_has_listareproduccion_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `BibliotecaMusical`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_listareproduccion_listareproduccion1`
    FOREIGN KEY (`listareproduccion_idlistareproducciones`)
    REFERENCES `BibliotecaMusical`.`listareproduccion` (`idlistareproducciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`album_has_cancion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`album_has_cancion` (
  `album_idalbum` INT NOT NULL,
  `cancion_idcancion` INT NOT NULL,
  PRIMARY KEY (`album_idalbum`, `cancion_idcancion`),
  INDEX `fk_album_has_cancion_cancion1_idx` (`cancion_idcancion` ASC) VISIBLE,
  INDEX `fk_album_has_cancion_album1_idx` (`album_idalbum` ASC) VISIBLE,
  CONSTRAINT `fk_album_has_cancion_album1`
    FOREIGN KEY (`album_idalbum`)
    REFERENCES `BibliotecaMusical`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_album_has_cancion_cancion1`
    FOREIGN KEY (`cancion_idcancion`)
    REFERENCES `BibliotecaMusical`.`cancion` (`idcancion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`artista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`artista` (
  `idartista` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `nombreArtistico` VARCHAR(45) NOT NULL,
  `artistacol` VARCHAR(45) NULL,
  PRIMARY KEY (`idartista`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;