
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <!-- Bulma Version 0.7.1-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src='https://www.google.com/recaptcha/api.js'></script>
    
</head>

<body>
    <section class="hero is-success is-fullheight">
        <div class="hero-body">
            <div class="container has-text-centered">
                <div class="column is-4 is-offset-4">
                    <h3 class="title has-text-grey">Login</h3>
                    <p class="subtitle has-text-grey">Please login to proceed.</p>
                    <%
                    	if(request.getAttribute("error") != null){
                    %>
                    	<p class=" has-text-danger has-text-weight-semibold">&bull;&nbsp;<%= request.getAttribute("error") %></p>
                    <%	
                   		}
                    %>
                    
                    <div class="box">
                        <form method="post" action="Login">
                            <div class="field">
                                <div class="control has-icons-left">
                                    <input class="input is-large" type="email" name="username" placeholder="Enter Email">
                                    <span class="icon is-small is-left">
						     	 		<i class="fa fa-envelope"></i>
						    		</span>
                                </div>
                            </div>

                            <div class="field">
                                <div class="control has-icons-left">
                                    <input class="input is-large" type="password" name="password" placeholder="Enter Password" >
                                    <span class="icon is-small is-left">
						     	 		<i class="fa fa-lock"></i>
						    		</span>
                                </div>
                            </div>
            				<div class="field column">
            					<div class="control has-text-centered">
            						<div class="g-recaptcha" data-sitekey="6LfKBXUUAAAAAMl0uRqth8Oahyq89TV1axRVQbRa"></div>
            					</div>
            				</div>
           					<div class="field">
		           				<div class="control has-text-centered">
		                       		<button class="button is-success is-medium" type="submit">Login</button>
	                            
	                        		<a class="button is-info is-medium" href="register">Register</a>
								</div>
							</div>
                        </form>
                    </div>
                    <p class="has-text-grey">
                        <a href="../">Forgot Password</a>
                    </p>
                </div>
            </div>
        </div>
    </section>
    <script async type="text/javascript" src="../js/bulma.js"></script>
</body>	
</html>