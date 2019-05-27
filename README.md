# resful-web-services
- Spring boot
- Content Negotiation 
    - in header send ```Accept = "application/xml"```, then the response should come in xml
- Internationalization
    - in header send ```Accept-language = "US"```
- HATEOAS
- SWAGGER
    - http://localhost:8080/v2/api-docs
    - http://localhost:8080/swagger-ui.html
- Actuator
    - http://localhost:8080/actuator
    - http://localhost:8080  (this should show HAL browser after maven dependency is added)
- Static Filtering
    - filter parameters from sending back in the response
    - see ```StaticFiltering, StaticFilteringModel```
- Dynamic Filtering
    - Filter parameters dynamically using MappingJacksonValue
    - see ```DynamicFiltering, DynamicFilteringModel ```   
    