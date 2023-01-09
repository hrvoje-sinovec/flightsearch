package kingict.airplanesearch.facade.impl;

import com.amadeus.exceptions.ResponseException;
import kingict.airplanesearch.entity.Flight;
import kingict.airplanesearch.facade.FlightFacade;
import kingict.airplanesearch.service.FlightService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightFacadeImpl implements FlightFacade {

    private final FlightService service;

    public FlightFacadeImpl(FlightService service) {
        this.service = service;
    }


    @Override
    public List<Flight> getAll(Flight flight) throws ResponseException {
        return service.getAll(flight);
    }

    @Override
    public void save(Flight flight) {
        service.save(flight);
    }
}
