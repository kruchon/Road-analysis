package org.kruchon.accidentAnalyzer.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="SUMMARIES")
public class Summary implements Serializable{
    private static final long serialVersionUID = 5323700715449849741L;
    private String query;

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
