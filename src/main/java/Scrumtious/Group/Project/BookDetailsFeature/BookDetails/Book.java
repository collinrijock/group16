package Scrumtious.Group.Project.BookDetailsFeature.BookDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookdetails")

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
        name = "book_sequence",
        sequenceName = "book_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_sequence"
    )

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

    public Book() {

    }

    public Book(String id, 
                String isbn, 
                String name, 
                String description, 
                double price, 
                String author, 
                String genre, 
                String publisher, 
                int yearPublished, 
                int copiesSold){
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public Book(String isbn, 
                String name, 
                String description, 
                double price, 
                String author, 
                String genre, 
                String publisher, 
                int yearPublished, 
                int copiesSold){
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public String getBookId(){
        return id;
    }

    public void setBookId(String id){
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "Book{" +
        ", id= " + id +
        ", isbn= " + isbn +
        ", name= " + name +
        ", description= " + description +
        ", price= " + price +
        ", author= " + author +
        ", genre= " + genre +
        ", publisher= " + publisher +
        ", yearPublished= " + yearPublished +
        ", copiesSold= " + copiesSold +
        '}';
    }

}

