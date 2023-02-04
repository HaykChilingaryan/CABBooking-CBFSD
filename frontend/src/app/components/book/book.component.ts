import { Component, OnInit } from '@angular/core';
import {  FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Cabtype } from 'src/app/classes/cabtype';
import { BookService } from 'src/app/services/book.service';
import { CabTypesService } from 'src/app/services/cab-types.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit{
  

  public cabTypeObservable: Observable<any[]> = new Observable();

  constructor(public bookService:BookService,
              public cabTypeservice: CabTypesService,
              private router: Router){

  }

  compareByCabId(cab1: Cabtype, cab2: Cabtype) {
    return cab1 && cab2 && cab1.cabTypeId === cab2.cabTypeId;
  }

  onSelectOption(category: Cabtype | Event | undefined) {
    // this.productForm.patchValue({
    //   category: this.categories.find(x => x.categoryId === category.categoryId)
    // })
  }

  bookingRef = new FormGroup({
    bookingId:new FormControl(),
    bookingDistance:new FormControl(),
    bookingDate:new FormControl(),
    bookingTime: new FormControl(),
    cabTypeId: new FormControl()
  });

  storeBooking() {
    let booking = this.bookingRef.value;
    console.log(booking);
    this.bookService.storeBooking(booking).subscribe({
      next:(result:any)=>{
        console.log(result);
      },
      error:(error:any)=>{
        alert("Id Already Exists");
        this.router.navigate(['/book']);
        this.bookingRef.reset;
      },
      complete:()=>this.router.navigate(['/fare',booking.bookingId])
    })
    
  }

  ngOnInit(): void {
    this.cabTypeObservable = this.cabTypeservice.getTypes();
  }

   
}

export interface Booking {
  bookingId?: string;
  bookingDistance?: number;
  bookingDate?: string;
  bookingTime?: number;
  bookingFare?: number;
  cabTypeId?:number;
}

