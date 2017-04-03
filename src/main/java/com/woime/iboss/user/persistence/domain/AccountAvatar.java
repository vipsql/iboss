package com.woime.iboss.user.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AccountAvatar 头像.
 * 
 * @author devaeye
 */
@Entity
@Table(name = "ACCOUNT_AVATAR")
public class AccountAvatar implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** 主键. */
	private Long id;

	/** 外键，账号信息. */
	private AccountInfo accountInfo;

	/** 类型. */
	private String type;

	/** 附件路径. */
	private String code;

	/** 租户. */
	private String tenantId;

	public AccountAvatar()
	{
	}

	public AccountAvatar(Long id)
	{
		this.id = id;
	}

	public AccountAvatar(Long id, AccountInfo accountInfo, String type, String code, String tenantId)
	{
		this.id = id;
		this.accountInfo = accountInfo;
		this.type = type;
		this.code = code;
		this.tenantId = tenantId;
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

	/** @return 外键，账号信息. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	public AccountInfo getAccountInfo()
	{
		return this.accountInfo;
	}

	/**
	 * @param accountInfo
	 *            外键，账号信息.
	 */
	public void setAccountInfo(AccountInfo accountInfo)
	{
		this.accountInfo = accountInfo;
	}

	/** @return 类型. */
	@Column(name = "TYPE", length = 50)
	public String getType()
	{
		return this.type;
	}

	/**
	 * @param type
	 *            类型.
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/** @return 附件路径. */
	@Column(name = "CODE", length = 200)
	public String getCode()
	{
		return this.code;
	}

	/**
	 * @param code
	 *            附件路径.
	 */
	public void setCode(String code)
	{
		this.code = code;
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
}