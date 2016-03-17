
CREATE TABLE `market`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(300) NOT NULL,
  `password` VARCHAR(300) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `market`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(300) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `market`.`stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(300) NULL,
  `price` DECIMAL(8,2) NULL,
  `discount` DECIMAL(3,2) NULL,
  `category_id` INT NULL,
  `image_id` LONGBLOB NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `market`.`image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `base64` VARCHAR(10000) NULL,
  `bytes` LONGBLOB NULL,
  PRIMARY KEY (`id`));
