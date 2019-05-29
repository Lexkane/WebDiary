import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-practise',
  templateUrl: './practise.component.html',
  styleUrls: ['./practise.component.css']
})
export class PractiseComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  openNav() {
    // document.getElementById("mySidebar").style.width = "250px";
    // document.getElementById("main").style.marginLeft = "250px";
    document.getElementById("main").style.opacity = '0.1';
    document.getElementById("main").style.marginLeft = "15%";
    document.getElementById("main").style.pointerEvents="none";
    document.getElementById("mySidebar").style.width = "15%";
    // document.getElementById("card-text").style.fontSize = "1vw";
    // document.getElementById("mySidebar").style.display = "block";
    // document.getElementById("sd").style.visibility = "visible";



  }

  closeNav() {
    // document.getElementById("mySidebar").style.width = "0";
    // document.getElementById("main").style.marginLeft = "0";
    document.getElementById("main").style.opacity = '1';
    document.getElementById("main").style.pointerEvents="auto";
    // document.getElementById("card-text").style.fontSize = "1vw";
    document.getElementById("main").style.marginLeft = "0%";
    document.getElementById("mySidebar").style.width = "0%";

    // document.getElementById("mySidebar").style.display = "none";
    // document.getElementById("sd").style.visibility = "hidden";


  }
}
