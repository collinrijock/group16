package Scrumtious.Group.Project.bookbrowsing;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GenreService {

    private final List<Genre> genres = Arrays.asList(
            new Genre("Horror", "IT", "Stephen King"),
            new Genre("Romance", "Pride and Prejudice", "Jane Austen"),
            new Genre("Fiction", "Night Circus", "Erin Morgenstern"),
            new Genre("Mystery", "The Butterfly House", "Katrine Engberg"),
            new Genre("Kids", "Diary of a Whimpy Kid", "Jeff Kinney"),
            new Genre("Fiction", "Girl with the Dragon Tattoo", "Stieg Larsson"),
            new Genre("Teen", "House of Salt and Sorrows", "Erin A Craig"),
            new Genre("Literary Fiction", "Great Circle", "Maggie Shipstead"),
            new Genre("Humor", "Dad Jokes", "Jimmy Niro")
    );

    public List<Genre> getAllGenres() {
        return genres;
    }

    public Genre getGenre(String id) {
        return genres.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

}
