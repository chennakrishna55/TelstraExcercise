package com.telstra.codechallenge.assignment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositoryService {

	@Autowired
	private RestTemplate restTemplate;

	public List<RepositoryDetails> getRepositories(String api) {

		// try {
		ResponseEntity<RepositoryDetailsList> responseEntity = restTemplate.getForEntity(api,
				RepositoryDetailsList.class);
		return responseEntity.getBody().getRdl();

	}/*
		 * catch (Exception e) { System.out.println(e.getMessage()); throw new
		 * RepositoryException("Exception Occured"); }
		 */

	// }
}
