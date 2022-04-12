package hh.palvelinohjelmoiti.artlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmoiti.artlist.domain.Art;
import hh.palvelinohjelmoiti.artlist.domain.ArtRepository;
import hh.palvelinohjelmoiti.artlist.domain.Artist;
import hh.palvelinohjelmoiti.artlist.domain.ArtistRepository;

@SpringBootApplication
public class ArtListApplication {

	private static final Logger log = LoggerFactory.getLogger(ArtListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ArtListApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ArtRepository repository, ArtistRepository arepository) {
		return (args) -> {

			Artist r1 = new Artist(null, "Vincent Van Gogh");
			Artist r2 = new Artist(null, "Leonardo DaVinci");
			Artist r3 = new Artist(null, "Edvard Munchen");

			arepository.save(r1);
			arepository.save(r2);
			arepository.save(r3);

			Art a1 = new Art(null, "Mona Lisa", 1503, "Yhtiä maailman tunnetuimpia maalauksia Leonardo DaVincilta",
					arepository.findByName("Leonardo DaVinci").get(0));
			Art a2 = new Art(null, "Huuto", 1893, "Edvard Munchin tunntetumpia tauluja",
					arepository.findByName("Edvard Munchen").get(0));
			Art a3 = new Art(null, "The Starry night", 1889,
					"Vincent van Goghin tunnetuin öljymaalaus, jonka maalasi mielisairaalassa",
					arepository.findByName("Vincent Van Gogh").get(0));
			Art a4 = new Art(null, "Pyhä Ehtoollinen", 1498, "Kristinuskon tunnetuimpia maalauksia",
					arepository.findByName("Leonardo DaVinci").get(0));

			repository.save(a1);
			repository.save(a2);
			repository.save(a3);
			repository.save(a4);

			log.info("fetch all books");
			for (Art art : repository.findAll()) {
				log.info(art.toString());
			}

		};
	};
}
