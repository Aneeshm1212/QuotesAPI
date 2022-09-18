package com.example.quotesapi.Controllers;

import com.example.quotesapi.Model.Browser;
import com.example.quotesapi.Model.Country;
import com.example.quotesapi.Model.Quote;
import com.example.quotesapi.Service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quote/")

public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @PostMapping("/cr")
    String quoteAdd( @RequestBody Quote q){
        try{

        quoteService.quoteAdd(q);
        return "SUCCESS";
        }
        catch (Exception e){
            return  "FAILED IN CREATING ";
        }
    }

    @GetMapping
    void getAll(){
        List<Quote> test = quoteService.getAll();
        for(Quote q: test){
            System.out.println(q.getText()+"\n \t\t\t -"+q.getAuthor());
        }
    }

    @DeleteMapping("/dlt")
    String quoteDelete(@RequestParam Long id)
    {
        try{
            quoteService.quoteDelete(id);
            return "Success";
        }
        catch (Exception e){
            return "Error during Deletion";
        }
    }


    @GetMapping("/rand")
    Object quoteGetter(@RequestParam(required = false) Long country , Long browser ){
        try {
            System.out.println();
            return quoteService.quoteGetter(country,browser);
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
        }

}
