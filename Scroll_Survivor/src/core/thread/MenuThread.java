package core.thread;

import core.menager.MyMenuPanel;

public class MenuThread extends Thread
{
		
		MyMenuPanel m;
		
		public MenuThread(MyMenuPanel m) 
		{
			this.m=m;
			
		}
		
		public void run() 
		{
			
			while(true) 
			{
				
				m.repaint();
				try {
					sleep(100);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
			
		}
}


