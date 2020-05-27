"use strict";

var username;
var loginStatus;

var loadPosts = function() {
    username = sessionStorage.getItem("username");
    loginStatus = sessionStorage.getItem("loginStatus");
    console.log(username);
    console.log(loginStatus);
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/post/viewall", true);
    xhr.send();
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            console.log(this.responseText);
            let results= JSON.parse(JSON.stringify(this.responseText));
            let write = "";
            for(let index = 0; index < results.length; index++) {
                write = write + "<div class='post'>" +
                    "<span class=\"username-holder\">" + results[index].username + "</span>" +
                    "<span class=\"content-holder\">" + results[index].content + "</span>" +
                    "</div>";
            }
            document.getElementById("post-container").innerHTML = document.getElementById("post-container").innerHTML + write;
        }
    }
}

document.getElementById("post-write").onclick = function() {
    console.log("publish button clicked");
    var xhrPost = new XMLHttpRequest();
    xhrPost.open("POST", "/post/add", true);
    xhrPost.setRequestHeader("Content-Type", "application/json;UTF-8");
    var content = document.getElementById("write-post").value;
    content = content.trim();
    if(content.replace(/\s+/g,"") != "") {
        xhrPost.send(JSON.stringify(
            {
                "content" : content ,
                "username" : username
            }
        ))
    }
    xhrPost.onreadystatechange = function () {
        if(xhrPost.status == 200 && xhrPost.readyState == 4) {
            window.location.reload(true);
        }
    }
    
}