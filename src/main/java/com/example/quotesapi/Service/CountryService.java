package com.example.quotesapi.Service;

import com.example.quotesapi.Model.Country;
import com.example.quotesapi.Model.Quote;
import com.example.quotesapi.Repository.CountryRepository;
import com.example.quotesapi.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements Mapper  {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired private QuoteRepository quoteRepository;
//    public void quoteCountryMapper(Long CountryId,Long QuoteId) {
//          }

    @Override
    public void quoteMapper(Long ConfigId, Long QuoteID) {
        Country country =countryRepository.findById(ConfigId).get();
        country.quoteCountryMapper(quoteRepository.findById(QuoteID).get());
        countryRepository.save(country);

    }
}
