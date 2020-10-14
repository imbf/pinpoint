package com.navercorp.pinpoint.web.view;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.navercorp.pinpoint.web.alarm.vo.DataSourceAlarmVO;

import java.io.IOException;

public class DataSourceAlarmVOSerializer extends JsonSerializer<DataSourceAlarmVO> {
    
    @Override
    public void serialize(DataSourceAlarmVO dataSourceAlarmVO, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
        jgen.writeStartObject();
        
        jgen.writeStringField("databaseName", dataSourceAlarmVO.getDatabaseName());
        jgen.writeNumberField("connectionValue", dataSourceAlarmVO.getConnectionUsedRate());
        
        jgen.writeEndObject();
    }
}
