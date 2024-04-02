package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.ManagerDao;
import com.javaex.vo.ImageVo;
import com.javaex.vo.ProductVo;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerDao managerDao;
	
	//메뉴 등록
	public int exeInsert(ProductVo productVo) {
		System.out.println("ManagerService.exeInsert()");
		
		int count = managerDao.menuInsert(productVo);
		
		return count;
	}
	
	
	//리스트
	public List<ProductVo> exeList() {
		System.out.println("ManagerService.exeList()");
		
		List<ProductVo> pList = managerDao.selectList();
		
		return pList;
	}
	
	//삭제
	public int exeDelete(int no) {
		System.out.println("ManagerService.exeDelete()");
		int count;
		count = managerDao.imgDelete(no);
		if(count > 0) {
			count ++;
			managerDao.menuDelete(no);
			System.out.println(count);
		} else {
			count = managerDao.menuDelete(no);
		}
		return count;
	}
	
	public String exeUpload(MultipartFile file, int no) {
		System.out.println("AttachService.exeUpload()");
		
		//파일저장 폴더
		String saveDir = "C:\\javaStudy\\upload";
		
		//0. 파일 정보수집
		//	오리지날 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("orgName: "+orgName);
		
		//	확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("exName: " + exName);
		//System.out.println(orgName.substring(4)); //4번 이후 출력
		//System.out.println(orgName.lastIndexOf(".")); //.이 몇번째야
		
		//	저장 파일명(겹치지 않게)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+exName;
		System.out.println("saveName: " + saveName);
		
		//	파일 사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize: "+fileSize);
		
		//	파일 전체 경로
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath: "+filePath);
		
		//1. 파일정보를 db에 저장
		//	vo로 묶어주고
		ImageVo imageVo = new ImageVo(no, orgName, saveName, filePath);
		
		//	db에 저장
		//System.out.println("..........DB저장완료");
		
		managerDao.insertImg(imageVo);
		
		
		//2. 파일정보를 하드디스크에 저장
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saveName;
	}//exeUpload

}
