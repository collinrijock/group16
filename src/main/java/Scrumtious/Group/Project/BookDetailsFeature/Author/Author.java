package Scrumtious.Group.Project.BookDetailsFeature.Author;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

// Collection created in database
@Document(collection = "author")

public class Author {
    
    // Variables
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;

    // Default constructor
    public Author() {
        
    }

    // Constructor with all variables
    public Author(
                String id,
                String firstName,
                String lastName,
                String biography,
                String publisher){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }

    // Constructor without id (database will generate id)
    public Author(
                String firstName,
                String lastName,
                String biography,
                String publisher){
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }

    // Getters and Setters
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
