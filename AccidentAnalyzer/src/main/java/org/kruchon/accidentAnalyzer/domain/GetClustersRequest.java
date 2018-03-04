package org.kruchon.accidentAnalyzer.domain;

public class GetClustersRequest {
    private Integer minSize;
    private Float minPercent;

    public Integer getMinSize() {
        return minSize;
    }

    public void setMinSize(Integer minSize) {
        this.minSize = minSize;
    }

    public Float getMinPercent() {
        return minPercent;
    }

    public void setMinPercent(Float minPercent) {
        this.minPercent = minPercent;
    }
}
