package com.navercorp.pinpoint.web.alarm.vo.sender.payload;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.navercorp.pinpoint.web.alarm.checker.AlarmChecker;
import com.navercorp.pinpoint.web.batch.BatchConfiguration;
import com.navercorp.pinpoint.web.view.WebhookPayloadSerializer;

@JsonSerialize(using = WebhookPayloadSerializer.class)
public class WebhookPayload {
    
    private String pinpointUrl;
    private String batchEnv;
    private String applicationId;
    private String serviceType;
    private String checkerName;
    private String checkerType;
    private UserGroup userGroup;
    private CheckerDetectedValue checkerDetectedValue;
    private String unit;
    private Integer threshold;
    private String notes;
    private Integer sequenceCount;
    
    public WebhookPayload(AlarmChecker checker, BatchConfiguration batchConfiguration, int sequenceCount, UserGroup userGroup) {
        this.pinpointUrl = batchConfiguration.getPinpointUrl();
        this.batchEnv = batchConfiguration.getBatchEnv();
        this.applicationId = checker.getRule().getApplicationId();
        this.serviceType = checker.getRule().getServiceType();
        this.checkerName = checker.getRule().getCheckerName();
        this.checkerType = checker.getCheckerType();
        this.userGroup = userGroup;
        this.checkerDetectedValue = checker.getCheckerDetectedValue();
        this.unit = checker.getUnit();
        this.threshold = checker.getRule().getThreshold();
        this.notes = checker.getRule().getNotes();
        this.sequenceCount = sequenceCount;
    }
    
    public String getPinpointUrl() {
        return pinpointUrl;
    }
    
    public String getBatchEnv() {
        return batchEnv;
    }
    
    public String getApplicationId() {
        return applicationId;
    }
    
    public String getServiceType() {
        return serviceType;
    }
    
    public String getCheckerName() {
        return checkerName;
    }
    
    public String getCheckerType() {
        return checkerType;
    }
    
    public UserGroup getUserGroup() {
        return userGroup;
    }
    
    public CheckerDetectedValue getCheckerDetectedValue() {
        return checkerDetectedValue;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public Integer getThreshold() {
        return threshold;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public Integer getSequenceCount() {
        return sequenceCount;
    }
}
