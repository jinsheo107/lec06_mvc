package com.gn.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static com.gn.common.sql.JDBCTemplate.commit;
import static com.gn.common.sql.JDBCTemplate.rollback;
import static com.gn.common.sql.JDBCTemplate.close;

import com.gn.user.vo.User;

public class UserDao {
	public int userCreate(User u, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO user (user_id, user_pw, user_name) VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUser_id());
			pstmt.setString(2, u.getUser_pw());
			pstmt.setString(3, u.getUser_name());
			
			result = pstmt.executeUpdate();
			
			commit(conn);
			
		} catch(Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
