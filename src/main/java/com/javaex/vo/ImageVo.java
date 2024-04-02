package com.javaex.vo;

public class ImageVo {

	private int productNo;
	private String orgName;
	private String saveName;
	private String filePath;
	private long fileSize;
	
	
	public ImageVo() {
	}

	public ImageVo(String orgName, String saveName, String filePath) {
		this.orgName = orgName;
		this.saveName = saveName;
		this.filePath = filePath;
	}
	
	public ImageVo(int productNo, String orgName, String saveName, String filePath) {
		this.productNo = productNo;
		this.orgName = orgName;
		this.saveName = saveName;
		this.filePath = filePath;
	}

	public ImageVo(int productNo, String orgName, String saveName, String filePath, long fileSize) {
		this.productNo = productNo;
		this.orgName = orgName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getSaveName() {
		return saveName;
	}


	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public long getFileSize() {
		return fileSize;
	}


	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}


	@Override
	public String toString() {
		return "ImageVo [productNo=" + productNo + ", orgName=" + orgName + ", saveName=" + saveName + ", filePath="
				+ filePath + ", fileSize=" + fileSize + "]";
	}
	
	
}
