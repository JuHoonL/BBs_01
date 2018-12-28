package com.biz.bbs.exec;

import java.util.List;

import com.biz.bbs.dao.BBsMainDAO;
import com.biz.bbs.dao.BBsMainDAOImp;
import com.biz.bbs.vo.BBsMainVO;

public class BBsMainExec02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BBsMainDAOImp bm = new BBsMainDAOImp();
		
//		bm.dbConnection();
		/*
		 * BBsMainDao의 selectAll()을 호출(실행)하고 실행완료되면 그(return 된) 결과를 받아서
		 * bbsList에 저장하라
		 */
		List<BBsMainVO> bbsList = bm.selectAll();
		for(BBsMainVO v : bbsList) {
			System.out.println(v);
		}
	}

}
