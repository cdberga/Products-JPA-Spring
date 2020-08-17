package com.berga.jpaspring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berga.jpaspring.model.Rating;

@Transactional
public interface RatingRepository extends JpaRepository<Rating, Long> {

	public Iterable<Rating> getRatingsByProductId(final String productId);
}
