package sg.edu.nus.iss.ssf_12l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.ssf_12l.model.country.Country;
import sg.edu.nus.iss.ssf_12l.service.CountryService;



@Controller
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping(path={"","/"})
    public String getCountries(Model model) {
        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);
        return "countries";
    }
    
    @GetMapping("/filter")
    public String filterCountries(@RequestParam("population") String population, Model model) {
        List<Country> countries = countryService.getCountries();
        countries = countries.stream()
            .filter(c -> Integer.parseInt(c.getPopulation()) >= Integer.parseInt(population))
            .toList();
        model.addAttribute("countries", countries);
        return "countries";
    }
    
}
