'use strict'

let resultsDiv = document.querySelector("#results");
let getBtn = document.querySelector("#get");
let postBtn = document.querySelector("#post");

// HTTP Requests - Request/Response
// Axios uses promises
// We must handle the success, and the failure

// GET - READ
let getRequest = () => {
    axios.get("http://localhost:8080/music/getAll")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}


// POST - CREATE
let postRequest = () => {

    let obj = {
        "songName":"Baby",
        "artist":"Justin Bieber",
        "year":"2010"
    }

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

        // const img = document.createElement("img");
        // img.setAttribute("src", entry.avatar);
        // img.setAttribute("class", "avatars");

        entryDiv.appendChild(text);
        resultsDiv.appendChild(entryDiv);
        // resultsDiv.appendChild(img);
    }
}

// Event Listeners
getBtn.addEventListener("click", getRequest);
postBtn.addEventListener("click", postRequest);