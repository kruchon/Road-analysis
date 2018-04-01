package org.kruchon.accidentAnalyzer.component.impl;

import org.kruchon.accidentAnalyzer.component.AccidentsHolder;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccidentsHolderImpl implements AccidentsHolder {
    List<Accident> accidents;

    public void setAccidents(List<Accident> accidents){
        this.accidents = accidents;
    }

    public List<Accident> getAccidents(){
        return accidents;
    }
}
