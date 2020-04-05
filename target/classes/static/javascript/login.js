"use strict";
//Javascript that handels UI according to Server requests.
var username = "";
var loginstatus = false;



var navbar = document.getElementById("navbar");
var navigationlogin = document.getElementById("navigationlogin");
var navigationmenu = document.getElementById("navigationmenu");
var menucontainer = document.getElementById("menu-container");
var logincontainer = document.getElementById("login-container");
var loginform = document.getElementById("login-form");

var login = function () {
    var xhr = new XMLHttpRequest();
    xhr.open("Post", "/user/login", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    xhr.send(JSON.stringify(
        {
            "username" : document.getElementById("username").value ,
            "password" : document.getElementById("password").value
        }
    ));
    xhr.onreadystatechange = function () {
/*
        loginstatus = xhr.readyState == 4 && xhr.status == 220;
        if(loginstatus) {
*/
        if(true) {
//            var result = JSON.parse(this.responseText);
//            username = result.username;
            navbar.style.display = "block";
            menucontainer.style.display="block";
            navigationmenu.style.display="flex";
            navigationlogin.style.display="none";
            logincontainer.style.display = "none";
            loginform.style.display = "none";
        }
    }
    navbar.style.display = "block";
    menucontainer.style.display="block";
    loginform.style.display = "none";
}

var create = function () {
    console.log("i am clicked")
    var xhr = new XMLHttpRequest();
    xhr.open("Post", "/user/create", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    xhr.send(JSON.stringify(
        {
            "username" : document.getElementById("username").value ,
            "password" : document.getElementById("password").value,
            "name" : document.getElementById("name").value
        }
    ))

    xhr.onreadystatechange = function () {
        if(xhr.status == 200 && xhr.readyState == 4) {
            register();
            console.log(this.responseText);
        }

    }
}