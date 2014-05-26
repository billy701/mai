package com.wyu.jframe;

import java.util.List;

import com.wyu.mapping.Record;

public interface AccessInterFace {
	abstract void delete(int id);
	abstract Object getById(int id);
	abstract void update(Object user);
	abstract void save(Object user);
}
