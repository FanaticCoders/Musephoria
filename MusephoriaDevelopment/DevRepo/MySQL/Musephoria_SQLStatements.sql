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
  PRIMARY KEY (`CdId`)  COMMENT '') AUTO_INCREMENT=1001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`Track`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Track` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Track` (
  `TrackId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CdId` INT UNSIGNED NOT NULL COMMENT '',
  `Description` NVARCHAR(300) NULL COMMENT '',
  `Artist` NVARCHAR(45) NOT NULL COMMENT '',
  `Duration` NVARCHAR(25) NOT NULL COMMENT '',
  PRIMARY KEY (`TrackId`)  COMMENT '',
  INDEX `TrackCd_idx` (`CdId` ASC)  COMMENT '',
  CONSTRAINT `TrackCd`
    FOREIGN KEY (`CdId`)
    REFERENCES `musephoria`.`Cd` (`CdId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=2001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Customer` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Customer` (
  `CustomerId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `UserName` NVARCHAR(45) NOT NULL COMMENT '',
  `Password` NVARCHAR(25) NOT NULL COMMENT '',
  `Sex` ENUM('Male', 'Female') NOT NULL COMMENT '',
  `DateOfBirth` DATE NOT NULL COMMENT '',
  `DefaultPaymentInfo` ENUM('Credit', 'Debit') NOT NULL COMMENT '',
  `IsCustomerActive` TINYINT(1) NOT NULL COMMENT '',
  `TimeStamp` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`CustomerId`)  COMMENT '') AUTO_INCREMENT=3001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Order` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Order` (
  `OrderId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CustomerId` INT UNSIGNED NOT NULL COMMENT '',
  `BaseAmount` FLOAT NULL COMMENT '',
  `Tax` FLOAT NULL COMMENT '',
  `TotalAmount` FLOAT UNSIGNED NOT NULL COMMENT '',
  `TimeStamp` DATETIME NOT NULL COMMENT '',
  `IsOrderActive` TINYINT(1) NULL COMMENT '',
  PRIMARY KEY (`OrderId`)  COMMENT '',
  INDEX `OrderCustomer_idx` (`CustomerId` ASC)  COMMENT '',
  CONSTRAINT `OrderCustomer`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `musephoria`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=4001,
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `musephoria`.`CustomerDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`CustomerDetail` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`CustomerDetail` (
  `CustomerDetailId` INT UNSIGNED NOT NULL COMMENT '',
  `CustomerId` INT UNSIGNED NOT NULL COMMENT '',
  `CustomerName` VARCHAR(45) NOT NULL COMMENT '',
  `Address` NVARCHAR(45) NOT NULL COMMENT '',
  `City` NVARCHAR(25) NOT NULL COMMENT '',
  `Province` NVARCHAR(25) NOT NULL COMMENT '',
  `Country` NVARCHAR(25) NOT NULL COMMENT '',
  `ZipCode` NVARCHAR(6) NOT NULL COMMENT '',
  `Email` NVARCHAR(25) NOT NULL COMMENT '',
  `Phone` NVARCHAR(10) NOT NULL COMMENT '',
  `IsShipppingAddress` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`CustomerDetailId`)  COMMENT '',
  CONSTRAINT `CustomerDetailCustomer`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `musephoria`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=5001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`Cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Cart` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Cart` (
  `CartId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CustomerId` INT UNSIGNED NOT NULL COMMENT '',
  `BaseAmount` FLOAT NOT NULL COMMENT '',
  `Tax` FLOAT NOT NULL COMMENT '',
  `TotalAmount` FLOAT NOT NULL COMMENT '',
  `IsCartActive` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`CartId`)  COMMENT '',
  INDEX `CustomerId_idx` (`CustomerId` ASC)  COMMENT '',
  CONSTRAINT `CustomerCartId`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `musephoria`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=6001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`CartItem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`CartItem` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`CartItem` (
  `CartItemId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CartId` INT UNSIGNED NOT NULL COMMENT '',
  `CdId` INT UNSIGNED NOT NULL COMMENT '',
  `CardItemName` NVARCHAR(45) NOT NULL COMMENT '',
  `Quantity` INT UNSIGNED NOT NULL COMMENT '',
  `BaseAmount` FLOAT UNSIGNED NOT NULL COMMENT '',
  PRIMARY KEY (`CartItemId`)  COMMENT '',
  INDEX `CdId_idx` (`CdId` ASC)  COMMENT '',
  CONSTRAINT `CartItemCart`
    FOREIGN KEY (`CartId`)
    REFERENCES `musephoria`.`Cart` (`CartId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CartItemCd`
    FOREIGN KEY (`CdId`)
    REFERENCES `musephoria`.`Cd` (`CdId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=7001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`Shipping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Shipping` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Shipping` (
  `ShippingId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `OrderId` INT UNSIGNED NOT NULL COMMENT '',
  `Address` NVARCHAR(45) NOT NULL COMMENT '',
  `Status` ENUM('Ordered', 'Processed', 'InTransit', 'Delivered', 'Cancelled') NOT NULL COMMENT '',
  `IsShippingActive` TINYINT(1) NULL COMMENT '',
  PRIMARY KEY (`ShippingId`)  COMMENT '',
  CONSTRAINT `ShippingOrder`
    FOREIGN KEY (`OrderId`)
    REFERENCES `musephoria`.`Order` (`OrderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=8001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`Session`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`Session` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`Session` (
  `SessionId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CustomerId` INT UNSIGNED NOT NULL COMMENT '',
  `IpAddress` NVARCHAR(25) NULL COMMENT '',
  `UserAgent` NVARCHAR(25) NULL COMMENT '',
  `SessionStartTime` DATETIME NOT NULL COMMENT '',
  `SessionEndTime` DATETIME NOT NULL COMMENT '',
  `IsSessionActive` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`SessionId`)  COMMENT '',
  INDEX `CustomerId_idx` (`CustomerId` ASC)  COMMENT '',
  CONSTRAINT `SessionCustomer`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `musephoria`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=9001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`OrderItem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`OrderItem` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`OrderItem` (
  `OrderItemId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `OrderId` INT UNSIGNED NOT NULL COMMENT '',
  `CdId` INT UNSIGNED NOT NULL COMMENT '',
  `OrderItemName` NVARCHAR(45) NOT NULL COMMENT '',
  `OrderQuantity` INT UNSIGNED NOT NULL COMMENT '',
  INDEX `OrderId_idx` (`OrderId` ASC)  COMMENT '',
  INDEX `CdId_idx` (`CdId` ASC)  COMMENT '',
  PRIMARY KEY (`OrderItemId`)  COMMENT '',
  CONSTRAINT `OrderItemOrder`
    FOREIGN KEY (`OrderId`)
    REFERENCES `musephoria`.`Order` (`OrderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `OrderItemCd`
    FOREIGN KEY (`CdId`)
    REFERENCES `musephoria`.`Cd` (`CdId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=10001,
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
    ON UPDATE NO ACTION) AUTO_INCREMENT=11001,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musephoria`.`PurchaseOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musephoria`.`PurchaseOrder` ;

CREATE TABLE IF NOT EXISTS `musephoria`.`PurchaseOrder` (
  `PurchaseOrderId` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `CustomerId` INT UNSIGNED NOT NULL COMMENT '',
  `PurchaseOrderItem` NVARCHAR(45) NOT NULL COMMENT '',
  `Quantity` INT NOT NULL COMMENT '',
  `BaseAmount` FLOAT NOT NULL COMMENT '',
  `ShippingAddress` NVARCHAR(45) NOT NULL COMMENT '',
  `PurchaseOrderStatus` ENUM('Ordered', 'Approved', 'Rejected') NOT NULL COMMENT '',
  `IsPurchaseOrderActive` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`PurchaseOrderId`)  COMMENT '',
  INDEX `PurchaseOrderCustomer_idx` (`CustomerId` ASC)  COMMENT '',
  CONSTRAINT `PurchaseOrderCustomer`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `musephoria`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) AUTO_INCREMENT=12001,
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
