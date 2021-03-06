package com.woime.iboss.security.perm;

import com.woime.iboss.security.util.SpringSecurityUtils;

public class PermissionChecker
{
	private PermissionMatcher permissionMatcher = new PermissionMatcher();

	public boolean isAuthorized(String text)
	{
		String want = text;

		for (String have : SpringSecurityUtils.getAuthorities())
		{
			if (permissionMatcher.match(want, have))
			{
				return true;
			}
		}

		return false;
	}

	public void setReadOnly(boolean readOnly)
	{
		permissionMatcher.setReadOnly(readOnly);
	}

	public boolean isReadOnly()
	{
		return permissionMatcher.isReadOnly();
	}
}
