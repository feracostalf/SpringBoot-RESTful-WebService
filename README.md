# Demo project for Spring Boot
Restful Webservice

# topics
RestController, RequestMapping, PathParameters, StaticResorces, CustomizedExceptionHandler, HTTPStatus, ResponseEntity, RequestPath, RequestBody, DeleteMapping, Validations, CustomeValidationMessage, XML/JSON format, Languaje dataformat, Swagger, API Versioning, HETAOS, Serialization

URIs
Name resources in plural
- /users
- /users/1
- /users/1/posts/
- /users/1/posts/1

HTTP methods
- POST create new resource (@PostMapping / @RequestMapping - @Method=POST)
- PUT fully update resource
- DELETE delete a resource
- GET retreive resources
- PATCH partially update

Validations
- Add springboot starter validation dependency
    <dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
```
    @Size(min = 2, message = "size name must be > 2")
    private String name;
    @Past
    private LocalDate birthDate;
```

ContentNegotation
- Add messages_{lang}.properties file to customize language messages
- Add jackson-dataformat-xml dependency to parse data to XML format
```
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```
Test dataformat from request Headers
Accept: application-xml, application-json (format XML/JSON)
Accept-Language: 'en', 'es', 'fr' (Internalization messages)

SpringDoc - OpenApi
- Add springdoc to generate swagger from sourcecode
```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.7.0</version>
</dependency>
```
Go swagger-ui/index.html

Versioning
- URI
- v1/customer
```
    @GetMapping(path="v1/customer")
    public CustomerV1 retrieveFistVersionOfCustomer(){
        return new CustomerV1("Fernando Acosta");
    }
    //V2
    @GetMapping(path="v2/customer")
    public CustomerV2 retrieveSecondVersionOfCustomer(){
        return new CustomerV2(new Name("Fernando", "Acosta", 12345678));
    }
```

- Request Params
customer?version=1
customer?version=2
```
    @GetMapping(path="customer",params = "version=1")
    public CustomerV1 retrieveFistVersionOfCustomerRequestParam(){
        return new CustomerV1("Fernando Acosta");
    }
    //V2
    @GetMapping(path="customer", params = "version=2")
    public CustomerV2 retrieveSecondVersionOfCustomerRequestParam(){
        return new CustomerV2(new Name("Fernando", "Acosta", 12345678));
    }
```

- Header Request (Same url)
Add request Header (X-API-VERSION=1 / X-API-VERSION=2)
customer
```
    @GetMapping(path="customer/header",headers = "X-API-VERSION=1")
    public CustomerV1 retrieveFistVersionOfCustomerRequestHeader(){
        return new CustomerV1("Fernando Acosta");
    }
    //V2
    @GetMapping(path="customer/header", headers = "X-API-VERSION=2")
    public CustomerV2 retrieveSecondVersionOfCustomerRequestHeader(){
        return new CustomerV2(new Name("Fernando", "Acosta", 12345678));
    }
```
- Media type Versioning (Same url)
Validate value from Accept Header

HATEOS Links to Perform subsequent actions
```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```
```
//Wrap User resource in EntityModel
EntityModel<User> entityModel=EntityModel.of(user);

//Create a link to point retrieveAllUsers controller method
WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

//Add link to entity model
entityModel.add(link.withRel("all-users"));
```

Serialization
- Customized entity response names
```
@JsonProperty("user_name")
private String name;
``` 
- Static Filtering
Filter Bean values to all responses
```
    private String user;
    @JsonIgnore
    private String password;
    private String DNI;
```
- Dynamic Filtering
Allows to filter values to specific REST responses
```
@GetMapping(path = "/filtering-list")
    public MappingJacksonValue retriveBeanAll(){
        List<FilteredBean> filteredBean= Arrays.asList(
            new FilteredBean("Fer","FerT34%545","3498982387"),
            new FilteredBean("Jorge","lkejddl445","083749373"),
            new FilteredBean("Juan","4059fr","28376987")
            );
        MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(filteredBean);

        SimpleBeanPropertyFilter simpleBeanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("user");
        
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
```
SPRING BOOT ACTUATOR - MANAGE & MONITORING SERVICE
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
to see all available apis in /actuator
```
management.endpoints.web.exposure.include=*
```

HAL EXPLORER - Hyperlink our resources and apis to monitor & manage for non technical users
```
<dependency>
	<groupId>org.springframework.data</groupId>
	<artifactId>spring-data-rest-hal-explorer</artifactId>
</dependency>
```

- CONNECTING DATABASE H2 TO REST API (JPA & HIBERNATE)
```
#Enable h2 console
spring.h2.console.enabled=true
```
Dependencies
```
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

```
Anotate entity class and indicate entity ID with @Id
@Entity(name="user_details")
Browse to /h2-console and connect to DB using jdbc URL: ex jdbc:h2:mem:bbd734f4-1f31-43c7-a4cd-fd2ea8b197e7
Create data.sql file to insert some default data
```
INSERT INTO USER_DETAILS VALUES(1, current_date(),'Hello');
INSERT INTO USER_DETAILS VALUES(2, current_date(), 'World');
```

Add properties
```
#add DB URL
spring.datasource.url=jdbc:h2:mem:test
spring.jpa.defer-datasource-initialization=true
```
Create entity repository interface and extends from JPA repository
ex: public interface UserRespository extends JpaRepository<User,Integer>







# Following Udemy course
Master Microservices with SpringBoot and SpringCloud by Ranga Karanam
