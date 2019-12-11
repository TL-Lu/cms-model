package com.lutenglong.commen;

public enum Gender {
	未知(0),男(1),女(2);
	
	private int value =0;
	
	private Gender(int value) {
		this.value=value;
	}
	public static Gender valueOf(int value) {		
			switch(value) {
			case 0:
					return 未知;
			case 1:
				return 男;
			case 2:
				return 女;
			default:
				return null;
		}
	}
	
	public int value() {		
		return this.value;
	}
}
