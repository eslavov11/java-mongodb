import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class CarService {
  private API_URL = '/api/cars/';

  constructor(private http: HttpClient) {
  }

  public getAll() {
    return this.http.get(this.API_URL);
  }

  public get(id) {
    return this.http.get(this.API_URL + id);
  }

  public add(car) {
    return this.http.post(this.API_URL, car);
  }

  public edit(id, car) {
    return this.http.put(this.API_URL + id, car);
  }
}
