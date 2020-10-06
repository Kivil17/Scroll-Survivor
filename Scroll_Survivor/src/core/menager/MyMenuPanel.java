package core.menager;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.music.MusicManager;
import core.thread.MenuThread;

public class MyMenuPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	Image arrow;
	Image credits;
	
	Image wait1;
	Image wait2;
	Image wait3;
	Image wait4;
	
	int conta;
	
	ImageIcon icon= new ImageIcon("Resources/image/music2.png"); 
	
	ImageIcon icon2= new ImageIcon("Resources/image/music1.png");
	
	ArrayList<Image> w;
	
	Toolkit tk=Toolkit.getDefaultToolkit();
	int [] position;
	MenuThread mt= new MenuThread(this);
	MyFrame game;
	
	URL urlMenuBackground= this.getClass().getResource("/Image/bg.png");
	Image menuBackground=tk.getImage(urlMenuBackground);
	
	JButton iName;
	JLabel name;
	JTextField name_field;
	
	JButton return_menu;
	JButton music;
	JButton music1;
	JButton start;
	
	MyMenuFrame mmf;
	
	boolean c;
	public boolean stop;
	boolean inserito;
	
	String user;
	
	MusicManager music_manager;
	
	GameMenager gamemenager;
	
	public MyMenuPanel()
	{
		super();
		
		inserito=false;
		c=false;
		stop=true;
		conta=0;
		
		w= new ArrayList<Image>();
		
		user="";
		this.setEnabled(true);
		
		//bottone per tornare al menu
		return_menu= new JButton();
		return_menu.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
		return_menu.setText("back to menu");
		return_menu.setForeground(Color.RED);
		return_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				return_menu.setVisible(false);
				
				iName.setVisible(true);
				name.setVisible(true);
				name_field.setVisible(true);
				if(inserito)
				{
					name.setText("Welcome "+user);
					iName.setVisible(false);
					name_field.setVisible(false);
				}
				else
				{
					name.setText("Insert Your Name");
				}
				c=false;
				
			}
			
			}
				
		);
		this.add(return_menu);
	
		return_menu.setVisible(false);
		
		//bottone per far partire il gioco
		
		start= new JButton();
		start.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
		start.setText("START GAME");
		start.setForeground(Color.RED);
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.setVisible(false);
				mt.stop();
				stop=true;
				//mmf.dispose();
				game = new MyFrame(user);
				
			}
			
			}
				
		);
		this.add(start);
	
		start.setVisible(false);
		
		//bottone per stoppare la musica
		
		music= new JButton(icon);
		music.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
		
		
		music.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				music_manager = new MusicManager(gamemenager);
				
				try {
					music_manager.initMusic();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				music_manager.stopMusic();
				
			}
			
			}
				
		);
		this.add(music);
	
		music.setVisible(false);
		
		//bottone per far partire la musica
		
	
			music1= new JButton(icon2);
			music1.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
				
			music1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					music_manager = new MusicManager(gamemenager);
						
					try {
						music_manager.initMusic();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
					music_manager.setStoppato(false);
						
				}
					
				}
						
			);
			this.add(music1);
			
			music1.setVisible(false);
				
		
		
		//assegno il tasto di invio del nome
		iName=new JButton();
		iName.setFont(new Font("Monospaced Bold",Font.PLAIN,10));
		iName.setText("SEND");
		
		//assegno il testo per l'inserimento
		name=new JLabel();
		name.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
		name.setText("Insert your name");
		name.setForeground(Color.GREEN);
		
		this.add(iName);
		this.add(name);
		
		name_field= new JTextField();
		name_field.setFont(new Font("Monospaced Bold",Font.PLAIN,10));
		this.add(name_field);
		
		position= new int[2];
		position[0]=1;
		position[1]=0;
		
		initMenu();
		initListener();
	}

	public void initMenu()
	{
		
		URL urlarrow=this.getClass().getResource("/image/Red_Arrow_Left.png");
		arrow=tk.getImage(urlarrow);
		
		URL urlcredits=this.getClass().getResource("/image/credits.png");
		credits=tk.getImage(urlcredits);
		
		URL urlwait1=this.getClass().getResource("/image/wait1.jpg");
		URL urlwait2=this.getClass().getResource("/image/wait2.jpg");
		URL urlwait3=this.getClass().getResource("/image/wait3.jpg");
		URL urlwait4=this.getClass().getResource("/image/wait4.jpg");
		
		wait1=tk.getImage(urlwait1);
		wait2=tk.getImage(urlwait2);
		wait3=tk.getImage(urlwait3);
		wait4=tk.getImage(urlwait4);
		
		w.add(wait1);
		w.add(wait2);
		w.add(wait3);
		w.add(wait4);
		
		mt.start();
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		if(stop==false)
		{
			iName.setVisible(false);
			name.setVisible(false);
			name_field.setVisible(false);
			name.setText(null);
			
			start.setVisible(true);
			music.setVisible(true);
			music1.setVisible(true);
			
			start.setBounds(290, 500, 200, 30);
			music.setBounds(600, 100, icon.getIconWidth(), icon.getIconHeight());
			music1.setBounds(700, 100, icon.getIconWidth(), icon.getIconHeight());
			
			for(int i=0; i<w.size(); i++)
			{
				if(conta==0)
				{
					g.drawImage(w.get(conta), 0, 0, null);
					conta++;
				}
				else if(conta==1)
				{
					g.drawImage(w.get(conta), 0, 0, null);
					conta++;
				}
				else if(conta==2)
				{
					g.drawImage(w.get(conta), 0, 0, null);
					conta++;
				}
				else if(conta==3)
				{
					g.drawImage(w.get(conta), 0, 0, null);
					conta=0;
				}
			}
		}
		else
		{
			g.drawImage(menuBackground, 0, 0,this);
			if(position[0]==1)
			g.drawImage(arrow, 255, 320,this);
			if(position[1]==1)
			g.drawImage(arrow, 255, 510,this);
			
			
			if(c)
			{
				iName.setVisible(false);
				name.setVisible(false);
				name_field.setVisible(false);
				name.setText(null);
				
				return_menu.setVisible(true);
				
				g.drawImage(credits, 0, 0, this);
				
			}
			
			iName.setBounds(650, 240, 100, 30);
			
			
			name.setBounds(550, 140, 300, 100);
			name.setVisible(true);
			
			name_field.setBounds(550, 200, 200, 30);
			
		}	
	}
	
public void initListener() {
		
		
		iName.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				user=name_field.getText();
				name.setText("Welcome "+user);
				inserito=true;
				iName.setVisible(false);
				name_field.setVisible(false);
				}
			
		});
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				
				if(e.getKeyCode()==40) 
				{
					if(position[0]==1) 
					{
						position[0]=0;
						position[1]=1;
						
					}
					
				}
				else if(e.getKeyCode()==38) 
				{
					
					if(position[1]==1)
					{
						position[1]=0;
						position[0]=1;
					}
				}
				else if(e.getKeyCode()==10) 
				{
					if(position[0]==1) 
					{
						stop=false;
					}
					else if(position[1]==1)
					{
						c=true;
					}
						
				}
				
			}	
		}
		);		
	}

	

}
