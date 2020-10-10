package com.navercorp.pinpoint.web.view;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.navercorp.pinpoint.web.alarm.vo.sender.payload.AgentCheckerDetectedValue;
import com.navercorp.pinpoint.web.alarm.vo.sender.payload.AlarmCheckerDetectedValue;
import com.navercorp.pinpoint.web.alarm.vo.sender.payload.CheckerDetectedValue;
import com.navercorp.pinpoint.web.alarm.vo.sender.payload.WebhookPayload;

import java.io.IOException;

public class WebhookPayloadSerializer extends JsonSerializer<WebhookPayload> {
    private static final String LONG_VALUE_ALARM_CHECKER = "LongValueAlarmChecker";
    
    @Override
    public void serialize(WebhookPayload webhookPayload, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
        jgen.writeStartObject();
        
        jgen.writeStringField("pinpointUrl", webhookPayload.getPinpointUrl());
        jgen.writeStringField("batchEnv", webhookPayload.getBatchEnv());
        jgen.writeStringField("applicationId", webhookPayload.getApplicationId());
        jgen.writeStringField("serviceType", webhookPayload.getServiceType());
        jgen.writeStringField("checkerName", webhookPayload.getCheckerName());
        jgen.writeStringField("checkerType", webhookPayload.getCheckerType());
        jgen.writeObjectField("userGroup", webhookPayload.getUserGroup());
        
        CheckerDetectedValue checkerDetectedValue = webhookPayload.getCheckerDetectedValue();
        if (webhookPayload.getCheckerType().equals(LONG_VALUE_ALARM_CHECKER)) {
            jgen.writeObjectField("checkerDetectedValue", ((AlarmCheckerDetectedValue) checkerDetectedValue).getDetectedValue());
        } else {
            jgen.writeObjectField("checkerDetectedValue", ((AgentCheckerDetectedValue) checkerDetectedValue).getDetectedAgents());
        }
        
        jgen.writeStringField("unit", webhookPayload.getUnit());
        jgen.writeNumberField("threshold", webhookPayload.getThreshold());
        jgen.writeStringField("notes", webhookPayload.getNotes());
        jgen.writeNumberField("sequenceCount", webhookPayload.getSequenceCount());
        
        jgen.writeEndObject();
    }
}
