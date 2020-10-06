package core;

import core.interfaces.DynamicObject;
import core.interfaces.StaticObject;

public class Coin implements StaticObject
{
	private int x;
	
	private int y;
	
	private String value; 
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x=x;
	}

	@Override
	public void setY(int y) {
		this.y=y;
	}

	
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean collision(DynamicObject other) {
		
		return false;
	}

}
