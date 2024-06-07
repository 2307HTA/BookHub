/*
package com.example.bookhub.main.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SearchSchedulerService {

    private final SearchService searchService;

    public SearchSchedulerService(SearchService searchService) {
        this.searchService = searchService;
    }

    @Scheduled(fixedRate = 3600000) // 1시간마다 실행 (1시간 = 60 * 60 * 1000 밀리초)
    public void updateSearchRanking() {
        // 실시간 검색어 업데이트 작업 수행
        searchService.updateSearchRanking();
    }
}
*/