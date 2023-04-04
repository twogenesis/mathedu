-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.32 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- mathedu 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `mathedu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mathedu`;

-- 테이블 mathedu.admin_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `admin_info` (
  `admin_seq` int NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(10) NOT NULL,
  `admin_pwd` varchar(64) NOT NULL,
  `admin_status` int NOT NULL DEFAULT '1',
  `admin_regdt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_seq`),
  UNIQUE KEY `admin_id` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.admin_info:~8 rows (대략적) 내보내기
INSERT INTO `admin_info` (`admin_seq`, `admin_id`, `admin_pwd`, `admin_status`, `admin_regdt`) VALUES
	(1, 'admin', '1234', 2, '2023-03-23 15:48:31'),
	(2, 'adminuser', '4g9CwF3G17sk3kn/7DQTeQ==', 1, '2023-03-27 11:39:24'),
	(3, 'adminuser1', '4g9CwF3G17sk3kn/7DQTeQ==', 1, '2023-03-31 17:50:38'),
	(4, 'adminuser2', '4g9CwF3G17sk3kn/7DQTeQ==', 1, '2023-03-31 17:50:01'),
	(5, 'adminuser3', '4g9CwF3G17sk3kn/7DQTeQ==', 1, '2023-03-31 17:50:01'),
	(6, 'adminuser4', '4g9CwF3G17sk3kn/7DQTeQ==', 1, '2023-03-31 17:50:01'),
	(7, 'adminuser5', '4g9CwF3G17sk3kn/7DQTeQ==', 1, '2023-03-31 17:50:01'),
	(8, 'adminuser6', '4g9CwF3G17sk3kn/7DQTeQ==', 1, '2023-03-31 17:50:01');

-- 테이블 mathedu.bbs_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `bbs_info` (
  `bbs_seq` int NOT NULL AUTO_INCREMENT,
  `bbs_title` varchar(255) NOT NULL,
  `bbs_content` text NOT NULL,
  `bbs_teacher_seq` int NOT NULL,
  `bbs_class_seq` int NOT NULL,
  `bbs_category` varchar(100) DEFAULT NULL,
  `bbs_regdt` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bbs_seq`),
  KEY `bbs_teacher_seq` (`bbs_teacher_seq`),
  KEY `bbs_class_seq` (`bbs_class_seq`),
  CONSTRAINT `bbs_info_ibfk_1` FOREIGN KEY (`bbs_teacher_seq`) REFERENCES `teacher_info` (`teacher_seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bbs_info_ibfk_2` FOREIGN KEY (`bbs_class_seq`) REFERENCES `class_info` (`class_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.bbs_info:~11 rows (대략적) 내보내기
INSERT INTO `bbs_info` (`bbs_seq`, `bbs_title`, `bbs_content`, `bbs_teacher_seq`, `bbs_class_seq`, `bbs_category`, `bbs_regdt`) VALUES
	(1, 'Sample BBS Title444', 'Sample Content', 1, 1, NULL, '2023-03-27 20:30:33'),
	(2, 'Sample BBS Title444', 'Sample Content', 1, 1, NULL, '2023-03-27 20:31:00'),
	(3, 'Sample BBS Title444', 'Sample Content', 1, 1, NULL, '2023-03-27 20:31:25'),
	(4, 'Sample BBS Title444', 'Sample Content', 1, 1, NULL, '2023-03-27 20:31:26'),
	(5, 'Sample BBS Title444', 'Sample Content', 1, 1, NULL, '2023-03-27 20:31:27'),
	(6, 'Sample BBS Title444', 'Sample Content', 1, 1, NULL, '2023-03-27 20:31:28'),
	(7, 'qwetqwtqwtsdgdghdryrey', 'Sample Content', 1, 1, NULL, '2023-03-27 20:31:28'),
	(8, 'Sample BBS Title444', 'Sample Content', 1, 1, NULL, '2023-03-27 20:31:29'),
	(9, 'Sample BBS Title444', 'Sample Content', 1, 1, NULL, '2023-03-27 20:31:30'),
	(10, 'Sample Title', '글의 내용입니다.', 1, 1, NULL, '2023-03-31 15:48:49'),
	(11, 'Sample Title', '글의 내용입니다.', 1, 1, '수업자료', '2023-03-31 15:50:07');

-- 테이블 mathedu.bbs_info_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `bbs_info_file` (
  `bfile_seq` int NOT NULL AUTO_INCREMENT,
  `bfile_name` varchar(255) NOT NULL,
  `bfile_bbs_seq` int NOT NULL,
  PRIMARY KEY (`bfile_seq`),
  KEY `bfile_notice_seq` (`bfile_bbs_seq`),
  CONSTRAINT `bbs_info_file_ibfk_1` FOREIGN KEY (`bfile_bbs_seq`) REFERENCES `bbs_info` (`bbs_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.bbs_info_file:~16 rows (대략적) 내보내기
INSERT INTO `bbs_info_file` (`bfile_seq`, `bfile_name`, `bfile_bbs_seq`) VALUES
	(1, 'cncyni1679916660551.jpg', 2),
	(2, 'sitmwekil1679916660552.jpg', 2),
	(3, 'ohjlip1679916685989.jpg', 3),
	(4, 'zlunid1679916685990.jpg', 3),
	(5, 'tgchklj1679916686718.jpg', 4),
	(6, 'kajxvmz1679916686718.jpg', 4),
	(7, 'znaeam1679916687437.jpg', 5),
	(8, 'abfqgpf1679916687438.jpg', 5),
	(9, 'xxtyoxslsc1679916688102.jpg', 6),
	(10, 'fpxjvnhfyk1679916688104.jpg', 6),
	(11, 'tapcdosqz1679916688849.jpg', 7),
	(12, 'vyfnhritgw1679916688850.jpg', 7),
	(13, 'olzrpfqvvg1679916689500.jpg', 8),
	(14, 'fgrhiwkkjm1679916689501.jpg', 8),
	(15, 'dznnjnrgm1679916690164.jpg', 9),
	(16, 'qtuctvyd1679916690165.jpg', 9);

-- 뷰 mathedu.class_detail_view 구조 내보내기
-- VIEW 종속성 오류를 극복하기 위해 임시 테이블을 생성합니다.
CREATE TABLE `class_detail_view` (
	`seq` INT(10) NULL,
	`title` VARCHAR(20) NULL COLLATE 'utf8mb4_0900_ai_ci',
	`days` VARCHAR(16) NULL COLLATE 'utf8mb4_0900_ai_ci',
	`grade` INT(10) NULL,
	`opendt` DATETIME NULL,
	`closedt` DATETIME NULL,
	`starttime` TIME NULL,
	`endtime` TIME NULL,
	`teacher` VARCHAR(100) NULL COLLATE 'utf8mb4_0900_ai_ci',
	`teacherNo` INT(10) NULL,
	`studentCnt` BIGINT(19) NULL
) ENGINE=MyISAM;

-- 테이블 mathedu.class_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `class_info` (
  `class_seq` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) NOT NULL,
  `class_grade` int NOT NULL,
  `class_days` varchar(16) NOT NULL,
  `class_opendt` datetime NOT NULL,
  `class_closedt` datetime NOT NULL,
  `class_starttime` time NOT NULL,
  `class_endtime` time NOT NULL,
  `class_teacher_seq` int NOT NULL,
  PRIMARY KEY (`class_seq`),
  KEY `class_teacher_seq` (`class_teacher_seq`),
  CONSTRAINT `class_info_ibfk_1` FOREIGN KEY (`class_teacher_seq`) REFERENCES `teacher_info` (`teacher_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.class_info:~8 rows (대략적) 내보내기
INSERT INTO `class_info` (`class_seq`, `class_name`, `class_grade`, `class_days`, `class_opendt`, `class_closedt`, `class_starttime`, `class_endtime`, `class_teacher_seq`) VALUES
	(1, '샘플 반 2', 2, '월, 수, 금', '2023-03-01 00:00:00', '2023-03-31 00:00:00', '18:30:00', '20:30:00', 1),
	(3, '샘플 반 2', 3, '월, 수, 금', '2023-03-01 00:00:00', '2023-03-31 00:00:00', '18:30:00', '20:30:00', 1),
	(4, '샘플 반 2', 4, '월, 수, 금', '2023-03-01 00:00:00', '2023-03-31 00:00:00', '18:30:00', '20:30:00', 1),
	(5, '샘플 반 123123', 4, '월, 수, 금', '2023-03-01 00:00:00', '2023-03-31 00:00:00', '18:30:00', '20:30:00', 1),
	(6, '샘플 반 2123', 3, '월, 수, 금', '2023-03-01 00:00:00', '2023-03-31 00:00:00', '18:30:00', '20:30:00', 1),
	(7, '샘플 반 2223', 1, '월, 수, 금', '2023-03-01 00:00:00', '2023-03-31 00:00:00', '18:30:00', '20:30:00', 1),
	(8, '샘플 반 2223 444 44', 3, '월, 수, 금', '2023-03-01 00:00:00', '2023-03-31 00:00:00', '18:30:00', '20:30:00', 1),
	(9, '샘플 반 2223 444 44', 4, '월, 수, 금', '2023-03-01 00:00:00', '2023-03-31 00:00:00', '18:30:00', '20:30:00', 1);

-- 테이블 mathedu.exam_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `exam_info` (
  `exam_seq` int NOT NULL AUTO_INCREMENT,
  `exam_name` varchar(50) NOT NULL,
  `exam_date` datetime NOT NULL,
  `exam_class_seq` int NOT NULL,
  `exam_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`exam_seq`),
  KEY `exam_class_seq` (`exam_class_seq`),
  CONSTRAINT `exam_info_ibfk_1` FOREIGN KEY (`exam_class_seq`) REFERENCES `class_info` (`class_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.exam_info:~17 rows (대략적) 내보내기
INSERT INTO `exam_info` (`exam_seq`, `exam_name`, `exam_date`, `exam_class_seq`, `exam_type`) VALUES
	(1, '3월 사전지식 평가', '2023-03-03 00:00:00', 1, 'weekly'),
	(2, '3월 2주차 주간 시험', '2023-03-10 00:00:00', 1, 'weekly'),
	(3, '3월 3주차 주간 시험', '2023-03-17 00:00:00', 1, 'weekly'),
	(4, '3월 4주차 주간 시험', '2023-03-24 00:00:00', 1, 'weekly'),
	(5, '3월 월간 시험', '2023-03-31 00:00:00', 1, 'monthly'),
	(6, '3월 입학 평가', '2023-03-03 00:00:00', 3, 'weekly'),
	(7, '3월 2주차 주간 평가', '2023-03-10 00:00:00', 3, 'weekly'),
	(8, '3월 3주차 주간 시험', '2023-03-17 00:00:00', 3, 'weekly'),
	(9, '3월 4주차 주간 시험', '2023-03-24 00:00:00', 3, 'weekly'),
	(10, '3월 월간 시험', '2023-03-31 00:00:00', 3, 'monthly'),
	(11, '4월 월간 시험', '2023-04-30 00:00:00', 3, 'monthly'),
	(12, '1월 월간 시험', '2023-01-31 00:00:00', 3, 'monthly'),
	(13, '2월 월간 시험', '2023-02-28 00:00:00', 3, 'monthly'),
	(14, '12월 월간 시험', '2022-12-29 00:00:00', 3, 'monthly'),
	(15, '1월 월간 시험', '2023-01-31 00:00:00', 1, 'monthly'),
	(16, '2월 월간 시험', '2023-02-28 00:00:00', 1, 'monthly'),
	(17, '11월 월간 시험', '2023-11-28 00:00:00', 1, 'monthly'),
	(18, '11월 월간 시험', '2023-11-28 00:00:00', 3, 'monthly');

-- 뷰 mathedu.exam_list_view 구조 내보내기
-- VIEW 종속성 오류를 극복하기 위해 임시 테이블을 생성합니다.
CREATE TABLE `exam_list_view` (
	`teacherNo` INT(10) NULL,
	`examNo` INT(10) NULL,
	`examName` VARCHAR(50) NULL COLLATE 'utf8mb4_0900_ai_ci',
	`totalStuCount` BIGINT(19) NULL,
	`attendCount` BIGINT(19) NULL,
	`missedCount` BIGINT(19) NULL,
	`avgScore` BIGINT(19) NULL,
	`examDt` DATE NULL,
	`classNo` INT(10) NULL,
	`examType` VARCHAR(10) NULL COLLATE 'utf8mb4_0900_ai_ci'
) ENGINE=MyISAM;

-- 테이블 mathedu.exam_scores 구조 내보내기
CREATE TABLE IF NOT EXISTS `exam_scores` (
  `exscore_seq` int NOT NULL AUTO_INCREMENT,
  `exscore_exam_seq` int NOT NULL,
  `exscore_stu_seq` int NOT NULL,
  `exscore_score` int NOT NULL,
  PRIMARY KEY (`exscore_seq`),
  KEY `exscore_exam_seq` (`exscore_exam_seq`),
  KEY `exscore_stu_seq` (`exscore_stu_seq`),
  CONSTRAINT `exam_scores_ibfk_1` FOREIGN KEY (`exscore_exam_seq`) REFERENCES `exam_info` (`exam_seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `exam_scores_ibfk_2` FOREIGN KEY (`exscore_stu_seq`) REFERENCES `student_info` (`stu_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.exam_scores:~14 rows (대략적) 내보내기
INSERT INTO `exam_scores` (`exscore_seq`, `exscore_exam_seq`, `exscore_stu_seq`, `exscore_score`) VALUES
	(2, 1, 4, 90),
	(3, 1, 5, 90),
	(4, 1, 6, 78),
	(5, 1, 7, 87),
	(6, 1, 9, 92),
	(7, 1, 9, -1),
	(8, 2, 10, 95),
	(9, 2, 4, 95),
	(10, 2, 5, 77),
	(11, 2, 6, 66),
	(12, 2, 7, 42),
	(13, 2, 8, 48),
	(14, 2, 9, 88),
	(15, 5, 7, 95);

-- 뷰 mathedu.exam_score_list_view 구조 내보내기
-- VIEW 종속성 오류를 극복하기 위해 임시 테이블을 생성합니다.
CREATE TABLE `exam_score_list_view` (
	`studentNo` INT(10) NOT NULL,
	`studentName` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`studentId` VARCHAR(8) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`studentImgURL` VARCHAR(269) NULL COLLATE 'utf8mb4_0900_ai_ci',
	`classNo` INT(10) NOT NULL,
	`className` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`examNo` INT(10) NOT NULL,
	`examName` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`examDt` DATETIME NOT NULL,
	`score` INT(10) NULL
) ENGINE=MyISAM;

-- 테이블 mathedu.notice_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice_info` (
  `notice_seq` int NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(255) NOT NULL,
  `notice_content` text NOT NULL,
  `notice_teacher_seq` int NOT NULL,
  `notice_class_seq` int NOT NULL,
  `notice_regdt` datetime DEFAULT CURRENT_TIMESTAMP,
  `notice_category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`notice_seq`),
  KEY `notice_teacher_seq` (`notice_teacher_seq`),
  KEY `notice_class_seq` (`notice_class_seq`),
  CONSTRAINT `notice_info_ibfk_1` FOREIGN KEY (`notice_teacher_seq`) REFERENCES `teacher_info` (`teacher_seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `notice_info_ibfk_2` FOREIGN KEY (`notice_class_seq`) REFERENCES `class_info` (`class_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.notice_info:~5 rows (대략적) 내보내기
INSERT INTO `notice_info` (`notice_seq`, `notice_title`, `notice_content`, `notice_teacher_seq`, `notice_class_seq`, `notice_regdt`, `notice_category`) VALUES
	(5, 'Sample Notice Title', 'Sample Content', 1, 1, '2023-03-27 18:59:59', NULL),
	(7, 'ㅁㄴㅇㅂㅈㅅㅂㅈㅅㅂㅈㅁㄴㅇ', 'Sample Content', 1, 1, '2023-03-27 19:45:44', NULL),
	(8, 'Sample Notice Title222', 'Sample Content', 1, 1, '2023-03-27 19:45:46', NULL),
	(9, 'Sample Notice Title22233', 'Sample Content', 1, 1, '2023-03-27 19:45:48', NULL),
	(10, 'Sample Notice Title444', 'Sample Content', 1, 1, '2023-03-27 19:45:51', NULL);

-- 테이블 mathedu.notice_info_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice_info_file` (
  `nfile_seq` int NOT NULL AUTO_INCREMENT,
  `nfile_name` varchar(255) NOT NULL,
  `nfile_notice_seq` int NOT NULL,
  PRIMARY KEY (`nfile_seq`),
  KEY `nfile_notice_seq` (`nfile_notice_seq`),
  CONSTRAINT `notice_info_file_ibfk_1` FOREIGN KEY (`nfile_notice_seq`) REFERENCES `notice_info` (`notice_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.notice_info_file:~10 rows (대략적) 내보내기
INSERT INTO `notice_info_file` (`nfile_seq`, `nfile_name`, `nfile_notice_seq`) VALUES
	(5, 'dferpl1679910023734.jpg', 5),
	(6, 'wesnki1679910023743.jpg', 5),
	(9, 'hhojihzk1679913944204.jpg', 7),
	(10, 'wwomjfnqi1679913944206.jpg', 7),
	(11, 'wxlrvvqiii1679913946658.jpg', 8),
	(12, 'cjxfdekuvd1679913946659.jpg', 8),
	(13, 'zumglccnpm1679913948028.jpg', 9),
	(14, 'lzdhtk1679913948029.jpg', 9),
	(15, 'siofizc1679913951049.jpg', 10),
	(16, 'vplquyycb1679913951050.jpg', 10);

-- 테이블 mathedu.school_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `school_info` (
  `school_seq` int NOT NULL AUTO_INCREMENT,
  `school_name` varchar(20) NOT NULL,
  PRIMARY KEY (`school_seq`),
  UNIQUE KEY `school_name` (`school_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.school_info:~0 rows (대략적) 내보내기
INSERT INTO `school_info` (`school_seq`, `school_name`) VALUES
	(1, '그린초등학교');

-- 테이블 mathedu.student_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `student_info` (
  `stu_seq` int NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(8) NOT NULL,
  `stu_pwd` varchar(64) NOT NULL,
  `stu_birth_year` int NOT NULL,
  `stu_birth_month` int NOT NULL,
  `stu_birth_date` int NOT NULL,
  `stu_school_seq` int NOT NULL,
  `stu_grade` int NOT NULL,
  `stu_phone` varchar(16) DEFAULT NULL,
  `stu_alternate_phone` varchar(16) NOT NULL,
  `stu_image` varchar(255) DEFAULT 'default.jpg',
  `stu_regdt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `stu_name` varchar(30) NOT NULL,
  `stu_class_seq` int DEFAULT NULL,
  `stu_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stu_seq`),
  UNIQUE KEY `stu_id` (`stu_id`),
  KEY `stu_school_seq` (`stu_school_seq`),
  KEY `student_info_FK` (`stu_class_seq`),
  CONSTRAINT `student_info_FK` FOREIGN KEY (`stu_class_seq`) REFERENCES `class_info` (`class_seq`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `student_info_ibfk_1` FOREIGN KEY (`stu_school_seq`) REFERENCES `school_info` (`school_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.student_info:~9 rows (대략적) 내보내기
INSERT INTO `student_info` (`stu_seq`, `stu_id`, `stu_pwd`, `stu_birth_year`, `stu_birth_month`, `stu_birth_date`, `stu_school_seq`, `stu_grade`, `stu_phone`, `stu_alternate_phone`, `stu_image`, `stu_regdt`, `stu_name`, `stu_class_seq`, `stu_address`) VALUES
	(3, '23030002', '4g9CwF3G17sk3kn/7DQTeQ==', 2014, 3, 22, 1, 3, '010-1234-5678', '010-2367-4956', 'wfeaasd1679974385978.jpg', '2023-03-28 12:33:05', 'SampleStudent', 1, NULL),
	(4, '23030003', '4g9CwF3G17sk3kn/7DQTeQ==', 2014, 3, 22, 1, 3, '010-1234-5678', '010-2367-4956', 'tnrrxaxse1679974390266.jpg', '2023-03-28 12:33:10', 'SampleStudent', 1, NULL),
	(5, '23030004', '4g9CwF3G17sk3kn/7DQTeQ==', 2014, 3, 22, 1, 3, '010-1234-5678', '010-2367-4956', 'upobtcza1679975011028.jpg', '2023-03-28 12:43:31', 'SampleStudent', 1, NULL),
	(6, '23030005', '4g9CwF3G17sk3kn/7DQTeQ==', 2014, 3, 22, 1, 3, '010-1234-5678', '010-2367-4956', 'vttlykxogg1679975017107.jpg', '2023-03-28 12:43:37', 'SampleStudent', 1, NULL),
	(7, '23030006', '4g9CwF3G17sk3kn/7DQTeQ==', 2014, 3, 22, 1, 3, '010-1234-5678', '010-2367-4956', 'yrnarcqj1679975020030.jpg', '2023-03-28 12:43:40', 'SampleStudent', 1, NULL),
	(8, '23030007', '4g9CwF3G17sk3kn/7DQTeQ==', 2014, 3, 22, 1, 3, '010-1234-5678', '010-2367-4956', 'inrvcubsbg1679975022679.jpg', '2023-03-28 12:43:42', 'SampleStudent', 1, NULL),
	(9, '23030008', '4g9CwF3G17sk3kn/7DQTeQ==', 2014, 3, 22, 1, 3, '010-1234-5678', '010-2367-4956', 'riiffp1679975025467.jpg', '2023-03-28 12:43:45', 'SampleStudent', 1, NULL),
	(10, '23030009', '4g9CwF3G17sk3kn/7DQTeQ==', 2014, 3, 22, 1, 3, '010-1234-5678', '010-2367-4956', 'hitlldmck1679977062507.jpg', '2023-03-28 13:17:42', 'SampleStudent', 1, '대구광역시 중구 중앙대로 394'),
	(11, '23030010', 'Qcd+bLXE8i96zPBdSi/T+qyb+NXCHZhdo2+DDfLqAOQ=', 2014, 3, 1, 1, 3, '010-1234-5678', '010-3254-4423', 'adgwehsdh3124.jpg', '2023-04-03 20:56:11', '김학생', 1, '대구광역시 중구 중앙대로 394');

-- 테이블 mathedu.teacher_class_conn 구조 내보내기
CREATE TABLE IF NOT EXISTS `teacher_class_conn` (
  `tcc_seq` int NOT NULL AUTO_INCREMENT,
  `tcc_teacher_seq` int DEFAULT NULL,
  `tcc_class_seq` int NOT NULL,
  PRIMARY KEY (`tcc_seq`),
  KEY `tcc_teacher_seq` (`tcc_teacher_seq`),
  KEY `tcc_class_seq` (`tcc_class_seq`),
  CONSTRAINT `teacher_class_conn_ibfk_1` FOREIGN KEY (`tcc_teacher_seq`) REFERENCES `teacher_info` (`teacher_seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_class_conn_ibfk_2` FOREIGN KEY (`tcc_class_seq`) REFERENCES `class_info` (`class_seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.teacher_class_conn:~2 rows (대략적) 내보내기
INSERT INTO `teacher_class_conn` (`tcc_seq`, `tcc_teacher_seq`, `tcc_class_seq`) VALUES
	(1, 1, 1),
	(2, 1, 3);

-- 테이블 mathedu.teacher_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `teacher_info` (
  `teacher_seq` int NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(10) NOT NULL,
  `teacher_pwd` varchar(64) NOT NULL,
  `teacher_img` varchar(255) NOT NULL DEFAULT 'default.jpg',
  `teacher_status` int NOT NULL DEFAULT '1',
  `teacher_regdt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `teacher_name` varchar(100) NOT NULL,
  PRIMARY KEY (`teacher_seq`),
  UNIQUE KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mathedu.teacher_info:~5 rows (대략적) 내보내기
INSERT INTO `teacher_info` (`teacher_seq`, `teacher_id`, `teacher_pwd`, `teacher_img`, `teacher_status`, `teacher_regdt`, `teacher_name`) VALUES
	(1, 'teacher1', '4g9CwF3G17sk3kn/7DQTeQ==', 'keqqmzx1679895068090.jpg', 1, '2023-03-27 12:50:20', '하니'),
	(3, 'teacher3', '4g9CwF3G17sk3kn/7DQTeQ==', 'ttknrwnwuw1679893759912.jpg', 1, '2023-03-27 14:09:19', '곽두팔'),
	(4, 'teacher4', '4g9CwF3G17sk3kn/7DQTeQ==', 'larcklgesm1679893821851.jpg', 1, '2023-03-27 14:10:21', '계두식'),
	(5, 'teacher5', '4g9CwF3G17sk3kn/7DQTeQ==', 'mhfbfsu1680163514010.jpg', 1, '2023-03-30 17:05:14', '계두식'),
	(6, 'teacher6', '4g9CwF3G17sk3kn/7DQTeQ==', 'allhjxpjin1680163537225.jpg', 1, '2023-03-30 17:05:37', '황덕배');

-- 뷰 mathedu.top30pcntview 구조 내보내기
-- VIEW 종속성 오류를 극복하기 위해 임시 테이블을 생성합니다.
CREATE TABLE `top30pcntview` (
	`examNo` INT(10) NOT NULL,
	`top30pCnt` DECIMAL(22,0) NOT NULL,
	`exam_date` DATETIME NOT NULL
) ENGINE=MyISAM;

-- 뷰 mathedu.class_detail_view 구조 내보내기
-- 임시 테이블을 제거하고 최종 VIEW 구조를 생성
DROP TABLE IF EXISTS `class_detail_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `class_detail_view` AS select `a`.`class_seq` AS `seq`,`a`.`class_name` AS `title`,`a`.`class_days` AS `days`,`a`.`class_grade` AS `grade`,`a`.`class_opendt` AS `opendt`,`a`.`class_closedt` AS `closedt`,`a`.`class_starttime` AS `starttime`,`a`.`class_endtime` AS `endtime`,`b`.`teacher_name` AS `teacher`,`b`.`teacher_seq` AS `teacherNo`,(select count(0) from `student_info` where (`student_info`.`stu_class_seq` = `a`.`class_seq`)) AS `studentCnt` from (`class_info` `a` left join `teacher_info` `b` on((`a`.`class_teacher_seq` = `b`.`teacher_seq`)));

-- 뷰 mathedu.exam_list_view 구조 내보내기
-- 임시 테이블을 제거하고 최종 VIEW 구조를 생성
DROP TABLE IF EXISTS `exam_list_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `exam_list_view` AS select `c`.`class_teacher_seq` AS `teacherNo`,`c`.`exam_seq` AS `examNo`,`c`.`exam_name` AS `examName`,`c`.`totalStuCount` AS `totalStuCount`,`c`.`attendCount` AS `attendCount`,(`c`.`totalStuCount` - `c`.`attendCount`) AS `missedCount`,`c`.`avgScore` AS `avgScore`,cast(`c`.`exam_date` as date) AS `examDt`,`c`.`class_seq` AS `classNo`,`c`.`exam_type` AS `examType` from (select `a`.`exam_seq` AS `exam_seq`,`a`.`exam_name` AS `exam_name`,`a`.`exam_date` AS `exam_date`,`a`.`exam_class_seq` AS `exam_class_seq`,`a`.`exam_type` AS `exam_type`,`b`.`class_seq` AS `class_seq`,`b`.`class_name` AS `class_name`,`b`.`class_grade` AS `class_grade`,`b`.`class_days` AS `class_days`,`b`.`class_opendt` AS `class_opendt`,`b`.`class_closedt` AS `class_closedt`,`b`.`class_starttime` AS `class_starttime`,`b`.`class_endtime` AS `class_endtime`,`b`.`class_teacher_seq` AS `class_teacher_seq`,(select count(0) from `exam_scores` where ((`exam_scores`.`exscore_exam_seq` = `a`.`exam_seq`) and (`exam_scores`.`exscore_score` >= 0))) AS `attendCount`,(select count(0) from `student_info` where (`student_info`.`stu_class_seq` = `b`.`class_seq`)) AS `totalStuCount`,(select ifnull(floor(avg(`exam_scores`.`exscore_score`)),0) from `exam_scores` where ((`exam_scores`.`exscore_exam_seq` = `a`.`exam_seq`) and (`exam_scores`.`exscore_score` >= 0))) AS `avgScore` from (`exam_info` `a` join `class_info` `b` on((`a`.`exam_class_seq` = `b`.`class_seq`)))) `c`;

-- 뷰 mathedu.exam_score_list_view 구조 내보내기
-- 임시 테이블을 제거하고 최종 VIEW 구조를 생성
DROP TABLE IF EXISTS `exam_score_list_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `exam_score_list_view` AS select `e`.`studentNo` AS `studentNo`,`e`.`studentName` AS `studentName`,`e`.`studentId` AS `studentId`,`e`.`studentImgURL` AS `studentImgURL`,`e`.`classNo` AS `classNo`,`e`.`className` AS `className`,`e`.`examNo` AS `examNo`,`e`.`examName` AS `examName`,`e`.`examDt` AS `examDt`,`e`.`score` AS `score` from (select `a`.`stu_seq` AS `studentNo`,`a`.`stu_name` AS `studentName`,`a`.`stu_id` AS `studentId`,concat('/file/student/',`a`.`stu_image`) AS `studentImgURL`,`b`.`class_seq` AS `classNo`,`b`.`class_name` AS `className`,`c`.`exam_seq` AS `examNo`,`c`.`exam_name` AS `examName`,`c`.`exam_date` AS `examDt`,`d`.`exscore_score` AS `score` from (((`student_info` `a` join `class_info` `b` on((`a`.`stu_class_seq` = `b`.`class_seq`))) join `exam_info` `c` on((`b`.`class_seq` = `c`.`exam_class_seq`))) left join `exam_scores` `d` on((`a`.`stu_seq` = `d`.`exscore_stu_seq`)))) `e`;

-- 뷰 mathedu.top30pcntview 구조 내보내기
-- 임시 테이블을 제거하고 최종 VIEW 구조를 생성
DROP TABLE IF EXISTS `top30pcntview`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `top30pcntview` AS select `a`.`examNo` AS `examNo`,`a`.`top30pCnt` AS `top30pCnt`,`b`.`exam_date` AS `exam_date` from ((select `a`.`exscore_exam_seq` AS `examNo`,ceiling((count(0) * 0.3)) AS `top30pCnt` from (`exam_scores` `a` join `exam_info` `b` on((`a`.`exscore_exam_seq` = `b`.`exam_seq`))) where (`a`.`exscore_score` >= 0) group by `a`.`exscore_exam_seq`) `a` join `exam_info` `b` on((`a`.`examNo` = `b`.`exam_seq`))) where `a`.`examNo` in (select `a`.`exscore_exam_seq` from (`exam_scores` `a` join `student_info` `b` on((`a`.`exscore_stu_seq` = `b`.`stu_seq`))));

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
