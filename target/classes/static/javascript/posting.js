"use strict";

document.getElementById("post-write").onclick = function() {
    var xhr = new XMLHttpRequestRequest();
    xhr.open("POST", "/post/newpost", true);
    xhr.setRequestHeader("Content-Type", "application/json;UTF-8");
    xhr.send(JSON.stringify(
        {
            
        }
    ))
    
}