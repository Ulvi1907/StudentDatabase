function clearStudentTable(){
    let studentsTable = document.getElementById("students");

    while (studentsTable.rows.length > 1){
        studentsTable.deleteRow(1);
    }
}

function addStudentsIntoTable(data){
    let studentsTable = document.getElementById("students");
    for ( let i = 0; i < data.length; i++) {
        console.log(data[i].id +' '+ data[i].name + ' ' + data[i].surname + ' ' + data[i].point);
        let row = '<tr>'+
            '<td>' + data[i].id + '</td>' +
            '<td>' + data[i].name + '</td>' +
            '<td>' + data[i].surname + '</td>' +
            '<td>' + data[i].point + '</td>' +
            '<td><button onclick="showStudentDetails('+ data[i].id +')">View</button>&nbsp;' +
            '<button onclick="showStudentDetailsUpdate('+data[i].id +')">Update</button>&nbsp;' +
            '<button onclick="DeleteStudent('+data[i].id+')">Delete</button></td>' +
            '</tr>';
        let newRow = studentsTable.insertRow(studentsTable.rows.length);
        newRow.innerHTML = row;
    }
}

function showAllStudents() {
    fetch('/student/api/list/')
        .then(response => response.json())
        .then(data => {
            clearStudentTable()
            addStudentsIntoTable(data)
    })
        .catch(reason => console.log("Error getting students data "+ reason))

  }

function showStudentDetails(student_id){
    fetch('/student/api/list/'+ student_id)
        .then(response => response.json())
        .then(data => {
            alert(' ID: ' + data.id +
                '\n NAME: ' + data.name +
                '\n SURNAME: '+ data.surname +
                '\n POINT: '+ data.point);
        })

}
function showStudentDetailsUpdate(student_id){
    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/student/api/list/'+ student_id);

    xhr.onload = function (){
        console.log('Received student data '+ xhr.responseText);
        let data = JSON.parse(xhr.responseText);


        document.getElementById("id").innerHTML = data.id;
        document.getElementById("name").value = data.name;
        document.getElementById("surname").value = data.surname;
        document.getElementById("point").value = data.point;
        document.getElementById("update").style.display = 'block';
        document.getElementById("students").style.display = 'none';

    };

    xhr.onerror = function (){
        console.log('Error getting student details');
    };

    xhr.send();
}
function updateStudent(){
    let xhr = new XMLHttpRequest();
    let studentId = document.getElementById("id").innerText;
    xhr.open('PUT', '/student/api/list/' + studentId);
    xhr.setRequestHeader('Content-Type', 'application/json');

    let student = {
        'id': studentId,
        'name': document.getElementById("name").value,
        'surname': document.getElementById("surname").value,
        'point': document.getElementById("point").value
    }

    xhr.onload = function () {
        console.log('Save student data result ' + xhr.responseText);
        document.getElementById("update").style.display = 'none';
        document.getElementById("students").style.display = 'table';
        showAllStudents();
    };

    xhr.onerror = function () {
        console.log('Error getting student ' + studentId + ' details');
    };

    console.log(JSON.stringify(student));
    xhr.send(JSON.stringify(student));
}
function DeleteStudent(student_id){
    let xhr = new XMLHttpRequest();
    xhr.open('DELETE', '/student/api/list/'+ student_id);

    xhr.onload = function (){
        console.log('Received student data '+ xhr.responseText);
        alert("Delete Student with id = "+ student_id);
        return showAllStudents();
    };

    xhr.onerror = function (){
        console.log('Error getting student details');
    };

    xhr.send();
}
showAllStudents();