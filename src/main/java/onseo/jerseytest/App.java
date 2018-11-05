package onseo.jerseytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    //FIRST
    //TODO: Add functional tests and unit tests to this project:
    //TODO: Add mocks (specifically - WireMock) and appropriate stubs
    //TODO: to mock calls to my endpoints. Make sure dynamic port configuration
    //TODO: is being used so WireMockl server does not start using locked ports

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}