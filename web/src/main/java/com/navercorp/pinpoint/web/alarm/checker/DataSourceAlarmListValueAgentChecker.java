package com.navercorp.pinpoint.web.alarm.checker;

import com.navercorp.pinpoint.web.alarm.collector.DataCollector;
import com.navercorp.pinpoint.web.alarm.vo.DataSourceAlarmVO;
import com.navercorp.pinpoint.web.alarm.vo.Rule;

import java.util.List;

public abstract class DataSourceAlarmListValueAgentChecker extends AgentChecker<List<DataSourceAlarmVO>> {
    
    protected DataSourceAlarmListValueAgentChecker(Rule rule, String unit, DataCollector dataCollector) {
        super(rule, unit, dataCollector);
    }
    
    @Override
    public String getCheckerType() {
        return DataSourceAlarmListValueAgentChecker.class.getSimpleName();
    }
    
}
