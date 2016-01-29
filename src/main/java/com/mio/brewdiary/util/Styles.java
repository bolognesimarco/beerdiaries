package com.mio.brewdiary.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.mio.brewdiary.model.Style;

public class Styles extends AbstractEntries {
	
	public static final int STYLE_ALE=1;
	public static final int STYLE_LAGER=2;
	public static final int STYLE_PALE_ALE=3;
	
	
	private static Map<Integer, String> s = new HashMap<Integer, String>();
	static {
        s.put(STYLE_ALE, "ale");
        s.put(STYLE_LAGER, "lager");
        s.put(STYLE_PALE_ALE, "pale ale");
    }
	
	public Iterator<Map.Entry<Integer, String>> entries(){
		return s.entrySet().iterator();
	}
	
	public Class getEntryType(){
		return Style.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, String> values){
		((Style)obj).setId(values.getKey());
		((Style)obj).setName(values.getValue());
	}
}
