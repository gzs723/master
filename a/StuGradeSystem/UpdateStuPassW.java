package StuGradeSystem;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateStuPassW extends JPanel {
	private JTextField number, password;
	private JLabel jnumber,jpassword;
	
	private JButton button1,button2;
	
	public UpdateStuPassW()
	{
		//生成控件
		this.setLayout(null);
		jnumber=new JLabel("学号");
		number=new JTextField();
		jpassword=new JLabel("密码");
		password=new JTextField();
		
		button1=new JButton("查询");
		button2=new JButton("修改");
		//设置控件的大小和位置
		jnumber.setBounds(30,20,60,26);
		jpassword.setBounds(30,130,60,26);
		
		number.setBounds(110,20,120,26);
		password.setBounds(110,130,120,26);

		button1.setBounds(60,60,60,30);
		button2.setBounds(60,250,60,26);
		
		//设置文本框的属性为不可编辑
		//password.setEnabled(false);

		//将控件添加到容器中
		this.add(jnumber);
		this.add(number);
		this.add(button1);
		this.add(jpassword);
		this.add(password);
		this.add(button2);
		setSize(250,400);
		this.setVisible(true);
		myEvent();
	}
	
	private void myEvent()
	{
		//为button1增加监听
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(number.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "学号不能为空","修改",JOptionPane.WARNING_MESSAGE);
				else
				{
					try{
						
						String sqlstr,strnum;
						strnum=number.getText().toString().trim();
						sqlstr="select *from users where number='"+strnum+"'";
					//创建数据库连接
					JdbcFile conn=new JdbcFile();
					//产生登录SQL语句
					ResultSet result=conn.exexuteQuery(sqlstr);
					if(result.next())
					{
						number.setText(result.getString("number"));
						password.setText(result.getString("password1"));
			
					
						password.setEnabled(true);
					
					}
					else
						JOptionPane.showMessageDialog(null, "没有该学号的学生","修改",JOptionPane.WARNING_MESSAGE);
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
			
		});
		
		//为button2增加监听
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(number.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "学号不能为空","修改",JOptionPane.WARNING_MESSAGE);	
				
					else
						if(password.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "密码不能为空","修改",JOptionPane.WARNING_MESSAGE);	
						
									else
										{
											try
											{
												String strname,strnum,strpassword,strcollege,strsubject,strgrade,strsql;
												int k=-1;
											
												strnum=number.getText().toString();
												strpassword=password.getText().toString();
												
												//创建数据库连接
												JdbcFile conn=new JdbcFile();
												//产生登录SQL语句
												strsql="update users set password1='"+strpassword+"'where number='"+strnum+"'";
												k=conn.update(strsql);
												if(k>0)
													if(k>0)
														JOptionPane.showMessageDialog(null,"修改密码成功！","修改",JOptionPane.WARNING_MESSAGE);
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
		});
		
		
	}
			
}