import {Component, EventEmitter, Input, model, OnInit, Output} from '@angular/core';
import {AccountDTO} from "../data/DTOs/account.dto";
import { CommonModule } from '@angular/common';
import {AccountService} from "../services/account-service/account.service";

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent implements OnInit{

  account: AccountDTO | undefined;
  @Output() clickedItemEvent = new EventEmitter<any>();

  constructor(private accountService: AccountService) {
  }

  ngOnInit(): void {
    this.accountService.getAccountData().subscribe(account => {
      this.account = account;
      console.log("Sidebar updated with account data:", account);
    });
  }

  selectItem(clickedItem:any): void {
    // Logic to request and display the item data on the main screen
    this.clickedItemEvent.emit(clickedItem)
    console.log(`Selected ${clickedItem}`);
    // You can use a router to navigate or communicate with a parent component using Output
  }
}
