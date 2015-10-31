-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema musephoria
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `musephoria` ;

-- -----------------------------------------------------
-- Schema musephoria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `musephoria` DEFAULT CHARACTER SET utf8 ;
USE `musephoria` ;

-- -----------------------------------------------------
-- Table `musephoria`.`cd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`cd` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`cd` (
  `CdId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `Name` VARCHAR(25) NOT NULL COMMENT '',
  `Description` VARCHAR(300) NULL DEFAULT NULL COMMENT '',
  `Price` FLOAT NOT NULL COMMENT '',
  `Quantity` INT(11) NULL DEFAULT NULL COMMENT '',
  `Genre` ENUM('Rock','Blues','Country','Pop','Electronic') NOT NULL COMMENT '',
  `Artist` VARCHAR(25) NOT NULL COMMENT '',
  `Year` YEAR NOT NULL COMMENT '',
  `Rating` ENUM('Poor','Average','Good','Very Good','Excellent') NULL DEFAULT NULL COMMENT '',
  `Review` VARCHAR(10000) NULL DEFAULT NULL COMMENT '',
  `Language` VARCHAR(25) NULL DEFAULT NULL COMMENT '',
  `NumberOfTrack` INT(11) NOT NULL COMMENT '',
  `AlbumArt` MEDIUMBLOB NULL DEFAULT NULL COMMENT '',
  `IsCdActive` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`CdId`)  COMMENT '') AUTO_INCREMENT = 1001,
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `musephoria`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`customer` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`customer` (
  `CustomerId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `UserName` VARCHAR(45) NOT NULL COMMENT '',
  `Password` VARCHAR(25) NOT NULL COMMENT '',
  `CustomerName` VARCHAR(45) NOT NULL COMMENT '',
  `DateOfBirth` DATE NOT NULL COMMENT '',
  `Sex` ENUM('Male','Female') NOT NULL COMMENT '',
  `Address` VARCHAR(45) NOT NULL COMMENT '',
  `City` VARCHAR(45) NOT NULL COMMENT '',
  `Province` VARCHAR(45) NOT NULL COMMENT '',
  `Country` VARCHAR(45) NOT NULL COMMENT '',
  `ZipCode` VARCHAR(7) NOT NULL COMMENT '',
  `Email` VARCHAR(45) NOT NULL COMMENT '',
  `Phone` VARCHAR(45) NOT NULL COMMENT '',
  `DefaultPaymentInfo` ENUM('Credit','Debit') NOT NULL COMMENT '',
  `TimeStamp` DATETIME NOT NULL COMMENT '',
  `IsCustomerActive` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`CustomerId`)  COMMENT '') AUTO_INCREMENT = 2001,
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `musephoria`.`purchaseorder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`purchaseorder` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`purchaseorder` (
  `PurchaseOrderId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CustomerId` INT(10) UNSIGNED NOT NULL COMMENT '',
  `TotalQuantity` INT(11) NOT NULL COMMENT '',
  `TotalPrice` FLOAT NOT NULL COMMENT '',
  `Taxes` FLOAT NOT NULL COMMENT '',
  `PurchaseOrderStatus` ENUM('Ordered','Approved','Rejected') NOT NULL COMMENT '',
  PRIMARY KEY (`PurchaseOrderId`)  COMMENT '',
  INDEX `PurchaseOrderCustomer_idx` (`CustomerId` ASC)  COMMENT '',
  CONSTRAINT `PurchaseOrderCustomer`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `musephoria`.`customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT = 3001,
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `musephoria`.`purchaseorderitem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`purchaseorderitem` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`purchaseorderitem` (
  `PurchaseOrderItemId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `PurchaseOrderId` INT(10) UNSIGNED NOT NULL COMMENT '',
  `CdId` INT(10) UNSIGNED NOT NULL COMMENT '',
  PRIMARY KEY (`PurchaseOrderItemId`)  COMMENT '',
  INDEX `CdId_idx` (`CdId` ASC)  COMMENT '',
  INDEX `PurchaseOrderItemPurchaseOrder_idx` (`PurchaseOrderId` ASC)  COMMENT '',
  CONSTRAINT `PurchaseOrderItemCd`
    FOREIGN KEY (`CdId`)
    REFERENCES `musephoria`.`cd` (`CdId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PurchaseOrderItemPurchaseOrder`
    FOREIGN KEY (`PurchaseOrderId`)
    REFERENCES `musephoria`.`purchaseorder` (`PurchaseOrderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT = 4001,
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `musephoria`.`shipping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`shipping` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`shipping` (
  `ShippingId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `PurchaseOrderId` INT(10) UNSIGNED NOT NULL COMMENT '',
  `Address` VARCHAR(45) NOT NULL COMMENT '',
  `City` VARCHAR(45) NOT NULL COMMENT '',
  `Province` VARCHAR(45) NOT NULL COMMENT '',
  `Country` VARCHAR(45) NOT NULL COMMENT '',
  `ZipCode` VARCHAR(7) NOT NULL COMMENT '',
  `Phone` VARCHAR(45) NOT NULL COMMENT '',
  `IsShippingActive` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`ShippingId`)  COMMENT '',
  INDEX `ShippingPurchaseOrder_idx` (`PurchaseOrderId` ASC)  COMMENT '',
  CONSTRAINT `ShippingPurchaseOrder`
    FOREIGN KEY (`PurchaseOrderId`)
    REFERENCES `musephoria`.`purchaseorder` (`PurchaseOrderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT = 5001,
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
