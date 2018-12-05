CREATE DATABASE testRestAPI;

USE testRestAPI;

CREATE TABLE `contact` (
  `name` VARCHAR(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` INT(3) NOT NULL,
  `dob` DATE NOT NULL,
  `email` VARCHAR(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` INT(11) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `contact`
  MODIFY `id` INT(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

INSERT INTO `contact` (`name`, `age`, `dob`, `email`, `id`) VALUES
('Nguyễn văn B', 22, '2017-11-15', 'vanb@gamil.com', 2),
('Nguyễn A', 22, '2017-11-01', 'test@gmail.com', 3),
('Nguyễn C', 23, '1997-11-01', 'test@gmail.com', 4),
('Test', 25, '1990-11-01', 'test@gmail.com', 5);

SELECT * FROM contact;