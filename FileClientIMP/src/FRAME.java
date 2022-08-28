import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SwingFrame extends JFrame implements Runnable
{
	JPanel jpt,jpl,jpr;
	Color col,lbCol;
	JLabel lb;
	Image img;
	Random ra;
	Font f;
	JTextField jid,jpwd;
	int rr,gg,bb;
	Thread th;
	MyFrame mf;
	SwingFrame(String s)
	{
		super(s);
		th=new Thread(this);
		jpt=new JPanel();
		jpr=new JPanel();
		jpl=new JPanel();
		jpt.setLayout(null);
		jpl.setLayout(null);
		jpr.setLayout(null);
		jpt.setBounds(0, 0,1300, 250);
		jpl.setBounds(0, 250,400, 450);
		jpr.setBounds(400, 250,900, 450);
		f=new Font("Ink free",Font.BOLD,32);
		this.setResizable(false);
		col=new Color(255);
		jpt.setBackground(col.black);
		jpl.setBackground(col.getColor("wooden"));
		jpr.setBackground(col.BLUE);
		lb=new JLabel("WELCOME TO OUR PORTAL");
		lb.setFont(f);
		ra=new Random();
		lb.setBounds(400,100,1300,50);
		jpt.add(lb);	
		add(jpt);	add(jpr);	add(jpl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		th.start();
	}
			public void run()
			{
				while(true)
				{
					rr=ra.nextInt(255);
					gg=ra.nextInt(255);
					bb=ra.nextInt(255);
					lbCol=new Color(rr,gg,bb);
					lb.setForeground(lbCol);
					try {
						Thread.sleep(300);
					}
					catch(Exception e)
					{}
				}
			}
}

public class FRAME{
	public static void main(String[] args) {
		SwingFrame sf=new SwingFrame("AGEETAN CORPORATION");
		sf.setVisible(true);
		sf.setSize(1300,700);
		sf.setLocation(50, 50);
	}
}
null
