package com.gn.user.dao;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.commit;
import static com.gn.common.sql.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.user.vo.User;

public class UserDao {
	public int userCreate(User u, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql1 = "SELECT COUNT(*) cnt FROM `user` WHERE `user_id` = ?";
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, u.getUser_id());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("cnt") > 0) {
					result = 0;
				} else {
					String sql = "INSERT INTO `user` (`user_id`, `user_pw`, `user_name`) VALUES(?, ?, ?)";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, u.getUser_id());
					pstmt.setString(2, u.getUser_pw());
					pstmt.setString(3, u.getUser_name());
					
					result = pstmt.executeUpdate();
				}
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
