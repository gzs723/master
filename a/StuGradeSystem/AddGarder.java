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
		jnumber=new JLabel("ѧ��");
		number=new JTextField();
		jname=new JLabel("����");
		name=new JTextField();
		jmajor=new JLabel("רҵ");
		major=new JTextField();
		jgrade=new JLabel("�꼶");
		grade=new JTextField();
		jcourse=new JLabel("�γ���");
		course=new JTextField();
		jmark=new JLabel("�ɼ�");
		mark=new JTextField();
		button1=new JButton("ȷ��");
		button2=new JButton("ȡ��");
		//���ÿؼ��Ĵ�С��λ��
		jnumber.setBounds(30,20,60,30);
		jname.setBounds(30,70,60,26);
		jmajor.setBounds(30,120,60,26);
		jgrade.setBounds(30,170,60,26);
		jcourse.setBounds(30,220,60,26);
		jmark.setBounds(30,270,60,26);
		//�����ı����λ�úʹ�С
		number.setBounds(110,20,120,26);
		name.setBounds(110,70,120,26);
		major.setBounds(110,120,120,26);
		grade.setBounds(110,170,120,26);
		course.setBounds(110,220,120,26);
		mark.setBounds(110,270,120,26);
		//���ð�ť��λ�úʹ�С
		button1.setBounds(60,320,60,26);
		button2.setBounds(140,320,60,26);
		//���ؼ���ӵ����������
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
					JOptionPane.showMessageDialog(null,"ѧ�Ų���Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
				else
					if(name.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null,"��������Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
					else
						if(major.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null,"רҵ����Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
						else
							if(grade.getText().toString().equals(""))
								JOptionPane.showMessageDialog(null,"�꼶����Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
							else
								if(course.getText().toString().equals(""))
									JOptionPane.showMessageDialog(null,"�γ�������Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
								else
									if(mark.getText().toString().equals(""))
										JOptionPane.showMessageDialog(null,"�ɼ�����Ϊ�գ�","���",JOptionPane.WARNING_MESSAGE);
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
											
												//�������ݿ�����
												JdbcFile conn=new JdbcFile();
												String sqlstr;
												int k=-1;
												//������¼SQL���
												sqlstr="insert into grade(number,name,major,grade,course,mark) values ( '"+strnum+"', '"+strname+"','"+strmajor+"','"+strgrade+"','"+strcourse+"','"+strmark+"')";
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
				major.setText("");
				grade.setText("");
				course.setText("");
				mark.setText("");				
			}			
		});
	}
	
}
