package com.javabackend.digitalLibrary.createRequest;

import com.javabackend.digitalLibrary.models.Author;
import com.javabackend.digitalLibrary.models.Book;
import com.javabackend.digitalLibrary.models.Genre;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookReq {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private Genre genre;
	
	@NotBlank
	private String authorName;
	
	@NotBlank
	@Email
	private String email;
	
	public Book to() {
		Author author = Author.builder().authName(authorName).email(email).build();
		
		return Book.builder().name(name).genre(genre).myAuthor(author).build();
	}
}
