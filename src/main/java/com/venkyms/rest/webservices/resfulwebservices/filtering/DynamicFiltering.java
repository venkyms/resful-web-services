package com.venkyms.rest.webservices.resfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DynamicFiltering {

  @GetMapping(path = "/d-filterData")
  public MappingJacksonValue getData() {
    DynamicFilteringModel model =
        new DynamicFilteringModel("Username", "password", "test@mail.com");

    SimpleBeanPropertyFilter filter =
        SimpleBeanPropertyFilter.filterOutAllExcept("userName", "email");
    FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicFilter", filter);

    MappingJacksonValue value = new MappingJacksonValue(model);
    value.setFilters(filters);
    return value;
  }

  @GetMapping(path = "/d-filterDataList")
  public MappingJacksonValue getDataList() {
    List<DynamicFilteringModel> modelList =
        Arrays.asList(
            new DynamicFilteringModel("Username", "password", "test@mail.com"),
            new DynamicFilteringModel("Username1", "password1", "test1@mail.com"));

    SimpleBeanPropertyFilter filter =
        SimpleBeanPropertyFilter.filterOutAllExcept("userName", "email");
    FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicFilter", filter);
    MappingJacksonValue value = new MappingJacksonValue(modelList);
    value.setFilters(filters);

    return value;
  }
}
