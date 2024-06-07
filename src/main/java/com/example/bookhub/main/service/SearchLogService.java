package com.example.bookhub.main.service;

import com.example.bookhub.main.vo.SearchLog.SearchLog;
import com.example.bookhub.main.vo.SearchLog.SearchLogDeleteRequest;
import com.example.bookhub.main.vo.SearchLog.SearchLogSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SearchLogService {
    private final RedisTemplate<String, SearchLog> redisTemplate;

    public void saveRecentSearchLog(SearchLogSaveRequest request) {
        String now = LocalDateTime.now().toString();
        String key = "SearchLog"; // 회원과 상관없이 일반적인 키 사용

        SearchLog value = SearchLog.builder()
                .name(request.getName())
                .createdAt(LocalDateTime.parse(now))
                .build();

        Long size = redisTemplate.opsForList().size(key);
        if (size == 10) {
            // rightPop을 통해 가장 오래된 데이터 삭제
            redisTemplate.opsForList().rightPop(key);
        }

        redisTemplate.opsForList().leftPush(key, value);
    }

    public List<SearchLog> findRecentSearchLogs() {
        String key = "SearchLog"; // 회원과 상관없이 일반적인 키 사용
        List<SearchLog> logs = redisTemplate.opsForList()
                .range(key, 0, 10);

        return logs;
    }

    public void deleteRecentSearchLog(SearchLogDeleteRequest request) {
        String key = "SearchLog"; // 회원과 상관없이 일반적인 키 사용
        SearchLog value = SearchLog.builder()
                .name(request.getName())
                .createdAt(request.getCreatedAt())
                .build();

        long count = redisTemplate.opsForList().remove(key, 1, value);


    }


}

