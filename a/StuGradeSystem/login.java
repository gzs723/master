package StuGradeSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class login extends JFrame{

	private JFrame fr;
	private JLabel lbluser;
	private JLabel lblpassword;
	private JTextField txtuser;
	private JPasswordField txtpassword;
	private JButton btnok;
	private JButton btncancel;
	public login() {
		// TODO Auto-generated constructor stub
		fr=new JFrame("登录");
		lbluser=new JLabel("用户名");
		lblpassword=new JLabel("密码");
		txtuser=new JTextField();
		txtpassword=new JPasswordField();
		btnok=new JButton("确定");
		btncancel=new JButton("取消");
		ImageIcon background = new ImageIcon("");
		fr.setLayout(new GridLayout(3,2,20,20));
		lbluser.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		fr.add(lbluser);
		fr.add(txtuser);
		fr.add(lblpassword);
		fr.add(txtpassword);
		fr.add(btnok);
		fr.add(btncancel);
		fr.setSize(300, 300);
		//设置窗口相对于指定组件的位置。 如果组件当前未显示，或者组件为 null，则此窗口将置于屏幕的中央。
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		myEvent();
	}

	private void myEvent()
	{
		
		btnok.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String struser,strpassword,sqlstr;
				struser=txtuser.getText().trim();
				strpassword=txtpassword.getText().trim();
				Object obj=e.getSource();
				
				try{
					if(obj.equals(btnok))
					{
						if(struser.equals("")||strpassword.equals(""))
							JOptionPane.showMessageDialog(fr, "用户名或密码不能为空");
					
						//建数据库连接
						JdbcFile conn=new JdbcFile();
						//产生登录SQL语句
						
						sqlstr="select * from Admin where num='"+struser+"' and password1='"+strpassword+"'";
						ResultSet result=conn.exexuteQuery(sqlstr);
						if(result.next())
						{
							
						   GradeMain bm=new GradeMain();
						   bm.go();
						   fr.setVisible(false);
						   JOptionPane.showMessageDialog(fr, "登录成功");
						}
					    else
					    	
						JOptionPane.showMessageDialog(fr, "用户名或密码不正确");
					    
					}
					else  if(obj.equals(btncancel))
					{
						System.exit(0);
					}
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
		
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login lg=new login();
	}

}
