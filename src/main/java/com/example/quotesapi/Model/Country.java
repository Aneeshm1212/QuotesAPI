package com.example.quotesapi.Model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Node("Country")
public class Country {
    @Id @GeneratedValue
    private Long id;
    private String countryName;



    @Relationship(type = "Mapping" ,direction = Relationship.Direction.INCOMING)
    public Set<Quote> CountrySpecificQuotes;



    public  void quoteCountryMapper(Quote quote){
        if (CountrySpecificQuotes == null) {
            CountrySpecificQuotes = new HashSet<>();
        }
        CountrySpecificQuotes.add(quote);
    }

    public Long getId() {
        return id;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
