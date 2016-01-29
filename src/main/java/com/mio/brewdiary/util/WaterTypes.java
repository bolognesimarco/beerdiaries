package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.SpiceType;
import com.mio.brewdiary.model.WaterType;

public class WaterTypes extends AbstractEntries {
	
	public final int WATER_TYPE_TUB=1;
	
	
	
	public WaterTypes() {
        s.put(WATER_TYPE_TUB, "tub water");
    }
	
	public Class getEntryType(){
		return WaterType.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((WaterType)obj).setId(values.getKey());
		((WaterType)obj).setName((String)values.getValue());
	}
}
