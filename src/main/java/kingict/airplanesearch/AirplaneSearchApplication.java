package kingict.airplanesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;



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

