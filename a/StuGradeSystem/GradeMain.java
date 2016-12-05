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
	
	
	//go方法必须为public，否则不能被调用
	public void go()
	{
		this.getContentPane();
		this.setLayout(borderlayout);
		this.setJMenuBar(bar);
		
		menu1.setText("用户管理");
		item1.setText("添加学生");
		item2.setText("修改学生信息");
		item3.setText("删除学生");
		item4.setText("查询学生信息");
		item111.setText("添加教师");
		item21.setText("修改教师信息");
		item31.setText("删除教师");
		item41.setText("查询教师信息");
		item51.setText("修改密码");
		
		
		menu2.setText("教师管理");
		item5.setText("查询学生成绩");
		item6.setText("输入学生成绩");
		item7.setText("修改密码");
		
		menu3.setText("学生管理");
		item8.setText("查询成绩");
		item9.setText("修改密码");
		
	
		menu4.setText("退出");
		item10.setText("退出");	
		
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
		
		
		pan.add("成绩管理", lbl);
		this.setLocation(550, 200);
		this.setSize(350, 450);
		this.setTitle("学生成绩管理系统");
		this.setVisible(true);
		myEvent();
	

	}	
	private void myEvent()
	{
		item1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddStudent studentadd=new AddStudent();
				pan.add(studentadd,"添加学生");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "添加学生");
			}
		
		});
		
		item2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateStudents studentupdate=new UpdateStudents();
				pan.add(studentupdate,"修改学生信息");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "修改学生信息");
			}
		
		});
		
		item3.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteStudents studentdelete=new DeleteStudents();
				pan.add(studentdelete,"删除学生");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "删除学生");
			}
		
		});

		item4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchStudents studentssearch=new SearchStudents();
				pan.add(studentssearch,"查询学生信息");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "查询学生信息");
			}
		
		});

		item111.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddTeachers teachersadd=new AddTeachers();
				pan.add(teachersadd,"添加教师");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "添加教师");
			}
		
		});
			
		item21.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateTeachers teacherupdate=new UpdateTeachers();
				pan.add(teacherupdate,"修改教师信息");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "修改教师信息");
			}
		
		});
			
		item31.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteTeachers teacherdelete=new DeleteTeachers ();
				pan.add(teacherdelete,"删除教师");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "删除教师");
			}
		
		});
			
		item41.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchTeachers teachersearch=new SearchTeachers();
				pan.add(teachersearch,"添加图书信息");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "添加图书信息");
			}
		
		});
			
		item51.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Update1 update1=new Update1();
				pan.add(update1,"修改密码");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "修改密码");
			}
		
		});
	item5.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchStuGrade useradd=new SearchStuGrade();
				pan.add(useradd,"查询学生成绩");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "查询学生成绩");
			}
		
		});
		
		item6.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddGarder useradd=new AddGarder();
				pan.add(useradd,"输入学生成绩");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "输入学生成绩");
			}
		
		});
		
		
		item7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateTeaPassW useradd=new UpdateTeaPassW();
				pan.add(useradd,"输入学生成绩");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "输入学生成绩");
			}
		
		});
			
		
         item8.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchbrGrade useradd=new SearchbrGrade();
				pan.add(useradd,"查询成绩");
				CardLayout ct=(CardLayout)pan.getLayout();
				ct.show(pan, "查询成绩");
			}
		
		});
         
         item9.addActionListener(new ActionListener() {
 			
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				UpdateStuPassW useradd=new UpdateStuPassW();
 				pan.add(useradd,"修改密码");
 				CardLayout ct=(CardLayout)pan.getLayout();
 				ct.show(pan, "修改密码");
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
