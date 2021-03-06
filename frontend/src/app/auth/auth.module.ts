import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {BrowserModule} from '@angular/platform-browser';

import {AuthService} from './auth.service';
import {AuthRoutingModule} from './auth-routing.module';
import {HttpClient} from '../http-client.service';

@NgModule({
    providers: [
        HttpClient,
        AuthService
    ],
    imports: [
        HttpModule,
        BrowserModule,
        FormsModule,
        AuthRoutingModule
    ]
})

export class AuthModule { }
