package com.venkyms.rest.webservices.resfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StaticFiltering {

  @GetMapping(path = "/filterData")
  public StaticFilteringModel getData() {
    return new StaticFilteringModel("Username", "password", "test@mail.com");
  }

  @GetMapping(path = "/filterDataList")
  public List<StaticFilteringModel> getDataList() {
    return Arrays.asList(
        new StaticFilteringModel("Username", "password", "test@mail.com"),
        new StaticFilteringModel("Username1", "password1", "test1@mail.com"));
  }
}
