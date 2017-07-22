function showButton(){
  table = document.getElementById("table");
  table.innerHTML="";
var select = document.getElementById("vehicleVinList");
$.ajax({
        url:"http://localhost:8080/readings",
        type: "GET",
        crossDomain: true,
        success: OnSuccessShowButton,
        error: function(e){
            console.log(e);
            alert("error - "+e);
        },
    });
  }

    function OnSuccessShowButton(response){
      document.getElementById("drpdwn").classList.toggle("show");
      var select=document.getElementById("vehicleVinList");
      var data = response;
      for(var i=0;i<data.length;i++){
        var option = document.createElement("option");
        option.value= data[i]["vin"];
        option.innerHTML = data[i]["vin"];
       select.appendChild(option);
      }
      }

function selectVin(){
  //alert(document.getElementById("vehicleVinList").value);
  var selectedVin = document.getElementById("vehicleVinList").value;
  $.ajax({
          url:"http://localhost:8080/readings/"+selectedVin,
          type: "GET",
          crossDomain: true,
          success: onVinSelected,
          error: function(e){
              console.log(e);
              alert("error - "+e);
          },
      });

}
function onVinSelected(response){
//  alert("onVinSelected function");
  table = document.getElementById("alertstable")
  var data = response

  for(var i=0;i<response.length;i++){
    var addRow = table.insertRow(table.length);
    for(var j=0;j<4;j++){
      var col = addRow.insertCell(j);
      if(j==0){col.innerHTML = response[i]["vinNo"];}
      if(j==1){col.innerHTML = response[i]["alertStatus"];}
      if(j==2){col.innerHTML = response[i]["msg"];}
      if(j==3){col.innerHTML = response[i]["timeAlertGenerated"];}
    }
  }
}

function showHighAlerts(){
  $.ajax({
          url:"http://localhost:8080/readings/alerts",
          type: "GET",
          crossDomain: true,
          success: showAlerts,
          error: function(e){
              console.log(e);
              alert("error - "+e);
          },
      });
}
function showAlerts(response){
  //alert("fjhbdfjvbfdj"+response);
  var stringJson=JSON.stringify(response,null,2);
  var stringJSONNew=stringJson.split("{")[1];
  var stringJsonUp=stringJSONNew.split("}")[0];
//  alert("high alerts generated"+stringJsonUp);
  var keyValue=stringJsonUp.split(",");
//  alert("high alfkjdkfjerts generated"+stringJsonUp.split(",")[0].split(":")[0]);

  table = document.getElementById("highalertstable");
  table.classList.toggle("show");
  for(var i=0;i<stringJson.length;i++){
    var addRow = table.insertRow(table.length);
    for(var j=0;j<2;j++){
      var col = addRow.insertCell(j);
    if(j==0){col.innerHTML = stringJsonUp.split(",")[i].split(":")[0].replace(/["]+/g,'');}
    if(j==1){col.innerHTML = stringJsonUp.split(",")[i].split(":")[1];}
  }
}
}
