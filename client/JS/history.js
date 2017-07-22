google.charts.load('current', {packages: ['corechart']});
function drawLineColors(response) {
      //alert(response);
      //alert(response[0].timestamp+" -- - -- ");
      var data = new google.visualization.DataTable();
      data.addColumn('datetime', 'timestamp');
      data.addColumn('number', 'fuel');
      var dataRowsToBeAdded=[];
      for(var i=0;i<response.length;i++){
        var row1 = [new Date(response[i].timestamp),response[i].fuelVolume];
        dataRowsToBeAdded[i]=row1;
      }
      data.addRows(dataRowsToBeAdded);

      var options = {
        hAxis: {
          title: 'Time'
        },
        vAxis: {
          title: 'Fuel Volume'
        },
        colors: ['#a52714', '#097138']
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }

    function drawLineColors2(response) {
          //alert(response);
          //alert(response[0].timestamp+" -- - -- ");
          var data = new google.visualization.DataTable();
          data.addColumn('datetime', 'timestamp');
          data.addColumn('number', 'speed');
          var dataRowsToBeAdded=[];
          for(var i=0;i<response.length;i++){
            var row1 = [new Date(response[i].timestamp),response[i].speed];
            dataRowsToBeAdded[i]=row1;
          }
          data.addRows(dataRowsToBeAdded);

          var options = {
            hAxis: {
              title: 'Time'
            },
            vAxis: {
              title: 'Speed'
            },
            colors: ['#a52714', '#097138']
          };

          var chart = new google.visualization.LineChart(document.getElementById('chart_div2'));
          chart.draw(data, options);
        }

        function drawLineColors3(response) {
              //alert(response);
              //alert(response[0].timestamp+" -- - -- ");
              var data = new google.visualization.DataTable();
              data.addColumn('datetime', 'timestamp');
              data.addColumn('number', 'Engine Hp');
              var dataRowsToBeAdded=[];
              for(var i=0;i<response.length;i++){
                var row1 = [new Date(response[i].timestamp),response[i].engineHp];
                dataRowsToBeAdded[i]=row1;
              }
              data.addRows(dataRowsToBeAdded);

              var options = {
                hAxis: {
                  title: 'Time'
                },
                vAxis: {
                  title: 'Engine HP'
                },
                colors: ['#a52714', '#097138']
              };

              var chart = new google.visualization.LineChart(document.getElementById('chart_div3'));
              chart.draw(data, options);
            }

function history(){
  //alert("fvjhbdfj");


  $.ajax({
          url:"http://localhost:8080/readings",
          type: "GET",
          crossDomain: true,
          success: onSuccessHistory,
          error: function(e){
              console.log(e);
              alert("error - "+e);
          },
      });
    }

    function onSuccessHistory(response){
      document.getElementById("chart_div").classList.toggle("show");
      google.charts.load('current', {'packages': ['corechart'], 'callback': drawLineColors(response)});
      document.getElementById("chart_div2").classList.toggle("show");
      google.charts.load('current', {'packages': ['corechart'], 'callback': drawLineColors2(response)});
      document.getElementById("chart_div3").classList.toggle("show");
      google.charts.load('current', {'packages': ['corechart'], 'callback': drawLineColors3(response)});
      //google.charts.load('current', {packages: ['corechart', 'line']});
      //google.charts.load("visualization", "1", {packages:["corechart"]});
      //google.charts.setOnLoadCallback(drawLineColors(response));
}
