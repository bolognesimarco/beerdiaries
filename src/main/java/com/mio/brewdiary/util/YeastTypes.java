package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.YeastType;

public class YeastTypes extends AbstractEntries {
	
	public static final int YEAST_TYPE_WYEAST_1056=1;
	public static final int YEAST_TYPE_WYEAST_1084=2;
	public static final int YEAST_TYPE_SAFBREW_ABBAYE=3;
	
	
	public YeastTypes() {
        s.put(YEAST_TYPE_WYEAST_1056, "wyeast 1056");
        s.put(YEAST_TYPE_WYEAST_1056, "wyeast 1056");
        s.put(YEAST_TYPE_SAFBREW_ABBAYE, "safbrew abbaye");
    }
	
	public Class getEntryType(){
		return YeastType.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((YeastType)obj).setId(values.getKey());
		((YeastType)obj).setName((String)values.getValue());
	}
}
