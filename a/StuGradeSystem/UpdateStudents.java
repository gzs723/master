package StuGradeSystem;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateStudents extends JPanel {
	private JTextField number,name,college,subject,grade,password;
	private JLabel jnumber,jname,jpassword,jcollege,jsubject,jgrade;
	private JButton button1,button2;
	
	public UpdateStudents()
	{
		//生成控件
		this.setLayout(null);
		jnumber=new JLabel("学号");
		number=new JTextField();
		jname=new JLabel("姓名");
		name=new JTextField();
		jpassword=new JLabel("密码");
		password=new JTextField();
		jcollege=new JLabel("学院");
		college=new JTextField();
		jsubject=new JLabel("专业");
		subject=new JTextField();
		jgrade=new JLabel("年级");
		grade=new JTextField();
		button1=new JButton("查询");
		button2=new JButton("修改");
		//设置控件的大小和位置
		jnumber.setBounds(30,20,60,26);
		jname.setBounds(30,100,60,26);
		jpassword.setBounds(30,130,60,26);
		jcollege.setBounds(30,160,60,26);
		jsubject.setBounds(30,190,60,26);
		jgrade.setBounds(30,220,60,26);
		
		number.setBounds(110,20,120,26);
		name.setBounds(110,100,120,26);
		password.setBounds(110,130,120,26);
		college.setBounds(110,160,120,26);
		subject.setBounds(110,190,120,26);
		grade.setBounds(110,220,120,26);
		
		button1.setBounds(60,60,60,30);
		button2.setBounds(60,250,60,26);
		
		//设置文本框的属性为不可编辑
		name.setEnabled(false);
		password.setEnabled(false);
		college.setEnabled(false);
		subject.setEnabled(false);
		grade.setEnabled(false);
		//将控件添加到容器中
		this.add(jnumber);
		this.add(number);
		this.add(button1);
		this.add(jname);
		this.add(name);
		this.add(jpassword);
		this.add(password);
		this.add(jcollege);
		this.add(college);
		this.add(jsubject);
		this.add(subject);
		this.add(jgrade);
		this.add(grade);
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
						sqlstr="select number,name,password1,college,subject,grade from users where number='"+strnum+"'";
					//创建数据库连接
					JdbcFile conn=new JdbcFile();
					//产生登录SQL语句
					ResultSet result=conn.exexuteQuery(sqlstr);
					if(result.next())
					{
						number.setText(result.getString("number"));
						name.setText(result.getString("name"));
						password.setText(result.getString("password1"));
						college.setText(result.getString("college"));
						subject.setText(result.getString("subject"));
						grade.setText(result.getString("grade"));
						
						name.setEnabled(true);
						password.setEnabled(true);
						college.setEnabled(true);
						subject.setEnabled(true);
						grade.setEnabled(true);
					}
					else
						JOptionPane.showMessageDialog(null, "没有该学号的用户","修改",JOptionPane.WARNING_MESSAGE);
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
					if(name.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "姓名不能为空","修改",JOptionPane.WARNING_MESSAGE);	
					else
						if(password.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "密码不能为空","修改",JOptionPane.WARNING_MESSAGE);	
						else
							if(college.getText().toString().equals(""))
								JOptionPane.showMessageDialog(null, "学院不能为空","修改",JOptionPane.WARNING_MESSAGE);	
							else
								if(subject.getText().toString().equals(""))
									JOptionPane.showMessageDialog(null, "专业不能为空","修改",JOptionPane.WARNING_MESSAGE);	
								else
									if(grade.getText().toString().equals(""))
										JOptionPane.showMessageDialog(null, "年级不能为空","修改",JOptionPane.WARNING_MESSAGE);	
									else
										{
											try
											{
												String strname,strnum,strpassword,strcollege,strsubject,strgrade,strsql;
												int k=-1;
												strname=name.getText().toString();
												strnum=number.getText().toString();
												strpassword=password.getText().toString();
												strcollege=college.getText().toString();
												strsubject=subject.getText().toString();
												strgrade=grade.getText().toString();
												//创建数据库连接
												JdbcFile conn=new JdbcFile();
												//产生登录SQL语句
												strsql="update users set name='"+strname+"',password1='"+strpassword+"',college='"+strcollege+"',subject='"+strsubject+"',grade='"+strgrade+"' where number='"+strnum+"'";
												k=conn.update(strsql);
												if(k>0)
													if(k>0)
														JOptionPane.showMessageDialog(null,"修改用户信息成功！","修改",JOptionPane.WARNING_MESSAGE);
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
