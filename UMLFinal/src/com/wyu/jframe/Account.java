package com.wyu.jframe;

public class Account {

	private String account;
	private String password;
	private String duty;
	public Account(String ac,String pa,String du) {
		account = ac;
		password = pa;
		duty = du;
	}
	
	public String getAccount()
	{
		return account;
	}
	
	public String getPassword()
	{
		return password;
	}

	public String getDuty()
	{
		return duty;
	}
}
