import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CalcComponent } from './pages/calc/calc.component';
import { CalcService } from './services/calc.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './pages/main/main.component';
import { FormsModule } from '@angular/forms';
import { ButtonComponent } from './pages/calc/button/button.component';

const appRoutes: Routes = [
  { path: 'calculator/:id', component: CalcComponent },
  { path: '', component: MainComponent },
  { path: '**', component: MainComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CalcComponent,
    MainComponent,
    ButtonComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CalcService, HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
