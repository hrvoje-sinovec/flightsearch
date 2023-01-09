package kingict.airplanesearch.mapper;

import com.amadeus.Airport;
import com.amadeus.resources.FlightOfferSearch;
import kingict.airplanesearch.dto.FlightDto;
import kingict.airplanesearch.entity.Flight;

public interface FlightMapper {

    public Flight map(Flight flight, FlightOfferSearch flightOfferSearch, FlightOfferSearch.AirportInfo depart, String arrive, FlightOfferSearch.AirportInfo arriveDate);
}
