package com.woime.iboss.model.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ModelInfo .
 * 
 * @author devaeye
 */
@Entity
@Table(name = "MODEL_INFO")
public class ModelInfo implements java.io.Serializable
{
	private static final long serialVersionUID = 0L;

	/** null. */
	private Long id;

	/** null. */
	private String code;

	/** null. */
	private String name;

	/** null. */
	private String type;

	/** null. */
	private String tenantId;

	/** . */
	private Set<ModelField> modelFields = new HashSet<ModelField>(0);

	public ModelInfo()
	{
	}

	public ModelInfo(Long id)
	{
		this.id = id;
	}

	public ModelInfo(Long id, String code, String name, String type, String tenantId, Set<ModelField> modelFields)
	{
		this.id = id;
		this.code = code;
		this.name = name;
		this.type = type;
		this.tenantId = tenantId;
		this.modelFields = modelFields;
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
	@Column(name = "CODE", length = 200)
	public String getCode()
	{
		return this.code;
	}

	/**
	 * @param code
	 *            null.
	 */
	public void setCode(String code)
	{
		this.code = code;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modelInfo")
	public Set<ModelField> getModelFields()
	{
		return this.modelFields;
	}

	/**
	 * @param modelFields
	 *            .
	 */
	public void setModelFields(Set<ModelField> modelFields)
	{
		this.modelFields = modelFields;
	}
}
