package hh.palvelinohjelmoiti.artlist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.palvelinohjelmoiti.artlist.domain.Art;
import hh.palvelinohjelmoiti.artlist.domain.ArtRepository;
import hh.palvelinohjelmoiti.artlist.domain.TypeRepository;

@Controller
public class ArtController {

	@Autowired
	private ArtRepository repository;

	@Autowired
	private TypeRepository trepository;

	@RequestMapping(value = { "/", "/artlist" })
	public String artList(Model model) {

		model.addAttribute("arts", repository.findAll());
		return "artlist";

	}

	@RequestMapping(value = "artss", method = RequestMethod.GET)
	public @ResponseBody List<Art> artListaRest() {
		return (List<Art>) repository.findAll();
	}

	@RequestMapping(value = "/newart", method = RequestMethod.GET)
	public String getNewArt(Model model) {
		model.addAttribute("art", new Art());
		return "artform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveArt(Art art) {
		repository.save(art);
		return "redirect:/artlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/add" })
	public String addArt(Model model) {

		model.addAttribute("art", new Art());
		model.addAttribute("types", trepository.findAll());
		return "addart";
	}

	@RequestMapping(value = "/arts", method = RequestMethod.POST)
	public @ResponseBody Art saveArtRest(@RequestBody Art art) {
		return repository.save(art);
	}

	@RequestMapping(value = "/arts/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Art> findArtRest(@PathVariable("id") Long artId) {
		return repository.findById(artId);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteArt(@PathVariable("id") Long artId, Model model) {
		repository.deleteById(artId);
		return "redirect:../artlist";
	}

}
