package com.example.quotesapi.Repository;

import com.example.quotesapi.Model.Quote;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface QuoteRepository extends Neo4jRepository<Quote,Long> {


    @Query("MATCH(q:Quote)-[:Mapping]->(b:Browser)" +
            "where ID(b)= $browserid with q MATCH(q:Quote)-[:Mapping]->(c:Country)" +
            " where ID(c)= $countryid  return q")
    Quote QueryWithCountryAndBrowser(@Param("browserid") long browserid , @Param("countryid") Long countryid);
}
