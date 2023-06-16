CREATE TABLE drone (
  id VARCHAR(100) NOT NULL PRIMARY KEY,
  battery_capacity INT,
  drone_state VARCHAR(255),
  model VARCHAR(255),
  weight_limit DOUBLE
);

CREATE TABLE medication (
  id VARCHAR(36) NOT NULL PRIMARY KEY,
  code VARCHAR(255),
  imageurl VARCHAR(255),
  name VARCHAR(255),
  weight DOUBLE,
  drone_id VARCHAR(100) NOT NULL,
  FOREIGN KEY (drone_id) REFERENCES drone(id)
);


CREATE TABLE drone_battery_level_history (
  id VARCHAR(36) NOT NULL PRIMARY KEY,
  battery_level INT,
  created_date DATETIME,
  serial_number VARCHAR(100)
);


