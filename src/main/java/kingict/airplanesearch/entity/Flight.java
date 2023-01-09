package kingict.airplanesearch.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FLIGHTS")
public class Flight {

    @Id
    @Column(name = "FLIGHT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @Column(name = "POLAZNI_A")
    private String polazniA;

    @Column(name = "ODREDISNI_A")
    private String odredisniA;

    @Column(name = "DATUM_POLASKA")
    private String datumPolaska;

    @Column(name = "DATUM_POVRATKA")
    private String datumPovratka;

    @Column(name = "BR_PUTNIKA")
    private Long brPutnika;

    @Column(name = "DOSTUPNO_SJEDALA")
    private Long brDostSjedala;

    @Column(name = "UKUPNA_CIJENA")
    private String ukupnaCijena;

    @Column (name = "VALUTA")
    private String valuta;

    @Column(name = "OPIS")
    private String opis;

}
