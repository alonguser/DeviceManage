package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DeviceBean;

public class DeviceDao extends BaseDao {
	// ���ѧ����Ϣ
	public int addDevice(String name, String location, String address, String repair, String time) {
		int row = 0;
		// ��һ���͵ڶ���ͨ���̳и���ķ��������
		super.getConnection();
		try {
			// ������������һ�� Statement ����
			String sql = "INSERT INTO device(name,location,address,repair,time)VALUES(?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			//st = con.createStatement();
			
			pstm.setString(1, name);
			pstm.setString(2, location);
			pstm.setString(3, address);
			pstm.setString(4,repair);
			pstm.setString(5, time);
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

	public int addDevice(DeviceBean dev) {
		int row = 0;
		// ��һ���͵ڶ���ͨ���̳и���ķ��������
		super.getConnection();
		try {
			// ������������һ�� Statement ����
			//st = con.createStatement();
			String sql = "INSERT INTO device(name,location,address,repair,time)VALUES(?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			// ���Ĳ������Ͳ�ִ��sql���
			
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
			// �Ͽ������ݿ�����Ӳ���ͨ�����ø���ķ��������
			super.closeAll();
		}
		return row;
	}
	//��ѯ����ѧ����Ϣ
	public List selectAll() {
		List<DeviceBean> devList=new ArrayList<DeviceBean>();
		super.getConnection();		
		try {
			//������������PreparedStatement����
//			con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
			String sql1 = "alter table device drop id;";
			pstm=con.prepareStatement(sql1);
			//���Ĳ������Ͳ�ִ��sql���
			pstm.executeUpdate();
			String sql2 = "alter table device add id int not null first;";
			pstm=con.prepareStatement(sql2);
			//���Ĳ������Ͳ�ִ��sql���
			pstm.executeUpdate();
			String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
			pstm=con.prepareStatement(sql3);
			//���Ĳ������Ͳ�ִ��sql���
			pstm.executeUpdate();
			String sql4="select * from device order by id;";
			pstm=con.prepareStatement(sql4);
			//���Ĳ������Ͳ�ִ��sql���
			rs=pstm.executeQuery();
//			con.commit();
			
			//���岽��ʹ��ResultSet����
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
	//��ѯ����ѧ����Ϣ
		public DeviceBean selectById(int id) {
			DeviceBean dev=null;
			super.getConnection();		
			try {
				//������������PreparedStatement����
				String sql="select * from device where id=?";
				pstm=con.prepareStatement(sql);
				pstm.setInt(1, id);
				//���Ĳ������Ͳ�ִ��sql���
				rs=pstm.executeQuery();
				//���岽��ʹ��ResultSet����
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
				//������������PreparedStatement����
//				con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
				String sql1 = "alter table device drop id;";
				pstm=con.prepareStatement(sql1);
				//���Ĳ������Ͳ�ִ��sql���
				pstm.executeUpdate();
				String sql2 = "alter table device add id int not null first;";
				pstm=con.prepareStatement(sql2);
				//���Ĳ������Ͳ�ִ��sql���
				pstm.executeUpdate();
				String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
				pstm=con.prepareStatement(sql3);
				//���Ĳ������Ͳ�ִ��sql���
				pstm.executeUpdate();
				String sql4="select * from device where name=? order by id;";
				pstm=con.prepareStatement(sql4);
				pstm.setString(1, name);
				//���Ĳ������Ͳ�ִ��sql���
				rs=pstm.executeQuery();
//				con.commit();
				
				//���岽��ʹ��ResultSet����
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
		
				//��ѯѧ����Ϣ
				public List selectDeviceByLocation(String location) {
					List<DeviceBean> devList=new ArrayList<DeviceBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table device drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table device add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from device where location=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, location);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
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
				//��ѯѧ����Ϣ
				public List selectDeviceByAddress(String address) {
					List<DeviceBean> devList=new ArrayList<DeviceBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table device drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table device add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from device where address=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, address);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
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
				//��ѯѧ����Ϣ
				public List selectDeviceByRepair(String repair) {
					List<DeviceBean> devList=new ArrayList<DeviceBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table device drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table device add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from device where repair=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, repair);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
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
				//��ѯѧ����Ϣ
				public List selectDeviceByTime(String time) {
					List<DeviceBean> devList=new ArrayList<DeviceBean>();
					super.getConnection();		
					try {
						//������������PreparedStatement����
//						con.setAutoCommit(false);//��Ϊfalse,ÿ��executeUpdate�����������ύ�����ǵȴ�commit();
						String sql1 = "alter table device drop id;";
						pstm=con.prepareStatement(sql1);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql2 = "alter table device add id int not null first;";
						pstm=con.prepareStatement(sql2);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql3="alter table device modify column id int not null auto_increment,add primary key(id);";
						pstm=con.prepareStatement(sql3);
						//���Ĳ������Ͳ�ִ��sql���
						pstm.executeUpdate();
						String sql4="select * from device where time=? order by id;";
						pstm=con.prepareStatement(sql4);
						pstm.setString(1, time);
						//���Ĳ������Ͳ�ִ��sql���
						rs=pstm.executeQuery();
//						con.commit();
						
						//���岽��ʹ��ResultSet����
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
	//�޸�ѧ����Ϣ
	public int updateDevice(DeviceBean dev) {
		int row = 0;
		// ��һ���͵ڶ���ͨ���̳и���ķ��������
		super.getConnection();
		try {
			// ������������һ�� Statement ����
			String sql = "update device set name=?,location=?,address=?,repair=?,time=? where id=?;";
			pstm=con.prepareStatement(sql);
			//st = con.createStatement();
			pstm.setString(1, dev.getName());
			pstm.setString(2, dev.getLocation());
			pstm.setString(3, dev.getAddress());
			pstm.setString(4, dev.getRepair());
			pstm.setString(5, dev.getTime());
			pstm.setInt(6, dev.getId());
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
	public int deleteDevice(int id) {
		int row = 0;
		// ��һ���͵ڶ���ͨ���̳и���ķ��������
		super.getConnection();
		try {
			// ������������һ�� Statement ����
			String sql = "delete from device where id=?;";
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
			public DeviceBean selectByPage(int offset) {
				DeviceBean dev=null;
				super.getConnection();		
				try {
					//������������PreparedStatement����
					//��һ���ʺţ�����һҳ���ض�������¼  �� �ڶ����ʺţ� ����ǰ��Ķ�������¼��
					//5 0 --- ��һҳ (1-1)*5
					//5 5  --- �ڶ�ҳ (2-1)*5
					//5 10  --- ����ҳ
					String sql="select * from device limit 5 offset ?";
					pstm=con.prepareStatement(sql);
					
					pstm.setInt(1, offset);
					//���Ĳ������Ͳ�ִ��sql���
					rs=pstm.executeQuery();
					//���岽��ʹ��ResultSet����
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
