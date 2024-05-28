<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Author with Multiple Books</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <h2>Add Author with Multiple Books</h2>
    <form id="authorForm">
        <label for="authorName">Author Name:</label>
        <input type="text" id="authorName" name="name" required><br><br>

        <div id="booksContainer">
            <!-- Dynamic book title input fields will be added here -->
        </div>

        <button type="button" onclick="addBookInput()">Add Another Book</button><br><br>

        <button type="button" onclick="submitForm()">Submit</button>
    </form>

    <script>
        function addBookInput() {
            var container = document.getElementById("booksContainer");
            var input = document.createElement("input");
            input.type = "text";
            input.name="title";
            input.placeholder = "Enter Book Title";
            container.appendChild(input);
            container.appendChild(document.createElement("br"));
        }

        function submitForm() {
            var authorName = document.getElementById("authorName").value;
            var book = [];
            var bookInputs = document.querySelectorAll("#booksContainer input");
            bookInputs.forEach(function(input) {
                var title = input.value.trim();
                if (title !== "") {
                    book.push(title);
                }
            });

            // Display collected data in the console
            console.log("Author Name:", authorName);
            console.log("Books:", book);

            var data = {
                name: authorName
               
            };
            console.log(data);
            $.ajax({
                type: 'POST',
                url: "http://localhost:8080/OneToManyORM/insertAuthor",
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function(response) {
                    console.log("Data inserted Successfully");
                    // Handle success as needed
                    alert("Data inserted Successfully");
                },
                error: function(error) {
                    console.error("Error:", error);
                    // Handle error as needed
                    alert("Error: " + error.statusText);
                }
            });
        }
    </script>
</body>
</html>
