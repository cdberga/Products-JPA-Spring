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
import com.berga.jpaspring.service.ProductService;
import com.berga.jpaspring.service.RatingService;
import com.berga.jpaspring.vo.ResponseVO;

@RestController
@RequestMapping(value="/products")
public class ProductController {

	private final ProductService productService;
	private final RatingService ratingService;
	public ProductController(ProductService productService, RatingService ratingService) {
		this.productService = productService;
		this.ratingService = ratingService;
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Iterable<Product>>> findAll() {
		return ResponseEntity.ok(new ResponseVO<>(productService.findAll()));
	}
	
	@GetMapping(value="/{product_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Product>> get(@PathVariable("product_id") String productId) {
		return ResponseEntity.ok(new ResponseVO<>(productService.get(productId)));
	}
	
	@DeleteMapping(value="/{product_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<String>> delete(@PathVariable("product_id") String productId) {
		productService.delete(productId);
		return ResponseEntity.ok(new ResponseVO<>(productId));
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Product>> create(@RequestBody Product product) {
		Product productSaved = productService.save(product);
		return ResponseEntity.created(URI.create("/" + productSaved.getId())).body(new ResponseVO<>(productSaved));
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Product product) {
		productService.update(product);
		return ResponseEntity.noContent().build();
	}
	
	private void getRatings() {
		// TODO Auto-generated method stub

	}
	
	private void getRating() {
		// TODO Auto-generated method stub

	}
	
	private void saveRating() {
		// TODO Auto-generated method stub

	}
	
	private void updateRating() {
		// TODO Auto-generated method stub

	}
	
	private void deleteRating() {
		// TODO Auto-generated method stub

	}
}
