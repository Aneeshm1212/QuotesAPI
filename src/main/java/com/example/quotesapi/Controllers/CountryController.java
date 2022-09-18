package com.example.quotesapi.Controllers;

import com.example.quotesapi.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping  ("/api/country/quoteCountryMapper")
    String quoteCountryMapper(@RequestParam Long CountryId,Long QuoteID){
        try{
        countryService.quoteMapper(CountryId,QuoteID);
        return "SUCCESS";
        }
        catch (Exception e){
            //System.out.println(e);
            return "Failed to MApp";
        }
    }
}
