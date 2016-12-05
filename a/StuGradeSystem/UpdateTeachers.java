package StuGradeSystem;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateTeachers extends JPanel {
	private JTextField number,name,college,password;
	private JLabel jnumber,jname,jpassword,jcollege;
	private JButton button1,button2;
	
	public UpdateTeachers()
	{
		//���ɿؼ�
		this.setLayout(null);
		jnumber=new JLabel("��ʦ���");
		number=new JTextField();
		jname=new JLabel("����");
		name=new JTextField();
		jpassword=new JLabel("����");
		password=new JTextField();
		jcollege=new JLabel("ѧԺ");
		college=new JTextField();
		button1=new JButton("��ѯ");
		button2=new JButton("�޸�");
		//���ÿؼ��Ĵ�С��λ��
		jnumber.setBounds(30,20,60,26);
		jname.setBounds(30,100,60,26);
		jpassword.setBounds(30,130,60,26);
		jcollege.setBounds(30,160,60,26);
		
		
		number.setBounds(110,20,120,26);
		name.setBounds(110,100,120,26);
		password.setBounds(110,130,120,26);
		college.setBounds(110,160,120,26);
		
		button1.setBounds(60,60,60,30);
		button2.setBounds(60,250,60,26);
		
		//�����ı��������Ϊ���ɱ༭
		name.setEnabled(false);
		password.setEnabled(false);
		college.setEnabled(false);
		
		//���ؼ���ӵ�������
		this.add(jnumber);
		this.add(number);
		this.add(button1);
		this.add(jname);
		this.add(name);
		this.add(jpassword);
		this.add(password);
		this.add(jcollege);
		this.add(college);
		this.add(button2);
		setSize(250,400);
		this.setVisible(true);
		myEvent();
	}
	
	private void myEvent()
	{
		//Ϊbutton1���Ӽ���
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(number.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "��ʦ��Ų���Ϊ��","�޸�",JOptionPane.WARNING_MESSAGE);
				else
				{
					try{
						
						String sqlstr,strnum;
						strnum=number.getText().toString().trim();
						sqlstr="select number,name,password1,yuan from teacher where number='"+strnum+"'";
					//�������ݿ�����
					JdbcFile conn=new JdbcFile();
					//������¼SQL���
					ResultSet result=conn.exexuteQuery(sqlstr);
					if(result.next())
					{
						number.setText(result.getString("number"));
						name.setText(result.getString("name"));
						password.setText(result.getString("password1"));
						college.setText(result.getString("yuan"));
						
						name.setEnabled(true);
						password.setEnabled(true);
						college.setEnabled(true);
						
					}
					else
						JOptionPane.showMessageDialog(null, "û�иý�ʦ��ŵ��û�","�޸�",JOptionPane.WARNING_MESSAGE);
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
		
		//Ϊbutton2���Ӽ���
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(number.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "��ʦ��Ų���Ϊ��","�޸�",JOptionPane.WARNING_MESSAGE);	
				else
					if(name.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "��������Ϊ��","�޸�",JOptionPane.WARNING_MESSAGE);	
					else
						if(password.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "���벻��Ϊ��","�޸�",JOptionPane.WARNING_MESSAGE);	
						else
							if(college.getText().toString().equals(""))
								JOptionPane.showMessageDialog(null, "ѧԺ����Ϊ��","�޸�",JOptionPane.WARNING_MESSAGE);	
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
												
												//�������ݿ�����
												JdbcFile conn=new JdbcFile();
												//������¼SQL���
												strsql="update teacher set name='"+strname+"',password1='"+strpassword+"',yuan='"+strcollege+"'";
												k=conn.update(strsql);
												if(k>0)
													if(k>0)
														JOptionPane.showMessageDialog(null,"�޸Ľ�ʦ��Ϣ�ɹ���","�޸�",JOptionPane.WARNING_MESSAGE);
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
