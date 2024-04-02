package com.javaex.vo;

public class ProductVo {
	
	private int no;
	private String category;
	private String name;
	private int price;
	
	
	public ProductVo() {
	}
	
	public ProductVo(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	public ProductVo(String category, String name, int price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}
	
	public ProductVo(int no, String category, String name, int price) {
		this.no = no;
		this.category = category;
		this.name = name;
		this.price = price;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", category=" + category + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
