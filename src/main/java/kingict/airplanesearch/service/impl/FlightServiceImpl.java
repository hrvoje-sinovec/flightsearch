package kingict.airplanesearch.service.impl;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import kingict.airplanesearch.entity.Flight;
import kingict.airplanesearch.mapper.FlightMapper;
import kingict.airplanesearch.repository.FlightRepository;
import kingict.airplanesearch.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kingict.airplanesearch.entity.Amadeus.amadeus;

@Service
public class FlightServiceImpl implements FlightService {

    public FlightServiceImpl(FlightRepository repository, FlightMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private final FlightRepository repository;
    private final FlightMapper mapper;
    private int br = 0;
    private int brIt = 0;
    private int brSeg = 0;
    private String arrival;

    @Override
    public List<Flight> getAll(Flight flight) throws ResponseException {

        List<Flight> flights = new ArrayList<>();
        flights.removeAll(flights);

        //try catch block da ulovi exception ako ne postoji taj flight ili krivo upisani parametri
        try {

            //pretraga flightova po parametrima danim na frontendu
            FlightOfferSearch[] flightOfferSearches = amadeus.shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", flight.getPolazniA())
                            .and("destinationLocationCode", flight.getOdredisniA())
                            .and("departureDate", flight.getDatumPolaska())
                            .and("returnDate", flight.getDatumPovratka())
                            .and("adults", flight.getBrPutnika())
                            .and("max", flight.getBrLetova())
                            .and("currencyCode", flight.getValuta()));

            System.out.println(flightOfferSearches);

            //dohvat departure i arrival dateova

            for (FlightOfferSearch flightOfferSearch : flightOfferSearches) {

                Flight returnFlight = new Flight();
                ArrayList<FlightOfferSearch.AirportInfo> departSegments = new ArrayList<>();
                ArrayList<FlightOfferSearch.AirportInfo> arriveSegments = new ArrayList<>();

                brIt = 0;
                for (FlightOfferSearch.Itinerary itinerary : flightOfferSearch.getItineraries()) {
                    brIt++;

                    if (brIt == 2) {
                        br = 0;
                        for (FlightOfferSearch.SearchSegment searchSegment : itinerary.getSegments()) {
                            br++;
                            if (br == 1)
                                arrival = searchSegment.getDeparture().getIataCode();
                        }
                    }

                    for (FlightOfferSearch.SearchSegment searchSegment : itinerary.getSegments()) {

                        departSegments.add(searchSegment.getDeparture());
                        arriveSegments.add(searchSegment.getArrival());
                        brSeg++;

                        System.out.println("Broj: " + brSeg);
                        System.out.println("Departure: " + searchSegment.getDeparture());
                        System.out.println("Arrival: " + searchSegment.getArrival());


                        System.out.println("---------------------------------");
                    }
                }

                returnFlight.setBrDostSjedala((long) (brSeg / 2) - 1);
                returnFlight.setBrPutnika(flight.getBrPutnika());
                returnFlight.setOpis(flightOfferSearch.getSource());
                mapper.map(returnFlight, flightOfferSearch, departSegments.get(0), arrival, arriveSegments.get(arriveSegments.size() - 1));

                repository.save(returnFlight);
                flights.add(returnFlight);

                System.out.println(brIt);
                System.out.println(brSeg);
                brSeg = 0;
                System.out.println("------------------------");
            }


        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ne postoji taj flight: " +
                    flight.getPolazniA() + " > " + flight.getOdredisniA());
        } catch (com.amadeus.exceptions.ClientException e) {
            System.err.println("Krivi upis: Client Exception:" + e.getMessage());
        }
        //vraća listu flightova koji odgovaraju parametrima
        return flights;
    }

    @Override
    public void save(Flight flight) {
        repository.save(flight);
    }
}
