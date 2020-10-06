package core.interfaces;

public interface DynamicObject extends Entity,Moovable
{
	void move(Direction direction);
	int getHeight();
	int getWidth();
}
