import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {

  }


  openNav() {
    document.getElementById("main").style.opacity = '0.1';
    document.getElementById("main").style.pointerEvents="none";
    document.getElementById("mySidebar").style.width = "260px";
    document.getElementById("main-header").style.position = "inherited";
    document.getElementById("main-header").style.zIndex = "0";
    document.getElementById("main-header").style.opacity = '0.1';

}
  closeNav() {
    document.getElementById("main").style.opacity = '1';
    document.getElementById("main").style.pointerEvents="auto";
    document.getElementById("mySidebar").style.width = "0px";
    document.getElementById("main-header").style.position = "fixed";
    document.getElementById("main-header").style.zIndex = "1";
    document.getElementById("main-header").style.opacity = '1';

  }


}
