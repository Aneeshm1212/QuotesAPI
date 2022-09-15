package com.example.quotesapi.Service;

import com.example.quotesapi.Model.Country;
import com.example.quotesapi.Model.Quote;
import com.example.quotesapi.Repository.CountryRepository;
import com.example.quotesapi.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired private QuoteRepository quoteRepository;
    public void quoteCountryMapper(Long CountryId,Long QuoteId) {
        Country country =countryRepository.findById(CountryId).get();
        country.quoteCountryMapper(quoteRepository.findById(QuoteId).get());
        countryRepository.save(country);
         }
}
