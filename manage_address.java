import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Driver.*;

class manage_address extends JDialog implements ItemListener,ActionListener
{
	JLabel addressLineOne,addressLineTwo,city,state,pincode,uname;
	JTextField addressLineOneInput,addressLineTwoInput,pincodeInput,unameInput;
	JComboBox stateInput,cityInput;
	JButton	edit,save,exit;
	int i=0;
	Font f1 = new Font("Calibri",Font.BOLD,35);
	Font f2 = new Font("Calibri",Font.BOLD,22); 

	String dummy_city,uname_session,add1_1,add2_1,state1_1,pin1;
	Color c1 = new Color(89,89,89);
	Color c2 = new Color(255,255,255);
	manage_address(String add1,String add2,String city1,String state1,String pin,String uname_Session1)
	{
		dummy_city = city1;
		uname_session = uname_Session1;//records user login
		add1_1 = add1;
		add2_1 = add2;
		state1_1 = state1;
		pin1 = pin;
		setSize(800,750);
		setVisible(true);
		setTitle("Manage Address");
		setLayout(null);
		setLocationRelativeTo(null);

		//heading label
		JLabel head = new JLabel("Manage Address");
		head.setBounds(50,30,500,50);
		head.setFont(f1);
		head.setForeground(c1);
		add(head);


		//panel for placing labels and textfield 
		JPanel p1 = new JPanel();
		p1.setBounds(50,100,700,400);
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createLineBorder(c1,5,true));
		add(p1);


		//label for addressLineOne

		addressLineOne = new JLabel("Address Line 1 ");
		addressLineOne.setBounds(50,30,200,40);
		addressLineOne.setForeground(c1);
		addressLineOne.setFont(f2);
		p1.add(addressLineOne);

		//textfield for address line

		addressLineOneInput = new JTextField(20);
		addressLineOneInput.setBounds(250,30,400,40);
		addressLineOneInput.setBackground(c2);
		addressLineOneInput.setFont(f2);
		addressLineOneInput.setEditable(false);
		//addressLineOneInput.addFocusListener(this);
		addressLineOneInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p1.add(addressLineOneInput);

		if(add1==null || add1=="")
		{
			addressLineOneInput.setText("");
			i++;
		}
		else
		{
			addressLineOneInput.setText(""+add1);
		}

		//label for addressLinetwo

		addressLineTwo = new JLabel("Address Line 2 ");
		addressLineTwo.setBounds(50,100,200,40);
		addressLineTwo.setForeground(c1);
		addressLineTwo.setFont(f2);
		p1.add(addressLineTwo);

		//textfield for address line

		addressLineTwoInput = new JTextField(20);
		addressLineTwoInput.setBounds(250,100,400,40);
		addressLineTwoInput.setBackground(c2);
		addressLineTwoInput.setFont(f2);
		addressLineTwoInput.setEditable(false);
		//addressLineTwoInput.addFocusListener(this);
		addressLineTwoInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p1.add(addressLineTwoInput);

		if(add2==null || add2=="")
		{
			addressLineTwoInput.setText("");
			i++;
		}
		else
		{
			addressLineTwoInput.setText(""+add2);
		}

		//label for State

		state = new JLabel("State");
		state.setBounds(50,170,200,40);
		state.setForeground(c1);
		state.setFont(f2);
		p1.add(state);

		stateInput = new JComboBox();
		stateInput.setBounds(250,170,400,40);
		stateInput.setBackground(new Color(255,255,255));
		stateInput.setFont(new Font("Calibri",Font.BOLD,20));
		//stateInput.addFocusListener(this);
		stateInput.setEditable(false);
		stateInput.addItemListener(this);
		p1.add(stateInput);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			
			Statement fetch = conn.createStatement();
			ResultSet rs = fetch.executeQuery("Select * from state order by Name");
			while(rs.next())
			{
				stateInput.addItem(rs.getString(2));
			}
			conn.close();
			if(state1==null || state1=="")
			{
				i++;
			}
			else{
				stateInput.setSelectedItem(""+state1);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}	

		//label for city

		city = new JLabel("City");
		city.setBounds(50,240,200,40);
		city.setForeground(c1);
		city.setFont(f2);
		p1.add(city);


		//combobox for city
		cityInput = new JComboBox();
		cityInput.setBackground(new Color(255,255,255));
		cityInput.setFont(new Font("Calibri",Font.BOLD,20));
		cityInput.setBounds(250,240,400,40);
		cityInput.setEditable(false);
		//cityInput.addFocusListener(this);
		p1.add(cityInput);
		


		//label for pincode

		pincode = new JLabel("Pincode");
		pincode.setBounds(50,310,200,40);
		pincode.setForeground(c1);
		pincode.setFont(f2);
		p1.add(pincode);


		//textfield for pincode input
		pincodeInput = new JTextField(20);
		pincodeInput.setBounds(250,310,400,40);
		pincodeInput.setBackground(c2);
		pincodeInput.setFont(f2);
		pincodeInput.setEditable(false);
		//pincodeInput.addFocusListener(this);
		pincodeInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		p1.add(pincodeInput);

		if(pin==null || pin=="")
		{
			i++;
		}
		else{
			pincodeInput.setText(""+pin);
		}

		//second panel for buttons 

		JPanel p2 = new JPanel();
		p2.setBounds(50,550,700,100);
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createLineBorder(c1,5,true));
		add(p2);



		//add button which makes textfield to editable
		edit = new JButton("Edit");
		edit.setForeground(c2);
		edit.setBackground(c1);
		edit.setFocusPainted(false);
		edit.setFont(f2);
		edit.setBorder(BorderFactory.createLineBorder(c1,2,true));
		edit.setBounds(100,20,100,60);
		edit.addActionListener(this);
		p2.add(edit);


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

	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==stateInput)
		{

			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement sel = conn.createStatement();
				ResultSet rs = sel.executeQuery("Select * from city where state = '"+stateInput.getSelectedItem()+"' order by city asc");
				cityInput.removeAllItems();
				while(rs.next())
				{
					cityInput.addItem(rs.getString(2));
				}
				conn.close();
				if(dummy_city==null || dummy_city=="")
				{
					i++;
				}
				else{
					stateInput.setSelectedItem(""+dummy_city);
				}
			}
			catch(Exception e){

			}
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==edit)
		{
			addressLineOneInput.setEditable(true);
			addressLineTwoInput.setEditable(true);
			//stateInput.setEditable(true);
			//cityInput.setEditable(true);
			pincodeInput.setEditable(true);
		}
		else if(ae.getSource()==save)
		{
			JOptionPane j1 = new JOptionPane();
			String s1,s2,s3,s4,s5,s6;
			s1 = addressLineOneInput.getText();
			s2 = addressLineTwoInput.getText();
			s3 = ""+cityInput.getSelectedItem();
			s4 = ""+stateInput.getSelectedItem();
			s5 = pincodeInput.getText();
			s6 = uname_session;
			if(i>=4)
			{	
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("insert into address(address_line_one,address_line_two,city,state,pincode,user_name)values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
					conn.close();
					j1.showMessageDialog(null,"address inserted successfully","Address Insertion",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e)
				{}
			}
			else{
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("update `ag`.`address` SET `address_line_one`='"+s1+"',`address_line_two`='"+s2+"',`city` = '"+s3+"',`state`='"+s4+"',`pincode`='"+s5+"' where(`user_name` = '"+s6+"')");
					conn.close();
					j1.showMessageDialog(null,"Address updated successfully","Address Updation",JOptionPane.INFORMATION_MESSAGE);
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
		new manage_address("1","","Jalandhar","Punjab","5","6");
	}*/
}