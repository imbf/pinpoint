import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { IAlarmRule } from './alarm-rule-data.service';

@Component({
    selector: 'pp-alarm-rule-list',
    templateUrl: './alarm-rule-list.component.html',
    styleUrls: ['./alarm-rule-list.component.css']
})
export class AlarmRuleListComponent implements OnInit {
    @Input() alarmRuleList: IAlarmRule[];
    @Input() systemConfiguration: ISystemConfiguration
    @Output() outRemove = new EventEmitter<string>();
    @Output() outEdit = new EventEmitter<string>();

    private removeConfirmId = '';

    constructor() {}
    ngOnInit() {}
    getNotificationType(emailSend: boolean, smsSend: boolean, webhookSend: boolean): string {
        if (this.systemConfiguration.webhookEnable) {
            return !emailSend && !smsSend && !webhookSend ? 'None'
                : !emailSend && !smsSend && webhookSend ? 'Webhook'
                : !emailSend && smsSend && !webhookSend ? 'SMS'
                : emailSend && !smsSend && !webhookSend ? 'Email'
                : emailSend && smsSend && !webhookSend ? 'Email, SMS'
                : emailSend && !smsSend && webhookSend ? 'Email, Webhook'
                : !emailSend && smsSend && webhookSend ? 'SMS, Webhook'
                : 'Email, SMS, Webhook';
        }
        return !emailSend && !smsSend ? 'None'
            : emailSend && !smsSend ? 'Email'
            : !emailSend && smsSend ? 'SMS'
            : 'Email, SMS';
    }

    onRemove(ruleId: string): void {
        this.removeConfirmId = ruleId;
    }

    onEdit(ruleId: string): void {
        this.outEdit.emit(ruleId);
    }

    onCancelRemove(): void {
        this.removeConfirmId = '';
    }

    onConfirmRemove(): void {
        this.outRemove.emit(this.removeConfirmId);
        this.removeConfirmId = '';
    }

    isRemoveTarget(ruleId: string): boolean {
        return this.removeConfirmId === ruleId;
    }
}
