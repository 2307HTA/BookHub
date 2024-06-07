
package com.example.bookhub.main.controller;
import com.example.bookhub.main.dto.BookListDto;
import com.example.bookhub.main.dto.SearchCriteria;
import com.example.bookhub.main.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;
    @GetMapping("/main/catelist")
    public String Cate(SearchCriteria searchCriteria, Model model) {;
        BookListDto dto = bookCategoryService.getCategoryBooks(searchCriteria);

        model.addAttribute("category", bookCategoryService.getCategory(searchCriteria.getCateKeyword()));
        model.addAttribute("book", dto.getBooks()); // 모델에 책 정보를 담아서 HTML로 전달
        model.addAttribute("criteria", dto.getCriteria());
        return "main/cateList";
    }
}