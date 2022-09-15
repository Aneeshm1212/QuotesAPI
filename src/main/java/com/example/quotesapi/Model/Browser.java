package com.example.quotesapi.Model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Node("Browser")
public class Browser {

    @Id @GeneratedValue
    private  Long id;
    private String browser_name;

    @Relationship(type = "Mapping" ,direction = Relationship.Direction.INCOMING)
    public Set<Quote> BrowserSpecificQuotes;



    public  void quoteBrowserMapper(Quote quote){
        if (BrowserSpecificQuotes == null) {
            BrowserSpecificQuotes = new HashSet<>();
        }
        BrowserSpecificQuotes.add(quote);
    }



    public long getId() {
        return id;
    }


    public String getBrowser_name() {
        return browser_name;
    }

    public void setBrowser_name(String browser_name) {
        this.browser_name = browser_name;
    }
}
