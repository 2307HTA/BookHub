package com.example.bookhub.main.service;

import com.example.bookhub.main.dto.BookDto;
import com.example.bookhub.main.dto.BookListDto;
import com.example.bookhub.main.dto.SearchCriteria;
import com.example.bookhub.main.mapper.SearchMapper;
import com.example.bookhub.product.vo.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    private final SearchMapper searchMapper;

    @Override
    public BookListDto searchBooks(SearchCriteria criteria) {
        List<BookDto> books = searchMapper.searchBooks(criteria);

        int totalRows = searchMapper.count(criteria);
        criteria.setTotalRows(totalRows);

        BookListDto dto = new BookListDto();
        dto.setBooks(books);
        dto.setCriteria(criteria);

        return dto;
    }
}

    /*

    private final RedisTemplate<String, String> redisTemplate;

    @Transactional
    public BookListDto keywordSearch(SearchCriteria searchCriteria) {
        List<BookDto> books = searchMapper.searchBooks(searchCriteria);

        int totalRows = searchMapper.count(searchCriteria);
        searchCriteria.setTotalRows(totalRows);

        BookListDto dto = new BookListDto();
        dto.setBooks(books);
        dto.setCriteria(searchCriteria);

        return dto;
    }

    public List<SearchRankResponseDto> searchRankList() {
        String key = "ranking";
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> typedTuples = zSetOperations.reverseRangeWithScores(key, 0, 9);
        return typedTuples.stream().map(SearchRankResponseDto::convertToResponseRankingDto).collect(Collectors.toList());
    }

    @Override
    public void updateSearchRanking() {
        // 1. 실시간 검색어 랭킹 초기화
        String key = "ranking";
        redisTemplate.delete(key);

        // 2. 최근 1시간 동안의 검색어 랭킹 정보를 캐시에서 가져와서 Redis에 추가
        List<SearchRankResponseDto> recentSearchRank = getRecentSearchRank(); // 캐시에서 최근 1시간 동안의 검색어 랭킹 정보를 가져옴

        // 검색 횟수를 기준으로 정렬하여 Redis에 추가
        for (SearchRankResponseDto searchRank : recentSearchRank) {
            redisTemplate.opsForZSet().add(key, searchRank.getKeyword(), searchRank.getRank());
        }
    }

    private List<SearchRankResponseDto> getRecentSearchRank() {
        // Redis에서 최근 1시간 동안의 검색어 랭킹 정보를 가져오는 코드
        String key = "recent_search_rank"; // 캐시 키
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();

        // Redis에서 현재 시간부터 1시간 전까지의 범위에 있는 랭킹 정보를 가져옵니다.
        long currentTime = System.currentTimeMillis(); // 현재 시간
        long oneHourAgo = currentTime - (60 * 60 * 1000); // 현재 시간으로부터 1시간 전의 시간
        Set<ZSetOperations.TypedTuple<String>> typedTuples = zSetOperations.reverseRangeByScoreWithScores(key, oneHourAgo, currentTime);

        // 가져온 랭킹 정보를 SearchRankResponseDto 형태로 변환하여 리스트에 담습니다.
        List<SearchRankResponseDto> recentSearchRank = typedTuples.stream()
                .map(tuple -> new SearchRankResponseDto(tuple.getValue(), tuple.getScore()))
                .collect(Collectors.toList());

        return recentSearchRank;

    */



