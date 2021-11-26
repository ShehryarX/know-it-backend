package io.knowit.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private final Auth auth = new Auth();

    private final OAuth2 oauth2 = new OAuth2();

    public static class Auth {
        // TODO: Make this read from properties.yaml
        private String tokenSecret = "926D96C90030DD58429D2751AC1BDBBC";
        private long tokenExpirationMsec = 864000000;

        public String getTokenSecret() {
            return tokenSecret;
        }

        public long getTokenExpirationMsec() {
            return tokenExpirationMsec;
        }
    }

    public static final class OAuth2 {
        // TODO: Same here
        public List<String> getAuthorizedRedirectUris() {
            ArrayList<String> list = new ArrayList<>();
            list.add("http://localhost:3000/oauth2/redirect");
            return list;
        }
    }

    public Auth getAuth() {
        return auth;
    }

    public OAuth2 getOauth2() {
        return oauth2;
    }
}