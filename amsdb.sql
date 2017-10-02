-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2016 at 08:16 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `amsdb`
--
CREATE DATABASE IF NOT EXISTS `amsdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `amsdb`;

-- --------------------------------------------------------

--
-- Table structure for table `tblassignment`
--

DROP TABLE IF EXISTS `tblassignment`;
CREATE TABLE IF NOT EXISTS `tblassignment` (
  `assignmentid` int(11) NOT NULL,
  `assignment_name` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `moduleid` int(11) NOT NULL,
  `duedate` datetime NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`assignmentid`),
  KEY `assignmentfkmoduleid_idx` (`moduleid`),
  KEY `assignmentfkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblassignment`
--

INSERT INTO `tblassignment` (`assignmentid`, `assignment_name`, `description`, `moduleid`, `duedate`, `userid`) VALUES
(1, 'Java Assignment', 'Implement an application using java', 1, '2016-07-08 12:00:00', 1),
(2, 'C# Assignment', 'Build an app using C#', 3, '2016-07-08 12:00:00', 1),
(3, 'AOP Report', 'Report about Aspect Oriented Programming', 1, '2016-07-08 12:00:00', 1),
(4, 'ASP.NET Assignment', 'Build a web application', 2, '2016-07-08 12:00:00', 1),
(5, 'Java Assignement 2', 'Enhance java application', 1, '2016-07-08 12:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblattendance`
--

DROP TABLE IF EXISTS `tblattendance`;
CREATE TABLE IF NOT EXISTS `tblattendance` (
  `studentid` int(11) NOT NULL,
  `lectureid` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`studentid`,`lectureid`),
  KEY `attendancefkstudentid_idx` (`studentid`),
  KEY `attendancefklectureid_idx` (`lectureid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblattendance`
--

INSERT INTO `tblattendance` (`studentid`, `lectureid`, `time`, `userid`) VALUES
(1001, 1, '2016-07-29 08:30:00', 1),
(1001, 3, '2016-07-29 10:00:00', 1),
(1002, 1, '2016-07-29 08:30:00', 1),
(1003, 2, '2016-07-29 09:30:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblbatch`
--

DROP TABLE IF EXISTS `tblbatch`;
CREATE TABLE IF NOT EXISTS `tblbatch` (
  `batchid` int(11) NOT NULL,
  `batch_name` varchar(50) NOT NULL,
  `startdate` datetime NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`batchid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblbatch`
--

INSERT INTO `tblbatch` (`batchid`, `batch_name`, `startdate`, `userid`) VALUES
(1, 'Bsc IT 1', '2016-06-17 00:00:00', 1),
(2, 'BSc Computer', '2016-07-14 00:00:00', 1),
(3, 'MSc Trump 1', '2016-08-03 00:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblclassroom`
--

DROP TABLE IF EXISTS `tblclassroom`;
CREATE TABLE IF NOT EXISTS `tblclassroom` (
  `classroomid` int(11) NOT NULL,
  `room_name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`classroomid`),
  KEY `classroomfkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblclassroom`
--

INSERT INTO `tblclassroom` (`classroomid`, `room_name`, `description`, `userid`) VALUES
(1, 'Lab - 01', 'Windows Lab', 1),
(2, 'Lab - 02', 'Linux Lab', 1),
(3, 'Lab - 03', 'Lab for Networking', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblcourse`
--

DROP TABLE IF EXISTS `tblcourse`;
CREATE TABLE IF NOT EXISTS `tblcourse` (
  `courseid` int(11) NOT NULL,
  `course_name` varchar(100) NOT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `fee` float DEFAULT NULL,
  `level` varchar(20) DEFAULT NULL,
  `departmentid` int(11) NOT NULL,
  `coordinatorid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`courseid`),
  KEY `coursefkdepartmentid_idx` (`departmentid`),
  KEY `coursefkcoordinatorid_idx` (`coordinatorid`),
  KEY `coursefkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblcourse`
--

INSERT INTO `tblcourse` (`courseid`, `course_name`, `duration`, `fee`, `level`, `departmentid`, `coordinatorid`, `userid`) VALUES
(1, 'Diploma in Software Engineering', '8 months', 40000, '4', 1, 1, 1),
(3, 'Diploma in Information Technology', '10 Months', 450000, '4', 1, 1, 1),
(4, 'Certificate in C++', '4 Months', 25000, '3', 4, 5, 1),
(5, 'Certificate in Java Programming', '4 Months', 18000, '4', 5, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblcourse_batch`
--

DROP TABLE IF EXISTS `tblcourse_batch`;
CREATE TABLE IF NOT EXISTS `tblcourse_batch` (
  `courseid` int(11) NOT NULL,
  `batchid` int(11) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblcourse_batch`
--

INSERT INTO `tblcourse_batch` (`courseid`, `batchid`, `userid`) VALUES
(1, 1, 1),
(1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblcourse_module`
--

DROP TABLE IF EXISTS `tblcourse_module`;
CREATE TABLE IF NOT EXISTS `tblcourse_module` (
  `courseid` int(11) NOT NULL,
  `moduleid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`courseid`,`moduleid`),
  KEY `course_modulefkcourseid_idx` (`courseid`),
  KEY `course_modulefkmoduleid_idx` (`moduleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblcourse_module`
--

INSERT INTO `tblcourse_module` (`courseid`, `moduleid`, `userid`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbldepartment`
--

DROP TABLE IF EXISTS `tbldepartment`;
CREATE TABLE IF NOT EXISTS `tbldepartment` (
  `departmentid` int(11) NOT NULL,
  `department_name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`departmentid`),
  KEY `fkdepartmentid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbldepartment`
--

INSERT INTO `tbldepartment` (`departmentid`, `department_name`, `description`, `userid`) VALUES
(1, 'Computer Science', 'Department of Computer Science', 1),
(2, 'Software Engineering', 'Department of Information Technology', 1),
(3, 'Economics', 'Department of Economics', 1),
(4, 'Information Technology', 'Department of Information Technology', 1),
(5, 'Finance', 'Department of Finance', 1),
(6, 'Politics', 'Department of Politics', 1),
(7, 'Accounting', 'Department of Accounting', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblexam`
--

DROP TABLE IF EXISTS `tblexam`;
CREATE TABLE IF NOT EXISTS `tblexam` (
  `examid` int(11) NOT NULL,
  `starttime` datetime NOT NULL,
  `endtime` datetime NOT NULL,
  `moduleid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`examid`),
  KEY `examfkmoduleid_idx` (`moduleid`),
  KEY `examfkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblexam`
--

INSERT INTO `tblexam` (`examid`, `starttime`, `endtime`, `moduleid`, `userid`) VALUES
(2, '2016-06-19 07:00:00', '2016-06-19 07:00:00', 5, 1),
(3, '2016-06-20 08:30:00', '2016-06-20 09:30:00', 1, 1),
(4, '2016-06-19 08:30:00', '2016-06-19 12:30:00', 5, 1),
(6, '2016-06-18 07:00:00', '2016-06-18 07:00:00', 4, 1),
(7, '2016-07-28 07:00:00', '2016-07-30 07:00:00', 3, 1),
(9, '2016-07-22 07:00:00', '2016-07-22 07:00:00', 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbllecture`
--

DROP TABLE IF EXISTS `tbllecture`;
CREATE TABLE IF NOT EXISTS `tbllecture` (
  `lectureid` int(11) NOT NULL,
  `starttime` datetime NOT NULL,
  `endtime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `classroomid` int(11) NOT NULL,
  `moduleid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`lectureid`),
  KEY `lecturefkclassroomid_idx` (`classroomid`),
  KEY `lecturefkmoduleid_idx` (`moduleid`),
  KEY `lecturefkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbllecture`
--

INSERT INTO `tbllecture` (`lectureid`, `starttime`, `endtime`, `description`, `classroomid`, `moduleid`, `userid`) VALUES
(1, '2016-06-06 05:30:00', '2016-06-06 07:30:00', 'Introduction to SE', 1, 1, 1),
(2, '2016-06-11 08:30:00', '2016-06-11 10:30:00', 'Introduction to www', 2, 2, 1),
(3, '2016-06-11 08:30:00', '2016-06-11 10:30:00', 'Data Sorting ', 1, 4, 1),
(4, '2016-07-11 08:30:00', '2016-07-11 10:30:00', 'Computer networking', 3, 1, 1),
(5, '2016-07-11 08:30:00', '2016-07-11 12:30:00', 'Object oriented programming', 1, 1, 1),
(6, '2016-06-11 13:30:00', '2016-06-11 15:30:00', 'Programming with JS', 3, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbllecturer`
--

DROP TABLE IF EXISTS `tbllecturer`;
CREATE TABLE IF NOT EXISTS `tbllecturer` (
  `lecturerid` int(11) NOT NULL,
  `lecturer_name` varchar(100) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`lecturerid`),
  KEY `lecturerfkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbllecturer`
--

INSERT INTO `tbllecturer` (`lecturerid`, `lecturer_name`, `address`, `email`, `phone`, `description`, `userid`) VALUES
(1, 'Achala Dahanayaka', 'Galle', 'achala@yahoo.com', '0713-557332', 'Bsc in IT', 1),
(2, 'Tharanji Ediriweera', 'Kandy', 'tharanji.ediriweera@gmail.com', '0777-123456', 'Bsc in CS', 1),
(3, 'Hiran Kooragoda', 'Galle', 'hirankooragoda@yahoo.com', '0112-434565', 'BCS', 1),
(4, 'Anusha Janaki', 'Embilipitiya', 'anusha.jnk@yahoo.com', '0473-356742', 'Bsc in IT', 1),
(5, 'Sampath Janaka', 'Embilipitiya', 'sampath1122@gmail.com', '0473-234565', 'Msc in IT', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbllog`
--

DROP TABLE IF EXISTS `tbllog`;
CREATE TABLE IF NOT EXISTS `tbllog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `entity` varchar(45) NOT NULL,
  `action` varchar(45) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`logid`),
  KEY `fkuserid_idx` (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=245 ;

--
-- Dumping data for table `tbllog`
--

INSERT INTO `tbllog` (`logid`, `entity`, `action`, `time`, `userid`) VALUES
(18, 'Student', 'Inserted', '2016-06-10 09:31:11', 1),
(19, 'Student', 'Inserted', '2016-06-10 09:42:54', 1),
(20, 'Student', 'Inserted', '2016-06-10 09:46:02', 1),
(21, 'Student', 'Inserted', '2016-06-10 09:49:23', 1),
(22, 'Student', 'Inserted', '2016-06-10 09:51:19', 1),
(23, 'Student', 'Inserted', '2016-06-10 09:54:56', 1),
(24, 'Student', 'Updated', '2016-06-10 09:55:10', 1),
(25, 'Student', 'Updated', '2016-06-10 09:55:36', 1),
(26, 'Department', 'Updated', '2016-06-10 09:56:13', 1),
(27, 'Department', 'Updated', '2016-06-10 09:56:25', 1),
(28, 'Department', 'Inserted', '2016-06-10 09:57:05', 1),
(29, 'Department', 'Inserted', '2016-06-10 09:57:35', 1),
(30, 'Department', 'Inserted', '2016-06-10 09:57:58', 1),
(31, 'Department', 'Inserted', '2016-06-10 09:58:27', 1),
(32, 'Practical', 'Updated', '2016-06-10 09:59:29', 1),
(33, 'Practical', 'Inserted', '2016-06-10 10:00:14', 1),
(34, 'Classroom', 'updated', '2016-06-10 10:01:07', 1),
(35, 'Classroom', 'Inserted', '2016-06-10 10:01:23', 1),
(36, 'Classroom', 'Inserted', '2016-06-10 10:01:41', 1),
(37, 'Practical', 'Inserted', '2016-06-10 10:03:41', 1),
(38, 'Practical', 'Inserted', '2016-06-10 10:05:47', 1),
(39, 'Practical', 'Inserted', '2016-06-10 10:07:01', 1),
(40, 'Payment', 'Updated', '2016-06-10 10:07:31', 1),
(41, 'Payment', 'Updated', '2016-06-10 10:07:38', 1),
(42, 'Payment', 'Updated', '2016-06-10 10:07:45', 1),
(43, 'Payment', 'Inserted', '2016-06-10 10:08:14', 1),
(44, 'Payment', 'Inserted', '2016-06-10 10:12:00', 1),
(45, 'Payment', 'Inserted', '2016-06-10 10:12:17', 1),
(46, 'Payment', 'Inserted', '2016-06-10 10:12:38', 1),
(47, 'Module', 'Updated', '2016-06-10 10:13:40', 1),
(48, 'Lecturer', 'Updated', '2016-06-10 10:14:26', 1),
(49, 'Lecturer', 'Updated', '2016-06-10 10:14:31', 1),
(50, 'Lecturer', 'Updated', '2016-06-10 10:15:37', 1),
(51, 'Lecturer', 'Updated', '2016-06-10 10:17:05', 1),
(52, 'Lecturer', 'Inserted', '2016-06-10 10:17:48', 1),
(53, 'Lecturer', 'Updated', '2016-06-10 10:18:03', 1),
(54, 'Lecturer', 'Inserted', '2016-06-10 10:18:53', 1),
(55, 'Lecturer', 'Inserted', '2016-06-10 10:19:57', 1),
(56, 'Module', 'Inserted', '2016-06-10 10:22:38', 1),
(57, 'Module', 'Inserted', '2016-06-10 10:23:06', 1),
(58, 'Module', 'Inserted', '2016-06-10 10:23:31', 1),
(59, 'Module', 'Inserted', '2016-06-10 10:24:24', 1),
(60, 'Course', 'Updated', '2016-06-10 10:25:03', 1),
(61, 'Course', 'Inserted', '2016-06-10 10:25:34', 1),
(62, 'Course', 'Inserted', '2016-06-10 10:26:13', 1),
(63, 'Course', 'Inserted', '2016-06-10 10:27:08', 1),
(64, 'Course', 'Inserted', '2016-06-10 10:28:12', 1),
(65, 'Exam', 'Inserted', '2016-06-10 10:28:55', 1),
(66, 'Exam', 'Inserted', '2016-06-10 10:29:16', 1),
(67, 'Exam', 'Inserted', '2016-06-10 10:31:26', 1),
(68, 'Exam', 'Inserted', '2016-06-10 10:31:43', 1),
(69, 'Assignment', 'Updated', '2016-06-10 10:32:09', 1),
(70, 'Assignment', 'Inserted', '2016-06-10 10:41:01', 1),
(71, 'Assignment', 'Inserted', '2016-06-10 10:41:47', 1),
(72, 'Assignment', 'Inserted', '2016-06-10 10:42:42', 1),
(73, 'Assignment', 'Inserted', '2016-06-10 10:43:08', 1),
(74, 'Lecture', 'Updated', '2016-06-10 10:43:44', 1),
(75, 'Lecture', 'Inserted', '2016-06-10 10:44:34', 1),
(76, 'Lecture', 'Inserted', '2016-06-10 10:46:01', 1),
(77, 'Lecture', 'Updated', '2016-06-10 10:46:10', 1),
(78, 'Lecture', 'Inserted', '2016-06-10 10:51:56', 1),
(79, 'Lecture', 'Inserted', '2016-06-10 10:52:30', 1),
(80, 'Lecture', 'Inserted', '2016-06-10 10:53:05', 1),
(81, 'Practical', 'Updated', '2016-06-14 16:43:26', 1),
(82, 'Practical', 'Updated', '2016-06-14 16:45:39', 1),
(83, 'Practical', 'Updated', '2016-06-14 16:48:49', 1),
(84, 'Student', 'Updated', '2016-06-14 17:03:25', 1),
(85, 'Student', 'Updated', '2016-06-14 17:03:40', 1),
(86, 'Payment', 'Updated', '2016-06-14 17:13:11', 1),
(87, 'Student', 'Updated', '2016-06-15 18:00:22', 1),
(88, 'Student', 'Updated', '2016-06-15 18:00:38', 1),
(89, 'Student', 'Updated', '2016-06-15 18:08:36', 1),
(90, 'Practical', 'Inserted', '2016-06-16 16:09:55', 1),
(91, 'Practical', 'Inserted', '2016-06-16 16:22:41', 1),
(92, 'Payment', 'Inserted', '2016-06-16 16:35:17', 1),
(93, 'Exam', 'Inserted', '2016-06-16 17:19:09', 1),
(94, 'Batch', 'Inserted', '2016-06-17 17:04:16', 1),
(95, 'Batch', 'updated', '2016-06-17 17:04:26', 1),
(96, 'User', 'Updated', '2016-06-24 04:42:01', 1),
(97, 'User', 'Inserted', '2016-06-24 04:42:29', 1),
(98, 'Student', 'Updated', '2016-06-24 09:07:11', 1),
(99, 'Student', 'Inserted', '2016-06-24 09:07:47', 1),
(100, 'Student', 'Deleted', '2016-06-24 09:07:53', 1),
(101, 'Student', 'Updated', '2016-06-24 15:14:38', 1),
(102, 'Student', 'Inserted', '2016-06-25 17:44:14', 1),
(103, 'Student', 'Updated', '2016-06-25 17:44:36', 1),
(104, 'Student', 'Deleted', '2016-06-25 17:44:55', 1),
(105, 'Student', 'Updated', '2016-06-25 18:01:11', 1),
(106, 'Student', 'Updated', '2016-06-25 18:22:03', 1),
(107, 'Student', 'Updated', '2016-06-25 18:22:59', 1),
(108, 'Student', 'Inserted', '2016-06-25 18:52:09', 1),
(109, 'Student', 'Deleted', '2016-06-25 18:58:04', 1),
(110, 'Student', 'Inserted', '2016-06-25 19:06:41', 1),
(111, 'Student', 'Updated', '2016-06-25 19:07:22', 1),
(112, 'Student', 'Deleted', '2016-06-25 19:07:44', 1),
(113, 'Student Assignment', 'Inserted', '2016-07-28 21:19:35', 1),
(114, 'Student Assignment', 'Inserted', '2016-07-28 21:23:31', 1),
(115, 'Student Assignment', 'Inserted', '2016-07-28 21:28:45', 1),
(116, 'Student Assignment', 'updated', '2016-07-28 21:29:02', 1),
(117, 'Student Assignment', 'updated', '2016-07-28 21:29:15', 1),
(118, 'Student Assignment', 'updated', '2016-07-28 21:29:26', 1),
(119, 'Student Assignment', 'updated', '2016-07-28 21:29:36', 1),
(120, 'Student Assignment', 'updated', '2016-07-28 21:29:58', 1),
(121, 'Student Assignment', 'Inserted', '2016-07-28 21:34:20', 1),
(122, 'Student Exam', 'Inserted', '2016-07-28 22:35:39', 1),
(123, 'Student Exam', 'Inserted', '2016-07-28 22:35:52', 1),
(124, 'Student Exam', 'updated', '2016-07-28 22:37:24', 1),
(125, 'Course Module', 'Inserted', '2016-07-28 23:46:44', 1),
(126, 'Course Module', 'Inserted', '2016-07-28 23:46:48', 1),
(127, 'Course Module', 'Inserted', '2016-07-28 23:46:52', 1),
(128, 'Course Module', 'Deleted', '2016-07-28 23:51:45', 1),
(129, 'Course Module', 'Inserted', '2016-07-28 23:51:50', 1),
(130, 'Student Attendance', 'Inserted', '2016-07-29 01:48:05', 1),
(131, 'Student Attendance', 'Inserted', '2016-07-29 01:48:49', 1),
(132, 'Student Attendance', 'Inserted', '2016-07-29 01:57:52', 1),
(133, 'Student Attendance', 'Inserted', '2016-07-29 02:08:17', 1),
(134, 'Student Attendance', 'updated', '2016-07-29 02:14:33', 1),
(135, 'Student Attendance', 'updated', '2016-07-29 02:14:37', 1),
(136, 'Student Attendance', 'updated', '2016-07-29 02:14:45', 1),
(137, 'Student Course', 'Inserted', '2016-07-29 04:12:47', 1),
(138, 'Student Course', 'Inserted', '2016-07-29 04:13:10', 1),
(139, 'Student Course', 'updated', '2016-07-29 04:21:24', 1),
(140, 'Student Course', 'Inserted', '2016-07-29 04:21:37', 1),
(141, 'Student', 'Inserted', '2016-07-29 07:23:18', 1),
(142, 'Student Batch', 'Inserted', '2016-07-29 16:49:09', 1),
(143, 'Student Batch', 'Inserted', '2016-07-29 16:51:18', 1),
(144, 'Student Batch', 'Inserted', '2016-07-29 16:51:23', 1),
(145, 'Student Batch', 'Inserted', '2016-07-29 16:51:30', 1),
(146, 'Student Batch', 'Inserted', '2016-07-29 16:51:34', 1),
(147, 'Student Batch', 'Inserted', '2016-07-29 17:02:54', 1),
(148, 'Student Batch', 'Inserted', '2016-07-29 17:02:57', 1),
(149, 'Student Batch', 'Inserted', '2016-07-29 17:03:02', 1),
(150, 'Student Batch', 'Inserted', '2016-07-29 17:03:06', 1),
(151, 'Student Batch', 'Inserted', '2016-07-29 17:03:12', 1),
(152, 'Student Batch', 'Inserted', '2016-07-29 17:03:15', 1),
(153, 'Course Batch', 'Inserted', '2016-07-29 17:29:06', 1),
(154, 'Course Batch', 'Inserted', '2016-07-29 17:29:17', 1),
(155, 'User', 'Updated', '2016-07-31 06:59:24', 1),
(156, 'User', 'Updated', '2016-07-31 06:59:38', 1),
(157, 'User', 'Updated', '2016-07-31 06:59:51', 1),
(158, 'Lecturer', 'Inserted', '2016-07-31 07:11:58', 1),
(159, 'Lecturer', 'Updated', '2016-07-31 07:12:10', 1),
(160, 'Lecturer', 'Updated', '2016-07-31 07:12:21', 1),
(161, 'Lecturer', 'Deleted', '2016-07-31 07:12:28', 1),
(162, 'Exam', 'Updated', '2016-07-31 07:15:52', 1),
(163, 'Student Exam', 'Inserted', '2016-07-31 07:16:58', 1),
(164, 'Practical', 'Inserted', '2016-07-31 07:20:42', 1),
(165, 'Module', 'Inserted', '2016-07-31 07:22:27', 1),
(166, 'Module', 'Updated', '2016-07-31 07:22:34', 1),
(167, 'Module', 'Updated', '2016-07-31 07:22:41', 1),
(168, 'Module', 'Deleted', '2016-07-31 07:22:47', 1),
(169, 'Payment', 'Inserted', '2016-07-31 07:23:28', 1),
(170, 'Payment', 'Updated', '2016-07-31 07:23:37', 1),
(171, 'Payment', 'Updated', '2016-07-31 07:23:52', 1),
(172, 'Payment', 'Deleted', '2016-07-31 07:23:59', 1),
(173, 'Department', 'Updated', '2016-07-31 07:33:30', 1),
(174, 'Department', 'Deleted', '2016-07-31 07:34:04', 1),
(175, 'Department', 'Updated', '2016-07-31 07:34:21', 1),
(176, 'Department', 'Inserted', '2016-07-31 07:35:25', 1),
(177, 'Course', 'Updated', '2016-07-31 07:44:11', 1),
(178, 'Batch', 'Inserted', '2016-07-31 07:45:58', 1),
(179, 'Course', 'Inserted', '2016-07-31 07:51:41', 1),
(180, 'Student', 'Inserted', '2016-07-31 09:56:11', 1),
(181, 'Student', 'Updated', '2016-07-31 09:56:56', 1),
(182, 'Student', 'Deleted', '2016-07-31 09:57:12', 1),
(183, 'Department', 'Inserted', '2016-07-31 09:59:47', 1),
(184, 'Department', 'Updated', '2016-07-31 10:00:20', 1),
(185, 'Department', 'Deleted', '2016-07-31 10:00:55', 1),
(186, 'Practical', 'Inserted', '2016-07-31 10:04:34', 1),
(187, 'Practical', 'Updated', '2016-07-31 10:04:57', 1),
(188, 'Practical', 'Deleted', '2016-07-31 10:06:15', 1),
(189, 'Exam', 'Inserted', '2016-07-31 10:06:51', 1),
(190, 'Exam', 'Updated', '2016-07-31 10:07:05', 1),
(191, 'Exam', 'Deleted', '2016-07-31 10:07:16', 1),
(192, 'Student Exam', 'Inserted', '2016-07-31 10:08:21', 1),
(193, 'Module', 'Inserted', '2016-07-31 10:12:16', 1),
(194, 'Module', 'Updated', '2016-07-31 10:12:33', 1),
(195, 'Module', 'Deleted', '2016-07-31 10:12:40', 1),
(196, 'Payment', 'Inserted', '2016-07-31 10:14:37', 1),
(197, 'Payment', 'Updated', '2016-07-31 10:14:56', 1),
(198, 'Payment', 'Deleted', '2016-07-31 10:15:10', 1),
(199, 'Course', 'Updated', '2016-07-31 10:18:50', 1),
(200, 'Course', 'Deleted', '2016-07-31 10:19:03', 1),
(201, 'Batch', 'updated', '2016-07-31 10:19:39', 1),
(202, 'Student', 'Inserted', '2016-07-31 10:33:05', 1),
(203, 'Student', 'Updated', '2016-07-31 10:33:23', 1),
(204, 'Student', 'Deleted', '2016-07-31 10:33:33', 1),
(205, 'Student Course', 'Inserted', '2016-07-31 10:34:17', 1),
(206, 'Student Batch', 'Inserted', '2016-07-31 10:34:28', 1),
(207, 'Lecture', 'Inserted', '2016-07-31 10:37:21', 1),
(208, 'Lecture', 'Updated', '2016-07-31 10:37:33', 1),
(209, 'Lecture', 'Deleted', '2016-07-31 10:37:40', 1),
(210, 'Exam', 'Inserted', '2016-07-31 10:39:29', 1),
(211, 'Exam', 'Updated', '2016-07-31 10:39:45', 1),
(212, 'Exam', 'Deleted', '2016-07-31 10:39:54', 1),
(213, 'Module', 'Inserted', '2016-07-31 10:41:14', 1),
(214, 'Module', 'Updated', '2016-07-31 10:41:23', 1),
(215, 'Module', 'Deleted', '2016-07-31 10:41:27', 1),
(216, 'Payment', 'Inserted', '2016-07-31 10:42:28', 1),
(217, 'Payment', 'Updated', '2016-07-31 10:42:46', 1),
(218, 'Payment', 'Deleted', '2016-07-31 10:42:56', 1),
(219, 'Course', 'Inserted', '2016-07-31 10:44:56', 1),
(220, 'Course', 'Updated', '2016-07-31 10:45:08', 1),
(221, 'Course', 'Deleted', '2016-07-31 10:45:17', 1),
(222, 'Student', 'Inserted', '2016-07-31 11:09:45', 1),
(223, 'Student', 'Updated', '2016-07-31 11:10:13', 1),
(224, 'Student', 'Deleted', '2016-07-31 11:10:23', 1),
(225, 'Student Course', 'updated', '2016-07-31 11:11:41', 1),
(226, 'Student Course', 'Deleted', '2016-07-31 11:11:46', 1),
(227, 'Student Batch', 'Inserted', '2016-07-31 11:12:01', 1),
(228, 'Lecture', 'Inserted', '2016-07-31 11:14:39', 1),
(229, 'Lecture', 'Updated', '2016-07-31 11:15:08', 1),
(230, 'Lecture', 'Deleted', '2016-07-31 11:15:17', 1),
(231, 'Exam', 'Inserted', '2016-07-31 11:17:35', 1),
(232, 'Exam', 'Updated', '2016-07-31 11:17:52', 1),
(233, 'Exam', 'Deleted', '2016-07-31 11:17:59', 1),
(234, 'Student Exam', 'Inserted', '2016-07-31 11:18:14', 1),
(235, 'Module', 'Inserted', '2016-07-31 11:19:22', 1),
(236, 'Module', 'Updated', '2016-07-31 11:19:33', 1),
(237, 'Module', 'Deleted', '2016-07-31 11:19:41', 1),
(238, 'Payment', 'Inserted', '2016-07-31 11:20:38', 1),
(239, 'Payment', 'Updated', '2016-07-31 11:21:03', 1),
(240, 'Payment', 'Deleted', '2016-07-31 11:21:20', 1),
(241, 'Department', 'Inserted', '2016-07-31 11:23:31', 1),
(242, 'Department', 'Updated', '2016-07-31 11:23:51', 1),
(243, 'Department', 'Deleted', '2016-07-31 11:24:08', 1),
(244, 'Student Course', 'Inserted', '2016-08-01 18:11:10', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblmodule`
--

DROP TABLE IF EXISTS `tblmodule`;
CREATE TABLE IF NOT EXISTS `tblmodule` (
  `moduleid` int(11) NOT NULL,
  `module_name` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `lecturerid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`moduleid`),
  KEY `modulefklecturerid_idx` (`lecturerid`),
  KEY `modulefkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblmodule`
--

INSERT INTO `tblmodule` (`moduleid`, `module_name`, `description`, `lecturerid`, `userid`) VALUES
(1, 'Software Engineering', 'Introduction to SE', 1, 1),
(2, 'Web Application Development', 'Web application development into', 2, 1),
(3, 'Management in IT', 'Management in information technology', 3, 1),
(4, 'Mathematics', 'Maths for IT', 3, 1),
(5, 'Data Structures and Algorithms', 'Data structures and algorithms using C++', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblpayment`
--

DROP TABLE IF EXISTS `tblpayment`;
CREATE TABLE IF NOT EXISTS `tblpayment` (
  `paymentid` int(11) NOT NULL,
  `amount` float NOT NULL,
  `time` datetime NOT NULL,
  `studentid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`paymentid`),
  KEY `fkstudentid_idx` (`studentid`),
  KEY `fkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblpayment`
--

INSERT INTO `tblpayment` (`paymentid`, `amount`, `time`, `studentid`, `userid`) VALUES
(2, 12000, '2016-06-12 08:30:00', 1003, 1),
(3, 15000, '2016-06-14 08:30:00', 1001, 1),
(4, 9000, '2016-06-12 10:30:00', 1004, 1),
(5, 16000, '2016-06-10 08:30:00', 1007, 1),
(6, 70000, '2016-06-17 08:00:00', 1007, 1),
(7, 15000, '2016-07-05 08:00:00', 1011, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblpractical`
--

DROP TABLE IF EXISTS `tblpractical`;
CREATE TABLE IF NOT EXISTS `tblpractical` (
  `practicalid` int(11) NOT NULL,
  `starttime` datetime NOT NULL,
  `endtime` datetime NOT NULL,
  `studentid` int(11) NOT NULL,
  `classroomid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`practicalid`),
  KEY `practicalfkstudentid_idx` (`studentid`),
  KEY `practicalfkclassroomid_idx` (`classroomid`),
  KEY `practicalfkuserid_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblpractical`
--

INSERT INTO `tblpractical` (`practicalid`, `starttime`, `endtime`, `studentid`, `classroomid`, `userid`) VALUES
(1, '2016-06-06 07:00:00', '2016-06-06 07:00:00', 1001, 3, 1),
(3, '2016-06-11 08:30:00', '2016-06-11 11:30:00', 1001, 1, 1),
(4, '2016-06-11 08:30:00', '2016-06-11 11:30:00', 1002, 2, 1),
(5, '2016-06-12 08:30:00', '2016-06-12 12:30:00', 1001, 3, 1),
(6, '2016-06-16 07:00:00', '2016-06-16 08:30:00', 1004, 2, 1),
(7, '2016-06-17 08:30:00', '2016-06-17 09:30:00', 1001, 1, 1),
(8, '2016-07-21 08:30:00', '2016-07-28 07:00:00', 1001, 1, 1),
(9, '2016-07-19 07:00:00', '2016-07-21 07:00:00', 1001, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblstudent`
--

DROP TABLE IF EXISTS `tblstudent`;
CREATE TABLE IF NOT EXISTS `tblstudent` (
  `studentid` int(11) NOT NULL,
  `student_name` varchar(100) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `background` varchar(255) DEFAULT NULL,
  `reg_date` date NOT NULL,
  `batchid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`studentid`),
  KEY `fkuser_idx` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblstudent`
--

INSERT INTO `tblstudent` (`studentid`, `student_name`, `address`, `gender`, `birthday`, `email`, `phone`, `background`, `reg_date`, `batchid`, `userid`) VALUES
(1001, 'Kushan Namal', 'Colombo', 'Male', '1988-02-10', 'kushan@gmail.com', '0717-560118', 'A/L in Arts', '2016-06-09', 1, 1),
(1002, 'Roshan Wijesinghe', 'Kandy', 'Male', '1995-05-10', 'roshan@gmail.com', '0777-123987', 'G.C.E A/L in Maths', '2016-05-04', 1, 1),
(1003, 'Nuwan Fernando', 'Negambo', 'Male', '1988-02-04', 'nuwanfer@gmail.com', '0112-434545', 'Bsc in Civil Engineering', '2016-03-19', 1, 1),
(1004, 'Shehan Wijesinghe', 'Galle', 'Male', '1988-02-14', 'shehan@yahoo.com', '0717-456765', 'A/L in Commerce', '2015-05-19', 1, 1),
(1005, 'Ruwangi Fernado', 'Kandy', 'Female', '1985-07-12', 'ruwangi@yahoo.com', '0113-356276', 'Bsc in IT', '2016-01-31', 1, 1),
(1006, 'Wasana Wijesinghe', 'Matara', 'Female', '1990-04-18', 'wasanawijesinghe@hotmail.com', '0771435653', 'A/L in Commerce', '2016-01-23', 1, 1),
(1007, 'Uditha Bandara', 'Matara', 'Male', '1991-03-14', 'uditha.b@gmail.com', '0112-433565', 'Bsc in Computing', '2015-11-21', 1, 1),
(1008, 'Chamini Rajapaksha', 'Galle', 'Female', '1991-12-21', 'chamini.r@gmail.com', '0721-547623', 'G.C.E A/L in Arts', '2015-11-30', 1, 1),
(1009, 'Dilshan Perera', 'Galle', 'Male', '1992-12-19', 'dilshan92@gmail.com', '0112-434678', 'Bsc in Maths', '2013-12-14', 1, 1),
(1010, 'Chamodi Amarasinghe', 'Kalutara', 'Female', '1983-12-18', 'cham.amarasignhe@yahoo.com', '0112-432124', 'GCE A/L in Biology', '2016-05-12', 1, 1),
(1011, 'Sisira Kumara', 'Matara', 'Male', '1980-03-18', 'sisira@gmail.com', '0413-674943', 'A/L in Commerce', '2016-01-03', 1, 1),
(1012, 'Ishani Perera', 'Kandy', 'Female', '1988-03-19', 'i.perera@yahoo.com', '0112-235985', 'Bsc in Biology', '2016-05-03', 1, 1),
(1013, 'Buddhika Samaraweera', 'Rathnapura', 'Male', '1990-12-15', 'buddhika.s@yahoo.com', '0721-325675', 'GCE O/L Passed', '2014-11-22', 1, 1),
(1014, 'Ruchira Menaka', 'Rathnapura', 'Male', '1993-07-12', 'ruchira@gmail.com', '0783-434124', 'A/L in Biology', '2016-03-25', 1, 1),
(1015, 'Shahana Samaraweera', 'Colombo', 'Female', '1991-09-19', 'shahana.s@gmail.com', '0112-433422', 'Bsc in Microbiology', '2016-04-21', 1, 1),
(1018, 'Nuwan Perera', 'Colombo', 'Male', '1992-07-16', 'nuwan@gmail.com', '0777234543', '-', '2016-07-13', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblstudent_assignment`
--

DROP TABLE IF EXISTS `tblstudent_assignment`;
CREATE TABLE IF NOT EXISTS `tblstudent_assignment` (
  `studentid` int(11) NOT NULL,
  `assignmentid` int(11) NOT NULL,
  `marks` decimal(10,0) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`studentid`,`assignmentid`),
  KEY `student_assignmentfkstudentid_idx` (`studentid`),
  KEY `student_assignmentfkassignmentid_idx` (`assignmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblstudent_assignment`
--

INSERT INTO `tblstudent_assignment` (`studentid`, `assignmentid`, `marks`, `userid`) VALUES
(1001, 1, '10', 1),
(1001, 2, '10', 1),
(1001, 3, '10', 1),
(1002, 3, '68', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblstudent_batch`
--

DROP TABLE IF EXISTS `tblstudent_batch`;
CREATE TABLE IF NOT EXISTS `tblstudent_batch` (
  `batchid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblstudent_batch`
--

INSERT INTO `tblstudent_batch` (`batchid`, `studentid`, `userid`) VALUES
(1, 1001, 1),
(1, 1002, 1),
(1, 1003, 1),
(1, 1004, 1),
(2, 1006, 1),
(2, 1007, 1),
(2, 1002, 1),
(2, 1003, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblstudent_course`
--

DROP TABLE IF EXISTS `tblstudent_course`;
CREATE TABLE IF NOT EXISTS `tblstudent_course` (
  `courseid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL,
  `fee` float DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`courseid`,`studentid`),
  KEY `student_coursefkstudentid_idx` (`studentid`),
  KEY `student_coursefkcourseid_idx` (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblstudent_course`
--

INSERT INTO `tblstudent_course` (`courseid`, `studentid`, `fee`, `userid`) VALUES
(1, 1001, 30000, 1),
(3, 1001, 45000, 1),
(3, 1003, 67000, 1),
(4, 1001, 70000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblstudent_exam`
--

DROP TABLE IF EXISTS `tblstudent_exam`;
CREATE TABLE IF NOT EXISTS `tblstudent_exam` (
  `studentid` int(11) NOT NULL,
  `examid` int(11) NOT NULL,
  `marks` decimal(10,0) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`studentid`,`examid`),
  KEY `student_examfkstudentid_idx` (`studentid`),
  KEY `student_examfkexamid_idx` (`examid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblstudent_exam`
--

INSERT INTO `tblstudent_exam` (`studentid`, `examid`, `marks`, `userid`) VALUES
(1001, 3, '67', 1),
(1001, 6, '80', 1),
(1004, 3, '78', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
CREATE TABLE IF NOT EXISTS `tbluser` (
  `userid` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(45) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbluser`
--

INSERT INTO `tbluser` (`userid`, `user_name`, `email`, `password`, `type`, `status`) VALUES
(1, 'Rasan Samarasinghe', 'admin@gmail.com', '1234', 'admin', 'active'),
(2, 'Test Coordinator', 'coordinator@gmail.com', '1234', 'coordinator', 'active'),
(3, 'Test Receptionist', 'receptionist@gmail.com', '1234', 'receptionist', 'active');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblassignment`
--
ALTER TABLE `tblassignment`
  ADD CONSTRAINT `assignmentfkmoduleid` FOREIGN KEY (`moduleid`) REFERENCES `tblmodule` (`moduleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `assignmentfkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblattendance`
--
ALTER TABLE `tblattendance`
  ADD CONSTRAINT `attendancefklectureid` FOREIGN KEY (`lectureid`) REFERENCES `tbllecture` (`lectureid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attendancefkstudentid` FOREIGN KEY (`studentid`) REFERENCES `tblstudent` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblclassroom`
--
ALTER TABLE `tblclassroom`
  ADD CONSTRAINT `classroomfkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblcourse`
--
ALTER TABLE `tblcourse`
  ADD CONSTRAINT `coursefkcoordinatorid` FOREIGN KEY (`coordinatorid`) REFERENCES `tbllecturer` (`lecturerid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `coursefkdepartmentid` FOREIGN KEY (`departmentid`) REFERENCES `tbldepartment` (`departmentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `coursefkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblcourse_module`
--
ALTER TABLE `tblcourse_module`
  ADD CONSTRAINT `course_modulefkcourseid` FOREIGN KEY (`courseid`) REFERENCES `tblcourse` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `course_modulefkmoduleid` FOREIGN KEY (`moduleid`) REFERENCES `tblmodule` (`moduleid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbldepartment`
--
ALTER TABLE `tbldepartment`
  ADD CONSTRAINT `departmentfkusertid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblexam`
--
ALTER TABLE `tblexam`
  ADD CONSTRAINT `examfkmoduleid` FOREIGN KEY (`moduleid`) REFERENCES `tblmodule` (`moduleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examfkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbllecture`
--
ALTER TABLE `tbllecture`
  ADD CONSTRAINT `lecturefkclassroomid` FOREIGN KEY (`classroomid`) REFERENCES `tblclassroom` (`classroomid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `lecturefkmoduleid` FOREIGN KEY (`moduleid`) REFERENCES `tblmodule` (`moduleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `lecturefkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbllecturer`
--
ALTER TABLE `tbllecturer`
  ADD CONSTRAINT `lecturerfkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbllog`
--
ALTER TABLE `tbllog`
  ADD CONSTRAINT `logfkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblmodule`
--
ALTER TABLE `tblmodule`
  ADD CONSTRAINT `modulefklecturerid` FOREIGN KEY (`lecturerid`) REFERENCES `tbllecturer` (`lecturerid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `modulefkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblpayment`
--
ALTER TABLE `tblpayment`
  ADD CONSTRAINT `paymentfkstudentid` FOREIGN KEY (`studentid`) REFERENCES `tblstudent` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paymentfkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblpractical`
--
ALTER TABLE `tblpractical`
  ADD CONSTRAINT `practicalfkclassroomid` FOREIGN KEY (`classroomid`) REFERENCES `tblclassroom` (`classroomid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `practicalfkstudentid` FOREIGN KEY (`studentid`) REFERENCES `tblstudent` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `practicalfkuserid` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblstudent`
--
ALTER TABLE `tblstudent`
  ADD CONSTRAINT `studentfkuser` FOREIGN KEY (`userid`) REFERENCES `tbluser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblstudent_assignment`
--
ALTER TABLE `tblstudent_assignment`
  ADD CONSTRAINT `student_assignmentfkassignmentid` FOREIGN KEY (`assignmentid`) REFERENCES `tblassignment` (`assignmentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_assignmentfkstudentid` FOREIGN KEY (`studentid`) REFERENCES `tblstudent` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblstudent_course`
--
ALTER TABLE `tblstudent_course`
  ADD CONSTRAINT `student_coursefkcourseid` FOREIGN KEY (`courseid`) REFERENCES `tblcourse` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_coursefkstudentid` FOREIGN KEY (`studentid`) REFERENCES `tblstudent` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblstudent_exam`
--
ALTER TABLE `tblstudent_exam`
  ADD CONSTRAINT `student_examfkexamid` FOREIGN KEY (`examid`) REFERENCES `tblexam` (`examid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_examfkstudentid` FOREIGN KEY (`studentid`) REFERENCES `tblstudent` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
