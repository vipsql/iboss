package com.woime.iboss.user.persistence.manager;

import org.springframework.stereotype.Service;

import com.woime.iboss.core.hibernate.HibernateEntityDao;
import com.woime.iboss.user.persistence.domain.AccountAvatar;

@Service
public class AccountAvatarManager extends HibernateEntityDao<AccountAvatar>
{
}
