package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DeviceBean;

public class DeviceDao extends BaseDao {
	// 添加学生信息
	public int addDevice(String name, String location, String address, String repair, String time) {
		int row = 0;
		// 第一步和第二步通过继承父类的方法来完成
		super.getConnection();
		try {
			// 第三步：创建一个 Statement 对象
			String sql = "INSERT INTO device(name,location,address,repair,time)VALUES(?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			//st = con.createStatement();
			
			pstm.setString(1, name);
			pstm.setString(2, location);
			pstm.setString(3, address);
			pstm.setString(4,repair);
			pstm.setString(5, time);
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

	public int addDevice(DeviceBean dev) {
		int row = 0;
		// 第一步和第二步通过继承父类的方法来完成
		super.getConnection();
		try {
			// 第三步：创建一个 Statement 对象
			//st = con.createStatement();
			String sql = "INSERT INTO device(name,location,address,repair,time)VALUES(?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			// 第四步：发送并执行sql语句
			
			pstm.setString(1, dev.getName());
			pstm.setString(2, dev.getLocation());
			pstm.setString(3, dev.getAddress());
			pstm.setString(4, dev.getRepair());
			pstm.setString(5, dev.getTime());
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
	//查询所有学生信息
	public List selectAll() {
		List<DeviceBean> devList=new ArrayList<DeviceBean>();
		super.getConnection();		
		try {
			//第三步：创建PreparedStatement对象
//			con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
			String sql1 = "alter table device drop id;";
			pstm=con.prepareStatement(sql1);
			//第四步：发送并执行sql语句
			pstm.executeUpdate();
			String sql2 = "alter table device add id int not null first;";
			pstm=con.prepareStatement(sql2);
			//第四步：发送并执行sql语句
			pstm.executeUpdate();
			String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
			pstm=con.prepareStatement(sql3);
			//第四步：发送并执行sql语句
			pstm.executeUpdate();
			String sql4="select * from device order by id;";
			pstm=con.prepareStatement(sql4);
			//第四步：发送并执行sql语句
			rs=pstm.executeQuery();
//			con.commit();
			
			//第五步：使用ResultSet对象
			while(rs.next()) {
				DeviceBean dev=new DeviceBean();
				dev.setId(rs.getInt("id"));
				dev.setName(rs.getString(2));
				dev.setLocation(rs.getString(3));
				dev.setAddress(rs.getString(4));
				dev.setRepair(rs.getString(5));
				dev.setTime(rs.getString(6));
				devList.add(dev);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return devList;
	}
	//查询单个学生信息
		public DeviceBean selectById(int id) {
			DeviceBean dev=null;
			super.getConnection();		
			try {
				//第三步：创建PreparedStatement对象
				String sql="select * from device where id=?";
				pstm=con.prepareStatement(sql);
				pstm.setInt(1, id);
				//第四步：发送并执行sql语句
				rs=pstm.executeQuery();
				//第五步：使用ResultSet对象
				while(rs.next()) {
					  dev=new DeviceBean();
					 dev.setId(rs.getInt("id"));
						dev.setName(rs.getString(2));
						dev.setLocation(rs.getString(3));
						dev.setAddress(rs.getString(4));
						dev.setRepair(rs.getString(5));
						dev.setTime(rs.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				super.closeAll();
			}
			return dev;
		}
		
		public List selectDeviceByName(String name) {
			List<DeviceBean> devList=new ArrayList<DeviceBean>();
			super.getConnection();		
			try {
				//第三步：创建PreparedStatement对象
//				con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
				String sql1 = "alter table device drop id;";
				pstm=con.prepareStatement(sql1);
				//第四步：发送并执行sql语句
				pstm.executeUpdate();
				String sql2 = "alter table device add id int not null first;";
				pstm=con.prepareStatement(sql2);
				//第四步：发送并执行sql语句
				pstm.executeUpdate();
				String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
				pstm=con.prepareStatement(sql3);
				//第四步：发送并执行sql语句
				pstm.executeUpdate();
				String sql4="select * from device where name=? order by id;";
				pstm=con.prepareStatement(sql4);
				pstm.setString(1, name);
				//第四步：发送并执行sql语句
				rs=pstm.executeQuery();
//				con.commit();
				
				//第五步：使用ResultSet对象
				while(rs.next()) {
					DeviceBean dev=new DeviceBean();
					dev.setId(rs.getInt("id"));
					dev.setName(rs.getString(2));
					dev.setLocation(rs.getString(3));
					dev.setAddress(rs.getString(4));
					dev.setRepair(rs.getString(5));
					dev.setTime(rs.getString(6));
					devList.add(dev);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				super.closeAll();
			}
			return devList;
		}
		
				//查询学生信息
				public List selectDeviceByLocation(String location) {
					List<DeviceBean> devList=new ArrayList<DeviceBean>();
					super.getConnection();		
					try {
						//第三步：创建PreparedStatement对象
//						con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
						String sql1 = "alter table device drop id;";
						pstm=con.prepareStatement(sql1);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql2 = "alter table device add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql4="select * from device where location=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, location);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
//						con.commit();
						
						//第五步：使用ResultSet对象
						while(rs.next()) {
							DeviceBean dev=new DeviceBean();
							dev.setId(rs.getInt("id"));
							dev.setName(rs.getString(2));
							dev.setLocation(rs.getString(3));
							dev.setAddress(rs.getString(4));
							dev.setRepair(rs.getString(5));
							dev.setTime(rs.getString(6));
							devList.add(dev);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return devList;
				}
				//查询学生信息
				public List selectDeviceByAddress(String address) {
					List<DeviceBean> devList=new ArrayList<DeviceBean>();
					super.getConnection();		
					try {
						//第三步：创建PreparedStatement对象
//						con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
						String sql1 = "alter table device drop id;";
						pstm=con.prepareStatement(sql1);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql2 = "alter table device add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql4="select * from device where address=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, address);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
//						con.commit();
						
						//第五步：使用ResultSet对象
						while(rs.next()) {
							DeviceBean dev=new DeviceBean();
							dev.setId(rs.getInt("id"));
							dev.setName(rs.getString(2));
							dev.setLocation(rs.getString(3));
							dev.setAddress(rs.getString(4));
							dev.setRepair(rs.getString(5));
							dev.setTime(rs.getString(6));
							devList.add(dev);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return devList;
				}
				//查询学生信息
				public List selectDeviceByRepair(String repair) {
					List<DeviceBean> devList=new ArrayList<DeviceBean>();
					super.getConnection();		
					try {
						//第三步：创建PreparedStatement对象
//						con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
						String sql1 = "alter table device drop id;";
						pstm=con.prepareStatement(sql1);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql2 = "alter table device add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql4="select * from device where repair=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, repair);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
//						con.commit();
						
						//第五步：使用ResultSet对象
						while(rs.next()) {
							DeviceBean dev=new DeviceBean();
							dev.setId(rs.getInt("id"));
							dev.setName(rs.getString(2));
							dev.setLocation(rs.getString(3));
							dev.setAddress(rs.getString(4));
							dev.setRepair(rs.getString(5));
							dev.setTime(rs.getString(6));
							devList.add(dev);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return devList;
				}
				//查询学生信息
				public List selectDeviceByTime(String time) {
					List<DeviceBean> devList=new ArrayList<DeviceBean>();
					super.getConnection();		
					try {
						//第三步：创建PreparedStatement对象
//						con.setAutoCommit(false);//设为false,每次executeUpdate将不会立刻提交，而是等待commit();
						String sql1 = "alter table device drop id;";
						pstm=con.prepareStatement(sql1);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql2 = "alter table device add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//第四步：发送并执行sql语句
						pstm.executeUpdate();
						String sql4="select * from device where time=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, time);
						//第四步：发送并执行sql语句
						rs=pstm.executeQuery();
//						con.commit();
						
						//第五步：使用ResultSet对象
						while(rs.next()) {
							DeviceBean dev=new DeviceBean();
							dev.setId(rs.getInt("id"));
							dev.setName(rs.getString(2));
							dev.setLocation(rs.getString(3));
							dev.setAddress(rs.getString(4));
							dev.setRepair(rs.getString(5));
							dev.setTime(rs.getString(6));
							devList.add(dev);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						super.closeAll();
					}
					return devList;
				}
	//修改学生信息
	public int updateDevice(DeviceBean dev) {
		int row = 0;
		// 第一步和第二步通过继承父类的方法来完成
		super.getConnection();
		try {
			// 第三步：创建一个 Statement 对象
			String sql = "update device set name=?,location=?,address=?,repair=?,time=? where id=?;";
			pstm=con.prepareStatement(sql);
			//st = con.createStatement();
			pstm.setString(1, dev.getName());
			pstm.setString(2, dev.getLocation());
			pstm.setString(3, dev.getAddress());
			pstm.setString(4, dev.getRepair());
			pstm.setString(5, dev.getTime());
			pstm.setInt(6, dev.getId());
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
	public int deleteDevice(int id) {
		int row = 0;
		// 第一步和第二步通过继承父类的方法来完成
		super.getConnection();
		try {
			// 第三步：创建一个 Statement 对象
			String sql = "delete from device where id=?;";
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
			public DeviceBean selectByPage(int offset) {
				DeviceBean dev=null;
				super.getConnection();		
				try {
					//第三步：创建PreparedStatement对象
					//第一个问号，代表一页返回多少条记录  ， 第二个问号， 跳过前面的多少条记录。
					//5 0 --- 第一页 (1-1)*5
					//5 5  --- 第二页 (2-1)*5
					//5 10  --- 第三页
					String sql="select * from device limit 5 offset ?";
					pstm=con.prepareStatement(sql);
					
					pstm.setInt(1, offset);
					//第四步：发送并执行sql语句
					rs=pstm.executeQuery();
					//第五步：使用ResultSet对象
					while(rs.next()) {
						  dev=new DeviceBean();
						 dev.setId(rs.getInt(1));
							dev.setName(rs.getString(2));
							dev.setLocation(rs.getString(3));
							dev.setAddress(rs.getString(4));
							dev.setRepair(rs.getString(5));
							dev.setTime(rs.getString(6));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					super.closeAll();
				}
				return dev;
			}
}
