-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.17 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table dahouet.challenge
CREATE TABLE IF NOT EXISTS `challenge` (
  `ID_CHALLENGE` int(11) NOT NULL,
  `NOM_CHALLENGE` varchar(25) NOT NULL,
  `DATE_CHALLENGE_DEBUT` date NOT NULL,
  `DATE_CHALLENGE_FIN` date NOT NULL,
  PRIMARY KEY (`ID_CHALLENGE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.challenge: ~2 rows (approximately)
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` (`ID_CHALLENGE`, `NOM_CHALLENGE`, `DATE_CHALLENGE_DEBUT`, `DATE_CHALLENGE_FIN`) VALUES
	(1, 'Eté 2014', '2014-06-21', '2014-09-21'),
	(2, 'Hiver 2014', '2014-12-21', '2015-03-21');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;


-- Dumping structure for table dahouet.classe
CREATE TABLE IF NOT EXISTS `classe` (
  `ID_CLASSE` int(11) NOT NULL,
  `ID_SERIE` int(11) NOT NULL,
  `NOM_CLASSE` varchar(30) NOT NULL,
  `COEFFICIENT` decimal(5,4) NOT NULL,
  PRIMARY KEY (`ID_CLASSE`),
  KEY `FK1_IDserie` (`ID_SERIE`),
  CONSTRAINT `FK1_IDserie` FOREIGN KEY (`ID_SERIE`) REFERENCES `serie` (`ID_SERIE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.classe: ~11 rows (approximately)
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` (`ID_CLASSE`, `ID_SERIE`, `NOM_CLASSE`, `COEFFICIENT`) VALUES
	(1, 1, 'Corsaire', 0.1000),
	(2, 1, 'Surprise', 0.2000),
	(3, 1, '8 Metres', 0.3000),
	(4, 1, 'Maraudeur', 0.4000),
	(5, 1, 'Figaro', 0.5000),
	(6, 2, 'Flying Fifteen', 0.6000),
	(7, 2, 'Soling', 0.7000),
	(8, 2, 'Star', 0.8000),
	(9, 2, 'Tempest', 0.9000),
	(10, 2, 'Yngling', 0.9500),
	(11, 2, '5.5', 0.9800);
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;


-- Dumping structure for table dahouet.comite
CREATE TABLE IF NOT EXISTS `comite` (
  `ID_COMITE` int(11) NOT NULL,
  `NOM_COMITE` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_COMITE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.comite: ~5 rows (approximately)
/*!40000 ALTER TABLE `comite` DISABLE KEYS */;
INSERT INTO `comite` (`ID_COMITE`, `NOM_COMITE`) VALUES
	(1, 'Bretagne'),
	(2, 'Normandie'),
	(3, 'Aquitaine'),
	(4, 'Côtes d\'Armor'),
	(5, 'Nice');
/*!40000 ALTER TABLE `comite` ENABLE KEYS */;


-- Dumping structure for table dahouet.commissaire
CREATE TABLE IF NOT EXISTS `commissaire` (
  `ID_COMMISSAIRE` int(11) NOT NULL,
  `ID_COMITE` int(11) NOT NULL,
  `NOM_COMMISSAIRE` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_COMMISSAIRE`),
  KEY `FK_FAIT_PARTIE` (`ID_COMITE`),
  CONSTRAINT `FK_FAIT_PARTIE` FOREIGN KEY (`ID_COMITE`) REFERENCES `comite` (`ID_COMITE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.commissaire: ~3 rows (approximately)
/*!40000 ALTER TABLE `commissaire` DISABLE KEYS */;
INSERT INTO `commissaire` (`ID_COMMISSAIRE`, `ID_COMITE`, `NOM_COMMISSAIRE`) VALUES
	(1, 1, 'Mark Collins'),
	(2, 2, 'François Migraine'),
	(3, 3, 'Symphonie Ringard');
/*!40000 ALTER TABLE `commissaire` ENABLE KEYS */;


-- Dumping structure for procedure dahouet.commissaires_regate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `commissaires_regate`(IN `nomchal` VARCHAR(50))
BEGIN
select regate.date_depart, commissaire.nom_commissaire, comite.nom_comite from regate
inner join commissaire on regate.id_commissaire = commissaire.id_commissaire
inner join comite on commissaire.id_comite = comite.id_comite
inner join challenge on regate.id_challenge = challenge.id_challenge
where challenge.id_challenge = nomchal;
END//
DELIMITER ;


-- Dumping structure for table dahouet.course
CREATE TABLE IF NOT EXISTS `course` (
  `NUM_COURSE` int(11) NOT NULL,
  `ID_EQUIPAGE` int(11) NOT NULL,
  `ID_VOILIER` int(11) NOT NULL,
  `CONDITION_DEPART` char(1) NOT NULL,
  `TEMPS` time NOT NULL,
  `TEMPS_REEL` time NOT NULL,
  `TEMPS_COMPENSE` time NOT NULL,
  `PAVILLON` varchar(20) NOT NULL,
  `CONDITION_ARRIVEE` varchar(3) NOT NULL,
  `DECISION_COMITE` varchar(25) NOT NULL,
  `DISTANCE_PARCOURUE` decimal(10,2) NOT NULL,
  `POINTS` int(11) NOT NULL,
  PRIMARY KEY (`ID_EQUIPAGE`,`NUM_COURSE`,`ID_VOILIER`),
  KEY `FK_PARTICIPE2` (`NUM_COURSE`),
  KEY `FK_PARTICIPE3` (`ID_VOILIER`),
  CONSTRAINT `FK_PARTICIPE` FOREIGN KEY (`ID_EQUIPAGE`) REFERENCES `equipage` (`ID_EQUIPAGE`),
  CONSTRAINT `FK_PARTICIPE2` FOREIGN KEY (`NUM_COURSE`) REFERENCES `regate` (`NUM_COURSE`),
  CONSTRAINT `FK_PARTICIPE3` FOREIGN KEY (`ID_VOILIER`) REFERENCES `voilier` (`ID_VOILIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.course: ~6 rows (approximately)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`NUM_COURSE`, `ID_EQUIPAGE`, `ID_VOILIER`, `CONDITION_DEPART`, `TEMPS`, `TEMPS_REEL`, `TEMPS_COMPENSE`, `PAVILLON`, `CONDITION_ARRIVEE`, `DECISION_COMITE`, `DISTANCE_PARCOURUE`, `POINTS`) VALUES
	(1, 1, 1, 'P', '17:05:22', '17:06:22', '00:01:00', 'Aucun', 'NA', 'Validé', 25.00, 1),
	(4, 1, 6, 'P', '16:30:00', '16:32:00', '00:02:00', 'Aucun', 'NA', 'Validé', 40.25, 1),
	(1, 2, 2, 'R', '17:08:15', '17:09:15', '00:01:00', 'Aucun', 'DNS', 'Validé', 22.50, 2),
	(4, 2, 7, 'P', '17:45:35', '17:47:35', '00:02:00', 'Aucun', 'NA', 'Validé', 32.25, 2),
	(1, 3, 3, 'P', '17:09:32', '17:10:32', '00:01:00', 'Aucun', 'NA', 'Validé', 30.50, 3),
	(4, 3, 8, 'P', '17:54:18', '17:56:18', '00:02:00', 'Aucun', 'DNS', 'Validé', 21.00, 3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


-- Dumping structure for table dahouet.equipage
CREATE TABLE IF NOT EXISTS `equipage` (
  `ID_EQUIPAGE` int(11) NOT NULL,
  `ID_EQUIPIER_SKIPPER` int(11) NOT NULL,
  `NOM_EQUIPAGE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_EQUIPAGE`),
  KEY `FK_DESIGNE` (`ID_EQUIPIER_SKIPPER`),
  CONSTRAINT `FK_DESIGNE` FOREIGN KEY (`ID_EQUIPIER_SKIPPER`) REFERENCES `equipier` (`ID_EQUIPIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.equipage: ~3 rows (approximately)
/*!40000 ALTER TABLE `equipage` DISABLE KEYS */;
INSERT INTO `equipage` (`ID_EQUIPAGE`, `ID_EQUIPIER_SKIPPER`, `NOM_EQUIPAGE`) VALUES
	(1, 1, 'Chanceux'),
	(2, 5, 'Special Forces'),
	(3, 8, 'Merlun');
/*!40000 ALTER TABLE `equipage` ENABLE KEYS */;


-- Dumping structure for procedure dahouet.equipage_regate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `equipage_regate`(IN `coursereg` INT, IN `voiliereg` VARCHAR(50))
BEGIN
declare varcourse int;
select regate.num_course, regate.date_depart, voilier.nom_voilier, equipier.nom_equipier, equipage.id_equipier_skipper
from regate
inner join course on regate.num_course = course.num_course
inner join voilier on course.id_voilier = voilier.id_voilier
inner join equipage on course.id_equipage = equipage.id_equipage
inner join equipe_regate on equipage.id_equipage = equipe_regate.id_equipage
inner join equipier on equipe_regate.id_equipier = equipier.id_equipier
where course.num_course = coursereg and voilier.NOM_VOILIER = voiliereg;
END//
DELIMITER ;


-- Dumping structure for table dahouet.equipe_regate
CREATE TABLE IF NOT EXISTS `equipe_regate` (
  `ID_EQUIPIER` int(11) NOT NULL,
  `ID_EQUIPAGE` int(11) NOT NULL,
  PRIMARY KEY (`ID_EQUIPIER`,`ID_EQUIPAGE`),
  KEY `FK_COMPOSE2` (`ID_EQUIPAGE`),
  CONSTRAINT `FK_COMPOSE` FOREIGN KEY (`ID_EQUIPIER`) REFERENCES `equipier` (`ID_EQUIPIER`),
  CONSTRAINT `FK_COMPOSE2` FOREIGN KEY (`ID_EQUIPAGE`) REFERENCES `equipage` (`ID_EQUIPAGE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.equipe_regate: ~9 rows (approximately)
/*!40000 ALTER TABLE `equipe_regate` DISABLE KEYS */;
INSERT INTO `equipe_regate` (`ID_EQUIPIER`, `ID_EQUIPAGE`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 2),
	(5, 2),
	(6, 2),
	(7, 3),
	(8, 3),
	(9, 3);
/*!40000 ALTER TABLE `equipe_regate` ENABLE KEYS */;


-- Dumping structure for table dahouet.equipier
CREATE TABLE IF NOT EXISTS `equipier` (
  `ID_EQUIPIER` int(11) NOT NULL,
  `NOM_EQUIPIER` varchar(25) NOT NULL,
  `PRENOM_EQUIPIER` varchar(25) NOT NULL,
  `EMAIL_EQUIPIER` varchar(25) NOT NULL,
  `COORDONNEES_EQUIPIER` varchar(50) NOT NULL,
  `ID_LICENCE_FFV` int(11) NOT NULL,
  `POINTS_FFV` double NOT NULL,
  `DATE_OBTENTION_LICENCE` date NOT NULL,
  `DATE_NAISSANCE` date NOT NULL,
  PRIMARY KEY (`ID_EQUIPIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.equipier: ~9 rows (approximately)
/*!40000 ALTER TABLE `equipier` DISABLE KEYS */;
INSERT INTO `equipier` (`ID_EQUIPIER`, `NOM_EQUIPIER`, `PRENOM_EQUIPIER`, `EMAIL_EQUIPIER`, `COORDONNEES_EQUIPIER`, `ID_LICENCE_FFV`, `POINTS_FFV`, `DATE_OBTENTION_LICENCE`, `DATE_NAISSANCE`) VALUES
	(1, 'Plis', 'Frank', '', '3, rue Interior', 43752, 0, '2014-08-25', '1980-03-15'),
	(2, 'Rail', 'Micha', '', '27, rue de la Solitude', 52728, 0, '2015-02-17', '1977-07-28'),
	(3, 'Miro', 'Rachel', '', '17b, La Mineur', 51890, 0, '2015-01-03', '1985-12-02'),
	(4, 'Rivers', 'Robert', '', '55, Jam Street', 35270, 0, '2015-03-20', '1983-04-18'),
	(5, 'Flowers', 'Fanny', '', '18, Licarn Street', 22334, 0, '2015-02-20', '1990-07-30'),
	(6, 'Mklone', 'Tri', '', '60, rue Nosstram', 70203, 0, '2014-10-13', '1979-02-22'),
	(7, 'Dupont', 'Lucas', '', '20, rue La Looser', 66332, 0, '2014-10-05', '1988-10-01'),
	(8, 'Pinne', 'Fili', '', '328, Riverside', 52523, 0, '2015-02-28', '1992-11-16'),
	(9, 'Staint', 'Nicolas', '', '44, rue Misifus', 72456, 0, '2014-12-05', '1982-05-12'),
	(10, 'Princap', 'Julie', 'tyuio@fghot.fgo', '2, La Rue. 67000', 10, 1, '0002-11-30', '0002-11-30'),
	(11, 'Julius', 'Miguel', 'sdffg@ffggh.ffg', '23, Grunt. 23450', 11, 0.7, '2015-03-18', '2015-03-18');
/*!40000 ALTER TABLE `equipier` ENABLE KEYS */;


-- Dumping structure for procedure dahouet.moyenne_distance
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `moyenne_distance`(IN `nomchal` VARCHAR(50))
BEGIN
select course.Num_course, regate.Num_course, regate.id_challenge,
		sum( course.Distance_parcourue) as Distance_Totale,  count(course.Num_course) as Nombre_de_Participants
	from course
	 
	inner join regate on course.Num_course=regate.Num_course
	where course.condition_depart != 'A' and regate.id_challenge = nomchal
group by course.Num_course;
END//
DELIMITER ;


-- Dumping structure for table dahouet.proprietaire
CREATE TABLE IF NOT EXISTS `proprietaire` (
  `ID_PROPRIO` int(11) NOT NULL,
  `NOM_PROPRIO` varchar(25) NOT NULL,
  `PRENOM_PROPRIO` varchar(25) NOT NULL,
  `EMAIL_PROPRIO` varchar(25) NOT NULL,
  `TEL_PROPRIO` varchar(25) NOT NULL,
  `COORDONNEES_PROPRIO` varchar(50) NOT NULL,
  `NOM_CLUB` varchar(25) NOT NULL,
  PRIMARY KEY (`ID_PROPRIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.proprietaire: ~22 rows (approximately)
/*!40000 ALTER TABLE `proprietaire` DISABLE KEYS */;
INSERT INTO `proprietaire` (`ID_PROPRIO`, `NOM_PROPRIO`, `PRENOM_PROPRIO`, `EMAIL_PROPRIO`, `TEL_PROPRIO`, `COORDONNEES_PROPRIO`, `NOM_CLUB`) VALUES
	(1, 'Martin', 'Marcel', 'mm@mm.mm', '0000000', '1, One. 35001', 'YC Val André'),
	(2, 'Letroc', 'Pierre', 'pl@pl.pl', '1111111', '2, Two. 35002', 'YC Val André'),
	(3, 'Le Jay', 'Roger', 'rlj@rlj.rlj', '2222222', '3, Three. 35003', 'YC Le Legué'),
	(4, 'Reyes', 'Pilar', 'pr@pr.pr', '3333333', '4, Four. 35004', 'YC St Malo'),
	(5, 'Conda', 'Anna', 'ac@ac.ac', '4444444', '5, Five. 35005', 'YC La Rochelle'),
	(6, 'Fititus', 'Sport', 'sf@sf.sf', '5555555', '6, Six. 35006', 'YC St Brieuc'),
	(7, 'Moore', 'Michael', 'mimo@mimo.mimo', '6666666', '7, Seven. 35007', 'YC Nice'),
	(8, 'Araignée', 'Toile', 'ta@ta.ta', '7777777', '8, Eight. 35008', 'YC St Malo'),
	(9, 'Mimimi', 'Fififi', 'fm@fm.fm', '8888888', '9, Nine. 35009', 'YC La Rochelle'),
	(10, 'Munchen', 'Peter', 'pm@pm.pm', '9999999', '10, Ten. 35010', 'YC Nice'),
	(11, 'Romualdo', 'Picacho', 'pr@pr.pr', '1010101', '11, Eleven. 35011', 'YC St Brieuc'),
	(12, 'Tompson', 'Regis', 'eeee@eee.ee', '55 55 55 55 55', '2, Grace. 35220', 'YC Alba'),
	(13, 'Track', 'Flick', 'aaaaa@gggg.cc', '44 44 44 44 44', '5, rue Grrrrrr. 25', 'YC Prrrrr'),
	(14, 'Gregarious', 'Loup', 'aaaa@aaaa.aa', '00 00 00 00 00', '19, rue La Liaison. 33000', 'YC Auction'),
	(15, 'Knovac', 'Yolanda', 'rrrr@ttttt.co', '99 99 99 99 99', '45, rue de la Rue. 22000', 'YC La Loire'),
	(16, 'Wolick', 'Graham', 'oooo@oooo.oo', '88 88 88 88 88', '77, La Sept. 77770', 'YC Mineur'),
	(17, 'Grant', 'Selfie', 'eeee@uuuu.co', '66 66 66 66 66', '66, SixtySix. England', 'YC Yorkshire'),
	(18, 'Frag', 'Lire', 'wwww@eeee.fff', '44 44 44 44 44', '67, rue Lance. 55000', 'YC Mineur'),
	(19, 'Klaus', 'Maggie', 'kmag@uoi.com', '09 09 09 09 09', '4, Gruessom. 12700', 'YC Hail'),
	(20, 'Grosse', 'Tulip', 'aaa@ggg.yy', '00 88 77 66 55', '24, rue la Folie. 45000', 'YC Roche'),
	(21, 'Lucas', 'Régis', 'hhh@ttt.rr', '55 66 88 77 44', '19, av De Gaule. 72270', 'YC La Roche'),
	(22, 'Talius', 'Marcus', 'yuo@rfv.hh', '33 54 87 09 21', '23, av De Gaule.35620', 'YC St Malo');
/*!40000 ALTER TABLE `proprietaire` ENABLE KEYS */;


-- Dumping structure for table dahouet.proprio_equipier
CREATE TABLE IF NOT EXISTS `proprio_equipier` (
  `ID_PROPRIO` int(11) NOT NULL,
  `ID_EQUIPIER` int(11) NOT NULL,
  PRIMARY KEY (`ID_PROPRIO`,`ID_EQUIPIER`),
  KEY `FK_PEUT_ETRE2` (`ID_EQUIPIER`),
  CONSTRAINT `FK_PEUT_ETRE` FOREIGN KEY (`ID_PROPRIO`) REFERENCES `proprietaire` (`ID_PROPRIO`),
  CONSTRAINT `FK_PEUT_ETRE2` FOREIGN KEY (`ID_EQUIPIER`) REFERENCES `equipier` (`ID_EQUIPIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.proprio_equipier: ~0 rows (approximately)
/*!40000 ALTER TABLE `proprio_equipier` DISABLE KEYS */;
/*!40000 ALTER TABLE `proprio_equipier` ENABLE KEYS */;


-- Dumping structure for table dahouet.regate
CREATE TABLE IF NOT EXISTS `regate` (
  `NUM_COURSE` int(11) NOT NULL,
  `ID_COMMISSAIRE` int(11) NOT NULL,
  `ID_CHALLENGE` int(11) NOT NULL,
  `ID_COMITE` int(11) NOT NULL,
  `NUM_SERIE_COURSE` int(11) NOT NULL,
  `DATE_DEPART` date NOT NULL,
  `HEURE_DEPART` time NOT NULL,
  `DIRECTION_VENT_DEPART` varchar(3) NOT NULL,
  `INTENSITE_VENT` int(11) NOT NULL,
  `DIRECTION_COURANT` varchar(3) NOT NULL,
  `VITESSE_COURANT` decimal(4,2) NOT NULL,
  `ETAT_MER` varchar(30) NOT NULL,
  `1_BORD` int(11) NOT NULL,
  PRIMARY KEY (`NUM_COURSE`),
  KEY `FK_COMPORTE` (`ID_CHALLENGE`),
  KEY `FK_JUGE` (`ID_COMITE`),
  KEY `FK_PRESIDE` (`ID_COMMISSAIRE`),
  CONSTRAINT `FK_Challenge` FOREIGN KEY (`ID_CHALLENGE`) REFERENCES `challenge` (`ID_CHALLENGE`),
  CONSTRAINT `FK_JUGE` FOREIGN KEY (`ID_COMITE`) REFERENCES `comite` (`ID_COMITE`),
  CONSTRAINT `FK_PRESIDE` FOREIGN KEY (`ID_COMMISSAIRE`) REFERENCES `commissaire` (`ID_COMMISSAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.regate: ~5 rows (approximately)
/*!40000 ALTER TABLE `regate` DISABLE KEYS */;
INSERT INTO `regate` (`NUM_COURSE`, `ID_COMMISSAIRE`, `ID_CHALLENGE`, `ID_COMITE`, `NUM_SERIE_COURSE`, `DATE_DEPART`, `HEURE_DEPART`, `DIRECTION_VENT_DEPART`, `INTENSITE_VENT`, `DIRECTION_COURANT`, `VITESSE_COURANT`, `ETAT_MER`, `1_BORD`) VALUES
	(1, 1, 1, 1, 1, '2015-04-19', '10:00:00', 'NNO', 15, 'SSE', 1.40, 'Calme', 10),
	(2, 2, 1, 2, 2, '2015-04-20', '10:00:00', 'NE', 18, 'SE', 1.70, 'Agitée', 12),
	(3, 3, 1, 3, 3, '2015-04-21', '10:00:00', 'S', 17, 'NE', 1.01, 'Pluie', 13),
	(4, 1, 1, 4, 4, '2015-04-22', '10:00:00', 'N', 16, 'N', 1.55, 'Calme', 14),
	(5, 2, 1, 5, 5, '2015-04-23', '10:00:00', 'E', 14, 'O', 1.22, 'Agitée', 15);
/*!40000 ALTER TABLE `regate` ENABLE KEYS */;


-- Dumping structure for table dahouet.serie
CREATE TABLE IF NOT EXISTS `serie` (
  `ID_SERIE` int(11) NOT NULL,
  `NOM_SERIE` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_SERIE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.serie: ~3 rows (approximately)
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
INSERT INTO `serie` (`ID_SERIE`, `NOM_SERIE`) VALUES
	(0, 'Choisissez'),
	(1, 'Habitables'),
	(2, 'Quillards de sport');
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;


-- Dumping structure for table dahouet.voilier
CREATE TABLE IF NOT EXISTS `voilier` (
  `ID_VOILIER` int(11) NOT NULL,
  `ID_PROPRIO` int(11) NOT NULL,
  `ID_CLASSE` int(11) NOT NULL,
  `NOM_VOILIER` varchar(25) NOT NULL,
  `NUMERO_VOILE` int(11) NOT NULL,
  PRIMARY KEY (`ID_VOILIER`),
  KEY `FK_POSSEDE` (`ID_PROPRIO`),
  KEY `FK_ID_CLASSE` (`ID_CLASSE`),
  CONSTRAINT `FK_ID_CLASSE` FOREIGN KEY (`ID_CLASSE`) REFERENCES `classe` (`ID_CLASSE`),
  CONSTRAINT `FK_POSSEDE` FOREIGN KEY (`ID_PROPRIO`) REFERENCES `proprietaire` (`ID_PROPRIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dahouet.voilier: ~20 rows (approximately)
/*!40000 ALTER TABLE `voilier` DISABLE KEYS */;
INSERT INTO `voilier` (`ID_VOILIER`, `ID_PROPRIO`, `ID_CLASSE`, `NOM_VOILIER`, `NUMERO_VOILE`) VALUES
	(1, 1, 1, 'Lollipop', 22),
	(2, 2, 2, 'Flink', 35),
	(3, 3, 3, 'Stonehedge', 55),
	(4, 4, 4, 'Naufragio', 72),
	(5, 5, 5, 'La Honte', 48),
	(6, 6, 6, 'Retro', 128),
	(7, 7, 7, 'Mitigado', 112),
	(8, 8, 8, 'Rudo', 17),
	(9, 9, 9, 'Galère', 88),
	(10, 10, 10, 'La Loca', 92),
	(11, 11, 11, 'Filigrane', 14),
	(12, 6, 8, 'Fluck', 25),
	(13, 5, 3, 'Regex', 12),
	(14, 5, 8, 'Sickness', 25),
	(15, 5, 9, 'Grand', 11),
	(16, 14, 2, 'Sea Wolf', 27),
	(17, 3, 3, 'Gilligan', 18),
	(18, 22, 10, 'Tahiti Dream', 33),
	(19, 17, 4, 'Riser', 62),
	(20, 12, 4, 'Cain', 23),
	(21, 4, 2, 'Lick', 52);
/*!40000 ALTER TABLE `voilier` ENABLE KEYS */;


-- Dumping structure for trigger dahouet.before_insert_regate
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `before_insert_regate` BEFORE INSERT ON `regate` FOR EACH ROW BEGIN
	declare dateini date;
	declare datefin date;
	declare error condition for sqlstate '45001';
	
	if (new.id_challenge != ("Hiver" or "Eté"))then 
	SIGNAL error
 		set message_text ='Le challenge doit être "Hiver" ou "Eté"', mysql_errno=9000;
	end if;



	select date_challenge_debut into dateini from challenge
		where id_challenge = new.id_challenge;
	select date_challenge_fin into datefin from challenge
		where id_challenge = new.id_challenge;
	if (new.date_depart not between dateini and datefin) then 
	SIGNAL error
 		set message_text ='La régate est en déhors des dates du challenge', mysql_errno=9000;
	end if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Dumping structure for trigger dahouet.course_before_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `course_before_update` BEFORE UPDATE ON `course` FOR EACH ROW BEGIN
	declare error condition for sqlstate '45001';
	declare compte int;
	
 select count(num_course) into compte from course
 where num_course = new.num_course;
 if (new.points > compte) then 
	SIGNAL error
 		set message_text ='La place est supérieur au nombre de participants', mysql_errno=9000;
	end if;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Dumping structure for trigger dahouet.regate_before_delete
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `regate_before_delete` BEFORE DELETE ON `regate` FOR EACH ROW BEGIN
	declare dateini date;
	declare datefin date;
	declare error condition for sqlstate '45001';

	select date_challenge_debut into dateini from challenge
		where id_challenge = old.id_challenge;
	select date_challenge_fin into datefin from challenge
		where id_challenge = old.id_challenge;
	if (old.date_depart between dateini and datefin) then 
	SIGNAL error
 		set message_text ='Le challenge est encore en cours', mysql_errno=9000;
	end if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
