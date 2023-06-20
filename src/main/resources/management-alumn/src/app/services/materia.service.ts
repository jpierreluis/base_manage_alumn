import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Materia } from '../models/materia';
import { URL_BACKEND } from '../utils/config';

@Injectable({
  providedIn: 'root'
})
export class MateriaService {

  private endPoind:string= URL_BACKEND + "/api/materia/"

  constructor(private http:HttpClient) { }

  getElement(id:string):Observable<any>{
    return this.http.get<any>(`${this.endPoind}id?id=${id}`);
  }

  save(alumno:Materia):Observable<any>{
    return this.http.post<any>(`${this.endPoind}`,alumno);
  }

  delete(id:string):Observable<any>{
    return this.http.delete<any>(`${this.endPoind}?id=${id}`);
  }

  getAll():Observable<Materia[]>{
    return this.http.get<Materia[]>(`${this.endPoind}`);
  }
}
