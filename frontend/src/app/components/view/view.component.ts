import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit{

  public bookings: Observable<any[]> = new Observable();
  constructor(private bookService: BookService){}

  ngOnInit(): void {
    this.bookings = this.bookService.getAllBookings();
  }




}
