import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavigationComponent} from './navigation/navigation.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {DiaryComponent} from './diary/diary.component';
import {RouterModule, Routes} from "@angular/router";
import {SignInComponent} from './signin/sign-in.component';
import {RegisterComponent} from './register/register.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {PractiseComponent} from './practise/practise.component';
import {AboutComponent} from './about/about.component';
import {EditorComponent} from './editor/editor.component';
import {AccountComponent} from './account/account.component';

const appRoutes: Routes = [
  {
    path: 'navigation',
    component: NavigationComponent,
    children: [
      {
        path: '',
        redirectTo: 'diary',
        pathMatch: 'full'
      },
      {
        path: 'account',
        component: AccountComponent
      },
      {
        path: 'diary',
        component: DiaryComponent
      },
      {
        path: 'diary/editor',
        component: EditorComponent
      },
      {
        path: 'about',
        component: AboutComponent
      }
    ]
  },
  {
    path: 'sign-in',
    component: SignInComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'practise',
    component: PractiseComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    NotFoundComponent,
    DiaryComponent,
    SignInComponent,
    RegisterComponent,
    PractiseComponent,
    AboutComponent,
    EditorComponent,
    AccountComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
