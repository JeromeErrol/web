CREATE TABLE `market`.`image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `base64` VARCHAR(10000) NULL,
  `bytes` LONGBLOB NULL,
  PRIMARY KEY (`id`));
