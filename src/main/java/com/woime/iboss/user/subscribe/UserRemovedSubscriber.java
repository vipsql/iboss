package com.woime.iboss.user.subscribe;

import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.woime.iboss.api.tenant.TenantConnector;
import com.woime.iboss.api.tenant.TenantDTO;
import com.woime.iboss.api.user.UserCache;
import com.woime.iboss.api.user.UserDTO;
import com.woime.iboss.api.userauth.UserAuthCache;
import com.woime.iboss.api.userauth.UserAuthConnector;
import com.woime.iboss.api.userauth.UserAuthDTO;
import com.woime.iboss.core.mapper.JsonMapper;
import com.woime.iboss.core.subscribe.Subscribable;

@Component("com.woime.iboss.user.subscribe.UserRemovedSubscriber")
public class UserRemovedSubscriber implements Subscribable<String>
{
	private static Logger logger = LoggerFactory.getLogger(UserRemovedSubscriber.class);
	private JsonMapper jsonMapper = new JsonMapper();
	private String destinationName = "topic.user.notify.removed";
	private UserCache userCache;
	private UserAuthCache userAuthCache;
	private TenantConnector tenantConnector;
	private UserAuthConnector userAuthConnector;

	public void handleMessage(String message)
	{
		try
		{
			UserDTO userDto = jsonMapper.fromJson(message, UserDTO.class);

			userCache.removeUser(userDto);

			for (TenantDTO tenantDto : tenantConnector.findAll())
			{
				UserAuthDTO userAuthDto = userAuthConnector.findByUsername(userDto.getUsername(), tenantDto.getId());
				userAuthCache.removeUserAuth(userAuthDto);
			}

			logger.info("remove user : {}", message);
		}
		catch (IOException ex)
		{
			logger.error(ex.getMessage(), ex);
		}
	}

	public boolean isTopic()
	{
		return true;
	}

	public String getName()
	{
		return destinationName;
	}

	public void setDestinationName(String destinationName)
	{
		this.destinationName = destinationName;
	}

	@Resource
	public void setUserCache(UserCache userCache)
	{
		this.userCache = userCache;
	}

	@Resource
	public void setUserAuthCache(UserAuthCache userAuthCache)
	{
		this.userAuthCache = userAuthCache;
	}

	@Resource
	public void setTenantConnector(TenantConnector tenantConnector)
	{
		this.tenantConnector = tenantConnector;
	}

	@Resource
	public void setUserAuthConnector(UserAuthConnector userAuthConnector)
	{
		this.userAuthConnector = userAuthConnector;
	}
}
