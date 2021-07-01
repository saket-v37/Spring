package com.springBooot.restfullWebServices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

// this is example of static filtering
@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public MappingJacksonValue retrieveBean(){
        // Dynamic Filter
        SomeBean someBean=  new SomeBean("name","dob","password");

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping(path = "/filtering-list")
    public MappingJacksonValue retrieveListsFromBean(){
        // Dynamic Filter
        List<SomeBean> list=  Arrays.asList(new SomeBean("name1","dob2","password3"),new SomeBean("name2","dob2","password2"));

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;
    }

}
