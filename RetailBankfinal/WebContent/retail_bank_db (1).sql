-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2020 at 10:42 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `retail_bank_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_account`
--

CREATE TABLE `tb_account` (
  `acc_id` int(11) NOT NULL,
  `cust_id` int(11) NOT NULL,
  `balance` double NOT NULL,
  `acc_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_account`
--

INSERT INTO `tb_account` (`acc_id`, `cust_id`, `balance`, `acc_type`) VALUES
(111000001, 100000001, 5000, 'saving'),
(111000002, 100000001, 10000, 'current');

-- --------------------------------------------------------

--
-- Table structure for table `tb_customer`
--

CREATE TABLE `tb_customer` (
  `cust_id` int(11) NOT NULL,
  `cust_ssn_id` int(11) NOT NULL,
  `cust_name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `addr` text NOT NULL,
  `state` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_customer`
--

INSERT INTO `tb_customer` (`cust_id`, `cust_ssn_id`, `cust_name`, `age`, `addr`, `state`, `city`) VALUES
(100000001, 800000001, 'soni jadhav', 23, 'khadki,pune', 'Maharashtra', 'pune'),
(100000002, 800000002, 'rajesh singh', 25, 'ramwadi', 'Maharashtra', 'mumbai');

-- --------------------------------------------------------

--
-- Table structure for table `tb_cust_acc_status`
--

CREATE TABLE `tb_cust_acc_status` (
  `cust_id` int(11) NOT NULL,
  `acc_id` int(11) NOT NULL,
  `acc_type` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `message` text NOT NULL,
  `last_updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cust_acc_status`
--

INSERT INTO `tb_cust_acc_status` (`cust_id`, `acc_id`, `acc_type`, `status`, `message`, `last_updated`) VALUES
(100000001, 111000001, 'saving', 'kkkk', 'aswqsas', '2020-06-13 08:20:34');

-- --------------------------------------------------------

--
-- Table structure for table `tb_transaction`
--

CREATE TABLE `tb_transaction` (
  `trans_id` int(11) NOT NULL,
  `discrip` varchar(100) NOT NULL,
  `dt` date NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `acc_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_transaction`
--

INSERT INTO `tb_transaction` (`trans_id`, `discrip`, `dt`, `amount`, `acc_id`) VALUES
(1, 'withdraw', '2020-06-09', '100', 111000001),
(2, 'deposit', '2020-06-25', '100', 111000001);

-- --------------------------------------------------------

--
-- Table structure for table `tb_userstore`
--

CREATE TABLE `tb_userstore` (
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `logged_in` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `sign_out` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_userstore`
--

INSERT INTO `tb_userstore` (`username`, `password`, `logged_in`, `sign_out`) VALUES
('admin', 'admin', '2020-06-13 08:41:51', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_account`
--
ALTER TABLE `tb_account`
  ADD PRIMARY KEY (`acc_id`),
  ADD KEY `cust_id` (`cust_id`);

--
-- Indexes for table `tb_customer`
--
ALTER TABLE `tb_customer`
  ADD PRIMARY KEY (`cust_id`);

--
-- Indexes for table `tb_cust_acc_status`
--
ALTER TABLE `tb_cust_acc_status`
  ADD PRIMARY KEY (`acc_id`,`cust_id`),
  ADD KEY `cust_id` (`cust_id`);

--
-- Indexes for table `tb_transaction`
--
ALTER TABLE `tb_transaction`
  ADD PRIMARY KEY (`trans_id`),
  ADD KEY `acc_id` (`acc_id`);

--
-- Indexes for table `tb_userstore`
--
ALTER TABLE `tb_userstore`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_account`
--
ALTER TABLE `tb_account`
  MODIFY `acc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111000003;

--
-- AUTO_INCREMENT for table `tb_customer`
--
ALTER TABLE `tb_customer`
  MODIFY `cust_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100000003;

--
-- AUTO_INCREMENT for table `tb_transaction`
--
ALTER TABLE `tb_transaction`
  MODIFY `trans_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_account`
--
ALTER TABLE `tb_account`
  ADD CONSTRAINT `tb_account_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `tb_customer` (`cust_id`) ON DELETE CASCADE;

--
-- Constraints for table `tb_cust_acc_status`
--
ALTER TABLE `tb_cust_acc_status`
  ADD CONSTRAINT `tb_cust_acc_status_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `tb_customer` (`cust_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `tb_cust_acc_status_ibfk_2` FOREIGN KEY (`acc_id`) REFERENCES `tb_account` (`acc_id`) ON DELETE CASCADE;

--
-- Constraints for table `tb_transaction`
--
ALTER TABLE `tb_transaction`
  ADD CONSTRAINT `tb_transaction_ibfk_1` FOREIGN KEY (`acc_id`) REFERENCES `tb_account` (`acc_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
