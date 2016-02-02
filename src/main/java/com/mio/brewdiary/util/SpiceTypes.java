package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.SpiceType;

public class SpiceTypes extends AbstractEntries {
	
	public static final int SPICE_TYPE_CANDY_BROWN_SUGAR=1;
	public static final int SPICE_TYPE_PINK_PEPPER=2;
	public static final int SPICE_TYPE_HONEY=3;
	public static final int SPICE_TYPE_MR_MALT_WINTER_ALE_MIX=4;
	
	
	
	public SpiceTypes() {
        s.put(SPICE_TYPE_CANDY_BROWN_SUGAR, "candy brown sugar");
        s.put(SPICE_TYPE_PINK_PEPPER, "pink pepper");
        s.put(SPICE_TYPE_HONEY, "honey");
        s.put(SPICE_TYPE_MR_MALT_WINTER_ALE_MIX, "mr malt's winter ale mix");
    }
	
	public Class getEntryType(){
		return SpiceType.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((SpiceType)obj).setId(values.getKey());
		((SpiceType)obj).setName((String)values.getValue());
	}
}
