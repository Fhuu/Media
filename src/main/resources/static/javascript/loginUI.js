"use strict";
//Javascript file for UI solely on UI. Nothing to do with server.

var navigationloginbutton = document.getElementById("navigationlogin");
var registerForm = document.getElementsByClassName("register");
var registrerTogle = document.getElementById("togle");
var submitbutton = document.getElementById("loginbutton");
var overlay = document.getElementById("login-container");
var navigationcontainer = document.getElementById("navigationcontainer");

var register =  function (){
    if(registerForm[0].style.display == "block") {
        for (let index = 0; index < registerForm.length; index++) {
            registerForm[index].style.display = "none";
        }        
        submitbutton.style.display = "";
        registrerTogle.innerHTML="HAVEN'T GOT AN ACCOUNT?";
    } else {
        registrerTogle.innerHTML="LOGIN?";
        for (let index = 0; index < registerForm.length; index++) {
            registerForm[index].style.display = "block";
        }
        submitbutton.style.display = "none";
        console.log("clicked");
    }
}

var closeOverlay = function() {
    overlay.style.display="none";
    navigationloginbutton.style.display="block";
}

navigationloginbutton.onclick = function() {
    overlay.style.display="block";
    navigationloginbutton.style.display="none";
}

navigationmenu.onclick = function() {
    navigationcontainer.style.display="block";
    
}
