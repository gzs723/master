package StuGradeSystem;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class AddGarder extends JPanel {
	private JTextField  number,name,major,grade,course,mark;
	private JLabel jnumber,jname,jmajor,jgrade,jcourse,jmark;
	private JPasswordField password;
	private JButton button1,button2;
	public  AddGarder()
	{
		this.setLayout(null);
		jnumber=new JLabel("学号");
		number=new JTextField();
		jname=new JLabel("姓名");
		name=new JTextField();
		jmajor=new JLabel("专业");
		major=new JTextField();
		jgrade=new JLabel("年级");
		grade=new JTextField();
		jcourse=new JLabel("课程名");
		course=new JTextField();
		jmark=new JLabel("成绩");
		mark=new JTextField();
		button1=new JButton("确定");
		button2=new JButton("取消");
		//设置控件的大小和位置
		jnumber.setBounds(30,20,60,30);
		jname.setBounds(30,70,60,26);
		jmajor.setBounds(30,120,60,26);
		jgrade.setBounds(30,170,60,26);
		jcourse.setBounds(30,220,60,26);
		jmark.setBounds(30,270,60,26);
		//设置文本框的位置和大小
		number.setBounds(110,20,120,26);
		name.setBounds(110,70,120,26);
		major.setBounds(110,120,120,26);
		grade.setBounds(110,170,120,26);
		course.setBounds(110,220,120,26);
		mark.setBounds(110,270,120,26);
		//设置按钮的位置和大小
		button1.setBounds(60,320,60,26);
		button2.setBounds(140,320,60,26);
		//将控件添加到面板容器中
		this.add(jnumber);
		this.add(number);
		this.add(jname);
		this.add(name);
		this.add(jmajor);
		this.add(major);
		this.add(jgrade);
		this.add(grade);
		this.add(jcourse);
		this.add(course);
		this.add(jmark);
		this.add(mark);
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
						if(major.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null,"专业不能为空！","添加",JOptionPane.WARNING_MESSAGE);
						else
							if(grade.getText().toString().equals(""))
								JOptionPane.showMessageDialog(null,"年级不能为空！","添加",JOptionPane.WARNING_MESSAGE);
							else
								if(course.getText().toString().equals(""))
									JOptionPane.showMessageDialog(null,"课程名不能为空！","添加",JOptionPane.WARNING_MESSAGE);
								else
									if(mark.getText().toString().equals(""))
										JOptionPane.showMessageDialog(null,"成绩不能为空！","添加",JOptionPane.WARNING_MESSAGE);
									else
										{
										
											try
											{
												String strnum=number.getText().toString();
												String strname=name.getText().toString();
												String strmajor=major.getText().toString();
												String strgrade=grade.getText().toString();
												String strcourse=course.getText().toString();
												String strmark=mark.getText().toString();
											
												//创建数据库连接
												JdbcFile conn=new JdbcFile();
												String sqlstr;
												int k=-1;
												//产生登录SQL语句
												sqlstr="insert into grade(number,name,major,grade,course,mark) values ( '"+strnum+"', '"+strname+"','"+strmajor+"','"+strgrade+"','"+strcourse+"','"+strmark+"')";
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
				major.setText("");
				grade.setText("");
				course.setText("");
				mark.setText("");				
			}			
		});
	}
	
}
