import {BrowserModule} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {CarAddComponent} from './car/car-add/car-add.component';
import {CarListComponent} from './car/car-list/car-list.component';
import {CarEditComponent} from './car/car-edit/car-edit.component';
import {UserLoginComponent} from './user/user-login/user-login.component';
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {AuthService} from './shared/services/auth.service';
import {CarService} from './shared/services/car.service';
import {UserService} from './shared/services/user.service';
import {ApiService} from './shared/services/api.service';
import {NavComponent} from './nav/nav.component';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

@NgModule({
  declarations: [
    AppComponent,
    CarAddComponent,
    CarListComponent,
    CarEditComponent,
    UserLoginComponent,
    NavComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [ApiService,
    AuthService,
    CarService,
    UserService,
    {provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
