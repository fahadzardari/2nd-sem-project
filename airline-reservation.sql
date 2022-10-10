-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 08, 2022 at 06:03 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline-reservation`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `email`, `password`) VALUES
(1, 'fahad', '1');

-- --------------------------------------------------------

--
-- Table structure for table `airports`
--

CREATE TABLE `airports` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `airports`
--

INSERT INTO `airports` (`id`, `name`, `city`, `code`) VALUES
(1, 'Jinnah International ', 'Karachi', 'KHI'),
(2, 'John F. Kennedy International', 'New York', 'JFK');

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `passport_no` varchar(255) NOT NULL,
  `age` int(255) NOT NULL,
  `flight_id` int(255) NOT NULL,
  `ticket_no` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `name`, `email`, `passport_no`, `age`, `flight_id`, `ticket_no`) VALUES
(1, 'John Doe', '', '55555555', 324, 1, ''),
(2, 'John Boy', '', '13123', 213, 8, ''),
(3, 'fahad', 'FAHAD@EMAIL.COM', '123123', 123123, 8, '12312'),
(4, 'FAHDF', 'FDSJSDF', '12', 1, 8, 'fTraB6'),
(5, 'fahad', 'fahadzardari111@gmail.com', '1312323', 12, 1, 'i5Ypm8'),
(6, 'fahad', 'fahadzardari111@gmail.com', '1312323', 12, 1, 'eJzA00'),
(7, 'fahsd1', 'fahadzardari111@gmail.com', 'dsklfj', 12, 8, 'k5MAdG'),
(8, 'fakjhdf', 'jetofo4663@canyona.com', 'dlkfjsd', 12, 1, 'VhAYy0'),
(9, 'Fhad', 'jetofo4663@canyona.com', 'sdldfjsd', 21, 9, 'h5MRTo8tdQnJ'),
(10, 'Shahid', 'jetofo4663@canyona.com', '3123-1231-123', 19, 8, 'UEDi2515YK0t'),
(11, 'fahad', 'fahadzardari111@gmail.com', 'lkdfhsdjk', 123, 8, 't2Bbr6rCTtNy'),
(12, 'ARAYAN', 'jetofo4663@canyona.com', '213123', 12, 8, 'E3XGEQqERXBO'),
(13, 'jhsdfh', 'fahadzardari111@gmail.com', '123123', 12, 8, 'xYNRrtbjz8CG');

-- --------------------------------------------------------

--
-- Table structure for table `fleet`
--

CREATE TABLE `fleet` (
  `id` int(255) NOT NULL,
  `plane` varchar(255) NOT NULL,
  `capacity` varchar(255) NOT NULL,
  `flight_no` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fleet`
--

INSERT INTO `fleet` (`id`, `plane`, `capacity`, `flight_no`) VALUES
(2, 'Boeing-747', '500', 104);

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `id` int(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `departure_date` varchar(255) NOT NULL,
  `departure_time` varchar(255) NOT NULL,
  `arrival` varchar(255) NOT NULL,
  `flight_no` int(255) NOT NULL,
  `plane_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`id`, `origin`, `destination`, `departure_date`, `departure_time`, `arrival`, `flight_no`, `plane_id`) VALUES
(1, 'John F. Kennedy International', 'Jinnah International ', '25/12/2022', '1500', '1900', 104, 2),
(8, 'Jinnah International ', 'John F. Kennedy International', '21/21/1231', '1231', '2141', 104, 2),
(9, 'John F. Kennedy International', 'Jinnah International ', '21/11/2022', '2131', '2200', 104, 2),
(12, 'Jinnah International ', 'John F. Kennedy International', '23/10/2033', '0101', '1200', 104, 2),
(13, 'Jinnah International ', 'John F. Kennedy International', '21/9/2023', '2100', '0100', 104, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `airports`
--
ALTER TABLE `airports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `flight_id` (`flight_id`);

--
-- Indexes for table `fleet`
--
ALTER TABLE `fleet`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`id`),
  ADD KEY `plane_id` (`plane_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `airports`
--
ALTER TABLE `airports`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `fleet`
--
ALTER TABLE `fleet`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `flights`
--
ALTER TABLE `flights`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
