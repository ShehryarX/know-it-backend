package io.knowit.backend.proto.response;

public class GetUserDetailsResponse {
    private String authToken;

    public GetUserDetailsResponse() {
    }

    public GetUserDetailsResponse(String authToken) {
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
