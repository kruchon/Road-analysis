package org.kruchon.accidentAnalyzer.utils;

import java.math.BigDecimal;

public interface AccidentConst {
    BigDecimal ACCIDENT_ZONE_DIAMETER_FOR_CLUSTERING = new BigDecimal("0.5"); //degrees, no minutes/seconds
    Float NUMBER_OF_CLUSTERS_TO_TOTAL_SIZE = 0.5f;
}

