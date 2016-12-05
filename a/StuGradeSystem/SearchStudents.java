package StuGradeSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
public class SearchStudents extends JPanel implements ActionListener{
	//�����ؼ�
	private JTextField searchfield;
	private JLabel searchlabel;
	private JComboBox searchcbo;
	private JButton button1;
	//����Vector����
	Vector vector1=new Vector();
	Vector vector2=new Vector();
	//�����������
	JScrollPane jspane;
	private JPanel jp=new JPanel();
	//�������
	JTable table;
	
	public SearchStudents(){
		searchlabel=new JLabel(" ѧ����Ϣ��ѯ");
		searchfield=new JTextField("�������ѯ��Ϣ");
		searchcbo=new JComboBox();
		button1=new JButton("��ѯ");
		searchcbo.addItem("��ѧ�Ų�ѯ");
		searchcbo.addItem("��������ѯ");
		//����JPanel�Ĳ��ֹ�����
		jp.setLayout(new FlowLayout());
		//����������ӱ�ǩ�Ͱ�ť
		jp.add(searchlabel);
		jp.add(searchfield);
		jp.add(button1);
		jp.add(searchcbo);
		jp.add(button1);
		//���ò��ֹ�����
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.NORTH);
		//��Vector2�����Ԫ��
		vector2.add("ѧ��");
		vector2.add("����");
		vector2.add("����");
		vector2.add("ѧԺ");
		vector2.add("רҵ");
		vector2.add("�꼶");
		//Ϊ��ť���Ӽ���
		button1.addActionListener(this);
		this.setSize(500,500);		
	}
	//���Ӽ����¼�
	public void actionPerformed(ActionEvent e)
	{
		String numorname,searchf,sql;
		
		numorname=searchcbo.getSelectedItem().toString();
		searchf=searchfield.getText().trim();
		{
			if(searchf.equals(""))
				JOptionPane.showMessageDialog(null, "��ѯ��������Ϊ�գ�","��ѯ",JOptionPane.WARNING_MESSAGE);
			else
				if(numorname.equals(""))
					JOptionPane.showMessageDialog(null, "��ѯ��������Ϊ�գ�","��ѯ",JOptionPane.WARNING_MESSAGE);
				else
				{
						try
						{
						String sqlstr;
						if(searchf.equals("��ѧ�Ų�ѯ"))
							sqlstr="select number,name,password1,college,subject,grade from users where number='"+searchf+"'";
						else 
							sqlstr="select number,name,password1,college,subject,grade from users where name='"+searchf+"'";	
						//�������ݿ�����
						JdbcFile conn=new JdbcFile();
						//������¼SQL���
						ResultSet result=conn.exexuteQuery(sqlstr);
						if(result.next())
						{
							Vector vector3=new Vector();
							vector3.add(result.getString("number"));
							vector3.add(result.getString("name"));
							vector3.add(result.getString("password1"));
							vector3.add(result.getString("college"));
							vector3.add(result.getString("subject"));
							vector3.add(result.getString("grade"));
							vector1.add(vector3);
							//�������
							table=new JTable(vector1,vector2);
							//�����������
							jspane=new JScrollPane(table);
							//�������ӵ�������
							this.add(jspane,BorderLayout.CENTER);
						}
						else 
							JOptionPane.showMessageDialog(null, "û�и�ѧ����Ϣ��","��ѯ",JOptionPane.WARNING_MESSAGE);
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

