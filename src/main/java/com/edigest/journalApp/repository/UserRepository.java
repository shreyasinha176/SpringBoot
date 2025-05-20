package com.edigest.journalApp.repository;

import com.edigest.journalApp.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, ObjectId> {
    Users findByUserName(String username);
    void deleteByUserName(String username);
}
