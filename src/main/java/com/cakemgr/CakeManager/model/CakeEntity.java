package com.cakemgr.CakeManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cake")
public class CakeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Id", unique = true, nullable = false)
	private long Id;
	@Column(name = "title", unique = true, nullable = false, length = 100)
	private String title;
	@Column(name = "desc", unique = false, nullable = false, length = 100)
	private String desc;
	@Column(name = "image", unique = false, nullable = false, length = 300)
	private String image;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImage() {
		return image;
	}

	public CakeEntity(String title, String desc, String image) {
		super();
		this.title = title;
		this.desc = desc;
		this.image = image;
	}

	public CakeEntity() {
	}

	@Override
	public String toString() {
		return "CakeEntity [Id=" + Id + ", title=" + title + ", desc=" + desc + ", image=" + image + "]";
	}

	public void setImage(String image) {
		this.image = image;
	}

}
