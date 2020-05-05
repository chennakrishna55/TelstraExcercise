package com.telstra.codechallenge.assignment;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
public class UsersResponse {
	
	private List<User> items;

	public List<User> getItems() {
		return items;
	}

	public void setItems(List<User> items) {
		this.items = items;
	}

	

}
