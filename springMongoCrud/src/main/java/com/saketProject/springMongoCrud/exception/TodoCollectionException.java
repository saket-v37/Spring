package com.saketProject.springMongoCrud.exception;

public class TodoCollectionException extends Exception{

    private static final long serialVersionUID=1L;

    public TodoCollectionException(String message){
        super();
    }

    public static  String todoNotFoundException(String id){
        return "todo with given id "+id+" not found";
    }

    public static String todoAlreadyExist(){
        return "todo with given name already exist";
    }
}
