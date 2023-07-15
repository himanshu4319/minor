import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager.*;
import java.util.Date;
import java.text.SimpleDateFormat; 
public class sales extends JFrame implements ActionListener
{
	JPanel mainPanel,dateInvoicePanel, toPanel, fromPanel, productPanel, finalBalancePanel, paymentDetailsPanel,buttonPanel;
	JPanel[] panel ;//for product
	JLabel[] product_sno;
	JLabel[] itembox;
	JLabel[] prodduct_qty;
	JLabel[] proPrice;
	JLabel[] Total;
	JLabel amt,sno1,tohead;
	JTextField qty1,price1,invoiceNumberInput,dateform;
	JButton save,exit,btn1;
	int j=0,y=125; 
	int pp=0;
	int loop,Final_total=0;
	Color c1 = new Color(89,89,89);
	JComboBox itemBox1;
	String session;
	int optionPaneResult;
	JOptionPane j2 = new JOptionPane();
	Font f1 = new Font("Calibri",Font.BOLD,40);
	Font f2 = new Font("Calibri",Font.PLAIN,18);
	Font f3 = new Font("Calibri",Font.BOLD,22);
	sales(String loginid, String Client)
	{
		session = loginid;
		//basic functionalities
		setSize(1800,1040);
		setLayout(null);
		setTitle("Sales - Aggarwal & Aggarwal's");

		


		//mainPanel
		mainPanel = new JPanel();
		mainPanel.setBounds(50,50,1500,900);
		mainPanel.setLayout(null);
		mainPanel.setBorder(BorderFactory.createLineBorder(c1,3,true));
		add(mainPanel);


		//from panel setting
		fromPanel = new JPanel();
		fromPanel.setLayout(null);
		fromPanel.setBounds(100,20,1300,130);
		mainPanel.add(fromPanel);

		JLabel fromHeading = new JLabel("",JLabel.CENTER);
		fromHeading.setFont(f1);
		fromHeading.setForeground(c1);
		fromHeading.setBounds(100,10,1100,35);
		fromPanel.add(fromHeading);

		JLabel fromFirstLine = new JLabel("",JLabel.CENTER);
		fromFirstLine.setFont(f2);
		fromFirstLine.setForeground(c1);
		fromFirstLine.setBounds(100,50,1100,20);
		fromPanel.add(fromFirstLine);

		JLabel fromSecondLine = new JLabel("",JLabel.CENTER);
		fromSecondLine.setFont(f2);
		fromSecondLine.setForeground(c1);
		fromSecondLine.setBounds(100,75,1100,20);
		fromPanel.add(fromSecondLine);

		JLabel fromThirdLine = new JLabel("",JLabel.CENTER);
		fromThirdLine.setFont(f2);
		fromThirdLine.setForeground(c1);
		fromThirdLine.setBounds(100,100,1100,20);
		fromPanel.add(fromThirdLine);

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select admin_user.firm_name ,address.* from admin_user inner join address on address.user_name = admin_user.login_user where login_user = '"+loginid+"'");
			while(rs.next())
			{
				fromHeading.setText(rs.getString(1));
				fromFirstLine.setText(rs.getString(3));
				fromSecondLine.setText(rs.getString(4));
				fromThirdLine.setText(""+rs.getString(5)+", "+rs.getString(6)+"-"+rs.getString(7));			
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		//from panel setting finnishes



		//toPanel Setting
		toPanel = new JPanel();
		toPanel.setLayout(null);
		toPanel.setBorder(BorderFactory.createLineBorder(c1,1,false));
		toPanel.setBounds(100,180,650,185);
		mainPanel.add(toPanel);

		JLabel to = new JLabel("To ");
		to.setBounds(40,30,50,30);
		to.setFont(new Font("Calibri",Font.BOLD,25));
		to.setForeground(c1);
		toPanel.add(to);


		tohead = new JLabel("");
		tohead.setBounds(120,50,480,30);
		tohead.setForeground(c1);
		tohead.setFont(f3);
		toPanel.add(tohead);

		JLabel toFirstLine = new JLabel("");
		toFirstLine.setBounds(120,85,480,20);
		toFirstLine.setForeground(c1);
		toFirstLine.setFont(f2);
		toPanel.add(toFirstLine);

		JLabel toSecondLine = new JLabel("");
		toSecondLine.setBounds(120,110,480,20);
		toSecondLine.setForeground(c1);
		toSecondLine.setFont(f2);
		toPanel.add(toSecondLine);

		JLabel toThirdLine = new JLabel("");
		toThirdLine.setBounds(120,135,480,20);
		toThirdLine.setForeground(c1);
		toThirdLine.setFont(f2);
		toPanel.add(toThirdLine);

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from firm where M_S = '"+Client+"'");
			while(rs.next())
			{
				tohead.setText(Client);
				toFirstLine.setText(rs.getString(7));
				toSecondLine.setText(""+rs.getString(9)+", "+rs.getString(8)+" - "+rs.getString(10));
				toThirdLine.setText(""+rs.getString(4)+", "+rs.getString(6));
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		//to panel settings finishes.

		//dateInvoice panel setting
		dateInvoicePanel = new JPanel();
		dateInvoicePanel.setLayout(null);
		dateInvoicePanel.setBorder(BorderFactory.createLineBorder(c1,1,false));
		dateInvoicePanel.setBounds(750,180,650,185);
		mainPanel.add(dateInvoicePanel);

		JLabel invoiceNumber = new JLabel("Invoice No. ");
		invoiceNumber.setFont(f3);
		invoiceNumber.setForeground(c1);
		invoiceNumber.setBounds(40,30,120,30);
		dateInvoicePanel.add(invoiceNumber);

		invoiceNumberInput = new JTextField(10);
		invoiceNumberInput.setBounds(180,30,100,30);
		invoiceNumberInput.setForeground(c1);
		invoiceNumberInput.setFont(f3);
		invoiceNumberInput.setBorder(BorderFactory.createLineBorder(c1,3,true));
		dateInvoicePanel.add(invoiceNumberInput);


		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");  
	    Date date = new Date();  
    	
    	JLabel dateLabel = new JLabel("Date ");
		dateLabel.setFont(f3);
		dateLabel.setForeground(c1);
		dateLabel.setBounds(380,30,120,30);
		dateInvoicePanel.add(dateLabel);
		
		dateform = new JTextField(20);
		dateform.setFont(f3);
		dateform.setForeground(c1);
		dateform.setBounds(460,30,150,30);
		dateInvoicePanel.add(dateform);
		dateform.setText(formatter.format(date));


		try{
			int i=0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select Count(DISTINCT invoiceNumber) from bills where loginUser = '"+loginid+"'");
			while(rs.next())
			{
				i=rs.getInt(1);
				i=i+1;
				invoiceNumberInput.setText("00"+i);
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		//dateInvoice panel setting finishes.
		
		//product panel
		productPanel = new JPanel();
		productPanel.setBounds(100,385,1300,300);
		productPanel.setBorder(BorderFactory.createLineBorder(c1,1,false));
		productPanel.setLayout(null);
		mainPanel.add(productPanel);

		JPanel p1 = new JPanel();
		p1.setBounds(40,20,1220,40);
		p1.setBorder(BorderFactory.createLineBorder(c1,1,false));
		p1.setLayout(null);
		productPanel.add(p1);

		JLabel sno = new JLabel("S no.",JLabel.CENTER);
		sno.setBounds(20,5,100,30);
		//sno.setBorder(BorderFactory.createLineBorder(c1,1,false));
		sno.setFont(f3);
		sno.setForeground(c1);
		p1.add(sno);

		JLabel item = new JLabel("Item Details",JLabel.CENTER);
		item.setBounds(130,5,450,30);
		item.setFont(f3);
		item.setForeground(c1);
		p1.add(item);

		JLabel qty = new JLabel("Quantity",JLabel.CENTER);
		qty.setBounds(600,5,100,30);
		qty.setFont(f3);
		qty.setForeground(c1);
		p1.add(qty);

		JLabel price = new JLabel("Price",JLabel.CENTER);
		price.setBounds(710,5,240,30);
		price.setFont(f3);
		price.setForeground(c1);
		p1.add(price);


		JLabel amount = new JLabel("Amount",JLabel.CENTER);
		amount.setBounds(1000,5,240,30);
		amount.setFont(f3);
		amount.setForeground(c1);
		p1.add(amount);

		//declaration of panel array
		panel = new JPanel[3];

		
		prodduct_qty = new JLabel[3];
		product_sno = new JLabel[3];
		itembox = new JLabel[5];
		proPrice = new JLabel[3];
		Total = new JLabel[3];
		
		//panel where user enter product details

		JPanel p11 = new JPanel();
		p11.setBounds(40,65,1220,40);
		p11.setBorder(BorderFactory.createLineBorder(c1,1,false));
		p11.setLayout(null);
		productPanel.add(p11);

		sno1 = new JLabel("",JLabel.CENTER);
		sno1.setText(""+(pp+1));
		sno1.setBounds(20,5,100,30);
		//sno.setBorder(BorderFactory.createLineBorder(c1,1,false));
		sno1.setFont(f3);
		sno1.setForeground(c1);
		p11.add(sno1);

		itemBox1 = new JComboBox();
		itemBox1.setBounds(150,5,400,30);
		itemBox1.setFont(f3);
		itemBox1.setForeground(c1);
		p11.add(itemBox1);

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from products where loginid= '"+loginid+"'");
			while(rs.next())
			{
				itemBox1.addItem(""+rs.getString(2)+" "+rs.getString(3));
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		qty1 = new JTextField(20);
		qty1.setBounds(600,5,100,30);
		qty1.setFont(f3);
		qty1.setForeground(c1);
		p11.add(qty1);

		price1 = new JTextField(20);
		price1.setBounds(710,5,240,30);
		price1.setFont(f3);
		price1.setForeground(c1);
		p11.add(price1);
		
		


		//setting of payment panel
		paymentDetailsPanel = new JPanel();
		paymentDetailsPanel.setBounds(100,705,650,175);
		paymentDetailsPanel.setLayout(null);
		paymentDetailsPanel.setBorder(BorderFactory.createLineBorder(c1,1,false));
		mainPanel.add(paymentDetailsPanel);
		

		JLabel payhead = new JLabel("Payment Details");
		payhead.setBounds(20,15,200,30);
		payhead.setFont(new Font("Calibri",Font.BOLD,25));
		payhead.setForeground(c1);
		paymentDetailsPanel.add(payhead);

		JLabel acc = new JLabel("");
		acc.setBounds(120,50,480,30);
		acc.setForeground(c1);
		acc.setFont(f3);
		paymentDetailsPanel.add(acc);

		JLabel payFirstLine = new JLabel("");
		payFirstLine.setBounds(120,85,480,20);
		payFirstLine.setForeground(c1);
		payFirstLine.setFont(f2);
		paymentDetailsPanel.add(payFirstLine);

		JLabel paySecondLine = new JLabel("");
		paySecondLine.setBounds(120,110,480,20);
		paySecondLine.setForeground(c1);
		paySecondLine.setFont(f2);
		paymentDetailsPanel.add(paySecondLine);

		JLabel payThirdLine = new JLabel("");
		payThirdLine.setBounds(120,135,480,20);
		payThirdLine.setForeground(c1);
		payThirdLine.setFont(f2);
		paymentDetailsPanel.add(payThirdLine);


		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select payment.*, admin_user.firm_name from payment inner join admin_user on payment.login = admin_user.login_user where login_user ='"+loginid+"'");
			while(rs.next())
			{
				acc.setText("Account number : "+rs.getString(2));
				payFirstLine.setText("IFSC Code : "+rs.getString(3));
				paySecondLine.setText("Bank Name : "+rs.getString(4));
				payThirdLine.setText("UPI Id : "+rs.getString(5));
			}
		}		
		catch(Exception e)
		{}

		finalBalancePanel = new JPanel();
		finalBalancePanel.setBounds(750,705,650,175);
		finalBalancePanel.setBorder(BorderFactory.createLineBorder(c1,1,false));
		finalBalancePanel.setLayout(null);
		mainPanel.add(finalBalancePanel);

		JLabel Total = new JLabel("Total Amount");
		Total.setFont(new Font("Calibri",Font.BOLD,32));
		Total.setBounds(100,50,200,75);
		Total.setForeground(c1);
		finalBalancePanel.add(Total);

		amt = new JLabel("",JLabel.CENTER);
		amt.setBounds(350,50,250,75);
		amt.setForeground(c1);
		amt.setBorder(BorderFactory.createLineBorder(c1,2,true));
		amt.setFont(new Font("Calibri",Font.BOLD,32));
		finalBalancePanel.add(amt);


		setVisible(true);

		//button panel
		buttonPanel = new JPanel();
		buttonPanel.setBounds(1600,230,150,600);
		buttonPanel.setLayout(null);
		buttonPanel.setBorder(BorderFactory.createLineBorder(c1,3,true));
		add(buttonPanel);

		//adding Button

		btn1 = new JButton("Insert");
		btn1.setBounds(1100,5,100,30);
		btn1.setFocusPainted(false);
		btn1.setFont(new Font("Calibri",Font.BOLD,20));
		btn1.setBorder(BorderFactory.createLineBorder(c1,3,true));
		btn1.setForeground(new Color(255,255,255));
		btn1.addActionListener(this);
		btn1.setBackground(c1);
		p11.add(btn1);

		save = new JButton("Save");
		save.setBounds(25,150,100,60);
		save.setFocusPainted(false);
		save.setFont(new Font("Calibri",Font.BOLD,20));
		save.setBorder(BorderFactory.createLineBorder(c1,3,true));
		save.setForeground(new Color(255,255,255));
		save.addActionListener(this);
		save.setBackground(c1);
		buttonPanel.add(save);

		exit = new JButton("Exit");
		exit.setBounds(25,350,100,60);
		exit.setFocusPainted(false);
		exit.addActionListener(this);
		exit.setFont(new Font("Calibri",Font.BOLD,20));
		exit.setBorder(BorderFactory.createLineBorder(c1,3,true));
		exit.setForeground(new Color(255,255,255));
		exit.setBackground(c1);
		buttonPanel.add(exit);

	}

	public void actionPerformed(ActionEvent ae)
	{
		//this click inserts value in an array
		if(ae.getSource()==btn1)
		{
			if(pp<3)
			{
				sno1.setText(""+(pp+1));
				String s1,s2;
				int s3,s4,s5;
				s1=""+(pp+1);
				s2=""+itemBox1.getSelectedItem();
				s3=Integer.parseInt(qty1.getText());
				s4=Integer.parseInt(price1.getText());
				s5=s3*s4;
			
				panel[pp] = new JPanel();
				panel[pp].setBorder(BorderFactory.createLineBorder(c1,1,false));
				panel[pp].setLayout(null);
				productPanel.add(panel[pp]);
			
				product_sno[pp] = new JLabel("",JLabel.CENTER);
				product_sno[pp].setBounds(20,5,150,30);
				//product_sno.setBorder(BorderFactory.createLineBorder(c1,1,false));
				product_sno[pp].setFont(f3);
				product_sno[pp].setForeground(c1);
				product_sno[pp].setText(""+(pp+1));
				product_sno[pp].setText(s1);
				panel[pp].add(product_sno[pp]);

				itembox[pp] = new JLabel("",JLabel.CENTER);
				itembox[pp].setBounds(180,5,500,30);
				itembox[pp].setFont(f3);
				itembox[pp].setForeground(c1);
				itembox[pp].setText(s2);
				panel[pp].add(itembox[pp]);

				prodduct_qty[pp] = new JLabel("",JLabel.CENTER);
				prodduct_qty[pp].setBounds(690,5,100,30);
				prodduct_qty[pp].setFont(f3);
				prodduct_qty[pp].setText(""+s3);
				prodduct_qty[pp].setForeground(c1);
				panel[pp].add(prodduct_qty[pp]);

				
				proPrice[pp] = new JLabel("",JLabel.CENTER);
				proPrice[pp].setBounds(800,5,240,30);
				proPrice[pp].setFont(f3);
				proPrice[pp].setText(""+s4);
				proPrice[pp].setForeground(c1);
				panel[pp].add(proPrice[pp]);

				Total[pp] = new JLabel("",JLabel.CENTER);
				Total[pp].setBounds(1000,5,200,30);
				Total[pp].setFont(f3);
				Total[pp].setText(""+s5);
				Total[pp].setForeground(c1);
				panel[pp].add(Total[pp]);

				panel[pp].setBounds(40,y,1220,40);
				y=y+60;
				System.out.print(pp);
				pp=pp+1;
				loop=pp;		
				Final_total += s5;
				amt.setText(""+Final_total);
				if(pp<3)
				{	
					optionPaneResult=j2.showConfirmDialog(null,"Would you like to add more Product","Submit Response",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					optionPaneResult=JOptionPane.NO_OPTION;
				}			
			}	
			else{
				JOptionPane.showMessageDialog(null,"You can add maximum three products only.","Information",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (ae.getSource()==exit) 
		{
			setVisible(false);
			optionPaneResult = JOptionPane.YES_OPTION;
		}
		else if(ae.getSource()==save);
		{
			if(optionPaneResult==JOptionPane.NO_OPTION ){
				String[] proId = new String[1];
				String b1,b2,b3,b4,b5,b6,b7;
				b1 = invoiceNumberInput.getText();
				b2 = dateform.getText();
				b3 = tohead.getText();
				for(int m=0;m<loop;m++)
				{
					b4 = itembox[m].getText();
					proId = b4.split("\\s");
					b5 = prodduct_qty[m].getText();
					b6 = proPrice[m].getText();
					b7 = amt.getText();
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("Insert into bills(invoiceNumber,orderDate,firmId,productId,productDesc,productQty,productPrice,loginUser,totalValue) values('"+b1+"','"+b2+"','"+b3+"','"+proId[0]+"','"+b4+"','"+b5+"','"+b6+"','"+session+"','"+b7+"')");			
					}
					catch(Exception e){}
					}
					JOptionPane.showMessageDialog(null,"Invoice Registered Successfully","Congratulations",JOptionPane.INFORMATION_MESSAGE);
				}
			}	
		}	
	public static void main(String[] args) {
		new sales("himanshu4319","Nittin Kumar & co.");
	}
}