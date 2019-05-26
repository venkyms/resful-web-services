package com.venkyms.rest.webservices.resfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "User Data model")
public class User {
  private Integer id;

  @Size(min = 2, message = "Invalid name")
  @ApiModelProperty(notes = "Name should be minimum 2 char")
  private String name;

  @Past
  @ApiModelProperty(notes = "Date should be in the past")
  private Date birthDate;

  public User(Integer id, String name, Date birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
}
