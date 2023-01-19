package kingict.airplanesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@SpringBootApplication
public class AirplaneSearchApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(AirplaneSearchApplication.class, args);
        openHomePage();
    }

    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:7000");
    }
}

