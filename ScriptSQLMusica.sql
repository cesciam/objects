-- MySQL Script generated by MySQL Workbench
-- Sun Nov 17 15:15:40 2019
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
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `imagen` VARCHAR(45) NOT NULL,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `contrasenna` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `edad` INT NULL DEFAULT NULL,
  `pais` VARCHAR(45) NULL DEFAULT NULL,
  `cedula` INT NULL DEFAULT NULL,
  `tipo` VARCHAR(45) NOT NULL,
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
  `usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`idlistareproducciones`, `usuario_idusuario`),
  INDEX `fk_listareproduccion_usuario_idx` (`usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_listareproduccion_usuario`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `BibliotecaMusical`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Table `BibliotecaMusical`.`compositor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`compositor` (
  `idcompositor` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `generos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcompositor`))
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
  `album_idalbum` INT NOT NULL,
  `compositor_idcompositor` INT NOT NULL,
  PRIMARY KEY (`idcancion`, `album_idalbum`, `compositor_idcompositor`),
  INDEX `fk_cancion_album1_idx` (`album_idalbum` ASC) VISIBLE,
  INDEX `fk_cancion_compositor1_idx` (`compositor_idcompositor` ASC) VISIBLE,
  CONSTRAINT `fk_cancion_album1`
    FOREIGN KEY (`album_idalbum`)
    REFERENCES `BibliotecaMusical`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cancion_compositor1`
    FOREIGN KEY (`compositor_idcompositor`)
    REFERENCES `BibliotecaMusical`.`compositor` (`idcompositor`)
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
  `fechaNacimiento` DATE NOT NULL,
  `fechaDefuncion` DATE NULL,
  `pais` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `album_idalbum` INT NOT NULL,
  `cancion_idcancion` INT NOT NULL,
  `cancion_album_idalbum` INT NOT NULL,
  PRIMARY KEY (`idartista`, `album_idalbum`, `cancion_idcancion`, `cancion_album_idalbum`),
  INDEX `fk_artista_album1_idx` (`album_idalbum` ASC) VISIBLE,
  INDEX `fk_artista_cancion1_idx` (`cancion_idcancion` ASC, `cancion_album_idalbum` ASC) VISIBLE,
  CONSTRAINT `fk_artista_album1`
    FOREIGN KEY (`album_idalbum`)
    REFERENCES `BibliotecaMusical`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_artista_cancion1`
    FOREIGN KEY (`cancion_idcancion` , `cancion_album_idalbum`)
    REFERENCES `BibliotecaMusical`.`cancion` (`idcancion` , `album_idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`listareproduccion_has_cancion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`listareproduccion_has_cancion` (
  `listareproduccion_idlistareproducciones` INT NOT NULL,
  `listareproduccion_usuario_idusuario` INT NOT NULL,
  `cancion_idcancion` INT NOT NULL,
  PRIMARY KEY (`listareproduccion_idlistareproducciones`, `listareproduccion_usuario_idusuario`, `cancion_idcancion`),
  INDEX `fk_listareproduccion_has_cancion_cancion1_idx` (`cancion_idcancion` ASC) VISIBLE,
  INDEX `fk_listareproduccion_has_cancion_listareproduccion1_idx` (`listareproduccion_idlistareproducciones` ASC, `listareproduccion_usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_listareproduccion_has_cancion_listareproduccion1`
    FOREIGN KEY (`listareproduccion_idlistareproducciones` , `listareproduccion_usuario_idusuario`)
    REFERENCES `BibliotecaMusical`.`listareproduccion` (`idlistareproducciones` , `usuario_idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_listareproduccion_has_cancion_cancion1`
    FOREIGN KEY (`cancion_idcancion`)
    REFERENCES `BibliotecaMusical`.`cancion` (`idcancion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibliotecaMusical`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibliotecaMusical`.`genero` (
  `idgenero` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `cancion_idcancion` INT NOT NULL,
  `cancion_album_idalbum` INT NOT NULL,
  `cancion_compositor_idcompositor` INT NOT NULL,
  `artista_idartista` INT NOT NULL,
  `artista_album_idalbum` INT NOT NULL,
  `artista_cancion_idcancion` INT NOT NULL,
  `artista_cancion_album_idalbum` INT NOT NULL,
  PRIMARY KEY (`idgenero`, `cancion_idcancion`, `cancion_album_idalbum`, `cancion_compositor_idcompositor`, `artista_idartista`, `artista_album_idalbum`, `artista_cancion_idcancion`, `artista_cancion_album_idalbum`),
  INDEX `fk_genero_cancion1_idx` (`cancion_idcancion` ASC, `cancion_album_idalbum` ASC, `cancion_compositor_idcompositor` ASC) VISIBLE,
  INDEX `fk_genero_artista1_idx` (`artista_idartista` ASC, `artista_album_idalbum` ASC, `artista_cancion_idcancion` ASC, `artista_cancion_album_idalbum` ASC) VISIBLE,
  CONSTRAINT `fk_genero_cancion1`
    FOREIGN KEY (`cancion_idcancion` , `cancion_album_idalbum` , `cancion_compositor_idcompositor`)
    REFERENCES `BibliotecaMusical`.`cancion` (`idcancion` , `album_idalbum` , `compositor_idcompositor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_genero_artista1`
    FOREIGN KEY (`artista_idartista` , `artista_album_idalbum` , `artista_cancion_idcancion` , `artista_cancion_album_idalbum`)
    REFERENCES `BibliotecaMusical`.`artista` (`idartista` , `album_idalbum` , `cancion_idcancion` , `cancion_album_idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
