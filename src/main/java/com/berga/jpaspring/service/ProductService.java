package com.berga.jpaspring.service;

import org.springframework.data.repository.CrudRepository;

import com.berga.jpaspring.model.Product;
import com.berga.jpaspring.repository.ProductRepository;

public class ProductService implements GenericService<Product, String> {

	private final ProductRepository productRepository;
	
	public ProductService(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public String getId(Product entity) {
		return entity.getId();
	}

	@Override
	public CrudRepository<Product, String> getRepository() {
		return productRepository;
	}

}
