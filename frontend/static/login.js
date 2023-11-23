function checkLogin(username, inputpassword) {
    const url = `http://localhost:8080/api/login?username=${encodeURIComponent(username)}&password=${encodeURIComponent(inputpassword)}`;
    
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    };

    fetch(url, options)
        .then(response => response.json())
        .then(responseData => {
            console.log(responseData);
            if (responseData !== 'No Data') {
                console.log('Correct credentials');
            } else {
                console.log('Incorrect credentials');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

checkLogin('dev', 'tester');