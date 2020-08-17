package com.navercorp.pinpoint.web.alarm.vo;

import java.util.Map;

public class AgentCheckerValue<T> extends CheckerValue {

    private Map<String, T> agentValue;

    public AgentCheckerValue(String unit, Map<String, T> agentValue) {
        super(unit);
        this.agentValue = agentValue;
    }

    public Map<String, T> getAgentValue() {
        return agentValue;
    }
}
