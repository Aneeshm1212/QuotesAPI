package com.example.quotesapi.Model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
public class Quote {

    @Id @GeneratedValue
    private Long id;
    private String text;
    private String author;



    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Quote))
        {
        return false;
        }
        if(obj==this){
            return true;
        }

        Quote quote = (Quote) obj;

        return (quote.getId()==this.getId());

    }


    @Override
    public int hashCode() {
        return (int) getId();
    }
}
