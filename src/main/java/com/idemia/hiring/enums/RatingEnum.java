package com.idemia.hiring.enums;

public enum RatingEnum {
	
	POOR(1),FAIR(2),GOOD(3),VERY_GOOD(4), EXCELLENT(5);
	
	private int val;
	
	RatingEnum(int val) {
		this.val = val;
	}
	
	public int getValue() {
		return val;
	}
}
