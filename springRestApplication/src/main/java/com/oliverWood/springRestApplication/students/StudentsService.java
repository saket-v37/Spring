package com.oliverWood.springRestApplication.students;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
//Or you can use @Component but this is a service bean so we should be more specific.
// both @Component and @Service will work same
public class StudentsService {

    public List<Students> getStudents(){
        return List.of(new Students(1L,"Sam",23, LocalDate.of(2000, Month.DECEMBER,5),"samNortan@gmail.com"));
    }
}
