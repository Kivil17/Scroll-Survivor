package core.thread;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import core.interfaces.Direction;
import core.menager.MyPanel;

public class MyThread extends Thread
{
	MyPanel panel;
	public int z;
	Robot robot;
	
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public MyThread(MyPanel p)
	{
		this.panel=p;
		
		z=4000;
	}
	
	public void run()
	{
		
		while(!panel.getGM().isFine())
		{
			
			
			
			
			panel.getGM().ScendiMatrice();
			panel.getGM().ScendiMatrice();
			panel.getGM().GeneraRigaBase();
			panel.getGM().ScendiMatrice();
			panel.getGM().GeneraRiga();
			
			panel.getGM().IsGameOver();
			
			this.panel.repaint();
			
			try {
				
				if(panel.getGM().getWorld().getPlayer().getPoint()==50)
					z=z-1000;
				if(panel.getGM().getWorld().getPlayer().getPoint()==150)
					z=z-500;
				if(panel.getGM().getWorld().getPlayer().getPoint()==250)
					z=z-200;
				
				sleep(z);
				//System.out.println(panel.getGM().getWorld().getPlayer().getPoint());
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			
			
		}
		
		
	}

	private void type(int i) {
		robot.delay(40);
	    robot.keyPress(i);
	    robot.keyRelease(i);
		
		
	}
}
