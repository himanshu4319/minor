import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Driver.*;
import java.sql.*;

class manage_payments extends JDialog implements FocusListener,ActionListener
{
	JLabel accountNumber,ifscCode,bankName,upiId;
	JTextField accountNumberInput,ifscCodeInput,bankNameInput,upiIdInput;
	JButton edit,save,exit;
	int i=0;
	Font f1 = new Font("Calibri",Font.BOLD,35);
	Font f2 = new Font("Calibri",Font.BOLD,22); 

	String login_session = "";
	Color c1 = new Color(89,89,89);
	Color c2 = new Color(255,255,255);
	manage_payments(String pay1,String pay2,String pay3,String pay4,String pay5){
		login_session=pay5;

		setSize(800,750);
		setLayout(null);
		setTitle("Manage Payment Details");
		setLocationRelativeTo(null);
		setVisible(true);

		JLabel head = new JLabel("Manage Payments Details");
		head.setBounds(50,30,500,50);
		head.setFont(f1);
		head.setForeground(c1);
		add(head);


		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createLineBorder(c1,3,true));
		p1.setBounds(50,130,700,360);
		add(p1);

		//setting JLabel & Textfield for account number
		accountNumber = new JLabel("Account Number ");
		accountNumber.setFont(f2);
		accountNumber.setForeground(c1);
		accountNumber.setBounds(50,40,200,40);
		p1.add(accountNumber);

		accountNumberInput = new JTextField(20);
		accountNumberInput.setBounds(250,40,400,40);
		accountNumberInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		accountNumberInput.setEditable(false);
		accountNumberInput.setFont(f2);
		accountNumberInput.addFocusListener(this);
		accountNumberInput.setBackground(c2);
		p1.add(accountNumberInput);

		if(pay1==null||pay1==""){
			accountNumberInput.setText("");
			i++;
		}
		else{
			accountNumberInput.setText(""+pay1);
		}


		//setting Jlabel and textfield for ifsc

		ifscCode = new JLabel("IFSC Code ");
		ifscCode.setFont(f2);
		ifscCode.setForeground(c1);
		ifscCode.setBounds(50,120,200,40);
		p1.add(ifscCode);

		ifscCodeInput = new JTextField(20);
		ifscCodeInput.setBounds(250,120,400,40);
		ifscCodeInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		ifscCodeInput.setEditable(false);
		ifscCodeInput.setFont(f2);
		ifscCodeInput.setBackground(c2);
		ifscCodeInput.addFocusListener(this);
		p1.add(ifscCodeInput);

		if(pay2=="" || pay2==null){
			ifscCodeInput.setText("");
			i++;
		}
		else{
			ifscCodeInput.setText(""+pay2);
		}

		//setting Jlabel and textfield for Bank Name

		bankName = new JLabel("Bank Name ");
		bankName.setFont(f2);
		bankName.setForeground(c1);
		bankName.setBounds(50,200,200,40);
		p1.add(bankName);

		bankNameInput = new JTextField(20);
		bankNameInput.setBounds(250,200,400,40);
		bankNameInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		bankNameInput.setEditable(false);
		bankNameInput.setFont(f2);
		bankNameInput.addFocusListener(this);
		bankNameInput.setBackground(c2);
		p1.add(bankNameInput);

		if(pay3=="" || pay3==null){
			bankNameInput.setText("");
			i++;
		}
		else{
			bankNameInput.setText(""+pay3);
		}

		//setting Jlabel and textfield upiId

		upiId = new JLabel("UPI ID ");
		upiId.setFont(f2);
		upiId.setForeground(c1);
		upiId.setBounds(50,280,200,40);
		p1.add(upiId);

		upiIdInput = new JTextField(20);
		upiIdInput.setBounds(250,280,400,40);
		upiIdInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		upiIdInput.setEditable(false);
		upiIdInput.setFont(f2);
		upiIdInput.addFocusListener(this);
		upiIdInput.setBackground(c2);
		p1.add(upiIdInput);

		if(pay4=="" || pay4==null){
			upiIdInput.setText("");
			i++;
		}
		else{
			upiIdInput.setText(""+pay2);
		}


		//adding Buttons and Panel

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

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==edit)
		{
			accountNumberInput.setEditable(true);
			upiIdInput.setEditable(true);
			ifscCodeInput.setEditable(true);
			bankNameInput.setEditable(true);
		}

		else if(ae.getSource()==save)
		{
			JOptionPane j1 = new JOptionPane();
			String s1,s2,s3,s4;
			s1=accountNumberInput.getText();
			s2=upiIdInput.getText();
			s3=ifscCodeInput.getText();
			s4=bankNameInput.getText();
			if(s1.length()==0 || s2.length()==0 || s3.length()==0 || s4.length()==0)
			{
				j1.showMessageDialog(null,"All fields are required.","warning",JOptionPane.WARNING_MESSAGE);
			}
			else{
				if(i==4){
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("insert into payment(Ac_number,ifsc,Bname,upi,login)values('"+s1+"','"+s3+"','"+s4+"','"+s2+"','"+login_session+"')");
						conn.close();
						j1.showMessageDialog(null,"Payments Details inserted successfully","Payment Details",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e)
					{}
				}
				else if(i<4){
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("update `ag`.`payment` SET `Ac_number`='"+s1+"',`ifsc`='"+s3+"',`Bname` = '"+s4+"',`upi`='"+s2+"' where(`login` = '"+login_session+"')");
						conn.close();
						j1.showMessageDialog(null,"Payments Details updated successfully","Payment Details",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e)
					{}
				}
			}

		}
		else if(ae.getSource()==exit)
		{
			setVisible(false);
		}
	}
	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==accountNumberInput)
		{
			accountNumberInput.setBackground(c1);
			accountNumberInput.setForeground(c2);
		}
		else if(fe.getSource()==upiIdInput)
		{
			upiIdInput.setBackground(c1);
			upiIdInput.setForeground(c2);
		}
		else if(fe.getSource()==ifscCodeInput)
		{
			ifscCodeInput.setBackground(c1);
			ifscCodeInput.setForeground(c2);
		}
		else if(fe.getSource()==bankNameInput)
		{
			bankNameInput.setBackground(c1);
			bankNameInput.setForeground(c2);
		}
	}

	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==accountNumberInput)
		{
			accountNumberInput.setBackground(c2);
			accountNumberInput.setForeground(c1);
		}
		else if(fe.getSource()==upiIdInput)
		{
			upiIdInput.setBackground(c2);
			upiIdInput.setForeground(c1);
		}
		else if(fe.getSource()==ifscCodeInput)
		{
			ifscCodeInput.setBackground(c2);
			ifscCodeInput.setForeground(c1);
		}
		else if(fe.getSource()==bankNameInput)
		{
			bankNameInput.setBackground(c2);
			bankNameInput.setForeground(c1);
		}
	}

	public static void main(String[] args) {
		new manage_payments("p1","p2","p3","P4","p5");
	}
	
}