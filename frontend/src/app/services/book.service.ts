import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Booking } from '../components/book/book.component';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private HttpClient: HttpClient){}

  getAllBookings(){
    return this.HttpClient.get<Booking[]>('http://localhost:9090/booking/findAllBookings');
  }

  storeBooking(booking: any ):Observable<string>{
    return this.HttpClient.post("http://localhost:9090/booking/storeBooking",booking, {responseType:'text'});
  }

  
  getBookingById(id: number){
    return this.HttpClient.get<Booking>('http://localhost:9090/booking/findBookingById/'+id);
    
  }
  deleteProduct(bookingId:any):Observable<string>{
    return this.HttpClient.delete("http://localhost:9090/booking/deleteBookingById/"+bookingId,{responseType:'text'});
  }
}
