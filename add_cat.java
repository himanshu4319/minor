import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Driver.*;

class add_cat extends JDialog implements ActionListener, FocusListener
{
	JLabel categoryCode,categoryName;
	JTextField categoryCodeInput,categoryNameInput;

	Font f1=new Font("Calibri",Font.BOLD,22);
	Color c1=new Color(89,89,89);
	String loginid;
	JButton add,save,exit;

	public int checking_cat(String cat,String session)
	{
		int i=0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from categories where category_code = '"+cat+"' and loginid = '"+session+"'");
			while(rs.next()){
				i++;
			}
			conn.close();
		}
		catch(Exception e)
		{

		}
		return i;
	}
	add_cat( String loginid1)
	{

		loginid = loginid1;
		setTitle("Add Category");	
		setSize(800,600);
		setLayout(null);
		
		setLocationRelativeTo(null);

		JLabel head=new JLabel("Add Category");
		head.setFont(new Font("Calibri",Font.BOLD,30));
		head.setForeground(c1);
		head.setBounds(80,20,400,30);
		add(head);


		JPanel p1=new JPanel();
		p1.setBounds(50,70,700,250);
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createLineBorder(c1,3,true));
		add(p1);

		categoryCode = new JLabel("Category Code");
		categoryCode.setFont(f1);
		categoryCode.setBounds(50,50,200,50);
		categoryCode.setForeground(c1);
		p1.add(categoryCode);

		categoryCodeInput = new JTextField(20);
		categoryCodeInput.setBounds(300,50,350,50);
		categoryCodeInput.setBorder(BorderFactory.createLineBorder(c1,3,true));
		categoryCodeInput.setFont(f1);
		categoryCodeInput.setEditable(false);
		categoryCodeInput.setForeground(c1);
		categoryCodeInput.addFocusListener(this);
		categoryCodeInput.setBackground(new Color(255,255,255));
		p1.add(categoryCodeInput);


		categoryName = new JLabel("Category Name");
		categoryName.setFont(f1);
		categoryName.setBounds(50,150,200,50);
		categoryName.setForeground(c1);
		p1.add(categoryName);

		categoryNameInput = new JTextField(20);
		categoryNameInput.setBounds(300,150,350,50);
		categoryNameInput.setBorder(BorderFactory.createLineBorder(c1,3,true));
		categoryNameInput.setFont(f1);
		categoryNameInput.setForeground(c1);
		categoryNameInput.addFocusListener(this);
		categoryNameInput.setBackground(new Color(255,255,255));
		categoryNameInput.setEditable(false);
		p1.add(categoryNameInput);



		JPanel p2 = new JPanel();
		p2.setBounds(50,370,700,100);
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createLineBorder(c1,3,true));
		add(p2);


		add = new JButton("Add");
		add.setBounds(100,20,100,60);
		add.setFocusPainted(false);
		add.setFont(new Font("Calibri",Font.BOLD,20));
		add.setBorder(BorderFactory.createLineBorder(c1,3,true));
		add.setForeground(new Color(255,255,255));
		add.addActionListener(this);
		add.setBackground(c1);
		p2.add(add);

		save = new JButton("Save");
		save.setBounds(300,20,100,60);
		save.setFocusPainted(false);
		save.setFont(new Font("Calibri",Font.BOLD,20));
		save.setBorder(BorderFactory.createLineBorder(c1,3,true));
		save.setForeground(new Color(255,255,255));
		save.addActionListener(this);
		save.setBackground(c1);
		p2.add(save);

		exit = new JButton("Exit");
		exit.setBounds(500,20,100,60);
		exit.setFocusPainted(false);
		exit.addActionListener(this);
		exit.setFont(new Font("Calibri",Font.BOLD,20));
		exit.setBorder(BorderFactory.createLineBorder(c1,3,true));
		exit.setForeground(new Color(255,255,255));
		exit.setBackground(c1);
		p2.add(exit);



		setVisible(true);
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==categoryNameInput)
		{
			categoryNameInput.setForeground(c1);
			categoryNameInput.setBackground(new Color(255,255,255));
		}
		else if(fe.getSource()==categoryCodeInput)
		{
			categoryCodeInput.setForeground(c1);
			categoryCodeInput.setBackground(new Color(255,255,255));
		}
	}
	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==categoryNameInput)
		{
			categoryNameInput.setForeground(new Color(255,255,255));
			categoryNameInput.setBackground(c1);
		}
		else if(fe.getSource()==categoryCodeInput)
		{
			categoryCodeInput.setForeground(new Color(255,255,255));
			categoryCodeInput.setBackground(c1);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			categoryCodeInput.setEditable(true);
			categoryNameInput.setEditable(true);
		}

		if(ae.getSource()==save)
		{
			String s1,s2;
			int j;
			s1="CAT"+categoryCodeInput.getText();
			s2 = categoryNameInput.getText();
			j=checking_cat(s1,loginid);
			if(s1.length()!=0 && s2.length()!=0)
			{
				if(j!=0)
					JOptionPane.showMessageDialog(null,"Category already exists","Error",JOptionPane.INFORMATION_MESSAGE);
				else{
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("Insert into categories(category_name,category_code,loginid) values('"+s2+"','"+s1+"','"+loginid+"')");
						JOptionPane.showMessageDialog(null,"Category Added Successfully...","Congratulations",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		}	
		if(ae.getSource()==exit)
		{
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new add_cat("himanshu4319");
	}
}