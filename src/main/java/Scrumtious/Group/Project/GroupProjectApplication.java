package Scrumtious.Group.Project;

import Scrumtious.Group.Project.BrowsingSorting.Books;
import Scrumtious.Group.Project.BrowsingSorting.BooksRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootApplication
//@EnableMongoRepositories
public class GroupProjectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GroupProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BooksRepository booksRepository, MongoTemplate mongoTemplate) {
		return args -> {

			Books book1 = new Books(
					"9781501142970",
					"IT",
					"The story follows the experiences of seven children as they are terrorized " +
							   "by an evil entity that exploits the fears of its victims to disguise itself " +
							   "while hunting its prey.",
					20.00,
					"Stephen King",
					"Horror",
					"Scribner",
					1986,
					1000000,
					5.0
			);

			Books book2 = new Books(
					"9788494407291",
					"Emma",
					"Emma, by Jane Austen, is a novel about youthful hubris and romantic misunderstandings. " +
							"It is set in the fictional country village of Highbury and the surrounding estates of Hartfield, Randalls and Donwell Abbey, " +
							"and involves the relationships among people from a small number of families.",
					19.99,
					"Jane Austen",
					"Romance",
					"Oxford University Press",
					1816,
					700000,
					4.9
			);

			Books book3 = new Books(
					"9781644734667",
					"The Christmas Pig",
					"A heartwarming, page-turning adventure about one child's love for his most treasured thing, " +
							"and how far he will go to find it. A tale for the whole family to fall in love with, " +
							"from one of the world's greatest storytellers.",
					18.99,
					"JK Rowling",
					"Children",
					"Scholastic Inc.",
					2021,
					400000,
					4.8
			);

			Books book4 = new Books(
					"9781435159570",
					"Dracula",
					"Jonathan Harker, a young English lawyer, as he travels to Transylvania. " +
							  "Harker plans to meet with Count Dracula.",
					17.99,
					"Bram Stoker",
					"Fiction",
					"Barns and Noble Inc.",
					1897,
					900000,
					4.7
			);

			Books book5 = new Books(
					"9781101658055",
					"Dune",
					"The novel tells the story of young Paul Atreides, heir apparent to Duke Leto Atreides and " +
							"scion of House Atreides, as he and his family relocate to the planet Arrakis, " +
							"the universe's only source of the spice melange.",
					16.99,
					"Frank Herbert",
					"Sci-Fi",
					"Penguin Publishing Group",
					1965,
					800000,
					4.6
			);

			Books book6 = new Books(
					"9781501167713",
					"Something Wicked This Way Comes",
					"It is about two 13-year-old best friends, Jim Nightshade and William Halloway, and their " +
							"nightmarish experience with a traveling carnival that comes to their Midwestern home, " +
							"Green Town, Illinois.",
					15.99,
					"Frank Herbert",
					"Horror",
					"Simon and Schuster",
					2017,
					200000,
					5.0
			);

			Books book7 = new Books(
					"9781501167713",
					"Far From the Maddening Crowd",
					"It tells the story of the young farmer Gabriel Oak and his love for and pursuit of the " +
							"elusive Bathsheba Everdene, whose wayward nature leads her to both tragedy and true love.",
					14.99,
					"Thomas Hardy",
					"Romance",
					"E-artnow",
					2017,
					100000,
					4.9
			);

			Books book8 = new Books(
					"9780062915627",
					"Eyes That Kiss in the Corners",
					"This lyrical, stunning picture book tells a story about learning to love and celebrate " +
							"your Asian-shaped eyes, in the spirit of Hair Love by Matthew A. Cherry, " +
							"and is a celebration of diversity.",
					13.99,
					"Joanna Ho, Dung Ho",
					"Children",
					"HarperCollins Publishers",
					2021,
					500000,
					4.8
			);

			Books book9 = new Books(
					"9781250217318",
					"The House in the Cerulean Sea",
					"The House in the Cerulean Sea is an enchanting love story, masterfully told, about the " +
							"profound experience of discovering an unlikely family in an unexpected place—and " +
							"realizing that family is yours.",
					12.99,
					"TJ Kline",
					"Fiction",
					"Tom Doherty Associates",
					2020,
					300000,
					4.7
			);

			Books book10 = new Books(
					"9780593357392",
					"Child of Light",
					"An all-new fantasy series about a human girl struggling to find her place in a magical " +
							"world she's never known. At nineteen, Auris Afton Grieg has led an . . . unusual life.",
					11.99,
					"Terry Brooks",
					"Sci-Fi",
					"Random House Publishing Group",
					2021,
					600000,
					3.8
			);
			booksRepository.saveAll(
					List.of(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10)
			);

		};
	}

}