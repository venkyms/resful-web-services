package com.venkyms.rest.webservices.resfulwebservices.versioning;

public class ContactV1 {
  private String address;

  public ContactV1(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
