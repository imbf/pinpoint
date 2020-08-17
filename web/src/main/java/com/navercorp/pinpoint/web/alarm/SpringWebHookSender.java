/*
 * Copyright 2018 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.navercorp.pinpoint.web.alarm;

import com.navercorp.pinpoint.web.alarm.checker.AlarmChecker;
import com.navercorp.pinpoint.web.alarm.vo.WebHookPayload;
import com.navercorp.pinpoint.web.batch.BatchConfiguration;
import com.navercorp.pinpoint.web.service.UserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;

public class SpringWebHookSender implements WebHookSender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BatchConfiguration batchConfiguration;
    private final String webHookReceiverURL;
    private final UserGroupService userGroupService;
    private final RestTemplate springHttpSender;

    public SpringWebHookSender(BatchConfiguration batchConfiguration, UserGroupService userGroupService, RestTemplate springHttpSender) {
        Objects.requireNonNull(batchConfiguration, "batchConfiguration");
        Objects.requireNonNull(userGroupService, "userGroupService");
        Objects.requireNonNull(springHttpSender, "restTemplate");

        this.batchConfiguration = batchConfiguration;
        this.webHookReceiverURL = batchConfiguration.getWebHookReceiverUrl();
        this.userGroupService = userGroupService;
        this.springHttpSender = springHttpSender;
    }

    @Override
    public void sendHttp(AlarmChecker checker, int sequenceCount, StepExecution stepExecution) {
        List<String> receivers = userGroupService.selectEmailOfMember(checker.getuserGroupId());

        if (receivers.size() == 0) {
            return;
        }

        try {
            WebHookPayload webHookPayload = new WebHookPayload(checker, batchConfiguration, sequenceCount);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity httpEntity = new HttpEntity(webHookPayload, httpHeaders);
            springHttpSender.exchange(new URI(webHookReceiverURL), HttpMethod.POST, httpEntity, String.class);
            logger.info("send WebHook : {}", checker.getRule());
        } catch (Exception e) {
            logger.error("can't send WebHook. {}", checker.getRule(), e);
        }
    }
}
