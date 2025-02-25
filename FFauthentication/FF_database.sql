-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 25, 2025 at 04:18 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ff_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `authentication`
--

CREATE TABLE `authentication` (
  `id` int(11) NOT NULL,
  `email` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `authentication`
--

INSERT INTO `authentication` (`id`, `email`, `password`) VALUES
(1, 'paullopez@gmail.com', '$2y$10$HIQ/3VbJOR5IAEgFz4iWfuWOpyt0v2R.sU.gJ2APdcri8IDk'),
(2, '123@gmail.com', '$2y$10$pf4zp7NpYrn8EB7s9o2hXOyVACz5nCP4XwFBv5VJuHOXcZV3'),
(4, 'jp@gmail.com', '$2y$10$.O0.4p97lwVETCCTHu5s1uquTiqXGVKxxOgotakoYurzkPpc'),
(5, 'paullopez@gmail.com3', '$2y$10$8VdgZlyIaoIo/n.4zbl/s.xZ4xtJY/UB21xSYgaN45V76c20'),
(6, 'paul@gmail.com', '$2y$10$LkbHiXYnBxM80PjsP/rNYecL7HVASd0mzjx3uliP/gZjbDSX'),
(7, 'paullopez123@gmail.com', '$2y$10$A83ay0d9nC7/7OyTNnwxzORe5oxRcNaOo7kLsgbLdVYkEumJ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authentication`
--
ALTER TABLE `authentication`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authentication`
--
ALTER TABLE `authentication`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
