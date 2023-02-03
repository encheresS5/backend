const URL="./inscription";

console.log("MANDEHA");
function createInput(value,name) {
    let input=document.createElement("input");
    input.name=name;
    input.type="hidden";
    input.value=value;
    console.log(input);
    return input;
}

function createForm(idCandidat,idFiliere) {
    let form=document.createElement("form");
    form.appendChild(createInput(idCandidat,'idcandidat'));
    form.appendChild(createInput(idFiliere,'idfiliere'));
    console.log(form);
    return form;
}

function getFormData(idCandidat,idFiliere) {
    let form_data=new FormData(createForm(idCandidat,idFiliere));
    console.log(form_data);
    return form_data;
}

function updateETU(idCandidat,numero){
    console.log(numero)
}

function confirmInscription(idCandidat,idFiliere,nom){
    console.log("confirm");
    console.log(idCandidat+" "+idFiliere+" "+nom);
    if (window.confirm("Voulez-vous inscrire "+nom)===true){
            inscrire(idCandidat,idFiliere);
    }
}

function inscrire(idCandidat,idFiliere){
    let xhr;
    try { xhr = new ActiveXObject('Msxml2.XMLHTTP'); }
    catch (e)
    {
        try { xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
        catch (e2)
        {
            try { xhr = new XMLHttpRequest(); }
            catch (e3) { xhr = false; }
        }
    }
    xhr.onreadystatechange = function ()
    {
        if (xhr.readyState == 4)
        {
            if (xhr.status == 200)
            {
                let result = JSON.parse(xhr.responseText);
                updateETU("",result);
            } else
            {
                document.dyn = "Error code " + xhr.status;
            }
        }
    };
    var data =JSON.stringify({
        "idCandidat":idCandidat,
        "idFiliere":idFiliere,
    });
    xhr.open("POST", URL, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    console.log(getFormData(idCandidat,idFiliere))
    xhr.send(getFormData(idCandidat,idFiliere));
}
