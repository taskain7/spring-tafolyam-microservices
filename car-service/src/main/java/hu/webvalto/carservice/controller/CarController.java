package hu.webvalto.carservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    @GetMapping("/name")
    public ResponseEntity<String> getCarName() {
        return new ResponseEntity<>("Toyota", HttpStatus.OK);
    }
}
