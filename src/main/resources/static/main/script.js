window.onload = function() {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/projects");
    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const container = document.querySelector(".container");
            const projects = JSON.parse(xhr.responseText);
            for (let project of projects) {
                const projectDiv = document.createElement("div");
                projectDiv.className = "project-box";
                projectDiv.onclick = function() {
                    location.assign("/project?id=" + encodeURIComponent(project.project_id));
                }

                const image = document.createElement("img");
                image.src = project.img;

                const title = document.createElement("h2");
                title.innerText = project.title;
                title.className = "libre-bodoni-regular";

                projectDiv.appendChild(image);
                projectDiv.appendChild(title);

                container.appendChild(projectDiv);
            }
        }
    }
    xhr.send();
}