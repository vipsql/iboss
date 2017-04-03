package com.woime.iboss.pim.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PimPhrase 常用语.
 * 
 * @author devaeye
 */
@Entity
@Table(name = "PIM_PHRASE")
public class PimPhrase implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** 主键. */
	private Long id;

	/** 内容. */
	private String content;

	/** 用户. */
	private String userId;

	public PimPhrase()
	{
	}

	public PimPhrase(Long id)
	{
		this.id = id;
	}

	public PimPhrase(Long id, String content, String userId)
	{
		this.id = id;
		this.content = content;
		this.userId = userId;
	}

	/** @return 主键. */
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId()
	{
		return this.id;
	}

	/**
	 * @param id
	 *            主键.
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/** @return 内容. */
	@Column(name = "CONTENT", length = 200)
	public String getContent()
	{
		return this.content;
	}

	/**
	 * @param content
	 *            内容.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/** @return 用户. */
	@Column(name = "USER_ID", length = 64)
	public String getUserId()
	{
		return this.userId;
	}

	/**
	 * @param userId
	 *            用户.
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
}