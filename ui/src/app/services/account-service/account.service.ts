import { Injectable } from '@angular/core';
import {BehaviorSubject, catchError, map, Observable, of, tap} from 'rxjs';
import { AccountDTO } from '../../data/DTOs/account.dto';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";  // Ensure the path to your AccountDTO model is correct

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private accountDataSubject = new BehaviorSubject<AccountDTO | undefined>(undefined); // Initialize with undefined

  constructor(private http: HttpClient) {}

  getAccountData(): Observable<AccountDTO | undefined> {
    return this.accountDataSubject.asObservable();
  }

  loadAccountData(): Observable<AccountDTO> {
    console.log("Loading account data...");

    return this.http.get<AccountDTO>(`${environment.baseUrl}/v1/account/getOrCreateAuthenticatedAccount`)
      .pipe(
        tap(data => {
          console.log("Account data received:", data);
          this.accountDataSubject.next(data);
          this.getAccountData().subscribe(e => {
            console.log("Current account data:", e);
            console.log("UserAccountId:", e?.userAccountId);
            if (e?.courses && e.courses.length > 0) {
              console.log("Last course ID:", e?.courses[e.courses.length - 1].courseId);
            }
          });
        }),
        catchError(error => {
          console.error("Error loading account data:", error);
          return of(null as unknown as AccountDTO); // Ensuring we return an Observable<AccountDTO>
        })
      );
  }
}
