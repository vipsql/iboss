package com.woime.iboss.api.dict;

public interface DictConnector
{
	DictDTO findDictByName(String dictName, String typeName, String tenantId);

	DictDTO findDictByType(String typeName, String tenantId);
}