package com.venkyms.rest.webservices.resfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactVersionController {

  @GetMapping(path = "v1/address")
  public ContactV1 contactV1() {
    return new ContactV1("Whitefield, Bangalore, 560066");
  }

  @GetMapping(path = "v2/address")
  public ContactV2 contactV2() {
    return new ContactV2(new Address("Whitefield", "Bangalore", "560066"));
  }

  @GetMapping(path = "address/param", params = "version=1")
  public ContactV1 paramV1() {
    return new ContactV1("Whitefield, Bangalore, 560066");
  }

  @GetMapping(path = "address/param", params = "version=2")
  public ContactV2 paramV2() {
    return new ContactV2(new Address("Whitefield", "Bangalore", "560066"));
  }

  @GetMapping(path = "address/header", headers = "API-VERSION=1")
  public ContactV1 headerV1() {
    return new ContactV1("Whitefield, Bangalore, 560066");
  }

  @GetMapping(path = "address/header", headers = "API-VERSION=2")
  public ContactV2 headerV2() {
    return new ContactV2(new Address("Whitefield", "Bangalore", "560066"));
  }

  @GetMapping(path = "address/produces", produces = "application/com.venkyms.app-v1+json")
  public ContactV1 producesV1() {
    return new ContactV1("Whitefield, Bangalore, 560066");
  }

  @GetMapping(path = "address/produces", produces = "application/com.venkyms.app-v2+json")
  public ContactV2 producesV2() {
    return new ContactV2(new Address("Whitefield", "Bangalore", "560066"));
  }
}
