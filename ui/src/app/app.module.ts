import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { CallbackComponent } from './callback/callback.component';
import { HeaderComponent } from "./header/header.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AuthHeaderInterceptor} from "./auth/auth-header.interceptor";
import {SidebarComponent} from "./sidebar/sidebar.component";
import {PanelComponent} from "./panels/panel/panel.component";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatProgressSpinner} from "@angular/material/progress-spinner";
import {MatToolbar} from "@angular/material/toolbar";
import {MatButton} from "@angular/material/button";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    HeaderComponent,
    CallbackComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    SidebarComponent,
    PanelComponent,
    MatProgressSpinner,
    MatToolbar,
    MatButton
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthHeaderInterceptor,
      multi: true
    },
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
