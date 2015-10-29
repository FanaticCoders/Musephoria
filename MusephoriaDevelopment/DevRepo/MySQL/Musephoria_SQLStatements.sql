-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema musephoria
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `musephoria` ;

-- -----------------------------------------------------
-- Schema musephoria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `musephoria` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `musephoria` ;

-- -----------------------------------------------------
-- Table `musephoria`.`Cd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Cd` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Cd` (
  `CdId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `Name` NVARCHAR(25) NOT NULL COMMENT '',
  `Description` NVARCHAR(300) NULL COMMENT '',
  `Price` FLOAT NOT NULL COMMENT '',
  `Quantity` INT NULL COMMENT '',
  `Genre` ENUM('Rock', 'Blues', 'Country', 'Pop', 'Electronic') NOT NULL COMMENT '',
  `Artist` NVARCHAR(25) NOT NULL COMMENT '',
  `Year` YEAR NOT NULL COMMENT '',
  `Rating` ENUM('Poor', 'Average', 'Good', 'Very Good', 'Excellent') NULL COMMENT '',
  `Review` NVARCHAR(10000) NULL COMMENT '',
  `Language` NVARCHAR(25) NULL COMMENT '',
  `NumberOfTrack` INT NOT NULL COMMENT '',
  `AlbumArt` MEDIUMBLOB NULL COMMENT '',
  `IsCdActive` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`CdId`)  COMMENT '') AUTO_INCREMENT = 1001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Customer` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Customer` (
  `CustomerId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `UserName` NVARCHAR(45) NOT NULL COMMENT '',
  `Password` NVARCHAR(25) NOT NULL COMMENT '',
  `CustomerName` NVARCHAR(45) NOT NULL COMMENT '',
  `DateOfBirth` DATE NOT NULL COMMENT '',
  `Sex` ENUM('Male', 'Female') NOT NULL COMMENT '',
  `Address` NVARCHAR(45) NOT NULL COMMENT '',
  `City` NVARCHAR(45) NOT NULL COMMENT '',
  `Province` NVARCHAR(45) NOT NULL COMMENT '',
  `Country` NVARCHAR(45) NOT NULL COMMENT '',
  `ZipCode` NVARCHAR(7) NOT NULL COMMENT '',
  `Email` NVARCHAR(45) NOT NULL COMMENT '',
  `Phone` NVARCHAR(45) NOT NULL COMMENT '',
  `DefaultPaymentInfo` ENUM('Credit', 'Debit') NOT NULL COMMENT '',
  `TimeStamp` DATETIME NOT NULL COMMENT '',
  `IsCustomerActive` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`CustomerId`)  COMMENT '') AUTO_INCREMENT = 2001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`PurchaseOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`PurchaseOrder` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`PurchaseOrder` (
  `PurchaseOrderId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CustomerId` INT UNSIGNED NOT NULL COMMENT '',
  `TotalQuantity` INT NOT NULL COMMENT '',
  `TotalPrice` FLOAT NOT NULL COMMENT '',
  `Taxes` FLOAT NOT NULL COMMENT '',
  `PurchaseOrderStatus` ENUM('Ordered', 'Approved', 'Rejected') NOT NULL COMMENT '',
  PRIMARY KEY (`PurchaseOrderId`)  COMMENT '',
  INDEX `PurchaseOrderCustomer_idx` (`CustomerId` ASC)  COMMENT '',
  CONSTRAINT `PurchaseOrderCustomer`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `musephoria`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT = 3001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`Shipping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Shipping` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Shipping` (
  `ShippingId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `PurchaseOrderId` INT UNSIGNED NOT NULL COMMENT '',
  `Address` NVARCHAR(45) NOT NULL COMMENT '',
  `City` NVARCHAR(45) NOT NULL COMMENT '',
  `Province` NVARCHAR(45) NOT NULL COMMENT '',
  `Country` NVARCHAR(45) NOT NULL COMMENT '',
  `ZipCode` NVARCHAR(7) NOT NULL COMMENT '',
  `Phone` NVARCHAR(45) NOT NULL COMMENT '',
  `IsShippingActive` TINYINT(1) NULL COMMENT '',
  PRIMARY KEY (`ShippingId`)  COMMENT '',
  INDEX `ShippingPurchaseOrder_idx` (`PurchaseOrderId` ASC)  COMMENT '',
  CONSTRAINT `ShippingPurchaseOrder`
    FOREIGN KEY (`PurchaseOrderId`)
    REFERENCES `musephoria`.`PurchaseOrder` (`PurchaseOrderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT = 4001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`PurchaseOrderItem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`PurchaseOrderItem` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`PurchaseOrderItem` (
  `PurchaseOrderItemId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `PurchaseOrderId` INT UNSIGNED NOT NULL COMMENT '',
  `CdId` INT UNSIGNED NOT NULL COMMENT '',
  `PurchaseOrderItemName` NVARCHAR(45) NOT NULL COMMENT '',
  `BaseAmount` FLOAT NOT NULL COMMENT '',
  INDEX `CdId_idx` (`CdId` ASC)  COMMENT '',
  PRIMARY KEY (`PurchaseOrderItemId`)  COMMENT '',
  INDEX `PurchaseOrderItemPurchaseOrder_idx` (`PurchaseOrderId` ASC)  COMMENT '',
  CONSTRAINT `PurchaseOrderItemCd`
    FOREIGN KEY (`CdId`)
    REFERENCES `musephoria`.`Cd` (`CdId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PurchaseOrderItemPurchaseOrder`
    FOREIGN KEY (`PurchaseOrderId`)
    REFERENCES `musephoria`.`PurchaseOrder` (`PurchaseOrderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT = 5001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`PaymentInfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`PaymentInfo` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`PaymentInfo` (
  `PaymentInfoId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CustomerId` INT UNSIGNED NOT NULL COMMENT '',
  `CardNumber` INT UNSIGNED NOT NULL COMMENT '',
  `PaymentInfoStatus` ENUM('Approved', 'Rejected') NOT NULL COMMENT '',
  `TimeStamp` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`PaymentInfoId`)  COMMENT '',
  INDEX `PaymentCustomer_idx` (`CustomerId` ASC)  COMMENT '',
  CONSTRAINT `PaymentCustomer`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `musephoria`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT = 6001,
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
