package StuGradeSystem;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class AddTeachers extends JPanel {
	private JTextField number,name,college;
	private JLabel Tnumber,Tname,Tcollege,Tpassword;
	private JPasswordField password;
	private JButton button1,button2;
	
	public  AddTeachers()
	{
		this.setLayout(null);
		Tnumber=new JLabel("教师编号");
		number=new JTextField();
		Tname=new JLabel("姓名");
		name=new JTextField();
		Tpassword=new JLabel("密码");
		password=new JPasswordField();
		Tcollege=new JLabel("学院");
		college=new JTextField();
		button1=new JButton("确定");
		button2=new JButton("取消");
		//设置标签的位置和大小
		Tnumber.setBounds(30,20,60,30);
		Tname.setBounds(30,70,60,26);
		Tpassword.setBounds(30,120,60,26);
		Tcollege.setBounds(30,170,60,26);
        //设置文本框的位置和大小
		number.setBounds(110,20,120,26);
		name.setBounds(110,70,120,26);
		password.setBounds(110,120,120,26);
		college.setBounds(110,170,120,26);
		//设置按钮的位置和大小
		button1.setBounds(60,320,60,26);
		button2.setBounds(140,320,60,26);
		//将控件添加到面板容器中
		this.add(Tnumber);
		this.add(number);
		this.add(Tname);
		this.add(name);
		this.add(Tpassword);
		this.add(password);
		this.add(Tcollege);
		this.add(college);
		this.add(button1);
		this.add(button2);
		setSize(250,400);
        this.setVisible(true);
         myEvent();
	}
	
	private void myEvent()
	{
		
		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(number.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null,"学号不能为空！","添加",JOptionPane.WARNING_MESSAGE);
				else
					if(name.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null,"姓名不能为空！","添加",JOptionPane.WARNING_MESSAGE);
					else
						if(password.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null,"密码不能为空！","添加",JOptionPane.WARNING_MESSAGE);
						else
							if(college.getText().toString().equals(""))
								JOptionPane.showMessageDialog(null,"学院不能为空！","添加",JOptionPane.WARNING_MESSAGE);
									else
										{
										
											try
											{
												String strnum=number.getText().toString();
												String strname=name.getText().toString();
												String strpassword=password.getText().toString();
												String strcollege=college.getText().toString();								
											
												//创建数据库连接
												JdbcFile conn=new JdbcFile();
												String sqlstr;
												int k=-1;
												//产生登录SQL语句
												sqlstr="insert into teacher(number,name,password1,yuan) values ( '"+strnum+"', '"+strname+"','"+strpassword+"','"+strcollege+"')";
												k=conn.insert(sqlstr);
												if(k>0)
													JOptionPane.showMessageDialog(null,"添加用户成功！","添加",JOptionPane.WARNING_MESSAGE);
												else
													JOptionPane.showMessageDialog(null,"添加用户失败！","添加",JOptionPane.WARNING_MESSAGE);
											}catch(SQLException ex)
											{
												System.out.println(ex);
											}catch(ClassNotFoundException ce)
											{
												System.out.println("SQLException:"+ce.getMessage());
											}catch(Exception s){
												s.printStackTrace();				
											}
										}
			}
			
		}
		);
		
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				number.setText("");
				name.setText("");
				password.setText("");
				college.setText("");
					
			}			
		});
	}
	
}


