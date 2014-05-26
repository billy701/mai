package com.wyu.jframe;

import java.util.List;

import com.wyu.dao.RecordDAO;
import com.wyu.mapping.Record;

public class RecordManager implements AccessInterFace{
	private RecordDAO recordDAO;
	private static RecordManager recordManger;
	
	public static RecordManager getInstance()
	{
		if(recordManger == null)
			recordManger = new RecordManager();
		return recordManger;
	}

	private RecordManager() {
		
	}

	@Override
	public void delete(int id) {
		recordDAO.delete(id);
	}

	@Override
	public Object getById(int id) {
		return recordDAO.getById(id);
	}

	@Override
	public void update(Object user) {
		recordDAO.update((Record) user);
		
	}

	@Override
	public void save(Object user) {
		recordDAO.save((Record) user);
		
	}

	public List<Record> findAll() {
		return recordDAO.findAll();
	}
	
	
}
