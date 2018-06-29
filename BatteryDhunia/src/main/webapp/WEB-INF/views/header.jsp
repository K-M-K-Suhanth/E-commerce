<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
 /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   .active {
    background-color: white;
    }
    .collapse navbar-collapse a:hover {background-color: #f1f1f1}
    </style>
</head>
<body>
    <header>
<div class="jumbotron">
  <div class="container text-left">
    <h1>Battery Dhunia</h1>      
    <p>A place for all your batteries</p>
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <!--<a class="navbar-brand" href="home.jsp"><img src="C:\\Users\\Suhanth\\Desktop\\project\\navbaricon.jpg"></a>-->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="aboutus">Home</a></li>
        <li><a href="/BatteryDhunia/aboutus">AboutUs</a></li>
        <li><a href="#foo">Categories</a></li>
        <li><a href="/BatteryDhunia/displayproducts">Products</a></li>
        <li><a href="/BatteryDhunia/contactus">ContactUs</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="wishlist"><span class="glyphicon glyphicon-heart"></span> Wish List</a></li>
        <li><a href="showcart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        <li><a href="/BatteryDhunia/"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
      </ul>
    </div>
  </div>
</nav>
</header>
</body>
</html>