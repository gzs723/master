package StuGradeSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Group;
public class GradeMain extends JFrame{

	private JPanel pan=new JPanel();
	private JLabel lbl=new JLabel();
	BorderLayout borderlayout=new BorderLayout();
 
	 
	
	private JMenuBar bar=new JMenuBar();
	private JMenu menu1=new JMenu();
	private JMenu menu2=new JMenu();
	private JMenu menu3=new JMenu();
	private JMenu menu4=new JMenu();
	
	private JMenuItem item1=new JMenuItem();
	private JMenuItem item2=new JMenuItem();
	private JMenuItem item3=new JMenuItem();
	private JMenuItem item4=new JMenuItem();
	
	private JMenuItem item5=new JMenuItem();
	private JMenuItem item6=new JMenuItem();
	private JMenuItem item7=new JMenuItem();
	
	private JMenuItem item8=new JMenuItem();
	private JMenuItem item9=new JMenuItem();
	private JMenuItem item10=new JMenuItem();
	
	private JMenuItem item111=new JMenuItem();
	private JMenuItem item21=new JMenuItem();
	private JMenuItem item31=new JMenuItem();
	private JMenuItem item41=new JMenuItem();
	private JMenuItem item51=new JMenuItem();
	
	
	//go��������Ϊpublic�������ܱ�����
	public void go()
	{
		this.getContentPane();
		this.setLayout(borderlayout);
		this.setJMenuBar(bar);
		
		menu1.setText("�û�����");
		item1.setText("���ѧ��");
		item2.setText("�޸�ѧ����Ϣ");
		item3.setText("ɾ��ѧ��");
		item4.setText("��ѯѧ����Ϣ");
		item111.setText("��ӽ�ʦ");
		item21.setText("�޸Ľ�ʦ��Ϣ");
		item31.setText("ɾ����ʦ");
		item41.setText("��ѯ��ʦ��Ϣ");
		item51.setText("�޸�����");
		
		
		menu2.setText("��ʦ����");
		item5.setText("��ѯѧ���ɼ�");
		item6.setText("����ѧ���ɼ�");
		item7.setText("�޸�����");
		
		menu3.setText("ѧ������");
		item8.setText("��ѯ�ɼ�");
		item9.setText("�޸�����");
		
	
		menu4.setText("�˳�");
		item10.setText("�˳�");	
		
		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);		
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		menu1.add(item111);
		menu1.add(item21);
		menu1.add(item31);
		menu1.add(item41);
		menu1.add(item51);
		
		menu2.add(item5);
		menu2.add(item6);
		menu2.add(item7);
		
		menu3.add(item8);
		menu3.add(item9);
		
		menu4.add(item10);
		
		CardLayout cardlayout=new CardLayout();
		pan.setLayout(cardlayout);
		this.add(pan,BorderLayout.CENTER);
		yy a9=new yy();
		
		pan.add(a9,"111");
		CardLayout ct=(CardLayout)pan.getLayout();
		ct.show(pan, "111");
		
		
		pan.add("�ɼ�����", lbl);
		this.setLocation(550, 200);
		this.setSize(350, 450);
		this.setTitle("ѧ���ɼ�����ϵͳ");
		this.setVisible(true);
		myEvent();
	

	}	
	private void myEvent()
	{
		item1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddStudent studentadd=new AddStudent();
				pan.add(studentadd,"���ѧ��");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "���ѧ��");
			}
		
		});
		
		item2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateStudents studentupdate=new UpdateStudents();
				pan.add(studentupdate,"�޸�ѧ����Ϣ");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "�޸�ѧ����Ϣ");
			}
		
		});
		
		item3.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteStudents studentdelete=new DeleteStudents();
				pan.add(studentdelete,"ɾ��ѧ��");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "ɾ��ѧ��");
			}
		
		});

		item4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchStudents studentssearch=new SearchStudents();
				pan.add(studentssearch,"��ѯѧ����Ϣ");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "��ѯѧ����Ϣ");
			}
		
		});

		item111.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddTeachers teachersadd=new AddTeachers();
				pan.add(teachersadd,"��ӽ�ʦ");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "��ӽ�ʦ");
			}
		
		});
			
		item21.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateTeachers teacherupdate=new UpdateTeachers();
				pan.add(teacherupdate,"�޸Ľ�ʦ��Ϣ");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "�޸Ľ�ʦ��Ϣ");
			}
		
		});
			
		item31.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteTeachers teacherdelete=new DeleteTeachers ();
				pan.add(teacherdelete,"ɾ����ʦ");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "ɾ����ʦ");
			}
		
		});
			
		item41.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchTeachers teachersearch=new SearchTeachers();
				pan.add(teachersearch,"���ͼ����Ϣ");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "���ͼ����Ϣ");
			}
		
		});
			
		item51.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Update1 update1=new Update1();
				pan.add(update1,"�޸�����");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "�޸�����");
			}
		
		});
	item5.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchStuGrade useradd=new SearchStuGrade();
				pan.add(useradd,"��ѯѧ���ɼ�");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "��ѯѧ���ɼ�");
			}
		
		});
		
		item6.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddGarder useradd=new AddGarder();
				pan.add(useradd,"����ѧ���ɼ�");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "����ѧ���ɼ�");
			}
		
		});
		
		
		item7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateTeaPassW useradd=new UpdateTeaPassW();
				pan.add(useradd,"����ѧ���ɼ�");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "����ѧ���ɼ�");
			}
		
		});
			
		
         item8.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchbrGrade useradd=new SearchbrGrade();
				pan.add(useradd,"��ѯ�ɼ�");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "��ѯ�ɼ�");
			}
		
		});
         
         item9.addActionListener(new ActionListener() {
 			
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				UpdateStuPassW useradd=new UpdateStuPassW();
 				pan.add(useradd,"�޸�����");
 				CardLayout ct=(CardLayout)pan.getLayout();
 				ct.show(pan, "�޸�����");
 			}
 		
 		});
		
         
		
		item10.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		
		});
		
	}
}
