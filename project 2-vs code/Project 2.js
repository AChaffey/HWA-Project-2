'use strict'

let resultsDiv = document.querySelector("#results");
let postBtn = document.querySelector("#post");
let addsongName = 
let addartist = 
let addyear = 

// HTTP Requests - Request/Response
// Axios uses promises
// We must handle the success, and the failure

// GET - READ
let setup = () => {
    axios.get("http://localhost:8080/music/getAll")
        .then((response) => {
    
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}


// POST - CREATE
let create = () => {

    let obj = {
        "songName": addsongName,
        "artist":addartist,
        "year": addyear
    }
    console.log(obj);
    axios.post("http://localhost:8080/music/create", obj)
        .then((response) => {
            console.log(response);
            // displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
// PUT/PATCH - UPDATE

// DELETE - DELETE

let displayResult = (data) => {
    for (let entry of data) {
        const entryDiv = document.createElement("div");
        entryDiv.setAttribute("class", "entryDiv");
        const text = document.createTextNode(`ID: ${entry.id} | Song Name: ${entry.songName} | Artist: ${entry.artist} | Year: ${entry.year}`);
        
        entryDiv.appendChild(text);
        resultsDiv.appendChild(entryDiv);
    
    }
}

// Event Listeners
getBtn.addEventListener("click", getRequest);
postBtn.addEventListener("click", postRequest);