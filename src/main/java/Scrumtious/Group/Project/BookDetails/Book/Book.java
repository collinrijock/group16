package Scrumtious.Group.Project.BookDetails.Book;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.mongodb.core.mapping.DBRef;

import Scrumtious.Group.Project.BookDetails.Author.Author;

// Collection created in database
@Entity
@Table(name = "BOOK")


public class Book{

    // Variables
    @Id
    private String id;
    private String isbn;
    private String name;
    private String description;
    private double price;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;

    // Variable with reference to authors
    @ElementCollection
    @DBRef
    private Set<Author> author = new HashSet<>();

    // Default constructor
    public Book() {
        
    }

    // Constructor
    public Book(String id,
                String isbn, 
                String name, 
                String description, 
                double price, 
                String genre, 
                String publisher, 
                int yearPublished, 
                int copiesSold,
                Set<Author> author){
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.author = author;
    }

    public String getBookId() {
        return id;
    }

    public void setBookId(String id) {
        this.id = id;
    }

    public String getisbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished){
        this.yearPublished = yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold){
        this.copiesSold = copiesSold;
    }

    public Set<Author> getAuthors() {
        return author;
    }

    public void setAuthors(Set<Author> author) {
        this.author = author;
    }

}//end class