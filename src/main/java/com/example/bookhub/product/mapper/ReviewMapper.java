package com.example.bookhub.product.mapper;

import com.example.bookhub.product.dto.ReviewImageDto;
import com.example.bookhub.product.vo.Review;
import com.example.bookhub.product.vo.ReviewImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    void createReview(Review review);
    List<ReviewImageDto> getReviewsByBookNo(long bookNo);
    void createReviewImage(ReviewImage reviewImage);
}