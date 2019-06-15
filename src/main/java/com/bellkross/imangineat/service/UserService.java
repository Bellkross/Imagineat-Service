package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudServiceImpl<User, Long> {

    @Autowired
    UserService(JpaRepository<User, Long> repository) {
        super(repository);
    }

}
