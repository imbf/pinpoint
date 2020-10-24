package com.navercorp.pinpoint.web.alarm.vo.sender.payload;

public class AlarmCheckerDetectedValue<T> implements CheckerDetectedValue {
    
    private T detectedValue;
    
    public AlarmCheckerDetectedValue(T detectedValue) {
        this.detectedValue = detectedValue;
    }
    
    public T getDetectedValue() {
        return detectedValue;
    }
}
