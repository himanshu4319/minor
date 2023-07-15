import java.sql.Driver.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class add_products extends JDialog implements FocusListener,ActionListener
{
	JLabel productId, productName, productDesc, productPrice, categoryName, productQty;
	JTextField productIdInput, productNameInput, productPriceInput;
	JComboBox categoryNameInput;
	JSlider productQtyInput;
	JTextArea productDescInput;
	JButton add, save, exit;
	Font f1 = new Font("Calibri",Font.BOLD,22);
	Color c1 = new Color(89,89,89);
	String login_session;

	public int checkingProduct(String session, String pro)
	{
		int i=0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from products where proId = '"+pro+"' and loginid = '"+session+"'");
			while(rs.next())
			{
				i++;
			}
			conn.close() ;
		}
		catch(Exception e)
		{}
		return i;
	}
	add_products(String loginid)
	{
		login_session = loginid;
		setSize(900,830);
		setTitle("Add Products");
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);

		//heading 
		JLabel head = new JLabel("Add Products");
		head.setFont(new Font("Calibri",Font.BOLD,30));
		head.setForeground(new Color(89,89,89));
		head.setBounds(50,50,400,40);
		add(head);

		//main panel
		JPanel p1 = new JPanel();
		p1.setBounds(50,110,800,480);
		p1.setBorder(BorderFactory.createLineBorder(new Color(89,89,89),3,true));
		p1.setLayout(null);
		add(p1);

		//product ID(like HSN Code)
		productId = new JLabel("Product Id : ");
		productId.setFont(f1);
		productId.setForeground(c1);
		productId.setBounds(50,50,250,40);
		p1.add(productId);

		productIdInput = new JTextField(20);
		productIdInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		productIdInput.setFont(f1);
		productIdInput.setBounds(350,50,400,40);
		productIdInput.setForeground(c1);
		productIdInput.setBackground(new Color(255,255,255));
		productIdInput.setEditable(false);
		productIdInput.addFocusListener(this);
		p1.add(productIdInput);

		//product Name
		productName = new JLabel("Product Name : ");
		productName.setFont(f1);
		productName.setForeground(c1);
		productName.setBounds(50,110,250,40);
		p1.add(productName);

		productNameInput = new JTextField(20);
		productNameInput.setEditable(false);
		productNameInput.addFocusListener(this);
		productNameInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		productNameInput.setFont(f1);
		productNameInput.setBounds(350,110,400,40);
		productNameInput.setForeground(c1);
		productNameInput.setBackground(new Color(255,255,255));
		p1.add(productNameInput);

		//product Category 

		categoryName = new JLabel("Category : ");
		categoryName.setFont(f1);
		categoryName.setForeground(c1);
		categoryName.setBounds(50,170,250,40);
		p1.add(categoryName);

		categoryNameInput = new JComboBox();
		categoryNameInput.addFocusListener(this);
		categoryNameInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		categoryNameInput.setFont(f1);
		categoryNameInput.setBounds(350,170,400,40);
		categoryNameInput.setForeground(c1);
		categoryNameInput.setBackground(new Color(255,255,255));
		p1.add(categoryNameInput);

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
			
			Statement fetch = conn.createStatement();
			ResultSet rs = fetch.executeQuery("Select * from categories where loginid='"+loginid+"' order by category_name");
			while(rs.next())
			{
				categoryNameInput.addItem(rs.getString(2));
			}
			conn.close();

		}
		catch(Exception e){
			System.out.println(e);
		}


		//product qty
		productQty = new JLabel("Quantity :");
		productQty.setFont(f1);
		productQty.setForeground(c1);
		productQty.setBounds(50,230,250,40);
		p1.add(productQty);

		productQtyInput = new JSlider(JSlider.HORIZONTAL,0,100,0);
		productQtyInput.setFont(f1);
		productQtyInput.setBounds(350,230,400,40);
		productQtyInput.setForeground(c1);
		productQtyInput.setMajorTickSpacing(20);
		productQtyInput.setMinorTickSpacing(10);
		productQtyInput.setPaintTicks(true);
		productQtyInput.setPaintLabels(true);
		p1.add(productQtyInput);

		//product Description
		productDesc = new JLabel("Product's Desciption :");
		productDesc.setFont(f1);
		productDesc.setForeground(c1);
		productDesc.setBounds(50,290,250,40);
		p1.add(productDesc);

		productDescInput = new JTextArea();
		productDescInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		productDescInput.setFont(f1);
		productDescInput.setEditable(false);
		productDescInput.addFocusListener(this);
		productDescInput.setBounds(350,290,400,80);
		productDescInput.setForeground(c1);
		productDescInput.setBackground(new Color(255,255,255));
		p1.add(productDescInput);


		//product price
		productPrice = new JLabel("product's Price :");
		productPrice.setFont(f1);
		productPrice.setForeground(c1);
		productPrice.setBounds(50,390,250,40);
		p1.add(productPrice);

		productPriceInput = new JTextField(20);
		productPriceInput.setEditable(false);
		productPriceInput.addFocusListener(this);
		productPriceInput.setBorder(BorderFactory.createLineBorder(c1,2,true));
		productPriceInput.setFont(f1);
		productPriceInput.setBounds(350,390,400,40);
		productPriceInput.setForeground(c1);
		productPriceInput.setBackground(new Color(255,255,255));
		p1.add(productPriceInput);


		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createLineBorder(c1,5,true));
		p3.setBounds(50,630,800,100);
		add(p3);

		add = new JButton("Add");
		add.setBounds(150,20,100,60);
		add.setFocusPainted(false);
		add.setFont(new Font("Calibri",Font.BOLD,20));
		add.setBorder(BorderFactory.createLineBorder(c1,3,true));
		add.setForeground(new Color(255,255,255));
		add.addActionListener(this);
		add.setBackground(c1);
		p3.add(add);

		save = new JButton("Save");
		save.setBounds(350,20,100,60);
		save.setFocusPainted(false);
		save.setFont(new Font("Calibri",Font.BOLD,20));
		save.setBorder(BorderFactory.createLineBorder(c1,3,true));
		save.setForeground(new Color(255,255,255));
		save.addActionListener(this);
		save.setBackground(c1);
		p3.add(save);

		exit = new JButton("Exit");
		exit.setBounds(550,20,100,60);
		exit.setFocusPainted(false);
		exit.addActionListener(this);
		exit.setFont(new Font("Calibri",Font.BOLD,20));
		exit.setBorder(BorderFactory.createLineBorder(c1,3,true));
		exit.setForeground(new Color(255,255,255));
		exit.setBackground(c1);
		p3.add(exit);

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			productIdInput.setEditable(true);
			productNameInput.setEditable(true);
			productDescInput.setEditable(true);
			productPriceInput.setEditable(true);
		}

		else if(ae.getSource()==save)
		{
			String s1,s2,s3,s4,s5,s6;
			int j;
			s1 = "A&A"+productIdInput.getText();
			s2 = productNameInput.getText();
			s3 = ""+categoryNameInput.getSelectedItem();
			s4 = ""+productQtyInput.getValue();
			s5 = productDescInput.getText();
			s6 = productPriceInput.getText();

			j = checkingProduct(login_session,s1);
			if(j==0)
			{	
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ag","root","Secureit4321@");
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("Insert into products(proId,proName,proCategory,proQuantity,proDesc,proPrice,loginid) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+login_session+"')");
					String str = ""+s2+" as a product added successfully under "+s3+" category";
					JOptionPane.showMessageDialog(null,str,"Congratulations",JOptionPane.INFORMATION_MESSAGE);
					conn.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"A product is already existed with "+s1+" product Id.");
			}	
		}
		else if(ae.getSource()==exit)
		{
			setVisible(false);
		}
	}
	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==productIdInput)
		{
			productIdInput.setForeground(c1);
			productIdInput.setBackground(new Color(255,255,255));
		}
		else if(fe.getSource()==productNameInput)
		{
			productNameInput.setForeground(c1);
			productNameInput.setBackground(new Color(255,255,255));	
		}
		else if(fe.getSource()==categoryNameInput)
		{
			categoryNameInput.setForeground(c1);
			categoryNameInput.setBackground(new Color(255,255,255));
		}
		else if(fe.getSource()==productDescInput)
		{
			productDescInput.setForeground(c1);
			productDescInput.setBackground(new Color(255,255,255));
		}
		else if(fe.getSource()==productPriceInput)
		{
			productPriceInput.setForeground(c1);
			productPriceInput.setBackground(new Color(255,255,255));
		}
	}

	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==productIdInput)
		{
			productIdInput.setForeground(new Color(255,255,255));
			productIdInput.setBackground(c1);
		}
		else if(fe.getSource()==productNameInput)
		{
			productNameInput.setForeground(new Color(255,255,255));
			
			productNameInput.setBackground(c1);	
		}
		else if(fe.getSource()==categoryNameInput)
		{
			categoryNameInput.setForeground(new Color(255,255,255));
			categoryNameInput.setBackground(c1);
		}
		else if(fe.getSource()==productDescInput)
		{
			productDescInput.setForeground(new Color(255,255,255));
			productDescInput.setBackground(c1);
		}
		else if(fe.getSource()==productPriceInput)
		{
			productPriceInput.setForeground(new Color(255,255,255));
			productPriceInput.setBackground(c1);
		}
	}
	/*public static void main(String[] args) {
		new add_products("himanshu4319");
	}*/

}
