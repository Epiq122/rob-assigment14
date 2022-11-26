let user = null;

if (sessionStorage.getItem('user') == null) {
    user = prompt("Please enter your name");
    sessionStorage.setItem('user', user);
}



