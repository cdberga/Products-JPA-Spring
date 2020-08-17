package com.berga.jpaspring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berga.jpaspring.model.Product;

@Transactional
public interface ProductRepository extends JpaRepository<Product, String> {


}
