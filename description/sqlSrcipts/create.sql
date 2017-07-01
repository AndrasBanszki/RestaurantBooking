CREATE DATABASE `restaurant` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

CREATE TABLE `book_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NOT NULL,
  `table_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_time` datetime NOT NULL,
  `long` int(11) NOT NULL,
  `number_of_people` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `restaurant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `city_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number_of_seats` int(11) NOT NULL,
  `restaurant_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `restaurant`.`city` (`name`) VALUES ('Budapest');
INSERT INTO `restaurant`.`city` (`name`) VALUES ('Nyíregyháza');
INSERT INTO `restaurant`.`city` (`name`) VALUES ('Debrecen');

INSERT INTO `restaurant`.`restaurant` (`name`,`city_id`) VALUES ('Rozsdás Rákolló', 1);
INSERT INTO `restaurant`.`restaurant` (`name`,`city_id`) VALUES ('Gödör', 1);
INSERT INTO `restaurant`.`restaurant` (`name`,`city_id`) VALUES ('Arany Patkó', 1);
INSERT INTO `restaurant`.`restaurant` (`name`,`city_id`) VALUES ('France Riviéra', 2);
INSERT INTO `restaurant`.`restaurant` (`name`,`city_id`) VALUES ('Tirpák Falatozó', 2);
INSERT INTO `restaurant`.`restaurant` (`name`,`city_id`) VALUES ('Blaháné étterem', 3);

INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 1);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 1);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 1);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 1);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 1);

INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 2);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 2);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 2);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (3, 2);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (3, 2);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (3, 2);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 2);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 2);

INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 3);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (3, 3);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (3, 3);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (3, 3);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (3, 3);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 3);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 3);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 3);

INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (6, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (6, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 4);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 4);

INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (4, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 5);
INSERT INTO `restaurant`.`table` (`number_of_seats`, `restaurant_id`) VALUES (2, 5);
