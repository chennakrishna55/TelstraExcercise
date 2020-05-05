package com.telstra.codechallenge.test;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.telstra.codechallenge.assignment.RepositoryDetailsList;
import com.telstra.codechallenge.assignment.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@MockBean
	private RestTemplate restTemplate;
		
	@Test
	public void testSearch() {
		
		
		when(restTemplate.getForEntity(Mockito.anyString(), RepositoryDetailsList.class)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		
		ResponseEntity<RepositoryDetailsList> responseEntity=restTemplate.getForEntity(Mockito.any(), RepositoryDetailsList.class);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		
		
	}
}
