import { Component, OnInit } from '@angular/core';
import { gameModel } from 'src/app/models';
import { BggService } from 'src/app/services/bgg.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  games: gameModel[] = []

  //inject in the service 
  constructor(private bggservice: BggService) {}

  ngOnInit(): void {
    this.bggservice.getListOfGames()
    .then(result => {
      //games is from the param initialized above
      this.games = result
      console.info('>> result: ', result)
    })
    .catch(error => {
      console.error('>>>> error: ', error)
    });
    
  }
}
