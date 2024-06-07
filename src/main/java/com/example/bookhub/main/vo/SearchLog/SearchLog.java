package com.example.bookhub.main.vo.SearchLog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SearchLog {
    private String name;
    private LocalDateTime createdAt;

}