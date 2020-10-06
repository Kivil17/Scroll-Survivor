package core.menager;

import javax.swing.JFrame;

public class MyMenuFrame extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	
	MyMenuPanel m = new MyMenuPanel();

	
	public MyMenuFrame() {
		super();
		
		
		
		this.setTitle("Menù");
		this.setSize(770, 770);
		this.setContentPane(m);
		m.setFocusable(true);
			
			
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setResizable(false);
			
		
		
	}
	
	public static void main(final String[] args) {
		MyMenuFrame menu = new MyMenuFrame();
		
	}

}
