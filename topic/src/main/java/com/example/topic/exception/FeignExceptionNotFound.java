package com.example.topic.exception;

public class FeignExceptionNotFound extends RuntimeException{
    public FeignExceptionNotFound(String object, String resource, String resourceName) {
        super(String.format("Object %s not found in resource %s and resource %s",object,resource,resourceName));
    }
}
