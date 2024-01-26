CREATE TABLE IF NOT EXISTS Museum_Address (
  museum_address_id INT AUTO_INCREMENT PRIMARY KEY,
  line_one VARCHAR(250) NOT NULL,
    line_two VARCHAR(250) DEFAULT NULL,
    state VARCHAR(16) NOT NULL,
    post_code VARCHAR(250) NOT NULL,
    country VARCHAR(250) NOT NULL
    );
