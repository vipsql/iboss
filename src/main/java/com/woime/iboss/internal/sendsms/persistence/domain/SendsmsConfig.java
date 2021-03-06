package com.woime.iboss.internal.sendsms.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SendsmsConfig .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "SENDSMS_CONFIG")
public class SendsmsConfig implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private String name;

	/** null. */
	private String host;

	/** null. */
	private String username;

	/** null. */
	private String password;

	/** null. */
	private String appId;

	/** null. */
	private String description;

	/** null. */
	private String mobileFieldName;

	/** null. */
	private String messageFieldName;

	/** null. */
	private String tenantId;

	/** . */
	private Set<SendsmsHistory> sendsmsHistories = new HashSet<SendsmsHistory>(0);

	/** . */
	private Set<SendsmsQueue> sendsmsQueues = new HashSet<SendsmsQueue>(0);

	public SendsmsConfig()
	{
	}

	public SendsmsConfig(Long id)
	{
		this.id = id;
	}

	public SendsmsConfig(Long id, String name, String host, String username, String password, String appId, String description, String mobileFieldName, String messageFieldName, String tenantId,
			Set<SendsmsHistory> sendsmsHistories, Set<SendsmsQueue> sendsmsQueues)
	{
		this.id = id;
		this.name = name;
		this.host = host;
		this.username = username;
		this.password = password;
		this.appId = appId;
		this.description = description;
		this.mobileFieldName = mobileFieldName;
		this.messageFieldName = messageFieldName;
		this.tenantId = tenantId;
		this.sendsmsHistories = sendsmsHistories;
		this.sendsmsQueues = sendsmsQueues;
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
	@Column(name = "HOST", length = 200)
	public String getHost()
	{
		return this.host;
	}

	/**
	 * @param host
	 *            null.
	 */
	public void setHost(String host)
	{
		this.host = host;
	}

	/** @return null. */
	@Column(name = "USERNAME", length = 200)
	public String getUsername()
	{
		return this.username;
	}

	/**
	 * @param username
	 *            null.
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/** @return null. */
	@Column(name = "PASSWORD", length = 200)
	public String getPassword()
	{
		return this.password;
	}

	/**
	 * @param password
	 *            null.
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/** @return null. */
	@Column(name = "APP_ID", length = 50)
	public String getAppId()
	{
		return this.appId;
	}

	/**
	 * @param appId
	 *            null.
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
	}

	/** @return null. */
	@Column(name = "DESCRIPTION", length = 200)
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * @param description
	 *            null.
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/** @return null. */
	@Column(name = "MOBILE_FIELD_NAME", length = 50)
	public String getMobileFieldName()
	{
		return this.mobileFieldName;
	}

	/**
	 * @param mobileFieldName
	 *            null.
	 */
	public void setMobileFieldName(String mobileFieldName)
	{
		this.mobileFieldName = mobileFieldName;
	}

	/** @return null. */
	@Column(name = "MESSAGE_FIELD_NAME", length = 50)
	public String getMessageFieldName()
	{
		return this.messageFieldName;
	}

	/**
	 * @param messageFieldName
	 *            null.
	 */
	public void setMessageFieldName(String messageFieldName)
	{
		this.messageFieldName = messageFieldName;
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

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sendsmsConfig")
	public Set<SendsmsHistory> getSendsmsHistories()
	{
		return this.sendsmsHistories;
	}

	/**
	 * @param sendsmsHistories
	 *            .
	 */
	public void setSendsmsHistories(Set<SendsmsHistory> sendsmsHistories)
	{
		this.sendsmsHistories = sendsmsHistories;
	}

	/** @return . */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sendsmsConfig")
	public Set<SendsmsQueue> getSendsmsQueues()
	{
		return this.sendsmsQueues;
	}

	/**
	 * @param sendsmsQueues
	 *            .
	 */
	public void setSendsmsQueues(Set<SendsmsQueue> sendsmsQueues)
	{
		this.sendsmsQueues = sendsmsQueues;
	}
}
