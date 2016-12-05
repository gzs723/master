package StuGradeSystem;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class AddStudent extends JPanel {
	private JTextField number,name,college,subject,grade;
	private JLabel jnumber,jname,jcollege,jsubject,jgrade,jpassword;
	private JPasswordField password;
	private JButton button1,button2;
	
	public  AddStudent()
	{
		this.setLayout(null);
		jnumber=new JLabel("ѧ��");
		number=new JTextField();
		jname=new JLabel("����");
		name=new JTextField();
		jpassword=new JLabel("����");
		password=new JPasswordField();
		jcollege=new JLabel("ѧԺ");
		college=new JTextField();
		jsubject=new JLabel("רҵ");
		subject=new JTextField();
		jgrade=new JLabel("�꼶");
		grade=new JTextField();
		button1=new JButton("ȷ��");
		button2=new JButton("ȡ��");
		
		//���ñ�ǩ��λ�úʹ�С
		jnumber.setBounds(30,20,60,30);
		jname.setBounds(30,70,60,26);
		jpassword.setBounds(30,120,60,26);
		jcollege.setBounds(30,170,60,26);
		jsubject.setBounds(30,220,60,26);
		jgrade.setBounds(30,270,60,26);
		//�����ı����λ�úʹ�С
		number.setBounds(110,20,120,26);
		name.setBounds(110,70,120,26);
		password.setBounds(110,120,120,26);
		college.setBounds(110,170,120,26);
		subject.setBounds(110,220,120,26);
		grade.setBounds(110,270,120,26);
		//���ð�ť��λ�úʹ�С
		button1.setBounds(60,320,60,26);
		button2.setBounds(140,320,60,26);
		//���ؼ���ӵ����������
		this.add(jnumber);
		this.add(number);
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
					JOptionPane.showMessageDialog(null,"ѧ�Ų���Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
				else
					if(name.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null,"��������Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
					else
						if(password.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
						else
							if(college.getText().toString().equals(""))
								JOptionPane.showMessageDialog(null,"ѧԺ����Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
							else
								if(subject.getText().toString().equals(""))
									JOptionPane.showMessageDialog(null,"רҵ����Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
								else
									if(grade.getText().toString().equals(""))
										JOptionPane.showMessageDialog(null,"�꼶����Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
									else
										{
										
											try
											{
												String strnum=number.getText().toString();
												String strname=name.getText().toString();
												String strpassword=password.getText().toString();
												String strcollege=college.getText().toString();
												String strsubject=subject.getText().toString();
												String strgrade=grade.getText().toString();
											
												//�������ݿ�����
												JdbcFile conn=new JdbcFile();
												String sqlstr;
												int k=-1;
												//������¼SQL���
												sqlstr="insert into users(number,name,password1,college,subject,grade) values ( '"+strnum+"', '"+strname+"','"+strpassword+"','"+strcollege+"','"+strsubject+"','"+strgrade+"')";
												k=conn.insert(sqlstr);
												if(k>0)
													JOptionPane.showMessageDialog(null,"����û��ɹ���","���",JOptionPane.WARNING_MESSAGE);
												else
													JOptionPane.showMessageDialog(null,"����û�ʧ�ܣ�","���",JOptionPane.WARNING_MESSAGE);
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
				subject.setText("");
				grade.setText("");				
			}			
		});
	}
	
}
