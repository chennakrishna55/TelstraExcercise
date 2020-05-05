package com.telstra.codechallenge.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.telstra.codechallenge.assignment.User;
import com.telstra.codechallenge.assignment.UserService;
import com.telstra.codechallenge.assignment.UsersController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

	public List<User> list;

	@InjectMocks
	private UsersController usersController;

	@MockBean
	private UserService userService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeClass
	public void initial() {
		list = new ArrayList<>();

		User user1 = new User(44, "errfree", "https://github.com/errfree");
		User user2 = new User(81, "engineyard", "https://github.com/engineyard");
		User user3 = new User(119, "ministrycentered", "https://github.com/ministrycentered");

		list.add(user1);
		list.add(user2);
		list.add(user3);
	}
	
	@AfterClass
	public void after() {
		list.remove(0);
		list.remove(1);
		list.remove(2);
	}

	@Test
	public void testSearch() {

		when(userService.search(Mockito.anyString())).thenReturn(list);

		List<User> result = usersController.search("followers:0", "joined", "asc", 5);
		
		assertEquals(result.size(), 30);
		
		assertThat(result.get(0).getHtml_url().equals(list.get(0).getHtml_url()));

		assertThat(result.get(1).getId() == list.get(1).getId());

		assertThat(result.get(2).getLogin().equals(list.get(3).getLogin()));
	}
}
