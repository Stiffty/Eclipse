package objectStream_Test;

import java.io.Serializable;

public class Test implements Serializable{

	private int value;
	
	public Test(int z){
		// TODO Auto-generated constructor stub
		value = z;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
