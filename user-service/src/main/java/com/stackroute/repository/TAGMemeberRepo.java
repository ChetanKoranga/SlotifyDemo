package com.stackroute.repository;

import com.stackroute.Models.TAGMemeber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TAGMemeberRepo extends MongoRepository<TAGMemeber,String> {
}
