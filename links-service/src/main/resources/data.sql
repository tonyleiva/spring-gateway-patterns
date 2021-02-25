DROP TABLE IF EXISTS links;

CREATE TABLE links (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  text VARCHAR(250) NOT NULL,
  link VARCHAR(250) NOT NULL,
  position INT NOT NULL,
  active BIT
);

INSERT INTO links
(user_id, text, link, position, active) VALUES
(1, 'my insta', 'www.intagram.com', 1, 1),
(1, 'my face', 'www.facebook.com', 2, 1),
(2, 'my insta', 'www.intagram.com', 1, 1);