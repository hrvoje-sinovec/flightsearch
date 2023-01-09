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
VALUES ('FROM', 'TO', CURRENT_DATE(), CURRENT_DATE(), 3, 24, 24140, 'KN:(', 'TESTIRAM')