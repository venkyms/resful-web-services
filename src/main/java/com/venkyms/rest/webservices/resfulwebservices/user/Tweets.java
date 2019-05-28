package com.venkyms.rest.webservices.resfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
public class Tweets {
  @Id @GeneratedValue private Integer id;

  private String message;

  // many tweets are related to one user, many to one
  // LAZY load user to avoid recursion here, tweets tries to retrieve User and User tries to
  // retrieve tweet
  // this will be loaded only when tweets.getUser() is called
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore   //avoid recursive call
  private User user;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Tweets{" + "id=" + id + ", message='" + message + '\'' + '}';
  }
}
