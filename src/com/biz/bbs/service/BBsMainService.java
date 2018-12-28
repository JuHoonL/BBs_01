package com.biz.bbs.service;

import java.util.ArrayList;
import java.util.List;

import com.biz.bbs.dao.BBsMainDAO;
import com.biz.bbs.dao.BBsMainDAOImp;
import com.biz.bbs.vo.BBsMainVO;

public class BBsMainService {

	List<BBsMainVO> bbsMainList;
	BBsMainDAO mainDAO;
	
	
	
	
	public BBsMainService() {
		bbsMainList = new ArrayList();
		mainDAO = new BBsMainDAOImp();
	}
	
	
	
	public void viewBBsList() {
		bbsMainList = mainDAO.selectAll();
		
		System.out.println("==========================================================================================");
		System.out.println("나의 게시판 v1.0");
		System.out.println("==========================================================================================");
		System.out.println("NO\t날짜\t\t작성자\t제목\t\t내용");
		System.out.println("------------------------------------------------------------------------------------------");
		for(BBsMainVO vo : bbsMainList) {
			System.out.print(vo.getB_id() + "\t");
			System.out.print(vo.getB_date() + "\t");
			System.out.print(vo.getB_auth() + "\t");
			System.out.print(vo.getB_subject() + "\t");
			System.out.println(vo.getB_text());
		}
	}
}
