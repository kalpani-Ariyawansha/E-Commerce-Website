package com.SQA.QATestForShop.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPersonalDetailsRepository extends MongoRepository<UserPersonalDetails,String> {
}
