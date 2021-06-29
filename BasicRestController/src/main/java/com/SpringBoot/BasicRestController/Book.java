package com.SpringBoot.BasicRestController;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Book {
    private int id;
    private String name;
    private double price;


}
