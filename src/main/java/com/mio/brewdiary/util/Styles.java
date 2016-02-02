package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.Style;

public class Styles extends AbstractEntries {
	
	public static final int STYLE_ALE=1;
	public static final int STYLE_LAGER=2;
	public static final int STYLE_PALE_ALE=3;
	public static final int STYLE_WINTER_ALE=4;
	
	public Styles() {
        s.put(STYLE_ALE, "ale");
        s.put(STYLE_LAGER, "lager");
        s.put(STYLE_PALE_ALE, "pale ale");
        s.put(STYLE_WINTER_ALE, "winter ale");
    }
	
	public Class getEntryType(){
		return Style.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((Style)obj).setId(values.getKey());
		((Style)obj).setName((String)values.getValue());
	}
}
