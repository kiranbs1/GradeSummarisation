import {Component, OnInit} from '@angular/core';
import {SecurityService} from "../services/security-service/security.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{


  constructor(private securityService: SecurityService, private router: Router) {
  }

  ngOnInit(): void {
  }

  logout() {
    this.securityService.logout().subscribe(() => {
      this.securityService.removeToken();
      this.router.navigate(['/login']);
    });
  }
}
