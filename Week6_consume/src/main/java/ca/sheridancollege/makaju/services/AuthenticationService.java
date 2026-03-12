package ca.sheridancollege.makaju.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.makaju.beans.AuthenticationRequest;
import ca.sheridancollege.makaju.beans.AuthenticationResponse;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Service
public class AuthenticationService {
	
	final private String USERNAME = "ronish";
	final private String PASSWORD = "1234";
	
	private String token= null;
	
	private String getBody() {
		AuthenticationRequest credentials = new AuthenticationRequest(USERNAME,PASSWORD);
		return JSONify(credentials);
		
	}
	
	private String JSONify(final AuthenticationRequest userInfo) {
		String toReturn = null;
		try {
			toReturn = new ObjectMapper().writeValueAsString(userInfo);
		}catch (JacksonException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	//from spring
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		if(token!=null) {
			String authToken = "Bearer " + token;
			headers.set("Authorization", authToken);
		}
		return headers;
		
	}
	
	private void authenticate(RestTemplate restTemplate) {
		HttpHeaders authenticationHeaders = getHeaders();
		String authenticationBody = getBody();
		HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody, authenticationHeaders);
		ResponseEntity<AuthenticationResponse> authenticationResponse= restTemplate.exchange("http://localhost:8080/api/v1/auth/authenticate", HttpMethod.POST,authenticationEntity,AuthenticationResponse.class);
		if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
			token = authenticationResponse.getBody().getToken();
		}
	}
	
	public <T> ResponseEntity<T> standardRequest(RestTemplate restTemplate, String url, HttpMethod methodType, Object objectToSend, Class<T> returnType){
		if (token == null) {
			authenticate(restTemplate);
		}
		HttpHeaders headers = getHeaders();
		HttpEntity<Object> request =new HttpEntity<>(objectToSend, headers);
		return (ResponseEntity<T>) restTemplate.exchange(url, methodType, request, returnType); 
		
	}
	
	
	

}
