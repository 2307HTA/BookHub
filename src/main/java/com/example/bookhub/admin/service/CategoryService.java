package com.example.bookhub.admin.service;

import com.example.bookhub.admin.mapper.CategoryMapper;
import com.example.bookhub.admin.vo.Category;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public List<Category> getAllTopLevelCategories() {
        return categoryMapper.getAllTopLevelCategories();
    }

    public List<Category> getAllSecondLevelCategories() {
        return categoryMapper.getAllSecondLevelCategories();
    }

    public List<Category> getAllThirdLevelCategories() {
        return categoryMapper.getAllThirdLevelCategories();
    }

    public List<Category> getSecondLevelCategoriesByTopLevelCategoryName(int categoryNo) {
        return categoryMapper.getSecondLevelCategoriesByTopLevelCategoryName(categoryNo);
    }
}
