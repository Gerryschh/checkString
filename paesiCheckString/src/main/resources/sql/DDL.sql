DROP SCHEMA IF EXISTS nazioni;
CREATE SCHEMA nazioni;
USE nazioni;

DROP TABLE IF EXISTS country;
CREATE TABLE country (
  nome_paese VARCHAR(50) NOT NULL PRIMARY KEY,
  alpha2_code VARCHAR(2) NOT NULL
);

DROP TABLE IF EXISTS alias;
CREATE TABLE alias (
  alias_paese VARCHAR(50) NOT NULL PRIMARY KEY,
  nome_paese VARCHAR(50) NOT NULL,
  algoritmo VARCHAR(20) NOT NULL,
  soglia DOUBLE(3,2) DEFAULT 1 NOT NULL,
  approvato BOOLEAN DEFAULT FALSE NOT NULL,
  FOREIGN KEY (nome_paese) REFERENCES country(nome_paese) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);

DROP TABLE IF EXISTS alias_unknown;
CREATE TABLE alias_unknown (
	input VARCHAR(50) NOT NULL PRIMARY KEY
	);