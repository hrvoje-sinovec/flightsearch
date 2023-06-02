# flightsearch

---
ISPRAVAK: Aplikacija automatski pokreće adresu: http://localhost:7000

Dodao security i web pageve, aplikacija se pokreće adresom: http://localhost:7000

Sve funkcije su dozvoljene samo adminu za sad.

**ADMIN**

**Username:** hsinovec

**Password:** 123

---

Stavio sam da se ispisuju svi mogući rezultati, ako zbog testiranja zelite smanjiti koliko ih se pretražuje, u FlightServiceImpl odkomentirati **.and("max", zeljeni broj pretraga)**

```java
public class FlightServiceImpl implements FlightService {

  //          FlightOfferSearch[] flightOfferSearches = amadeus.shopping.flightOffersSearch.get(
  //                  Params.with("originLocationCode", flight.getPolazniA())
  //                          .and("destinationLocationCode", flight.getOdredisniA())
  //                          .and("departureDate", flight.getDatumPolaska())
  //                          .and("returnDate", flight.getDatumPovratka())
  //                          .and("adults", flight.getBrPutnika())
                              .and("max", 5) 
  //                          .and("currencyCode", flight.getValuta()));
            }
```

---

Baza se pristupa u http://localhost:7000/h2-console/

username: root

pass: root

---

Manual adrese:

Register user: http://localhost:7000/api/user/register

View users: http://localhost:7000/api/user/1 (id 1 je admin)

Search flights: http://localhost:7000/api/flight/search

Create flight: http://localhost:7000/api/flight/create (ne koristi se u aplikaciji)



