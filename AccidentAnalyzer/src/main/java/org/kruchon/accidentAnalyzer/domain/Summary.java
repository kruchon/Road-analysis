package org.kruchon.accidentAnalyzer.domain;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public interface Summary {
    Query getQuery(Session session);
    void setQuery();
    List execute(Session session);
}