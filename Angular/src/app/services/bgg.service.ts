import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { commentModel, gameModel } from '../models';

@Injectable({
  providedIn: 'root'
})
export class BggService {

  constructor(private httpClient:HttpClient) { }

  getListOfGames():Promise<gameModel[]>{
    return firstValueFrom(
      //same as springboot mapping
      this.httpClient.get<gameModel[]>('api/games')
      )
  }

  getCommentByGameId(gid: number): Promise<commentModel[]>{
    return firstValueFrom(
      //same as springboot mapping
      this.httpClient.get<commentModel[]>(`api/game/${gid}/comments`)
    )
  }

}
