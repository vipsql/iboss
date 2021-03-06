package com.woime.iboss.sign.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SignInfo .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "SIGN_INFO")
public class SignInfo implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private String userId;

	/** null. */
	private Date createTime;

	/** null. */
	private String catalog;

	/** null. */
	private String type;

	/** null. */
	private String ref;

	/** null. */
	private String tenantId;

	public SignInfo()
	{
	}

	public SignInfo(Long id)
	{
		this.id = id;
	}

	public SignInfo(Long id, String userId, Date createTime, String catalog, String type, String ref, String tenantId)
	{
		this.id = id;
		this.userId = userId;
		this.createTime = createTime;
		this.catalog = catalog;
		this.type = type;
		this.ref = ref;
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
	@Column(name = "CATALOG", length = 50)
	public String getCatalog()
	{
		return this.catalog;
	}

	/**
	 * @param catalog
	 *            null.
	 */
	public void setCatalog(String catalog)
	{
		this.catalog = catalog;
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
	@Column(name = "REF", length = 100)
	public String getRef()
	{
		return this.ref;
	}

	/**
	 * @param ref
	 *            null.
	 */
	public void setRef(String ref)
	{
		this.ref = ref;
	}

	/** @return null. */
	@Column(name = "TENANT_ID", length = 64)
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
