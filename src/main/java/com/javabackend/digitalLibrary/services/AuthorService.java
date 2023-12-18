package com.javabackend.digitalLibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabackend.digitalLibrary.models.Author;
import com.javabackend.digitalLibrary.repos.AuthorRepos;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepos authorRepos;

	public Author createOrGetAuthor(Author myAuthor) {
		Author authorFromDB = authorRepos.findAuthor(myAuthor.getEmail());
		
		if(authorFromDB == null) {
			authorFromDB = authorRepos.save(myAuthor);
		}
		
		return authorFromDB;
	}

}
