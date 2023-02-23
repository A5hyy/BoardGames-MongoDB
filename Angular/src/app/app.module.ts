import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { GameComponent } from './components/Game/game.component';
import { CommentComponent } from './components/Comment/comment.component';
import { BggService } from './services/bgg.service';

const appRoutes:Routes =[
  {path: '', component:GameComponent},
  {path: 'games', component:GameComponent},
  {path: 'game/:gid/comments', component:CommentComponent},
  {path: '**', redirectTo:'', pathMatch:'full'}
] 

@NgModule({
  declarations: [
    AppComponent,
    GameComponent,
    CommentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ BggService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
