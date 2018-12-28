package com.biz.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.bbs.vo.BBsMainVO;

/*
 * DAOImp
 * 이 클래스는 실질적으로 DAO를 실행할 코드를 작성하는 부분이다.
 * 이 클래스는 반드시 DAO 인터페이스를 상속받도록 해야 한다.
 */
public class BBsMainDAOImp implements BBsMainDAO {

	private Connection dbConn ;
	
	
	
	public BBsMainDAOImp() {
		this.dbConnection();
	}
	
	private void dbConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String strurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String struser = "bbsUSER";
			String strpassword = "1234";
			
			dbConn = DriverManager.getConnection(strurl, struser, strpassword);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(BBsMainVO bbsMainVO) {
		// TODO Auto-generated method stub
		
	}

	
	/*
	 * SELECTALL() 메서드는 DB로 부터 게시판 데이터를 모두 읽어서 List로
	 * 만들어서 호출한 쪽에 다시 return해 준다. 
	 */
	public List<BBsMainVO> selectAll() {
		// TODO 게시판 데이터를 모두 읽어서 List로 리턴하는 메서드
		
		/*
		 * JDBC를 통해서 DB와 연동하는 코드를 작성할 때 SQL 관련 문자열들은 
		 * " " 안에서 문자열의 시작과 끝에 반드시 빈칸을 한개이상 추가 작성
		 */
		String sql = " SELECT * FROM tbl_bbs_main ";
		
		/*
		 * sql문자열을 JDBC에 보내는 절차
		 */
		
		PreparedStatement ps;
		
		/*
		 * 드디어 DB에게 JDBC를 통해 SQL을 실행하라고 명령
		 * 
		 * 그리고 SQL이 정상적으로 수행이 완료되면 그결과(SELECT를 실행했으므로 그 리스트)를
		 * rs 변수에 받아라
		 */
		
		try {
			ps = dbConn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			/*
			 * rs에 받아놓은 데이터 리스트를 List에 옮겨 담는다.
			 */
			
			List<BBsMainVO> bbsList = new ArrayList();
//			while(true) {
//				if(rs.next() == false) break;
			while(rs.next()) {					// rs.next()가 true이면 {}안의 것을 실행해라
				long id = rs.getLong("b_id");
				String strdate = rs.getString("b_date");
				String strauth = rs.getString("b_auth");
				String strsubject = rs.getString("b_subject");
				String strtext = rs.getString("b_text");
				
				BBsMainVO vo = new BBsMainVO();
				vo.setB_id(id);
				vo.setB_date(strdate);
				vo.setB_auth(strauth);
				vo.setB_subject(strsubject);
				vo.setB_text(strtext);
				
				bbsList.add(vo);
			}
			return bbsList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void findBYid(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BBsMainVO bbsMainVO) {
		// TODO 게시판 데이터 업데이트 메서드
		String sql = " UPDATE tbl_bbs_main ";
		sql += " SET b_date = " + " 2018-11-01 ";
		sql += " WHERE b_id = " + 2;
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	
}
