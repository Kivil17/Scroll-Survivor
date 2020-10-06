package core.menager;


import java.awt.AWTException;
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.Base;
import core.Coin;
import core.Player;
import core.interfaces.Direction;
import core.interfaces.Entity;
import core.music.MusicManager;
import core.thread.MyThread;
import core.thread.ThreadPlayer;

@SuppressWarnings("serial")

public class MyPanel extends JPanel
{
	
	JLabel point;
	JLabel record;
	
	MyFrame game;
	
	Toolkit t = Toolkit.getDefaultToolkit();

	JButton return_menu;
	boolean c;
	static boolean ok;
	
	GameMenager gamemenager;
	
	Image wall;
	Image background;
	
	Image player;
	Image player1;
	Image player2;
	Image player3;
	Image player4;
	Image player5;
	Image player6;
	Image player7;
	Image player8;
	Image player9;
	
	Image playerRight;
	Image playerRight1;
	Image playerRight2;
	Image playerRight3;
	Image playerRight4;
	Image playerRight5;
	Image playerRight6;
	Image playerRight7;
	Image playerRight8;
	Image playerRight9;
	
	Image playerLeft;
	Image playerLeft1;
	Image playerLeft2;
	Image playerLeft3;
	Image playerLeft4;
	Image playerLeft5;
	Image playerLeft6;
	Image playerLeft7;
	Image playerLeft8;
	Image playerLeft9;
	
	Image playerUp;
	
	Image coin;
	Image coin1;
	Image coin2;
	Image coin3;
	Image coin4;
	Image coin5;
	Image coin6;
	Image coin7;
	Image coin8;
	Image coin9;
	
	Image go;

	
	ArrayList<Image> idlePlayer = new ArrayList<Image>();
	ArrayList<Image> PlayerRight = new ArrayList<Image>();
	ArrayList<Image> PlayerLeft = new ArrayList<Image>();
	
	ArrayList<Image> coinG= new ArrayList<Image>();
	
	MyFrame frame;
	
	int destra=0;
	int sinistra=0;
	int k=0;
	
	int destrav=0;
	int sinistrav=0;
	
	int co=0;
	
	static boolean flag=true;
	
	MyThread thread;
	ThreadPlayer thread2;
	
	Entity [][]M;
	
	public MyPanel (GameMenager g)
	{
		super();
		
		//variabili
		ok=false;
		
		thread= new MyThread(this);
		thread2= new ThreadPlayer(this);
	
		point=new JLabel();
		point.setFont(new Font("Monospaced Bold", Font.PLAIN, 20));
		point.setBounds(0,0,0,0);
		point.setForeground(Color.YELLOW);
		this.add(point);

		
		return_menu= new JButton();
		return_menu.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
		return_menu.setText("PLAY AGAIN");
		return_menu.setForeground(Color.RED);
		return_menu.setVisible(false);
		return_menu.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				return_menu.setVisible(false);
				gamemenager.getWorld().getPlayer().setPoint(0);
				thread.setZ(4000);
				ok=true;
				game = new MyFrame(gamemenager.getUser());
				
			}
			
			}
				
		);
		this.add(return_menu);

		
		this.setEnabled(true);
		this.setFocusable(true);
		this.gamemenager = g;
		
		M = gamemenager.getWorld().getMatrix();
		
		gamemenager.StartWorld();
		
		initGUI();
		
		initEH();
	
		
	}

	private void initEH() {
		
		
		thread.start();
		thread2.start();
		
		this.addKeyListener(new KeyAdapter(){
			
			public void keyReleased(KeyEvent e)
			{
				
				if(gamemenager.isFine()==true)
				{
					thread.stop();
					thread2.stop();
				}
				else
				{
					if(e.getKeyChar()=='a')
					{
						gamemenager.getWorld().getPlayer().setDirection(Direction.LEFT);
						gamemenager.movePlayer( Direction.LEFT);
					}
					else if(e.getKeyChar()=='d')
					{
						gamemenager.getWorld().getPlayer().setDirection(Direction.RIGHT);
						gamemenager.movePlayer( Direction.RIGHT);
					}
					else if(e.getKeyChar()=='w')
					{
						gamemenager.getWorld().getPlayer().setDirection(Direction.UP);
						gamemenager.movePlayer( Direction.UP);
					}
					
					MyPanel p = (MyPanel) e.getSource();
					p.repaint();
			
				}
				
			}
		}
		);
		
	}

	public static boolean getFlag()
	{
		return flag;
	}
	public static void setFlag(boolean f)
	{
		flag=f;
	}
	public void initGUI()
	{
		
		
	
		
		
		URL urlgo=this.getClass().getResource("/image/Game Overs.jpg");
		
		
		URL urlplayer=this.getClass().getResource("/image/JK_P_Gun__Idle_000.png");
		URL urlplayer1=this.getClass().getResource("/image/JK_P_Gun__Idle_001.png");
		URL urlplayer2=this.getClass().getResource("/image/JK_P_Gun__Idle_002.png");
		URL urlplayer3=this.getClass().getResource("/image/JK_P_Gun__Idle_003.png");
		URL urlplayer4=this.getClass().getResource("/image/JK_P_Gun__Idle_004.png");
		URL urlplayer5=this.getClass().getResource("/image/JK_P_Gun__Idle_005.png");
		URL urlplayer6=this.getClass().getResource("/image/JK_P_Gun__Idle_006.png");
		URL urlplayer7=this.getClass().getResource("/image/JK_P_Gun__Idle_007.png");
		URL urlplayer8=this.getClass().getResource("/image/JK_P_Gun__Idle_008.png");
		URL urlplayer9=this.getClass().getResource("/image/JK_P_Gun__Idle_009.png");
		
		URL urlplayerRight=this.getClass().getResource("/image/JK_P_Gun__Run_000.png");
		URL urlplayerRight1=this.getClass().getResource("/image/JK_P_Gun__Run_001.png");
		URL urlplayerRight2=this.getClass().getResource("/image/JK_P_Gun__Run_002.png");
		URL urlplayerRight3=this.getClass().getResource("/image/JK_P_Gun__Run_003.png");
		URL urlplayerRight4=this.getClass().getResource("/image/JK_P_Gun__Run_004.png");
		URL urlplayerRight5=this.getClass().getResource("/image/JK_P_Gun__Run_005.png");
		URL urlplayerRight6=this.getClass().getResource("/image/JK_P_Gun__Run_006.png");
		URL urlplayerRight7=this.getClass().getResource("/image/JK_P_Gun__Run_007.png");
		URL urlplayerRight8=this.getClass().getResource("/image/JK_P_Gun__Run_008.png");
		URL urlplayerRight9=this.getClass().getResource("/image/JK_P_Gun__Run_009.png");
		
		URL urlplayerLeft=this.getClass().getResource("/image/JK_P_Gun__Run1_000.png");
		URL urlplayerLeft1=this.getClass().getResource("/image/JK_P_Gun__Run2_001.png");
		URL urlplayerLeft2=this.getClass().getResource("/image/JK_P_Gun__Run3_002.png");
		URL urlplayerLeft3=this.getClass().getResource("/image/JK_P_Gun__Run4_003.png");
		URL urlplayerLeft4=this.getClass().getResource("/image/JK_P_Gun__Run5_004.png");
		URL urlplayerLeft5=this.getClass().getResource("/image/JK_P_Gun__Run6_005.png");
		URL urlplayerLeft6=this.getClass().getResource("/image/JK_P_Gun__Run7_006.png");
		URL urlplayerLeft7=this.getClass().getResource("/image/JK_P_Gun__Run8_007.png");
		URL urlplayerLeft8=this.getClass().getResource("/image/JK_P_Gun__Run9_008.png");
		URL urlplayerLeft9=this.getClass().getResource("/image/JK_P_Gun__Run10_009.png");
		
		
		URL urlplayerUp=this.getClass().getResource("/image/JK_P_Gun__Jump_000.png");
		
		URL urlcoin= this.getClass().getResource("/image/Silver_21.png");
		URL urlcoin1= this.getClass().getResource("/image/Silver_22.png");
		URL urlcoin2= this.getClass().getResource("/image/Silver_23.png");
		URL urlcoin3= this.getClass().getResource("/image/Silver_24.png");
		URL urlcoin4= this.getClass().getResource("/image/Silver_25.png");
		URL urlcoin5= this.getClass().getResource("/image/Silver_26.png");
		URL urlcoin6= this.getClass().getResource("/image/Silver_27.png");
		URL urlcoin7= this.getClass().getResource("/image/Silver_28.png");
		URL urlcoin8= this.getClass().getResource("/image/Silver_29.png");
		URL urlcoin9= this.getClass().getResource("/image/Silver_30.png");
		
		
		URL urlwall=this.getClass().getResource("/image/blocco-png-9.png");
		
		URL urlbg=this.getClass().getResource("/image/SPoW_82318_01.jpg.png");
		
		
		wall= t.getImage(urlwall);
		
		playerUp= t.getImage(urlplayerUp);
		
		player= t.getImage(urlplayer);
		player1= t.getImage(urlplayer1);
		player2= t.getImage(urlplayer2);
		player3= t.getImage(urlplayer3);
		player4= t.getImage(urlplayer4);
		player5= t.getImage(urlplayer5);
		player6= t.getImage(urlplayer6);
		player7= t.getImage(urlplayer7);
		player8= t.getImage(urlplayer8);
		player9= t.getImage(urlplayer9);
		
		playerRight= t.getImage(urlplayerRight);
		playerRight1= t.getImage(urlplayerRight1);
		playerRight2= t.getImage(urlplayerRight2);
		playerRight3= t.getImage(urlplayerRight3);
		playerRight4= t.getImage(urlplayerRight4);
		playerRight5= t.getImage(urlplayerRight5);
		playerRight6= t.getImage(urlplayerRight6);
		playerRight7= t.getImage(urlplayerRight7);
		playerRight8= t.getImage(urlplayerRight8);
		playerRight9= t.getImage(urlplayerRight9);
		
		playerLeft= t.getImage(urlplayerLeft);
		playerLeft1= t.getImage(urlplayerLeft1);
		playerLeft2= t.getImage(urlplayerLeft2);
		playerLeft3= t.getImage(urlplayerLeft3);
		playerLeft4= t.getImage(urlplayerLeft4);
		playerLeft5= t.getImage(urlplayerLeft5);
		playerLeft6= t.getImage(urlplayerLeft6);
		playerLeft7= t.getImage(urlplayerLeft7);
		playerLeft8= t.getImage(urlplayerLeft8);
		playerLeft9= t.getImage(urlplayerLeft9);
		
		
		coin= t.getImage(urlcoin);
		coin1= t.getImage(urlcoin1);
		coin2= t.getImage(urlcoin2);
		coin3= t.getImage(urlcoin3);
		coin4= t.getImage(urlcoin4);
		coin5= t.getImage(urlcoin5);
		coin6= t.getImage(urlcoin6);
		coin7= t.getImage(urlcoin7);
		coin8= t.getImage(urlcoin8);
		coin9= t.getImage(urlcoin9);
		
		//background
		background = t.getImage(urlbg);
		
		//immagine game over
		go=t.getImage(urlgo);
		
		//aggiungo le immagini per ogni arraylist
		
		idlePlayer.add(player);
		idlePlayer.add(player1);
		idlePlayer.add(player2);
		idlePlayer.add(player3);
		idlePlayer.add(player4);
		idlePlayer.add(player5);
		idlePlayer.add(player6);
		idlePlayer.add(player7);
		idlePlayer.add(player8);
		idlePlayer.add(player9);
		
		PlayerRight.add(playerRight);
		PlayerRight.add(playerRight1);
		PlayerRight.add(playerRight2);
		PlayerRight.add(playerRight3);
		PlayerRight.add(playerRight4);
		PlayerRight.add(playerRight5);
		PlayerRight.add(playerRight6);
		PlayerRight.add(playerRight7);
		PlayerRight.add(playerRight8);
		PlayerRight.add(playerRight9);
		
		PlayerLeft.add(playerLeft);
		PlayerLeft.add(playerLeft1);
		PlayerLeft.add(playerLeft2);
		PlayerLeft.add(playerLeft3);
		PlayerLeft.add(playerLeft4);
		PlayerLeft.add(playerLeft5);
		PlayerLeft.add(playerLeft6);
		PlayerLeft.add(playerLeft7);
		PlayerLeft.add(playerLeft8);
		PlayerLeft.add(playerLeft9);
		
		coinG.add(coin);
		coinG.add(coin1);
		coinG.add(coin2);
		coinG.add(coin3);
		coinG.add(coin4);
		coinG.add(coin5);
		coinG.add(coin6);
		coinG.add(coin7);
		coinG.add(coin8);
		coinG.add(coin9);
		
	}
	public GameMenager getGM()
	{
		return gamemenager;
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int dx=0,dy=0;
	
		if(!gamemenager.isFine())
		{
			
				
			g.drawImage(background,0,0,this);
			
			for(int i=0; i<gamemenager.getWorld().getDimx(); i++)
			{
				for(int j=0; j<gamemenager.getWorld().getDimy(); j++)
				{

					if(M[i][j] instanceof Player)
					{
						
							
						if(gamemenager.getWorld().getPlayer().getDirection()==Direction.STOP)
						{
							
							if(k==0)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==1)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==2)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==3)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==4)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==5)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==6)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==7)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==8)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k++;
							}
							else if(k==9)
							{
								g.drawImage(idlePlayer.get(k), dx, dy, null);
								k=0;
							}
						
							
						}
						if(gamemenager.getWorld().getPlayer().getDirection()==Direction.RIGHT)
						{
							
							if(destra==0)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==1)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==2)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==3)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==4)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==5)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==6)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==7)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==8)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra++;
							}
							else if(destra==9)
							{
								g.drawImage(PlayerRight.get(destra), dx, dy, null);
								destra=0;
							}
							
						
						}
						else if(gamemenager.getWorld().getPlayer().getDirection()==Direction.LEFT)
						{
							
							if(sinistra==0)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==1)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==2)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==3)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==4)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==5)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==6)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==7)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==8)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra++;
							}
							else if(sinistra==9)
							{
								g.drawImage(PlayerLeft.get(sinistra), dx, dy, null);
								sinistra=0;
							}
							
							
						
						}
						else if(gamemenager.getWorld().getPlayer().getDirection()==Direction.UP)
						{
							
							g.drawImage(playerUp, dx, dy, null);
							
						}
					}
					
					if(M[i][j] instanceof Base)
						g.drawImage(wall, dx, dy, null);
					
					if(M[i][j] instanceof Coin)
					{
							
								if(co==0)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==1)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==2)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==3)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==4)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==5)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==6)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==7)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==8)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co++;
								}
								else if(co==9)
								{
									g.drawImage(coinG.get(co), dx, dy, null);
									co=0;
								}
						
					}
					
					
					
					dx+=70;
				}
				dy+=70;
				dx=0;
			}
			point.setBounds(100, 5, 300, 60);
			point.setVisible(true);
			
			point.setText("PUNTEGGIO "+gamemenager.getUser()+":"+String.valueOf(gamemenager.getWorld().getPlayer().getPoint()));
			
		

		}	
		else
		{
			
			return_menu.setVisible(true);
			
			return_menu.setBounds(290, 500, 200, 30);
			g.drawImage(go, 0, 0, this);
		}
		
		
		
	}
}
