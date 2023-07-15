//login window
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.sql.Driver.*;
class login extends JFrame implements FocusListener,ActionListener,MouseListener
{
	String user,firm,signinuser;
	JLabel brandName,userName,passWord,brandLogo,reg;
	JTextField userInput ;
	JPasswordField passInput;
	JButton signInButton;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18 ;
	JOptionPane j1;
	int status;//for determining whether login user is a administrator or normal user.
	//color
	Color c1 = new Color(217,217,217);//grey;
	Color c2 = new Color(255,255,255);//white;
	Color c3 = new Color(28,37,64);//royal dark blue
	Color c4 = new Color(44,44,44);//royal black
	Color c5 = new Color(191,189,186);//light-dark grey
	Color c6 = new Color(166,162,159);//dark - light grey
	Color c7 = new Color(115,115,115);
	Color c8 = new Color(89,85,82);
	//font
	Font f1 = new Font("Calibri",Font.PLAIN,45);
	Font f2 = new Font("Calibri",Font.BOLD,25);
	Font f3 = new Font("Calibri",Font.PLAIN,20);
	Font f4 = new Font("Calibri",Font.BOLD,20);
	login()
	{

		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/minor/icons/icon.png");
		setIconImage(icon);
		
		setSize(1920,1080);
		JPanel back = new JPanel();
		back.setBounds(0,0,1920,1080);
		back.setLayout(null);
		back.setBackground(new Color(226,229,231));
		add(back);
		//this.setBackground(new Color(101,169,240));
		setLayout(null);
		setTitle("Login Page");

		//grey boxes mid....
		p1 = new JPanel();
		p1.setBackground(c1);
		p1.setBounds(0,0,200,200);
		p1.addMouseListener(this);
		back.add(p1);
		p2 = new JPanel();
		p2.setBackground(c1);
		p2.setBounds(210,210,200,200);
		back.add(p2);
		p2.addMouseListener(this);
		p3 = new JPanel();
		p3.setBackground(c1);
		p3.setBounds(420,420,200,200);
		back.add(p3);
		p3.addMouseListener(this);
		p4 = new JPanel();
		p4.setBounds(630,630,200,200);
		p4.setBackground(c1);
		back.add(p4);
		p4.addMouseListener(this);
		p5 = new JPanel();
		p5.setBackground(c1);
		p5.setBounds(840,840,200,200);
		back.add(p5);
		p5.addMouseListener(this);


		//grey boxes left
		p6 = new JPanel();
		p6.setBackground(c5);
		p6.setBounds(0,210,200,200);
		back.add(p6);
		p6.addMouseListener(this);
		p7 = new JPanel();
		p7.setBackground(c5);
		p7.setBounds(210,420,200,200);
		back.add(p7);
		p7.addMouseListener(this);
		p8 = new JPanel();
		p8.setBackground(c5);
		p8.setBounds(420,630,200,200);
		back.add(p8);
		p8.addMouseListener(this);
		p9 = new JPanel();
		p9.setBackground(c5);
		p9.setBounds(630,840,200,200);
		back.add(p9);
		p9.addMouseListener(this);


		//dark -light grey boxes
		p10 = new JPanel();
		p10.setBackground(c6);
		p10.setBounds(0,420,200,200);
		back.add(p10);
		p11 = new JPanel();
		p11.setBackground(c6);
		p11.setBounds(210,630,200,200);
		back.add(p11);
		p12 = new JPanel();
		p12.setBackground(c6);
		p12.setBounds(420,840,200,200);
		back.add(p12);

		//dark grey boxes
		p13 = new JPanel();
		p13.setBackground(c7);
		p13.setBounds(0,630,200,200);
		back.add(p13);
		p13.addMouseListener(this);

		p14 = new JPanel();
		p14.setBackground(c7);
		p14.setBounds(210,840,200,200);
		back.add(p14);
		p14.addMouseListener(this);

		//last dark grey box
		p15 = new JPanel();
		p15.setBackground(c8);
		p15.setBounds(0,840,200,200);
		back.add(p15);
		p15.addMouseListener(this);


		//right corner
		p16 = new JPanel();
		p16.setBackground(c8);
		p16.setBounds(1720,0,200,200);
		back.add(p16);
		p16.addMouseListener(this);

		p17  = new JPanel();
		p17.setBackground(new Color(115,115,115));
		p17.setBounds(1510,0,200,200);
		back.add(p17);
		p17.addMouseListener(this);

		p18 = new JPanel();
		p18.setBackground(new Color(115,115,115));
		p18.setBounds(1720,210,200,200);
		back.add(p18);
		p18.addMouseListener(this);

		/*JPanel head = new JPanel();
		head.setBounds();
		head.setBackground(new Color(226,229,231));
		head.setLayout(null);
		back.add(head);
*/
		brandLogo = new JLabel(new ImageIcon("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/minor/icons/icon.png"));
		brandLogo.setBounds(550,20,200,160);
		back.add(brandLogo);

		brandName = new JLabel("Aggarwal & Aggarwal's");
		brandName.setBounds(750,60,600,80);
		brandName.setFont(f1);
		back.add(brandName);


		//username/Email
		userName = new JLabel("Username / Email ");
		userName.setFont(f2);
		userName.setBounds(1120,300,400,40);
		userName.setForeground(c4);
		back.add(userName);

		//input textfield for username / Email
		userInput = new JTextField(20);
		userInput.setFont(f3);
		userInput.setBounds(1150,350,500,40);
		userInput.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),2,true));
		back.add(userInput);
		userInput.addFocusListener(this);

		//Password
		passWord = new JLabel("Password");
		passWord.setFont(f2);
		passWord.setForeground(c4);
		passWord.setBounds(1120,425,400,40);
		back.add(passWord);

		//textfield for password
		passInput = new JPasswordField(20);
		passInput.setFont(f3);
		passInput.setBounds(1150,475,500,40);
		passInput.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),2,true));
		back.add(passInput);
		passInput.addFocusListener(this);

	
		signInButton = new JButton("Login");
		signInButton.setFont(f4);
		signInButton.setBounds(1200,570,150,40);
		back.add(signInButton);
		signInButton.setBorder(BorderFactory.createLineBorder(c4,3,true));
		signInButton.setFocusPainted(false);
		signInButton.setBackground(c4);
		signInButton.setForeground(c2);
		signInButton.addActionListener(this);
		signInButton.addMouseListener(this);

		reg = new JLabel("Register Here");
		reg.setFont(new Font("Calibri",Font.BOLD,25));
		reg.setForeground(c4);
		reg.setBounds(1500,570,150,40);
		back.add(reg);
		reg.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me)
			{
				reg.setForeground(new Color(74,71,89));
			}
			public void mouseExited(MouseEvent me)
			{
				reg.setForeground(c4);
			}
			public void mouseClicked(MouseEvent me)
			{
				new register();
				setVisible(false);
			}
		});

		//window Adapter 
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		setVisible(true);
	}

	//focus listener method
	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==userInput)
		{
			userInput.setBackground(new Color(89,89,89));
			userInput.setForeground(c2);
		
		}
		else if(fe.getSource()==passInput)
		{
			passInput.setForeground(c2);
			passInput.setBackground(new Color(89,89,89));

		}
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==userInput)
		{
			userInput.setForeground(new Color(89,89,89));
			userInput.setBackground(c2);
		}
		else if (fe.getSource()==passInput) 
		{
			passInput.setForeground(new Color(89,89,89));
			passInput.setBackground(c2);	
		}
	}
	//actionListener method
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==signInButton)
		{
			int i=0;
			j1 = new JOptionPane();
			String s1 = userInput.getText();
			String s2 = passInput.getText();
			if(s2.length()==0 || s1.length()==0)
			{
				j1.showMessageDialog(null,"Enter Valid Username and Password","For Login",JOptionPane.WARNING_MESSAGE);
			}
			else{
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement sel = conn1.createStatement();
					ResultSet rs = sel.executeQuery("Select * from admin_user where user_name = '"+s1+"' and pass ='"+s2+"'");
					while(rs.next())
					{	
						status = Integer.parseInt(rs.getString(2));
						user = rs.getString(3);
						firm = rs.getString(5);
						signinuser = rs.getString(7);
						i++;
					}
					if(i==1)
					{
						j1.showMessageDialog(null,"Welcome, "+user,"Welcome",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						new home(user,firm,signinuser,status);
					}
					else{
						j1.showMessageDialog(null,"Enter Valid Username or Password","Invalid username or password",JOptionPane.WARNING_MESSAGE);
					}
					conn1.close();
				}	
				catch(Exception e){

				}
			}		
		}
	}
	//Mouse Listener method
	public void mouseEntered(MouseEvent me)
	{
		if (me.getSource()==p1) {
			p1.setBackground(c8);
		}
		else if(me.getSource()==p2){
			p2.setBackground(c8);
		}
		else if(me.getSource()==p3){
			p3.setBackground(c8);
		}
		else if(me.getSource()==p4){
			p4.setBackground(c8);
		}
		else if(me.getSource()==p5){
			p5.setBackground(c8);
		}
		else if(me.getSource()==p6){
			p6.setBackground(c7);
		}
		else if(me.getSource()==p7){
			p7.setBackground(c7);
		}
		else if(me.getSource()==p8){
			p8.setBackground(c7);
		}
		else if(me.getSource()==p9){
			p9.setBackground(c7);
		}
		else if(me.getSource()==p13){
			p13.setBackground(c5);
		}
		else if(me.getSource()==p14){
			p14.setBackground(c5);
		}
		else if(me.getSource()==p15){
			p15.setBackground(c1);
		}
		else if(me.getSource()==p16){
			p16.setBackground(c1);
		}
		else if(me.getSource()==p17){
			p17.setBackground(c5);
		}
		else if(me.getSource()==p18){
			p18.setBackground(c5);
		}
	}

	public void mouseClicked(MouseEvent me)
	{
			
	}
	public void mouseReleased(MouseEvent me)
	{
		
	}
	public void mouseExited(MouseEvent me)
	{
		if (me.getSource()==p1) {
			p1.setBackground(c1);
		}
		else if(me.getSource()==p2){
			p2.setBackground(c1);
		}
		else if(me.getSource()==p3){
			p3.setBackground(c1);
		}
		else if(me.getSource()==p4){
			p4.setBackground(c1);
		}
		else if(me.getSource()==p5){
			p5.setBackground(c1);
		}
		else if(me.getSource()==p6){
			p6.setBackground(c5);
		}
		else if(me.getSource()==p7){
			p7.setBackground(c5);
		}
		else if(me.getSource()==p8){
			p8.setBackground(c5);
		}
		else if(me.getSource()==p9){
			p9.setBackground(c5);
		}
		else if(me.getSource()==p13){
			p13.setBackground(c7);
		}
		else if(me.getSource()==p14){
			p14.setBackground(c7);
		}
		else if(me.getSource()==p15){
			p15.setBackground(c8);
		}
		else if(me.getSource()==p16){
			p16.setBackground(c8);
		}
		else if(me.getSource()==p17){
			p17.setBackground(c7);
		}
		else if(me.getSource()==p18){
			p18.setBackground(c7);
		}
	}
	public void mousePressed(MouseEvent me)
	{

	}
	/*public static void main(String[] args) {
		new login();
	}*/
}