package com.hnjdzy.news.entity;

import java.io.Serializable;

/*
 * 主题 实体类
 * @author
 */
public class Topic implements Serializable {
    private static final long serialVersionUID = 2786883833042050721L;
    private int tid;
	private String tname;
	
	public Topic() {
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Topic(int tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Topic [tid=" + tid + ", tname=" + tname + "]";
	}
	
	
	
	

}
