-- Insert data into the user table
INSERT INTO `user` (`username`, `password`, `type`) VALUES
('candidate1', 'hashed_password1', 'candidate'),
('candidate2', 'hashed_password2', 'candidate'),
('manager1', 'hashed_password3', 'hiring_manager'),
('manager2', 'hashed_password4', 'hiring_manager'),
('manager3', 'hashed_password5', 'hiring_manager'),
('admin1', 'hashed_password_admin1', 'admin'),
('admin2', 'hashed_password_admin2', 'admin');

-- Insert data into the candidate table
INSERT INTO `candidate` (`user_id`, `full_name`, `email`, `address`, `phone`, `resume`) VALUES
(1, 'John Doe', 'johndoe@example.com', '123 Main St, Cityville', '123-456-7890', 'John Doe Resume...'),
(2, 'Jane Smith', 'janesmith@example.com', '456 Oak St, Townsville', '987-654-3210', 'Jane Smith Resume...');
(3, 'Mary Kate', 'marykate@example.com', '456 Oak St, Townsville', '987-654-3210', 'Mary Kate Resume...');

-- Insert data into the hiring_manager table
INSERT INTO `hiring_manager` (`user_id`, `full_name`, `email`, `department`, `phone`) VALUES
(3, 'Alice Johnson', 'alicejohnson@example.com', 'HR', '555-123-4567'),
(4, 'Bob Brown', 'bobbrown@example.com', 'Engineering', '555-987-6543'),
(5, 'Carol White', 'carolwhite@example.com', 'Sales', '555-456-7890');

-- Insert data into the admin table
INSERT INTO `admin` (`user_id`, `full_name`, `email`) VALUES
(6, 'Samuel Adams', 'samuel.adams@example.com'),
(7, 'Emily Clark', 'emily.clark@example.com');

-- Insert data into the job_listing table
INSERT INTO `job_listing` (`manager_id`, `department`, `listing_title`, `date_listed`, `date_closed`, `job_title`, `job_description`, `additional_information`, `listing_status`) VALUES
(1, 'HR', 'HR Manager Position', '2024-08-01 10:00:00', NULL, 'HR Manager', 'Responsible for managing HR operations...', 'Looking for experienced HR professionals.', 'Open'),
(2, 'Engineering', 'Software Engineer', '2024-08-05 12:00:00', NULL, 'Software Engineer', 'Develop and maintain software applications...', 'Preferably with full-stack experience.', 'Open'),
(3, 'Sales', 'Sales Executive', '2024-08-10 09:00:00', NULL, 'Sales Executive', 'Lead sales initiatives and manage client relations...', 'Experience in B2B sales required.', 'Open');

-- Insert data into the job_application table
INSERT INTO `job_application` (`candidate_id`, `job_id`, `date_applied`, `cover_letter`, `custom_resume`, `application_status`) VALUES
(1, 1, '2024-08-12 08:00:00', 'Cover letter for HR Manager position...', 'Custom resume tailored for HR Manager role...', 'Under Review'),
(2, 2, '2024-08-15 10:30:00', 'Cover letter for Software Engineer position...', 'Custom resume tailored for Software Engineer role...', 'Interview Scheduled'),
(1, 3, '2024-08-18 11:45:00', 'Cover letter for Sales Executive position...', 'Custom resume tailored for Sales Executive role...', 'Rejected');
