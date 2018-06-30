import {Component, OnInit} from '@angular/core';
import {UserService} from '../shared/services/user.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AuthService} from '../shared/services/auth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  private balance: number;


  constructor(private userService: UserService,
              private authService: AuthService,
              private http: HttpClient,
              private router: Router) {
    this.balance = 0;
  }

  async ngOnInit() {
  }

  public logout() {
    this.authService.logout().subscribe(res => {
      this.router.navigate(['/login']);
    });
  }

  public authenticated() {
    return !!this.userService.currentUser;
  }
}
