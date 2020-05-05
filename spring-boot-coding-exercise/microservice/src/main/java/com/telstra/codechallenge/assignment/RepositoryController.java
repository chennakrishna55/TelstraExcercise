package com.telstra.codechallenge.assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RepositoryController {
	

	@Value("${repos.api}")
	 private String api;	
	
	@Autowired
	private RepositoryService repositoryService;
		
	@RequestMapping(value="/api/repositories")
	public List<RepositoryDetails> getHottestRepository(@RequestParam(name="q") String queue,@RequestParam(name="sort") String sorttype, @RequestParam(name="order") String ordertype) {
		
		System.out.println(queue);
		 return repositoryService.getRepositories(String.format(api+"?q=created>2013-07-15%s", "&sort="+sorttype+"&order="+ordertype));
	 }
	
	public String getHottestRepositoryFallback() {
		return "Git Hub is tempororly not available, Try after some time";
	}
	
	@GetMapping(value="/test")
	public String getHottestRepository() {
		return "test";
	 }
}
