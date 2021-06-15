package com.springProjects.firstSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringProjectApplication {

	public static void main(String[] args) {

		// Binary Search [ In Loosely Couple Manner ] -- Without using Spring Framework
//		Binary_Search_Implementation binary_search_implementation=new Binary_Search_Implementation(new QuickSort());
//		int result=binary_search_implementation.binarySearch(new int[]{12,5,8,3},3);
//		System.out.println(result);
		/*
			Output:-
			com.springProjects.firstSpringProject.QuickSort@5bb3d42d
3			3
		*/

		//*************************************************************************
		// Binary Search [ In Loosely Couple Manner ] -- With Spring Framework
		ApplicationContext applicationContext=SpringApplication.run(FirstSpringProjectApplication.class, args);
		Binary_Search_Implementation binary_search_implementation=applicationContext.getBean(Binary_Search_Implementation.class);
		int result=binary_search_implementation.binarySearch(new int[]{12,5,8,3},3);
		System.out.println(result);





	}

}
