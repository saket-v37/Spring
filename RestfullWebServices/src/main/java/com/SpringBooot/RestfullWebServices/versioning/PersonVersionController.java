package com.springBooot.restfullWebServices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    // URI Versioning
    @GetMapping(path="/api/v1/person")
    public PersonV1 personV1Api(){
        return new PersonV1("Jacob Murphy");
        }
    @GetMapping(path="/api/v2/person")
    public PersonV2 personV2Api(){
        return new PersonV2(new Name("Jacob","Murphy"));
    }

    // Request Param Versioning
    @GetMapping(value="/person/params",params = "version=1")
    public PersonV1 reqParamVersioning1(){
        return new PersonV1("Jacob Murphy");
    }
    @GetMapping(value="/person/params",params = "version=2")
    public PersonV2 reqParamVersioning2(){
        return new PersonV2(new Name("Jacob","Murphy"));
    }

    // Headers Param Versioning
    @GetMapping(value="/person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerVersioning1(){
        return new PersonV1("Jacob Murphy");
    }
    @GetMapping(value="/person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerVersioning2(){
        return new PersonV2(new Name("Jacob","Murphy"));
    }

    // Accept header or MINE type Versioning
    @GetMapping(value="/person/produces",produces = "application/xyz.company.app-v1+json")
    public PersonV1 producesVersioning1(){
        return new PersonV1("Jacob Murphy");
    }
    @GetMapping(value="/person/produces",produces = "application/xyz.company.app-v2+json")
    public PersonV2 producesVersioning2(){
        return new PersonV2(new Name("Jacob","Murphy"));
    }

}
