package com.venkyms.rest.webservices.resfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // extends JpaRepository, taking entity and primary key
}
