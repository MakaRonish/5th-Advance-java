import { Component, inject } from '@angular/core';
import {StudentService} from '../student-service';

@Component({
  selector: 'app-student-list',
  imports: [],
  templateUrl: './student-list.html',
  styleUrl: './student-list.css',
})
export class StudentList {
	
	studentService = inject(StudentService)
}
