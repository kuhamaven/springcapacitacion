package com.example.demo;

import com.example.demo.controllers.UserController;
import com.example.demo.models.AuthorModel;
import com.example.demo.services.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@Autowired
	private UserController userController;
	@Autowired
	private AuthorService authorService;

	@Test
	public void contextLoad() throws Exception {
		assertThat(userController).isNotNull();
	}

	@Test
	public void assertThatAuthorGetsCreated() throws Exception {
		LocalDate date = LocalDate.of(1965,7,31);
		AuthorModel author1 = new AuthorModel("Joanne","Rowling","British",date);
		authorService.saveAuthor(author1);
		Assertions.assertEquals(authorService.findAuthorById(1).getName(),"Joanne");
	}

	@Test
	public void assertThatAuthorGetsFetchedAndUpdated() throws Exception {
		AuthorModel author1 = createJoanneRowling();
		AuthorModel authorById = authorService.findAuthorById(1);
		Assertions.assertEquals(author1.getNationality(),authorById.getNationality());
		authorById.setPseudonym("J.K. Rowling");
		authorService.updateAuthor(authorById);
		Assertions.assertEquals(authorService.findAuthorById(1).getPseudonym(),"J.K. Rowling");
	}

	@Test
	public void assertThatAuthorGetsDeleted() throws Exception {
		createJoanneRowling();
		authorService.deleteAuthor(1);
		try {
			authorService.findAuthorById(1);
		}
		catch (Exception e){
			Assertions.assertEquals(e.getMessage(),"Author with id: 1 not found!");
		}
	}

	public AuthorModel createJoanneRowling(){
		LocalDate date = LocalDate.of(1965,7,31);
		AuthorModel author1 = new AuthorModel("Joanne","Rowling","British",date);
		authorService.saveAuthor(author1);
		return author1;
	}

}
