package com.woime.iboss.auth.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * PermType 权限类型.
 * 
 * @author devaeye
 */
@Entity
@Table(name = "auth_perm_type")
public class PermType implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** 主键. */
	private Long id;

	/** 名称. */
	private String name;

	/** 类型. */
	private Integer type;

	/** 排序. */
	private Integer priority;

	/** 备注. */
	private String descn;

	/** 租户. */
	private String tenantId;

	/** . */
	private Set<Perm> perms = new HashSet<Perm>(0);

	public PermType()
	{
	}

	public PermType(Long id)
	{
		this.id = id;
	}

	public PermType(Long id, String name, Integer type, Integer priority, String descn, String tenantId, Set<Perm> perms)
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.priority = priority;
		this.descn = descn;
		this.tenantId = tenantId;
		this.perms = perms;
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

	/** @return 名称. */
	@Column(name = "NAME", length = 50)
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name
	 *            名称.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/** @return 类型. */
	@Column(name = "TYPE")
	public Integer getType()
	{
		return this.type;
	}

	/**
	 * @param type
	 *            类型.
	 */
	public void setType(Integer type)
	{
		this.type = type;
	}

	/** @return 排序. */
	@Column(name = "PRIORITY")
	public Integer getPriority()
	{
		return this.priority;
	}

	/**
	 * @param priority
	 *            排序.
	 */
	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}

	/** @return 备注. */
	@Column(name = "DESCN", length = 200)
	public String getDescn()
	{
		return this.descn;
	}

	/**
	 * @param descn
	 *            备注.
	 */
	public void setDescn(String descn)
	{
		this.descn = descn;
	}

	/** @return 租户. */
	@Column(name = "TENANT_ID", length = 50)
	public String getTenantId()
	{
		return this.tenantId;
	}

	/**
	 * @param tenantId
	 *            租户.
	 */
	public void setTenantId(String tenantId)
	{
		this.tenantId = tenantId;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permType")
	@OrderBy("priority")
	public Set<Perm> getPerms()
	{
		return this.perms;
	}

	/**
	 * @param perms
	 *            .
	 */
	public void setPerms(Set<Perm> perms)
	{
		this.perms = perms;
	}
}
