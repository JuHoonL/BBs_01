package com.biz.bbs.dao;

import java.util.List;

import com.biz.bbs.vo.BBsMainVO;

/*
 * interface는 
 * 1. member 변수를 갖을 수 없다.
 * 2. method를 선언만 할 수 있다.
 */
public interface BBsMainDAO {

	//CRUD를 선언
	
	public void insert(BBsMainVO bbsMainVO);
	
	public List<BBsMainVO> selectAll();
	
	public void findBYid(long id);
	
	public void update(BBsMainVO bbsMainVO);
	
	public void delete(long id);

}
