let user = sessionStorage.getItem('user');

if (user === null) {
    let name = prompt('Please enter your name');
    while (name === null || name === '') {
        name = prompt('Please enter your name');
    }
    // fetch users
    fetch('/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: name
    }).then(response => response.json())
        .then(user => {
            sessionStorage.setItem('user', JSON.stringify(user));
        })
} else {
    user = JSON.parse(sessionStorage.getItem('user'));


}
