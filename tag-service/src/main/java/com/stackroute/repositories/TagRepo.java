/*
author: chetan.koranga,
date of creation: 18/05/22
*/
package com.stackroute.repositories;

import com.stackroute.models.SlotsBooked;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


// No need implementation, just one interface, and you have CRUD, thanks Spring Data!
public interface TagRepo extends MongoRepository<SlotsBooked, String> {
    List<SlotsBooked> findByTagEmailId(String tagEmailId);

    List<SlotsBooked> findByInterviewerEmailId(String email);

}
