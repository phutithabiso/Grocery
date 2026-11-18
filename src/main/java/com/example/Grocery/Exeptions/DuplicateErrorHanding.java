package com.example.Grocery.Exeptions;

public class DuplicateErrorHanding extends RuntimeException{
    public DuplicateErrorHanding(String message){
        super(message);
    }
}
