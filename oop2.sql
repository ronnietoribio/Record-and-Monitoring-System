-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2024 at 11:57 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cas`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `course` varchar(250) DEFAULT NULL,
  `department` varchar(250) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `course`, `department`, `date_insert`, `date_update`, `date_delete`, `status`) VALUES
(1, 'BSCS', 'CAS', NULL, '2024-06-09', '2024-06-11', 'Available'),
(2, 'BSINT', 'CAS', '2024-06-09', '2024-06-09', NULL, 'Available'),
(3, 'BSCS', 'CAS', '2024-06-11', NULL, NULL, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `full_name` varchar(250) DEFAULT NULL,
  `gender` varchar(250) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `year` varchar(250) DEFAULT NULL,
  `course` varchar(250) DEFAULT NULL,
  `semester` varchar(250) DEFAULT NULL,
  `section` varchar(250) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `student_id`, `full_name`, `gender`, `birth_date`, `age`, `year`, `course`, `semester`, `section`, `image`, `date_insert`, `date_update`, `date_delete`, `status`) VALUES
(1, 20240001, 'Student1', 'Male', '2017-06-30', 0, '2nd Year', 'BSINT', '1st Semester', 'A', 'C:UsersirvinDocumentsNetBeansProjectsMonitoring_SystemsrcStudent_Directory\\20230007.jpg', '2024-06-10', '2024-06-10', NULL, 'Active'),
(2, 20240010, 'student2', 'Male', '2024-06-20', 0, '2nd Year', 'BSINT', '2nd Semester', 'A', 'C:UsersirvinDocumentsNetBeansProjectsMonitoring_SystemsrcStudent_Directory\\20230008.jpg', '2024-06-10', '2024-06-10', NULL, 'Active'),
(11, 20240003, 'student3', 'Male', '2024-06-07', 0, '2nd Year', 'BSINT', '2nd Semester', 'B', 'C:\\Users\\irvin\\Documents\\NetBeansProjects\\Monitoring_System\\src\\Student_Directory\\20230009.jpg', '2024-06-11', '2024-06-11', NULL, 'Active'),
(12, 20240012, 'student4', 'Male', '2018-06-07', 0, '2nd Year', 'BSINT', '2nd Semester', 'B', 'C:\\Users\\irvin\\Documents\\NetBeansProjects\\Monitoring_System\\src\\Student_Directory\\20230010.jpg', '2024-06-11', '2024-06-11', NULL, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `student_grade`
--

CREATE TABLE `student_grade` (
  `id` int(11) NOT NULL,
  `studentNum` int(100) NOT NULL,
  `year` varchar(100) NOT NULL,
  `course` varchar(100) NOT NULL,
  `subject` varchar(250) DEFAULT NULL,
  `first_sem` double DEFAULT NULL,
  `second_sem` double DEFAULT NULL,
  `finals` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_grade`
--

INSERT INTO `student_grade` (`id`, `studentNum`, `year`, `course`, `subject`, `first_sem`, `second_sem`, `finals`) VALUES
(8, 20240001, '2nd Year', 'BSINT', NULL, 0, 0, 0),
(9, 20240012, '2nd Year', 'BSINT', NULL, 2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `subject_code` varchar(250) DEFAULT NULL,
  `subject` varchar(250) DEFAULT NULL,
  `course` varchar(250) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`id`, `subject_code`, `subject`, `course`, `date_insert`, `date_update`, `date_delete`, `status`) VALUES
(1, 'ITS201', 'System Integration & Architecture', 'BSINT', NULL, NULL, NULL, 'Available'),
(2, 'ITS200', 'Database Mgt. Systems I', 'BSINT', '2024-06-21', NULL, NULL, 'Available'),
(3, 'ITS205', 'Database Mgt. II', 'BSINT', '2024-06-09', '2024-06-09', NULL, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `teacher_id` varchar(250) DEFAULT NULL,
  `full_name` varchar(250) DEFAULT NULL,
  `gender` varchar(250) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `year_experience` varchar(250) DEFAULT NULL,
  `experience` varchar(250) DEFAULT NULL,
  `department` varchar(250) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `salary_status` varchar(250) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `teacher_id`, `full_name`, `gender`, `birth_date`, `year_experience`, `experience`, `department`, `salary`, `salary_status`, `image`, `date_insert`, `date_update`, `date_delete`, `status`) VALUES
(1, 'TID-1', 'Teacher1', 'Male', NULL, '4 Years or more', 'Web Developer', 'CAS', NULL, NULL, 'C:\\Users\\irvin\\Documents\\NetBeansProjects\\Monitoring_System\\src\\Teacher_Directory\\TID-1.jpg', '2024-06-10', '2024-06-11', NULL, 'Active'),
(2, 'TID-8', 'teacher2', 'Male', NULL, '4 Years or more', 'Programer', 'CAS', NULL, NULL, 'C:\\Users\\irvin\\Documents\\NetBeansProjects\\Monitoring_System\\src\\Teacher_Directory\\TID-1.jpg', '2024-06-10', '2024-06-11', NULL, 'Active'),
(9, 'TID-3', 'Teacher3', 'Male', NULL, '2 years', 'Programer', 'CAS', NULL, NULL, 'C:\\Users\\irvin\\Documents\\NetBeansProjects\\Monitoring_System\\src\\Teacher_Directory\\TID-3.jpg', '2024-06-11', '2024-06-11', NULL, 'Active'),
(10, 'TID-10', 'teacher4', 'Male', NULL, '4 Years or more', 'Web Developer', 'CAS', NULL, NULL, 'C:\\Users\\irvin\\Documents\\NetBeansProjects\\Monitoring_System\\src\\Teacher_Directory\\TID-4.jpg', '2024-06-11', '2024-06-11', NULL, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `teacher_handle`
--

CREATE TABLE `teacher_handle` (
  `id` int(11) NOT NULL,
  `teacher_id` varchar(250) DEFAULT NULL,
  `subject_code` varchar(250) DEFAULT NULL,
  `subject` varchar(250) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher_handle`
--

INSERT INTO `teacher_handle` (`id`, `teacher_id`, `subject_code`, `subject`, `date`, `status`) VALUES
(3, 'TID-3', 'ITS200', 'Database Mgt. Systems I', '2024-06-11', 'Inactive');

-- --------------------------------------------------------

--
-- Table structure for table `teacher_student`
--

CREATE TABLE `teacher_student` (
  `id` int(11) NOT NULL,
  `teacher_id` varchar(250) DEFAULT NULL,
  `stud_studentID` bigint(20) DEFAULT NULL,
  `stud_name` varchar(250) DEFAULT NULL,
  `stud_gender` varchar(250) DEFAULT NULL,
  `stud_year` varchar(250) DEFAULT NULL,
  `stud_course` varchar(250) DEFAULT NULL,
  `stud_subject` varchar(250) DEFAULT NULL,
  `stud_semester` varchar(250) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher_student`
--

INSERT INTO `teacher_student` (`id`, `teacher_id`, `stud_studentID`, `stud_name`, `stud_gender`, `stud_year`, `stud_course`, `stud_subject`, `stud_semester`, `date_insert`, `date_update`, `date_delete`, `status`) VALUES
(16, 'TID-1', 20240001, 'Student1', 'Male', '2nd Year', 'BSINT', NULL, '1st Semester', '2024-06-11', NULL, NULL, 'Active'),
(17, 'TID-10', 20240012, 'student4', 'Male', '2nd Year', 'BSINT', NULL, '2nd Semester', '2024-06-11', NULL, NULL, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Id` int(11) NOT NULL,
  `full_name` varchar(250) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Username` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `Role` varchar(100) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `teacher_id` varchar(250) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Id`, `full_name`, `Email`, `Username`, `Password`, `Role`, `student_id`, `teacher_id`, `Date`, `status`) VALUES
(1, NULL, 'admin@gmail.com', 'admin', 'user', 'Admin', NULL, NULL, NULL, 'Active'),
(2, 'Teacher1', 'teacher1@gmail.com', 'teacher1', 'teacher1', 'Teacher', NULL, 'TID-1', '2024-06-10', NULL),
(3, 'student1@gmail.com', 'Student1', 'student1', 'student1', 'Student', 20240001, NULL, '2024-06-10', NULL),
(4, 'student2@gmail.com', 'student2', 'student2', 'student2', 'Student', 20240002, NULL, '2024-06-10', NULL),
(5, 'teacher2', 'teacher2@gmail.com', 'teacher2', 'teacher2', 'Teacher', NULL, 'TID-8', '2024-06-10', NULL),
(6, 'student3@gmail.com', 'student3', 'student3', 'student3', 'Student', 20240003, NULL, '2024-06-11', NULL),
(7, 'Teacher3', 'teacher3@gmail.com', 'teacher3', 'teacher3', 'Teacher', NULL, 'TID-3', '2024-06-11', NULL),
(8, 'student@gmail.com', 'student4', 'student4', 'student4', 'Student', 20240012, NULL, '2024-06-11', NULL),
(9, 'teacher4', 'teacher4@gmaili.com', 'teacher4', 'teacher4', 'Teacher', NULL, 'TID-10', '2024-06-11', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_grade`
--
ALTER TABLE `student_grade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher_handle`
--
ALTER TABLE `teacher_handle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher_student`
--
ALTER TABLE `teacher_student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `student_grade`
--
ALTER TABLE `student_grade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `teacher_handle`
--
ALTER TABLE `teacher_handle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `teacher_student`
--
ALTER TABLE `teacher_student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
