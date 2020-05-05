package com.telstra.codechallenge.assignment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
	
	
	@Value("${users.api}")
	 private String api;	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/api/users")
	public List<User> search(@RequestParam(name = "q") String queue,@RequestParam(name="sort") String sorttype, @RequestParam(name="order") String ordertype,@RequestParam(name="no") long no) {
	
		List<User> list=userService.search(String.format(api+"?q=%s", queue+"&sort="+sorttype+"&order="+ordertype));
		System.out.println(list.size());
		//List<User> list2=list.stream().sorted((e1,e2)->e1.getId()-e2.getId()).collect(Collectors.toList());
		//list2.forEach(e->System.out.println(e.getId()));
		return list.stream().limit(no).collect(Collectors.toList());
	}
}
