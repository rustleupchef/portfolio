function addSkill() {
    const skillItem = document.createElement("li");
    skillItem.innerText = document.getElementById("skill").value;
    document.getElementById("skills").appendChild(skillItem);
}

function create() {
    const skillsList = new Array();
    const skills = document.getElementById("skills");
    for (let element of skills.children) {
        skillsList.push(element.innerText);
    }

    const title = document.getElementById("title").value;
    const description = document.getElementById("description").value;

    const data = {
        title : title,
        description : description,
        skills : skillsList
    };

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/create");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            const parsedData = JSON.parse(xhr.responseText)
            if (parsedData.type === "success") {
                location.assign("/");
            } else {
                alert(parsedData.message);
            }
        }
    }
    xhr.send(JSON.stringify(data));
}