package com.springBooot.restfullWebServices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    @GetMapping(path="/api/v1/person")
    public PersonV1 personV1Api(){
        return new PersonV1("Sarad Kumar");
        }

    @GetMapping(path="/api/v2/person")
    public PersonV2 personV2Api(){
        return new PersonV2(new Name("Sarad","Kumar"));
    }
}
