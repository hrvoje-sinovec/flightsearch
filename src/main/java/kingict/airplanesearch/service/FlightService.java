package kingict.airplanesearch.service;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import kingict.airplanesearch.entity.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> getAll(Flight flight) throws ResponseException;


    void save(Flight flight);
}
