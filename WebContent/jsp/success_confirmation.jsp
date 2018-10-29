
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sarapion</title>
        <link rel="shortcut icon" href="../images/fav_icon.png" type="image/x-icon">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">        
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <!-- Bulma Version 0.7.1-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css" />
        <link rel="stylesheet" type="text/css" href="css/hero.css">
        <link rel="stylesheet" href="https://unpkg.com/bulma-modal-fx/dist/css/modal-fx.min.css" />
        
    </head>
    <body>
        <section class="hero is-info is-medium is-bold">
            <div class="hero-body">
                <div class="container has-text-centered">
                    <h1 class="title is-size-1">
                    Sarapion
                    </h1>
                    <h2 class="subtitle">
                    	Success!
                    </h2>
                </div>
            </div>
        </section>
        <div class="box cta">
            
        </div>
        <section class="container">
        		<div class="container box has-text has-text-centered">
        			
        			<h3 class="is-bold is-size-3">Successfully Registered</h3>
        			<p class=""><i class="far fa-check-square 7x"></i>&nbsp;An email has been sent to <%= request.getAttribute("email") %>. Please check your email to verify and confirm.</p>
        			<br>
        			<a class="button is-info is-medium" href="${pageContext.request.contextPath}/login">Login</a>
        		</div>
            <br>
            
        </section>
        <footer class="footer">
            <div class="container">
                <div class="">
                    <div class=" is-half">
                        <h2><strong>Contributers</strong></h2>
                        <ul>
                            <li>Mohamed Abdi 100-649-804</li>
                            <li>Kevin Ly 101-082-639</li>
                            <li>ZhiRun Yulu 101-065-994</li>
                            <li>Carol Hung 101-019-479</li>
                        </ul>
                    </div>
                    
                </div>
            
            </div>
            <script src="../js/bulma.js"></script>
        </footer>
    </body>

</html>