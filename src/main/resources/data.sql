CREATE TABLE FLIGHTS (
                                FLIGHT_ID INTEGER PRIMARY KEY auto_increment,
                                POLAZNI_A VARCHAR(10),
                                ODREDISNI_A VARCHAR(10),
                                DATUM_POLASKA DATETIME,
                                DATUM_POVRATKA DATETIME,
                                BR_PUTNIKA INT,
                                DOSTUPNO_SJEDALA INT,
                                UKUPNA_CIJENA VARCHAR(20),
                                VALUTA VARCHAR(40),
                                OPIS VARCHAR(100),
                                CONSTRAINT FLIGHTS_DG_TMP_PK PRIMARY KEY (FLIGHT_ID)
);


INSERT INTO FLIGHTS (POLAZNI_A, ODREDISNI_A, DATUM_POLASKA, DATUM_POVRATKA, BR_PUTNIKA, DOSTUPNO_SJEDALA, UKUPNA_CIJENA, VALUTA, OPIS)
VALUES ('FROM', 'TO', CURRENT_DATE(), CURRENT_DATE(), 3, 24, 24140, 'KN:(', 'TESTIRAM');

CREATE TABLE USERS
(
    ID        NUMBER PRIMARY KEY AUTO_INCREMENT,
    FIRSTNAME VARCHAR(255),
    LASTNAME  VARCHAR(255),
    USERNAME  VARCHAR(255),
    PASSWORD  VARCHAR(255),
    ROLES     VARCHAR(255)
);

INSERT INTO USERS(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, ROLES)
VALUES ('Hrvoje', 'Sinovec', 'hsinovec', '$2a$10$lkMXCDzy/bny.jQv9PU32eLMNX5xI2Rd8KQbSPJe8.bsRA8wykz6W', 'ADMIN');
