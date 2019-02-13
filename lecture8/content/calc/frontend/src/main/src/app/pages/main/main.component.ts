import { Component, OnInit } from '@angular/core';
import { CalcService } from '../../services/calc.service';
import { Router } from '@angular/router';
import { THIS_EXPR } from '../../../../node_modules/@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  error = false;
  calcId: string;

  constructor(private calcService: CalcService, private router: Router) {
  }

  createCalculator() {
    this.error = false;
    this.calcService.createCalculator().subscribe(response => {
      this.router.navigateByUrl('/calculator/' + response);
    }, err => {
      this.error = true;
    });
  }

  openCalculator(calcId: string) {
    this.router.navigateByUrl('/calculator/' + calcId);
  }
}
