package org.kruchon.accidentAnalyzer.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="SUMMARY_RESULT_VALUES")
public class SummaryResultValue implements Serializable {
    private static final long serialVersionUID = -815329304549996209L;
    private Integer resultLine;
    private String columnName;
    private String value;

    @ManyToOne
    @JoinColumn(name = "summary_id")
    private Summary summary;

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Integer getResultLine() {
        return resultLine;
    }

    public void setResultLine(Integer resultLine) {
        this.resultLine = resultLine;
    }
}
