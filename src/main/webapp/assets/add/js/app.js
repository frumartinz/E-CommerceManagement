const form = document.getElementById('custome-form');
const email = document.getElementById('email');
const password = document.getElementById('password');

form.addEventListener('submit', (e) => {
    e.preventDefault();

    checkInputs();
});

function checkInputs(){
    //get the values from the inputs
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();

    if(emailValue === '') {
        //show error
        //add error class
        setErrorFor(email, 'email cannot be blank');
    } else if(!isEmail(emailValue)) {
        setErrorFor(email, 'Email is not valid');
    } else{
        //add success class
        setSuccessFor(email);
    }

    if(passwordValue === '') {
        setErrorFor(password, 'password cannot be blank');
    } else if(passwordValue.length < 7) {
        setErrorFor(password, 'Password must be at least 7 characters')
    } else{
        //add success class
        setSuccessFor(password);
    }
}

function setErrorFor(input, message) {
    const myd = input.parentElement; //.form-control
    const small = myd.querySelector('small');

    //add error message inside small
    small.innerText = message;

    //add error class
    myd.className = 'myd error';
}

function setSuccessFor(input) {
    const myd = input.parentElement;
    myd.className = 'myd success';
}

function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}
