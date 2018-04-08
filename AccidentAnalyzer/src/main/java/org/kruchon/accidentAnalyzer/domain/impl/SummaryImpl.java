package org.kruchon.accidentAnalyzer.domain.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.kruchon.accidentAnalyzer.domain.Summary;

import java.util.List;

public class SummaryImpl implements Summary{
    private String query;

    public Query getQuery(Session session) {
        return session.createQuery(query);
    }

    public List execute(Session session){
        Query query = getQuery(session);
        return query.list();
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
