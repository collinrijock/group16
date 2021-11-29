package Scrumtious.Group.Project.BookDetails.Author;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.mongodb.core.mapping.DBRef;
import Scrumtious.Group.Project.BookDetails.Book.Book;

// Collection created in  database
@Entity
@Table(name = "AUTHOR")

public class Author{

    // Variables
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;

    // Variable with reference to books
    @ElementCollection
    @DBRef
    private Set<Book> books = new HashSet<>();

    // Default constructor
    public Author() {
        
    }

    // Constructor
    public Author(
                String id,
                String firstName,
                String lastName,
                String biography,
                String publisher,
                Set<Book> books){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
        this.books = books;
    }

    // Getters and Setters
    public String getAuthorId() {
        return id;
    }

    public void setAuthorId(String id) {
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

}// end class
