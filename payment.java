import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Driver.*;
import java.util.Date;
import java.text.SimpleDateFormat; 
import javax.swing.table.AbstractTableModel;
class payment extends JFrame implements FocusListener,ActionListener
{
	JLabel date,account,paymentDesc,paymentAmount,paymentType;
	JTextField dateInput,paymentAmountInput;
	JTextArea paymentDescInput;
	JComboBox accountInput,paymentTypeInput;
	JLabel[] lastEntry;
	JButton add, save, exit;
	Font f1 = new Font("Calibri",Font.BOLD,22); 
	String login_session;
	Float D1;
	payment(String loginid)
	{
		login_session = loginid;
		setSize(1600,800);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Payments");

		JLabel head = new JLabel("Payments");
		head.setBounds(40,40,200,30);
		head.setForeground(new Color(89,89,89));
		head.setFont(new Font("Calibri",Font.BOLD,30));
		add(head);

		JPanel p1 = new JPanel();
		p1.setBounds(40,100,1520,400);
		p1.setLayout(null);
		//p1.setBackground(new Color(89,89,89));
		p1.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),5,true));
		add(p1);

		//dateField
		date = new JLabel("Transaction Date: ",JLabel.CENTER);
		date.setBounds(40,40,200,30);
		date.setForeground(new Color(89,89,89));
		date.setFont(f1);
		p1.add(date);

		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");  
	    Date date1 = new Date();

	    dateInput = new JTextField(20);
	    dateInput.setFont(f1);
		dateInput.setForeground(new Color(89,89,89));
		dateInput.setBounds(40,80,200,50);
		dateInput.addFocusListener(this);
		dateInput.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		dateInput.setEditable(false);
		p1.add(dateInput);
		dateInput.setText(formatter.format(date1));  

		//Client account 

		account = new JLabel("Account: ",JLabel.CENTER);
		account.setBounds(280,40,250,30);
		account.setForeground(new Color(89,89,89));
		account.setFont(f1);
		p1.add(account);
		

		accountInput = new JComboBox();
		accountInput.addFocusListener(this);
		accountInput.setForeground(new Color(89,89,89));
		accountInput.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		accountInput.setBackground(new Color(255,255,255));
		accountInput.setFont(new Font("Calibri",Font.BOLD,20));
		accountInput.setBounds(280,80,250,50);
		p1.add(accountInput);

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			
			Statement fetch = conn.createStatement();
			ResultSet rs = fetch.executeQuery("Select * from firm where loginid = '"+loginid+"' order by M_S");
			while(rs.next())
			{
				accountInput.addItem(rs.getString(2));
			}
			conn.close();

		}
		catch(Exception e){
			System.out.println(e);
		}

		//payment description

		paymentDesc = new JLabel("Description ",JLabel.CENTER);
		paymentDesc.setBounds(570,40,350,30);
		paymentDesc.setForeground(new Color(89,89,89));
		paymentDesc.setFont(f1);
		p1.add(paymentDesc);

		paymentDescInput = new JTextArea();
		paymentDescInput.setEditable(false);
		paymentDescInput.setForeground(new Color(89,89,89));
		paymentDescInput.addFocusListener(this);
		paymentDescInput.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		paymentDescInput.setBackground(new Color(255,255,255));
		paymentDescInput.setFont(new Font("Calibri",Font.BOLD,20));
		paymentDescInput.setBounds(570,80,350,100);
		p1.add(paymentDescInput);		

		//payment amount

		paymentAmount = new JLabel("Amount",JLabel.CENTER);
		paymentAmount.setBounds(960,40,250,30);
		paymentAmount.setForeground(new Color(89,89,89));
		paymentAmount.setFont(f1);
		p1.add(paymentAmount);


		paymentAmountInput = new JTextField(20);
		paymentAmountInput.setEditable(false);
		paymentAmountInput.setForeground(new Color(89,89,89));
		paymentAmountInput.addFocusListener(this);
		paymentAmountInput.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		paymentAmountInput.setBackground(new Color(255,255,255));
		paymentAmountInput.setFont(new Font("Calibri",Font.BOLD,20));
		paymentAmountInput.setBounds(960,80,250,50);
		p1.add(paymentAmountInput);		


		//payment type

		paymentType = new JLabel("Payment's Type",JLabel.CENTER);
		paymentType.setBounds(1250,40,250,30);
		paymentType.setForeground(new Color(89,89,89));
		paymentType.setFont(f1);
		p1.add(paymentType);

		paymentTypeInput = new JComboBox();
		paymentTypeInput.setForeground(new Color(89,89,89));
		paymentTypeInput.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		paymentTypeInput.addFocusListener(this);
		paymentTypeInput.setBackground(new Color(255,255,255));
		paymentTypeInput.setFont(new Font("Calibri",Font.BOLD,20));
		paymentTypeInput.setBounds(1250,80,250,50);
		paymentTypeInput.addItem("Credit");
		paymentTypeInput.addItem("Debit");
		p1.add(paymentTypeInput);

		setVisible(true);

		JPanel p2 = new JPanel();
		p2.setBounds(360,230,800,110);
		p2.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		p2.setLayout(null);
		p1.add(p2);

		add = new JButton("Add");
		add.setBounds(150,25,100,60);
		add.setFocusPainted(false);
		add.setFont(new Font("Calibri",Font.BOLD,20));
		add.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		add.setForeground(new Color(255,255,255));
		add.addActionListener(this);
		add.setBackground(new Color(89,89,89));
		p2.add(add);

		save = new JButton("Save");
		save.setBounds(350,25,100,60);
		save.setFocusPainted(false);
		save.setFont(new Font("Calibri",Font.BOLD,20));
		save.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		save.setForeground(new Color(255,255,255));
		save.addActionListener(this);
		save.setBackground(new Color(89,89,89));
		p2.add(save);

		exit = new JButton("Exit");
		exit.setBounds(550,25,100,60);
		exit.setFocusPainted(false);
		exit.addActionListener(this);
		exit.setFont(new Font("Calibri",Font.BOLD,20));
		exit.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		exit.setForeground(new Color(255,255,255));
		exit.setBackground(new Color(89,89,89));
		p2.add(exit);


		JPanel p3 = new JPanel();
		p3.setBounds(40,550,1520,150);
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),5,true));
		add(p3);


		JPanel p4 = new JPanel();
		p4.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),1,true));
		p4.setLayout(null);
		p4.setBounds(50,60,1420,70);
		p3.add(p4);


		
		lastEntry = new JLabel[7];

		lastEntry[0] = new JLabel("Last Entry");
		lastEntry[0].setBounds(50,20,300,30);
		lastEntry[0].setForeground(new Color(89,89,89));
		lastEntry[0].setFont(new Font("Calibri",Font.BOLD,30));
		p3.add(lastEntry[0]);


		for(int i=1;i<7;i++)
		{
			lastEntry[i] = new JLabel("",JLabel.CENTER);
			lastEntry[i].setForeground(new Color(89,89,89));
			p4.add(lastEntry[i]);
			lastEntry[i].setFont(new Font("Calibri",Font.BOLD,22));
			
		}
		
		lastEntry[1].setBounds(50,25,100,20);//display payid
		lastEntry[2].setBounds(210,25,150,20);//display txn date
		lastEntry[3].setBounds(410,25,200,20);//dispay account name
		lastEntry[4].setBounds(660,25,340,20);//display payment desc.
		lastEntry[5].setBounds(1060,25,150,20);//display amount.
		lastEntry[6].setBounds(1270,25,100,20);//display payment type

		
		p3.add(new JScrollPane());
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			dateInput.setEditable(true);
			paymentDescInput.setEditable(true);
			paymentAmountInput.setEditable(true);
		}

		if(ae.getSource()==save)
		{
			int i=0;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select Count(payID) from payment_entry where loginid = '"+login_session+"'");
				while(rs.next())
				{
					i=rs.getInt(1);
					i=i+1;
				}
				conn.close();	
			}
			catch(Exception e)
			{

			}
			
			String s1,s2,s3,s4,s5,s6;
			s1 = "INV"+i;
			s2 = dateInput.getText();
			s3 =""+accountInput.getSelectedItem();
			s4 = paymentDescInput.getText();
			s5 = paymentAmountInput.getText();
			s6 = ""+paymentTypeInput.getSelectedItem();

			if(s5.length()==0 || s2.length()==0 || s4.length()==0){
				JOptionPane.showMessageDialog(null,"Fill all fields","Caution",JOptionPane.WARNING_MESSAGE);
			}
			else{
				lastEntry[1].setText(s1);
				lastEntry[2].setText(s2);
				lastEntry[3].setText(s3);
				lastEntry[4].setText(s4);
				
				lastEntry[6].setText(s6);
				if(paymentTypeInput.getSelectedItem()=="Credit")
				{
					D1 = Float.parseFloat(s5);
					D1 = -1*D1;
					s5 = String.valueOf(D1);
				}
				lastEntry[5].setText(s5);
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("Insert into payment_entry(payId,payDate,customerId,payDesc,payAmount,payType,loginid) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+login_session+"')");
					JOptionPane.showMessageDialog(null,"Payment Inserted Successfully","Congratulations",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				paymentAmountInput.setText("");
				paymentDescInput.setText("");
			}		
		}
		if(ae.getSource()==exit)
		{
			setVisible(false);
		}
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==dateInput)
		{
			dateInput.setForeground(new Color(89,89,89));
			dateInput.setBackground(new Color(255,255,255));
		}
		else if(fe.getSource()==accountInput)
		{
			accountInput.setForeground(new Color(89,89,89));
			accountInput.setBackground(new Color(255,255,255));
		}
		else if(fe.getSource()==paymentDescInput)
		{
			paymentDescInput.setForeground(new Color(89,89,89));
			paymentDescInput.setBackground(new Color(255,255,255));
		}
		else if(fe.getSource()==paymentTypeInput)
		{
			paymentTypeInput.setForeground(new Color(89,89,89));
			paymentTypeInput.setBackground(new Color(255,255,255));
		}
		else if(fe.getSource()==paymentAmountInput)
		{
			paymentAmountInput.setForeground(new Color(89,89,89));
			paymentAmountInput.setBackground(new Color(255,255,255));
		}
	}


	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==dateInput)
		{
			dateInput.setForeground(new Color(255,255,255));
			dateInput.setBackground(new Color(89,89,89));
		}
		else if(fe.getSource()==accountInput)
		{
			accountInput.setForeground(new Color(255,255,255));
			accountInput.setBackground(new Color(89,89,89));
		}
		else if(fe.getSource()==paymentDescInput)
		{
			paymentDescInput.setForeground(new Color(255,255,255));
			paymentDescInput.setBackground(new Color(89,89,89));
		}
		else if(fe.getSource()==paymentTypeInput)
		{
			paymentTypeInput.setForeground(new Color(255,255,255));
			paymentTypeInput.setBackground(new Color(89,89,89));
		}
		else if(fe.getSource()==paymentAmountInput)
		{
			paymentAmountInput.setForeground(new Color(255,255,255));
			paymentAmountInput.setBackground(new Color(89,89,89));
		}
	}
	public static void main(String[] args) {
		new payment("himanshu4319");
	}
}