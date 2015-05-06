package com.kappa.citynow.shared.domain.flickr;

import java.io.Serializable;
import java.util.List;


public class Photos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4941948510495886271L;
	private Number page;
	private Number pages;
	private Number perpage;
	private List<Photo> photo;
	private String total;

	public Number getPage() {
		return this.page;
	}

	public void setPage(Number page) {
		this.page = page;
	}

	public Number getPages() {
		return this.pages;
	}

	public void setPages(Number pages) {
		this.pages = pages;
	}

	public Number getPerpage() {
		return this.perpage;
	}

	public void setPerpage(Number perpage) {
		this.perpage = perpage;
	}

	public List<Photo> getPhoto() {
		return this.photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
