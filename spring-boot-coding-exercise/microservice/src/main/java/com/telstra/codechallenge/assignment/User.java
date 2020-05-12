package com.telstra.codechallenge.assignment;

public class User {

	private int id;
	private String login;
	private String html_url;
	
	

	public User() {
		super();
	}

	public User(int id, String login, String html_url) {
		super();
		this.id = id;
		this.login = login;
		this.html_url = html_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

}
