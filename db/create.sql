-- RESET:
DROP DATABASE `coursecritics`;

-- MySQL Script generated by MySQL Workbench
-- Wed Feb 21 10:21:12 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema coursecritics
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema coursecritics
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `coursecritics` DEFAULT CHARACTER SET utf8 ;
USE `coursecritics` ;

-- -----------------------------------------------------
-- Table `coursecritics`.`school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coursecritics`.`school` (
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coursecritics`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coursecritics`.`course` (
  `name` VARCHAR(255) NOT NULL,
  `school_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `fk_course_school_idx` (`school_name` ASC),
  CONSTRAINT `fk_course_school`
    FOREIGN KEY (`school_name`)
    REFERENCES `coursecritics`.`school` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coursecritics`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coursecritics`.`user` (
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coursecritics`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coursecritics`.`review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(255) NOT NULL,
  `user_username` VARCHAR(255) NOT NULL,
  `quality` INT NULL,
  `relevance` INT NULL,
  `difficulty` INT NULL,
  `teaching` INT NULL,
  `comment` VARCHAR(500) NULL,
  `program` VARCHAR(255) NULL,
  `lectures_required` TINYINT NULL,
  `book_required` TINYINT NULL,
  `group_work` TINYINT NULL,
  `time_spent` INT NULL,
  INDEX `fk_review_user1_idx` (`user_username` ASC),
  INDEX `fk_review_course1_idx` (`course_name` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_username`)
    REFERENCES `coursecritics`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_course1`
    FOREIGN KEY (`course_name`)
    REFERENCES `coursecritics`.`course` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




-- INSERT EXAMPLE DATA
-- SCHOOLS
INSERT INTO school (name) VALUES ("Kungliga Tekniska Högskolan");
INSERT INTO school (name) VALUES ("Lunds Universitet");
INSERT INTO school (name) VALUES ("Linköpings Universitet");
INSERT INTO school (name) VALUES ("Kungliga Konsthögskolan");
INSERT INTO school (name) VALUES ("Karolinska Institutet");
INSERT INTO school (name) VALUES ("Luleå Tekniska Universitet");
INSERT INTO school (name) VALUES ("Mittuniversitetet");
INSERT INTO school (name) VALUES ("Linnéuniversitetet");
INSERT INTO school (name) VALUES ("Karlstads Universitet");
INSERT INTO school (name) VALUES ("Uppsala Universitet");

-- COURSES
INSERT INTO course (name, school_name) VALUES ("ID1001 Network Engineering", "Kungliga Tekniska Högskolan");
INSERT INTO course (name, school_name) VALUES ("IX1313 Algebra", "Kungliga Tekniska Högskolan");
INSERT INTO course (name, school_name) VALUES ("ID1010 Database Management", "Kungliga Tekniska Högskolan");
INSERT INTO course (name, school_name) VALUES ("ID9020 Programming I", "Kungliga Tekniska Högskolan");
INSERT INTO course (name, school_name) VALUES ("LI2010 Physiology I", "Lunds Universitet");
INSERT INTO course (name, school_name) VALUES ("LT1242 French, Basic Course", "Lunds Universitet");
INSERT INTO course (name, school_name) VALUES ("CI1100 Chemistry: General Chemistry", "Linköpings Universitet");
INSERT INTO course (name, school_name) VALUES ("LS1302 Discrete Mathematics", "Linköpings Universitet");
INSERT INTO course (name, school_name) VALUES ("AB1020 Art History", "Kungliga Konsthögskolan");
INSERT INTO course (name, school_name) VALUES ("II1085 Medicine History", "Karolinska Institutet");
INSERT INTO course (name, school_name) VALUES ("LO6043 Medical Acupuncture", "Karolinska Institutet");
INSERT INTO course (name, school_name) VALUES ("LT9021 Physics II", "Luleå Tekniska Universitet");
INSERT INTO course (name, school_name) VALUES ("TR1503 Mathematical Analytics", "Luleå Tekniska Universitet");
INSERT INTO course (name, school_name) VALUES ("YY7050 Economics I", "Mittuniversitetet");
INSERT INTO course (name, school_name) VALUES ("BY1020 Evolutionary Theories", "Linnéuniversitetet");
INSERT INTO course (name, school_name) VALUES ("LU7304 Science History", "Linnéuniversitetet");
INSERT INTO course (name, school_name) VALUES ("PO1401 Teaching Ethics", "Karlstads Universitet");
INSERT INTO course (name, school_name) VALUES ("KU7643 Roman History I", "Karlstads Universitet");
INSERT INTO course (name, school_name) VALUES ("KI1213 Swedish History I", "Karlstads Universitet");
INSERT INTO course (name, school_name) VALUES ("UI4040 Basic Biology", "Uppsala Universitet");
INSERT INTO course (name, school_name) VALUES ("UI4020 Basic Chemistry", "Uppsala Universitet");

-- USERS
INSERT INTO user (username, password) VALUES ("bowie", "bowie");
INSERT INTO user (username, password) VALUES ("jack27", "jack27");
INSERT INTO user (username, password) VALUES ("john41", "john41");
INSERT INTO user (username, password) VALUES ("ben42", "ben42");
INSERT INTO user (username, password) VALUES ("lisa12", "lisa12");
INSERT INTO user (username, password) VALUES ("amanda9", "amanda9");
INSERT INTO user (username, password) VALUES ("daisy70", "daisy70");
INSERT INTO user (username, password) VALUES ("nora5", "nora5");
INSERT INTO user (username, password) VALUES ("bob1", "bob1");
INSERT INTO user (username, password) VALUES ("lena3", "lena3");

-- REVIEWS
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID1001 Network Engineering", "jack27", "2", "5", "3", "2", "Very relevant course, dissapointed with the teaching...", "COMP09", "1", "0", "1", "19");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID1001 Network Engineering", "john41", "4", "2", "1", "4", "Fun, challenging course.", "NETT09", "1", "0", "1", "20");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID1001 Network Engineering", "ben42", "4", "3", "2", "3", "Great course. I didn´t like the lectures.", "IQIQ15", "0", "1", "1", "10");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("IX1313 Algebra", "jack27", "3", "1", "5", "4", "Very relevant course.", "COMP09", "0", "0", "1", "24");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("IX1313 Algebra", "lisa12", "2", "3", "2", "1", "I hated the course.", "COMP09", "1", "0", "0", "18");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("IX1313 Algebra", "amanda9", "4", "4", "4", "5", "I LOVED the course!!!", "COMP09", "0", "1", "0", "21");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID1010 Database Management", "amanda9", "2", "5", "4", "3", "Very relevant and difficult course.", "IQIQ15", "1", "1", "1", "23");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID1010 Database Management", "daisy70", "3", "3", "5", "2", "Very difficult", "NETT09", "1", "0", "1", "24");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID1010 Database Management", "nora5", "3", "1", "2", "4", "Great teachers.", "COMP09", "1", "0", "1", "22");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID9020 Programming I", "amanda9", "4", "3", "1", "2", "Very easy course.", "COMP11", "0", "0", "0", "23");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID9020 Programming I", "john41", "3", "5", "3", "4", "Good course. Worth taking!", "IQIQ15", "0", "1", "0", "10");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("ID9020 Programming I", "jack27", "5", "4", "3", "2", "OK.", "NETT09", "1", "1", "1", "16");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LI2010 Physiology I", "ben42", "4", "3", "3", "3", "I found the course interesting", "COMP09", "1", "1", "1", "18");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LI2010 Physiology I", "lisa12", "4", "2", "3", "5", "Not that relevant course. But the teaching was great!", "IQIQ15", "0", "1", "1", "27");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LI2010 Physiology I", "daisy70", "5", "2", "4", "3", "Liked it.", "IQIQ15", "0", "1", "1", "30");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LT1242 French, Basic Course", "ben42", "5", "3", "2", "4", "Great teachers!", "COMP09", "1", "0", "0", "22");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LT1242 French, Basic Course", "amanda9", "4", "3", "5", "3", "Good course.", "COMP11", "1", "0", "0", "10");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LT1242 French, Basic Course", "john41", "3", "3", "3", "5", "Uninteresting course. Awesome teaching.", "NETT09", "0", "0", "1", "23");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("CI1100 Chemistry: General Chemistry", "jack27", "5", "5", "5", "5", "5+++", "IQIQ15", "0", "0", "1", "21");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("CI1100 Chemistry: General Chemistry", "lisa12", "3", "4", "2", "4", "Do it!", "IQIQ15", "0", "0", "1", "16");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("CI1100 Chemistry: General Chemistry", "daisy70", "3", "4", "4", "3", "Difficult.", "COMP09", "0", "1", "1", "16");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LS1302 Discrete Mathematics", "daisy70", "4", "3", "1", "3", "Easy!", "COMP09", "1", "0", "1", "22");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LS1302 Discrete Mathematics", "bob1", "3", "5", "4", "3", "VERY relevant!", "IQIQ15", "1", "0", "0", "10");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LS1302 Discrete Mathematics", "nora5", "5", "4", "3", "5", "This was great! A PERFECT course!", "NETT09", "1", "0", "0", "27");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LS1302 Discrete Mathematics", "lisa12", "3", "4", "2", "3", "Not good. Not bad. meh.", "IQIQ15", "1", "1", "1", "22");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("AB1020 Art History", "john41", "4", "3", "4", "3", "Worth doing.", "TECH13", "0", "0", "1", "30");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("AB1020 Art History", "jack27", "4", "3", "1", "3", "Very easy course.", "NETT09", "0", "0", "1", "10");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("II1085 Medicine History", "ben42", "4", "3", "2", "3", "Not too difficult.", "IQIQ15", "1", "1", "1", "23");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("II1085 Medicine History", "daisy70", "1", "1", "3", "2", "Not worth doing.", "COMP09", "1", "1", "1", "15");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LO6043 Medical Acupuncture", "bob1", "4", "3", "4", "3", "Very interesting.", "COMP11", "1", "0", "0", "27");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LO6043 Medical Acupuncture", "nora5", "4", "5", "3", "2", "Fascinating theories.", "COMP09", "0", "0", "0", "16");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LO6043 Medical Acupuncture", "amanda9", "5", "4", "3", "4", "GREAT!!!", "IQIQ15", "0", "1", "0", "15");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LT9021 Physics II", "jack27", "2", "2", "5", "3", "Don´t do it if you don´t have to!", "MEDI10", "1", "0", "0", "21");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LT9021 Physics II", "john41", "3", "2", "4", "3", "Tough course.", "NETT09", "1", "1", "1", "16");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("TR1503 Mathematical Analytics", "daisy70", "2", "1", "5", "1", "I HATE math. I failed this. Twice.", "IQIQ15", "1", "0", "1", "15");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("TR1503 Mathematical Analytics", "bob1", "3", "2", "4", "2", "Not that relevant.", "MEDI10", "1", "1", "1", "30");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("YY7050 Economics I", "ben42", "4", "4", "3", "5", "Great teaching and great course.", "COMP09", "0", "0", "1", "27");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("YY7050 Economics I", "nora5", "5", "5", "2", "5", "Awesome!", "TECH13", "0", "1", "1", "20");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("BY1020 Evolutionary Theories", "jack27", "4", "3", "2", "3", "Not that difficult. Very interesting.", "NETT09", "0", "0", "0", "18");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("BY1020 Evolutionary Theories", "bob1", "3", "4", "2", "4", "This was good! Had alot of interesting discussions.", "IQIQ15", "0", "1", "0", "22");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("BY1020 Evolutionary Theories", "john41", "4", "5", "2", "3", "Loved it.", "MEDI10", "1", "0", "0", "16");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LU7304 Science History", "nora5", "2", "1", "4", "3", "This was just boring.", "COMP09", "1", "0", "0", "23");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("LU7304 Science History", "amanda9", "3", "2", "3", "2", "Skip it if you can.", "COMP09", "1", "1", "1", "18");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("PO1401 Teaching Ethics", "ben42", "4", "3", "2", "4", "Liked it! Can recommend.", "MEDI10", "0", "1", "1", "16");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("PO1401 Teaching Ethics", "jack27", "4", "2", "4", "4", "Not that relevant.", "NETT09", "0", "0", "1", "16");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("PO1401 Teaching Ethics", "nora5", "5", "3", "4", "2", "Good course. Not relevant though.", "COMP09", "0", "0", "1", "21");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("KU7643 Roman History I", "lena3", "4", "3", "5", "2", "I found it very difficult.", "MEDI10", "1", "1", "0", "20");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("KU7643 Roman History I", "bob1", "5", "5", "3", "5", "I really liked it.", "COMP11", "1", "0", "0", "30");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("KU7643 Roman History I", "nora5", "4", "4", "3", "4", "Great course if you´re into history.", "MEDI10", "1", "0", "0", "21");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("KI1213 Swedish History I", "amanda9", "4", "5", "3", "4", "Lots of kings and wars. Interesting!", "NETT09", "0", "0", "1", "20");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("KI1213 Swedish History I", "john41", "3", "2", "3", "3", "Not my thing.", "COMP09", "1", "1", "1", "24");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("KI1213 Swedish History I", "jack27", "5", "3", "4", "4", "Good course.", "MEDI10", "1", "1", "1", "18");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("UI4040 Basic Biology", "amanda9", "4", "3", "5", "3", "Very difficult, but felt relevant and interesting.", "COMP09", "0", "1", "1", "23");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("UI4040 Basic Biology", "ben42", "4", "2", "4", "3", "I don´t think it was very relevant.", "NETT09", "0", "0", "0", "22");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("UI4040 Basic Biology", "nora5", "4", "3", "2", "1", "I didn´t like the teaching.", "MEDI10", "0", "0", "0", "24");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("UI4020 Basic Chemistry", "amanda9", "2", "4", "3", "2", "OK.", "MEDI10", "1", "1", "0", "23");
INSERT INTO review (course_name, user_username, quality, relevance, difficulty, teaching, comment, program, lectures_required, book_required, group_work, time_spent)
VALUES ("UI4020 Basic Chemistry", "nora5", "3", "4", "3", "3", "It was worth doing.", "NETT09", "1", "0", "1", "10");


