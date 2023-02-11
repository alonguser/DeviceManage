package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ManageUserBean;
import model.UserBean;

public class ManageUserDao extends BaseDao{
	
	// 添加学生信息
		public int addSuser(String userId, String password, String name,String phone) {
			int row = 0;
			// 第一步和第二步通过继承父类的方法来完成
			super.getConnection();
			try {
				// 第三步：创建一个 Statement 对象
				String sql = "INSERT INTO suser(suserId,password,name,phone)VALUES(?,?,?,?)";
				pstm=con.prepareStatement(sql);
				//st = con.createStatement();
				
				pstm.setString(1, userId);
				pstm.setString(2, password);
				pstm.setString(3, name);
				pstm.setString(4,phone);
				// 第四步：发送并执行sql语句
				//row = st.executeUpdate(sql);
				row=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// 断开与数据库的连接操作通过调用父类的方法来完成
				super.closeAll();
			}
			return row;
		}

		public int addSuser(ManageUserBean suser) {
			int row = 0;
			// 第一步和第二步通过继承父类的方法来完成
			super.getConnection();
			try {
				// 第三步：创建一个 Statement 对象
				//st = con.createStatement();
				String sql = "INSERT INTO suser(suserId,password,name,phone)VALUES(?,?,?,?)";
				pstm=con.prepareStatement(sql);
				// 第四步：发送并执行sql语句
				
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
				// 断开与数据库的连接操作通过调用父类的方法来完成
				super.closeAll();
			}
			return row;
		}
		
		//查询信息
				public ManageUserBean sLogin(String userId) {
					ManageUserBean mub=null;
					super.getConnection();		
					try {
						//第三步：创建PreparedStatement对象
						String sql="select name,password from suser where suserId=?";
						pstm=con.prepareStatement(sql);
						pstm.setString(1, userId);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
						//第五步：使用ResultSet对象
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
				
				//查询信息
				public ManageUserBean ssLogin(String userId) {
					ManageUserBean mub=null;
					super.getConnection();		
					try {
						//第三步：创建PreparedStatement对象
						String sql="select name,password from ssuser where ssuserId=?";
						pstm=con.prepareStatement(sql);
						pstm.setString(1, userId);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
						//第五步：使用ResultSet对象
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
				
				//查询所有学生信息
				public List selectAllSuser() {
					List<ManageUserBean> sList=new ArrayList<ManageUserBean>();
					super.getConnection();		
					try {
						//第三步：创建PreparedStatement对象
//						con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
						String sql1 = "alter table suser drop id;";
						pstm=con.prepareStatement(sql1);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql2 = "alter table suser add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql3="alter table suser modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql4="select * from suser order by id;";
						pstm=con.prepareStatement(sql4);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
//						con.commit();
						
						//第五步：使用ResultSet对象
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
				
				//修改学生信息
				public int updateSuser(ManageUserBean suser) {
					int row = 0;
					// 第一步和第二步通过继承父类的方法来完成
					super.getConnection();
					try {
						// 第三步：创建一个 Statement 对象
						String sql = "update suser set suserId=?,password=?,name=?,phone=? where id=?;";
						pstm=con.prepareStatement(sql);
						//st = con.createStatement();
						pstm.setString(1, suser.getUserId());
						pstm.setString(2, suser.getPassword());
						pstm.setString(3, suser.getName());
						pstm.setString(4, suser.getPhone());
						pstm.setInt(5, suser.getId());
						// 第四步：发送并执行sql语句
						//row = st.executeUpdate(sql);
						row=pstm.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						// 断开与数据库的连接操作通过调用父类的方法来完成
						super.closeAll();
					}
					return row;
				}
				//删除学生信息
				public int deleteSuser(int id) {
					int row = 0;
					// 第一步和第二步通过继承父类的方法来完成
					super.getConnection();
					try {
						// 第三步：创建一个 Statement 对象
						String sql = "delete from suser where id=?;";
						pstm=con.prepareStatement(sql);
						pstm.setInt(1, id);
						// 第四步：发送并执行sql语句
						//row = st.executeUpdate(sql);
						row=pstm.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						// 断开与数据库的连接操作通过调用父类的方法来完成
						super.closeAll();
					}
					return row;
				}
				
				//查询单个学生信息
				public ManageUserBean selectById(int id) {
					ManageUserBean suser=null;
					super.getConnection();		
					try {
						//第三步：创建PreparedStatement对象
						String sql="select * from suser where id=?";
						pstm=con.prepareStatement(sql);
						pstm.setInt(1, id);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
						//第五步：使用ResultSet对象
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
						//第三步：创建PreparedStatement对象
//						con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
						String sql1 = "alter table suser drop id;";
						pstm=con.prepareStatement(sql1);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql2 = "alter table suser add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql3="alter table suser modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql4="select * from suser where suserId=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, userId);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
//						con.commit();
						
						//第五步：使用ResultSet对象
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
						//第三步：创建PreparedStatement对象
//						con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
						String sql1 = "alter table suser drop id;";
						pstm=con.prepareStatement(sql1);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql2 = "alter table suser add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql3="alter table suser modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql4="select * from suser where name=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, name);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
//						con.commit();
						
						//第五步：使用ResultSet对象
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
						//第三步：创建PreparedStatement对象
//						con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
						String sql1 = "alter table suser drop id;";
						pstm=con.prepareStatement(sql1);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql2 = "alter table suser add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql3="alter table suser modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql4="select * from suser where phone=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, phone);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
//						con.commit();
						
						//第五步：使用ResultSet对象
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
