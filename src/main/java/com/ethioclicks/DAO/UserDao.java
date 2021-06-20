package com.ethioclicks.DAO;

import com.ethioclicks.entity.UserInfo;

public interface UserDao {
	public void saveUser (UserInfo user);
	public long countUser ();
}


