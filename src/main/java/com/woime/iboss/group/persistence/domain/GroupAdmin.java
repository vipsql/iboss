package com.woime.iboss.group.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GroupAdmin .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "GROUP_ADMIN")
public class GroupAdmin implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private GroupInfo groupInfo;

	/** null. */
	private String userId;

	/** null. */
	private String tenantId;

	public GroupAdmin()
	{
	}

	public GroupAdmin(Long id)
	{
		this.id = id;
	}

	public GroupAdmin(Long id, GroupInfo groupInfo, String userId, String tenantId)
	{
		this.id = id;
		this.groupInfo = groupInfo;
		this.userId = userId;
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
}
