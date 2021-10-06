package Scrumtious.Group.Project.bookbrowsingfeature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookbrowsingfeature")
@Entity
@Table
public class Genre {

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
    private String year_published;
    private int copies_sold;
    private double rating;

    public Genre(){

    }

    public Genre(String id,
                 String isbn,
                 String name,
                 String description,
                 double price,
                 String author,
                 String genre,
                 String publisher,
                 String year_published,
                 int copies_sold,
                 double rating) {
    this.id = id;
    this.isbn = isbn;
    this.name = name;
    this.description = description;
    this.price = price;
    this.author = author;
    this.genre = genre;
    this.publisher = publisher;
    this.year_published = year_published;
    this.copies_sold = copies_sold;
    this.rating = rating;
    }

    public Genre(String isbn,
                 String name,
                 String description,
                 double price,
                 String author,
                 String genre,
                 String publisher,
                 String year_published,
                 int copies_sold,
                 double rating) {
    this.isbn = isbn;
    this.name = name;
    this.description = description;
    this.price = price;
    this.author = author;
    this.genre = genre;
    this.publisher = publisher;
    this.year_published = year_published;
    this.copies_sold = copies_sold;
    this.rating = rating;
    }   

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
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
    public void setDescription(String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
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
    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String getYear_published() {
        return year_published;
    }
    public void setYear_published(String year_published) {
        this.year_published = year_published;
    }


    public int getCopies_sold() {
        return copies_sold;
    }
    public void setCopies_sold(int copies_sold) {
        this.copies_sold = copies_sold;
    }


    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Books{" +
        ", id= " + id +
        ", isbn= " + isbn +
        ", name= " + name +
        ", description= " + description +
        ", price= " + price +
        ", author= " + author +
        ", genre= " + genre +
        ", publisher= " + publisher +
        ", yearPublished= " + year_published +
        ", copiesSold= " + copies_sold +
        ", rating= " + rating +
        '}';
    }

    
}
