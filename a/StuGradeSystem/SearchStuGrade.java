package StuGradeSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
public class SearchStuGrade extends JPanel implements ActionListener{
	//�����ؼ�
	private JTextField field2;
	private JLabel lab2;
	private JComboBox searchcbo2;//�����б�
	private JButton button1;
	//����Vector����
	Vector vector1=new Vector();//��Ч���ӳ���
	Vector vector2=new Vector();
	//�����������
	JScrollPane jspane;
	private JPanel jp=new JPanel();
	//�������
	JTable table;
	public SearchStuGrade(){
		lab2=new JLabel(" ��ѯ����");
		field2=new JTextField("�������ѯ��Ϣ");
		searchcbo2=new JComboBox();
		button1=new JButton("��ѯ");
		searchcbo2.addItem("��ѧ�Ų�ѯ");
		searchcbo2.addItem("��������ѯ");
		//����JPanel�Ĳ��ֹ�����
		jp.setLayout(new FlowLayout());
		//����������ӱ�ǩ�Ͱ�ť
		jp.add(lab2);
		jp.add(field2);
		jp.add(button1);
	    jp.add(searchcbo2);
	    jp.add(button1);
		//���ò��ֹ�����
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.NORTH);
		//��Vector2�����Ԫ��
		vector2.add("ѧ��");
		vector2.add("����");
		vector2.add("רҵ");
		vector2.add("�꼶");
		vector2.add("�γ���");
		vector2.add("�ɼ�");
		//Ϊ��ť���Ӽ���
		button1.addActionListener(this);
		this.setSize(500,500);	
		this.setVisible(true);
	}
	//���Ӽ����¼�
	public void actionPerformed(ActionEvent e)
	{
		String numorname2,searchf2,sql;
		
		numorname2=searchcbo2.getSelectedItem().toString();
		
		searchf2=field2.getText().trim();
		
		{
			
			if(searchf2.equals(""))
				JOptionPane.showMessageDialog(null, "��ѯ��������Ϊ�գ�","��ѯ",JOptionPane.WARNING_MESSAGE);
			else
			   if(numorname2.equals(""))
				 JOptionPane.showMessageDialog(null, "��ѯ��������Ϊ�գ�","��ѯ",JOptionPane.WARNING_MESSAGE);
				else
				{
						try
						{
						String sqlstr ;
						if(numorname2.equals("��ѧ�Ų�ѯ"))
							sqlstr="select number,name,major,grade,course,mark from grade where number='"+searchf2+"'";
						else
							sqlstr="select number,name,major,grade,course,mark from grade where name='"+numorname2+"'";	
					
						//�������ݿ�����
						JdbcFile conn=new JdbcFile();
						//������¼SQL���
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



