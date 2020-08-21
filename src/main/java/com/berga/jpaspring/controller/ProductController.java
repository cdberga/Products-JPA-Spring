package com.berga.jpaspring.controller;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berga.jpaspring.model.Product;
import com.berga.jpaspring.model.Rating;
import com.berga.jpaspring.service.ProductService;
import com.berga.jpaspring.service.RatingService;
import com.berga.jpaspring.vo.ResponseVO;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	private final ProductService productService;
	private final RatingService ratingService;

	public ProductController(ProductService productService, RatingService ratingService) {
		this.productService = productService;
		this.ratingService = ratingService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Iterable<Product>>> findAll() {
		return ResponseEntity.ok(new ResponseVO<>(productService.findAll()));
	}

	@GetMapping(value = "/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Product>> get(@PathVariable("product_id") String productId) {
		return ResponseEntity.ok(new ResponseVO<>(productService.get(productId)));
	}

	@DeleteMapping(value = "/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<String>> delete(@PathVariable("product_id") String productId) {
		productService.delete(productId);
		return ResponseEntity.ok(new ResponseVO<>(productId));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Product>> create(@RequestBody Product product) {
		Product productSaved = productService.save(product);
		return ResponseEntity.created(URI.create("/" + productSaved.getId())).body(new ResponseVO<>(productSaved));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Product product) {
		Product productSaved = productService.update(product);
		return ResponseEntity.ok(new ResponseVO<>(productSaved.getId()));
	}

	@GetMapping(value = "/{product_id}/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Iterable<Rating>>> getRatings(@PathVariable("product_id") String productId) {
		return ResponseEntity.ok(new ResponseVO<>(ratingService.getRatingsByProductId(productId)));
	}

	@GetMapping(value = "/{product_id}/ratings/{rating_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Rating>> getRating(@PathVariable("product_id") String productId,
			@PathVariable("rating_id") Long ratingId) {
		return ResponseEntity.ok(new ResponseVO<>(ratingService.get(ratingId)));
	}

	@PostMapping(value = "/{product_id}/ratings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Rating>> saveRating(@PathVariable("product_id") String productId,
			@RequestBody Rating rating) {
		if (!productId.equals(rating.getProductId())) {
			throw new RuntimeException("Product id and Rating product id does not match");
		}
		Rating savedRating = ratingService.save(rating);
		return ResponseEntity
				.created(URI.create("/" + savedRating.getProductId() + "/ratings/" + savedRating.getRatingId()))
				.body(new ResponseVO<>(savedRating));
	}

	@PutMapping(value = "/{product_id}/ratings/{rating_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateRating(@PathVariable("product_id") String productId,
			@PathVariable("rating_id") Long ratingId, @RequestBody Rating rating) {
		Rating savedRating = ratingService.update(rating);
		return ResponseEntity.ok(new ResponseVO<>(savedRating.getRatingId()));
	}

	@DeleteMapping(value = "/{product_id}/ratings/{rating_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Long>> deleteRating(@PathVariable("product_id") String productId,
			@PathVariable("rating_id") Long ratingId) {
		ratingService.delete(ratingId);
		return ResponseEntity.ok(new ResponseVO<>(ratingId));
	}
}
