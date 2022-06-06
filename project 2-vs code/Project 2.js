'use strict'
// Button
let postBtn = document.querySelector("#post");
let view = document.querySelector("#Update");
let remove = document.querySelector("#Delete");
// Inputs
let songName = document.querySelector("#songName");
let artist = document.querySelector("#Artist");
let releaseYear = document.querySelector("#year");
let deleteId = document.querySelector("#ID");
let updateId = document.querySelector("#ID1");
// Divs
let resultsDiv = document.querySelector("#results");
// Form
let form = document.querySelector("#form");
let tBody = document.querySelector("tbody");


// POST - CREATE
        let post = () => {

            let obj = {
                "songName": songName.value,
                "artist": artist.value,
                "releaseYear": releaseYear.value,
            }
            // console.log(obj);
            axios.post("http://localhost:8080/music/create", obj)
                .then((response) => {
                    readAll();
                })
                .catch((err) => {
                    console.error(err);
                })
        }

// GET - READ
let readAll = () => {

    axios.get("http://localhost:8080/music/getAll")
        .then((response) => {
            tBody.innerHTML = ""
            displayResult(response.data);
            
        })
        .catch((err) => {
            console.error(err);
        })
}


let update = () => {

    let obj = {"songName": songName.value,
    "artist": artist.value,
    "releaseYear": releaseYear.value
}
    axios.put(`http://localhost:8080/music/update/${updateId.value}`, obj)
        .then((response) => {
            readAll();
        })
        .catch((err) => {
            console.error(err);
        })
}


// DELETE - DELETE

let del = () => {
    let obj = {"songName": songName.value,
    "artist": artist.value,
    "releaseYear": releaseYear.value,

}
    axios.delete(`http://localhost:8080/music/delete/${deleteId.value}`)
        .then((response) => {
            
            readAll();
        })
        .catch((err) => {
            console.error(err);
        })
    }


let displayResult = (data) => {
    for (let entry of data) {
        let tr = document.createElement("tr");

        let td1 = document.createElement("td");
        td1.setAttribute("class", "table-light border-dark");
        td1.textContent = `${entry.id}`;
        
        let td2  = document.createElement("td");
        td2.setAttribute("class", "table-light border-dark")
        td2.textContent = `${entry.songName}`;

        let td3  = document.createElement("td");
        td3.setAttribute("class", "table-light border-dark")
        td3.textContent = `${entry.artist}`;

        let td4  = document.createElement("td");
        td4.setAttribute("class", "table-light border-dark")
        td4.textContent = `${entry.releaseYear}`;

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tBody.appendChild(tr);
        
}
}

// Event Listeners
view.addEventListener("click", update);
postBtn.addEventListener("click", post, displayResult);
remove.addEventListener("click", del);