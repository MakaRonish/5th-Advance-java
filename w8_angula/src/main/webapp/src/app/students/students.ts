import { Component } from '@angular/core';
import { StudentAdd } from './student-add/student-add';
import { StudentList } from './student-list/student-list';

@Component({
  selector: 'app-students',
  imports: [StudentAdd,StudentList],
  templateUrl: './students.html',
  styleUrl: './students.css',
})
export class Students {}
