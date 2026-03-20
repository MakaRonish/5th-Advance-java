import { Injectable, inject, signal } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Student} from './student';


const restUrl='/api/v1/students';
@Injectable({
  providedIn: 'root',
})
export class StudentService {
	private http = inject(HttpClient);
	
	students = signal<Student[]>([]);
	
	constructor(){
		this.getStudents();
	}
	
	getStudents():void{
		this.http.get<Student[]>(restUrl).subscribe(data => {
			this.students.set(data);
		})
	}
	
}
