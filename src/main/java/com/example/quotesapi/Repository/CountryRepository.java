package com.example.quotesapi.Repository;

import com.example.quotesapi.Model.Country;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CountryRepository  extends Neo4jRepository<Country,Long> {
}
