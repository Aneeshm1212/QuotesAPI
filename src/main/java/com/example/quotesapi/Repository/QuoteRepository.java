package com.example.quotesapi.Repository;

import com.example.quotesapi.Model.Quote;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface QuoteRepository extends Neo4jRepository<Quote,Long> {

}
