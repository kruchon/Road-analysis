package org.kruchon.accidentAnalyzer.utils;

import org.kruchon.accidentAnalyzer.domain.SummaryResultValue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class AccidentConverter {
    public HashMap<String,List<String>> convertToTable(List<SummaryResultValue> resultValues) {
        HashMap<String, List<String>> resultTable = new HashMap<String, List<String>>();
        for(SummaryResultValue resultValue : resultValues){
            String columnName = resultValue.getColumnName();
            String value = resultValue.getValue();
            if(!resultTable.containsKey(columnName)){
                resultTable.put(columnName,new ArrayList<String>());
            }
            resultTable.get(columnName).add(value);
        }
        return resultTable;
    }
}
