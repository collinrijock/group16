package Scrumtious.Group.Project.bookbrowsingfeature;


import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GenreConfig {

    @Bean
    CommandLineRunner commandLineRunner(GenreRepository repository) {
        return args -> {

            Genre PridePrejudice = new Genre(
                "9780141439518", 
                "Pride and Prejudice",
                "A novel of manners",
                9.99,
                "Jane Austen",
                "Romance",
                "Penguin Publishing Group",
                "1813",
                20000000,
                4.5
            );

            Genre Notebook = new Genre(
                "070993007508", 
                "The Notebook",
                "A classic tale of love",
                9.99,
                "Nicholas Sparks",
                "Romance",
                "Warner Books",
                "1996",
                105000000,
                4.7
            );

            Genre ItEnds = new Genre(
                "1501110365", 
                "It Ends With Us",
                "Love is fragile",
                11.99,
                "Colleen Hoover",
                "Romance",
                "Atria",
                "1996",
                21000,
                5.0
            );

            Genre It = new Genre(
                "9781501142970", 
                "IT",
                "Hauntingly Familiar",
                17.99,
                "Stephen King",
                "Horror",
                "Scribner",
                "1986",
                5000000,
                4.9
            );

            Genre Shadows = new Genre(
                "1250771900", 
                "The Shadows",
                "Lucid dreams and horror stories",
                2.99,
                "Alex North",
                "Horror",
                "Celadon Books",
                "2020",
                4000,
                3.3
            );

            Genre TheHaunting = new Genre(
                "0143039989", 
                "The Haunting of Hill House",
                "The greatest haunted house story every written",
                17.99,
                "Shirley Jackson",
                "Horror",
                "Penguin Publishing",
                "2006",
                5000000,
                5.0
            );

            Genre Frankenstein = new Genre(
                "9781435159624", 
                "Frankenstein",
                "Consequences of obsession",
                7.95,
                "Mary Shelly",
                "Fiction",
                "Berns",
                "1818",
                1000000,
                4.3
            );

            Genre FiveYears = new Genre(
                "9781435159624", 
                "In Five Years",
                "The next great love story",
                12.99,
                "Rebecca Serle",
                "Fiction",
                "Atria",
                "2021",
                20690,
                4.9
            );

            Genre LastFlight = new Genre(
                "9781435659624", 
                "The Last Flight",
                "The moral dillemas",
                9.48,
                "Julia Clark",
                "Fiction",
                "Berns",
                "2021",
                14742,
                2.1
            );

            Genre ThousandShips = new Genre(
                "9780063065390", 
                "A Thousand Ships",
                "A goddess of poetry",
                24.99,
                "Natalie Hayes",
                "Mythology",
                "Harper Collins",
                "2021",
                1000,
                3.8
            );

            Genre MagicalBeast = new Genre(
                "9780063075390", 
                "Mythical Creates and Magical Beasts",
                "Wide eyes and curious soul",
                24.99,
                "Zayden Stone",
                "Mythology",
                "Harper Collins",
                "2021",
                85,
                4.9
            );

            Genre Yokai = new Genre(
                "9780063065390", 
                "The Book of Yokai",
                "Mysterious creatures",
                17.76,
                "Michael Dylan Foster",
                "Mythology",
                "University of California Press",
                "2015",
                1186,
                3.2
            );

            Genre StrangePlanet = new Genre(
                "9780062970701", 
                "Strange Planet Existence Chronicle",
                "A charming guided journal",
                12.99,
                "Nathan W. Pyle",
                "Humor",
                "Harper Collins",
                "2020",
                98,
                4.4
            );

            Genre Anxious = new Genre(
                "9781162970701", 
                "Anxious People",
                "A brilliant and comforting read",
                12.99,
                "Fredrik Backman",
                "Humor",
                "Harper Collins",
                "2020",
                32665,
                1.9
            );

            Genre IsThis = new Genre(
                "9982982127619", 
                "Is This Anything?",
                "A charming guided journal",
                14.99,
                "Jerry Seinfeld",
                "Humor",
                "Audible",
                "2020",
                6175,
                4.6
            );

            Genre ButterflyHouse = new Genre(
                "9781982127619", 
                "The Butterfly House",
                "Solve the crime",
                13.99,
                "Kathrine Engberg",
                "Crime",
                "Galley Scout",
                "2021",
                1500,
                2.9
            );

            Genre CourtOwls = new Genre(
                "9781401235420", 
                "Batman Vol 1: The Court of Owls",
                "The capped crusader",
                14.99,
                "Scott Snyder",
                "Comic",
                "DC Comics",
                "2013",
                15000,
                4.9
            );

            Genre WheelTime = new Genre(
                "9781250768681", 
                "The Wheel of Time",
                "An epic fantasy",
                18.99,
                "Robert Jordan",
                "Sci-Fi",
                "Tom Doherty Publishing",
                "2020",
                1543,
                1.8
            );

            Genre After = new Genre(
                "9781912374335", 
                "After He Died",
                "Disturbing but compulsive",
                15.95,
                "Michael J. Malone",
                "Thriller",
                "Ornedo Books",
                "2018",
                10000,
                3.5
            );

            Genre Gustavo = new Genre(
                "9781536224160", 
                "Gustavo the Ghost",
                "A story of friendship",
                7.95,
                "Flavia Z. Drago",
                "Kids",
                "Candle Wick Press",
                "2021",
                954,
                4.3
            );

            repository.saveAll(
                List.of(PridePrejudice, Notebook, ItEnds, It, Shadows,
                TheHaunting, Frankenstein, ThousandShips, FiveYears, 
                LastFlight, MagicalBeast, Yokai, Anxious, IsThis,
                StrangePlanet, ButterflyHouse, CourtOwls, WheelTime,
                After, Gustavo)
            );

        };
        
    }
    
}
