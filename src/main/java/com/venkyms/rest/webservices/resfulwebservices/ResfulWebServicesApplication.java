package com.venkyms.rest.webservices.resfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class ResfulWebServicesApplication {

  public static void main(String[] args) {
    SpringApplication.run(ResfulWebServicesApplication.class, args);
  }

  @Bean
  public LocaleResolver localeResolver() {
    // use SessionLocaleResolver if Accept-language is passed in method in controller class
    // SessionLocaleResolver localeResolver = new SessionLocaleResolver();

    // use AcceptHeaderLocaleResolver, if locale is taken from context in controller class
    AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
    localeResolver.setDefaultLocale(Locale.US);
    return localeResolver;
  }

  // this can be configured in application properties by defining the message property
//  @Bean
//  public ResourceBundleMessageSource messageSource() {
//    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//    messageSource.setBasename("messages");
//    return messageSource;
//  }
}
