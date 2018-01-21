package com.example.demo;

import com.example.demo.domain.els.Book;
import com.example.demo.els.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private BookService bookService;

	@Autowired
	private ElasticsearchTemplate esTemplate;

	@Before
	public void before() {
		esTemplate.deleteIndex(Book.class);
		esTemplate.createIndex(Book.class);
		esTemplate.putMapping(Book.class);
		esTemplate.refresh(Book.class);
	}

    @Test
	public void testSave() {

		Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
		bookService.save(book);


		Book testBook = bookService.findOne(book.getId());

		assertNotNull(testBook.getId());
		assertEquals(testBook.getTitle(), book.getTitle());
		assertEquals(testBook.getAuthor(), book.getAuthor());
		assertEquals(testBook.getReleaseDate(), book.getReleaseDate());


	}
}
