package core.music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import core.menager.GameMenager;

public class MusicManager {
	
	GameMenager gamemanager;
	
	AudioFormat	loop_format;
	DataLine.Info	loop_info;
	Clip loop_clip;
	File loop_music;
	AudioInputStream loop_stream;
	
	
	public static boolean stoppato=false;
	
	public MusicManager(GameMenager gamemanager) {
		super();
		this.gamemanager = gamemanager;
	}
	
	public void initMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		loop_stream=AudioSystem.getAudioInputStream(this.getClass().getResourceAsStream("Space-Sprinkles.wav"));
		loop_format= loop_stream.getFormat();
		loop_info=new DataLine.Info(Clip.class,loop_format);
		loop_clip= (Clip) AudioSystem.getLine(loop_info);
		loop_clip.open(loop_stream);
	    
	}
	public void playMusic()
	{

			loop_clip.setMicrosecondPosition(0);
			loop_clip.start();
			loop_clip.loop(Clip.LOOP_CONTINUOUSLY);
			//System.out.println("AVVIATO");
	
		
		
	}
	public void stopMusic() 
	{
			stoppato=true;
			loop_clip.stop();
			
			//System.out.println("STOPPATO");
		
		
	}

	public boolean isStoppato() {
		return stoppato;
	}

	public void setStoppato(boolean stoppato) {
		this.stoppato = stoppato;
	}



}