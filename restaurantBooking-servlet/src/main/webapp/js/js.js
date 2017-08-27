/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * 
 * 
 */



// sets a few attributes at startup for selects
function refreshAttr(){        
    var restSelect = document.getElementById("selectRestaurant");
    var selectedRestaurant = restSelect.options[restSelect.selectedIndex].value;
    if (!(selectedRestaurant === "0") && restSelect.options[0].value === "0") {
        restSelect.remove(0);
    }
    
    var citySelect = document.getElementById("selectCity");
    var selectedCity = citySelect.options[citySelect.selectedIndex].value;
    if( !(selectedCity === "0") && citySelect.options[0].value === "0") {
        citySelect.remove(0);
    }
    
    var tableSelect = document.getElementById("selectTable");
    var selectedTable = tableSelect.options[tableSelect.selectedIndex].value;
    if( !(selectedTable === "0") && tableSelect.options[0].value === "0") {
        tableSelect.remove(0);
    }
    

    var selectedDate = document.getElementById("selectDate").value;
    if (selectedDate === "") {
        document.getElementById("selectDate").value = document.getElementById("selecteDate").getAttribute("min");
    }
}
//enables the restaurant Select
function enableRestaurant(){
    var citySelect = document.getElementById("selectCity");
    var selectedCity = citySelect.options[citySelect.selectedIndex].value;
    if ( !(selectedCity === '0')  ) {
        document.getElementById("selectRestaurant").disabled = false;
    }    
}
//enables the restaurant Select
function enableTables(){
    var tableSelect = document.getElementById("selectRestaurant");
    var selectedRest = tableSelect.options[tableSelect.selectedIndex].value;
    if ( !(selectedRest === '0')) {
        document.getElementById("selectTable").disabled = false;
    }    
}
// sets Mindate to today so you cant get a booking for Yesterday min="2000-01-02"
function setMinDate() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    if (dd < 10)
        dd = '0' + dd;
    if (mm < 10)
        mm = '0' + mm;
    {
        today = yyyy + '-' + mm + '-' + dd;
    }
    var dateInput = document.getElementById("selectDate");
    dateInput.setAttribute("min", today);
    if (dateInput.getAttribute("value") === "") {
        document.getElementById("selectDate").setAttribute("value", today);
    }
}

// sets a default Time if nothing selected
function setTimeIfnoTime() {
    var timeInput = document.getElementById("selectTime");
    if (timeInput.getAttribute("value") === "") {
        document.getElementById("selectTime").setAttribute("value", "08:00");
    }
}

function mainSetup() {
    setMinDate();
    
    refreshAttr();
    
    setTimeIfnoTime();
    
    enableRestaurant();
    enableTables();
}