import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {SecurityService} from "../services/security-service/security.service";
import {Router} from "@angular/router";
import {AccountDTO} from "../data/DTOs/account.dto";
import {AccountService} from "../services/account-service/account.service";
import {PanelComponent} from "../panels/panel/panel.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  account: AccountDTO | undefined;
  @ViewChild(PanelComponent) panelComponent!: PanelComponent

  constructor(private securityService: SecurityService,
              private router: Router, private accountService: AccountService) {
  }

  ngOnInit(): void {

    this.accountService.loadAccountData().subscribe(account => {
      this.account = account;
    });
  }

  sidebarItemEvent(event : any): void {
    this.panelComponent.onFocusChange(event)
  }
}
