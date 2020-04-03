-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema RFB_db
-- -----------------------------------------------------
drop database if exists `RFB_db`;
DROP SCHEMA IF EXISTS `RFB_db` ;
create database `RFB_db`;

DROP SCHEMA IF EXISTS `RFB_db` ;
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
  `stuenr` INT NOT NULL,
  `farve` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`stuenr`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RFB_db`.`Børn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RFB_db`.`Børn` (
  `id_barn` INT NOT NULL AUTO_INCREMENT,
  `cpr_nummer` VARCHAR(45) NOT NULL,
  `navn` VARCHAR(45) NOT NULL,
  `adresse` VARCHAR(45) NOT NULL,
  `Stue_stuenr` INT NOT NULL,
  PRIMARY KEY (`id_barn`, `Stue_stuenr`),
  INDEX `fk_Børn_Stue1_idx` (`Stue_stuenr` ASC) VISIBLE,
  CONSTRAINT `fk_Børn_Stue1`
    FOREIGN KEY (`Stue_stuenr`)
    REFERENCES `RFB_db`.`Stue` (`stuenr`)
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

insert into Stue value(1,"blå");
insert into Stue value(2,"grøn");
insert into Stue value(3,"gul");

insert into Børn value (default,"1707163465","Jens Jensen","Bakkevej",1);
insert into Børn value (default,"1808168753","Lars Hansen","Dalsvej 2",2);
insert into Børn value (default,"1909169875","Christian Petersen","Jordbærvej 3",3);
insert into Børn value (default,"1606162311","Ole Poulsen","Kirsebærvej 4",1);
insert into Børn value (default,"1505169643","Bo Frederiksen","Mandelvej 5",2);
insert into Børn value (default,"1404162311","Victor Albertsen","Melonvej 6",3);
insert into Børn value (default,"1303168777","Thor Larsen","Æblevej 7",1);
insert into Børn value (default,"1202165555","Villum Thorsen","Pærevej 8",2);

insert into Forældre value ("Lars Larsen",74327495,98734152,1);
insert into Forældre value ("Kurt Thorsen",45623091,35465718,2);
insert into Forældre value ("Hans Hansen",12659304,28374659,3);
insert into Forældre value ("Preben Pølsetud",28374651,36409514,4);
insert into Forældre value ("Poul Krebs",28475638,27364098,5);
insert into Forældre value ("Lotte Ludvig",59348712,28374651,6);
insert into Forældre value ("Lis Poulsen",26348576,23619999,7);
insert into Forældre value ("Beate Jensen",16253475,182736451,8);



