var TUTORIAL_SAVVY = {

 /*return google visualization data*/
 getvisualizationData: function (jsonData) {

  var point1, point2, dataArray = [],

   data = new google.visualization.DataTable();

  data.addColumn('string', 'Product Name');

  data.addColumn('number', 'Total Sale');

 
  /* for loop code for changing inputdata to 'data' of type google.visualization.DataTable*/
  $.each(jsonData, function (i, obj) {

   point1 = "Sale : " + obj.totalsale + "";



   dataArray.push([obj.productname, obj.totalsale]);
  });

  data.addRows(dataArray);

  return data;
 },
 /*return options for bar chart: these options are for various configuration of chart*/
 getOptionForBarchart: function () {

  var options = {
   animation: {
    duration: 2000,
    easing: 'out'
   },

   hAxis: {
    baselineColor: '#ccc'
   },
   vAxis: {
    baselineColor: '#ccc',
    gridlineColor: '#fff'
   },

   isStacked: true,
   height: 400,
   backgroundColor: '#fff',
   colors: ["#68130E", "#c65533"],
   fontName: 'roboto',
   fontSize: 12,
   legend: {
    position: 'top',
    alignment: 'end',
    textStyle: {
     color: '#b3b8bc',
     fontName: 'roboto',
     fontSize: 12
    }
   },
   
  };
  return options;
 },
 /*Draws a Bar chart*/
 drawBarChart: function (inputdata) {

  var barOptions = TUTORIAL_SAVVY.getOptionForBarchart(),

   data = TUTORIAL_SAVVY.getvisualizationData(inputdata),

   chart = new google.visualization.ColumnChart(document.getElementById('barchart_material'));

  chart.draw(data, barOptions);
  /*for redrawing the bar chart on window resize*/
  $(window).resize(function () {

   chart.draw(data, barOptions);
  });
 },
 /* Returns a custom HTML tooltip for Visualization chart*/
 returnTooltip: function (dataPoint1, dataPoint2) {

  return "<div style='height:30px;width:150px;font:12px,roboto;padding:15px 5px 5px 5px;border-radius:3px;'>" +
   "<span style='color:#68130E;font:12px,roboto;padding-right:20px;'>" + dataPoint1 + "</span>" +
   "<span style='color:#c65533;font:12px,roboto;'>" + dataPoint2 + "</span></div>";
 },
 /*Makes ajax call to servlet and download data */
 getPrductData: function () {

  $.ajax({

    url: "DataVisualisation",

    dataType: "JSON",

    success: function (data) {

     TUTORIAL_SAVVY.drawBarChart(data);
    }
   });
 }
};

google.load("visualization", "1", {
  packages: ["corechart"]
 });

$(document).ready(function () {

 TUTORIAL_SAVVY.getProductData();
});