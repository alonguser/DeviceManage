package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	private static String DRIVER="com.mysql.cj.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/db_device?useSSL=false&serverTimezone=GMT";
	private static String USER="root";
	private static String PWD="901399";
	protected Connection con=null;
	//protected Statement st=null;
	protected PreparedStatement pstm=null;
	protected ResultSet rs=null;
	//�������ݿ�����
	public void getConnection() {		
		
			try {
				//��һ�������ز�ע����������
				Class.forName(DRIVER);
				//�ڶ���������һ�� Connection ����
				con=DriverManager.getConnection(URL, USER, PWD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("δ������������");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("���ݿ����Ӳ��ɹ���");
				e.printStackTrace();
			}	
	}
	//�رմ򿪵�����
	public void closeAll()  {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstm!=null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if(con!=null&&con.isClosed()!=true) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
