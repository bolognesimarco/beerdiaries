package com.mio.brewdiary.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.mio.brewdiary.model.HopFormat;
import com.mio.brewdiary.model.HopType;
import com.mio.brewdiary.model.Style;

public class HopTypes extends AbstractEntries {
	
	public final int HOP_TYPE_FUGGLE=1;
	public final int HOP_TYPE_SAAZ=2;
	public final int HOP_TYPE_TETTNANGER=3;
	
	
	
	public HopTypes() {
        s.put(HOP_TYPE_FUGGLE, "fuggle");
        s.put(HOP_TYPE_SAAZ, "saaz");
        s.put(HOP_TYPE_TETTNANGER, "tettnanger");
    }
	
	public Class getEntryType(){
		return HopType.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((HopType)obj).setId(values.getKey());
		((HopType)obj).setName((String)values.getValue());
	}
}
