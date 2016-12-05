package StuGradeSystem;


import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.sql.*;
public class SearchTeachers extends JPanel implements ActionListener{
	//声明控件
	private JTextField searchfield;
	private JLabel searchlabel;
	private JComboBox searchcbo;
	private JButton button1;
	//声明Vector变量
	Vector vector1=new Vector();
	Vector vector2=new Vector();
	//声明滚动面板
	JScrollPane jspane;
	private JPanel jp=new JPanel();
	//声明表格
	JTable table;
	
	public SearchTeachers(){
		searchlabel=new JLabel(" 教师信息查询");
		searchfield=new JTextField("请输入查询信息");
		searchcbo=new JComboBox();
		button1=new JButton("查询");
		searchcbo.addItem("按教师编号查询");
		searchcbo.addItem("按姓名查询");
		//设置JPanel的布局管理器
		jp.setLayout(new FlowLayout());
		//向容器中添加标签和按钮
		jp.add(searchlabel);
		jp.add(searchfield);
		jp.add(button1);
		jp.add(searchcbo);
		jp.add(button1);
		//设置布局管理器
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.NORTH);
		//在Vector2中添加元素
		vector2.add("教师编号");
		vector2.add("姓名");
		vector2.add("密码");
		vector2.add("学院");
	
		//为按钮增加监听
		button1.addActionListener(this);
		this.setSize(500,500);		
	}
	//增加监听事件
	public void actionPerformed(ActionEvent e)
	{
		String numorname,searchf,sql;
		numorname=searchcbo.getSelectedItem().toString();
		searchf=searchfield.getText().trim();
		{
			if(searchf.equals(""))
				JOptionPane.showMessageDialog(null, "查询条件不能为空！","查询",JOptionPane.WARNING_MESSAGE);
			else
				if(numorname.equals(""))
					JOptionPane.showMessageDialog(null, "查询条件不能为空！","查询",JOptionPane.WARNING_MESSAGE);
				else
				{
						try
						{
						String sqlstr;
						if(searchf.equals("按教师编号查询"))
							sqlstr="select number,name,password1,yuan from teacher where number='"+searchf+"'";
						else
							
							sqlstr="select number,name,password1,yuan from teacher where name='"+searchf+"'";	
						//创建数据库连接
						JdbcFile conn=new JdbcFile();
						//产生登录SQL语句
						ResultSet result=conn.exexuteQuery(sqlstr);
						if(result.next())
						{
							Vector vector3=new Vector();
							vector3.add(result.getString("number"));
							vector3.add(result.getString("name"));
							vector3.add(result.getString("password1"));
							vector3.add(result.getString("yuan"));
							vector1.add(vector3);
							//创建表格
							table=new JTable(vector1,vector2);
							//创建滚动面板
							jspane=new JScrollPane(table);
							//将面板添加到窗口中
							this.add(jspane,BorderLayout.CENTER);
						}
						else 
							JOptionPane.showMessageDialog(null, "没有该教师信息！","查询",JOptionPane.WARNING_MESSAGE);
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
}

