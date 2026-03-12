package ca.sheridancollege.makaju.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.beans.AuthenticationRequest;
import ca.sheridancollege.makaju.beans.AuthenticationResponse;
import ca.sheridancollege.makaju.beans.Role;
import ca.sheridancollege.makaju.beans.User;
import ca.sheridancollege.makaju.beans.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {
	
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;
	private JwtService jwtService;
	private AuthenticationManager authenticationManager;
	
	
	
	public AuthenticationResponse register(AuthenticationRequest request) {
		User user = User.builder()
						.email(request.getEmail())
						.password(passwordEncoder.encode(request.getPassword()))
						.role(Role.USER)
						.build();
		userRepo.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
		
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
		User user = userRepo.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

}
