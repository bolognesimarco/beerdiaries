package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.MaltType;

public class MaltTypes extends AbstractEntries {
	
	public static final int MALT_TYPE_MUNICH=1;
	public static final int MALT_TYPE_VIENNA=2;
	public static final int MALT_TYPE_CRYSTAL=3;
	public static final int MALT_TYPE_MARIS_OTTER=4;
	public static final int MALT_TYPE_BROWN=5;
	public static final int MALT_TYPE_CHOCOLATE=6;
	public static final int MALT_TYPE_CARA_120=7;
	
	
	
	public MaltTypes() {
        s.put(MALT_TYPE_MUNICH, "munich");
        s.put(MALT_TYPE_VIENNA, "vienna");
        s.put(MALT_TYPE_CRYSTAL, "crystal");
        s.put(MALT_TYPE_MARIS_OTTER, "maris otter");
        s.put(MALT_TYPE_BROWN, "brown");
        s.put(MALT_TYPE_BROWN, "chocolate");
        s.put(MALT_TYPE_CARA_120, "cara 120");
    }
	
	public Class getEntryType(){
		return MaltType.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((MaltType)obj).setId(values.getKey());
		((MaltType)obj).setName((String)values.getValue());
	}
}
