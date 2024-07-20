package com.example.Library.exeption;

import java.util.function.Supplier;

public class ResourceNotFound extends RuntimeException implements Supplier<ResourceNotFound> {
    public ResourceNotFound(String message) {
        super(message);
    }

    public static ResourceNotFound instance(String message){
        return new ResourceNotFound(message);
    }

    @Override
    public ResourceNotFound get() {
        return this;
    }
}
