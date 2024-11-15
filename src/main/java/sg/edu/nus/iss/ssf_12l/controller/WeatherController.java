package sg.edu.nus.iss.ssf_12l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.ssf_12l.model.country.Country;
import sg.edu.nus.iss.ssf_12l.service.CountryService;



@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    CountryService countryService;
    
    @GetMapping("")
    public String weather(@RequestParam MultiValueMap<String, String> map,
        //@PathVariable(required = true, name = "country") String city,
        //@RequestParam(name="metrics", defaultValue = "centimeters") String metric,
        Model model) {
        
        String city = map.getFirst("city");
        String metric = map.getFirst("metrics");
        model.addAttribute("city", city);
        model.addAttribute("metrics", metric);

        return "weather";
    }

    @GetMapping("/pagea")
    public String pageA(Model model) {
        String [] units = {"centimeter", "metre", "kilometre"};
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("units", units);
        return "pagea";
    }
    
    @GetMapping("/forma")
    public String showForm() {
        return "forma";
    }

    @PostMapping("forma")
    public String handlePageA(@RequestBody MultiValueMap<String, String> form) {
        for(String str : form.keySet()) {
            System.out.println(str + ">>>>> " + form.getFirst(str));
        }
        
        return "forma";
    }
    
    
}
