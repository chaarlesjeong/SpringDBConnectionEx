package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDB {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public OracleDB() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
	}

	public ResultSet executeQuery(String sql) {
		try {

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("log 없다");
			System.out.println(conn);
			System.out.println(pstmt);
		}

		return rs;

	}

	public void close() {
		try {
			conn.close();

		} catch (SQLException e) {

		}
	}
}