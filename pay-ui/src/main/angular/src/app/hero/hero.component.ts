import { Component } from '@angular/core';

import { Hero } from './hero';

@Component({
  selector: 'hero-root',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.styl'],
})

export class HeroComponent {
  title = 'Tour of Heroes';
}