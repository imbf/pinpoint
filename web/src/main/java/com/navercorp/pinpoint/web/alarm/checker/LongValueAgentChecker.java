package com.navercorp.pinpoint.web.alarm.checker;

import com.navercorp.pinpoint.web.alarm.collector.DataCollector;
import com.navercorp.pinpoint.web.alarm.vo.Rule;

public abstract class LongValueAgentChecker extends AgentChecker<Long> {
    
    protected LongValueAgentChecker(Rule rule, String unit, DataCollector dataCollector) {
        super(rule, unit, dataCollector);
    }
    
    @Override
    protected boolean decideResult(Long value) {
        return value >= rule.getThreshold();
    }
    
    @Override
    public String getCheckerType() {
        return LongValueAgentChecker.class.getSimpleName();
    }
    
}
