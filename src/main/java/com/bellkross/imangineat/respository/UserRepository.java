package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
