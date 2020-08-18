package com.berga.jpaspring.model;

public enum Size {
	SMALL(0), MEDIUM(1), LARGE(2), NOT_APPLICABLE(3);
	
	private int size;
	
	Size(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	public static Size of(int size) {
		for (Size item : Size.values()) {
			if(item.getSize() == size)
				return item;
		}
		return Size.NOT_APPLICABLE;
	}
}
