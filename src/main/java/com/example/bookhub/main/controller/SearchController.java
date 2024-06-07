package com.example.bookhub.main.controller;


import com.example.bookhub.main.dto.BookListDto;
import com.example.bookhub.main.dto.SearchCriteria;
import com.example.bookhub.main.service.SearchLogService;
import com.example.bookhub.main.service.SearchService;
import com.example.bookhub.main.vo.SearchLog.SearchLog;
import com.example.bookhub.main.vo.SearchLog.SearchLogSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class SearchController {
    private final SearchService searchService;
    private final SearchLogService searchLogService;

    //  출시일 순 검색 했을때
    @GetMapping("/search")
    public String searchBooks(SearchCriteria searchCriteria, Model model) {;
        BookListDto dto = searchService.searchBooks(searchCriteria);
        model.addAttribute("book", dto.getBooks()); // 모델에 책 정보를 담아서 HTML로 전달.
        model.addAttribute("criteria", dto.getCriteria());
        return "main/searchList"; // searchList.html로 반환
    }



    @PostMapping("/saveSearchLog")
    public ResponseEntity<String> saveRecentSearchLog(@RequestBody SearchLogSaveRequest request) {
        searchLogService.saveRecentSearchLog(request);
        return ResponseEntity.ok("최근 검색 기록 저장 완료");
    }

    @GetMapping("/findRecentSearchLog")
    public ResponseEntity<List<SearchLog>> findRecentSearchLog() {
        List<SearchLog> recentSearchLogList = searchLogService.findRecentSearchLogs();
        return ResponseEntity.ok(recentSearchLogList);
    }
}


    /*
    // 검색 페이지로 이동 및 검색 수행
    @GetMapping("/search")
    public String searchBooks(SearchCriteria searchCriteria, Model model) {
        // 검색어가 있을 경우에만 실시간 검색어 랭킹 업데이트
        if (searchCriteria.getKeyword() != null && !searchCriteria.getKeyword().isEmpty()) {
            searchService.updateSearchRanking();
        }

        // 검색 수행
        BookListDto dto = searchService.keywordSearch(searchCriteria);
        model.addAttribute("book", dto.getBooks()); // 모델에 책 정보를 담아서 HTML로 전달.
        model.addAttribute("criteria", dto.getCriteria());
        return "main/searchList"; // searchList.html로 반환
    }

*/