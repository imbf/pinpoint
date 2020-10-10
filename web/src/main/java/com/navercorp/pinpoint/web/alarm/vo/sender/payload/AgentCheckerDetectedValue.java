package com.navercorp.pinpoint.web.alarm.vo.sender.payload;

import java.util.List;

public class AgentCheckerDetectedValue<T> extends CheckerDetectedValue {
    
    private List<DetectedAgent<T>> detectedAgents;
    
    public AgentCheckerDetectedValue(List<DetectedAgent<T>> detectedAgents) {
        this.detectedAgents = detectedAgents;
    }
    
    public List<DetectedAgent<T>> getDetectedAgents() {
        return detectedAgents;
    }
}
