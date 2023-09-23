package com.example.webservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
    
    @GetMapping(path = "/filtering")
    public FilteredBean retriveBean(){
        return new FilteredBean("Fer","FerT34%545","3498982387");
    }

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
}
