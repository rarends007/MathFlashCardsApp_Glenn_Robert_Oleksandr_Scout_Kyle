/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const signInBtn = document.querySelector('.sing_in_container>a');
const getStarted = document.querySelector('#get_started');

if (signInBtn || getStarted) {
    signInBtn.addEventListener('click', (e) => signInForm(e))
    getStarted.addEventListener('click', (e) => signInForm(e))
}


function signInForm(e) {
    e.preventDefault();
    modMenu = document.querySelectorAll('.modular_menu')
    modMenu.forEach(element => {
        element.style.display = 'none';
    });
    const logInForm = document.querySelector('#login_form');
    logInForm.style.display = 'flex'
}