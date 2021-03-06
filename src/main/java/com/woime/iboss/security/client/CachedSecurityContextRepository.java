package com.woime.iboss.security.client;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import com.woime.iboss.api.userauth.UserAuthConnector;
import com.woime.iboss.api.userauth.UserAuthDTO;
import com.woime.iboss.core.mapper.BeanMapper;
import com.woime.iboss.security.impl.SpringSecurityUserAuth;
import com.woime.iboss.security.util.SpringSecurityUtils;

public class CachedSecurityContextRepository extends HttpSessionSecurityContextRepository
{
	private UserAuthConnector userAuthConnector;
	private BeanMapper beanMapper = new BeanMapper();
	private boolean debug;

	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder)
	{
		SecurityContext securityContext = super.loadContext(requestResponseHolder);

		if (securityContext == null)
		{
			logger.debug("securityContext is null");

			return null;
		}

		if (debug)
		{
			return securityContext;
		}

		SpringSecurityUserAuth userAuthInSession = SpringSecurityUtils.getCurrentUser(securityContext);

		if (userAuthInSession == null)
		{
			logger.debug("userAuthInSession is null");

			return securityContext;
		}

		UserAuthDTO userAuthInCache = userAuthConnector.findById(userAuthInSession.getId(), userAuthInSession.getTenantId());

		SpringSecurityUserAuth userAuthResult = new SpringSecurityUserAuth();
		beanMapper.copy(userAuthInCache, userAuthResult);

		SpringSecurityUtils.saveUserDetailsToContext(userAuthResult, null, securityContext);

		return securityContext;
	}

	public void setUserAuthConnector(UserAuthConnector userAuthConnector)
	{
		this.userAuthConnector = userAuthConnector;
	}

	public void setDebug(boolean debug)
	{
		this.debug = debug;
	}
}
