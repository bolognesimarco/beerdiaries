package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.HopType;

public class HopTypes extends AbstractEntries {
	
	public static final int HOP_TYPE_FUGGLE=1;
	public static final int HOP_TYPE_SAAZ=2;
	public static final int HOP_TYPE_TETTNANGER=3;
	public static final int HOP_TYPE_KENT_GOLDING=4;
	
	
	
	public HopTypes() {
        s.put(HOP_TYPE_FUGGLE, "fuggle|3.91");
        s.put(HOP_TYPE_SAAZ, "saaz|3.34");
        s.put(HOP_TYPE_TETTNANGER, "tettnanger|3.30");
        s.put(HOP_TYPE_KENT_GOLDING, "kent golding|5.02");
    }
	
	public Class getEntryType(){
		return HopType.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		String[] words=((String)values.getValue()).split("|");
		((HopType)obj).setId(values.getKey());
		((HopType)obj).setName(words[0]);
		((HopType)obj).setAa(new Double(words[1]));
	}
}
