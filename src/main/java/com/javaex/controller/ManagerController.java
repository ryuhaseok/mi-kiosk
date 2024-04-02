package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.ManagerService;
import com.javaex.util.JsonResult;
import com.javaex.vo.ProductVo;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	// 사진등록
	@PostMapping("/api/managers/attach")
	public JsonResult upload(@RequestBody MultipartFile file,  @ModelAttribute ProductVo productVo) {
		System.out.println("ManagerController.upload()");
		System.out.println("fileName=" + file.getOriginalFilename());
		System.out.println("toString=" + file);
		System.out.println(productVo);

		String saveName = managerService.exeUpload(file, productVo.getNo());

		return JsonResult.success(saveName);
	}

	//메뉴 삭제
	@DeleteMapping("/api/managers/list/{no}")
	public JsonResult menuDelete(@PathVariable(value="no") int no) {
		System.out.println("ManagerController.menuDelete()");
		int count = managerService.exeDelete(no);
		System.out.println(count);
		//삭제가 정상적으로 되면(0보다 큰값이 리턴되면)
		if(count == 1) {
			return JsonResult.success("삭제완료");
		} else if(count == 2){
			return JsonResult.success("이미지");
		}else { //삭제가 제대로 안되면
			return JsonResult.fail("삭제실패");
		}
	}
	
	// 메뉴등록
	@PostMapping("/api/managers/list")
	public int menuInsert(@RequestBody ProductVo productVo) {
		System.out.println("ManagerController.menuInsert()");

		int count = managerService.exeInsert(productVo);
		
		return count;
	}

	// 리스트
	@GetMapping("/api/managers/list")
	public List<ProductVo> list() {
		System.out.println("ManagerController.list()");

		List<ProductVo> pList = managerService.exeList();
		System.out.println(pList);

		return pList;
	}
	
}
