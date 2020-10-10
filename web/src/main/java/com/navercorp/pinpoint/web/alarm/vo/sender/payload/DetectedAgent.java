package com.navercorp.pinpoint.web.alarm.vo.sender.payload;

public class DetectedAgent<T> {
    
    private String agentId;
    private T agentValue;
    
    public DetectedAgent(String agentId, T agentValue) {
        this.agentId = agentId;
        this.agentValue = agentValue;
    }
    
    public String getAgentId() {
        return agentId;
    }
    
    public T getAgentValue() {
        return agentValue;
    }
}
