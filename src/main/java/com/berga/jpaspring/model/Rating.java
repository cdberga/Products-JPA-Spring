package com.berga.jpaspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_ratings", schema = "product")
public class Rating {

	@Id
	@GeneratedValue
	@Column(name = "rating_id")
	private Long ratingId;

	private Double rating;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "user_id")
	private String userId;

	public Rating() {
	}

	public Rating(Long ratingId, Double rating, String productId, String userId) {
		this.ratingId = ratingId;
		this.rating = rating;
		this.productId = productId;
		this.userId = userId;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Rating : {\"rating_id\" : \"" + ratingId + "\", \\\"rating\\\" : \"" + rating + "\", \"product_id\" : \"" + productId
				+ "\", \"user_id\" : \"" + userId + "\"}";
	}
}
