package com.example.quotesapi.Service;


import com.example.quotesapi.Model.Browser;
import com.example.quotesapi.Model.Country;
import com.example.quotesapi.Repository.BrowserRepository;
import com.example.quotesapi.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BrowserService {

    @Autowired
    private BrowserRepository browserRepository;

    @Autowired
    QuoteRepository quoteRepository;
    public void quoteBrowserMapper(Long browserId, Long quoteID) {
        Browser browser =browserRepository.findById(browserId).get();
        browser.quoteBrowserMapper(quoteRepository.findById(quoteID).get());
        browserRepository.save(browser);

    }
}
