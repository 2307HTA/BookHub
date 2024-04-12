package com.example.bookhub.admin.service;

import com.example.bookhub.admin.mapper.AdminMapper;
import com.example.bookhub.admin.vo.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;


    public Admin getAdmin(String id){
        return adminMapper.getAdmin(id);
    }
}
