package ca.sheridancollege.makaju.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.makaju.beans.AuthenticationRequest;
import ca.sheridancollege.makaju.beans.AuthenticationResponse;
import ca.sheridancollege.makaju.services.AuthenticationService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService authService;
	
	@PostMapping(value= {"/register"}, consumes="application/json")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
		
		return ResponseEntity.ok(authService.register(request));
		
	}

	@PostMapping(value= {"/authenticate"}, consumes="application/json")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		
		return ResponseEntity.ok(authService.authenticate(request));
		
	}
}
