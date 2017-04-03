package com.woime.iboss.org.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JobLevel .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "JOB_LEVEL")
public class JobLevel implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private JobGrade jobGrade;

	/** null. */
	private String name;

	/** null. */
	private String tenantId;

	/** null. */
	private Integer priority;

	/** . */
	private Set<JobInfo> jobInfos = new HashSet<JobInfo>(0);

	public JobLevel()
	{
	}

	public JobLevel(Long id)
	{
		this.id = id;
	}

	public JobLevel(Long id, JobGrade jobGrade, String name, String tenantId, Integer priority, Set<JobInfo> jobInfos)
	{
		this.id = id;
		this.jobGrade = jobGrade;
		this.name = name;
		this.tenantId = tenantId;
		this.priority = priority;
		this.jobInfos = jobInfos;
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
	@JoinColumn(name = "GRADE_ID")
	public JobGrade getJobGrade()
	{
		return this.jobGrade;
	}

	/**
	 * @param jobGrade
	 *            null.
	 */
	public void setJobGrade(JobGrade jobGrade)
	{
		this.jobGrade = jobGrade;
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

	/** @return null. */
	@Column(name = "PRIORITY")
	public Integer getPriority()
	{
		return this.priority;
	}

	/**
	 * @param priority
	 *            null.
	 */
	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobLevel")
	public Set<JobInfo> getJobInfos()
	{
		return this.jobInfos;
	}

	/**
	 * @param jobInfos
	 *            .
	 */
	public void setJobInfos(Set<JobInfo> jobInfos)
	{
		this.jobInfos = jobInfos;
	}
}