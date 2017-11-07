-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2017 at 08:29 PM
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

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`dID`, `dPass`, `dName`, `speciality`, `qualification`, `clinicAdd`) VALUES
(1, 'password', 'John Doe', 'Optometry', 'MBBS, FCPS, HTML', 'House number, Something street, Some state, Olympus'),
(2, 'password', 'Jane Moe', 'Nephrology', 'FCPS, PHP', 'Basha code, Random road, Weird city, Bermuda');

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`pID`, `pPass`, `pName`, `age`, `gender`, `Address`, `currDiag`) VALUES
(1, 'password', 'Fevro Sickleton', 40, 'm', 'bla, blu, muh, meh', 'Very Sick, ples help'),
(2, 'password', 'Swollenia Footmeister', 27, 'f', 'there, then that way, then right, tada', 'HugeFootitis');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
