package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ImageVo;
import com.javaex.vo.ProductVo;

@Repository
public class ManagerDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//사진 등록
	public int insertImg(ImageVo imageVo) {
		System.out.println("AttachDao.insertImg()");
		
		int count = sqlSession.insert("kiosk.insertImg", imageVo);
		
		return count;
	}
	
	//메뉴 등록
	public int menuInsert(ProductVo productVo) {
		System.out.println("ManagerDao.menuInsert()");
		
		int count = sqlSession.insert("kiosk.insertMenu", productVo);
		
		return count;
	}
	
	
	//리스트
	public List<ProductVo> selectList() {
		System.out.println("ManagerDao.selectList()");
		
		List<ProductVo> pList = sqlSession.selectList("kiosk.selectList");
		
		return pList;
	}
	
	//삭제
	public int menuDelete(int no) {
		System.out.println("ManagerDao.menuDelete()");
		System.out.println(no);
		int count = sqlSession.delete("kiosk.deleteMenu", no);
		return count;
	}
	//이미지삭제
	public int imgDelete(int no) {
		System.out.println("ManagerDao.imgDelete()");
		System.out.println(no);
		int count = sqlSession.delete("kiosk.deleteImg", no);
		return count;
	}

}
