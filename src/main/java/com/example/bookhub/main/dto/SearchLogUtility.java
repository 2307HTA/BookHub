package com.example.bookhub.main.dto;

import java.util.UUID;

public class SearchLogUtility {
    public static String searchLogKey() {
        // 여기에서 사용자 식별자를 기반으로 고유한 키를 생성합니다.
        // 로그인하지 않은 사용자이므로 특정 식별자를 사용하지 않고 고유한 값을 생성합니다.
        // 여기에서는 UUID를 사용할 수 있습니다.
        return "search_log_" + UUID.randomUUID().toString();
    }

    // 최근 검색어 목록의 최대 크기를 결정하는 상수
    public static final int RECENT_KEYWORD_SIZE = 20;
}
