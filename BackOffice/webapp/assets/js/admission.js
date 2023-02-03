function getNumero(id) {
    let id_split=id.split("-");
    return id_split[1];
}

function onlyOne(check_input) {
    console.log(check_input.id);
    let numero=getNumero(check_input.id);
    let inp_admis=document.getElementById("admis-"+numero);
    let inp_attente=document.getElementById("attente-"+numero);
    let inp_refus=document.getElementById("refus-"+numero);
    inp_admis.checked=inp_admis.id==check_input.id;
    inp_attente.checked=inp_attente.id==check_input.id;
    inp_refus.checked=inp_refus.id==check_input.id;
}