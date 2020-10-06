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
	public static boolean audio_attivo=false;
	
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
	/**
	 * @return the audio_attivo
	 */
	public boolean isAudio_attivo() {
		return audio_attivo;
	}

	/**
	 * @param audio_attivo the audio_attivo to set
	 */
	public void setAudio_attivo(boolean audio_attivo) {
		this.audio_attivo = audio_attivo;
	}

	public void playMusic()
	{

			loop_clip.setMicrosecondPosition(0);
			loop_clip.start();
			loop_clip.loop(Clip.LOOP_CONTINUOUSLY);
			//System.out.println("AVVIATO");
			audio_attivo=true;
		
		
	}
	public void stopMusic() 
	{
			stoppato=true;
			loop_clip.stop();
			audio_attivo=false;
			//System.out.println("STOPPATO");
		
		
	}

	public boolean isStoppato() {
		return stoppato;
	}

	public void setStoppato(boolean stoppato) {
		this.stoppato = stoppato;
	}



}