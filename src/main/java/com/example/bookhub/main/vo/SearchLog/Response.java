package com.example.bookhub.main.vo.SearchLog;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private String message;
    private Object data;

    public Response(String message) {
        this.message = message;
    }


    public Response(List<SearchLog> data, String message) {
        this.data = data;
        this.message = message;
    }
}