let forgot_pw = document.querySelector('.forgot_pw')
let close = document.querySelector('.close')
let save = document.querySelector('.save')


forgot_pw.addEventListener('click',function(){
    let wherePw = document.getElementById('wherePw');
    wherePw.style.display = 'block';
})

close.addEventListener('click',function(){
    let wherePw = document.getElementById('wherePw');
    wherePw.style.display = 'none';
})

save.addEventListener('click',function(){
    let wherePw = document.getElementById('wherePw');
    wherePw.style.display = 'none';
})

let wherePwElem = document.querySelector('#whereId');
var submitBtnElem = wherePwElem.querySelector('input[type=submit]');

submitBtnElem.addEventListener('click', function (e){
   e.preventDefault();
   let url = '/user/findPw'
});