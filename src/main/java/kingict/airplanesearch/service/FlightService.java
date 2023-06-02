package kingict.airplanesearch.service;

import com.amadeus.exceptions.ResponseException;
import kingict.airplanesearch.entity.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> getAll(Flight flight) throws ResponseException;


    void save(Flight flight);
}
