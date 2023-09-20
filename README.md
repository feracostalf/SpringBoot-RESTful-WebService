# Demo project for Spring Boot
Restful Webservice

# topics
RestController, RequestMapping, PathParameters, StaticResorces, CustomizedExceptionHandler, HTTPStatus, ResponseEntity, RequestPath, RequestBody, DeleteMapping, Validations, CustomeValidationMessage, XML/JSON format, Languaje dataformat, Swagger

URIs
- Name resources in plural
- /users
- /users/1
- /users/1/posts/
- /users/1/posts/1

HTTP metods
- POST create new resource
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

ContentNegotation
- Add messages.properties file to customize language messages
- Add jackson-dataformat-xml dependency to parse data to XML format
```
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```
    Header:
        Accept:  
            application format(XML/JSON)
            language (en, es, fr) Internalization messages

SpringDoc - OpenApi
- Add springdoc to generate swagger from codesouce
```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.7.0</version>
</dependency>
```
http://localhost:8080/swagger-ui/index.html

# Following Udemy course
Master Microservices with SpringBoot and SpringCloud by Ranga Karanam
