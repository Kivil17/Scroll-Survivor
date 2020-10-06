package core;

import core.interfaces.Entity;
import java.util.Random;

public class World {

	private final int dimx=11;

    private final int dimy= 11;
    
    Random random= new Random();
	Player player= new Player();
	Base base= new Base();
	Coin coin= new Coin();
	
    Entity [][] M;
    
    public World()
    {
        M = new Entity [dimx][dimy];
        for(int i=0; i<dimx; i++)
        	for(int j=0; j<dimy; j++)
        		M[i][j]=new EmptyEntity();
        
    }
    
    public Entity[][] getMatrix()
    {
    	return this.M;
    }
   
    
	public void addInTheWorld(Entity entity, int i, int j)
	{
		M[i][j]= entity;
	}
    public int getDimx() {
		return dimx;
	}

	public int getDimy() {
		return dimy;
	}

	public int getIstanza(int x, int y)
	{
		if(M[x][y] instanceof EmptyEntity)
			return 0;
		else if(M[x][y] instanceof Base)
			return 2;
		else if(M[x][y] instanceof Player)
			return 3;
		else if(M[x][y] instanceof Coin)
			return 5;
		else
			return -1;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	@Override
    public String toString()
	{
    	String s="";
    	for(int i=0; i<dimx; i++)
    	{
    		for(int j=0; j<dimy; j++)
    		{
    			if(M[i][j] instanceof EmptyEntity )
    				s+=" * ";
    			else if(M[i][j] instanceof Player)
    				s+=" P ";
    			else if(M[i][j] instanceof Base)
    				s+=" = ";
    			else if(M[i][j] instanceof Coin)
    				s+=" @ ";
 
    		}
    		s+="\n";
    	}
    	return s;
	}
}
