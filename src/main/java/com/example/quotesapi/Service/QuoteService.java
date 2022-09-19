package com.example.quotesapi.Service;

import com.example.quotesapi.Model.Quote;
import com.example.quotesapi.Repository.BrowserRepository;
import com.example.quotesapi.Repository.CountryRepository;
import com.example.quotesapi.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class QuoteService implements Configs {


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



    @Override
    public Quote quoteRandomly() {
        return quoteRepository.findById((long)(Math.random()*quoteRepository.count())).get();
    }

    @Override
    public Set<Quote> quoteByBrowser(Long browser) {
        return browserRepository.findById((browser)).get().BrowserSpecificQuotes;

    }

    @Override
    public Quote quoteByBrowserAndCountry(Long browser,Long country) {
        return quoteRepository.QueryWithCountryAndBrowser(browser,country);
    }

    @Override
    public Set<Quote> quoteByCountry(Long country) {
        return countryRepository.findById(country).get().CountrySpecificQuotes;
    }




    public Object quoteGetter(Long country , Long browser) {
        try {

            if(country!=null && browser!=null){
                Quote q =quoteByBrowserAndCountry(browser,country);
                if(q != null){
                    return q;
                }
                else {
                    return quoteRandomly();
                }
            }
            else if (browser!=null) {
                return quoteByBrowser(browser);
            }
            else if (country!=null) {
                return quoteByCountry(country);
            }
            else{
               // System.out.println("SS");
                return quoteRandomly();
            }
        }
        catch (Exception e)
        {
         return quoteRandomly();
        }
    }
}
