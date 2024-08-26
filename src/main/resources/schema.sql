-- Step 1: Drop the dependent tables first
DROP TABLE IF EXISTS `job_application`;
DROP TABLE IF EXISTS `job_listing`;
DROP TABLE IF EXISTS `hiring_manager`;
DROP TABLE IF EXISTS `candidate`;
DROP TABLE IF EXISTS `admin`;

-- Step 2: Drop the user table
DROP TABLE IF EXISTS `user`;

-- Step 3: Recreate the user table
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,  -- Increased length for hashed passwords
  `type` varchar(20) DEFAULT NULL,  -- E.g., 'candidate', 'hiring_manager', 'admin'
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Step 4: Recreate the candidate table with foreign key reference to user table
CREATE TABLE `candidate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `resume` text,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Step 5: Recreate the hiring_manager table with foreign key reference to user table
CREATE TABLE `hiring_manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `department` varchar(25) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Step 6: Recreate the admin table with foreign key reference to user table
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Step 7: Recreate the job_listing table with foreign key reference to hiring_manager table
CREATE TABLE `job_listing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `manager_id` int NOT NULL,
  `department` varchar(25) DEFAULT NULL,
  `listing_title` varchar(100) DEFAULT NULL,
  `date_listed` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `date_closed` timestamp NULL DEFAULT NULL,
  `job_title` varchar(45) DEFAULT NULL,
  `job_description` text,
  `additional_information` text,
  `listing_status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`manager_id`) REFERENCES `hiring_manager`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Step 8: Recreate the job_application table with foreign key references to candidate and job_listing tables
CREATE TABLE `job_application` (
  `id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `job_id` int NOT NULL,
  `date_applied` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cover_letter` text,
  `custom_resume` text,
  `application_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`candidate_id`) REFERENCES `candidate`(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`job_id`) REFERENCES `job_listing`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
