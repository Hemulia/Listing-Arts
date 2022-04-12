package hh.palvelinohjelmoiti.artlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.palvelinohjelmoiti.artlist.domain.Art;
import hh.palvelinohjelmoiti.artlist.domain.ArtRepository;
import hh.palvelinohjelmoiti.artlist.domain.ArtistRepository;

@Controller
public class ArtController {

	@Autowired
	private ArtRepository repository;

	@Autowired
	private ArtistRepository arepository;

	@RequestMapping(value = { "/", "/artlist" })
	public String artList(Model model) {

		model.addAttribute("arts", repository.findAll());
		return "artlist";

	}

	@RequestMapping(value = "/newart", method = RequestMethod.GET)
	public String getNewArt(Model model) {
		model.addAttribute("art", new Art());
		return "artform";
	}

	@RequestMapping(value = "/saveart", method = RequestMethod.POST)
	public String saveArt(@ModelAttribute Art art) {
		repository.save(art);
		return "redirect:../arts";
	}

	// Poisto
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteArt(@PathVariable("id") Long artId, Model model) {
		repository.deleteById(artId);
		return "redirect:../artlist";
	}

	@RequestMapping(value = { "/add" })
	public String addArt(Model model) {

		model.addAttribute("art", new Art());
		model.addAttribute("artist", arepository.findAll());
		return "addart";
	}

}
