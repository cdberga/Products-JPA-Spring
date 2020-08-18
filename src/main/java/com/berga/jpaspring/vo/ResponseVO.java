package com.berga.jpaspring.vo;

public class ResponseVO<T> {

	private T results;
	
	public ResponseVO(T results) {
		this.results = results;
	}
	
	public T getResults() {
		return results;
	}
}
