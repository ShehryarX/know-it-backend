package io.knowit.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.knowit.backend.io.entity.UserEntity;
import io.knowit.backend.io.repository.UserEntityRepository;
import io.knowit.backend.proto.response.GetUserDetailsResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static io.knowit.backend.config.SecurityConstants.*;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private UserEntityRepository userEntityRepository;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                   UserEntityRepository userEntityRepository) {
        this.authenticationManager = authenticationManager;
        this.userEntityRepository = userEntityRepository;
        setFilterProcessesUrl(LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            UserEntity creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserEntity.class);
            UserEntity user = this.userEntityRepository.findByUsername(creds.getUsername());

            if (user == null) {
                throw new RuntimeException("User not registered");
            }

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getId(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String createJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String id = ((User)auth.getPrincipal()).getUsername();
        String token = createJwtToken(((User) auth.getPrincipal()).getUsername());

        Optional<UserEntity> user = userEntityRepository.findById(id);

        if (!user.isPresent()) {
            throw new Error("Failed to find registered user.");
        }

        ObjectMapper mapper = new ObjectMapper();
        GetUserDetailsResponse responseBody = new GetUserDetailsResponse();

        BeanUtils.copyProperties(user.get(), responseBody);

        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.getWriter().write(mapper.writeValueAsString(responseBody));
    }
}