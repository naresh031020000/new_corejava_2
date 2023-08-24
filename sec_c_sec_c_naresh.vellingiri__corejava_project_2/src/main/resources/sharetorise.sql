use sharetorise;

CREATE TABLE fundraiser (
id INT AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
description VARCHAR(300) NOT NULL,
funding_goal DOUBLE NOT NULL,
image_url VARCHAR(200) NOT NULL,
fund_ending_date DATE NOT NULL,
PRIMARY KEY(id),
CHECK(funding_goal >= 2000)
);

CREATE TABLE certificates(
id INT AUTO_INCREMENT,
fundraiser_id INT,
cert_number VARCHAR(50),
cert_image_url VARCHAR(300),
PRIMARY KEY (id),
FOREIGN KEY (fundraiser_id) REFERENCES fundraiser(id)
);

select * from fundraiser;