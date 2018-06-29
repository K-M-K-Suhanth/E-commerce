<jsp:include page="header.jsp"/>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<html>
    <head>
        <title>DeliveryAddress'</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha256-k2/8zcNbxVIh5mnQ52A0r3a6jAgMGxFJFE2707UxGCk= sha512-ZV9KawG2Legkwp3nAlxLIVFudTauWuBpC10uEafMHYL0Sarrz5A7G79kXh5+5+woxQ5HM559XX2UZjMJ36Wplg==" crossorigin="anonymous">
        <style>
        .body {
// custom fonts, etcetera can go here 
}

.jumbotron-flat {
  background-color: solid #4DB8FFF;
  height: 100%;
  border: 1px solid #4DB8FF;
  background: white;
  width: 100%;
text-align: center;
overflow: auto;
}

.paymentAmt {
    font-size: 80px; 
}

.centered {
    text-align: center;
}

.title {
 padding-top: 15px;   
}
        </style>
    </head>
    
    
    
    
    <body style="font-family: 'Open Sans', sans-serif;">
        <div class="container">
        <div class="centered title"><h1>Tell Your Address.</h1></div>
     </div>
     <hr class="featurette-divider"></hr>
         <div class="container">
            <div class="row">
                <div class="col-sm-6">
                <div class="tab-content">
  <div id="stripe" class="tab-pane fade in active">
                       <script src='https://js.stripe.com/v2/' type='text/javascript'></script>
          <form accept-charset="UTF-8" action="/BatteryDhunia/thankyou" class="require-validation" data-cc-on-file="false" data-stripe-publishable-key="pk_bQQaTxnaZlzv4FnnuZ28LFHccVSaj" id="payment-form" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓" /><input name="_method" type="hidden" value="PUT" /><input name="authenticity_token" type="hidden" value="qLZ9cScer7ZxqulsUWazw4x3cSEzv899SP/7ThPCOV8=" /></div>
            <br>
          <div class='form-row'>
              <div class='form-group required'>
                <div class='error form-group hide'>
                <div class='alert-danger alert'>
             
              </div>
            </div>
                <label class='control-label'>Flat-No:</label>
                <input name="flat" class='form-control' size='4' type='text'>
              </div>
                    
            </div>
            <div class='form-row'>
              <div class='form-group card required'>
                  <label class='control-label'>Street:</label>
                <input name="street" autocomplete='off' class='form-control card-number' size='20' type='text'>
              </div>
            </div>
            <div class='form-row'>
              <div class='form-group cvc required'>
                <label class='control-label'>Area:</label>
                <input name="area" autocomplete='off' class='form-control card-cvc'  size='4' type='text'>
              </div>
              <div class='form-group expiration required'>
                <label class='control-label'>City:</label>
                <input name="city" class='form-control card-expiry-month'  size='2' type='text'>
              </div>
              <div class='form-group expiration required'>
                <label class='control-label'>State:</label>
                <input name="state" class='form-control card-expiry-year'  size='4' type='text'>
              </div>
              <div class='form-group expiration required'>
                <label class='control-label'>Zipcode:</label>
                <input name="zipcode" class='form-control card-expiry-year'  size='4' type='text'>
              </div>
            </div>
    
           
            <div class='form-row'>
              <div class='form-group'>
                         <label class='control-label'></label>
                      
               <button class='form-control btn btn-primary' type='submit'> Continue</button>
          
              </form>    
                
              </div>
            </div>    
            
              </div>
                   
          
        </div>   
     
        <div class="col-sm-6">
           <label class='control-label'></label><!-- spacing -->
        
          <br><br>
         
           
                 
          
        </div>
        
     
          
            <br><br><br>
        </div>
                    
                    
                    
                </div>
                
                
                
            </div>
        </div>
        
        
        </form>
        
    </body>
</html>
<jsp:include page="footer.jsp"/>