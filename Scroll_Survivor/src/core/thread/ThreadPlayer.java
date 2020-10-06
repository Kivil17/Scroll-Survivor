package core.thread;

import core.menager.MyPanel;

public class ThreadPlayer extends Thread
{
	MyPanel panel;
	public ThreadPlayer(MyPanel p)
	{
		this.panel=p;
		
	}
	
	public void run()
	{
		while(!panel.getGM().isFine())
		{
			
			
			
			if(panel.getGM().isJumping())
			{
				panel.getGM().JumpMenager();
			}
			else
			{
				panel.getGM().FallingMenager();
			}
			
			this.panel.repaint();
			
			try {
				sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}
}
