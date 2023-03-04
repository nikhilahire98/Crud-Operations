import { Component, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {
  constructor(private service: AuthService, private toastr: ToastrService, private router: Router) {
    this.SetAccesspermission();
  }
  customerlist: any;
  dataSource: any;
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sort !: MatSort;

  accessdata: any;
  haveedit = false;
  haveadd = false;
  havedelete = false;

  ngAfterViewInit(): void {

  }

  LoadCustomer() {
    this.service.GetAllCustomer().subscribe(res => {
      this.customerlist = res;
      this.dataSource = new MatTableDataSource(this.customerlist);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;

    });
  }
  SetAccesspermission() {
    this.service.Getaccessbyrole(this.service.GetUserrole(), 'customer').subscribe(res => {
      this.accessdata = res;
      console.log(this.accessdata);

      if (this.accessdata.length > 0) {
        this.haveadd = this.accessdata[0].haveadd;
        this.haveedit = this.accessdata[0].haveedit;
        this.havedelete = this.accessdata[0].havedelete;
        this.LoadCustomer();
      } else {
        alert('you are not authorized to access');
        this.router.navigate(['']);
      }
    })
  }
  displayedColumns: string[] = ['id', 'name', 'salary', 'action'];

  updatecustomer(code: any) {
    if (this.haveedit) {
      // implement code for edit


      this.toastr.success('success');
    } else {
      this.toastr.warning("you don't have access for edit.");
    }
  }

  removecustomer(code: any) {
    if (this.havedelete) {
      // implement code for edit


      this.toastr.success('success');
    } else {
      this.toastr.warning("you don't have access for delete.");
    }

  }
  addcustomer() {
    if (this.haveadd) {
      // implement code for edit


      this.toastr.success('success')
    } else {
      this.toastr.warning("you don't have access for add.")
    }
  }
}
