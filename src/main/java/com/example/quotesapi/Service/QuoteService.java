package com.example.quotesapi.Service;

import com.example.quotesapi.Model.Quote;
import com.example.quotesapi.Repository.BrowserRepository;
import com.example.quotesapi.Repository.CountryRepository;
import com.example.quotesapi.Repository.QuoteRepository;
import com.sun.org.apache.xalan.internal.lib.ExsltSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private BrowserRepository browserRepository;
    public void quoteAdd(Quote q)
    {
            quoteRepository.save(q);
     }

    public List<Quote> getAll()
    {
            return quoteRepository.findAll();
    }


    public void quoteDelete(Long id) {
        quoteRepository.deleteById(id);
    }


    public Object quoteGetter(Long country , Long browser) {
        try{
           // System.out.println(country + " " + browser);
        if(country!=null && browser==null){
        return countryRepository.findById(country).get().CountrySpecificQuotes;
        }
        else if(browser!=null && country==null){
            return browserRepository.findById((browser)).get().BrowserSpecificQuotes;
        }
        else if(browser!=null && country!=null){
            Set<Quote> countrySpecificNotes= countryRepository.findById(country).get().CountrySpecificQuotes;
            Set<Quote> browserSpecificNotes =browserRepository.findById((browser)).get().BrowserSpecificQuotes;

            countrySpecificNotes.retainAll(browserSpecificNotes);
            //System.out.println(countrySpecificNotes);
            return countrySpecificNotes;

        }
        else{
        int id = (int)(Math.random()*quoteRepository.count()) ;
        return quoteRepository.findById((long)id);
    }}
        catch (Exception e){
            //System.out.println(e);
            int id = (int)(Math.random()*quoteRepository.count()) ;
            return quoteRepository.findById((long)id);
            }
    }



}
