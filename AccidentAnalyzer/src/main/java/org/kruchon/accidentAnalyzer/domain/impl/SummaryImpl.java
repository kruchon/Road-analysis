package org.kruchon.accidentAnalyzer.domain.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.kruchon.accidentAnalyzer.domain.Summary;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="SUMMARIES")
public class SummaryImpl implements Summary{
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

    public Query getQuery(Session session) {
        return session.createSQLQuery(query);
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
