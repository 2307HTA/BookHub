package com.example.bookhub.admin.controller;

import com.example.bookhub.admin.Repository.AdminRepository;
import com.example.bookhub.admin.service.AdminService;
import com.example.bookhub.admin.vo.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/login")
    public String loginForm(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(String id, String password, Model model){
        Admin admin = adminService.getAdmin(id);
        admin.getId();
    }

    @GetMapping("/home")
    public String home(){
        return "admin/home";
    }


}
