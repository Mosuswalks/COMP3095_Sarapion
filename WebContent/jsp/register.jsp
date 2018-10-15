<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <!-- Bulma Version 0.7.1-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <section class="hero is-light is-fullheight">
        <div class="hero-body">
          <div class="container has-text-centered">
            <div class="column is-6 is-offset-3">
              <h3 class="title has-text-grey">Registration Page</h3>
              <p class="subtitle has-text-grey">Please register to proceed.</p>
              <%
             	if(request.getAttribute("formErrors") != null){
	            List<String> errors =  (ArrayList<String>) request.getAttribute("formErrors");
              	if(errors.size() != 0){
	            	Iterator<String> iterator = errors.iterator();
		              while(iterator.hasNext()){
		            	  String error = iterator.next();%>
	            	  <p class="has-text-left has-text-danger has-text-weight-semibold">&bull;&nbsp;<%= error %></p>
	            <% 
	            
	              	}
	              }
             	}
	            %>
              
              <div class="box">
                
                <form method="post" action="Register">
                
                	<!---------- FIRST NAME & LAST NAME FIELDS ---------->
					<div class="columns">
	                  <div class="field column">
     				  	<label class="label has-text-left">First Name:</label>
	                 	<p class="control has-icons-left">
	                        <input class="input" type="text" name="firstName" placeholder="First Name">  
	                    </div>

	                  <div class="field column">
	                     <div class="control">	
	                     	<label class="label">Last Name:</label>
	                        <p class="control has-icons-left">
	                        <input class="input" type="text" name="lastName" placeholder="Last Name">
	                    </div>
	                  </div>
                  	</div>
                    
					<!---------- ADDRESS FIELD ---------->
					<div class="field">
     				  	<label class="label has-text-left">Address</label>
						<div class="control has-icons-left has-icons-right">
					    	<input class="input" type="text" name="address" placeholder="Enter Address" >
                            <span class="icon is-small is-left">
                              <i class="fas fa-map-marked-alt"></i>
                            </span>
					  	</div>
					</div>
					
					
					<!---------- EMAIL FIELD ---------->
					<div class="column is-6 is-offset-3">
	                    <div class="field">
	     					<label class="label has-text-left">Email:</label>
						  	<div class="control has-icons-left has-icons-right">
						    	<input class="input" type="email" name="email" placeholder="Enter Email">
						   	<span class="icon is-small is-left">
						      <i class="fa fa-envelope"></i>
						    </span>
						  </div>
						</div>
						
						
						<div class="field">
							
	     					<label class="label has-text-left">Password:</label>
	  					  	
							<p class="control has-icons-left">
								<input class="input" name="password" type="password" placeholder="Enter Password">
							    <span class="icon is-small is-left">
							      <i class="fas fa-unlock-alt"></i>
							    </span>
							</p>
						</div>
                        
                        <div class="field ">
	     					<label class="label has-text-left">Confirm Password:</label>

							<p class="control has-icons-left">
								<input class="input" name="passwordConfirmation" type="password" placeholder="Re-Enter Password">
							    <span class="icon is-small is-left">
							      <i class="fa fa-lock"></i>
							    </span>
							</p>
						</div>
                   
                    </div>
                    <!----- Terms and Conditions ------>
                    <div class="field">
					  <div class="control has-text-centered">
					    <label class="checkbox">
					      <input type="checkbox">
					      I agree to the <a class="has-text-link"href="https://google.com">terms and conditions</a>
					    </label>
					  </div>
					</div>

					<!------ Submit & Cancel ------->
                    <div class="control has-text-centered">
    				 	<button class="button is-success is-medium" type="submit" >Submit</button>
          				<a class="button is-danger is-medium" href="login" >Cancel</a>
  					</div>
                </form>
              </div>
            </div>
          </div>
        </div>
        

    </section>
    
    <script async type="text/javascript" src="../js/bulma.js"></script>
</body>

</html>