import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Driver.*;
import java.sql.*;

class home implements ActionListener
{
	String user_admin,firm_admin,loginid_admin,add1,add2,city,state,pincode;
	String pay1,pay2,pay3,pay4;//for payments page
	String[] clientListValues = new String[50] ;///for sales page
	String[] userListValues = new String[50];
	String[] productListValues = new String[50];
	String[] catListValues = new String[50];
	JButton[] button;
	JLabel F_name,Administrator,user, firstLine, secondLine, thirdLine;
	JMenu m1,m2,m8,m9,m10;
	JButton m3,m4,m5,m6,m7,sale_b,purchase_b,payment_b,Calculator_b;
	JMenuItem mI1,mI2,mI3,mI4,mI5,mI6,mI7,mI8,mI9,mI10,mI11,mI12,mI13 ;
	JList clientList,userList,productList,catList;
	JFrame f1;
	home(String user_ad,String firm,String loginid,int status)
	{
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/minor/icons/icon.png");
		
		
		


		f1 = new JFrame();
		f1.setVisible(true);
		f1.setLayout(null);
		f1.setIconImage(icon);
		f1.setSize(1920,1080);
		f1.setLocationRelativeTo(null);
		f1.setTitle("Aggarwal & Aggarwal's - Home");
		JMenuBar Mb1 = new JMenuBar();
		Mb1.setBackground(new Color(89,89,89));
		//f1.add(img);
		user_admin = user_ad;
		firm_admin = firm;
		loginid_admin = loginid;

		//clientListValues=new String[] {};
		//adding values to clientListValues from database 
		

		// settings of client list for sales, payments and purchase page
		clientList = new JList(clientListValues);
		clientList.setPreferredSize(new Dimension(400,400));
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer) clientList.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		clientList.setBackground(new Color(255,255,255));
		clientList.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		clientList.setForeground(new Color(89,89,89));
		clientList.setFont(new Font("Calibri",Font.BOLD,22));
		clientList.setLayoutOrientation(JList.VERTICAL);
		clientList.setFixedCellWidth(400);
		clientList.setFixedCellHeight(40);
		clientList.setSelectionForeground(new Color(255,255,255));
		clientList.setSelectionBackground(new Color(89,89,89));
		
		//setting of user list for editing and deleting a user.
		userList = new JList(userListValues);
		userList.setPreferredSize(new Dimension(400,400));
		DefaultListCellRenderer renderer1 =  (DefaultListCellRenderer) userList.getCellRenderer();  
		renderer1.setHorizontalAlignment(JLabel.CENTER);
		userList.setBackground(new Color(255,255,255));
		userList.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		userList.setForeground(new Color(89,89,89));
		userList.setFont(new Font("Calibri",Font.BOLD,22));
		userList.setLayoutOrientation(JList.VERTICAL);
		userList.setFixedCellWidth(400);
		userList.setFixedCellHeight(40);
		userList.setSelectionForeground(new Color(255,255,255));
		userList.setSelectionBackground(new Color(89,89,89));

		//setting of product list for editing and deleting a product.
		productList = new JList(productListValues);
		productList.setPreferredSize(new Dimension(400,400));
		DefaultListCellRenderer renderer2 =  (DefaultListCellRenderer) productList.getCellRenderer();  
		renderer2.setHorizontalAlignment(JLabel.CENTER);
		productList.setBackground(new Color(255,255,255));
		productList.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		productList.setForeground(new Color(89,89,89));
		productList.setFont(new Font("Calibri",Font.BOLD,22));
		productList.setLayoutOrientation(JList.VERTICAL);
		productList.setFixedCellWidth(400);
		productList.setFixedCellHeight(40);
		productList.setSelectionForeground(new Color(255,255,255));
		productList.setSelectionBackground(new Color(89,89,89));


		//setting of product list for editing and deleting a product.
		catList = new JList(catListValues);
		catList.setPreferredSize(new Dimension(400,400));
		DefaultListCellRenderer renderer3 =  (DefaultListCellRenderer) catList.getCellRenderer();  
		renderer3.setHorizontalAlignment(JLabel.CENTER);
		catList.setBackground(new Color(255,255,255));
		catList.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		catList.setForeground(new Color(89,89,89));
		catList.setFont(new Font("Calibri",Font.BOLD,22));
		catList.setLayoutOrientation(JList.VERTICAL);
		catList.setFixedCellWidth(400);
		catList.setFixedCellHeight(40);
		catList.setSelectionForeground(new Color(255,255,255));
		catList.setSelectionBackground(new Color(89,89,89));



		//dummy label in order to provide space b/w Menus
		JLabel dummy = new JLabel("                  ");
		JLabel dummy1 = new JLabel("                                  ");
		JLabel dummy2= new JLabel("                                  ");
		JLabel dummy3= new JLabel("                                  ");
		JLabel dummy4= new JLabel("                                  ");
		JLabel dummy5= new JLabel("                                  ");
		JLabel dummy6= new JLabel("                                  ");


		//Menu icons
		JLabel Account_icon = new JLabel(new ImageIcon("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/mini/icons/Accounts_20_20.png"));
		JLabel Admin_icon = new JLabel(new ImageIcon("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/mini/icons/Admin_20_20.png"));

		//Specifying JMenu
		m1 = new JMenu("Master");
		m1.setForeground(new Color(255,255,255));
		m1.setFont(new Font("Calibri",Font.BOLD,18));
		m2 = new JMenu("Accounts");
		m2.setForeground(new Color(255,255,255));
		m2.setFont(new Font("Calibri",Font.BOLD,18));
		m3 = new JButton("Sales",new ImageIcon("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/minor/icons/sales_20_20.png"));
		m3.setBackground(new Color(89,89,89));
		m3.setBorder(null);
		m3.setForeground(new Color(255,255,255));
		m3.setFont(new Font("Calibri",Font.BOLD,18));
		m4 = new JButton("Purchase",new ImageIcon("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/minor/icons/purchase_20_20.png"));
		m4.setForeground(new Color(255,255,255));
		m4.setBackground(new Color(89,89,89));
		m4.setBorder(null);
		m4.setFont(new Font("Calibri",Font.BOLD,18));
		m5 = new JButton("Payments",new ImageIcon("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/minor/icons/cash_20_20.png"));
		m5.setForeground(new Color(255,255,255));
		m5.setFont(new Font("Calibri",Font.BOLD,18));
		m5.setBackground(new Color(89,89,89));
		m5.setBorder(null);
		m7 = new JButton("Calculator",new ImageIcon("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/minor/icons/calci_20_20.png"));
		m7.setForeground(new Color(255,255,255));
		m7.setFont(new Font("Calibri",Font.BOLD,18));	
		m7.setBackground(new Color(89,89,89));
		m7.setBorder(null);
		m6 = new JButton("Exit",new ImageIcon("C:/Users/Himanshu Aggarwal/OneDrive/Desktop/minor/icons/exit_20_20.png"));
		m6.setForeground(new Color(255,255,255));
		m6.setFont(new Font("Calibri",Font.BOLD,18));	
		m6.setBackground(new Color(89,89,89));
		m6.setBorder(null);
		
		m8 = new JMenu("Manage Users");
		m8.setBackground(new Color(89,89,89));
		//m8.setForeground(new Color(255,255,255));
		m8.setFont(new Font("Calibri",Font.BOLD,18));
		m8.setPreferredSize(new Dimension(160,35));
		
		m9 = new JMenu("Manage Categories");
		m9.setBackground(new Color(89,89,89));
		//m9.setForeground(new Color(255,255,255));
		m9.setFont(new Font("Calibri",Font.BOLD,18));
		m9.setPreferredSize(new Dimension(160,35));

		m10 = new JMenu("Manage Products");
		m10.setBackground(new Color(89,89,89));
		//m9.setForeground(new Color(255,255,255));
		m10.setFont(new Font("Calibri",Font.BOLD,18));
		m10.setPreferredSize(new Dimension(160,35));
		

		//Applying Action Listener

		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);
		m6.addActionListener(this);
		m7.addActionListener(this);

		//Specifying JMenuItem
		mI1 = new JMenuItem("New Account");
		mI1.setBackground(new Color(255,255,255));
		mI1.setForeground(new Color(89,89,89));
		mI1.setFont(new Font("Calibri",Font.BOLD,17));
		mI1.addActionListener(this);
		mI1.setBorder(null);
		mI1.setPreferredSize(new Dimension(170,35));

		/*mI2 = new JMenuItem("Account Summary");
		mI2.setForeground(new Color(89,89,89));
		mI2.setBackground(new Color(255,255,255));
		mI2.setFont(new Font("Calibri",Font.BOLD,17));
		mI2.setBorder(null);
		mI2.setPreferredSize(new Dimension(170,35));
		*/
		m2.add(mI1);
		//m2.add(mI2);


		//adding menus in master mennu
		m1.add(m8);
		m1.add(m9);
		m1.add(m10);
		mI3 = new JMenuItem("Add User");
		mI3.setBackground(new Color(255,255,255));
		mI3.setForeground(new Color(89,89,89));
		mI3.setFont(new Font("Calibri",Font.BOLD,17));
		mI3.addActionListener(this);
		mI3.setPreferredSize(new Dimension(170,35));
		m8.add(mI3);
		//m1.add(new JSeparator());

		mI4 = new JMenuItem("Edit User");
		mI4.setBackground(new Color(255,255,255));
		mI4.setForeground(new Color(89,89,89));
		mI4.setFont(new Font("Calibri",Font.BOLD,17));
		mI4.setPreferredSize(new Dimension(170,35));
		mI4.addActionListener(this);
		m8.add(mI4);


		mI8 = new JMenuItem("Delete User");
		mI8.setBackground(new Color(255,255,255));
		mI8.setForeground(new Color(89,89,89));
		mI8.setFont(new Font("Calibri",Font.BOLD,17));
		mI8.setPreferredSize(new Dimension(170,35));
		mI8.addActionListener(this);
		m8.add(mI8);
		
		//adding menuitems in manage categories
		mI11 = new JMenuItem("Add Category");
		mI11.setBackground(new Color(255,255,255));
		mI11.setForeground(new Color(89,89,89));
		mI11.setFont(new Font("Calibri",Font.BOLD,17));
		mI11.setPreferredSize(new Dimension(170,35));
		mI11.addActionListener(this);
		m9.add(mI11);

		mI12 = new JMenuItem("Edit Category");
		mI12.setBackground(new Color(255,255,255));
		mI12.setForeground(new Color(89,89,89));
		mI12.setFont(new Font("Calibri",Font.BOLD,17));
		mI12.setPreferredSize(new Dimension(170,35));
		mI12.addActionListener(this);
		m9.add(mI12);

		mI13 = new JMenuItem("Delete Category");
		mI13.setBackground(new Color(255,255,255));
		mI13.setForeground(new Color(89,89,89));
		mI13.setFont(new Font("Calibri",Font.BOLD,17));
		mI13.setPreferredSize(new Dimension(170,35));
		mI13.addActionListener(this);
		m9.add(mI13);

		//adding menuitem in manage products menu
		mI5 = new JMenuItem("Add Product");
		mI5.setBackground(new Color(255,255,255));
		mI5.setForeground(new Color(89,89,89));
		mI5.setFont(new Font("Calibri",Font.BOLD,17));
		mI5.setPreferredSize(new Dimension(170,35));
		mI5.addActionListener(this);
		m10.add(mI5);

		mI9 = new JMenuItem("Edit Product");
		mI9.setBackground(new Color(255,255,255));
		mI9.setForeground(new Color(89,89,89));
		mI9.setFont(new Font("Calibri",Font.BOLD,17));
		mI9.setPreferredSize(new Dimension(170,35));
		mI9.addActionListener(this);
		m10.add(mI9);

		mI10 = new JMenuItem("Delete Product");
		mI10.setBackground(new Color(255,255,255));
		mI10.setForeground(new Color(89,89,89));
		mI10.setFont(new Font("Calibri",Font.BOLD,17));
		mI10.setPreferredSize(new Dimension(170,35));
		mI10.addActionListener(this);
		m10.add(mI10);

		mI6 = new JMenuItem("Manage Address");
		mI6.setBackground(new Color(255,255,255));
		mI6.setForeground(new Color(89,89,89));
		mI6.setFont(new Font("Calibri",Font.BOLD,17));
		mI6.setPreferredSize(new Dimension(170,35));
		mI6.addActionListener(this);
		m1.add(mI6);

		mI7 = new JMenuItem("Payment Details");
		mI7.setBackground(new Color(255,255,255));
		mI7.setForeground(new Color(89,89,89));
		mI7.setFont(new Font("Calibri",Font.BOLD,17));
		mI7.setPreferredSize(new Dimension(170,35));
		mI7.addActionListener(this);
		m1.add(mI7);
		if(status == 1){
			Mb1.add(dummy);
			Mb1.add(Admin_icon);
			Mb1.add(m1);
		}
		Mb1.add(dummy1);
		Mb1.add(Account_icon);
		Mb1.add(m2);
		Mb1.add(dummy2);
		Mb1.add(m3);
		Mb1.add(dummy3);
		Mb1.add(m4);
		Mb1.add(dummy4);
		Mb1.add(m5);
		Mb1.add(dummy6);
		Mb1.add(m7);
		Mb1.add(dummy5);
		Mb1.add(m6);


		f1.setJMenuBar(Mb1);

		JPanel Admin_block = new JPanel();
		Admin_block.setLayout(null);
		Admin_block.setBackground(new Color(89,89,89));
		Admin_block.setBounds(0,0,600,1080);
		Admin_block.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),5,true));
		f1.add(Admin_block);


		F_name = new JLabel("",JLabel.CENTER);
		F_name.setText(firm);
		F_name.setFont(new Font("Calibri",Font.BOLD,30));
		F_name.setBounds(50,50,500,30);
		F_name.setForeground(new Color(255,255,255));
		Admin_block.add(F_name);

		firstLine = new JLabel("",JLabel.CENTER);
		firstLine.setFont(new Font("Calibri",Font.PLAIN,20));
		firstLine.setForeground(new Color(255,255,255));
		firstLine.setBounds(50,100,500,20);
		Admin_block.add(firstLine);

		secondLine = new JLabel("",JLabel.CENTER);
		secondLine.setFont(new Font("Calibri",Font.PLAIN,20));
		secondLine.setForeground(new Color(255,255,255));
		secondLine.setBounds(50,130,500,20);
		Admin_block.add(secondLine);

		thirdLine = new JLabel("",JLabel.CENTER);
		thirdLine.setFont(new Font("Calibri",Font.PLAIN,20));
		thirdLine.setForeground(new Color(255,255,255));
		thirdLine.setBounds(50,160,500,20);
		Admin_block.add(thirdLine);

		JLabel Admin = new JLabel("Administrator: ",JLabel.CENTER);
		Admin.setFont(new Font("Calibri",Font.BOLD,20));
		Admin.setBounds(50,210,150,30);
		Admin.setForeground(new Color(255,255,255));
		Admin_block.add(Admin);

		Administrator = new JLabel("",JLabel.CENTER);
		Administrator.setFont(new Font("Calibri",Font.PLAIN,20));
		Administrator.setBounds(250,210,250,30);
		Administrator.setForeground(new Color(255,255,255));
		Admin_block.add(Administrator);

		JLabel user1 = new JLabel("Login User : ",JLabel.CENTER);
		user1.setFont(new Font("Calibri",Font.BOLD,20));
		user1.setBounds(50,250,150,30);
		user1.setForeground(new Color(255,255,255));
		Admin_block.add(user1);

		user = new JLabel("",JLabel.CENTER);
		user.setText(user_ad);
		user.setForeground(new Color(255,255,255));
		user.setFont(new Font("Calibri",Font.PLAIN,20));
		user.setBounds(250,250,250,30);
		Admin_block.add(user);

		JPanel adminChildPanel = new JPanel();
		adminChildPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),8,true));
		adminChildPanel.setBounds(50,320,500,450);
		adminChildPanel.setBackground(new Color(89,89,89));
		adminChildPanel.setLayout(null);
		Admin_block.add(adminChildPanel);

		JLabel[] shortSummary = new JLabel[10];
		//for displaying heading
		JLabel[] shortSummary1 = new JLabel[6];
		for(int k=0;k<6;k++)
		{
			shortSummary1[k] = new JLabel("",JLabel.CENTER);
			shortSummary1[k].setFont(new Font("Calibri",Font.PLAIN,20));
			shortSummary1[k].setForeground(new Color(255,255,255));
			adminChildPanel.add(shortSummary1[k]);
		}

		shortSummary1[0].setBounds(50,370,200,30);
		shortSummary1[1].setBounds(50,120,200,30);
		shortSummary1[2].setBounds(50,170,200,30);
		shortSummary1[3].setBounds(50,220,200,30);
		shortSummary1[4].setBounds(50,270,200,30);
		shortSummary1[5].setBounds(50,320,200,30);

		shortSummary1[1].setText("No. of Users:");
		shortSummary1[2].setText("No. of Clients:");
		shortSummary1[3].setText("No. of Categories:");
		shortSummary1[4].setText("No. of Products:");
		shortSummary1[5].setText("No. of Payments:");
		shortSummary1[0].setText("No. of Bills:");

		for(int k=1;k<7;k++)
		{
			shortSummary[k] = new JLabel();
			shortSummary[k].setFont(new Font("Calibri",Font.PLAIN,20));
			shortSummary[k].setForeground(new Color(255,255,255));
			adminChildPanel.add(shortSummary[k]);
		}
		shortSummary[0] = new JLabel("Administrative Details",JLabel.CENTER);
		shortSummary[0].setBounds(50,50,400,30);
		shortSummary[0].setFont(new Font("Calibri",Font.PLAIN,20));
		shortSummary[0].setForeground(new Color(255,255,255));
		adminChildPanel.add(shortSummary[0]);
		

		shortSummary[0].setFont(new Font("Calibri",Font.BOLD,24));
		shortSummary[1].setBounds(300,120,150,30);
		shortSummary[2].setBounds(300,170,150,30);
		shortSummary[3].setBounds(300,220,150,30);
		shortSummary[4].setBounds(300,270,150,30);
		shortSummary[5].setBounds(300,320,150,30);
		shortSummary[6].setBounds(300,370,150,30);
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select admin_user.firm_name ,address.* from admin_user inner join address on address.user_name = admin_user.login_user where login_user = '"+loginid+"'");
			while(rs.next())
			{
				//fromHeading.setText(rs.getString(1));
				firstLine.setText(rs.getString(3));
				secondLine.setText(rs.getString(4));
				thirdLine.setText(""+rs.getString(5)+", "+rs.getString(6)+"-"+rs.getString(7));	
				Administrator.setText(rs.getString(8));		
			}
			rs = stmt.executeQuery("Select count(user_name) from admin_user where login_user = '"+loginid_admin+"' and administrator = '0'");
			while(rs.next())
			{
				shortSummary[1].setText(rs.getString(1));
			}
			rs = stmt.executeQuery("Select count(*) from firm where loginid = '"+loginid_admin+"'");
			while(rs.next())
			{
				shortSummary[2].setText(rs.getString(1));
			}
			rs = stmt.executeQuery("Select count(*) from categories where loginid = '"+loginid_admin+"' ");
			while(rs.next())
			{
				shortSummary[3].setText(rs.getString(1));
			}
			rs = stmt.executeQuery("select count(*) from products where loginid = '"+loginid_admin+"'");
			while(rs.next())
			{
				shortSummary[4].setText(rs.getString(1));
			}
			rs = stmt.executeQuery("select count(*) from payment_entry where loginid = '"+loginid_admin+"'");
			while(rs.next())
			{
				shortSummary[5].setText(rs.getString(1));
			}
			rs = stmt.executeQuery("select count(DISTINCT invoiceNumber) from bills where loginUser = '"+loginid_admin+"'");
			while(rs.next())
			{
				shortSummary[6].setText(rs.getString(1));
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(1000,250,600,480);
		buttonPanel.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),5,true));
		buttonPanel.setLayout(null);
		f1.add(buttonPanel);


		button = new JButton[5];
		for(int k=0;k<5;k++)
		{

			button[k] = new JButton();
			button[k].setFocusPainted(false);
			button[k].setBackground(new Color(89,89,89));
			button[k].setForeground(new Color(255,255,255));
			button[k].setFont(new Font("Calibri",Font.BOLD,23));
			button[k].setBorder(BorderFactory.createLineBorder(new Color(89,89,89),4,true));
			buttonPanel.add(button[k]);
			button[k].addActionListener(this);

			
		}
		button[0].setText("Sales");
		button[0].setBounds(50,50,200,60);

		button[1].setText("Purchase");
		button[1].setBounds(190,130,200,60);

		button[2].setText("Payments");
		button[2].setBounds(330,210,200,60);

		button[3].setText("Calculator");
		button[3].setBounds(190,290,200,60);

		button[4].setText("New Account");
		button[4].setBounds(50,370,200,60);

	}
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==m3 || ae.getSource()==button[0]) //this click sales page
		{
			try{
				int i=0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from firm where loginid = '"+loginid_admin+"'");
				while(rs.next())
				{
					clientListValues[i] =rs.getString(2);
					System.out.print(clientListValues[i]);
					i++;
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			JOptionPane j1 = new JOptionPane();
			int result = j1.showConfirmDialog(null, clientList, "Select Client",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			String str = ""+clientList.getSelectedValue();
			if(result==JOptionPane.YES_OPTION)
			{
				new sales(loginid_admin,str);
			}
			//setVisible(false);
		}

		else if(ae.getSource()==mI1 || ae.getSource()==button[4])
		{
			new new_acc(loginid_admin);
		}
		else if(ae.getSource()==m4 || ae.getSource()==button[1]) // this click purchase page
		{
			try{
				int i=0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from firm where loginid = '"+loginid_admin+"'");
				while(rs.next())
				{
					clientListValues[i] =rs.getString(2);
					System.out.println(clientListValues[i]);
					i++;
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			JOptionPane j1 = new JOptionPane();
			int result = j1.showConfirmDialog(null, clientList, "Select Client",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			String str = ""+clientList.getSelectedValue();
			new purchase(loginid_admin,str);
			//setVisible(false);
		}
		else if(ae.getSource()==m5 || ae.getSource()==button[2])// this click payments page
		{
			
			new payment(loginid_admin);
		}




		else if(ae.getSource()==m6)// this is for exit only.
		{
			System.exit(0);
		}



		else if(ae.getSource()==mI3)//this for adding new user
		{
			new add_user(loginid_admin,firm_admin);
		}

		//action listener for edituser
		else if(ae.getSource()==mI4){
			int result;
			//database connectivity that fetches data 
			try{
				int i=0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from admin_user where login_user = '"+loginid_admin+"' and administrator = '0'");
				while(rs.next())
				{
					userListValues[i] =rs.getString(3);
					i++;
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
						
			JOptionPane j1 = new JOptionPane();
			result=j1.showConfirmDialog(null, userList, "Select User for modification",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			if(result==JOptionPane.YES_OPTION)
			{
				new edit_user(loginid_admin,firm_admin,""+userList.getSelectedValue());
			}	
			//setVisible(false);

		}


		//actionListener for delete a user
		else if(ae.getSource()==mI8)
		{
			try{
				int i=0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from admin_user where login_user = '"+loginid_admin+"' and administrator = '0'");
				while(rs.next())
				{
					userListValues[i] =rs.getString(3);
					System.out.println(userListValues[i]);
					i++;
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			JOptionPane j1 = new JOptionPane();
			int result = j1.showConfirmDialog(null, userList, "Select user for Deletion",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				
			//for deletion query
			if(result == JOptionPane.YES_OPTION){
				try{
					int i=0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("Delete from `ag`.`admin_user` where (`owner_name` = '"+userList.getSelectedValue()+"')");
					JOptionPane.showMessageDialog(null,"User Removed Successfully","Deletion",JOptionPane.INFORMATION_MESSAGE);
					conn.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}	
		}


		else if(ae.getSource()==m7 || ae.getSource()==button[3])// this for calculator
		{
			new calci();
		}
		//\/ manage Address
		else if(ae.getSource()==mI6)
		{
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement fetch = conn.createStatement();
				ResultSet rs = fetch.executeQuery("Select * from address where user_name = '"+loginid_admin+"'");
				while(rs.next())
				{
					add1 = rs.getString(2);
					add2 = rs.getString(3);
					city = rs.getString(4);
					state = rs.getString(5);
					pincode = rs.getString(6);
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			new manage_address(add1,add2,city,state,pincode,loginid_admin);
		}

		//manage payment details
		else if(ae.getSource()==mI7)
		{
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement fetch = conn.createStatement();
				ResultSet rs = fetch.executeQuery("Select * from payment where login = '"+loginid_admin+"'");
				while(rs.next())
				{
					pay1 = rs.getString(2);
					pay2 = rs.getString(3);
					pay3 = rs.getString(4);
					pay4 = rs.getString(5);
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			System.out.println(""+pay1);
			new manage_payments(pay1,pay2,pay3,pay4,loginid_admin);
		}


		//add product menu item
		else if(ae.getSource() == mI5)
		{
			new add_products(loginid_admin);
		}

		//for editing product
		else if(ae.getSource()==mI9)
		{
			String[] split_str = new String[1];
			String str;
			try{
				int i=0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from products where loginid = '"+loginid_admin+"'");
				while(rs.next())
				{
					productListValues[i] =""+rs.getString(2)+" "+rs.getString(3);
					i++;
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
						
			JOptionPane j1 = new JOptionPane();
			int result = j1.showConfirmDialog(null, productList, "Select Product for modification",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			str=""+productList.getSelectedValue();
			split_str = str.split("\\s");

			if(result==JOptionPane.YES_OPTION)
				new edit_product(loginid_admin,split_str[0]);
		}
		//for deleting product
		else if(ae.getSource()==mI10)
		{
			String[] split_str = new String[1];
			String str;
			int result;
			try{
				int i=0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from products where loginid = '"+loginid_admin+"'");
				while(rs.next())
				{
					productListValues[i] =""+rs.getString(2)+" "+rs.getString(3);
					i++;
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
						
			JOptionPane j1 = new JOptionPane();
			result = j1.showConfirmDialog(null, productList, "Select Product for modification",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			if(result==JOptionPane.YES_OPTION)
			{			
				str=""+productList.getSelectedValue();
				split_str = str.split("\\s");
				try{
					int i=0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("Delete from `ag`.`products` where (`proId` = '"+split_str[i]+"')");
					j1.showMessageDialog(null,"Product Deleted Successfully","Congratulations",JOptionPane.INFORMATION_MESSAGE);
					conn.close();
				}
				catch(Exception e)
				{}
			}	
		}

		//for manage categories
		else if(ae.getSource()==mI11)
		{
			new add_cat(loginid_admin);
		}
		else if(ae.getSource()==mI12)
		{
			String[] split_str = new String[1];
			String str;
			int result;
			try{
				int i=0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from categories where loginid = '"+loginid_admin+"'");
				while(rs.next())
				{
					catListValues[i] =""+rs.getString(3)+"  "+rs.getString(2);
					i++;
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
						
			JOptionPane j1 = new JOptionPane();
			result = j1.showConfirmDialog(null, catList, "Select Category for modification",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			if(result == JOptionPane.YES_OPTION)
			{
				str=""+catList.getSelectedValue();
				split_str = str.split("\\s");
				new edit_cat(split_str[0],loginid_admin);
			}
		}
		else if(ae.getSource()==mI13)
		{
			String[] split_str = new String[1];
			String str;
			int result;
			try{
				int i=0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from categories where loginid = '"+loginid_admin+"'");
				while(rs.next())
				{
					catListValues[i] =""+rs.getString(3)+"  "+rs.getString(2);
					i++;
				}
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
						
			JOptionPane j1 = new JOptionPane();
			result = j1.showConfirmDialog(null, catList, "Select Category for Deletion",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			if(result == JOptionPane.YES_OPTION)
			{
				str=""+catList.getSelectedValue();
				split_str = str.split("\\s");
				try{
					int i=0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("Delete from `ag`.`categories` where (`category_code` = '"+split_str[i]+"')");
					j1.showMessageDialog(null,"Category Deleted Successfully","Congratulations",JOptionPane.INFORMATION_MESSAGE);
					conn.close();
				}
				catch(Exception e)
				{}
			}	
		}
		
	}
	/*public static void main(String[] args) {
		new home("himanshu4319","himanshu4319","himanshu4319",1);
	}*/
}