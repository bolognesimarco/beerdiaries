package com.mio.brewdiary.util;

import java.util.Map;

import com.mio.brewdiary.model.MashPhase;

public class MashPhases extends AbstractEntries {
	
	public final int MASH_PHASE_MASH_IN=1;
	public final int MASH_PHASE_ACID_REST=2;
	public final int MASH_PHASE_PROTEIN_REST=3;
	public final int MASH_PHASE_BETA_AMILASI=4;
	public final int MASH_PHASE_ALFA_AMILASI=5;
	public final int MASH_PHASE_MASH_OUT=6;
	public final int MASH_PHASE_SACCARIFICAZIONE=7;
	
	
	
	public MashPhases() {
        s.put(MASH_PHASE_MASH_IN, "mash in");
        s.put(MASH_PHASE_ACID_REST, "acid rest");
        s.put(MASH_PHASE_PROTEIN_REST, "protein rest");
        s.put(MASH_PHASE_BETA_AMILASI, "beta amilasi");
        s.put(MASH_PHASE_ALFA_AMILASI, "alfa amilasi");
        s.put(MASH_PHASE_MASH_OUT, "mash out");
        s.put(MASH_PHASE_SACCARIFICAZIONE, "saccarificazione");
    }
	
	public Class getEntryType(){
		return MashPhase.class;
	}
	
	public void setter(Object obj, Map.Entry<Integer, Object> values){
		((MashPhase)obj).setId(values.getKey());
		((MashPhase)obj).setName((String)values.getValue());
	}
}
