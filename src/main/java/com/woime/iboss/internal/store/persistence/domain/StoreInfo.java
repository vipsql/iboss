package com.woime.iboss.internal.store.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StoreInfo .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "STORE_INFO")
public class StoreInfo implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private String name;

	/** null. */
	private String model;

	/** null. */
	private String path;

	/** null. */
	private String type;

	/** null. */
	private Long size;

	/** null. */
	private Date createTime;

	/** null. */
	private String tenantId;

	public StoreInfo()
	{
	}

	public StoreInfo(Long id)
	{
		this.id = id;
	}

	public StoreInfo(Long id, String name, String model, String path, String type, Long size, Date createTime, String tenantId)
	{
		this.id = id;
		this.name = name;
		this.model = model;
		this.path = path;
		this.type = type;
		this.size = size;
		this.createTime = createTime;
		this.tenantId = tenantId;
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
	@Column(name = "NAME", length = 200)
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name
	 *            null.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/** @return null. */
	@Column(name = "MODEL", length = 50)
	public String getModel()
	{
		return this.model;
	}

	/**
	 * @param model
	 *            null.
	 */
	public void setModel(String model)
	{
		this.model = model;
	}

	/** @return null. */
	@Column(name = "PATH", length = 200)
	public String getPath()
	{
		return this.path;
	}

	/**
	 * @param path
	 *            null.
	 */
	public void setPath(String path)
	{
		this.path = path;
	}

	/** @return null. */
	@Column(name = "TYPE", length = 50)
	public String getType()
	{
		return this.type;
	}

	/**
	 * @param type
	 *            null.
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/** @return null. */
	@Column(name = "SIZE_")
	public Long getSize()
	{
		return this.size;
	}

	/**
	 * @param size
	 *            null.
	 */
	public void setSize(Long size)
	{
		this.size = size;
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
	@Column(name = "TENANT_ID", length = 50)
	public String getTenantId()
	{
		return this.tenantId;
	}

	/**
	 * @param tenantId
	 *            null.
	 */
	public void setTenantId(String tenantId)
	{
		this.tenantId = tenantId;
	}
}
