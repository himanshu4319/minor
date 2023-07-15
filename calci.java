import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class calci extends JDialog implements ActionListener
{
	Double d1,d2;
	int status=0;
	Color c1 = new Color(217,217,217);//grey;
	Color c2 = new Color(255,255,255);//white;
	Color c3 = new Color(28,37,64);//royal dark blue
	Color c4 = new Color(44,44,44);//royal black
	Color c5 = new Color(191,189,186);//light-dark grey
	Color c6 = new Color(166,162,159);//dark - light grey
	Color c7 = new Color(115,115,115);
	Color c8 = new Color(89,85,82);
	JLabel T1;
	JButton j1,j2,j3,j4,j5,j6,j7,j8,j9,j0,j00,jdot,jadd,jsub,jpro,jdivide,jequal,jclear,jac,jsqr;
	calci()
	{
		setSize(540,600);
		setVisible(true);
		setLayout(null);
		setTitle("Calculator");
		T1 = new JLabel("0",JLabel.RIGHT);
		T1.setBackground(c5);
		T1.setBounds(40,25,460,80);
		T1.setBorder(BorderFactory.createLineBorder(c8));
		//T1.setEditable(false);
		T1.setFont(new Font("Consolas",Font.PLAIN,40));
		add(T1);


		j1 = new JButton("7");
		j1.setBackground(c8);
		j1.setFont(new Font("Consolas",Font.BOLD,40));
		j1.setForeground(c1);
		j1.setFocusPainted(false);
		j1.setBorder(null);
		j1.setBounds(120,130,80,60);
		add(j1);
	
		j2 = new JButton("8");
		j2.setBackground(c8);
		j2.setFont(new Font("Consolas",Font.BOLD,40));
		j2.setForeground(c1);
		j2.setFocusPainted(false);
		j2.setBorder(null);
		j2.setBounds(220,130,80,60);
		add(j2);

		j3 = new JButton("9");
		j3.setBackground(c8);
		j3.setFont(new Font("Consolas",Font.BOLD,40));
		j3.setForeground(c1);
		j3.setFocusPainted(false);
		j3.setBorder(null);
		j3.setBounds(320,130,80,60);
		add(j3);

		j4 = new JButton("4");
		j4.setBackground(c8);
		j4.setFont(new Font("Consolas",Font.BOLD,40));
		j4.setForeground(c1);
		j4.setFocusPainted(false);
		j4.setBorder(null);
		j4.setBounds(120,210,80,60);
		add(j4);

		j5 = new JButton("5");
		j5.setBackground(c8);
		j5.setFont(new Font("Consolas",Font.BOLD,40));
		j5.setForeground(c1);
		j5.setFocusPainted(false);
		j5.setBorder(null);
		j5.setBounds(220,210,80,60);
		add(j5);

		j6 = new JButton("6");
		j6.setBackground(c8);
		j6.setFont(new Font("Consolas",Font.BOLD,40));
		j6.setForeground(c1);
		j6.setFocusPainted(false);
		j6.setBorder(null);
		j6.setBounds(320,210,80,60);
		add(j6);

		j7 = new JButton("1");
		j7.setBackground(c8);
		j7.setFont(new Font("Consolas",Font.BOLD,40));
		j7.setForeground(c1);
		j7.setFocusPainted(false);
		j7.setBorder(null);
		j7.setBounds(120,290,80,60);
		add(j7);

		j8 = new JButton("2");
		j8.setBackground(c8);
		j8.setFont(new Font("Consolas",Font.BOLD,40));
		j8.setForeground(c1);
		j8.setFocusPainted(false);
		j8.setBorder(null);
		j8.setBounds(220,290,80,60);
		add(j8);

		j9 = new JButton("3");
		j9.setBackground(c8);
		j9.setFont(new Font("Consolas",Font.BOLD,40));
		j9.setForeground(c1);
		j9.setFocusPainted(false);
		j9.setBorder(null);
		j9.setBounds(320,290,80,60);
		add(j9);

		j0 = new JButton("0");
		j0.setBackground(c8);
		j0.setFont(new Font("Consolas",Font.BOLD,40));
		j0.setForeground(c1);
		j0.setFocusPainted(false);
		j0.setBorder(null);
		j0.setBounds(120,370,80,60);
		add(j0);

		j00= new JButton("00");
		j00.setBackground(c8);
		j00.setFont(new Font("Consolas",Font.BOLD,40));
		j00.setForeground(c1);
		j00.setFocusPainted(false);
		j00.setBorder(null);
		j00.setBounds(220,370,80,60);
		add(j00);

		jdot = new JButton(".");
		jdot.setBackground(c8);
		jdot.setFont(new Font("Consolas",Font.BOLD,40));
		jdot.setForeground(c1);
		jdot.setFocusPainted(false);
		jdot.setBorder(null);
		jdot.setBounds(320,370,80,60);
		add(jdot);

		jdivide = new JButton("/");
		jdivide.setBackground(c1);
		jdivide.setFont(new Font("Consolas",Font.BOLD,40));
		jdivide.setForeground(c8);
		jdivide.setFocusPainted(false);
		jdivide.setBorder(null);
		jdivide.setBounds(20,210,80,140);
		add(jdivide);

		jpro = new JButton("X");
		jpro.setBackground(c1);
		jpro.setFont(new Font("Consolas",Font.BOLD,40));
		jpro.setForeground(c8);
		jpro.setFocusPainted(false);
		jpro.setBorder(null);
		jpro.setBounds(420,210,80,60);
		add(jpro);

		jadd = new JButton("+");
		jadd.setBackground(c1);
		jadd.setFont(new Font("Consolas",Font.BOLD,40));
		jadd.setForeground(c8);
		jadd.setFocusPainted(false);
		jadd.setBorder(null);
		jadd.setBounds(420,290,80,140);
		add(jadd);

		jsub = new JButton("-");
		jsub.setBackground(c1);
		jsub.setFont(new Font("Consolas",Font.BOLD,40));
		jsub.setForeground(c8);
		jsub.setFocusPainted(false);
		jsub.setBorder(null);
		jsub.setBounds(20,370,80,140);
		add(jsub);

		jequal = new JButton("=");
		jequal.setBackground(c1);
		jequal.setFont(new Font("Consolas",Font.BOLD,40));
		jequal.setForeground(c8);
		jequal.setFocusPainted(false);
		jequal.setBorder(null);
		jequal.setBounds(320,450,180,60);
		add(jequal);

		jclear = new JButton("<-");
		jclear.setBackground(c1);
		jclear.setFont(new Font("Consolas",Font.BOLD,40));
		jclear.setForeground(c8);
		jclear.setFocusPainted(false);
		jclear.setBorder(null);
		jclear.setBounds(420,130,80,60);
		add(jclear);

		jac = new JButton("AC");
		jac.setBackground(c1);
		jac.setFont(new Font("Consolas",Font.BOLD,40));
		jac.setForeground(c8);
		jac.setFocusPainted(false);
		jac.setBorder(null);
		jac.setBounds(20,130,80,60);
		add(jac);

		jsqr = new JButton("x^2");
		jsqr.setBackground(c1);
		jsqr.setFont(new Font("Consolas",Font.BOLD,40));
		jsqr.setForeground(c8);
		jsqr.setFocusPainted(false);
		jsqr.setBorder(null);
		jsqr.setBounds(120,450,180,60);
		add(jsqr);

		//adding Action Listener
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
		j4.addActionListener(this);
		j5.addActionListener(this);
		j6.addActionListener(this);
		j7.addActionListener(this);
		j8.addActionListener(this);
		j9.addActionListener(this);
		j0.addActionListener(this);
		jadd.addActionListener(this);
		jsub.addActionListener(this);
		jpro.addActionListener(this);
		jdivide.addActionListener(this);
		jsqr.addActionListener(this);
		jac.addActionListener(this);
		jequal.addActionListener(this);
		j00.addActionListener(this);
		jdot.addActionListener(this);
		jclear.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==j1){
				if(T1.getText()=="0"){
					T1.setText("7");
				}
				else{
					T1.setText(T1.getText()+"7");
				}
			}	
		if(ae.getSource()==j2){
				if(T1.getText()=="0"){
					T1.setText("8");
				}
				else{
					T1.setText(T1.getText()+"8");
				}
			}	
		if(ae.getSource()==j3){
				if(T1.getText()=="0"){
					T1.setText("9");
				}
				else{
					T1.setText(T1.getText()+"9");
				}
			}	
		if(ae.getSource()==j4){
			if(T1.getText()=="0"){
				T1.setText("4");
			}
			else{
				T1.setText(T1.getText()+"4");
			}
		}		
			else if(ae.getSource()==j5){
				if(T1.getText()=="0"){
					T1.setText("5");
				}
				else{
					T1.setText(T1.getText()+"5");
				}
			}	
			else if(ae.getSource()==j6){
				if(T1.getText()=="0"){
					T1.setText("6");
				}
				else{
					T1.setText(T1.getText()+"6");
				}
			}	
			else if(ae.getSource()==j7){
				if(T1.getText()=="0"){
					T1.setText("1");
				}
				else{
					T1.setText(T1.getText()+"1");
				}
			}	
			else if(ae.getSource()==j8){
				if(T1.getText()=="0"){
					T1.setText("2");
				}
				else{
					T1.setText(T1.getText()+"2");
				}
			}	
			else if(ae.getSource()==j9){
				if(T1.getText()=="0"){
					T1.setText("3");
				}
				else{
					T1.setText(T1.getText()+"3");
				}
			}	
			else if(ae.getSource()==j0){
				if(T1.getText()=="0"){
					T1.setText("0");
				}
				else{
					T1.setText(T1.getText()+"0");
				}
			}	
			else if(ae.getSource()==j00){
				if(T1.getText()=="0")
					T1.setText("0");
				else	
					T1.setText(T1.getText()+"00");
			}
			else if(ae.getSource()==jdot){
				T1.setText(T1.getText()+".");

			}
			else if(ae.getSource()==jac)
			{
				d1=0.0;
				d2=0.0;
				T1.setText("0");
			}
			else if(ae.getSource()==jclear){
				String string = T1.getText();
				StringBuffer s1 = new StringBuffer(string);
				s1.deleteCharAt(s1.length()-1);
				String text = String.valueOf(s1);
				if(text.length()==0)
				{
					T1.setText("0");
				}
				else{
					T1.setText(text);
				}
			}	
			else if(ae.getSource()==jadd)
			{
				if(status==0){
					String s1 = T1.getText();
					d1 = Double.parseDouble(s1);
					T1.setText("0");
					status=1;
				}
				else {
					if(status==2)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1-d2;
						status=1;
						T1.setText("0");
					}
					else if(status==1)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1+d2;
						status=1;
						T1.setText("0");
					}
					else if(status==3)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1*d2;
						status=1;
						T1.setText("0");
					}
					else if(status==4)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1/d2;
						status=1;
						T1.setText("0");
					}
				}	
			}
			else if(ae.getSource()==jsub)
			{
				if(status==0){
					String s1 = T1.getText();
					d1 = Double.parseDouble(s1);
					T1.setText("0");
					status=2;
				}
				else {
					if(status==1)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1+d2;
						status=2;
						T1.setText("0");
					}
					else if(status==2)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1-d2;
						status=2;
						T1.setText("0");
					}
					else if(status==3)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1*d2;
						status=2;
						T1.setText("0");
					}
					else if(status==4)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1/d2;
						status=2;
						T1.setText("0");
					}

				}	
			}
			else if(ae.getSource()==jpro)
			{
				if(status==0){
					String s1 = T1.getText();
					d1 = Double.parseDouble(s1);
					T1.setText("0");
					status=3;
				}
				else {
					if(status==1)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1*d2;
						status=3;
						T1.setText("0");
					}
					else if(status==2)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1*d2;
						status=3;
						T1.setText("0");
					}
					else if(status==3)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1*d2;
						status=3;
						T1.setText("0");
					}
					else if(status==4)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1*d2;
						status=3;
						T1.setText("0");
					}
				}	
			}
			else if(ae.getSource()==jdivide)
			{
				if(status==0){
					String s1 = T1.getText();
					d1 = Double.parseDouble(s1);
					T1.setText("0");
					status=4;
				}
				else {
					if(status==1)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1/d2;
						status=4;
						T1.setText("0");
					}
					else if(status==2)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1/d2;
						status=4;
						T1.setText("0");
					}
					else if(status==3)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1/d2;
						status=4;
						T1.setText("0");
					}
					else if(status==4)
					{
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d1 = d1/d2;
						status=4;
						T1.setText("0");
					}
				}	
			}
			else if(ae.getSource()==jsqr)
			{
				String s1 = T1.getText();
				d1 = Double.parseDouble(s1);
				d1 = d1*d1;
				T1.setText(""+d1);
			}
			else if(ae.getSource()==jequal)
			{
				//T1.setText(""+d1);
				if(status==0)
				{

				}
				else{
					if(status==1)
					{
						Double d3;
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d3 = d1+d2;
						T1.setText(""+d3);
					}
					else if(status==2)
					{
						Double d3;
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d3 = d1-d2;
						T1.setText(""+d3);
					}
					else if(status==3)
					{
						Double d3;
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d3 = d1*d2;
						T1.setText(""+d3);
					}
					else if(status==4)
					{
						Double d3;
						String s2 = T1.getText();
						d2 = Double.parseDouble(s2);
						d3 = d1/d2;
						T1.setText(""+d3);
					}
				}
				status=0;
			}

	}
	public static void main(String[] args) {
		new calci();
	}
}