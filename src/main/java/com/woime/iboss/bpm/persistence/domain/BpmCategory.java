package com.woime.iboss.bpm.persistence.domain;

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
 * BpmCategory 流程分类.
 * 
 * @author devaeye
 */
@Entity
@Table(name = "bpm_category")
public class BpmCategory implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** 主键. */
	private Long id;

	/** 名称. */
	private String name;

	/** 排序. */
	private Integer priority;

	/** 租户. */
	private String tenantId;

	/** . */
	private Set<BpmProcess> bpmProcesses = new HashSet<BpmProcess>(0);

	public BpmCategory()
	{
	}

	public BpmCategory(Long id)
	{
		this.id = id;
	}

	public BpmCategory(Long id, String name, Integer priority, String tenantId, Set<BpmProcess> bpmProcesses)
	{
		this.id = id;
		this.name = name;
		this.priority = priority;
		this.tenantId = tenantId;
		this.bpmProcesses = bpmProcesses;
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
	@Column(name = "NAME", length = 200)
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

	/** @return 租户. */
	@Column(name = "TENANT_ID", length = 64)
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bpmCategory")
	@OrderBy("priority")
	public Set<BpmProcess> getBpmProcesses()
	{
		return this.bpmProcesses;
	}

	/**
	 * @param bpmProcesses
	 *            .
	 */
	public void setBpmProcesses(Set<BpmProcess> bpmProcesses)
	{
		this.bpmProcesses = bpmProcesses;
	}
}
