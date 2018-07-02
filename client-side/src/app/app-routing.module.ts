import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UserLoginComponent} from './user/user-login/user-login.component';
import {CarListComponent} from './car/car-list/car-list.component';
import {CarEditComponent} from './car/car-edit/car-edit.component';
import {CarAddComponent} from './car/car-add/car-add.component';

const routes: Routes = [
  {path: 'login', component: UserLoginComponent},
  {path: 'cars/add', component: CarAddComponent},
  {path: 'cars/edit/:id', component: CarEditComponent},
  {path: 'cars', component: CarListComponent},
  {path: '', component: CarListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
