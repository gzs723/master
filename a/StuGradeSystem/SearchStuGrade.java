package StuGradeSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
public class SearchStuGrade extends JPanel implements ActionListener{
	//声明控件
	private JTextField field2;
	private JLabel lab2;
	private JComboBox searchcbo2;//下拉列表
	private JButton button1;
	//声明Vector变量
	Vector vector1=new Vector();//高效增加长度
	Vector vector2=new Vector();
	//声明滚动面板
	JScrollPane jspane;
	private JPanel jp=new JPanel();
	//声明表格
	JTable table;
	public SearchStuGrade(){
		lab2=new JLabel(" 查询条件");
		field2=new JTextField("请输入查询信息");
		searchcbo2=new JComboBox();
		button1=new JButton("查询");
		searchcbo2.addItem("按学号查询");
		searchcbo2.addItem("按姓名查询");
		//设置JPanel的布局管理器
		jp.setLayout(new FlowLayout());
		//向容器中添加标签和按钮
		jp.add(lab2);
		jp.add(field2);
		jp.add(button1);
	    jp.add(searchcbo2);
	    jp.add(button1);
		//设置布局管理器
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.NORTH);
		//在Vector2中添加元素
		vector2.add("学号");
		vector2.add("姓名");
		vector2.add("专业");
		vector2.add("年级");
		vector2.add("课程名");
		vector2.add("成绩");
		//为按钮增加监听
		button1.addActionListener(this);
		this.setSize(500,500);	
		this.setVisible(true);
	}
	//增加监听事件
	public void actionPerformed(ActionEvent e)
	{
		String numorname2,searchf2,sql;
		
		numorname2=searchcbo2.getSelectedItem().toString();
		
		searchf2=field2.getText().trim();
		
		{
			
			if(searchf2.equals(""))
				JOptionPane.showMessageDialog(null, "查询条件不能为空！","查询",JOptionPane.WARNING_MESSAGE);
			else
			   if(numorname2.equals(""))
				 JOptionPane.showMessageDialog(null, "查询条件不能为空！","查询",JOptionPane.WARNING_MESSAGE);
				else
				{
						try
						{
						String sqlstr ;
						if(numorname2.equals("按学号查询"))
							sqlstr="select number,name,major,grade,course,mark from grade where number='"+searchf2+"'";
						else
							sqlstr="select number,name,major,grade,course,mark from grade where name='"+numorname2+"'";	
					
						//创建数据库连接
						JdbcFile conn=new JdbcFile();
						//产生登录SQL语句
						ResultSet result=conn.exexuteQuery(sqlstr);
						if(result.next())
						{
							Vector vector3=new Vector();
							vector3.add(result.getString("number"));
							vector3.add(result.getString("name"));
							vector3.add(result.getString("major"));
							vector3.add(result.getString("grade"));
							vector3.add(result.getString("course"));
							vector3.add(result.getString("mark"));
							vector1.add(vector3);
							//创建表格
							table=new JTable(vector1,vector2);
							//创建滚动面板
							jspane=new JScrollPane(table);
							//将面板添加到窗口中
							this.add(jspane,BorderLayout.CENTER);
						}
						else 
							JOptionPane.showMessageDialog(null, "没有该学生信息！","查询",JOptionPane.WARNING_MESSAGE);
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



