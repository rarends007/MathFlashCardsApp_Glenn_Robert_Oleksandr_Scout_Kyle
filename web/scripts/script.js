/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
"use strict";

const signInBtn = document.querySelector('.sing_in_container>a');
const getStarted = document.querySelector('#get_started');
const drillCreateBtn = document.querySelector('#drill_create_btn');
const drillCreateCloseBtn = document.querySelector('#drill_create_close_btn');

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
}
if(drillCreateBtn){
    drillCreateBtn.addEventListener('click', () => document.querySelector('.drill_create_container').style.display = 'flex');
}
if(drillCreateCloseBtn){
    drillCreateCloseBtn.addEventListener('click', () => document.querySelector('.drill_create_container').style.display = 'none');
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
    // Hide the login form
    const logInForm = document.querySelector('#login_form');
    if (logInForm) {
        logInForm.style.display = 'none';
    }
}
