package sg.edu.nus.iss.ssf_12l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.ssf_12l.model.country.Country;
import sg.edu.nus.iss.ssf_12l.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> getCountries() {
        return countryRepository.getCountries();
    }

    public boolean createCountry(Country country) {
        return countryRepository.createCountry(country);
    }
}
