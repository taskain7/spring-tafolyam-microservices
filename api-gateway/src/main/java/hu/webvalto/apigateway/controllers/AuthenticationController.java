package hu.webvalto.apigateway.controllers;

import hu.webvalto.apigateway.dtos.JwtRequestDTO;
import hu.webvalto.apigateway.dtos.JwtresponseDTO;
import hu.webvalto.apigateway.security.TokenManager;
import hu.webvalto.apigateway.services.MyUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final MyUserDetailsService myUserDetailsService;
    private final AuthenticationManager authenticationManager;
    private final TokenManager tokenManager;

    public AuthenticationController(MyUserDetailsService myUserDetailsService, AuthenticationManager authenticationManager, TokenManager tokenManager) {
        this.myUserDetailsService = myUserDetailsService;
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody JwtRequestDTO requestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(requestDTO.getUsername());
        String token = tokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtresponseDTO(token));
    }
}
