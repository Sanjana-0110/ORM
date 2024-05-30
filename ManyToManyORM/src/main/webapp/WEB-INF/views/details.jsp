<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Students with Multiple Courses</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <h2>Add Students with Multiple Courses</h2>
    <form id="studentsForm">
        <div id="studentsContainer">
            <!-- Dynamic student input sections will be added here -->
        </div>

        <button type="button" onclick="addStudentInput()">Add Another Student</button><br><br>
        <button type="button" onclick="submitForm()">Submit</button>
    </form>

    <script>
        function addStudentInput() {
            var studentContainer = document.createElement("div");
            studentContainer.className = "studentContainer";
            
            var studentLabel = document.createElement("label");
            studentLabel.innerText = "Student Name:";
            studentContainer.appendChild(studentLabel);
            
            var studentInput = document.createElement("input");
            studentInput.type = "text";
            studentInput.name = "name";
            studentInput.required = true;
            studentContainer.appendChild(studentInput);
            studentContainer.appendChild(document.createElement("br"));
            
            var coursesContainer = document.createElement("div");
            coursesContainer.className = "coursesContainer";
            studentContainer.appendChild(coursesContainer);

            var addCourseButton = document.createElement("button");
            addCourseButton.type = "button";
            addCourseButton.innerText = "Add Another Course";
            addCourseButton.onclick = function() { addCourseInput(coursesContainer); };
            studentContainer.appendChild(addCourseButton);
            studentContainer.appendChild(document.createElement("br"));
            studentContainer.appendChild(document.createElement("br"));

            document.getElementById("studentsContainer").appendChild(studentContainer);
        }

        function addCourseInput(coursesContainer) {
            var courseIdDropdown = document.createElement("select");
            courseIdDropdown.name = "id";
            courseIdDropdown.required = true;

            // Add static options for course ID dropdown
            var courseIdOptions = ["1", "2", "3", "4", "5"];
            courseIdOptions.forEach(function(option) {
                var courseIdOption = document.createElement("option");
                courseIdOption.value = option;
                courseIdOption.text = option;
                courseIdDropdown.appendChild(courseIdOption);
            });

            var courseTitleDropdown = document.createElement("select");
            courseTitleDropdown.name = "title";
            courseTitleDropdown.required = true;

            // Add static options for course title dropdown
            var courseTitleOptions = ["Java", "Spring", "Python", "Machine Learning", "AI"];
            courseTitleOptions.forEach(function(option) {
                var courseTitleOption = document.createElement("option");
                courseTitleOption.value = option;
                courseTitleOption.text = option;
                courseTitleDropdown.appendChild(courseTitleOption);
            });

            coursesContainer.appendChild(courseIdDropdown);
            coursesContainer.appendChild(courseTitleDropdown);
            coursesContainer.appendChild(document.createElement("br"));
        }


        function submitForm() {
            var students = [];
            var studentContainers = document.querySelectorAll(".studentContainer");
            
            studentContainers.forEach(function(studentContainer) {
                var studentName = studentContainer.querySelector("input[name='name']").value.trim();
                var courses = [];
                var courseIdInputs = studentContainer.querySelectorAll("select[name='id']"); // Select dropdown for course ID
                var courseTitleInputs = studentContainer.querySelectorAll("select[name='title']"); // Select dropdown for course title
                
                for (var i = 0; i < courseIdInputs.length; i++) {
                    var courseId = courseIdInputs[i].value;
                    var courseTitle = courseTitleInputs[i].value;

                    if (courseId !== "" && courseTitle !== "") {
                        courses.push({ id: courseId, title: courseTitle }); // Include both course ID and title in the courses array
                    }
                }

                if (studentName !== "" && courses.length > 0) {
                    students.push({ name: studentName, courses: courses });
                }
            });

            var data = {
                students: students
            };

            console.log(data); // For debugging purposes

            $.ajax({
                type: 'POST',
                url: "http://localhost:8080/ManyToManyORM/insertStudents",
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function(response) {
                    console.log("Data inserted Successfully");
                    alert("Data inserted Successfully");
                },
                error: function(error) {
                    console.error("Error:", error);
                    alert("Error: " + error.statusText);
                }
            });
        }

        // Initialize the form with one student input section
        addStudentInput();
    </script>
</body>
</html>
