package com.venkyms.rest.webservices.resfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetsRepository extends JpaRepository<Tweets, Integer> {
}
