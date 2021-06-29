package com.springProjects.firstSpringProject;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSort implements SortAlgorithm {
    public int[] sort(int[] numArr){
        // logic for bubble sort
        return numArr;
    }
}
