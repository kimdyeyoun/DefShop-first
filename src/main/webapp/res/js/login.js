let forgot_id = document.querySelector('.forgot_id')
let forgot_pw = document.querySelector('.forgot_pw')
let close = document.querySelector('.close')
let noneAndblock = document.querySelector('.noneAndblock')
let save = document.querySelector('.save')

forgot_id.addEventListener('click',function(){
    let whereId = document.getElementById('whereId');
    whereId.style.display = 'block';
})

close.addEventListener('click', function (){
    let whereId = document.getElementById('whereId');
    whereId.style.display = 'none';
})

save.addEventListener('click', function (){
    let noneAndblock = document.getElementById('noneAndblock');
    noneAndblock.style.display = 'none';
})

save.addEventListener('click', function (){
    let complet = document.getElementById('complet');
    complet.style.display = 'block';
    let whereId = document.getElementById('whereId');
    whereId.style.display = 'none';
})
