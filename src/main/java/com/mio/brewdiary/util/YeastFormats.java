package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.YeastFormat;

public class YeastFormats extends AbstractEntries {
	
	public static final int YEAST_FORMAT_DRY=1;
	public static final int YEAST_FORMAT_LIQUID=2;
	
	
	
	public YeastFormats() {
        s.put(YEAST_FORMAT_DRY, "dry");
        s.put(YEAST_FORMAT_LIQUID, "liquid");
    }
	
	public Class getEntryType(){
		return YeastFormat.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((YeastFormat)obj).setId(values.getKey());
		((YeastFormat)obj).setName((String)values.getValue());
	}
}
