package com.telstra.codechallenge.assignment;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	static Logger logger = Logger.getLogger(UserService.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	public List<User> search(String api) {
		logger.info("Entered into search method");
		try {
			ResponseEntity<UsersResponse> forEntity = restTemplate.getForEntity(api, UsersResponse.class);
			return forEntity.getBody().getItems();
		} catch (Exception e) {
			e.getMessage();
			throw new UserServiceException("Service is down, Try after sometime");
		}
	}

}
