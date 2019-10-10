package com.java1234.entity;

import java.util.List;


public class Tree {
	
	private Integer id ; 
	private String text ; //显示的名子
	private Integer father;//父节点
	private List<Tree> children;//子节点
	private Tree attributes;//其实也是note
	private boolean checked ; //easyui窗口   授权时会用到这个
	private String state ;//open就是代码到了叶子节点。  close就是支干  下面有可能有节点 
	private String url;//对应的页面  /station/pc/manage
	private String iconCls;//对应的图标
	private String permissions;//对应的shiro权限    job:change
	/**
	 * 这个这是记录 id的 因为在manage页面中，
	 * 有这样一个东西。$("#user").addClass("layui-this");  
	 * 选择哪个选项为选中  这是根据id来的。
	 */
	private String dd_id;
	
	
	
	public String getDd_id() {
		return dd_id;
	}
	public void setDd_id(String dd_id) {
		this.dd_id = dd_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getFather() {
		return father;
	}
	public void setFather(Integer father) {
		this.father = father;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	public Tree getAttributes() {
		return attributes;
	}
	public void setAttributes(Tree attributes) {
		this.attributes = attributes;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	
	 
	

	
	
	
	
	
	
}
