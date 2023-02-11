package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ManageUserBean;
import model.UserBean;

public class ManageUserDao extends BaseDao{
	
	// ���ѧ����Ϣ
		public int addSuser(String userId, String password, String name,String phone) {
			int row = 0;
			// ��һ���͵ڶ���ͨ���̳и���ķ��������
			super.getConnection();
			try {
				// ������������һ�� Statement ����
				String sql = "INSERT INTO suser(suserId,password,name,phone)VALUES(?,?,?,?)";
				pstm=con.prepareStatement(sql);
				//st = con.createStatement();
				
				pstm.setString(1, userId);
				pstm.setString(2, password);
				pstm.setString(3, name);
				pstm.setString(4,phone);
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

		public int addSuser(ManageUserBean suser) {
			int row = 0;
			// ��һ���͵ڶ���ͨ���̳и���ķ��������
			super.getConnection();
			try {
				// ������������һ�� Statement ����
				//st = con.createStatement();
				String sql = "INSERT INTO suser(suserId,password,name,phone)VALUES(?,?,?,?)";
				pstm=con.prepareStatement(sql);
				// ���Ĳ������Ͳ�ִ��sql���
				
				pstm.setString(1, suser.getUserId());
				pstm.setString(2, suser.getPassword());
				pstm.setString(3, suser.getName());
				pstm.setString(4, suser.getPhone());
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
		
		//��ѯ��Ϣ
				public ManageUserBean sLogin(String userId) {
					ManageUserBean mub=null;
					super.getConnection();		
					try {
						//������������PreparedStatement����
						String sql="select name,password from suser where suserId=?";
						pstm=con.prepareStatement(sql);
						pstm.setString(1, userId);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							mub=new ManageUserBean();
							mub.setName(rs.getString("name"));
							mub.setPassword(rs.getString("password"));
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return mub;
				}
				
				//��ѯ��Ϣ
				public ManageUserBean ssLogin(String userId) {
					ManageUserBean mub=null;
					super.getConnection();		
					try {
						//������������PreparedStatement����
						String sql="select name,password from ssuser where ssuserId=?";
						pstm=con.prepareStatement(sql);
						pstm.setString(1, userId);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							mub=new ManageUserBean();
							mub.setName(rs.getString("name"));
							mub.setPassword(rs.getString("password"));
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return mub;
				}
				
				//��ѯ����ѧ����Ϣ
				public List selectAllSuser() {
					List<ManageUserBean> sList=new ArrayList<ManageUserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table suser drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table suser add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table suser modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from suser order by id;";
						pstm=con.prepareStatement(sql4);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							ManageUserBean suser=new ManageUserBean();
							suser.setId(rs.getInt("id"));
							suser.setUserId(rs.getString(2));
							suser.setPassword(rs.getString(3));
							suser.setName(rs.getString(4));
							suser.setPhone(rs.getString(5));
							sList.add(suser);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return sList;
				}
				
				//�޸�ѧ����Ϣ
				public int updateSuser(ManageUserBean suser) {
					int row = 0;
					// ��һ���͵ڶ���ͨ���̳и���ķ��������
					super.getConnection();
					try {
						// ������������һ�� Statement ����
						String sql = "update suser set suserId=?,password=?,name=?,phone=? where id=?;";
						pstm=con.prepareStatement(sql);
						//st = con.createStatement();
						pstm.setString(1, suser.getUserId());
						pstm.setString(2, suser.getPassword());
						pstm.setString(3, suser.getName());
						pstm.setString(4, suser.getPhone());
						pstm.setInt(5, suser.getId());
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
				public int deleteSuser(int id) {
					int row = 0;
					// ��һ���͵ڶ���ͨ���̳и���ķ��������
					super.getConnection();
					try {
						// ������������һ�� Statement ����
						String sql = "delete from suser where id=?;";
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
				public ManageUserBean selectById(int id) {
					ManageUserBean suser=null;
					super.getConnection();		
					try {
						//������������PreparedStatement����
						String sql="select * from suser where id=?";
						pstm=con.prepareStatement(sql);
						pstm.setInt(1, id);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							suser=new ManageUserBean();
							suser.setId(rs.getInt("id"));
							suser.setUserId(rs.getString(2));
							suser.setPassword(rs.getString(3));
							suser.setName(rs.getString(4));
							suser.setPhone(rs.getString(5));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return suser;
				}
				
				public List selectSuserByUserId(String userId) {
					List<ManageUserBean> sList=new ArrayList<ManageUserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table suser drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table suser add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table suser modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from suser where suserId=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, userId);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							ManageUserBean suser=new ManageUserBean();
							suser.setId(rs.getInt("id"));
							suser.setUserId(rs.getString(2));
							suser.setPassword(rs.getString(3));
							suser.setName(rs.getString(4));
							suser.setPhone(rs.getString(5));
							sList.add(suser);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return sList;
				}
				
				public List selectSuserByName(String name) {
					List<ManageUserBean> sList=new ArrayList<ManageUserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table suser drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table suser add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table suser modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from suser where name=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, name);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							ManageUserBean suser=new ManageUserBean();
							suser.setId(rs.getInt("id"));
							suser.setUserId(rs.getString(2));
							suser.setPassword(rs.getString(3));
							suser.setName(rs.getString(4));
							suser.setPhone(rs.getString(5));
							sList.add(suser);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return sList;
				}
				
				public List selectSuserByPhone(String phone) {
					List<ManageUserBean> sList=new ArrayList<ManageUserBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table suser drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table suser add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table suser modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from suser where phone=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, phone);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
						while(rs.next()) {
							ManageUserBean suser=new ManageUserBean();
							suser.setId(rs.getInt("id"));
							suser.setUserId(rs.getString(2));
							suser.setPassword(rs.getString(3));
							suser.setName(rs.getString(4));
							suser.setPhone(rs.getString(5));
							sList.add(suser);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return sList;
				}


}
