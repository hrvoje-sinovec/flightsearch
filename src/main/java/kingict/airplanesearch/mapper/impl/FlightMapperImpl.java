package kingict.airplanesearch.mapper.impl;

import com.amadeus.resources.FlightOfferSearch;
import kingict.airplanesearch.dto.FlightDto;
import kingict.airplanesearch.entity.Flight;
import kingict.airplanesearch.mapper.FlightMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FlightMapperImpl implements FlightMapper {


    @Override
    public Flight map(Flight flight, FlightOfferSearch flightOfferSearch, FlightOfferSearch.AirportInfo depart, String arrive, FlightOfferSearch.AirportInfo arriveDate) {

        if (Objects.isNull(flightOfferSearch)) {
            return null;
        }

        flight.setPolazniA(depart.getIataCode());
        flight.setOdredisniA(arrive);
        flight.setDatumPolaska(depart.getAt());
        flight.setDatumPovratka(arriveDate.getAt());
        flight.setBrPutnika(flight.getBrPutnika());
//        flight.setBrDostSjedala((long) flightOfferSearch.getNumberOfBookableSeats());
        flight.setUkupnaCijena(flightOfferSearch.getPrice().getTotal());
        flight.setValuta(flightOfferSearch.getPrice().getCurrency());

        return flight;
    }
}
