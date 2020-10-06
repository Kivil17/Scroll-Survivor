package core;

import core.interfaces.Direction;
import core.interfaces.DynamicObject;

public class Player implements DynamicObject 
{
		
		
		private int x=3;
		
		private int y=6;
		
		private int width=0;
		
		private int height=0;
		
		private int speed=1;
		
		private Direction direction;
		
		public static int point;
		
		public Player()
		{
			
			this.direction=Direction.LEFT;
		}

		private boolean isHit;
		
		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}
		

		public boolean isHit() 
		{
			return isHit;
		}
		
		
		@Override
		public void setDirection(Direction direction)
		{
			this.direction=direction;
		}
		
		public void setHit(final boolean isHit)
		{
			this.isHit= isHit;
		}
		
		public int getPoint() {
			return point;
		}

		public void setPoint(int point) {
			this.point = point;
		}

		
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
		public Direction getDirection() {
			return direction;
		}

		@Override
		public int getspeed() {
			return speed;
		}

		@Override
		public void move(Direction direction) {
			//
		}

		public void addPoint()
		{
			this.point+=10;
		}
	
		
		
		
		
}
