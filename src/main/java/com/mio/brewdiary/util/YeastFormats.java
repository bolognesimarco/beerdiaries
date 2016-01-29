package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.HopFormat;
import com.mio.brewdiary.model.YeastFormat;

public class YeastFormats extends AbstractEntries {
	
	public final int YEAST_FORMAT_DRY_ALE=1;
	public final int YEAST_FORMAT_LIQUID_ALE=2;
	public final int YEAST_FORMAT_DRY_LAGER=3;
	public final int YEAST_FORMAT_LIQUID_LAGER=4;
	
	
	
	public YeastFormats() {
        s.put(YEAST_FORMAT_DRY_ALE, "dry ale");
        s.put(YEAST_FORMAT_LIQUID_ALE, "liquid ale");
        s.put(YEAST_FORMAT_DRY_LAGER, "dry lager");
        s.put(YEAST_FORMAT_LIQUID_LAGER, "liquid lager");
    }
	
	public Class getEntryType(){
		return YeastFormat.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((YeastFormat)obj).setId(values.getKey());
		((YeastFormat)obj).setName((String)values.getValue());
	}
}
