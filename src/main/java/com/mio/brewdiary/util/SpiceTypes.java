package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.SpiceType;

public class SpiceTypes extends AbstractEntries {
	
	public final int SPICE_TYPE_CANDY_SUGAR=1;
	public final int SPICE_TYPE_PINK_PEPPER=2;
	public final int SPICE_TYPE_HONEY=3;
	
	
	
	public SpiceTypes() {
        s.put(SPICE_TYPE_CANDY_SUGAR, "candy sugar");
        s.put(SPICE_TYPE_PINK_PEPPER, "pink pepper");
        s.put(SPICE_TYPE_HONEY, "honey");
    }
	
	public Class getEntryType(){
		return SpiceType.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((SpiceType)obj).setId(values.getKey());
		((SpiceType)obj).setName((String)values.getValue());
	}
}
