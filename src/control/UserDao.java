package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DeviceBean;
import model.UserBean;

public class UserDao extends BaseDao{
	
	// ���ѧ����Ϣ
		public int addStudent(String stuId, String password, String stuName, String pro, String phone) {
			int row = 0;
			// ��һ���͵ڶ���ͨ���̳и���ķ��������
			super.getConnection();
			try {
				// ������������һ�� Statement ����
				String sql = "INSERT INTO user(stuId,password,stuName,pro,phone)VALUES(?,?,?,?,?)";
				pstm=con.prepareStatement(sql);
				//st = con.createStatement();
				
				pstm.setString(1, stuId);
				pstm.setString(2, password);
				pstm.setString(3, stuName);
				pstm.setString(4,pro);
				pstm.setString(5, phone);
				// ���Ĳ������Ͳ�ִ��sql���
				//row = st.executeUpdate(sql);
				row=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// �Ͽ������ݿ�����Ӳ���ͨ�����ø���ķ��������
				super.closeAll();
			}
			return row;
		}

		public int addStudent(UserBean user) {
			int row = 0;
			// ��һ���͵ڶ���ͨ���̳и���ķ��������
			super.getConnection();
			try {
				// ������������һ�� Statement ����
				//st = con.createStatement();
				String sql = "INSERT INTO user(stuId,password,stuName,pro,phone)VALUES(?,?,?,?,?)";
				pstm=con.prepareStatement(sql);
				// ���Ĳ������Ͳ�ִ��sql���
				
				pstm.setString(1, user.getStuId());
				pstm.setString(2, user.getPassword());
				pstm.setString(3, user.getStuName());
				pstm.setString(4, user.getPro());
				pstm.setString(5, user.getPhone());
				row=pstm.executeUpdate();
				//row = st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// �Ͽ������ݿ�����Ӳ���ͨ�����ø���ķ��������
				super.closeAll();
			}
			return row;
		}
		
		//��ѯ����ѧ����Ϣ
				public UserBean stuLogin(String stuId) {
					UserBean user=null;
					super.getConnection();		
					try {
						//������������PreparedStatement����
						String sql="select stuName,password from user where stuId=?";
						pstm=con.prepareStatement(sql);
						pstm.setString(1, stuId);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							user=new UserBean();
							user.setStuName(rs.getString("stuName"));
							user.setPassword(rs.getString("password"));
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return user;
				}
				
				//��ѯ����ѧ����Ϣ
				public List selectAllStudent() {
					List<UserBean> stuList=new ArrayList<UserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table user drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table user add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table user modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from user order by id;";
						pstm=con.prepareStatement(sql4);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							UserBean user=new UserBean();
							user.setId(rs.getInt("id"));
							user.setStuId(rs.getString(2));
							user.setPassword(rs.getString(3));
							user.setStuName(rs.getString(4));
							user.setPro(rs.getString(5));
							user.setPhone(rs.getString(6));
							stuList.add(user);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return stuList;
				}
				
				//�޸�ѧ����Ϣ
				public int updateStudent(UserBean user) {
					int row = 0;
					// ��һ���͵ڶ���ͨ���̳и���ķ��������
					super.getConnection();
					try {
						// ������������һ�� Statement ����
						String sql = "update user set stuId=?,password=?,stuName=?,pro=?,phone=? where id=?;";
						pstm=con.prepareStatement(sql);
						//st = con.createStatement();
						pstm.setString(1, user.getStuId());
						pstm.setString(2, user.getPassword());
						pstm.setString(3, user.getStuName());
						pstm.setString(4, user.getPro());
						pstm.setString(5, user.getPhone());
						pstm.setInt(6, user.getId());
						// ���Ĳ������Ͳ�ִ��sql���
						//row = st.executeUpdate(sql);
						row=pstm.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						// �Ͽ������ݿ�����Ӳ���ͨ�����ø���ķ��������
						super.closeAll();
					}
					return row;
				}
				//ɾ��ѧ����Ϣ
				public int deleteStudent(int id) {
					int row = 0;
					// ��һ���͵ڶ���ͨ���̳и���ķ��������
					super.getConnection();
					try {
						// ������������һ�� Statement ����
						String sql = "delete from user where id=?;";
						pstm=con.prepareStatement(sql);
						pstm.setInt(1, id);
						// ���Ĳ������Ͳ�ִ��sql���
						//row = st.executeUpdate(sql);
						row=pstm.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						// �Ͽ������ݿ�����Ӳ���ͨ�����ø���ķ��������
						super.closeAll();
					}
					return row;
				}
				
				//��ѯ����ѧ����Ϣ
				public UserBean selectById(int id) {
					UserBean stu=null;
					super.getConnection();		
					try {
						//������������PreparedStatement����
						String sql="select * from user where id=?";
						pstm=con.prepareStatement(sql);
						pstm.setInt(1, id);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							stu=new UserBean();
							stu.setId(rs.getInt("id"));
							stu.setStuId(rs.getString(2));
							stu.setPassword(rs.getString(3));
							stu.setStuName(rs.getString(4));
							stu.setPro(rs.getString(5));
							stu.setPhone(rs.getString(6));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return stu;
				}
				
				public List selectStudentByStuId(String stuId) {
					List<UserBean> stuList=new ArrayList<UserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table user drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table user add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table user modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from user where stuId=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, stuId);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							UserBean user=new UserBean();
							user.setId(rs.getInt("id"));
							user.setStuId(rs.getString(2));
							user.setPassword(rs.getString(3));
							user.setStuName(rs.getString(4));
							user.setPro(rs.getString(5));
							user.setPhone(rs.getString(6));
							stuList.add(user);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return stuList;
				}
				
				public List selectStudentByStuName(String stuName) {
					List<UserBean> stuList=new ArrayList<UserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table user drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table user add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table user modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from user where stuName=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, stuName);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							UserBean user=new UserBean();
							user.setId(rs.getInt("id"));
							user.setStuId(rs.getString(2));
							user.setPassword(rs.getString(3));
							user.setStuName(rs.getString(4));
							user.setPro(rs.getString(5));
							user.setPhone(rs.getString(6));
							stuList.add(user);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return stuList;
				}
				
				public List selectStudentByPro(String pro) {
					List<UserBean> stuList=new ArrayList<UserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table user drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table user add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table user modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from user where pro=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, pro);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							UserBean user=new UserBean();
							user.setId(rs.getInt("id"));
							user.setStuId(rs.getString(2));
							user.setPassword(rs.getString(3));
							user.setStuName(rs.getString(4));
							user.setPro(rs.getString(5));
							user.setPhone(rs.getString(6));
							stuList.add(user);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return stuList;
				}
				
				public List selectStudentByPhone(String phone) {
					List<UserBean> stuList=new ArrayList<UserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table user drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table user add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table user modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from user where phone=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, phone);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							UserBean user=new UserBean();
							user.setId(rs.getInt("id"));
							user.setStuId(rs.getString(2));
							user.setPassword(rs.getString(3));
							user.setStuName(rs.getString(4));
							user.setPro(rs.getString(5));
							user.setPhone(rs.getString(6));
							stuList.add(user);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return stuList;
				}

}
