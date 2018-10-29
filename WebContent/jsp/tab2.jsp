
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
            <div class="hero-head">
                <nav class="navbar">
                    <div class="container">
                        <div class="navbar-brand">
                            <a class="navbar-item" href="${pageContext.request.contextPath}/dashboard">
                                Sarapion
                            </a>
                            <span class="navbar-burger burger" data-target="navbarMenu">
                                <span>tab1</span>
                                <span>tab2</span>
                                <span>tab3</span>
                            </span>
                        </div>
                        <div id="navbarMenu" class="navbar-menu">
                            <div class="navbar-start">
                                <div class="tabs is-right">
                                    <ul>
                                        <li><a href="../jsp/tab1.jsp">Tab1</a></li>
                                        <li class="is-active"><a href="../jsp/tab2.jsp">Tab2</a></li>
                                        <li><a href="../jsp/tab3.jsp">Tab3</a></li>
                                        <li><a href="../jsp/tab4.jsp">Tab4</a></li>
                                    </ul>
                                    
                                </div>
                            </div>
                      
                                <div class="navbar-end"><br>
                                <p class="navbar-item has-text">Welcome,<br>  <span class="has-text-left has-text-weight-semibold"><%= session.getAttribute("firstName") %></span></p>
	                                <form method="post" action="${pageContext.request.contextPath}/logout">
		                            		<span class="navbar-item">
		                					<button class="button is-info is-inverted is-outlined" type="submit"><i class="fas fa-sign-out-alt"></i>Logout</button>

		                                </span>
		                            </form>
	                            </div>       
                        </div>
                    </div>
                </nav>
            </div>
            <div class="hero-body">
                <div class="container has-text-centered">
                    <h1 class="title is-size-1">
                    Sarapion
                    </h1>
                    <h2 class="subtitle">
                    	Future Enhancement 2
                    </h2>
                </div>
            </div>
        </section>
        <div class="box cta">
            
        </div>
        <section class="container">
            <div class="container">
            		<img src="../images/underconstruction.png" alt="under construction image">
            </div>
            
        </section>
        <footer class="footer">
            <div class="container">
                <div class="columns">
                    <div class="column is-half">
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