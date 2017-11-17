-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2017 at 10:24 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medicloud`
--

-- --------------------------------------------------------

--
-- Table structure for table `patients_info`
--

CREATE TABLE `patients_info` (
  `name` varchar(250) NOT NULL,
  `dob` varchar(11) NOT NULL,
  `blood_group` varchar(3) NOT NULL,
  `sex` varchar(7) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `pID` varchar(50) NOT NULL,
  `address` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients_info`
--

INSERT INTO `patients_info` (`name`, `dob`, `blood_group`, `sex`, `phone_number`, `pID`, `address`) VALUES
('Abir Rahman', '01/10/1995', 'o-', 'Male', 1711355057, '2', 'Uttara'),
('Arnob Mahmud', '08/12/0995', 'B+', 'Male', 1676203723, '1', 'Uttara'),
('Fariha Islam', '14/02/1996', 'B+', 'Female', 1682752881, '3', 'Uttara'),
('Jawad Aziz Khan', '28/09/1996', 'AB+', 'Male', 1758888842, '4', 'Baridhara'),
('Nubraz Mugdho', '24/11/1996', 'B-', 'Female', 1634174168, '5', 'Uttara'),
('Nur Islam', '02/08/1995', 'o+', 'Male', 1742489777, '6', 'Bashundhara'),
('Ishfaq zaman', '01/01/1995', 'AB-', 'Male', 1678952455, '7', 'Banani');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
