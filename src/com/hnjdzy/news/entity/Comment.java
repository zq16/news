package com.hnjdzy.news.entity;

import java.io.Serializable;
import java.util.Date;

/*
 * 评论  实体类
 * @author 
 **/
public class Comment implements Serializable {
	
    private static final long serialVersionUID = -9015266392799849479L;
    private int cid;
	private int cnid;
	private String ccontent;
	private Date cdate;
	private String cip;
	private String cauthor;
	private int cthumb;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCnid() {
		return cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getCauthor() {
		return cauthor;
	}

	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}

	public int getCthumb() {
		return cthumb;
	}

	public void setCthumb(int cthumb) {
		this.cthumb = cthumb;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", cnid=" + cnid + ", ccontent=" + ccontent + ", cdate=" + cdate + ", cip=" + cip
				+ ", cauthor=" + cauthor + ", cthumb=" + cthumb + "]";
	}

	

	
	
	
}
