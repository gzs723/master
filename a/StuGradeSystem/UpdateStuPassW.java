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
		//���ɿؼ�
		this.setLayout(null);
		jnumber=new JLabel("ѧ��");
		number=new JTextField();
		jpassword=new JLabel("����");
		password=new JTextField();
		
		button1=new JButton("��ѯ");
		button2=new JButton("�޸�");
		//���ÿؼ��Ĵ�С��λ��
		jnumber.setBounds(30,20,60,26);
		jpassword.setBounds(30,130,60,26);
		
		number.setBounds(110,20,120,26);
		password.setBounds(110,130,120,26);

		button1.setBounds(60,60,60,30);
		button2.setBounds(60,250,60,26);
		
		//�����ı��������Ϊ���ɱ༭
		//password.setEnabled(false);

		//���ؼ���ӵ�������
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
		//Ϊbutton1���Ӽ���
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(number.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��","�޸�",JOptionPane.WARNING_MESSAGE);
				else
				{
					try{
						
						String sqlstr,strnum;
						strnum=number.getText().toString().trim();
						sqlstr="select *from users where number='"+strnum+"'";
					//�������ݿ�����
					JdbcFile conn=new JdbcFile();
					//������¼SQL���
					ResultSet result=conn.exexuteQuery(sqlstr);
					if(result.next())
					{
						number.setText(result.getString("number"));
						password.setText(result.getString("password1"));
			
					
						password.setEnabled(true);
					
					}
					else
						JOptionPane.showMessageDialog(null, "û�и�ѧ�ŵ�ѧ��","�޸�",JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��","�޸�",JOptionPane.WARNING_MESSAGE);	
				
					else
						if(password.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "���벻��Ϊ��","�޸�",JOptionPane.WARNING_MESSAGE);	
						
									else
										{
											try
											{
												String strname,strnum,strpassword,strcollege,strsubject,strgrade,strsql;
												int k=-1;
											
												strnum=number.getText().toString();
												strpassword=password.getText().toString();
												
												//�������ݿ�����
												JdbcFile conn=new JdbcFile();
												//������¼SQL���
												strsql="update users set password1='"+strpassword+"'where number='"+strnum+"'";
												k=conn.update(strsql);
												if(k>0)
													if(k>0)
														JOptionPane.showMessageDialog(null,"�޸�����ɹ���","�޸�",JOptionPane.WARNING_MESSAGE);
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