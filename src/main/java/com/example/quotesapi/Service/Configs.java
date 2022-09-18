package com.example.quotesapi.Service;

import com.example.quotesapi.Model.Quote;

import java.util.Set;

public interface Configs {
    Quote quoteRandomly();
    Set<Quote> quoteByBrowser(Long browser);
    Quote quoteByBrowserAndCountry(Long browser, Long country);
    Set<Quote> quoteByCountry(Long country);
}
