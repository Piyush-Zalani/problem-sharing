CREATE DATABASE mydata;

USE mydata;

CREATE TABLE registeruser(uid INTEGER PRIMARY KEY AUTO_INCREMENT, username VARCHAR(1000) , email VARCHAR(1000), password VARCHAR(256));

CREATE TABLE question(Qid INTEGER PRIMARY KEY AUTO_INCREMENT, questiontag VARCHAR(1000), questiondesc VARCHAR(1000), QuesionDate DATE, USER_ID INTEGER, FOREIGN KEY(USER_ID) REFERENCES registeruser(uid));

CREATE TABLE answer(Aid INTEGER PRIMARY KEY AUTO_INCREMENT, uid INTEGER, Qid INTEGER, description VARCHAR(1000), AnswerTime DATE, 
		CONSTRAINT FK_registeruser_uid FOREIGN KEY FK_registeruser_uid(uid) REFERENCES registeruser(uid));
		
ALTER TABLE answer ADD CONSTRAINT `FK_question_Qid` FOREIGN KEY `FK_question_Qid`(`Qid`)
    REFERENCES `question` (`Qid`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;

