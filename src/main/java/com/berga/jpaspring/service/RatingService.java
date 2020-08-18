package com.berga.jpaspring.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.repository.CrudRepository;

import com.berga.jpaspring.model.Rating;
import com.berga.jpaspring.repository.ProductRepository;
import com.berga.jpaspring.repository.RatingRepository;
import com.berga.jpaspring.repository.UserRepository;

public class RatingService implements GenericService<Rating, Long> {

	private final RatingRepository ratingRepository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	
	public RatingService(final RatingRepository ratingRepo, final ProductRepository productRepo, final UserRepository userRepo) {
		this.ratingRepository = ratingRepo;
		this.productRepository = productRepo;
		this.userRepository = userRepo;
	}
	@Override
	public Long getId(Rating entity) {
		return entity.getRatingId();
	}

	@Override
	public CrudRepository<Rating, Long> getRepository() {
		return this.ratingRepository;
	}
	
	public Iterable<Rating> getRatingsByProductId(final String productId) {
		return this.ratingRepository.getRatingsByProductId(productId);
	}

	@Override
	public Rating save(Rating entity) {
		if(!productRepository.existsById(entity.getProductId()) || !userRepository.existsById(entity.getUserId())) {
			throw new ServiceException("Neither product_id nor user_id exist: " + entity);
		}
		return GenericService.super.save(entity);
	}
}
