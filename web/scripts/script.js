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
const addQuestionBtn = document.querySelector('#add_question');
const createAnswerBtn = document.querySelector('#create_answer');
const addAnswerBtn = document.querySelector('#add_answer');

const answersPool = [];

//separated button logic so that it would allow a cancel to execute, with the original logic " if(signInBtn || getStarted) {} " the condition was always true, leading to logic issues with the cancel button
signInBtn?.addEventListener('click', (e) => signInForm(e));
getStarted?.addEventListener('click', (e) => signInForm(e));
cancelBtn?.addEventListener('click', (e) => cancelSignInForm(e));
drillCreateBtn?.addEventListener('click', () => document.querySelector('.drill_create_container').style.display = 'flex');
drillCreateCloseBtn?.addEventListener('click', () => document.querySelector('.drill_create_container').style.display = 'none');
addQuestionBtn?.addEventListener('click', () => document.querySelector('.add_qestion_form').style.display = 'flex');
createAnswerBtn?.addEventListener('click', (e) => {
    e.preventDefault();
    document.querySelector('.create_answer_container').style.display = 'flex';
});


addAnswerBtn?.addEventListener('click', (e) => {
    e.preventDefault();
    console.log(answersPool);
    const answerText = document.querySelector('#answer').value;
    const isCorrect = document.querySelector('#isCorrect').checked;
    const answer = {
        'answer': answerText,
        'isCorrect': isCorrect
    };
    answersPool.push(answer);
    document.querySelector('#answer_list').innerHTML = '';

    answersPool.forEach(answer => {
        const li = document.createElement('li');
        li.textContent = answer['answer'];
        if (answer['isCorrect']) li.classList.add('correct_answer');

        document.querySelector('#answer_list').append(li);        
    });
    
    document.querySelector('.create_answer_container').style.display = 'none';   
    document.querySelector('#answers_input').value = answersPool;
});



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
