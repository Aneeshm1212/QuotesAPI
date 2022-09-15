package com.example.quotesapi.Repository;

import com.example.quotesapi.Model.Browser;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BrowserRepository extends Neo4jRepository<Browser,Long> {
}
