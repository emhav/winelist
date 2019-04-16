package hh.swd20.Winelist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Winelist.domain.TypeRepository;
import hh.swd20.Winelist.domain.Wine;
import hh.swd20.Winelist.domain.WineRepository;

@Controller
public class WineController {
	@Autowired
	private WineRepository repository; 
	
	@Autowired
	private TypeRepository trepository; 
	
	//sisäänkirjautuminen
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	//listaa viinit
    @RequestMapping(value="/winelist")
    public String winelist(Model model) {	
        model.addAttribute("wines", repository.findAll());
        return "winelist";
    }
    
    //lisää uuden viinin
    @RequestMapping(value = "/add")
    public String addWine(Model model){
    	model.addAttribute("wine", new Wine());
    	model.addAttribute("types", trepository.findAll());
        return "addwine";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Wine wine){
        repository.save(wine);
        return "redirect:winelist";
    }    
    
    @RequestMapping(value = "/edit/{id}")
    public String addWine(@PathVariable("id") Long wineId, Model model){
    model.addAttribute("wine", repository.findById(wineId));
    model.addAttribute("types", trepository.findAll());
    return "editwine";
    }
    
    //poistaa olemessa olevan viinin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWine(@PathVariable("id") Long wineId, Model model) {
    	repository.deleteById(wineId);
        return "redirect:../winelist";
    }  
    
    //rest yksittäinen viini
    @RequestMapping(value="/wine/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Wine> findWineRest(@PathVariable("id") Long wineId) {	
    	return repository.findById(wineId);
    } 
    
    //rest kaikkien viinien listaus
    @RequestMapping(value="/wines", method = RequestMethod.GET)
    public @ResponseBody List<Wine> wineListRest() {	
        return (List<Wine>) repository.findAll();
    }
   
}
