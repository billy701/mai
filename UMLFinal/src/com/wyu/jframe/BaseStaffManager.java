package com.wyu.jframe;

import java.util.List;

import com.wyu.dao.StaffDAO;
import com.wyu.mapping.Staff;

public class BaseStaffManager implements AccessInterFace{

	private static BaseStaffManager baseStaffManager;
	private StaffDAO staffDAO;
	
	public static BaseStaffManager getInstance()
	{
		if( baseStaffManager == null)
			baseStaffManager = new BaseStaffManager();
		return baseStaffManager;
	}
	
	private BaseStaffManager() {
		
	}

	@Override
	public void delete(int id) {
		staffDAO.delete(id);
		
	}

	@Override
	public Object getById(int id) {
		return staffDAO.getById(id);
	}

	@Override
	public void update(Object user) {
		staffDAO.update((Staff) user);
		
	}

	@Override
	public void save(Object user) {
		staffDAO.save((Staff) user);
		
	}
	
	public List<Staff> findAll()
	{
		return staffDAO.findAll();
	}

}
