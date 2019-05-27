package com.venkyms.rest.webservices.resfulwebservices.versioning;

public class ContactV2 {
  private Address address;

  public ContactV2(Address address) {
    this.address = address;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
