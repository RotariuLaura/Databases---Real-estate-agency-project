SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema proiect_agentie_imobiliara
-- -----------------------------------------------------

DROP DATABASE IF EXISTS proiect_agentie_imobiliara;
CREATE DATABASE IF NOT EXISTS proiect_agentie_imobiliara;
USE proiect_agentie_imobiliara;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`adresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`adresa` (
  `adresa_id` INT NOT NULL AUTO_INCREMENT,
  `oras` CHAR(20) NULL DEFAULT NULL,
  `strada` CHAR(20) NULL DEFAULT NULL,
  `numar` INT NULL DEFAULT NULL,
  `scara` CHAR(10) NULL DEFAULT NULL,
  `etaj` CHAR(10) NULL DEFAULT NULL,
  `nr_apartament` INT NULL DEFAULT NULL,
  PRIMARY KEY (`adresa_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`agent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`agent` (
  `agent_id` INT NOT NULL AUTO_INCREMENT,
  `nume` CHAR(10) NULL DEFAULT NULL,
  `prenume` CHAR(10) NULL DEFAULT NULL,
  `nr_telefon` CHAR(10) NULL DEFAULT NULL,
  `email` CHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`agent_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `nume` CHAR(10) NULL DEFAULT NULL,
  `prenume` CHAR(10) NULL DEFAULT NULL,
  `tip_client` CHAR(30) NULL DEFAULT NULL,
  `nr_telefon` CHAR(11) NULL DEFAULT NULL,
  `email` CHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`proprietar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`proprietar` (
  `proprietar_id` INT NOT NULL AUTO_INCREMENT,
  `nume` CHAR(10) NULL DEFAULT NULL,
  `prenume` CHAR(10) NULL DEFAULT NULL,
  `nr_telefon` CHAR(10) NULL DEFAULT NULL,
  `email` CHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`proprietar_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`tipproprietate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`tipproprietate` (
  `tip_proprietate_id` INT NOT NULL AUTO_INCREMENT,
  `decomandata` CHAR(2) NULL DEFAULT NULL,
  `nume_proprietate` CHAR(50) NULL DEFAULT NULL,
  `nr_camere` INT NULL DEFAULT NULL,
  `suprafata` INT NULL DEFAULT NULL,
  PRIMARY KEY (`tip_proprietate_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`oferta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`oferta` (
  `oferta_id` INT NOT NULL AUTO_INCREMENT,
  `status_oferta` CHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`oferta_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`proprietate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`proprietate` (
  `proprietate_id` INT NOT NULL AUTO_INCREMENT,
  `pret` FLOAT NULL DEFAULT NULL,
  `descriere` CHAR(100) NULL DEFAULT NULL,
  `status_proprietate` CHAR(20) NULL DEFAULT NULL,
  `agent_id` INT NULL DEFAULT NULL,
  `proprietar_id` INT NULL DEFAULT NULL,
  `tip_proprietate_id` INT NULL DEFAULT NULL,
  `adresa_adresa_id` INT NOT NULL,
  `oferta_oferta_id` INT NOT NULL,
  PRIMARY KEY (`proprietate_id`, `adresa_adresa_id`, `oferta_oferta_id`),
  INDEX `agent_id` (`agent_id` ASC) VISIBLE,
  INDEX `proprietar_id` (`proprietar_id` ASC) VISIBLE,
  INDEX `tip_proprietate_id` (`tip_proprietate_id` ASC) VISIBLE,
  INDEX `fk_proprietate_adresa1_idx` (`adresa_adresa_id` ASC) VISIBLE,
  INDEX `fk_proprietate_oferta1_idx` (`oferta_oferta_id` ASC) VISIBLE,
  CONSTRAINT `proprietate_ibfk_2`
    FOREIGN KEY (`agent_id`)
    REFERENCES `proiect_agentie_imobiliara`.`agent` (`agent_id`),
  CONSTRAINT `proprietate_ibfk_3`
    FOREIGN KEY (`proprietar_id`)
    REFERENCES `proiect_agentie_imobiliara`.`proprietar` (`proprietar_id`),
  CONSTRAINT `proprietate_ibfk_4`
    FOREIGN KEY (`tip_proprietate_id`)
    REFERENCES `proiect_agentie_imobiliara`.`tipproprietate` (`tip_proprietate_id`),
  CONSTRAINT `fk_proprietate_adresa1`
    FOREIGN KEY (`adresa_adresa_id`)
    REFERENCES `proiect_agentie_imobiliara`.`adresa` (`adresa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proprietate_oferta1`
    FOREIGN KEY (`oferta_oferta_id`)
    REFERENCES `proiect_agentie_imobiliara`.`oferta` (`oferta_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`inchiriere`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`inchiriere` (
  `inchiriere_id` INT NOT NULL AUTO_INCREMENT,
  `data_inchirierii` DATE NULL DEFAULT NULL,
  `data_eliberarii` DATE NULL DEFAULT NULL,
  `proprietate_id` INT NULL DEFAULT NULL,
  `client_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`inchiriere_id`),
  INDEX `client_id` (`client_id` ASC) VISIBLE,
  INDEX `proprietate_id` (`proprietate_id` ASC) VISIBLE,
  CONSTRAINT `inchiriere_ibfk_1`
    FOREIGN KEY (`client_id`)
    REFERENCES `proiect_agentie_imobiliara`.`client` (`client_id`),
  CONSTRAINT `inchiriere_ibfk_2`
    FOREIGN KEY (`proprietate_id`)
    REFERENCES `proiect_agentie_imobiliara`.`proprietate` (`proprietate_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `proiect_agentie_imobiliara`.`vizionare`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiect_agentie_imobiliara`.`vizionare` (
  `vizionare_id` INT NOT NULL AUTO_INCREMENT,
  `data_vizionarii` DATE NULL DEFAULT NULL,
  `ora_vizionarii` INT NULL DEFAULT NULL,
  `proprietate_id` INT NULL DEFAULT NULL,
  `client_id` INT NULL DEFAULT NULL,
  `inchiriere` CHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`vizionare_id`),
  INDEX `proprietate_id` (`proprietate_id` ASC) VISIBLE,
  INDEX `client_id` (`client_id` ASC) VISIBLE,
  CONSTRAINT `vizionare_ibfk_1`
    FOREIGN KEY (`client_id`)
    REFERENCES `proiect_agentie_imobiliara`.`client` (`client_id`),
  CONSTRAINT `vizionare_ibfk_2`
    FOREIGN KEY (`proprietate_id`)
    REFERENCES `proiect_agentie_imobiliara`.`proprietate` (`proprietate_id`),
  CONSTRAINT `vizionare_ibfk_3`
    FOREIGN KEY (`proprietate_id`)
    REFERENCES `proiect_agentie_imobiliara`.`oferta` (`oferta_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- POPULARE

INSERT INTO agent(nume, prenume, nr_telefon, email) VALUES
('Rusu', 'Ionut', '0745678918', 'rusu.ionut@yahoo.com'),
('Zubascu', 'Cristina', '0732567890', 'zubascu.cristina@yahoo.com'),
('Jijie', 'Maria', '0765438975', 'jijie.maria@yahoo.com'),
('Pop', 'Ovidiu', '0752854982', 'pop.ovidiu@yahoo.com'),
('Popa', 'Luminita', '0723546721', 'popa.luminita@yahoo.com'),
('Cristea', 'Marian', '0743567243', 'cristea.marian@yahoo.com'),
('Chihaia', 'Iuliana', '0765547382', 'chihaia.iuliana@yahoo.com'),
('Faur', 'Vlad', '075645342', 'faur.vlad@yahoo.com'),
('Giurgiu', 'Bogdan', '0787546321', 'giurgiu.vlad@yahoo.com'),
('George', 'Calin', '0735426896', 'george.calin@yahoo.com');

INSERT INTO proprietar(nume, prenume, nr_telefon, email) VALUES
('Moisa', 'Ioana', '0789564321', 'moisa.ioana@yahoo.com'),
('Vieru', 'Cristian', '0756437892', 'vieru.cristian@yahoo.com'),
('Puiu', 'Radu', '0734589761', 'puiu.radu@yahoo.com'),
('Vintila', 'Teodora', '0756487602', 'vintila.teodora@yahoo.com'),
('Chis', 'Viroica', '0776546342', 'chis.viorica@yahoo.com'),
('Dumbrava', 'Ionel', '0765748352', 'dumbrava.ionel@yahoo.com'),
('Vintocu', 'Mihai', '0754634253', 'vintocu.mihai@yahoo.com'),
('Ciot', 'Vladimir', '0767564322', 'ciot.vladimir@yahoo.com'),
('Dunca', 'Ioana', '0745352671', 'dunca.ioana@yahoo.com'),
('Rus', 'Andrada', '0754634212', 'rus.andrada@yahoo.com');

INSERT INTO tipproprietate(decomandata, nume_proprietate, nr_camere, suprafata) VALUES
('NU', 'garsoniera', 1, 30),
('DA', 'apartament mic', 2, 40),
('DA', 'apartament mediu', 3, 55),
('DA', 'apartament mare', 4, 75);

INSERT INTO oferta(status_oferta) VALUES
('ACTIVA'), ('ACTIVA'), ('ACTIVA'), ('ACTIVA'),('ACTIVA'), ('INACTIVA'),('INACTIVA'),('INACTIVA'),('INACTIVA'),('INACTIVA'), ('ACTIVA');

INSERT INTO adresa(oras, strada, numar, scara, etaj, nr_apartament) VALUES
('Cluj', 'Nasaud', 22, 'B', 1, 25),
('Cluj', 'Dambovitei', 24, 'B4', 3, 23),
('Cluj', 'Dorobantilor', 30, 'B12', 2, 40),
('Cluj', 'Observatorului', 2, 'A', 1, 75), 
('Bucuresti', 'Fagului', 45, null, null, 12),
('Cluj', 'Nordului', 23, 'F5', 4, 12),
('Bistrita', 'Castanilor', 24, null, null, 12),
('Bucuresti', 'Prunului', 26, 'F5', 4, 12),
('Suceava', 'Marului', 24, 'F5', 4, 12),
('Bucuresti', 'Decebal', 56, 'F5', 4, 12),
('Cluj', 'Train', 44, 'B2', 2, 14);

INSERT INTO proprietate(pret, descriere, status_proprietate, agent_id, proprietar_id, tip_proprietate_id, adresa_adresa_id, oferta_oferta_id) VALUES
(300, 'mobilata, renovata, potrivita pentru o persoana', 'DISPONIBILA', 1, 1, 1, 1, 1),
(250, 'conditii medii, potrivita pentru o persoana', 'DISPONIBILA', 5, 2, 1, 2, 2),
(350, 'pentru o persoana/un cuplu, nou, confortabil', 'DISPONIBILA', 2, 3, 2, 3, 3),
(450, 'pentru 2 persoane, confortabil, frumos', 'DISPONIBILA', 3, 4, 3, 4, 4),
(600, 'potrivit afacere, nou', 'DISPONIBILA', 4, 4, 4, 5, 5),
(350, 'nou, conditii bune', 'INDISPONIBILA', 6, 5, 2, 6, 6),
(300, 'potrivit afacere, nou', 'INDISPONIBILA', 4, 6, 4, 7, 7),
(550, 'potrivit afacere, nou', 'INDISPONIBILA', 7, 7, 2, 8, 8),
(500, 'apartament spatios, mobilat, nou', 'INDISPONIBILA', 10, 8, 3, 9, 9),
(600, 'potrivit familie, nou', 'INDISPONIBILA', 8, 9, 4, 10, 10),
(450, 'pentru 2 persoane, mobilat, frumos', 'DISPONIBILA', 10, 3, 3, 11, 11);

INSERT INTO client(client_id, nume, prenume, tip_client, nr_telefon, email) VALUES
(1, 'Rotariu', 'Cristina', 'persoana fizica', '0763826384', 'rotariu.cristina@yahoo.com'),
(2, 'Divricean', 'Alexandru', 'persoana fizica', '0786762532', 'divricean.alexandru@yahoo.com'),
(3, 'Anton', 'Ionut', 'persoana fizica',' 0765987204', 'anton.ionut@yahoo.com'),
(4, 'Popescu', 'Dalia', 'firma', '0745678210', 'popescu.dalia@yahoo.com');

INSERT INTO vizionare(data_vizionarii, ora_vizionarii, proprietate_id, client_id, inchiriere) VALUES
('2022-02-12', 14, 1, 1, 'DA'),
('2022-04-20', 10, 1, 2, 'NU'),
('2022-04-20', 12, 3, 2, 'NU'),
('2022-05-16', 09, 2, 3, 'NU'),
('2022-10-08', 12, 4, 4, 'DA');

USE `proiect_agentie_imobiliara` ;

-- Proceduri pentru inserare in tabele

# procedura adauga_client

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_client`(client_id INT, nume CHAR(10), prenume CHAR(10), tip_client CHAR(30), nr_telefon CHAR(11), email CHAR(50))
BEGIN
	START TRANSACTION;
INSERT INTO client values(client_id, nume, prenume, tip_client, nr_telefon, email);
END$$

DELIMITER ;

call adauga_client(5, 'Matei', 'Adrian', 'firma', '0767898524', 'matei.adrian@yahoo.com');
call adauga_client(6, 'Drob', 'Maria', 'firma', '0765392580', 'drob.maria@yahoo.com');
call adauga_client(7, 'Luca', 'Sorin', 'persoana fizica', '0789045638', 'luca.sorin@yahoo.com');
call adauga_client(8, 'Criste', 'Mircea', 'persoana fizica', '0734775865', 'criste.mircea@yahoo.com');
call adauga_client(9, 'Ciobanu', 'Ilinca', 'firma', '0789234509', 'ciobanu.ilinca@yahoo.com');
call adauga_client(10, 'Atodirese', 'Diana', 'persoana fizica', '0759923862', 'atodirese.diana@yahoo.com');
call adauga_client(11, 'Stan', 'Cosmin', 'persoana fizica', '0798327876', 'stan.cosmin@yahoo.com');
call adauga_client(12, 'Lupu', 'Claudia', 'firma', '0743898792', 'lupu.claudia@yahoo.com');

# procedura adauga_proprietate

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_proprietate`(pret FLOAT, descriere CHAR(100), status_proprietate CHAR(20),
  agent_id INT, proprietar_id INT, tip_proprietate_id INT, adresa_adresa_id INT, oferta_oferta_id INT)
BEGIN
	START TRANSACTION;
INSERT INTO proprietate values(proprietate_id, pret, descriere, status_proprietate, agent_id, proprietar_id, tip_proprietate_id,
 adresa_adresa_id, oferta_oferta_id);
END$$

DELIMITER ;

# procedura adauga_adresa

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_adresa`(oras CHAR(20), strada CHAR(20), numar INT, scara CHAR(11), etaj CHAR(10), nr_apartament INT)
BEGIN
	START TRANSACTION;
INSERT INTO adresa values(adresa_id, oras, strada, numar, scara, etaj, nr_apartament);
END$$

DELIMITER ;

# procedura adauga_oferta

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_oferta`(status_oferta CHAR(20))
BEGIN
	START TRANSACTION;
INSERT INTO oferta values(oferta_id, status_oferta);
END$$

DELIMITER ;

call adauga_adresa('Cluj', 'Nicolae Draganu', 18, 'B2', 1, 3);
call adauga_oferta('ACTIVA');
call adauga_proprietate(700, 'nou, confortabil', 'DISPONIBILA', 1, 1, 4, 12, 12);

# procedura adauga_proprietar

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_proprietar`(proprietar_id INT, nume CHAR(10), prenume CHAR(10), tip_client CHAR(30), nr_telefon CHAR(11), email CHAR(50))
BEGIN
	START TRANSACTION;
INSERT INTO proprietar values(proprietar_id, nume, prenume, tip_client, nr_telefon, email);
END$$

DELIMITER ;

# procedura adauga_agent

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_agent`(agent_id INT, nume CHAR(10), prenume CHAR(10), tip_client CHAR(30), nr_telefon CHAR(11), email CHAR(50))
BEGIN
	START TRANSACTION;
INSERT INTO agent values(agent_id, nume, prenume, tip_client, nr_telefon, email);
END$$

DELIMITER ;

# procedura adauga_vizionare

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_vizionare`(vizionare_id INT, data_vizionarii DATE, ora_vizionarii INT,
    proprietate_id INT, client_id INT, inchiriere CHAR(2))
BEGIN
	START TRANSACTION;
INSERT INTO vizionare values(vizionare_id, data_vizionarii, ora_vizionarii, proprietate_id, client_id, inchiriere);
END$$

DELIMITER ;

# procedura adauga_inchiriere

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_inchiriere`(inchiriere_id INT, data_inchirierii DATE, data_eliberarii DATE,
    proprietate_id INT, client_id INT)
BEGIN
	START TRANSACTION;
INSERT INTO inchiriere values(inchiriere_id, data_inchirierii, data_eliberarii, proprietate_id, client_id);
END$$

DELIMITER ;

call adauga_vizionare(6, '2022-04-20', 12, 6, 12, 'NU');
call adauga_vizionare(7, '2022-10-04', 15, 6, 1, 'DA');
call adauga_inchiriere(1, '2022-10-04', null, 6, 1);
call adauga_vizionare(8, '2022-04-20', 15, 7, 5, 'NU');
call adauga_vizionare(9, '2022-12-14', 16, 7, 4, 'DA');
call adauga_inchiriere(2, '2022-12-14', null, 7, 4);
call adauga_vizionare(10, '2022-12-22', 12, 8, 5, 'NU');
call adauga_vizionare(11, '2022-04-20', 14, 8, 9, 'NU');
call adauga_vizionare(12, '2022-12-22', 15, 8, 6, 'DA');
call adauga_inchiriere(3, '2022-12-22', null, 8, 6);
call adauga_vizionare(13, '2022-04-20', 10, 9, 10, 'NU');
call adauga_vizionare(14, '2023-01-04', 15, 9, 7, 'DA');
call adauga_inchiriere(4, '2023-01-04', null, 9, 7);
call adauga_vizionare(15, '2022-04-20', 10, 10, 11, 'NU');
call adauga_vizionare(16, '2023-01-10', 10, 10, 8, 'DA');
call adauga_inchiriere(5, '2023-01-10', null, 10, 8);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET SQL_SAFE_UPDATES = 0;

-- Interogarile

#1.Clientii care au vizionat proprietati de tipul 1?

	 SELECT COUNT(*) FROM client 
	 JOIN vizionare on vizionare.client_id=client.client_id
	 JOIN proprietate on proprietate.proprietate_id=vizionare.proprietate_id
	 WHERE proprietate.tip_proprietate_id=1;
 
#2.Ce proprietari au proprietati in orasul Cluj si Bucuresti?

	 SELECT nume,prenume FROM proprietar 
	 JOIN proprietate on proprietate.proprietar_id=proprietar.proprietar_id
	 JOIN adresa on adresa.adresa_id=proprietate.adresa_adresa_id
	 WHERE adresa.oras in ("Cluj","Bucuresti")
	 GROUP BY nume, prenume;
 
 #3.Ce clienti au inchiriat proprietatile pe care le-au vizionat?
	 SELECT nume,prenume FROM client 
	 JOIN vizionare on vizionare.client_id=client.client_id
	 WHERE vizionare.inchiriere = 'DA'
	 GROUP BY nume, prenume;
  
 #4. Afisati clientii care au inchiriat proprietati in anul 2022.
 
	 SELECT nume,prenume FROM client 
	 JOIN inchiriere on inchiriere.client_id=client.client_id
	 WHERE year(inchiriere.data_inchirierii)="2022"
     ORDER BY client.client_id ASC;
 
 #5. Ce agent se ocupa de proprietatea de pe strada Dorobantilor?
	 SELECT nume,prenume FROM agent 
	 JOIN proprietate on proprietate.agent_id=agent.agent_id
	 JOIN adresa on adresa.adresa_id=proprietate.adresa_adresa_id
	 WHERE adresa.strada="Dorobantilor";

#6. Afisati proprietarii care au proprietati de tipul 1.

	SELECT nume,prenume FROM proprietar 
	JOIN proprietate on proprietate.proprietar_id=proprietar.proprietar_id
	WHERE proprietate.tip_proprietate_id=1;

#7. Ce clienti au vizionat in data de 20.04.2022 proprietati?

	SELECT nume,prenume FROM client 
	JOIN vizionare on vizionare.client_id=client.client_id
	WHERE vizionare.data_vizionarii='2022-04-20'
	GROUP BY nume, prenume
	ORDER BY client.client_id ASC;

#8. Clientii care au vizionat proprietatea 2?

	SELECT nume,prenume FROM client 
	JOIN vizionare on vizionare.client_id=client.client_id
	WHERE vizionare.proprietate_id=2;

#9. Proprietarul proprietatii vizionate de clientul 4 in data de 10.08.2022?

	SELECT * FROM proprietar
	JOIN proprietate on proprietar.proprietar_id=proprietate.proprietar_id
    JOIN vizionare on vizionare.proprietate_id=proprietate.proprietate_id
    JOIN client on client.client_id=vizionare.client_id
	WHERE client.client_id=4 AND vizionare.data_vizionarii='2022-08-10';

#10. De care proprietati se ocupa agentul cu numele Rusu Ionut?
	SELECT * FROM proprietate
	LEFT JOIN agent on agent.agent_id=proprietate.agent_id
	WHERE agent.nume='Rusu' AND agent.prenume = 'Ionut';


#11. Ce clienti au vizionat mai multe proprietati?

	SELECT nume,prenume FROM client
	JOIN vizionare on vizionare.client_id=client.client_id
	GROUP BY vizionare.client_id HAVING COUNT(*)>1;
 
 -- Procedurile (mai sus sunt si procedurile pentru inserare in tabele)
 
 # Procedura modificare data eliberare

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifica_data_eliberare`(id INT, eliberare DATE)
BEGIN
    START TRANSACTION;
    UPDATE inchirieri
    SET data_eliberarii = eliberare WHERE inchiriere_id = id;
  END$$

DELIMITER ;

# Procedura modificare data inchiriere

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifica_data_inchiriere`(id INT, inchiriere DATE)
BEGIN
    START TRANSACTION;
    UPDATE inchirieri
    SET data_inchirierii = inchiriere WHERE inchiriere_id = id;
  END$$

DELIMITER ;

# Procedura modificare status oferta

DELIMITER $$
USE `proiect_agentie_imobiliara`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifica_status_oferta`(id INT, status_oferta CHAR(20))
BEGIN
    START TRANSACTION;
    UPDATE oferta
    SET oferta.status_oferta = status_oferta WHERE oferta_id = id;
  END$$

DELIMITER ;

 # Procedura proprietarii cu proprietati de tipul x
DELIMITER $$

CREATE PROCEDURE proprietari_cu_proprietati_tip_x(IN parametru_tip int)
BEGIN
	SELECT nume,prenume FROM proprietar 
	JOIN proprietate on proprietate.proprietar_id=proprietar.proprietar_id
	WHERE proprietate.tip_proprietate_id=parametru_tip;
END;$$
DELIMITER;

#CALL proprietari_cu_proprietati_tip_x(1);

# Procedura clientii care au vizionat proprietati in data x
DELIMITER $$

CREATE PROCEDURE clienti_vizionari_in_data_x(IN parametru_date date)
BEGIN
	SELECT nume,prenume FROM client 
	JOIN vizionare on vizionare.client_id=client.client_id
	WHERE vizionare.data_vizionarii=parametru_date;
END;$$
DELIMITER;

#CALL clienti_vizionari_in_data_x("2022-04-20");

# Procedura clientii care un vizionat proprietatea x
DELIMITER $$

CREATE PROCEDURE clienti_vizionari_proprietate_x(IN parametru_id_proprietate int)
BEGIN
	SELECT nume,prenume FROM client 
	JOIN vizionare on vizionare.client_id=client.client_id
	WHERE vizionare.proprietate_id=parametru_id_proprietate;
END;$$

DELIMITER;

#CALL clienti_vizionari_proprietate_x(2);

# Procedura proprietarul proprietatii vizionate de clientul x in data y
DELIMITER $$

CREATE PROCEDURE proprietarii_proprietatii_vizionate(IN parametru_client_id int, IN parametru_date date)
BEGIN
	SELECT * FROM proprietar
	JOIN proprietate on proprietar.proprietar_id=proprietate.proprietar_id
    JOIN vizionare on vizionare.proprietate_id=proprietate.proprietate_id
    JOIN client on client.client_id=vizionare.client_id
	WHERE client.client_id=parametru_client_id AND vizionare.data_vizionarii=parametru_date;
END;$$

DELIMITER;
#CALL proprietarii_proprietatii_vizionate(1,"2022-02-12");

# Procedura de care proprietati de ocupa agentul cu numele x
DELIMITER $$

CREATE PROCEDURE proprietati_agent_x(IN parametru_agent varchar(50))
BEGIN
	SELECT * FROM proprietate
	LEFT JOIN agent on agent.agent_id=proprietate.agent_id
	WHERE agent.nume=parametru_agent;
END;$$

DELIMITER;
#CALL proprietati_agent_x("Rusu");

# Procedura ce clienti au vizionat mai multe proprietati
DELIMITER $$

CREATE PROCEDURE clienti_vizionari_multiple()
BEGIN
	SELECT nume,prenume FROM client
	JOIN vizionare on vizionare.client_id=client.client_id
	GROUP BY vizionare.client_id HAVING COUNT(*)>1;
END;$$
#DELIMITER;
#CALL clienti_vizionari_multiple();

 -- Triggerele
 
 # Trigger pentru modificare proprietate si oferta in momentul modificarii tabelei vizionare, deoarece tabela oferta nu are legatura directa cu tabela de vizionare, se va crea un alt trigger care modifica statusul ofertei in momentul in care se seteaza 'INDISPONIBILA' in proprietate
 delimiter // 
CREATE TRIGGER tModificareProprietate AFTER UPDATE ON vizionare
FOR EACH ROW BEGIN
		declare variabila_vizionare varchar(20);
        set variabila_vizionare = new.inchiriere;
        IF variabila_vizionare = 'DA' THEN
		UPDATE proprietate
        set status_proprietate = 'INDISPONIBILA'
        WHERE proprietate.proprietate_id = old.proprietate_id;
		END IF;
END;//
delimiter ;

#drop trigger tModificareProprietate
#update vizionare SET inchiriere = 'DA' where vizionare_id = 3

 delimiter // 
CREATE TRIGGER tModificareOferta AFTER UPDATE ON proprietate
FOR EACH ROW BEGIN
		declare variabila_proprietate varchar(20);
        set variabila_proprietate = new.status_proprietate;
        IF variabila_proprietate = 'INDISPONIBILA' THEN
		UPDATE oferta
        set status_oferta = 'INACTIVA'
        WHERE oferta.oferta_id = old.oferta_oferta_id;
        ELSEIF variabila_proprietate = 'DISPONIBILA' THEN
		UPDATE oferta
        set status_oferta = 'ACTIVA'
        WHERE oferta.oferta_id = old.oferta_oferta_id;
		END IF;
END;//
delimiter ;

#drop trigger tModificareOferta
#update vizionare SET inchiriere = 'DA' where vizionare_id = 4


# Trigger pentru update proprietate in momentul adaugarii unei inchirieri
 delimiter // 
CREATE TRIGGER tModificareProprietateDupaInchiriere BEFORE INSERT ON inchiriere
FOR EACH ROW BEGIN
		declare variabila_data_eliberarii varchar(20);
        set variabila_data_eliberarii = new.data_eliberarii;
		IF variabila_data_eliberarii is NULL THEN
		UPDATE proprietate
        set status_proprietate = 'INDISPONIBILA'
        WHERE proprietate.proprietate_id = new.proprietate_id;
		END IF;
END;//
delimiter ;

#drop trigger tModificareProprietateDupaInchiriere
#insert into inchiriere values (2,curdate(),NULL,2,1)

# Trigger pentru update proprietate in momentul modificarii data_eliberarii din inchiriere
 delimiter // 
CREATE TRIGGER tModificareProprietateDupaDataEliberarii BEFORE UPDATE ON inchiriere
FOR EACH ROW BEGIN
		declare variabila_data_eliberarii varchar(20);
        set variabila_data_eliberarii = new.data_eliberarii;
		IF variabila_data_eliberarii is NOT NULL THEN
		UPDATE proprietate
        set status_proprietate = 'DISPONIBILA'
        WHERE proprietate.proprietate_id = new.proprietate_id;
        ELSEIF variabila_data_eliberarii is NULL THEN
		UPDATE proprietate
        set status_proprietate = 'INDISPONIBILA'
        WHERE proprietate.proprietate_id = new.proprietate_id;
		END IF;
END;//
delimiter ;

#drop trigger tModificareProprietateDupaDataEliberarii
#update inchiriere set data_eliberarii = NULL where inchiriere_id = 1

call adauga_inchiriere(6, '2022-12-10', null, 1, 2);
UPDATE inchiriere
SET data_eliberarii = '2023-01-11'
WHERE inchiriere_id = 6;

-- Vederile

# View Clientii care au vizualizat proprietati de tipul 2
CREATE VIEW View_VizionariClientiProprietateaTip2 AS
SELECT nume,prenume FROM client 
 JOIN vizionare on vizionare.client_id=client.client_id
 JOIN proprietate on proprietate.proprietate_id=vizionare.proprietate_id
 WHERE proprietate.tip_proprietate_id=2;
 
 # View Agentii care se ocupa de proprietatea 2
CREATE VIEW View_AgentiiProprietatii2 AS
SELECT nume,prenume FROM agent 
JOIN proprietate on proprietate.agent_id=agent.agent_id
WHERE proprietate.proprietate_id=2;

 # View Proprietate cu id inlocuite de valori
CREATE VIEW View_ProprietateFaraId AS
 SELECT proprietate.proprietate_id,
		proprietate.pret,
		proprietate.descriere,
        proprietate.status_proprietate,
        concat_ws(' ',agent.nume, agent.prenume) AS Agent,
        concat_ws(' ',proprietar.nume, proprietar.prenume) AS Proprietar,
        tipproprietate.nume_proprietate AS TipProprietate,
        concat_ws(', ',adresa.oras,adresa.strada,adresa.numar,adresa.scara,adresa.etaj,adresa.nr_apartament) AS Adresa,
        oferta.status_oferta AS Oferta
FROM proprietate 
JOIN agent on agent.agent_id=proprietate.agent_id
JOIN proprietar on proprietar.proprietar_id=proprietate.proprietar_id
JOIN tipproprietate on tipproprietate.tip_proprietate_id=proprietate.tip_proprietate_id
JOIN adresa on adresa.adresa_id=proprietate.adresa_adresa_id
JOIN oferta on oferta.oferta_id=proprietate.oferta_oferta_id;

# View Inchiriere cu proprietati care au fost inchiriate in data de azi
CREATE VIEW View_InchirieriDeAzi AS
 SELECT inchiriere.data_inchirierii,
		inchiriere.data_eliberarii,
		inchiriere.proprietate_id,
        concat_ws(' ',client.nume, client.prenume) AS client
 FROM inchiriere 
JOIN client on client.client_id=inchiriere.client_id
WHERE inchiriere.data_inchirierii = curdate();

 # View Proprietati care nu sunt inchiriate
CREATE VIEW View_ProprietatiNeinchiriate AS
SELECT * FROM proprietate
WHERE proprietate.status_proprietate='DISPONIBILA';

-- Securizarea accesului

-- CREATE USER user_db@localhost
-- IDENTIFIED BY 'pass';

-- GRANT SELECT
-- ON proiect_agentie_imobiliara.*
-- TO user_db@localhost;

-- SHOW GRANTS FOR user_db@localhost;