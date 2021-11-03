package Scrumtious.Group.Project.BookBrowsing;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Data
@Document("bookbrowsing")
public class Book {

    @Id
    private String id;

    private String isbn;
    private String title;
    private String description;
    private double price;
    private String author;
    private String genre;
    private String publisher;
    private int yearPublished;


    private int copiesSold;
    private double rating;

    public Book(String isbn, String title, String description, double price,
                String author, String genre, String publisher, int yearPublished,
                int copiesSold, double rating) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.rating = rating;
    }

}
