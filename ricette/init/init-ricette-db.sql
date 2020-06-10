CREATE DATABASE IF NOT EXISTS instagnam;
USE instagnam;
CREATE TABLE IF NOT EXISTS ricetta_completa (id INTEGER AUTO_INCREMENT, autore VARCHAR(100), titolo VARCHAR(100), preparazione TEXT, PRIMARY KEY (id) );
-- INSERT INTO ricetta_completa(autore, titolo, preparazione) VALUES ("Cristiano", "Pizza al prosciutto", "Metti il prosciutto nel panino");
-- INSERT INTO ricetta_completa(autore, titolo, preparazione) VALUES ("Cristiano", "Pizza e mortazza", "Metti la mortadella nella pizza");
-- INSERT INTO ricetta_completa(autore, titolo, preparazione) VALUES ("Gennaro", "Tonno e fagioli", "Unisci i fagioli con il tonno");
-- INSERT INTO ricetta_completa(autore, titolo, preparazione) VALUES ("Antonino", "Pizza margherita", "... e alla fine inforna");
-- INSERT INTO ricetta_completa(autore, titolo, preparazione) VALUES ("Benedetta", "Tonno e fagioli", "Unisci il tonno con i fagioli");