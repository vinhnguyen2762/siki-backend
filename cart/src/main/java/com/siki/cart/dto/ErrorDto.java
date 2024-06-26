package com.siki.cart.dto;

import java.util.ArrayList;
import java.util.List;

public record ErrorDto(String statusCode, String title, String detail, List<String> fieldErrors) {
    public ErrorDto(String statusCode, String title, String detail){
        this(statusCode, title, detail, new ArrayList<>());
    }
}