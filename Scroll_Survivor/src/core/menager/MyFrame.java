package core.menager;

import java.awt.Dimension;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//import java.awt.Toolkit;
import javax.swing.JFrame;

import core.music.MusicManager;

@SuppressWarnings("serial")

public class MyFrame extends JFrame
{
	MyPanel panel;
	GameMenager gamemenager;
	MusicManager music_manager;
	
	public MyFrame(String user)
	{
		
		super();
		
		music_manager = new MusicManager(this.gamemenager);
		
		try {
			music_manager.initMusic();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(music_manager.isStoppato()==false && panel.ok==false )
			music_manager.playMusic();
		
		gamemenager=new GameMenager(user);
		panel = new MyPanel(gamemenager);
		
		
		this.setSize(new Dimension (770, 770));
		this.setTitle("Scroll Survivor");
		this.setContentPane(panel);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	
}
