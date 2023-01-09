package kingict.airplanesearch.facade;

import com.amadeus.exceptions.ResponseException;
import kingict.airplanesearch.entity.Flight;
import java.util.List;

public interface FlightFacade {

    List<Flight> getAll(Flight flight) throws ResponseException;

    void save(Flight flight);
}
