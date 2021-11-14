package Scrumtious.Group.Project.BookDetails.Book;

import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Service
public class BookService{

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
}
