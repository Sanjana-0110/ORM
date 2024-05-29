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
            var courseInput = document.createElement("input");
            courseInput.type = "text";
            courseInput.name = "title";
            courseInput.placeholder = "Enter Course Title";
            coursesContainer.appendChild(courseInput);
            coursesContainer.appendChild(document.createElement("br"));
        }

        function submitForm() {
            var students = [];
            var studentContainers = document.querySelectorAll(".studentContainer");
            
            studentContainers.forEach(function(studentContainer) {
                var studentName = studentContainer.querySelector("input[name='name']").value.trim();
                var courses = [];
                var courseInputs = studentContainer.querySelectorAll("input[name='title']");
                
                courseInputs.forEach(function(courseInput) {
                    var title = courseInput.value.trim();
                    if (title !== "") {
                        courses.push({ title: title });
                    }
                });

                if (studentName !== "") {
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
