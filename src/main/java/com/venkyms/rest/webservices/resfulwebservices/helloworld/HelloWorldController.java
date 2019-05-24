package com.venkyms.rest.webservices.resfulwebservices.helloworld;

import com.venkyms.rest.webservices.resfulwebservices.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

  @Autowired private MessageSource messageSource;

  @RequestMapping(method = RequestMethod.GET, path = "/hello")
  public String hello() {
    return "Hello";
  }

  @GetMapping(path = "/helloworld")
  public String helloWorld() {
    return "Hello world";
  }

  @GetMapping(path = "/helloworld-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("hello bean");
  }

  @GetMapping(path = "/helloworld-bean/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("hello bean %s", name));
  }

  // here Accept-language is passed in requestheader, to avoid this in every method use next method
  @GetMapping(path = "/helloworld-i18")
  public String helloWorldInternationalization(
      @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
    return messageSource.getMessage("welcome.message", null, locale);
  }

  @GetMapping(path = "/helloworld-i18n")
  public String helloInternationalization() {
    // LocaleContextHolder.getLocale() is easier way to add localalization without passing in each method
    return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
  }
}
