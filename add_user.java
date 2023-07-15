//Add_user
import java.sql.*;
import java.sql.Driver.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class add_user extends JDialog implements FocusListener,ActionListener
{
	JLabel user_S_Name,userName,passWord,firmName,administrator;
	JTextField user_S_Name_Input,userNameInput,firmNameInput,administratorInput;
	JPasswordField passWordInput;
	JButton add,save,exit;
	String adminUser1,firm1;
	JOptionPane j1;

	Color c1 = new Color(89,89,89);
	Color c5 = new Color(242,242,242);//white

	public int checking_user(String uName)
	{
		int i=0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement check = conn.createStatement();
			ResultSet rs = check.executeQuery("Select * from admin_user where user_name = '"+uName+"'");
			while(rs.next())
				i++;
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	add_user( String adminUser, String firm)
	{

		//setting visibillity,size,layout,title and positioning of dialog box.
		setVisible(true);
		setSize(800,900);
		setLayout(null);
		setTitle("Add user");
		setLocationRelativeTo(null);
		//setBorder(BorderFactory.createLineBorder(c2,5,true));

		adminUser1 = adminUser;
		firm1 = firm;

		JPanel p1 = new JPanel();
		p1.setBackground(c5);
		p1.setLayout(null);
		p1.setBounds(0,0,800,900);
		add(p1);

		JLabel head = new JLabel("Add user");
		head.setForeground(c1);
		head.setFont(new Font("Calibri",Font.BOLD,35));
		head.setBounds(30,20,400,40);
		p1.add(head);


		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createLineBorder(c1,5,true));
		p2.setBackground(c5);
		p2.setBounds(50,100,700,520);
		p2.setLayout(null);
		p1.add(p2);

		//LAbel for user's name
		user_S_Name = new JLabel("Name");
		user_S_Name.setBounds(40,25,150,30);
		user_S_Name.setForeground(c1);
		user_S_Name.setFont(new Font("Calibri",Font.BOLD,22));
		p2.add(user_S_Name);

		//textfield for user's input field
		user_S_Name_Input = new JTextField(15);
		user_S_Name_Input.setBounds(80,60,540,40);
		user_S_Name_Input.setEditable(false);
		user_S_Name_Input.setFont(new Font("Calibri",Font.BOLD,22));
		user_S_Name_Input.setBorder(BorderFactory.createLineBorder(c1,2,true));
		user_S_Name_Input.addFocusListener(this);
		p2.add(user_S_Name_Input);

		//label for user name
		userName = new JLabel("Username");
		userName.setBounds(40,115,150,30);
		userName.setForeground(c1);
		userName.setFont(new Font("Calibri",Font.BOLD,22));
		p2.add(userName);

		//textfield for username input
		userNameInput = new JTextField(15);
		userNameInput.setEditable(false);
		userNameInput.addFocusListener(this);
		userNameInput.setBounds(80,150,540,40);
		userNameInput.setFont(new Font("Calibri",Font.BOLD,22));
		userNameInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p2.add(userNameInput);

		//label for password
		passWord = new JLabel("Password");
		passWord.setBounds(40,205,150,30);
		passWord.setForeground(c1);
		passWord.setFont(new Font("Calibri",Font.BOLD,22));
		p2.add(passWord);

		//password field
		passWordInput = new JPasswordField(15);
		passWordInput.addFocusListener(this);
		passWordInput.setEditable(false);
		passWordInput.setBounds(80,240,540,40);
		passWordInput.setFont(new Font("Calibri",Font.BOLD,22));
		passWordInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p2.add(passWordInput);

		//label for administrator
		administrator = new JLabel("Administrator");
		administrator.setBounds(40,295,150,30);
		administrator.setForeground(c1);
		administrator.setFont(new Font("Calibri",Font.BOLD,22));
		p2.add(administrator); 

		//textfield for administrator
		administratorInput = new JTextField(15);
		administratorInput.setEditable(false);
		administratorInput.addFocusListener(this);
		administratorInput.setText(adminUser);
		administratorInput.setBounds(80,330,540,40);
		administratorInput.setFont(new Font("Calibri",Font.BOLD,22));
		administratorInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p2.add(administratorInput);

		//label for firmname
		firmName = new JLabel("Firm Name");
		firmName.setBounds(40,385,150,30);
		firmName.setForeground(c1);
		firmName.setFont(new Font("Calibri",Font.BOLD,22));
		p2.add(firmName); 

		//textfield for firmnameinput
		firmNameInput = new JTextField(15);
		firmNameInput.setEditable(false);
		firmNameInput.setText(firm);
		firmNameInput.setBounds(80,420,540,40);
		firmNameInput.setFont(new Font("Calibri",Font.BOLD,22));
		firmNameInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p2.add(firmNameInput);


		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createLineBorder(c1,5,true));
		p3.setBounds(50,650,700,100);
		p1.add(p3);

		add = new JButton("Add");
		add.setBounds(100,20,100,60);
		add.setFocusPainted(false);
		add.setFont(new Font("Calibri",Font.BOLD,20));
		add.setBorder(BorderFactory.createLineBorder(c1,3,true));
		add.setForeground(c5);
		add.addActionListener(this);
		add.setBackground(c1);
		p3.add(add);

		save = new JButton("Save");
		save.setBounds(300,20,100,60);
		save.setFocusPainted(false);
		save.setFont(new Font("Calibri",Font.BOLD,20));
		save.setBorder(BorderFactory.createLineBorder(c1,3,true));
		save.setForeground(c5);
		save.addActionListener(this);
		save.setBackground(c1);
		p3.add(save);

		exit = new JButton("Exit");
		exit.setBounds(500,20,100,60);
		exit.setFocusPainted(false);
		exit.addActionListener(this);
		exit.setFont(new Font("Calibri",Font.BOLD,20));
		exit.setBorder(BorderFactory.createLineBorder(c1,3,true));
		exit.setForeground(c5);
		exit.setBackground(c1);
		p3.add(exit);
	}

	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==user_S_Name_Input)
		{
			user_S_Name_Input.setBackground(c5);
			user_S_Name_Input.setForeground(c1);
		}
		else if(fe.getSource()==userNameInput)
		{
			userNameInput.setBackground(c5);
			userNameInput.setForeground(c1);
		}
		else if(fe.getSource()==passWordInput)
		{
			passWordInput.setForeground(c1);
			passWordInput.setBackground(c5);
		}
	}
	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==user_S_Name_Input)
		{
			user_S_Name_Input.setBackground(c1);
			user_S_Name_Input.setForeground(c5);
		}
		else if(fe.getSource()==userNameInput)
		{
			userNameInput.setBackground(c1);
			userNameInput.setForeground(c5);
		}
		else if(fe.getSource()==passWordInput)
		{
			passWordInput.setForeground(c5);
			passWordInput.setBackground(c1);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			user_S_Name_Input.setEditable(true);
			userNameInput.setEditable(true);
			passWordInput.setEditable(true);
		}
		else if(ae.getSource()==save)
		{
			String s1,s2,s3;
			s1=user_S_Name_Input.getText();
			s2=userNameInput.getText();
			s3=passWordInput.getText();
			int i = checking_user(s2);
			if(i!=0)
			{
				j1.showMessageDialog(null,"User with same username already exists","Warning",JOptionPane.WARNING_MESSAGE);
			}
			else
			{	try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement ins = conn.createStatement();
					ins.executeUpdate("insert into admin_user(owner_name,administrator,user_name,firm_name,pass,login_user)values('"+s1+"',0,'"+s2+"','"+firm1+"','"+s3+"','"+adminUser1+"')");
					conn.close();
					j1.showMessageDialog(null,"User added successfully","Congratulations",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e)
				{}
			}	
		}
		else if(ae.getSource()==exit)
		{
			setVisible(false);
		}
	}
	/*public static void main(String[] args) {
		new add_user("himanshu","Aggarwal");
	}*/
}
