# flightsearch
searchflights html ne radi, tako da poziv zovem preko postmana, POST input raw JSON body : 
Primjer:
{
    "polazniA": "AMS",
    "odredisniA": "VCE",
    "datumPolaska": "2023-01-10",
    "datumPovratka": "2023-01-18",
    "brPutnika": 4,
    "valuta": "EUR"
}

Stavio sam da se ispisuju svi mogući rezultati, ako zbog testiranja zelite smanjiti koliko ih se pretražuje, u FlightServiceImpl odkomentirati ".and("max", zeljeni broj pretraga)"

Baza se kreira u http://localhost:7000/h2-console/
username: root
pass: root

