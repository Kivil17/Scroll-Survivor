package core.menager;


import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import core.Base;
import core.Coin;
import core.EmptyEntity;
import core.Player;

import core.World;
import core.interfaces.Direction;
import core.interfaces.Entity;
import core.music.MusicManager;


public class GameMenager extends JFrame
{
	//variabili e entità del gioco
	
	private static final long serialVersionUID = 1L;
	
	private int infoGame;

	private static World world;
	
	private static Player player;
	
	private static Base base;
	
	private boolean jumping;
	
	private boolean falling;
	
	public boolean fine;
	
	private int precedente;
	
	private int contaCelle;
	
	public static int point;
	
	public static int cont;
	
	private String user;
	
	
	//public static boolean ceckCoin;
	
	ArrayList<Coin> coin;
	
	public GameMenager(String user)
	{
		//setto le variabili iniziali
		
		this.user=user;
		
		
		jumping=false;
		falling=false;
		fine=false;
		
		contaCelle=0;
		precedente=0;
		point=0;
		cont=0;
		
		player= new Player();
		coin = new ArrayList<Coin>();
		world = new World();
		base =new Base();
		
		//System.out.println(world);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public  boolean isFine() {
		return fine;
	}

	public void setFine(boolean fine) {
		this.fine = fine;
	}

	public void StartWorld()
	{
		int m=0,m1=0;
		
		for(int i=0; i<world.getDimx(); i++)
		{
			world.addInTheWorld(new Base(), m, 0);
			world.addInTheWorld(new Base(), m1, 10);
			for(int j=0; j<world.getDimy(); j++)
			{
				
			}
			m++;
			m1++;
			
		}
		for(int i=1; i<10; i++)
			if(i!=7)
				world.addInTheWorld(new Base(), 1, i);
		//world.addInTheWorld(new EmptyEntity(), 1, 7);	
		
		for(int i=1; i<10; i++)
			if(i!=5)
				world.addInTheWorld(new Base(), 4, i);
		
		for(int i=1; i<10; i++)
			if(i!=4)
				world.addInTheWorld(new Base(), 7, i);
	
		
		world.addInTheWorld(new Player(), 3, 6);
		coin.add(new Coin());
		world.addInTheWorld(coin.get(coin.size()-1), 6, 8);
		
		
	}

	
	public void printInfoGame()
	{
		System.out.println(infoGame);
		System.out.println(MusicManager.audio_attivo);
	}
	
	public void GeneraRigaBase()
	{
		Random random=new Random();
		int rand1= random.nextInt(9)+1;
		
		for(int i=0; i<world.getDimy(); i++)
		{
				world.addInTheWorld(new Base(), 0, i);	
				
		}
		
		/*if(cont==0)
		{
			world.addInTheWorld(new EmptyEntity(), 0, 4);
			
			
		}*/
		
		for(int i=0; i<world.getDimy(); i++)
		{
				if(rand1==precedente && precedente<world.getDimy()-2)
					world.addInTheWorld(new EmptyEntity(), 0, rand1+1);
				else if(rand1==precedente && precedente>2)
					world.addInTheWorld(new EmptyEntity(), 0, rand1-1);
				else 
					world.addInTheWorld(new EmptyEntity(), 0, rand1);
			
		}
		
		/*for(int i=0; i<10; i++)
			world.addInTheWorld(new Base(), i, 0);*/
		
		precedente=rand1;
	
		//cont++;
	}
	
	public void ScendiMatrice()
	{
		Entity [][]A= world.getMatrix();
		infoGame++;
		printInfoGame();
		
		for(int i=9; i>=0; i--)
		{
			for(int j=0; j<11; j++)
			{
				Entity t=A[i][j];
				if(t instanceof Player)
				{
					
					player.setX(i+1);
				}
				A[i+1][j]=t;
			}
				
		}
		
		
		falling=true;
		player.setDirection(Direction.STOP);
			
		for(int i=0; i<11; i++)
			A[0][i]=new EmptyEntity();
			
		A[0][0] = new Base();
		A[0][10]= new Base();
		
		
	}
	
	public void GeneraRiga()
	{
		Random random=new Random();
		int rand2= random.nextInt(9)+1;
		
		
		for(int i=0; i<world.getDimy(); i++)
		{
			if(world.getIstanza(4, rand2)==0)
			{
					if(rand2<world.getDimy()-2)
					{	
						
						//world.addInTheWorld(new Coin(), 3, rand2);		
						coin.add(new Coin());
						world.addInTheWorld(coin.get(coin.size()-1), 3, rand2+1);
					}
					else if(rand2-1>2)
					{
		
						//world.addInTheWorld(new Coin(), 3, rand2);
						coin.add(new Coin());
						world.addInTheWorld(coin.get(coin.size()-1), 3, rand2-1);
					}
						
			}
			else
			{
				//world.addInTheWorld(new Coin(), 3, rand2);
				coin.add(new Coin());
				world.addInTheWorld(coin.get(coin.size()-1), 3, rand2);
			}
			
		}
		
	}
	
	public ArrayList<Coin> getCoin() {
		return coin;
	}

	public void setCoin(ArrayList<Coin> coin) {
		this.coin = coin;
	}

	public void movePlayer(Direction direction) 
	{
		switch(direction)
		{
			case RIGHT:
				
				player.setDirection(Direction.RIGHT);
				int xr= player.getX();
				int yr=player.getY();
				
				if(world.getIstanza(xr+1, yr+1)==0)
				{
					if(jumping==false)
					{
						contaCelle=5;
						
						world.addInTheWorld(new EmptyEntity(), xr, yr);
						yr++;
						player.setY(yr);
						world.addInTheWorld(player, player.getX(), player.getY());
						//System.out.println(world);
						
						falling=true;
					}
					
				}
				else if(world.getIstanza(xr, yr+1)==5)
				{
					
					player.addPoint();
					world.addInTheWorld(new EmptyEntity(), xr, yr);
					yr++;
					player.setY(yr);
					world.addInTheWorld(player, player.getX(), player.getY());
					
					//System.out.println(world);
				}
				else
				{
					if(yr<world.getDimy()-2)
					{
						if(world.getIstanza(xr, yr+1)!=2)
						{
							player.setDirection(Direction.RIGHT);
							world.addInTheWorld(new EmptyEntity(), xr, yr);
							yr++;
							player.setY(yr);
							world.addInTheWorld(player, player.getX(), player.getY());
							//System.out.println(world);
						}
						else
						{
							player.setDirection(Direction.STOP);
							//System.out.println(world);
						}
					}
					else
					{
						player.setDirection(Direction.STOP);
						//System.out.println(world);
					}
				}
				
				break;
				
			case LEFT:
				
				player.setDirection(Direction.LEFT);
				int xl= player.getX();
				int yl=player.getY();
				
				if(world.getIstanza(xl+1, yl-1)==0)
				{
					if(jumping==false)
					{
						contaCelle=5;
						world.addInTheWorld(new EmptyEntity(), xl, yl);
						yl--;
						player.setY(yl);
						world.addInTheWorld(player, player.getX(), player.getY());
						
						//System.out.println(world);
						falling=true;
					}
					
				}
				else if(world.getIstanza(xl, yl-1)==5)
				{
					player.addPoint();
					world.addInTheWorld(new EmptyEntity(), xl, yl);
					yl--;
					player.setY(yl);
					world.addInTheWorld(player, player.getX(), player.getY());
					//System.out.println(world);
				}
				else
				{
					if(yl>1)
					{
						if(world.getIstanza(xl, yl-1)!=2)
						{
							player.setDirection(Direction.LEFT);
							world.addInTheWorld(new EmptyEntity(), xl, yl);
							yl--;
							player.setY(yl);
							world.addInTheWorld(player, player.getX(), player.getY());
							
							//System.out.println(world);
						}
						else
						{
							player.setDirection(Direction.STOP);
							//System.out.println(world);
						}
					}
					else 
					{
						player.setDirection(Direction.STOP);
						//System.out.println(world);
					}
				}
				break;
				
			case UP:
				player.setDirection(Direction.UP);
				jumping =true;
			
			default:
				break;
			
			
		}
	}
	
	
	public void JumpMenager()
	{
		int xu=player.getX();
		int yu=player.getY();
		
		if(contaCelle>=4 || xu==0)
		{	
			jumping=false;
			falling=true;
		}
		else
		{
			
			if(world.getIstanza(xu-1, yu)!=2)
			{
				
				player.setDirection(Direction.UP);
				contaCelle++;
				world.addInTheWorld(new EmptyEntity(), xu, yu);
				xu--;
				player.setX(xu);
				world.addInTheWorld(player, player.getX(), player.getY());
				//System.out.println(world);
		
			}
			else if(world.getIstanza(xu, yu)==5)
			{
				
				player.addPoint();
				
				world.addInTheWorld(new EmptyEntity(), xu, yu);
				xu--;
				player.setX(xu);
				world.addInTheWorld(player, player.getX(), player.getY());
				//System.out.println(world);
			}
			else
			{
				
				jumping=false;
				falling=true;
				
			}
			
			
		}
	}
	
	public void FallingMenager()
	{
		int xu=player.getX();
		int yu=player.getY();
		
		if(contaCelle==0)
		{	
			falling=false;
		}
		else
		{
			
			if(world.getIstanza(xu+1, yu)!=2)
			{
				
				contaCelle--;
				world.addInTheWorld(new EmptyEntity(), xu, yu);
				xu++;
				player.setX(xu);
				world.addInTheWorld(player, player.getX(), player.getY());
				//System.out.println(world);

			}
			else if(world.getIstanza(xu, yu)==5)
			{
				
				player.addPoint();
				
				world.addInTheWorld(new EmptyEntity(), xu, yu);
				xu++;
				player.setX(xu);
				world.addInTheWorld(player, player.getX(), player.getY());
				//System.out.println(world);
			}
			else
			{
				falling=false;
				contaCelle=0;
				player.setDirection(Direction.STOP);
			}
		}
		
			
	}
	public void IsGameOver()
	{
		if(player.getX()>=10)
		{
			fine=true;
		}
	}

	// queste funzioni gestiscono il salto
	
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	public boolean isFalling() {
		return falling;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	public int getContaCelle() {
		return contaCelle;
	}
	public void setContaCelle(int contaCelle) {
		this.contaCelle = contaCelle;
	}


	
	public World getWorld()
	{
		return GameMenager.world;
	}
	
	/*public static void main(String [] args)
	{
		MyFrame frame= new MyFrame();
		GameMenager.StartWorld();
		
	}*/
}
