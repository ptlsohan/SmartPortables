
$(document).ready(function () {
  $.ajax({

    url: "DataVisualisation",

    dataType: "JSON",

    success: function (data) {
	 google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);
      drawChart(data);
     
    }
   });
 function drawChart(jsonData) {
         data = new google.visualization.DataTable();

  data.addColumn('string', 'Product Name');

  data.addColumn('number', 'Total Sale');

 
  /* for loop code for changing inputdata to 'data' of type google.visualization.DataTable*/
  $.each(jsonData, function (i, obj) {

   point1 = "Sale : " + obj.totalsale + "";



   dataArray.push([obj.productname, obj.totalsale]);
  });

  data.addRows(dataArray);
        var options = {
          chart: {
            title: 'Company Performance',
            subtitle: 'Sales, Expenses, and Profit: 2014-2017',
          },
          bars: 'horizontal' // Required for Material Bar Charts.
        };
		
		

        var chart = new google.charts.Bar(document.getElementById('barchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
});
