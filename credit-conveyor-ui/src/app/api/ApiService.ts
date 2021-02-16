import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class ApiService {

  constructor(private http: Http) {
  }

  // tslint:disable-next-line:typedef
  get(path: string) {
    return this.http.get('http://localhost:8080' + path);
  }

}
