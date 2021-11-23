package Scrumtious.Group.Project.ShopCart;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Scrumtious.Group.Project.BookDetails.Book.Book;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


@Service
public class ShoppingCartService {

    private final ShoppingCartRepo shoppingCartRepo;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ShoppingCartService(ShoppingCartRepo shoppingCartRepo, MongoTemplate mongoTemplate){
        this.shoppingCartRepo = shoppingCartRepo;
        this.mongoTemplate = mongoTemplate;
    }

    public Book findBookByISBN(String isbn){

        Query query = new Query();
        query.addCriteria(Criteria.where("isbn").is(isbn));

        List<Book> bookList = mongoTemplate.find(query, Book.class);

        if(bookList.size() > 1){
            throw new IllegalStateException("Error: Too many books with isbn \"" + isbn + "\"");
        }else if(bookList.size() == 0){
            throw new IllegalStateException("Error: No books found with isbn \"" + isbn + "\"");
        }

        return bookList.get(0);
    }
    
}
