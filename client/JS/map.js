
 function maps()
 {
   $.ajax({
           url:"http://localhost:8080/readings",
           type: "GET",
           crossDomain: true,
           success: onSuccessMap,
           error: function(e){
               console.log(e);
               alert("error - "+e);
           },
       });
    }

function onSuccessMap(response){
  var latitude=response[0].latitude;
  var longitude=response[0].longitude;
  alert("latitude"+latitude+"longitude"+longitude);
    var uluru = {lat:latitude, lng: longitude};
   var map = new google.maps.Map(document.getElementById('map'), {
     center: {lat: latitude, lng: longitude},
     zoom: 8
   });
   var marker = new google.maps.Marker({
     position: uluru,
     map: map
   });
 }
