<%-- 
    Document   : index
    Created on : 26 Oct, 2023, 8:44:32 PM
    Author     : somna
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="java.util.Base64"%>
<%@page import="java.sql.Blob"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Course | Home :: w3layouts</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Educational Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free web designs for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--// Meta tag Keywords -->
<!-- css files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<!-- //css files -->
<!-- online-fonts -->
<link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&subset=latin-ext" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Covered+By+Your+Grace" rel="stylesheet">
<!-- //online-fonts -->
</head>
<body>
    
     <%!
            String vname,vemail;
            %>
        <%
            HttpSession sess = request.getSession(false);
            
            
try
{
            if(sess!=null) {
                vname = sess.getAttribute("fname").toString();
                vemail = sess.getAttribute("email").toString();    
            }
}
catch(Exception ex)
{
                %>
                <script>
                    alert("Session was not created!!!");
                    alert("Redirecting for logging==>>");
                    location.href="http://localhost:8080/OC/login.html";
                </script>
                <%  
}
            %> 
            <span style="align-content: flex-end">
            Welcome <%=vname%> .
          
        </span>

<div class="main-w3layouts" id="home">
	<!--top-bar-->
	<div class="top-search-bar">
		<div class="header-top-nav">
			<ul>
                            
                            <li><a href="admin/admin.html"><i class="fa fa-key" aria-hidden="true"></i>Admin Login</a></li>
                             <li><a href="UserProfile.jsp"><i class="fa fa-envelope" aria-hidden="true"></i><%=vname%></a></li>
                               
				<li><a href="login.html" ><i class="fa fa-key" aria-hidden="true"></i>LOGOUT</a></li>
			
			</ul>
		</div>
	</div>
	
	<!-- Modal3 login name-->
		
	<!-- //Modal3 -->

	<!-- Modal4 -->
		<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" >
			<div class="modal-dialog" role="document">
			<!-- Modal content-->
				<div class="modal-content news-w3l">
						<div class="modal-header">
							<button type="button" class="close w3l" data-dismiss="modal">&times;</button>
							<h4>Register Now</h4>
							<div class="login-main wthree">
							  <form action="http://localhost:8080/OC/register" method="post">
								<div class="form-group">
								  <label for="name">Name:</label>
								  <input type="text" class="form-control" id="name" name="SNAME">
								</div>
								<div class="form-group">
								  <label for="email">Email:</label>
								  <input type="email" class="form-control" id="email" name="SEMAIL">
								</div>
								<div class="form-group">
								  <label>Gender:</label>
								  <div class="radio">
									<label class="radio-inline">
									  <input type="radio" name="SGEN" value="male"> Male
									</label>
									<label class="radio-inline">
									  <input type="radio" name="SGEN" value="female"> Female
									</label>
									<label class="radio-inline">
									  <input type="radio" name="SGEN" value="other"> Other
									</label>
								  </div>
								</div>
								<div class="form-group">
								  <label for="SPHONE">Phone Number (+91):</label>
								  
								  <input type="text" class="form-control" id="phoneNumber" name="SPHONE">
								</div>
								<div class="form-group">
								  <label for="add">Address:</label>
								  <input type="text" class="form-control" id="add" name="SADD">
								</div>
								<div class="form-group">
								  <label for="Password">Password:</label>
								  <input type="password" class="form-control" id="Password" name="Password">
								</div>
								
								<button type="submit" class="btn btn-primary col-md-5">Register Now</button>
							  </form>
							</div>
						<!--//newsletter-->			
						</div>
					</div>
				</div>
			 </div>
			<div class="clearfix"></div>
	<!-- //Modal4-->
				<div class="search">
						<form action="#" method="post">
							<input type="search" placeholder="Search Here..." required="" />
							<input type="submit" value=" ">
						</form>
				</div>
					<div class="clearfix"></div>
	<!--//top-bar-->
	<!-- navigation -->
			<div class ="top-nav">
				<nav class="navbar navbar-default">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							
						</div>
						<!-- navbar-header -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="index.html" class="hvr-underline-from-center active">Home</a></li>
								<li><a href="#about" class="hvr-underline-from-center scroll">About Us</a></li>
								<li><a href="#services" class="hvr-underline-from-center scroll">Courses</a></li>
							        <li><a href="#contact" class="hvr-underline-from-center scroll">Contact Us</a></li>
							</ul>
						</div>
						<div class="clearfix"> </div>	
				</nav>
			</div>
	<!-- //navigation -->

	<div class="header">
		<!-- Slider -->
			<div class="slider">
				<div class="callbacks_container">
					<ul class="rslides" id="slider">
						<li>
						
							<div class="slider-info">
								<p>wisdom begins with wonder.</p>
								<h3><a href="index.html"><span>Edu</span> cational</a></h3>
								<h6>wisdom begins with wonder.</h6>
							</div>
						</li>
						<li>
						
							<div class="slider-info">
								<p>Education is a vaccine for violence.</p>
								<h3><a href="index.html"><span>Edu</span> cational</a></h3>
								<h6>wisdom begins with wonder.</h6>
							</div>
						</li>
						<li>
						
							<div class="slider-info">
								<p>wisdom begins with wonder.</p>
								<h3><a href="index.html"><span>Edu</span> cational</a></h3>
								<h6>wisdom begins with wonder.</h6>
							</div>
						</li>
						<li>
						
							<div class="slider-info">
								<p>Learning never exhausts the mind.</p>
								<h3><a href="index.html"><span>Edu</span> cational</a></h3>
								<h6>wisdom begins with wonder.</h6>
							</div>
						</li>
							
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		<!-- //Slider -->
	</div>
</div>
<!--main-content-->

<!--about-->
<div id="about" class="about">
	<div class="container">
			<h1>About <span>us</span></h1>
			<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ut enim ad tempor incididunt ut labore et dolore magna aliqua.</h2>
			<div class="specialty-grids-top">
				<div class="col-md-4 service-box" style="visibility: visible; animation-delay: 0.4s;">
					<figure class="icon">
						<span class="glyphicon glyphicon-education a1" aria-hidden="true"></span>
					</figure>
					<h5>Awesome Education</h5>
					<p>Sed ut perspiciis iste natus error sit voluptatem accusantium doloremque laudantium elerisque ipsum vehicula pharetra.</p>
				</div>
				<div class="col-md-4 service-box wow bounceIn animated" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s;">
					<figure class="icon">
						<span class="glyphicon glyphicon-home a2" aria-hidden="true"></span>
					</figure>
					<h5>Awesome classes</h5>
					<p>Sed ut perspiciis iste natus error sit voluptatem accusantium doloremque laudantium elerisque ipsum vehicula pharetra.</p>
				</div>
				<div class="col-md-4 service-box wow bounceIn animated" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s;">
					<figure class="icon">
						 <span class="glyphicon glyphicon-leaf a3" aria-hidden="true"></span>						
					</figure>
					<h5>Awesome Teachings</h5>
					<p>Sed ut perspiciis iste natus error sit voluptatem accusantium doloremque laudantium elerisque ipsum vehicula pharetra.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="buttons">
				<div class="button">
					<h5><a href="#contact" class="scroll" id="Contact">Contact with us</a></h5>
				</div>
				
			</div>
			<!-- Modal1 -->
			
				<!-- //Modal1 -->
				<div class="clearfix"></div>
			</div>
	</div>
	<div class="about-info">
		<img src="images/ab.jpg" alt="about-image">
		<div class="right-agile">
			<h5>Educational</h5>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
			<h5>Educational</h5>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam. </p>
		</div>
	</div>
	<div class="clearfix"></div>
<!--//about-->
 <%!

        // STEP 3: DECLARING OBJECTS AND VARIABLES
            OracleConnection oconn;
            OraclePreparedStatement ops;
            OracleResultSet ors;
            OracleResultSetMetaData orsmd;
            int counter, reccounter, colcounter;
        %>
        <%
            // STEP 4: REGISTRATION OF ORACLE DRIVER
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
            // STEP 5: INSTANTIATING TH             E CONNECTION
            oconn = 
                    (OracleConnection)
                    DriverManager.getConnection
        ("jdbc:oracle:thin:@Asus_ROG_G15:1521:orcl","TIITA","DATABASE");
            
            // STEP 6: INSTANTIATING THE STATEMENT OBJECT
            ops = (OraclePreparedStatement)oconn.prepareCall("SELECT * FROM courses where C_id>=10001");
//            ops.setString(1, vemail);
            
            // STEP 7: FILLING UP THE DATABASE RECORDS IN A TEMPORARY CONTAINER
            ors = (OracleResultSet)ops.executeQuery();
            
            // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
            orsmd = (OracleResultSetMetaData)ors.getMetaData();
            %>
<!-- services -->
 <!-- courses -->
 
        <div class="services" id="services">
            <h3>Courses</h3>
              <%
                    // STEP 10: BRINGING ALL THE RECORDS AND DISPLAYING AS TABLE ROWS
                    while(ors.next() == true)
                    {
                    %>
             
            <div class="col-md-2 services-gd text-center" data-wow-delay=".5s">
              
                <div class="hi-icon-wrap hi-icon-effect-9 hi-icon-effect-9a">
                    <a href="course.jsp" class="hi-icon"><% //to show the image
                        Blob imageBlob = ors.getBlob("IMAGE");
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        out.write("<img style='width:60px;height:80px'src=\"data:images/jpeg;base64," + new String(Base64.getEncoder().encode(imageBytes)) + "\">");
                        %></a>
                </div>
                <h4><a href="course.jsp"><%=ors.getString(2)%></a></h4>


            </div>
                <%
              }
            %>
                  
        </div>
            


<!-- Portfolio Modals -->
<div class="portfolio-modal modal fade slideanim" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl"></div>
            </div>
        </div>
        <div class="container">
		
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h3>Educational</h3>
						
                        <img src="images/g1.jpg" class="img-responsive" alt="">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                </div>
           
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade slideanim" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl"></div>
            </div>
        </div>
        <div class="container">
         
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h3>Educational</h3>
                      
                        <img src="images/g2.jpg" class="img-responsive" alt="">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                </div>
           
        </div>
    </div>
    </div>
<div class="portfolio-modal modal fade slideanim" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl"></div>
            </div>
        </div>
        <div class="container">
           
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h3>Educational</h3>
                     
                        <img src="images/g3.jpg" class="img-responsive" alt="">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                </div>
            </div>
       
    </div>
</div>
<div class="portfolio-modal modal fade slideanim" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl"></div>
            </div>
        </div>
        <div class="container">
			
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h3>Educational</h3>
                       
                        <img src="images/g4.jpg" class="img-responsive" alt="">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                </div>
            
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade slideanim" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl"></div>
            </div>
        </div>
        <div class="container">

                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h3>Educational</h3>
                       
                        <img src="images/g5.jpg" class="img-responsive" alt="">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                </div>
           
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade slideanim" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl"></div>
            </div>
        </div>
        <div class="container">
           
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h3>Educational</h3>
                       
                        <img src="images/g6.jpg" class="img-responsive" alt="">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                </div>
            </div>
        
    </div>
</div>
<div class="portfolio-modal modal fade slideanim" id="portfolioModal7" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl"></div>
            </div>
        </div>
        <div class="container">
            
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h3>Educational</h3>
                     
                        <img src="images/g7.jpg" class="img-responsive" alt="">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                </div>
         
        </div>
    </div>
</div>
<!-- /Portfolio Modals -->
<!-- //gallery -->



<!--test-->
	<div id="testimonials" class="review">
		<div class="container">
		<h3 class="title-w3">Testimonials</h3>
				<div class="test-monials">
				<!--//screen-gallery-->
						<div class="sreen-gallery-cursual">
							
						       <div id="owl-demo" class="owl-carousel">
					                 <div class="item-owl">
					                	<div class="test-review">
										<p><img src="images/left-quote.png" alt="">Lorem ipsum dolor sit ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.<img src="images/right-quote.png" alt=""></p>
											<div class="img-agile">
												<img src="images/t1.jpg" class="img-responsive" alt=""/>
											</div>
											  <h5>James</h5>
					                	    </div>
					                </div>
					                 <div class="item-owl">
					                	<div class="test-review">
										 <p> <img src="images/left-quote.png" alt="">Lorem ipsum dolor sit ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.<img src="images/right-quote.png" alt=""></p>
						                	<div class="img-agile">
											<img src="images/t2.jpg" class="img-responsive" alt=""/>
											</div>
											<h5>Williams Allen</h5>
					                	</div>
					                </div>
					                 <div class="item-owl">
					                	<div class="test-review">
										     <p><img src="images/left-quote.png" alt="">Lorem ipsum dolor sit ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.<img src="images/right-quote.png" alt=""></p>
						                	<div class="img-agile">
											<img src="images/t3.jpg" class="img-responsive" alt=""/>
											</div>
											<h5>Richard</h5>
					                	</div>
					                </div>
				              </div>
						<!--//screen-gallery-->
					</div>
				</div>
			</div>
		</div>
<!--//test-->

<!--contact-->
	<div class="map">
		<h4>Find us On google Map</h4>
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3684.2181481358016!2d88.43295287384967!3d22.57094293303382!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a0275be8320d919%3A0xe663ed60dae7dd4e!2sTechno%20India%20Institute%20of%20Technology!5e0!3m2!1sen!2sin!4v1700194816789!5m2!1sen!2sin" style="border:0" allowfullscreen></iframe>
	</div>
	<div class="contact-agile" id="contact">
		<h3>Contact <span>Us</span></h3>
			<div class="container">
						
				<form action="http://localhost:8080/OC/Contact" method="post" class="wow fadeInLeft animated" data-wow-delay=".5s">
					<div class="contact-grids1 agileinfo">
						<div class="contact-me ">
							<h4>Message</h4>
							<textarea name="Message" placeholder="" required=""> </textarea>
						</div>
						<div class="col-md-5 contact-form1">
							<h4>Name</h4>
							<input type="text" name="Name" placeholder="" required="">
						</div>
						<div class="col-md-5 contact-form1">
							<h4>Email</h4>
							<input type="email" name="Email" placeholder="" required="">
						</div>
						<div class="col-md-2 contact-form">
							<input type="submit" value="Submit">
						</div>
						<div class="clearfix"> </div>
					
					</div>
				</form>
						
			</div>
	</div>
<!--//contact-->

<!-- footer -->
	<div class="footer" id="footer">
		<div class="container">
			<div class="col-md-4 agileinfo_footer_grid">
				<h4>About Us</h4>
				<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu 
					fugiat nulla pariatur. <span>Excepteur sint occaecat cupidatat non proident 
					sunt in culpa qui officia deserunt mollit anim id est laborum.</span></p>
			</div>
			<div class="col-md-4 agileinfo_footer_grid mid-w3l nav2">
				<h4>Options</h4>
				<ul>
					<li><a href="#home" class="scroll">Home</a></li>
					<li><a href="#about" class="scroll">About Us</a></li>
					<li><a href="#services" class="scroll">Course</a></li>
					<li><a href="#gallery" class="scroll">Gallery</a></li>
				
					<li><a href="#testimonials" class="scroll">Testimonials</a></li>
				</ul>
			</div>
			<div class="col-md-4 agileinfo_footer_grid">
				<h4>Address</h4>
				<ul>
					<li><span class="glyphicon glyphicon-home" aria-hidden="true"></span>TIIT,Sector-v</li>
					<li><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span><a href="onlinecourse473@gmail.com">onlinecourse473@gmail.com</a></li>
					<li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>+917319554070</li>
				</ul>
			</div>
			
			<div class="clearfix"> </div>
			<div class="w3agile_footer_copy">
				<p>© 2013 Educational. All rights reserved TIIT| Design by <a href="http://w3layouts.com/">W3layouts.</a></p>
			</div>
		</div>
	</div>
<!-- //footer -->

<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>


<script src="js/jquery.chocolat.js"></script>
		<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen">
		<!--light-box-files -->
		<script>
		$(function() {
			$('.gallery-grid a').Chocolat();
		});
		</script>
 <!-- required-js-files-->
		
							<link href="css/owl.carousel.css" rel="stylesheet">
							    <script src="js/owl.carousel.js"></script>
							        <script>
							    $(document).ready(function() {
							      $("#owl-demo").owlCarousel({
							        items : 1,
							        lazyLoad : true,
							        autoPlay : true,
							        navigation : false,
							        navigationText :  false,
							        pagination : true,
							      });
							    });
							    </script>
								 <!--//required-js-files-->

<script src="js/responsiveslides.min.js"></script>
		<script>
				$(function () {
					$("#slider").responsiveSlides({
						auto: true,
						pager:false,
						nav: true,
						speed: 1000,
						namespace: "callbacks",
						before: function () {
							$('.events').append("<li>before event fired.</li>");
						},
						after: function () {
							$('.events').append("<li>after event fired.</li>");
						}
					});
				});
			</script>
			

<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->

	<!-- bottom-top -->
	<!-- smooth scrolling -->
		<script type="text/javascript">
			$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/								
			$().UItoTop({ easingType: 'easeOutQuart' });
			});
		</script>
		<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	<!-- //smooth scrolling -->
	<!--// bottom-top -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>

</body>
</html>