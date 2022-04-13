package hh.palvelinohjelmoiti.artlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmoiti.artlist.domain.Art;
import hh.palvelinohjelmoiti.artlist.domain.ArtRepository;
import hh.palvelinohjelmoiti.artlist.domain.Type;
import hh.palvelinohjelmoiti.artlist.domain.TypeRepository;

@SpringBootApplication
public class ArtListApplication {

	private static final Logger log = LoggerFactory.getLogger(ArtListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ArtListApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ArtRepository repository, TypeRepository trepository) {
		return (args) -> {

			Type r1 = new Type("Patsas");
			Type r2 = new Type("Maalaus");
			Type r3 = new Type("Arkkitehtuuri");
			Type r4 = new Type("Design");

			trepository.save(r1);
			trepository.save(r2);
			trepository.save(r3);
			trepository.save(r4);

			Art a1 = new Art(null, "Mona Lisa", "Leonardo DaVinci", 1503,
					"Yhtiä maailman tunnetuimpia maalauksia Leonardo DaVincilta",
					trepository.findByName("Maalaus").get(0));
			Art a2 = new Art(null, "Huuto", "Edvard Munchen", 1893, "Edvard Munchin tunntetumpia tauluja",
					trepository.findByName("Maalaus").get(0));
			Art a3 = new Art(null, "The Starry night", "Vincent Van Gogh", 1889,
					"Vincent van Goghin tunnetuin öljymaalaus, jonka maalasi mielisairaalassa",
					trepository.findByName("Maalaus").get(0));
			Art a4 = new Art(null, "Pyhä Ehtoollinen", "Leonardo DaVinci", 1498, "Kristinuskon tunnetuimpia maalauksia",
					trepository.findByName("Maalaus").get(0));
			Art a5 = new Art(null, "Daavid", "Michelangelo", 1504, "Firenzessä sijaitseva suuri marmoripatsas",
					trepository.findByName("Patsas").get(0));

			repository.save(a1);
			repository.save(a2);
			repository.save(a3);
			repository.save(a4);
			repository.save(a5);

			log.info("fetch all books");
			for (Art art : repository.findAll()) {
				log.info(art.toString());
			}

		};
	};
}
