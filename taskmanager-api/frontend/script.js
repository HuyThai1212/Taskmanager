let apiUrl = 'http://localhost:8080/tasks';
let editingId = null;

function fetchTasks() {
    fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector("#taskTable tbody");
            tbody.innerHTML = "";
            data.forEach((task, index) => {
                const row = document.createElement("tr");
                row.innerHTML = `
          <td>${index + 1}</td>
          <td>${task.name}</td>
          <td>${task.type}</td>
          <td>${task.date}</td>
          <td>${task.duration}</td>
          <td>${task.period === 'Sáng'
                        ? '<span style="color: gold;">☀️ Sáng</span>'
                        : '<span style="color: red;">🌇 Chiều/Tối</span>'}
          </td>
          <td>
            <button onclick="editTask(${task.id}, '${task.name}', '${task.type}', '${task.date}', ${task.duration})">Sửa</button>
            <button onclick="deleteTask(${task.id})">Xoá</button>
          </td>
        `;
                tbody.appendChild(row);
            });
        });
}

function addTask() {
    const name = document.getElementById("taskName").value.trim();
    const type = document.getElementById("taskType").value.trim();
    const date = document.getElementById("taskDate").value;
    const duration = document.getElementById("taskDuration").value;
    const period = document.getElementById("taskPeriod").value.trim();
    if (!period) {
        alert("Vui lòng chọn thời gian.");
        return;
    }
    if (!name || !type || !date || !duration) {
        alert("Vui lòng điền đầy đủ thông tin trước khi thêm hoặc cập nhật.");
        return;
    }

    const task = { name, type, date, duration: parseFloat(duration),period };

    const method = editingId ? "PUT" : "POST";
    const url = editingId ? `http://localhost:8080/tasks/${editingId}` : "http://localhost:8080/tasks";

    fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(task)
    })
        .then(() => {
            resetForm();
            fetchTasks();
        });
}


function editTask(id, name, type, date, duration) {
    editingId = id;
    document.getElementById("taskName").value = name;
    document.getElementById("taskType").value = type;
    document.getElementById("taskDate").value = date;
    document.getElementById("taskDuration").value = duration;
    document.getElementById("taskPeriod").value = period;
}

function deleteTask(id) {
    fetch(`${apiUrl}/${id}`, { method: 'DELETE' })
        .then(() => fetchTasks());
}

function resetForm() {
    editingId = null;
    document.getElementById("taskName").value = "";
    document.getElementById("taskType").value = "";
    document.getElementById("taskDate").value = "";
    document.getElementById("taskDuration").value = "";
    document.getElementById("taskPeriod").value = "";
}
