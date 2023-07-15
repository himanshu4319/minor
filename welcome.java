import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class welcome extends JDialog 
{
	Color c1 = new Color(217,217,217);//grey;
	Color c2 = new Color(191,189,186);//semi-dark grey
	Color c3 = new Color(166,162,159);//dark grey
	Color c4 = new Color(115,115,115);
	Color c5 = new Color(89,85,82);
	static progressThread pt;
	static JProgressBar JPro;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
	JLabel head,progress,desc;
	welcome()
	{
		setSize(700,550);
		setTitle("Aggarwal & Aggarwal's");
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});

		//light grey box
		p1 = new JPanel();
		p1.setBounds(0,0,100,100);
		p1.setBackground(c1);
		add(p1);

		p2 = new JPanel();
		p2.setBounds(105,105,100,100);
		p2.setBackground(c1);
		add(p2);

		p3 = new JPanel();
		p3.setBounds(210,210,100,100);
		p3.setBackground(c1);
		add(p3);

		p4 = new JPanel();
		p4.setBounds(315,315,100,100);
		p4.setBackground(c1);
		add(p4);


		//semi dark boxes

		p5 = new JPanel();
		p5.setBounds(0,105,100,100);
		p5.setBackground(c2);
		add(p5);

		p6 = new JPanel();
		p6.setBounds(105,210,100,100);
		p6.setBackground(c2);
		add(p6);

		p7 = new JPanel();
		p7.setBounds(210,315,100,100);
		p7.setBackground(c2);
		add(p7);

		//dark grey boxes

		p8 = new JPanel();
		p8.setBounds(0,210,100,100);
		p8.setBackground(c3);
		add(p8);

		p9 = new JPanel();
		p9.setBounds(105,315,100,100);
		p9.setBackground(c3);
		add(p9);


		//dark-2 grey

		p10 = new JPanel();
		p10.setBounds(0,315,100,100);
		p10.setBackground(c4);
		add(p10);

		head = new JLabel("Aggarwal & Aggarwal's");
		head.setFont(new Font("Calibri",Font.PLAIN,40));
		head.setBounds(250,75,400,40);
		add(head);

		desc = new JLabel("( A complete Solution of your Bussiness needs...)");
		desc.setFont(new Font("Calibri",Font.PLAIN,17));
		desc.setBounds(300,135,375,20);
		add(desc);

		progress = new JLabel("Progress :");
		progress.setFont(new Font("Calibri",Font.BOLD,20));
		progress.setBounds(520,395,150,25);
		add(progress);


		JPro = new JProgressBar(JProgressBar.HORIZONTAL);
		JPro.setBounds(40,445,600,25);
		JPro.setForeground(new Color(89,89,89));
		add(JPro);

		pt = new progressThread(JPro);
		pt.start();

		
		

	}
	public static void main(String[] args) {
		new welcome();
	}
	class progressThread extends Thread
	{
		JProgressBar jb1;
		public progressThread(JProgressBar jb1)
		{
			this.jb1 = jb1;
		}
		public void start()
		{
			int min=0,max=100;
			jb1.setMinimum(min);
			jb1.setMaximum(max);
			jb1.setValue(min);
			for(int x = min;x<=max;x++)
			{
				jb1.setValue(x);
				progress.setText("Progress : "+x+" %");
				if(x==100)
				{
					new login();
					setVisible(false);
				}
				try
				{
					Thread.sleep(50);
				}
				catch(Exception e){
				}	
			}	
		}
	}
}