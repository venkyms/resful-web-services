package com.venkyms.rest.webservices.resfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties(value = {"password"}) // you can define in the header with param names
public class StaticFilteringModel {
  private String userName;
  @JsonIgnore // this you can define on top of each field, or you can define in class header
  private String password;
  private String email;

  public StaticFilteringModel(String userName, String password, String email) {
    this.userName = userName;
    this.password = password;
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
