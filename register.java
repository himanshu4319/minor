import java.awt.*;
import javax.swing.*;
import java.sql.Driver.*;
import java.sql.*;
import java.awt.event.*;

class register extends JDialog implements FocusListener,ActionListener
{
	JLabel adminName,firmName,userName,passWord;
	JTextField adminNameInput, firmNameInput, userNameInput;
	JPasswordField passWordInput;
	JButton add,save,exit;

	Font f1 = new Font("Calibri",Font.BOLD,35);
	Font f2 = new Font("Calibri",Font.BOLD,22); 


	Color c1 = new Color(89,89,89);
	Color c2 = new Color(255,255,255);

	//function to check whether a new user is already a user.
	public int checking_user(String uName)
	{
		int i=0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag"
				,"root","Secureit4321@");
			Statement check = conn.createStatement();
			ResultSet rs = check.executeQuery("Select * from admin_user where user_name ='"
				+uName+"'");
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

	register(){
		setSize(800,640);
		setLayout(null);
		setVisible(true);
		setTitle("Register Administrator");
		setLocationRelativeTo(null);

		//heeading label.
		JLabel head = new JLabel("New Administrator");
		head.setBounds(50,30,500,50);
		head.setFont(f1);
		head.setForeground(c1);
		add(head);

		//panel for placing labels and textfield 
		JPanel p1 = new JPanel();
		p1.setBounds(50,100,700,310);
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createLineBorder(c1,5,true));
		add(p1);

		//label for adminName
		adminName = new JLabel("Owner Name");
		adminName.setBounds(50,30,200,40);
		adminName.setForeground(c1);
		adminName.setFont(f2);
		p1.add(adminName);

		//textfield for adminName
		adminNameInput = new JTextField(20);
		adminNameInput.setBounds(250,30,400,40);
		adminNameInput.setBackground(c2);
		adminNameInput.setFont(f2);
		adminNameInput.setEditable(false);
		adminNameInput.addFocusListener(this);
		adminNameInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p1.add(adminNameInput);

		//label for Firm Name
		firmName = new JLabel("Firm Name");
		firmName.setBounds(50,100,200,40);
		firmName.setForeground(c1);
		firmName.setFont(f2);
		p1.add(firmName);

		//textfield for firmName
		firmNameInput = new JTextField(20);
		firmNameInput.setBounds(250,100,400,40);
		firmNameInput.setBackground(c2);
		firmNameInput.setFont(f2);
		firmNameInput.setEditable(false);
		firmNameInput.addFocusListener(this);
		firmNameInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p1.add(firmNameInput);

		//label for username
		userName = new JLabel("Username");
		userName.setBounds(50,170,200,40);
		userName.setForeground(c1);
		userName.setFont(f2);
		p1.add(userName);

		//textfield for username
		userNameInput = new JTextField(20);
		userNameInput.setBounds(250,170,400,40);
		userNameInput.setFont(f2);
		userNameInput.setEditable(false);
		userNameInput.setBackground(c2);
		userNameInput.addFocusListener(this);
		userNameInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p1.add(userNameInput);

		//label for password
		passWord = new JLabel("Password");
		passWord.setBounds(50,240,200,40);
		passWord.setFont(f2);
		passWord.setForeground(c1);
		p1.add(passWord);

		//textfield for password
		passWordInput = new JPasswordField(20);
		passWordInput.setBounds(250,240,400,40);
		passWordInput.setFont(f2);
		passWordInput.setEditable(false);
		passWordInput.addFocusListener(this);
		passWordInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		passWordInput.setBackground(c2);
		p1.add(passWordInput);

		//second panel for buttons 
		JPanel p2 = new JPanel();
		p2.setBounds(50,440,700,100);
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createLineBorder(c1,2,true));
		add(p2);

		//add button which makes textfield to editable
		add = new JButton("Add");
		add.setForeground(c2);
		add.setBackground(c1);
		add.setFocusPainted(false);
		add.setFont(f2);
		add.setBorder(BorderFactory.createLineBorder(c1,2,true));
		add.setBounds(100,20,100,60);
		add.addActionListener(this);
		p2.add(add);

		//Save button which saves the record in database
		save = new JButton("Save");
		save.setForeground(c2);
		save.setBackground(c1);
		save.setFocusPainted(false);
		save.setFont(f2);
		save.addActionListener(this);
		save.setBorder(BorderFactory.createLineBorder(c1,2,true));
		save.setBounds(300,20,100,60);
		p2.add(save);

		//Exit button which shutdown this window
		exit = new JButton("Exit");
		exit.setForeground(c2);
		exit.setFont(f2);
		exit.setFocusPainted(false);
		exit.setBackground(c1);
		exit.setBorder(BorderFactory.createLineBorder(c1,2,true));
		exit.setBounds(500,20,100,60);
		exit.addActionListener(this);
		p2.add(exit);

		//adding window adapter
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
		});
	}	
	//method of focus Listener
	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==adminNameInput)
		{
			adminNameInput.setBackground(c2);
			adminNameInput.setForeground(c1);
		}
		else if(fe.getSource()==userNameInput)
		{
			userNameInput.setBackground(c2);
			userNameInput.setForeground(c1);
		}
		else if(fe.getSource()==passWordInput)
		{
			passWordInput.setBackground(c2);
			passWordInput.setForeground(c1);
		}
		else if(fe.getSource()==firmNameInput)
		{
			firmNameInput.setBackground(c2);
			firmNameInput.setForeground(c1);
		}
	}
	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==adminNameInput)
		{
			adminNameInput.setBackground(c1);
			adminNameInput.setForeground(c2);
		}
		else if(fe.getSource()==userNameInput)
		{
			userNameInput.setBackground(c1);
			userNameInput.setForeground(c2);
		}
		else if(fe.getSource()==passWordInput)
		{
			passWordInput.setBackground(c1);
			passWordInput.setForeground(c2);
		}
		else if(fe.getSource()==firmNameInput)
		{
			firmNameInput.setBackground(c1);
			firmNameInput.setForeground(c2);
		}
	}

	//method of action listener
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			adminNameInput.setEditable(true);
			userNameInput.setEditable(true);
			passWordInput.setEditable(true);
			firmNameInput.setEditable(true);
		}
		else if(ae.getSource()==save)
		{

			int i=0,check_empty_strings;
			String s1,s2,s3,s4;
			s1 = adminNameInput.getText();
			s2 = firmNameInput.getText();
			s3 = userNameInput.getText();
			s4 = passWordInput.getText();

			if(s1.length()!=0 && s2.length()!=0 && s3.length()!=0 && s4.length()!=0)
			{
				//check if user already exists
				i = checking_user(s3);
				JOptionPane j1 = new JOptionPane();
				if(i!=0)
				{
					j1.showMessageDialog(null,"A anothe Administrator with same username already exists. try with a different one","user Already exists",JOptionPane.WARNING_MESSAGE);
				}
				else{
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(
							"Insert into admin_user(administrator,owner_name,user_name,firm_name,pass,login_user) values(1,'"+s1+"','"+s3+"','"+s2+"','"+s4+"','"+s3+"')");
						
						j1.showMessageDialog(null,"Administrator registered successfully","Congratulations",JOptionPane.INFORMATION_MESSAGE);
						conn.close();
						new home(s1,s2,s3,1);
						setVisible(false);
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
			else{
				JOptionPane j1 = new JOptionPane();
				j1.showMessageDialog(null,"please fill all displaying fields","Required fields",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(ae.getSource()==exit)
		{
			setVisible(false);
			new login();
		}
	}
	public static void main(String[] args) {
		new register();
	}
}