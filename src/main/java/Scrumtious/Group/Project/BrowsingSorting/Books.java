package Scrumtious.Group.Project.BrowsingSorting;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document("sorting")
public class Books {

    @Id
    private String id;

    private String isbn;
    private String name;
    private String description;
    private double price;
    private String author;
    private String genre;
    private String publisher;
    private int yearPublished;

    private int copiesSold;
    private double rating;

    public Books(String isbn,
                String name,
                String description,
                double price,
                String author,
                String genre,
                String publisher,
                int yearPublished,
                int copiesSold,
                double rating) {
        this.isbn = isbn;
        this.name = name;
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

