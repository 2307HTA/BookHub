package com.example.bookhub.main.service;


import com.example.bookhub.main.dto.BookListDto;
import com.example.bookhub.main.dto.SearchCriteria;


import java.util.List;


public interface SearchService {
    BookListDto searchBooks(SearchCriteria searchCriteria);

}


// BookListDto keywordSearch(SearchCriteria searchCriteria);
// List<SearchRankResponseDto> searchRankList();
//void updateSearchRanking();