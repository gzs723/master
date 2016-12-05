package StuGradeSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcFile {
	Statement stmt;
	Connection conn;
	int value=-1;
	public JdbcFile() throws Exception
	{
		try{
		String drivername="sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(drivername);
		String url="jdbc:odbc:StuGradeSystemDB";
		conn=DriverManager.getConnection(url);
		 stmt=conn.createStatement();
		}catch(SQLException e)
		{
			throw new Exception("���ݿ�����δ�ҵ�"+e.getMessage());
		}catch(ClassNotFoundException ex)
		{
			throw new Exception("���ݿ�δ����"+ex.getMessage());
		}
	}
	
	public synchronized ResultSet exexuteQuery(String sql) throws Exception
	{
		ResultSet rs=stmt.executeQuery(sql);
		return rs;
	}
	
	public  synchronized int insert(String sql) throws Exception
	{
		value=stmt.executeUpdate(sql);
		return value;
	}
	
	public synchronized int update(String sql) throws Exception
	{
		value=stmt.executeUpdate(sql);
		return value;
	}
	
	public synchronized int delete(String sql) throws Exception
	{
		value=stmt.executeUpdate(sql);
		return value;
	}
	
	public void close()throws Exception
	{
		conn.close();
	}
}