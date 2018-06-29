<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    <style>

    </style>
    </head>
<body>
 Hello ${user.username}
<jsp:include page="header.jsp"></jsp:include>
<div id="top">
    <!-- this assumes your User class has a username field with a valid getter -->
   
</div>
    <br>
    <br>
    <!--carosel block adding-->

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="C:\\Users\\Suhanth\\Desktop\\project\\1.jpg"  height="300" width=100% alt="Image">
        <div class="carousel-caption">
          <!-- <h3>Sell $</h3>
          <p>Money Money.</p> -->
        </div>      
      </div>

      <div class="item">
        <img src="C:\\Users\\Suhanth\\Desktop\\project\\2.jpg" height="300" width=100% alt="Image">
        <div class="carousel-caption">
          <!-- <h3>More Sell $</h3>
          <p>Lorem ipsum...</p> -->
        </div>      
      </div>
        
      <div class="item">
        <img src="C:\\Users\\Suhanth\\Desktop\\project\\3.jpg" height="300" width=100% alt="Image">
        <div class="carousel-caption">
          <!-- <h3>More Sell $</h3>
          <p>Lorem ipsum...</p> -->
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
<br/>
<br/>
    <div id="foo">
<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Automotive Batteries</div>
        <div class="panel-body"><a href="/BatteryDhunia/displayproducts"><img src="C:\\Users\\Suhanth\\Desktop\\project\\download1.png" class="img-responsive" style="width:100%" alt="Image"></a></div>
        <div class="panel-footer">Good Battries are like Good Food!</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading">Inverter Batteries</div>
        <div class="panel-body"><a href="homeinvertors"><img src="C:\\Users\\Suhanth\\Desktop\\project\\download2.png" class="img-responsive" style="width:100%" alt="Image"></a></div>
        <div class="panel-footer">We are available at your home</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-success">
        <div class="panel-heading">Industrial Batteries</div>
        <div class="panel-body"><a href="industries"><img src="C:\\Users\\Suhanth\\Desktop\\project\\download3.png" class="img-responsive" style="width:100%" alt="Image"></a></div>
        <div class="panel-footer">All Industrial Batteries</div>
      </div>
    </div>
  </div>
</div><br>

<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-default">
        <div class="panel-heading">UPS Batteries</div>
        <div class="panel-body"><a href="ups"><img src="C:\\Users\\Suhanth\\Desktop\\project\\download4.png" class="img-responsive" style="width:100%" alt="Image"></a></div>
        <div class="panel-footer">Home UPS Systems</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-info">
        <div class="panel-heading">Solar Batteries</div>
        <div class="panel-body"><a href="solar"><img src="C:\\Users\\Suhanth\\Desktop\\project\\download5.png" class="img-responsive" style="width:100%" alt="Image"></a></div>
        <div class="panel-footer">Use Renewable energy</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-warning">
        <div class="panel-heading">Recyle Reuse Reduce</div>
        <div class="panel-body"><a href="recycle"><img src="C:\\Users\\Suhanth\\Desktop\\project\\download6.png" class="img-responsive" style="width:100%" alt="Image"></a></div>
        <div class="panel-footer">Do you have some old Batteries?, call us.</div>
      </div>
    </div>
  </div>
</div>
</div>        <br><br>
    <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>