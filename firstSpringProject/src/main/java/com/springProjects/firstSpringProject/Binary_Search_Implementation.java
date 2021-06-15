package com.springProjects.firstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Binary_Search_Implementation {
    //creating an instance of interface as a field
    private final SortAlgorithm sortAlgorithm;
    @Autowired
    // creating constructor to set field
    public Binary_Search_Implementation(SortAlgorithm sortAlgorithm){
        super();
        this.sortAlgorithm=sortAlgorithm;
    }

    public int binarySearch(int[] arr,int searchNumber){
        // Steps:-
        // Sort array first using sorting methods[quick or bubble search]
        int[] sortedArray=sortAlgorithm.sort(arr);
        System.out.println(sortAlgorithm);


        // Search element in sorted array using binary search logic



        //return SearchedNumbers
        return 3; // temporary [just make compiler happy]
    }
}
