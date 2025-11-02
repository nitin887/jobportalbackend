package com.jobportalbackend.jobportalbackend.controller;

import com.jobportalbackend.jobportalbackend.dto.LoginRequest;
import com.jobportalbackend.jobportalbackend.dto.LoginResponse;
import com.jobportalbackend.jobportalbackend.security.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication Controller", description = "APIs for user authentication and JWT token generation")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Operation(summary = "Authenticate a user and generate a JWT", description = "Handles POST requests for user login. On successful authentication, it returns a JWT token.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authentication successful, JWT token returned"),
            @ApiResponse(responseCode = "401", description = "Invalid credentials, authentication failed")
    })
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getName(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getName());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(jwt));
    }
}