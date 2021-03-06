package com.ybb.mall.service;

import com.ybb.mall.domain.SysReview;
import com.ybb.mall.service.dto.product.ReviewDTO;
import com.ybb.mall.web.rest.util.ResultObj;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing SysReview.
 */
public interface SysReviewService {

    /**
     * Save a sysReview.
     *
     * @param sysReview the entity to save
     * @return the persisted entity
     */
    SysReview save(SysReview sysReview);

    /**
     * Get all the sysReviews.
     *
     * @return the list of entities
     */
    List<SysReview> findAll();


    /**
     * Get the "id" sysReview.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<SysReview> findOne(Long id);

    /**
     * Delete the "id" sysReview.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
