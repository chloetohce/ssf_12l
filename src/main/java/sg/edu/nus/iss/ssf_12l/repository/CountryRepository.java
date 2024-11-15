package sg.edu.nus.iss.ssf_12l.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.ssf_12l.model.country.Country;

@Repository
public class CountryRepository {
    
    List<Country> countryList = new ArrayList<>();

    public List<Country> getCountries() {
        instantiateList();
        return countryList;
    }

    private void instantiateList() {
        if (countryList.isEmpty()) {
            countryList.add(new Country("SG", "Singapore", "6000000"));
            countryList.add(new Country("MY", "Malaysia", "40000000"));
            countryList.add(new Country("CN", "China", "10000000"));
        }
    }

    public boolean createCountry(Country country) {
        countryList.add(country);
        return true;
    }
}
