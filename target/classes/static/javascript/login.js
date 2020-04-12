"use strict";
//Javascript that handels UI according to Server requests.

var navigationmenu = document.getElementById("navigationmenu");

document.getElementById("loginbutton").onclick = function() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/user/login", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if(username != "" && password != "") {
        xhr.send(JSON.stringify(
            {
                "username" : document.getElementById("username").value,
                "password" : document.getElementById("password").value
            }
        ))
    }
    xhr.onreadystatechange = function () {
        let loginState = xhr.readyState == 4 & xhr.status == 200;
        console.log("The result is:");
        console.log(this.response);
        if(loginState && this.responseText == "true") {
            sessionStorage.setItem("username", username);
            sessionStorage.setItem("loginStatus", true);
            document.getElementById("navigationmenu").style.display="flex";
            document.getElementById("login-container").style.display="none";
            document.getElementById("menu-container").style.display="none";
        } else {
            console.log("USERNAME OR PASSWORD IS FALSE!");
            return;
        }
    }

}

var create = function () {
    console.log("i am clicked")
    var xhr = new XMLHttpRequest();
    xhr.open("Post", "/user/create", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(JSON.stringify(
        {
            "username": document.getElementById("username").value,
            "password": document.getElementById("password").value,
            "name": document.getElementById("name").value
        }
    ))

    xhr.onreadystatechange = function () {
        if (xhr.status == 200 && xhr.readyState == 4) {
            register();
            console.log(this.responseText);
        }

    }

}
