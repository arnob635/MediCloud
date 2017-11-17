-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2017 at 07:36 PM
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
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `email` varchar(128) NOT NULL,
  `password` varchar(16) NOT NULL,
  `ID` int(11) NOT NULL,
  `isDoc` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`email`, `password`, `ID`, `isDoc`) VALUES
('arnob635@gmail.com', '123456', 11223, 1),
('fevrosickleton@dmail.com', 'password', 1, 0),
('guydudeson@dmail.com', 'password', 3, 0),
('janedoe@dmail.com', 'password', 2, 1),
('johndoe@dmail.com', 'deersanddoes', 1, 1),
('swollenia@dmail.com', 'password', 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `dID` int(11) NOT NULL,
  `dPass` varchar(16) NOT NULL DEFAULT 'password',
  `dName` varchar(50) DEFAULT NULL,
  `speciality` varchar(50) DEFAULT NULL,
  `qualification` varchar(50) DEFAULT NULL,
  `clinicAdd` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`dID`, `dPass`, `dName`, `speciality`, `qualification`, `clinicAdd`) VALUES
(1, 'deersanddoes', 'John Doe', 'Optometry', 'MBBS, FCPS, HTML', 'House number, Something street, Some state, Olympus'),
(2, 'password', 'Jane Moe', 'Nephrology', 'FCPS, PHP', 'Basha code, Random road, Weird city, Bermuda');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `pID` int(11) NOT NULL,
  `pPass` varchar(16) DEFAULT 'password',
  `pName` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `currDiag` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`pID`, `pPass`, `pName`, `age`, `gender`, `Address`, `currDiag`) VALUES
(1, 'password', 'Fevro Sickleton', 40, 'm', 'bla, blu, muh, meh', 'Very Sick, ples help'),
(2, 'password', 'Swollenia Footmeister', 27, 'f', 'there, then that way, then right, tada', 'HugeFootitis'),
(3, 'password', 'Guy Dudeson', 25, 'm', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`dID`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`pID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `dID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `pID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
