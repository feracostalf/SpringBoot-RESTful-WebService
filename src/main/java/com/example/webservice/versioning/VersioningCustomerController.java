package com.example.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningCustomerController {
    //URI VERSIONING
    //V1
    @GetMapping(path="v1/customer")
    public CustomerV1 retrieveFistVersionOfCustomer(){
        return new CustomerV1("Fernando Acosta");
    }
    //V2
    @GetMapping(path="v2/customer")
    public CustomerV2 retrieveSecondVersionOfCustomer(){
        return new CustomerV2(new Name("Fernando", "Acosta", 12345678));
    }

    //REQUEST PARAMS VERSIONING
    //V1
    @GetMapping(path="customer",params = "version=1")
    public CustomerV1 retrieveFistVersionOfCustomerRequestParam(){
        return new CustomerV1("Fernando Acosta");
    }
    //V2
    @GetMapping(path="customer", params = "version=2")
    public CustomerV2 retrieveSecondVersionOfCustomerRequestParam(){
        return new CustomerV2(new Name("Fernando", "Acosta", 12345678));
    }

    //REQUEST HEADER VERSIONING
    //V1
    @GetMapping(path="customer/header",headers = "X-API-VERSION=1")
    public CustomerV1 retrieveFistVersionOfCustomerRequestHeader(){
        return new CustomerV1("Fernando Acosta");
    }
    //V2
    @GetMapping(path="customer/header", headers = "X-API-VERSION=2")
    public CustomerV2 retrieveSecondVersionOfCustomerRequestHeader(){
        return new CustomerV2(new Name("Fernando", "Acosta", 12345678));
    }


}
