import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { commentModel } from 'src/app/models';
import { BggService } from 'src/app/services/bgg.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit{

  params$!: Subscription

  comment: commentModel[] =[]

  constructor(private activatedRoute:ActivatedRoute, 
    private bggService:BggService,
    private router:Router) {}

  ngOnInit(): void {
    this.params$ = this.activatedRoute.params.subscribe(
      (params) => {
        const gid = params['gid']
        this.bggService.getCommentByGameId(gid)
        .then(commentResult => {
          this.comment = commentResult
          console.info('>>>> comment:', this.comment)
        })
        .catch(error => {
          console.error('>>>> error', error)
        })
      }
    )
    
  }
  

}
