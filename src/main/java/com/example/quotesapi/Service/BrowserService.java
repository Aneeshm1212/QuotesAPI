package com.example.quotesapi.Service;


import com.example.quotesapi.Model.Browser;
import com.example.quotesapi.Model.Country;
import com.example.quotesapi.Repository.BrowserRepository;
import com.example.quotesapi.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BrowserService implements Mapper {

    @Autowired
    private BrowserRepository browserRepository;

    @Autowired
    QuoteRepository quoteRepository;
//    public void quoteBrowserMapper(Long browserId, Long quoteID) {
//
//    }

    @Override
    public void quoteMapper(Long ConfigId, Long QuoteID) {
        Browser browser =browserRepository.findById(ConfigId).get();
        browser.quoteBrowserMapper(quoteRepository.findById(QuoteID).get());
        browserRepository.save(browser);

    }
}
