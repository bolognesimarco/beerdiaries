package com.mio.brewdiary.util;

import java.util.Iterator;
import java.util.Map;

public abstract class AbstractEntries {
	public abstract Iterator<Map.Entry<Integer, String>> entries();
	public abstract Class getEntryType();
	public abstract void setter(Object obj, Map.Entry<Integer, String> values);
}
