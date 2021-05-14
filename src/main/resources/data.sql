INSERT INTO FITNESS_CENTAR (naziv, adresa, broj_telefona, email) VALUES ('Fit', 'Temerinska 15', '0657784112', 'fitns@gmail.com');

INSERT INTO SALA (kapacitet, oznaka, fitness_centar_id) VALUES (50, 'S1', 1);
INSERT INTO SALA (kapacitet, oznaka, fitness_centar_id) VALUES (35, 'S2', 1);
INSERT INTO SALA (kapacitet, oznaka, fitness_centar_id) VALUES (20, 'S3', 1);

INSERT INTO TRENING (naziv, opis, vreme, tip, trajanje, cena, prijavljenih, fitness_centar_id) VALUES ('kardio', '2021-05-12', '19h', 'kondicioni',  1.5, 250, 15, 1);
INSERT INTO TRENING (naziv, opis, vreme, tip, trajanje, cena, prijavljenih, fitness_centar_id) VALUES ('ples', '2021-05-12', '18h', 'tango',  2, 300, 20, 1);
INSERT INTO TRENING (naziv, opis, vreme, tip, trajanje, cena, prijavljenih, fitness_centar_id) VALUES ('joga', '2021-05-12', '12h', 'tralala',  1, 150, 15, 1);
INSERT INTO TRENING (naziv, opis, vreme, tip, trajanje, cena, prijavljenih, fitness_centar_id) VALUES ('crossfit', '2021-05-12', '21h', 'kondicioni',  1.5, 350, 10, 1);

INSERT INTO LISTA_TRENINGA (sala_id, trening_id) VALUES (1, 1);
INSERT INTO LISTA_TRENINGA (sala_id, trening_id) VALUES (2, 2);
INSERT INTO LISTA_TRENINGA (sala_id, trening_id) VALUES (1, 3);
INSERT INTO LISTA_TRENINGA (sala_id, trening_id) VALUES (3, 4);




CREATE TABLE TRENER(
	id INTEGER	NOT NULL AUTO_INCREMENT,
	korisnicko_ime  VARCHAR(128) NOT NULL,
	lozinka VARCHAR(128) NOT NULL,
	ime  VARCHAR(128) NOT NULL,
	telefon  VARCHAR(128) NOT NULL,
	email VARCHAR(128) NOT NULL,
	uloga VARCHAR(128) NOT NULL,
	rodjendan VARCHAR(128) NOT NULL,
	aktivan INTEGER NOT NULL,
	prosecnaOcena DOUBLE NOT NULL,
	fitness_centar_id INTEGER NOT NULL,

	PRIMARY KEY(id)
);
	
INSERT INTO TRENER (korisnicko_ime, lozinka, ime, telefon, email, uloga, rodjendan, aktivan, prosecnaOcena, fitness_centar_id) VALUES ('Ana', '1234', 'Ana', '0617784121', 'ana@gmail.com', 'trener', '1992-01-05', 1, 8.5, 1);
INSERT INTO TRENER (korisnicko_ime, lozinka, ime, telefon, email, uloga, rodjendan, aktivan, prosecnaOcena, fitness_centar_id) VALUES ('Nemanja', '1234', 'Nemanja', '0627784121', 'nemanja@gmail.com', 'trener', '1994-01-05', 1, 8.5, 1); 

CREATE TABLE CLAN(
	id INTEGER	NOT NULL AUTO_INCREMENT,
	korisnicko_ime  VARCHAR(128) NOT NULL,
	lozinka VARCHAR(128) NOT NULL,
	ime  VARCHAR(128) NOT NULL,
	telefon  VARCHAR(128) NOT NULL,
	email VARCHAR(128) NOT NULL,
	uloga VARCHAR(128) NOT NULL,
	rodjendan VARCHAR(128) NOT NULL,
	aktivan INTEGER NOT NULL,

	PRIMARY KEY(id)
);

INSERT INTO CLAN (korisnicko_ime, lozinka, ime, telefon, email, uloga, rodjendan, aktivan) VALUES ('Milos', '1234', 'Milos', '0657784121', 'milos@gmail.com', 'clan', '2001-04-11', 1);
INSERT INTO CLAN (korisnicko_ime, lozinka, ime, telefon, email, uloga, rodjendan, aktivan) VALUES ('Nikola', '1114', 'Nikola', '0657684121', 'nikola@gmail.com', 'clan', '1996-01-08', 1);
INSERT INTO CLAN (korisnicko_ime, lozinka, ime, telefon, email, uloga, rodjendan, aktivan) VALUES ('Jelena', '1224', 'Jelena', '0627714121', 'jelena@gmail.com', 'clan', '2000-07-01', 1);
INSERT INTO CLAN (korisnicko_ime, lozinka, ime, telefon, email, uloga, rodjendan, aktivan) VALUES ('Nina', '1234', 'Nina', '0657784121', 'nina@gmail.com', 'clan', '1998-01-05', 1);


CREATE TABLE ADMINISTRATOR(
	id INTEGER	NOT NULL AUTO_INCREMENT,
	korisnicko_ime  VARCHAR(128) NOT NULL,
	lozinka VARCHAR(128) NOT NULL,
	ime  VARCHAR(128) NOT NULL,
	telefon  VARCHAR(128) NOT NULL,
	email VARCHAR(128) NOT NULL,
	uloga VARCHAR(128) NOT NULL,
	rodjendan VARCHAR(128) NOT NULL,
	aktivan INTEGER NOT NULL,

	PRIMARY KEY(id)
);

INSERT INTO ADMINISTRATOR (korisnicko_ime, lozinka, ime, telefon, email, uloga, rodjendan, aktivan) VALUES ('Nemanja', '1556', 'Nemanja', '0654884121', 'nemanja@gmail.com', 'administrator', '1998-01-05', 1);