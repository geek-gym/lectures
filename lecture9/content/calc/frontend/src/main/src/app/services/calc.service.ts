import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from '../../../node_modules/rxjs';
import { Value } from '../models/value';

@Injectable({
  providedIn: 'root'
})
export class CalcService {
  private requestUrl = '/api/calculator/';
  constructor(private http: HttpClient) { }

  public createCalculator(): Observable<string> {
    return this.http.post(this.requestUrl, null, { responseType: 'text' });
  }

  sendCommand(id: string, command: string): Observable<Value> {
    return this.http.put<Value>(this.requestUrl + id, { 'value': command });
  }

  getState(id: string): Observable<Value> {
    return this.http.get<Value>(this.requestUrl + id);
  }

  deleteCalculator(id: string) {
    this.http.delete(this.requestUrl + id);
  }
}
