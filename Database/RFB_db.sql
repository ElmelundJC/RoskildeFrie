-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema RFB_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `RFB_db` ;

-- -----------------------------------------------------
-- Schema RFB_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RFB_db` DEFAULT CHARACTER SET utf8 ;
USE `RFB_db` ;

-- -----------------------------------------------------
-- Table `RFB_db`.`Stue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RFB_db`.`Stue` (
  `stuenr.` INT NOT NULL,
  `farve` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`stuenr.`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RFB_db`.`Børn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RFB_db`.`Børn` (
  `id_barn` INT NOT NULL AUTO_INCREMENT,
  `cpr_nummer` VARCHAR(45) NOT NULL,
  `navn` VARCHAR(45) NOT NULL,
  `adresse` VARCHAR(45) NOT NULL,
  `Stue_stuenr.` INT NOT NULL,
  PRIMARY KEY (`id_barn`, `Stue_stuenr.`),
  INDEX `fk_Børn_Stue1_idx` (`Stue_stuenr.` ASC) VISIBLE,
  CONSTRAINT `fk_Børn_Stue1`
    FOREIGN KEY (`Stue_stuenr.`)
    REFERENCES `RFB_db`.`Stue` (`stuenr.`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RFB_db`.`Forældre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RFB_db`.`Forældre` (
  `navn` VARCHAR(45) NOT NULL,
  `mobilnummmer` INT NOT NULL,
  `arbejdsnummer` INT NULL,
  `Børn_id_barn` INT NOT NULL,
  UNIQUE INDEX `mobilnummmer_UNIQUE` (`mobilnummmer` ASC) VISIBLE,
  UNIQUE INDEX `arbejdsnummer_UNIQUE` (`arbejdsnummer` ASC) VISIBLE,
  PRIMARY KEY (`Børn_id_barn`),
  CONSTRAINT `fk_Forældre_Børn`
    FOREIGN KEY (`Børn_id_barn`)
    REFERENCES `RFB_db`.`Børn` (`id_barn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
