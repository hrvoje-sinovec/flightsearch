package kingict.airplanesearch.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FlightDto {

    private String polazniA;

    private String odredisniA;

    private LocalDate datumPolaska;

    private LocalDate datumPovratka;

    private Long brPutnika;

    private String ukupnaCijena;

    private String valuta;
}
