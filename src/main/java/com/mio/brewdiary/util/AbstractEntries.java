package com.mio.brewdiary.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractEntries {
	Map<Integer, Object> s = new HashMap<Integer, Object>();
	public Iterator<Map.Entry<Integer, Object>> entries(){
		return s.entrySet().iterator();
	}
	public abstract Class getEntryType();
	public abstract void setter(Object obj, Map.Entry<Integer, Object> values);
}
