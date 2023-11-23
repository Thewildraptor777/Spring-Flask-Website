// Get a reference to the form element
const form = document.getElementById('myForm');
form.setAttribute("action", window.location.protocol + "//" + window.location.hostname + ":8080/api/login")
// Add an event listener for form submission
form.addEventListener('submit', (e) => {
    e.preventDefault(); // Prevent the default form submission

    // Get the form data
    const formData = new FormData(form);

    // Send the form data to a server endpoint
    fetch(window.location.protocol + "//" + window.location.hostname + ":8080/api/login", {
        method: 'POST',
        body: formData
    })
        .then(response => response.text())
        .then(data => {
            // Handle the response from the server
            console.log(data);
            // Perform any other required operations
            if (data != '"No Data"') {
                // Data to send
                const newdata = {
                    data: data,

                };

                // Build the query string with the data
                const queryString = new URLSearchParams(newdata).toString();

                // Make a GET request to Flask server with the query string
                fetch(`/submit?${queryString}`)
                    .then(response => response.text())
                    .then(responseData => {
                        // Handle the response from Flask server
                        console.log(responseData);
                    })
                    .catch(error => {
                        // Handle any errors that occurred
                        console.error(error);
                    });
           // window.location.pathname = "/home"
            }
            else {
                window.location.reload()
            }
        })
        .catch(error => {
            // Handle any errors that occurred
            console.error(error);
        });
});


