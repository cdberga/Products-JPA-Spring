package com.berga.jpaspring.service;

import java.io.Serializable;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.repository.CrudRepository;

public interface GenericService<T, ID extends Serializable> {

	public default Iterable<T> findAll(){
		return getRepository().findAll();
	}
	
	public default T get(ID id) {
		return (T) getRepository().findById(id);
	}
	
	public default T save(T entity) {
		return getRepository().save(entity);
	}
	
	public default void delete(ID id) {
		if(getRepository().existsById(id)) {
			getRepository().deleteById(id);
		}
		else {
			throw new ServiceException("Object id does not exist: " + id);
		}
	}
	
	public default T update(T entity) {
		if(getRepository().existsById(getId(entity))) {
			return getRepository().save(entity);
		}
		else {
			throw new ServiceException("Can not update because object does not exist in DB: " + entity);
		}
	}
	
	public ID getId(T entity);
	
	public CrudRepository<T, ID> getRepository();
}
