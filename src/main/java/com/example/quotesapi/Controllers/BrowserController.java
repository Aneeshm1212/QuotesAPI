package com.example.quotesapi.Controllers;

import com.example.quotesapi.Service.BrowserService;
import com.example.quotesapi.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowserController {
    @Autowired
    private BrowserService browserService;

    @GetMapping("/api/browser/quoteBrowserMapper")
        String quoteBrowserMapper(@RequestParam Long BrowserId, Long QuoteID){
        try{
            browserService.quoteMapper(BrowserId,QuoteID);
            return "SUCCESS";
        }
        catch (Exception e){
            //System.out.println(e);
            return "Failed to Mapp";
        }
    }
}
