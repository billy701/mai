package com.wyu.jframe;

import java.util.List;

import com.wyu.dao.StaffDAO;
import com.wyu.mapping.Staff;

public class LoginWork {

	private StaffDAO staffdao;
	private static LoginWork loginwork;
	private List<Staff> listaccount;
	private LoginWork() {
	
	}
	
	public static LoginWork getInstance(){
		if( loginwork == null)
			loginwork = new LoginWork();
		return loginwork;
	}
	
	public boolean checkAccount(Account account){
		listaccount = staffdao.findAll();
		int maxsize = listaccount.size();
		for(int i = 0; i < maxsize;++i)
		{
			Staff staff = listaccount.get(i);
			if(staff.getName().equals(account.getAccount())
					&& staff.getPassword().equals(account.getPassword())
					&& staff.getDuty().equals(account.getDuty()))
				return true;
		}
		return false;
		
	}
	

}
