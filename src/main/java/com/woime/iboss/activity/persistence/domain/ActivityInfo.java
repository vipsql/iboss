package com.woime.iboss.activity.persistence.domain;

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
 * ActivityInfo .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "activity_info")
public class ActivityInfo implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private String name;

	/** null. */
	private String content;

	/** null. */
	private String location;

	/** null. */
	private String status;

	/** null. */
	private Date createTime;

	/** null. */
	private Date startTime;

	/** null. */
	private Date endTime;

	/** null. */
	private Date openTime;

	/** null. */
	private Date closeTime;

	/** null. */
	private Integer headCount;

	/** null. */
	private String userId;

	/** null. */
	private String tenantId;

	/** . */
	private Set<ActivityUser> activityUsers = new HashSet<ActivityUser>(0);

	public ActivityInfo()
	{
	}

	public ActivityInfo(Long id)
	{
		this.id = id;
	}

	public ActivityInfo(Long id, String name, String content, String location, String status, Date createTime, Date startTime, Date endTime, Date openTime, Date closeTime, Integer headCount,
			String userId, String tenantId, Set<ActivityUser> activityUsers)
	{
		this.id = id;
		this.name = name;
		this.content = content;
		this.location = location;
		this.status = status;
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.headCount = headCount;
		this.userId = userId;
		this.tenantId = tenantId;
		this.activityUsers = activityUsers;
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
	@Column(name = "CONTENT", length = 65535)
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
	@Column(name = "LOCATION", length = 200)
	public String getLocation()
	{
		return this.location;
	}

	/**
	 * @param location
	 *            null.
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}

	/** @return null. */
	@Column(name = "STATUS", length = 50)
	public String getStatus()
	{
		return this.status;
	}

	/**
	 * @param status
	 *            null.
	 */
	public void setStatus(String status)
	{
		this.status = status;
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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_TIME", length = 26)
	public Date getStartTime()
	{
		return this.startTime;
	}

	/**
	 * @param startTime
	 *            null.
	 */
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	/** @return null. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_TIME", length = 26)
	public Date getEndTime()
	{
		return this.endTime;
	}

	/**
	 * @param endTime
	 *            null.
	 */
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	/** @return null. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPEN_TIME", length = 26)
	public Date getOpenTime()
	{
		return this.openTime;
	}

	/**
	 * @param openTime
	 *            null.
	 */
	public void setOpenTime(Date openTime)
	{
		this.openTime = openTime;
	}

	/** @return null. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLOSE_TIME", length = 26)
	public Date getCloseTime()
	{
		return this.closeTime;
	}

	/**
	 * @param closeTime
	 *            null.
	 */
	public void setCloseTime(Date closeTime)
	{
		this.closeTime = closeTime;
	}

	/** @return null. */
	@Column(name = "HEAD_COUNT")
	public Integer getHeadCount()
	{
		return this.headCount;
	}

	/**
	 * @param headCount
	 *            null.
	 */
	public void setHeadCount(Integer headCount)
	{
		this.headCount = headCount;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activityInfo")
	public Set<ActivityUser> getActivityUsers()
	{
		return this.activityUsers;
	}

	/**
	 * @param activityUsers
	 *            .
	 */
	public void setActivityUsers(Set<ActivityUser> activityUsers)
	{
		this.activityUsers = activityUsers;
	}
}