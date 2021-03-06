package com.woime.iboss.pim.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PimFavorite .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "PIM_FAVORITE")
public class PimFavorite implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private String moduleType;

	/** null. */
	private String moduleId;

	/** null. */
	private String title;

	/** null. */
	private String content;

	/** null. */
	private Date createTime;

	/** null. */
	private String tags;

	/** null. */
	private String userId;

	public PimFavorite()
	{
	}

	public PimFavorite(Long id)
	{
		this.id = id;
	}

	public PimFavorite(Long id, String moduleType, String moduleId, String title, String content, Date createTime, String tags, String userId)
	{
		this.id = id;
		this.moduleType = moduleType;
		this.moduleId = moduleId;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.tags = tags;
		this.userId = userId;
	}

	/** @return null. */
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId()
	{
		return this.id;
	}

	/**
	 * @param id
	 *            null.
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/** @return null. */
	@Column(name = "MODULE_TYPE", length = 50)
	public String getModuleType()
	{
		return this.moduleType;
	}

	/**
	 * @param moduleType
	 *            null.
	 */
	public void setModuleType(String moduleType)
	{
		this.moduleType = moduleType;
	}

	/** @return null. */
	@Column(name = "MODULE_ID", length = 64)
	public String getModuleId()
	{
		return this.moduleId;
	}

	/**
	 * @param moduleId
	 *            null.
	 */
	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	/** @return null. */
	@Column(name = "TITLE", length = 100)
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * @param title
	 *            null.
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/** @return null. */
	@Column(name = "CONTENT", length = 200)
	public String getContent()
	{
		return this.content;
	}

	/**
	 * @param content
	 *            null.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/** @return null. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", length = 26)
	public Date getCreateTime()
	{
		return this.createTime;
	}

	/**
	 * @param createTime
	 *            null.
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	/** @return null. */
	@Column(name = "TAGS", length = 200)
	public String getTags()
	{
		return this.tags;
	}

	/**
	 * @param tags
	 *            null.
	 */
	public void setTags(String tags)
	{
		this.tags = tags;
	}

	/** @return null. */
	@Column(name = "USER_ID", length = 64)
	public String getUserId()
	{
		return this.userId;
	}

	/**
	 * @param userId
	 *            null.
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
}
