package kingict.airplanesearch.controller;

import com.amadeus.exceptions.ResponseException;
import kingict.airplanesearch.entity.Flight;
import kingict.airplanesearch.facade.FlightFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/flight")
public class FlightSearchController {

    private final FlightFacade facade;

    public FlightSearchController(FlightFacade facade) {
        this.facade = facade;
    }


    @PostMapping("/search")
    public String PostFlights(@RequestBody Flight flight, Model model) throws ResponseException {
        model.addAttribute("flights", facade.getAll(flight));
        return "flightslist";
    }

}

