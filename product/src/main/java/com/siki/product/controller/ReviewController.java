package com.siki.product.controller;

import com.siki.product.dto.PageableData;
import com.siki.product.dto.review.ReviewDto;
import com.siki.product.dto.review.ReviewPostDto;
import com.siki.product.service.ReviewService;
import com.siki.product.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping("/storefront")
    public ResponseEntity<Void> createReview(@Valid @RequestBody ReviewPostDto reviewPostDto){
        reviewService.createReviewForProduct(reviewPostDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/storefront/baseProduct/{slug}")
    public ResponseEntity<PageableData<ReviewDto>> getByBaseProductId(
            @PathVariable("slug") String baseProductSlug,

            @RequestParam(value = "pageNum", defaultValue = Constants.PageableConstant.DEFAULT_PAGE_NUMBER) int pageNum,

            @RequestParam(value = "pageSize", defaultValue = Constants.PageableConstant.DEFAULT_PAGE_SIZE) int pageSize,

            @RequestParam(value = "ratingStars", required = false) List<Integer> ratingStars,

            @RequestParam(value = "sortDir", defaultValue = Constants.PageableConstant.DEFAULT_SORT_DIR) String sortDir
    ) {
        return ResponseEntity.ok().body(reviewService.getByBaseProductId(baseProductSlug, pageNum, pageSize, ratingStars,sortDir));
    }


}
