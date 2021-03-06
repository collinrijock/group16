package Scrumtious.Group.Project.BookDetails.Book;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Service
public class BookService{

   @Autowired
   BookRepository bookRepository;

   private MongoTemplate mongoTemplate;

   public BookService(MongoTemplate mongoTemplate){
    this.mongoTemplate = mongoTemplate;
   }

   public List<Book> getBookList(String authorKey){
      Query query = new Query();
      query.addCriteria(Criteria.where("someMap." + authorKey).exists(true));
      List<Book> books = mongoTemplate.find(query,Book.class);
      return books;
   }

   public Page<Book> getPages(Pageable page) {
      return bookRepository.findAll(page);
   }

}

