package com.example.bookhub.admin.service;

import com.example.bookhub.admin.dto.DailyDto;
import com.example.bookhub.admin.mapper.DashBoardMapper;
import com.example.bookhub.admin.mapper.DetailDashBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailDashBoardService {

    private final DetailDashBoardMapper detailDashBoardMapper;


    public List<DailyDto> getDetailDaily(String value){
        return detailDashBoardMapper.getDetailDaily(value);
    }
}