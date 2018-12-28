package com.biz.bbs.exec;

import com.biz.bbs.dao.BBsFake;
import com.biz.bbs.dao.BBsMainDAO;
import com.biz.bbs.dao.BBsMainDAOImp;

public class BBsMainExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		BBsMainDAOImp dao = new BBsMainDAOImp();  //아래 코드와 같음
		BBsMainDAO dao = new BBsMainDAOImp();
		dao.delete(20l);
		
//		BBsFake bf = new BBsFake();			//아래 코드와 같음
		BBsMainDAO bf = new BBsFake();
		bf.delete(20l);  // long형으로 써주면 오류발생
	}

}
