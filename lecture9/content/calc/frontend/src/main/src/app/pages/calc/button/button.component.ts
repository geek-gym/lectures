import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CalcService } from 'src/app/services/calc.service';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {

  @Input() calcId: string;
  @Input() value: string;

  @Output() valueChange: EventEmitter<string> = new EventEmitter<string>();

  constructor(private calcService: CalcService) { }

  ngOnInit() {
  }

  sendCommand(command: string) {
    this.calcService.sendCommand(this.calcId, command).subscribe(val => {
      this.valueChange.emit(val.value);
    }, err => this.value = 'E');
  }
}
