package com.stackroute.repositories;

import com.stackroute.models.SlotUpdate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SlotUpdateRepo extends MongoRepository<SlotUpdate, String> {

}
