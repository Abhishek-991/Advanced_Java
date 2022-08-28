import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame
{
	Calendar cal;
	SimpleDateFormat timeFormat,dayFormat,dateFormat; 
	JLabel timeLabel,dayLabel,dateLabel;
	String time,day,date;
	TimeZone time_zone;
	MyFrame()
	{
		this.setTitle("INDIAN CLOCK");
		this.setLayout(new FlowLayout());
		this.setSize(450,170);
		this.setResizable(false);
		
		TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
		
		timeFormat=new SimpleDateFormat("hh:mm:ss a z");
		timeFormat.setTimeZone(istTimeZone);
		dayFormat=new SimpleDateFormat("EEEE");
		dayFormat.setTimeZone(istTimeZone);
		dateFormat=new SimpleDateFormat("dd MMMMM ,yyyy");
		dateFormat.setTimeZone(istTimeZone);
		timeLabel=new JLabel();
		dayLabel=new JLabel();
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));
		dateLabel=new JLabel();
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
		
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
	
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		
		this.setVisible(true);
		
		setTime();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void setTime()
	{
		try {
		while(true) {
		time=timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);

		day=dayFormat.format(Calendar.getInstance().getTime());
		dayLabel.setText(day);

		date=dateFormat.format(Calendar.getInstance().getTime());
		dateLabel.setText(date);

		
		Thread.sleep(1000);
		}
		}
		catch(Exception e)
		{
			System.out.print("ERROR : "+e.getMessage());
		}
	}
	public static void main(String[] st) {
		MyFrame mf=new MyFrame();
	}
}

