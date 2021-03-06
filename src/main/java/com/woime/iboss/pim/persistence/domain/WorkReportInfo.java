package com.woime.iboss.pim.persistence.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WorkReportInfo .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "WORK_REPORT_INFO")
public class WorkReportInfo implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private String type;

	/** null. */
	private String content;

	/** null. */
	private Date reportDate;

	/** null. */
	private Date createTime;

	/** null. */
	private String userId;

	/** null. */
	private String tenantId;

	/** . */
	private Set<WorkReportAttachment> workReportAttachments = new HashSet<WorkReportAttachment>(0);

	/** . */
	private Set<WorkReportAcl> workReportAcls = new HashSet<WorkReportAcl>(0);

	public WorkReportInfo()
	{
	}

	public WorkReportInfo(Long id)
	{
		this.id = id;
	}

	public WorkReportInfo(Long id, String type, String content, Date reportDate, Date createTime, String userId, String tenantId, Set<WorkReportAttachment> workReportAttachments,
			Set<WorkReportAcl> workReportAcls)
	{
		this.id = id;
		this.type = type;
		this.content = content;
		this.reportDate = reportDate;
		this.createTime = createTime;
		this.userId = userId;
		this.tenantId = tenantId;
		this.workReportAttachments = workReportAttachments;
		this.workReportAcls = workReportAcls;
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
	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE", length = 10)
	public Date getReportDate()
	{
		return this.reportDate;
	}

	/**
	 * @param reportDate
	 *            null.
	 */
	public void setReportDate(Date reportDate)
	{
		this.reportDate = reportDate;
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

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workReportInfo")
	public Set<WorkReportAttachment> getWorkReportAttachments()
	{
		return this.workReportAttachments;
	}

	/**
	 * @param workReportAttachments
	 *            .
	 */
	public void setWorkReportAttachments(Set<WorkReportAttachment> workReportAttachments)
	{
		this.workReportAttachments = workReportAttachments;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workReportInfo")
	public Set<WorkReportAcl> getWorkReportAcls()
	{
		return this.workReportAcls;
	}

	/**
	 * @param workReportAcls
	 *            .
	 */
	public void setWorkReportAcls(Set<WorkReportAcl> workReportAcls)
	{
		this.workReportAcls = workReportAcls;
	}
}
