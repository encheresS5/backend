const $button_ecole = $("#bschool");
const $inp_ecole_id = $("#idecole");
const $inp_ecole_nom = $("#nom_ecole");
const $button_valid_school = $("#valid_school");
const $div_candidat = $("#candidat");
const $div_school = $("#choice_school");
const $list_regions = $("#list_region");
const $list_schools = $("#list_school");

function fillData() {
    $.getJSON("school", function (data) {
        console.log(data);
        setRegion(data.regions);
        $list_regions.change(()=>{
            setSchools(parseInt($list_regions.find(":selected").val()),data.ecoles);
        });
    });
}

fillData();

function setRegion(regions) {
    for (let i = 0; i < regions.length; i++) {
        $list_regions.append(`<option value="${regions[i].idRegion}">${regions[i].nomRegion}</option>`);
    }
}

function setSchools(idregion,schools){
    $list_schools.empty();
    for (let i = 0; i < schools.length; i++) {
        if (schools[i].idRegion===idregion){
        $list_schools.append(`<option value="${schools[i].id}">${schools[i].nom}</option>`);
        }
    }
}

function chooseSchool(){
    $inp_ecole_id.val($list_schools.find(":selected").val());
    $inp_ecole_nom.val($list_schools.find(":selected").text());
}

//POPUP
function showpopup() {
    $div_candidat.attr('class', 'col-lg-6');
    $div_school.fadeIn();
    $div_school.removeAttr("style");
    $div_school.attr('class', 'col-lg-6');
}

function hidepopup() {
    $div_candidat.attr('class', 'offset-lg-2 col-lg-8');
    $div_school.fadeOut();
    $div_school.css({"visibility": "hidden", "display": "none"});
}

$button_ecole.click(() => {
    showpopup();
});

$button_valid_school.click(() => {
    chooseSchool();
    hidepopup();
});



