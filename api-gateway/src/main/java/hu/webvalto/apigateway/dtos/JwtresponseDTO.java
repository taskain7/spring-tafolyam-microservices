package hu.webvalto.apigateway.dtos;

public class JwtresponseDTO {
    private final String token;

    public JwtresponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
