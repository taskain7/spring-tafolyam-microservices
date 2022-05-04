package hu.webvalto.vendorservice.restclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class CarClient {

    private final static String URL = "http://localhost:8090/cars/name";


    private final RestTemplate restTemplate;

    public CarClient() {
        this.restTemplate = new RestTemplate();
    }

    @PostConstruct
    public void callRestApi() {
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        System.out.println("--------------------------");
        System.out.println(response);
        System.out.println("--------------------------");
    }
}
