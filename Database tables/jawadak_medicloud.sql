-- phpMyAdmin SQL Dump
-- version 4.0.10.18
-- https://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Dec 20, 2017 at 10:57 AM
-- Server version: 5.6.35
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jawadak_medicloud`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `email` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `generalID` int(7) NOT NULL,
  `isDoctor` tinyint(1) NOT NULL,
  PRIMARY KEY (`email`),
  KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`email`, `password`, `generalID`, `isDoctor`) VALUES
('abir.rahman1995@gmail.com', '8953814', 1, 1),
('abir69@gmail.com', '123', 2, 0),
('arnob69@gmail.com', '123', 1, 0),
('fariha69@gmail.com', '123', 3, 0),
('guy@mail.com', 'qwe', 8, 0),
('helio@helio.org', 'wow', 9, 0),
('ishfaq69@gmail.com', '123', 7, 0),
('jawad69@gmail.com', '123', 4, 0),
('mek@gmail.com', 'qwe', 12, 0),
('nubraz69@gmail.com', '123', 5, 0),
('nur69@gmail.com', '123', 6, 0),
('shabbir@gmail.com', 'qwe', 13, 0),
('test@test', 'qwe', 10, 0),
('tset@jaichaa.com', 'janina', 11, 0);

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE IF NOT EXISTS `appointments` (
  `pID` int(7) NOT NULL,
  `dID` int(7) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` int(2) NOT NULL,
  UNIQUE KEY `pID` (`pID`,`dID`,`date`),
  KEY `noDeld` (`dID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`pID`, `dID`, `date`, `time`) VALUES
(1, 1, '2017-12-29', 0),
(4, 3, '2017-12-29', 0);

-- --------------------------------------------------------

--
-- Table structure for table `doctor_info`
--

CREATE TABLE IF NOT EXISTS `doctor_info` (
  `name` varchar(50) NOT NULL,
  `dID` int(7) NOT NULL,
  `sex` varchar(7) NOT NULL,
  `specialty` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `qualifications` varchar(50) NOT NULL,
  `clinic_address` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`dID`),
  KEY `dID` (`dID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_info`
--

INSERT INTO `doctor_info` (`name`, `dID`, `sex`, `specialty`, `phone`, `qualifications`, `clinic_address`) VALUES
('Abir Rahman', 1, 'Male', 'Neurology', '1711355057', 'Self-Taught', 'Uttara'),
('Sadman Mahmud', 2, 'Male', 'Gynocologist', '168524679', 'Bangladesh Medial College', 'Banani'),
('Sullivan Widom', 3, 'Female', 'Optometrist', '151231241', 'Phd, Mbbs, Fewrs', 'Bashundhara');

-- --------------------------------------------------------

--
-- Table structure for table `patients_info`
--

CREATE TABLE IF NOT EXISTS `patients_info` (
  `name` varchar(250) NOT NULL,
  `pID` int(7) NOT NULL AUTO_INCREMENT,
  `dob` varchar(11) NOT NULL,
  `blood_group` varchar(3) NOT NULL,
  `sex` varchar(7) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(250) NOT NULL,
  PRIMARY KEY (`pID`),
  KEY `pID` (`pID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `patients_info`
--

INSERT INTO `patients_info` (`name`, `pID`, `dob`, `blood_group`, `sex`, `phone_number`, `address`) VALUES
('Arnob Mahmud', 1, '08/12/0995', 'B+', 'Male', '1676203723', 'Uttara'),
('Abir Rahman', 2, '01/10/1995', 'O-', 'Male', '1711355057', 'Uttara'),
('Fariha Islam', 3, '14/02/1996', 'B+', 'Female', '1682752881', 'Uttara'),
('Jawad Aziz Khan', 4, '28/09/1996', 'A+', 'Male', '1758888842', 'Baridhara'),
('Nubraz Mugdho', 5, '24/11/1996', 'B-', 'Female', '1634174168', 'Uttara'),
('Nur Islam', 6, '02/08/1995', 'O+', 'Male', '1742489777', 'Bashundhara'),
('Ishfaq Zaman', 7, '01/01/1995', 'AB-', 'Male', '1678952455', 'Banani'),
('Guy Dude', 8, '12.12.12', 'F', 'Male', '01512312300', 'The Streets'),
('Helio Server', 9, '22.12.2017', 'A++', 'Female', '1010010101', 'Cloudland'),
('Test', 10, '123', 'A', 'Male', '123', 'Qwerty'),
('A', 11, '2865', 'G', 'G', '506', 'Fh'),
('Ehsan Karim', 12, '12.12.12', 'A+', 'Male', '123456', 'Hdkslshdbkdos \nChkdksls'),
('Mohammad Shabbir', 13, '12.12.12', 'C++', 'Male', '123456789', 'Djosowwpowow');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `noDeld` FOREIGN KEY (`dID`) REFERENCES `doctor_info` (`dID`) ON DELETE NO ACTION,
  ADD CONSTRAINT `noDelp` FOREIGN KEY (`pID`) REFERENCES `patients_info` (`pID`) ON DELETE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
