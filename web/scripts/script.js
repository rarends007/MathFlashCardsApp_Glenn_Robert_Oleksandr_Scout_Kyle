/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
"use strict";

const signInBtn = document.querySelector('.sing_in_container>a');
const getStarted = document.querySelector('#get_started');

const cancelBtn = document.querySelector('#login-btn-cancel');

//separated button logic so that it would allow a cancel to execute, with the original logic " if(signInBtn || getStarted) {} " the condition was always true, leading to logic issues with the cancel button
if (signInBtn) {
    signInBtn.addEventListener('click', (e) => signInForm(e));
}

if (getStarted) {
    getStarted.addEventListener('click', (e) => signInForm(e));
}
  
if(cancelBtn){
    cancelBtn.addEventListener('click', (e) => cancelSignInForm(e));
    console.log("cancel button clicked");
}else{
    console.log("Issue with the cancel button");
}


function signInForm(e) {
    e.preventDefault();
    const modMenu = document.querySelectorAll('.modular_menu');
    modMenu.forEach(element => {
        element.style.display = 'none';
    });
    const logInForm = document.querySelector('#login_form');
    logInForm.style.display = 'flex';
}

function cancelSignInForm(e) {
    e.preventDefault();
    //reverse changes to the modmenu
    const modMenu = document.querySelectorAll('.modular_menu');
    modMenu.forEach(elem => {
        elem.style.display = 'block';
    });
    // Hide the login form
    const logInForm = document.querySelector('#login_form');
    if (logInForm) {
        logInForm.style.display = 'none';
    }
}
