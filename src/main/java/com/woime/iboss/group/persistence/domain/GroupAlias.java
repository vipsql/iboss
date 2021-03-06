package com.woime.iboss.group.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GroupAlias .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "GROUP_ALIAS")
public class GroupAlias implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private GroupInfo groupInfo;

	/** null. */
	private String name;

	/** null. */
	private String catalog;

	/** null. */
	private String tenantId;

	public GroupAlias()
	{
	}

	public GroupAlias(Long id)
	{
		this.id = id;
	}

	public GroupAlias(Long id, GroupInfo groupInfo, String name, String catalog, String tenantId)
	{
		this.id = id;
		this.groupInfo = groupInfo;
		this.name = name;
		this.catalog = catalog;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INFO_ID")
	public GroupInfo getGroupInfo()
	{
		return this.groupInfo;
	}

	/**
	 * @param groupInfo
	 *            null.
	 */
	public void setGroupInfo(GroupInfo groupInfo)
	{
		this.groupInfo = groupInfo;
	}

	/** @return null. */
	@Column(name = "NAME", length = 50)
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
	@Column(name = "CATALOG", length = 100)
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
