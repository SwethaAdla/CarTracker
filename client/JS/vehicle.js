function submit(){

  $.ajax({
          url:"http://localhost:8080/vehicles",
          type: "GET",
          crossDomain: true,
          success: onSuccess,
          error: function(e){
              console.log(e);
              alert("error - "+e);
          },
      });

}
function onSuccess(response){

  table = document.getElementById("table");
  var rowCount=table.rows.length;
  for(var x=rowCount-1;x>0;x--){
    table.deleteRow(x);
  }



  var data = response

  for(var i=0;i<response.length;i++){
    var addRow = table.insertRow(table.length);
    for(var j=0;j<7;j++){
      var col = addRow.insertCell(j);
      if(j==0){col.innerHTML = response[i]["vin"];}
      if(j==1){col.innerHTML = response[i]["make"];}
      if(j==2){col.innerHTML = response[i]["model"];}
      if(j==3){col.innerHTML = response[i]["year"];}
      if(j==4){col.innerHTML = response[i]["redlineRpm"];}
      if(j==5){col.innerHTML = response[i]["maxFuelVolume"];}
      if(j==6){col.innerHTML = response[i]["lastServiceDate"];}
    }
//    var option = document.createElement("option");
  //  option.value= response[i]["vin"];
    //option.innerHTML = response[i]["vin"];
    //select.appendChild(option);
  }
}
