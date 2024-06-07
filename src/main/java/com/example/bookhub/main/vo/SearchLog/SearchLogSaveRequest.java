package com.example.bookhub.main.vo.SearchLog;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class SearchLogSaveRequest {
    private String searchQuery;
    private LocalDateTime searchTime;


    // 유효성 검사 메소드
    public boolean isValid() {
        return searchQuery != null && !searchQuery.isEmpty() && searchQuery.length() <= 20;
    }

    public String getName() {
        return this.getName();
    }

    public LocalDateTime getCreatedAt() {
        return this.getCreatedAt();
    }
}