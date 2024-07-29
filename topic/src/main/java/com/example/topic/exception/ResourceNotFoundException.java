package com.example.topic.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String object,String resourceName,String resource) {
        super(String.format("Object %s not found in resource %s and resource %s",object,resource,resourceName));
    }
}
