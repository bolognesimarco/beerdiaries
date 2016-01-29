package com.mio.brewdiary.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.mio.brewdiary.model.HopFormat;
import com.mio.brewdiary.model.HopType;
import com.mio.brewdiary.model.MaltType;
import com.mio.brewdiary.model.Style;

public class MaltTypes extends AbstractEntries {
	
	public final int MALT_TYPE_MUNICH=1;
	public final int MALT_TYPE_VIENNA=2;
	public final int MALT_TYPE_CRYSTAL=3;
	
	
	
	public MaltTypes() {
        s.put(MALT_TYPE_MUNICH, "munich");
        s.put(MALT_TYPE_VIENNA, "vienna");
        s.put(MALT_TYPE_CRYSTAL, "crystal");
    }
	
	public Class getEntryType(){
		return MaltType.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((MaltType)obj).setId(values.getKey());
		((MaltType)obj).setName((String)values.getValue());
	}
}
