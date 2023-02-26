CREATE SCHEMA IF NOT EXISTS `proyectop312023` DEFAULT CHARACTER SET utf8 ;
USE `proyectop312023`;

CREATE TABLE IF NOT EXISTS tbl_usuario (
	usuid INT NOT NULL AUTO_INCREMENT,
	usunombre VARCHAR(45) NOT NULL,
	usucontrasena VARCHAR(25) NOT NULL,
	PRIMARY KEY (usuid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_aplicaciones (
	aplid INT NOT NULL AUTO_INCREMENT,
	aplnombre VARCHAR(45) NOT NULL,
	aplestatus VARCHAR(25) NOT NULL,
	PRIMARY KEY (aplid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_aplicacionusuario (
	aplid INT NOT NULL;
    usuid INT NOT NULL;
	PRIMARY KEY (aplid) )
ENGINE = InnoDB CHARACTER SET = latin1;