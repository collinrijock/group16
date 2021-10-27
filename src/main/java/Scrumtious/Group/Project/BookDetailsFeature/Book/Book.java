package Scrumtious.Group.Project.BookDetailsFeature.Book;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

// Collection created in database
@Document(collection = "bookdetails")

public class Book {

    // Variables
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

    // Default constructor
    public Book() {

    }

    // Constructor with all variables
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

    // Constructor without id (database will generate id)
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

    // Getters and Setters
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

}//end class

