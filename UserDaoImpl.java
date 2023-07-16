package com.thanhhc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.thanhhc.dao.UserDao;
import com.thanhhc.jdbc.JDBCConnection;
import com.thanhhc.model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void insert(User user) {
		int roleId=0;
		String sql = "INSERT INTO [User](email, username, password, avatar, dateOfBirth, address, role_id) VALUES (?,?,?,?,?,?,?)";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String formattedDate = dateFormat.format(user.getDateOfBirth());
			
//			java.util.Date utilDate = user.getDateOfBirth();
//			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAvatar());
//			ps.setDate(5, sqlDate);
			ps.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));
//			ps.setString(5, formattedDate);
			
			ps.setString(6, user.getAddress());
			try {
				if(user.getRoleId()==1) {
					roleId=1;
				}else {
					roleId=2;
				}

			} catch (Exception e) {
				roleId=2;
			}
			ps.setInt(7, roleId);
			;
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(User user) {
		String sql = "UPDATE [User] \r\n"
				+ "SET email = ?, avatar = ? ,dateOfBirth = ?, address = ?, username = ?\r\n"
				+ "WHERE id = ?";
		if(user.getAvatar() == null) {
			sql = "UPDATE [User] \r\n"
					+ "SET email = ?, avatar = NULL ,dateOfBirth = ?, address = ?, username = ? \r\n"
					+ "WHERE id = ? ";
		}
		Connection con = getConnection();
		System.out.println("zô");
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = dateFormat.format(user.getDateOfBirth());
			if(user.getAvatar() != null) {
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getAvatar());
				ps.setString(3, formattedDate);
				ps.setString(4, user.getAddress());
				ps.setString(5, user.getUsername());
				ps.setInt(6, user.getId());
			}else {
				ps.setString(1, user.getEmail());
				ps.setString(2, formattedDate);
				ps.setString(3, user.getAddress());
				ps.setString(4, user.getUsername());
				ps.setInt(5, user.getId());
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM [User] WHERE id = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User get(String username) {
		String sql = "SELECT * FROM [User] WHERE username = ? ";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(Integer.parseInt(rs.getString("role_id")));
				user.setDateOfBirth(rs.getDate("dateOfBirth"));
				user.setAddress(rs.getString("address"));

				return user;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User get(int id) {
		String sql = "SELECT * FROM [User] WHERE id = ? ";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(Integer.parseInt(rs.getString("role_id")));
				user.setDateOfBirth(rs.getDate("dateOfBirth"));
				user.setAddress(rs.getString("address"));

				return user;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM [User]";
		Connection conn = super.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(Integer.parseInt(rs.getString("role_id")));
				user.setDateOfBirth(rs.getDate("dateOfBirth"));
				user.setAddress(rs.getString("address"));

				userList.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public List<User> search(String keyword) {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM [User] WHERE name LIKE ? ";
		Connection conn = super.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(Integer.parseInt(rs.getString("role_id")));

				userList.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		Connection conn = super.getConnection();
		try {
			String query = "select * from [user] where email = ?";

			PreparedStatement psmt = conn.prepareStatement(query);

			psmt.setString(1, email);

			ResultSet resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				duplicate = true;
			}
			psmt.close();
			conn.close();
		} catch (SQLException ex) {
		}
		return duplicate;
	}

	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		Connection conn = super.getConnection();
		try {
			String query = "select * from [User] where username = ?";

			PreparedStatement psmt = conn.prepareStatement(query);

			psmt.setString(1, username);

			ResultSet resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				duplicate = true;
			}
			psmt.close();
			conn.close();
		} catch (SQLException ex) {
		}
		return duplicate;
	}
	public static void main (String args[]) {
		UserDaoImpl a = new UserDaoImpl();
		try {
			User ab = new User("thanh@gmail.com", "thanh", "123456", new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-16"), "Hue");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-16"));
			System.out.println(ab.getDateOfBirth());
			System.out.println(new java.sql.Date(ab.getDateOfBirth().getTime()));
//			a.insert(new User("thanh@gmail.com", "thanh", "123456", new SimpleDateFormat("YYYY-MM-DD").parse("2023-04-12"), "Hue"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a.getAll().get(0).getEmail());
	}
}
