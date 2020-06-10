CREATE DATABASE IF NOT EXISTS instagnam;
USE instagnam;
CREATE TABLE IF NOT EXISTS connessione (id INTEGER AUTO_INCREMENT, follower VARCHAR(100), followed VARCHAR(100), PRIMARY KEY (id) );
-- INSERT INTO connessione(follower, followed) VALUES ("Cristiano", "Gennaro");
-- INSERT INTO connessione(follower, followed) VALUES ("Gennaro", "Cristiano");
-- INSERT INTO connessione(follower, followed) VALUES ("Paolo", "Cristiano");
-- INSERT INTO connessione(follower, followed) VALUES ("Paolo", "Gennaro");
-- INSERT INTO connessione(follower, followed) VALUES ("Anna", "Antonino");
-- INSERT INTO connessione(follower, followed) VALUES ("Anna", "Benedetta");
