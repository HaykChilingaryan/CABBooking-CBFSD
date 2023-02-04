import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Cabtype } from 'src/app/classes/cabtype';
import { BookService } from 'src/app/services/book.service';
import { Booking } from '../book/book.component';

@Component({
  selector: 'app-fare',
  templateUrl: './fare.component.html',
  styleUrls: ['./fare.component.css']
})
export class FareComponent implements OnInit{

  public Id!: number;
  public fare: number | undefined ;
  public bookings: Observable<Booking> = new Observable();
  constructor(private route: ActivatedRoute,
    private newRoute:Router,
    public bookService: BookService) {}
  
   
  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.Id = params['id']);
    console.log(this.Id);
    this.bookService.getBookingById(this.Id).subscribe((data) =>(this.fare = data.bookingFare));
  }

  deleteBooking(bookingId: number){
    this.bookService.deleteProduct(bookingId).subscribe({
      next:(data:any)=> {
            console.log(data);
      },
      error:(error:any)=> console.log(error),
      complete:()=>this.newRoute.navigate(['/home'])
    
    });
    
  }


  

}
