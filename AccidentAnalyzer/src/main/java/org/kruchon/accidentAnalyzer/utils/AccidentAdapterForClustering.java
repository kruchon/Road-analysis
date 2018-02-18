package org.kruchon.accidentAnalyzer.utils;

import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.kruchon.accidentAnalyzer.domain.Accident;

public class AccidentAdapterForClustering extends DoublePoint {

    private Accident accident;

    public AccidentAdapterForClustering(Accident accident) {
        super(new double[]{accident.getLatitude().doubleValue(), accident.getLongitude().doubleValue()});
        this.accident = accident;
    }

    Accident getAccident(){
        return accident;
    }


}
