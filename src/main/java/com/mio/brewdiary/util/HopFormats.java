package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.HopFormat;

public class HopFormats extends AbstractEntries {
	
	public static final int HOP_FORMAT_PELLET=1;
	public static final int HOP_FORMAT_PLUGS=2;
	public static final int HOP_FORMAT_LEAF=3;
	
	
	
	public HopFormats() {
        s.put(HOP_FORMAT_PELLET, "pellet");
        s.put(HOP_FORMAT_PLUGS, "plugs");
        s.put(HOP_FORMAT_LEAF, "whole leaf");
    }
	
	public Class getEntryType(){
		return HopFormat.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((HopFormat)obj).setId(values.getKey());
		((HopFormat)obj).setName((String)values.getValue());
	}
}
