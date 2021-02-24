DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

INSERT INTO users
(username, first_name, last_name, email) VALUES
('tonyleiva', 'Tony', 'Leiva', 'tonyleiva@hotmail.com'),
('leti_psi', 'Leti', 'Souza', 'leti.psi@gmail.com'),
('nutristael', 'Stael', 'Hercules', 'tonyleiva@nutristael.com.br');