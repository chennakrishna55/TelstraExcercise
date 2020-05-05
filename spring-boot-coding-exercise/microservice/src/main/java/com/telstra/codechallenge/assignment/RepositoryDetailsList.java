package com.telstra.codechallenge.assignment;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class RepositoryDetailsList {

	private List<RepositoryDetails> rdl;

	public List<RepositoryDetails> getRdl() {
		return rdl;
	}

	public void setRdl(List<RepositoryDetails> rdl) {
		this.rdl = rdl;
	}
	
}
