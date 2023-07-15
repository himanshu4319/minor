//new Account
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Driver.*;
public class new_acc extends JDialog implements FocusListener,ActionListener,ItemListener
{
	JOptionPane j1;
	JLabel F_name ,Fn_name,O_contact, F_Address , Firm_State , Firm_City , Firm_pincode , F_contact , firm_City,F_o_name  ;
	JTextField F_name_input ,Fn_name_input, F_contact_input ,Firm_pincode_input ,O_contact_no ,F_o_name_input,F_Address_input,F_Address_input1;
	JButton Save,jAdd,exit;
	String loginid;
	JComboBox c1,c2,c3,F_city,F_state;
	String []code = {"+1","+91","+57","+2","+89","51","+67"};
	String []initials = {"Mr.","Mrs.","Miss"};
	new_acc( String loginid1)
	{
		loginid = loginid1;
		setTitle("New Account");
		setSize(900,1000);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);

		JLabel head = new JLabel("Firm Creation",JLabel.CENTER);
		head.setBounds(0,20,400,40);
		head.setForeground(new Color(89,89,89));
		head.setFont(new Font("Calibri",Font.BOLD,35));
		add(head);
		add(new JSeparator());

		JPanel j1 = new JPanel();
		j1.setBounds(50,80,800,680);
		j1.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),5,true));
		j1.setLayout(null);
		add(j1);


		//firm details 
		F_name = new JLabel("M/S");
		F_name.setBounds(50,30,200,40);
		F_name.setForeground(new Color(89,89,89));
		F_name.setFont(new Font("Calibri",Font.BOLD,20));
		j1.add(F_name);

		F_name_input = new JTextField(20);
		F_name_input.setBounds(300,30,450,40);
		F_name_input.setMargin(new Insets(0,20,0,10));	
		F_name_input.setBackground(new Color(255,255,255));	
		F_name_input.setFont(new Font("Calibri",Font.BOLD,20));
		F_name_input.setEditable(false);
		F_name_input.addFocusListener(this);
		j1.add(F_name_input);


		// firm nick details
		Fn_name = new JLabel("Firm Nick Name ");
		Fn_name.setBounds(50,90,200,40);
		Fn_name.setForeground(new Color(89,89,89));
		Fn_name.setFont(new Font("Calibri",Font.BOLD,20));
		j1.add(Fn_name);

		Fn_name_input = new JTextField(20);
		Fn_name_input.setBounds(300,90,450,40);
		Fn_name_input.setMargin(new Insets(0,20,0,10));
		Fn_name_input.setFont(new Font("Calibri",Font.BOLD,20));
		Fn_name_input.setEditable(false);
		Fn_name_input.addFocusListener(this);
		Fn_name_input.setBackground(new Color(255,255,255));
		j1.add(Fn_name_input);


		//firm Contact number

		F_contact = new JLabel("Contact number ");
		F_contact.setBounds(50,150,200,40);
		F_contact.setForeground(new Color(89,89,89));
		F_contact.setFont(new Font("Calibri",Font.BOLD,20));
		j1.add(F_contact);

		c2 = new JComboBox(code);
		c2.setBounds(300,150,70,40);
		c2.setFont(new Font("Calibri",Font.BOLD,20));
		c2.setBackground(new Color(255,255,255));
		c2.addFocusListener(this);
		j1.add(c2);

		F_contact_input = new JTextField(20);
		F_contact_input.setBackground(new Color(255,255,255));
		F_contact_input.setBounds(380,150,370,40);
		F_contact_input.setMargin(new Insets(0,20,0,10));
		F_contact_input.setEditable(false);
		F_contact_input.setFont(new Font("Calibri",Font.BOLD,20));
		F_contact_input.addFocusListener(this);
		j1.add(F_contact_input);

		//owner name


		F_o_name = new JLabel("Owner Name ");
		F_o_name.setBounds(50,210,200,40);
		F_o_name.setForeground(new Color(89,89,89));
		F_o_name.setFont(new Font("Calibri",Font.BOLD,20));
		j1.add(F_o_name);

		c1 = new JComboBox(initials);
		c1.setBounds(300,210,70,40);
		c1.setFont(new Font("Calibri",Font.BOLD,20));
		c1.setBackground(new Color(255,255,255));
		c1.addFocusListener(this);
		j1.add(c1);


		F_o_name_input = new JTextField(20);
		F_o_name_input.setBackground(new Color(255,255,255));
		F_o_name_input.setEditable(false);
		F_o_name_input.setBounds(380,210,370,40);
		F_o_name_input.setMargin(new Insets(0,20,0,10));
		F_o_name_input.setFont(new Font("Calibri",Font.BOLD,20));
		F_o_name_input.addFocusListener(this);
		j1.add(F_o_name_input);

		//owner contact number

		O_contact = new JLabel("Owner Contact no. ");
		O_contact.setBounds(50,270,200,40);
		O_contact.setForeground(new Color(89,89,89));
		O_contact.setFont(new Font("Calibri",Font.BOLD,20));
		j1.add(O_contact);

		c3 = new JComboBox(code);
		c3.setBounds(300,270,70,40);
		c3.setFont(new Font("Calibri",Font.BOLD,20));
		c3.setBackground(new Color(255,255,255));
		c3.addFocusListener(this);
		j1.add(c3);

		O_contact_no = new JTextField(20);
		O_contact_no.setBounds(380,270,370,40);
		O_contact_no.setBackground(new Color(255,255,255));
		O_contact_no.setMargin(new Insets(0,20,0,10));		
		O_contact_no.setEditable(false);
		O_contact_no.setFont(new Font("Calibri",Font.BOLD,20));
		O_contact_no.addFocusListener(this);
		j1.add(O_contact_no);


		JPanel p2 = new JPanel();
		p2.setBounds(300,330,450,320);
		p2.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		p2.setLayout(null);
		j1.add(p2);

		// Firm Address Details.
		F_Address = new JLabel("Firm Address ");
		F_Address.setBounds(50,370,200,40);
		F_Address.setForeground(new Color(89,89,89));
		F_Address.setFont(new Font("Calibri",Font.BOLD,20));
		j1.add(F_Address);



		F_Address_input = new JTextField(20);
		F_Address_input.setEditable(false);
		F_Address_input.setBackground(new Color(255,255,255));
		F_Address_input.setBounds(20,20,410,40);
		F_Address_input.setMargin(new Insets(0,20,0,10));	
		F_Address_input.addFocusListener(this);
		F_Address_input.setFont(new Font("Calibri",Font.BOLD,20));
		p2.add(F_Address_input);

		F_Address_input1 = new JTextField(20);
		F_Address_input1.setBackground(new Color(255,255,255));
		F_Address_input1.setBounds(20,80,410,40);
		F_Address_input1.setEditable(false);
		F_Address_input1.addFocusListener(this);
		F_Address_input1.setMargin(new Insets(0,20,0,10));	
		F_Address_input1.setFont(new Font("Calibri",Font.BOLD,20));
		p2.add(F_Address_input1);


		Firm_State = new JLabel("State");
		Firm_State.setBounds(60,140,80,40);
		Firm_State.setForeground(new Color(89,89,89));
		Firm_State.setFont(new Font("Calibri",Font.BOLD,20));
		p2.add(Firm_State);

		F_state = new JComboBox();
		F_state.setBounds(160,140,270,40);
		F_state.setBackground(new Color(255,255,255));
		F_state.setFont(new Font("Calibri",Font.BOLD,20));
		F_state.addFocusListener(this);
		F_state.setEditable(false);
		F_state.addItemListener(this);
		p2.add(F_state);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			
			Statement fetch = conn.createStatement();
			ResultSet rs = fetch.executeQuery("Select * from state order by Name");
			while(rs.next())
			{
				F_state.addItem(rs.getString(2));
			}
			conn.close();

		}
		catch(Exception e){
			System.out.println(e);
		}

		// city TextField
		Firm_City = new JLabel("City");
		Firm_City.setBounds(60,260,80,40);
		Firm_City.setForeground(new Color(89,89,89));
		Firm_City.setFont(new Font("Calibri",Font.BOLD,20));
		p2.add(Firm_City);

		F_city = new JComboBox();
		F_city.setBackground(new Color(255,255,255));
		F_city.setFont(new Font("Calibri",Font.BOLD,20));
		F_city.setBounds(160,260,270,40);
		F_city.setEditable(false);
		F_city.addFocusListener(this);
		p2.add(F_city);


		Firm_pincode = new JLabel("Pincode ");
		Firm_pincode.setBounds(60,200,80,40);
		Firm_pincode.setForeground(new Color(89,89,89));
		Firm_pincode.setFont(new Font("Calibri",Font.BOLD,20));
		p2.add(Firm_pincode);

		Firm_pincode_input = new JTextField(20);
		Firm_pincode_input.setBackground(new Color(255,255,255));
		Firm_pincode_input.setBounds(160,200,270,40);
		Firm_pincode_input.setMargin(new Insets(0,20,0,10));
		Firm_pincode_input.setFont(new Font("Calibri",Font.BOLD,20));
		Firm_pincode_input.addFocusListener(this);
		Firm_pincode_input.setEditable(false);
		p2.add(Firm_pincode_input);
		

		JPanel p3 = new JPanel();
		p3.setBounds(50,800,800,100);
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),5,true));
		add(p3);


		jAdd = new JButton("Add");
		jAdd.setBounds(100,20,120,60);
		jAdd.setForeground(new Color(255,255,255));
		jAdd.setFocusPainted(false);
		jAdd.setBackground(new Color(89,89,89));
		jAdd.setFont(new Font("Calibri",Font.BOLD,30));
		jAdd.addActionListener(this);
		jAdd.setBorder(BorderFactory.createLineBorder(new Color(115,115,115)));
		p3.add(jAdd);

		Save = new JButton("Save");
		Save.setBounds(340,20,120,60);
		Save.setFocusPainted(false);
		Save.setForeground(new Color(255,255,255));
		Save.setBackground(new Color(89,89,89));
		Save.setFont(new Font("Calibri",Font.BOLD,30));
		Save.addActionListener(this);
		Save.setBorder(BorderFactory.createLineBorder(new Color(115,115,115)));
		p3.add(Save);

		exit = new JButton("Exit");
		exit.setFocusPainted(false);
		exit.setBounds(580,20,120,60);
		exit.setForeground(new Color(255,255,255));
		exit.setBackground(new Color(89,89,89));
		exit.addActionListener(this);
		exit.setFont(new Font("Calibri",Font.BOLD,30));
		exit.setBorder(BorderFactory.createLineBorder(new Color(115,115,115)));
		p3.add(exit);

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
		});

	} 
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jAdd)
		{
			F_name_input.setEditable(true);
			Fn_name_input.setEditable(true);
			F_contact_input.setEditable(true);
			F_o_name_input.setEditable(true);
			O_contact_no.setEditable(true);
			F_Address_input.setEditable(true);
			F_Address_input1.setEditable(true);
			//F_city.setEditable(true);
			//F_state.setEditable(true);
			Firm_pincode_input.setEditable(true);
		}
		else if(ae.getSource()==exit)
		{
			setVisible(false);
		}
		else if(ae.getSource()==Save)
		{
			String s1,s2,s3,s4,s5,s6,s7,s8,s9;
			s1 = F_name_input.getText();
			s2 = Fn_name_input.getText();
			s3 = ""+c2.getSelectedItem()+" "+F_contact_input.getText();
			s4 = ""+c1.getSelectedItem()+" "+F_o_name_input.getText();
			s5 = ""+c3.getSelectedItem()+" "+O_contact_no.getText();
			s6 = ""+F_Address_input.getText()+", "+F_Address_input1.getText();
			s7 = ""+F_state.getSelectedItem();
			s8 = ""+F_city.getSelectedItem();
			s9 = Firm_pincode_input.getText();

			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");			
				Statement fetch = conn.createStatement();

				fetch.executeUpdate("insert into firm(M_S,firm_nickname,firm_contact,owner_name,owner_contact,firm_address,State,city,pincode,loginid)values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+loginid+"')");
				j1.showMessageDialog(null,"Firm added successfully","Congrats",JOptionPane.INFORMATION_MESSAGE);
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==F_state)
		{

			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement sel = conn.createStatement();
				ResultSet rs = sel.executeQuery("Select * from city where state = '"+F_state.getSelectedItem()+"' order by city asc");
				F_city.removeAllItems();
				while(rs.next())
				{
					F_city.addItem(rs.getString(2));
				}
				conn.close();
			}
			catch(Exception e){

			}
		}
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==F_name_input)
		{
			F_name_input.setBackground(new Color(255,255,255));
			F_name_input.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==Fn_name_input)
		{
			Fn_name_input.setBackground(new Color(255,255,255));
			Fn_name_input.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==F_contact_input)
		{
			F_contact_input.setBackground(new Color(255,255,255));
			F_contact_input.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==F_o_name_input)
		{
			F_o_name_input.setBackground(new Color(255,255,255));
			F_o_name_input.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==O_contact_no)
		{
			O_contact_no.setBackground(new Color(255,255,255));
			O_contact_no.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==F_Address_input)
		{
			F_Address_input.setBackground(new Color(255,255,255));
			F_Address_input.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==F_Address_input1)
		{
			F_Address_input1.setBackground(new Color(255,255,255));
			F_Address_input1.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==F_city)
		{
			F_city.setBackground(new Color(255,255,255));
			F_city.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==F_state)
		{
			F_state.setBackground(new Color(255,255,255));
			F_state.setForeground(new Color(89,89,89));
		}
		else if(fe.getSource()==Firm_pincode_input)
		{
			Firm_pincode_input.setBackground(new Color(255,255,255));
			Firm_pincode_input.setForeground(new Color(89,89,89));
		}
	}
	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==F_name_input)
		{
			F_name_input.setBackground(new Color(89,89,89));
			F_name_input.setForeground(new Color(255,255,255));
		}
		if(fe.getSource()==Fn_name_input)
		{
			Fn_name_input.setBackground(new Color(89,89,89));
			Fn_name_input.setForeground(new Color(255,255,255));
		}
		else if(fe.getSource()==F_contact_input)
		{
			F_contact_input.setBackground(new Color(89,89,89));
			F_contact_input.setForeground(new Color(255,255,255));
		}
		else if(fe.getSource()==F_o_name_input)
		{
			F_o_name_input.setBackground(new Color(89,89,89));
			F_o_name_input.setForeground(new Color(255,255,255));
		}
		else if(fe.getSource()==O_contact_no)
		{
			O_contact_no.setBackground(new Color(89,89,89));
			O_contact_no.setForeground(new Color(255,255,255));
		}
		else if(fe.getSource()==F_Address_input)
		{
			F_Address_input.setBackground(new Color(89,89,89));
			F_Address_input.setForeground(new Color(255,255,255));
		}
		else if(fe.getSource()==F_Address_input1)
		{
			F_Address_input1.setBackground(new Color(89,89,89));
			F_Address_input1.setForeground(new Color(255,255,255));
		}
		else if(fe.getSource()==F_city)
		{
			F_city.setBackground(new Color(89,89,89));
			F_city.setForeground(new Color(255,255,255));
		}
		else if(fe.getSource()==F_state)
		{
			F_state.setBackground(new Color(89,89,89));
			F_state.setForeground(new Color(255,255,255));
		}
		else if(fe.getSource()==Firm_pincode_input)
		{
			Firm_pincode_input.setBackground(new Color(89,89,89));
			Firm_pincode_input.setForeground(new Color(255,255,255));
		}
	}
	/*public static void main(String[] args) {
		new new_acc();
	}*/
}