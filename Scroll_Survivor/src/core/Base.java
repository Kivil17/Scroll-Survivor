package core;

import core.interfaces.DynamicObject;
import core.interfaces.StaticObject;

public class Base implements StaticObject 
{
	private int x;
	
	private int y;
	
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

	@Override
	public boolean collision(DynamicObject other) {
		return false;
	}

	@Override
	public String toString() {
		return "Base [x=" + x + ", y=" + y + "]";
	}

	
}
