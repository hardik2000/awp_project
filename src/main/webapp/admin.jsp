<%-- 
    Document   : index
    Created on : 25 Apr, 2020, 3:58:32 PM
    Author     : HARDIK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="database.*"%>
<%@ page import="domain.*"%>
<%@ page import="java.util.ArrayList"%>
<%! 
    getRoom room = new getRoom();
    getRecord record = new getRecord();
    ArrayList<Room> rooomlist;
    String status,cust;
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Marimar</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Marimar Hotel template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/animate.css">
<link href="plugins/jquery-datepicker/jquery-ui.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>
    body {
        background-color: #eee;
    }

    *[role="form"] {
        max-width: 530px;
        padding: 15px;
        margin: 0 auto;
        background-color: #fff;
        border-radius: 0.3em;
    }

    *[role="form"] h2 {
        margin-left: 5em;
        margin-bottom: 1em;
    }
</style>
</head>
<body>

<div class="super_container">
	
    <jsp:include page="/header.jsp"/>
    

	<div class="home">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/rooms.jpg" data-speed="0.8"></div>
		<div class="home_container d-flex flex-column align-items-center justify-content-center">
			<div class="home_title"><h1>Admin</h1></div>
		</div>
	</div>
        
	<!-- Intro -->
        <div class="container-fluid row">
            <div class="col-1"></div>
            <div class="col-7">
                <h3>Rooms :</h3>
                <table class="table table-bordered table-striped table-hover">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col">Room_no</th>
                        <th scope="col">Type</th>
                        <th scope="col">Price</th>
                        <th scope="col">Status</th>
                        <th scope="col">Customer</th>
                      </tr>
                    </thead>
                    <tbody>
                        <%
                            rooomlist = room.getAllRooms();
                            for(Room r:rooomlist)
                            {
                                if(r.isBooked())
                                {
                                    status="Booked";
                                    cust=record.getCutomer(r.getRoom_no());
                                }
                                else 
                                {
                                    status="Empty";
                                    cust="-";   
                                }
                        %>
                      <tr>
                          <th scope="row"><%= r.getRoom_no() %></th>
                          <th scope="row"><%= r.getType()%></th>
                          <th scope="row"><%= r.getPrice()%></th>
                          <th scope="row"><%= status%></th>
                          <th scope="row"><%= cust%></th>

                      </tr>
                      <%}%>
                    </tbody>
                </table>
            </div> <!-- ./container -->
            <div class="col">
                <h3>Room Prices :</h3>
                <form action="updatePrice.html" method="POST">
                <div class="form-group row">
                  <label class="col-sm-5 col-form-label">Budget Suite :</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" name="Budget_Suite" value="<%= room.getPriceOfType("Budget Suite") %>">
                  </div>
                </div>
                <div class="form-group row">
                  <label class="col-sm-5 col-form-label">Luxury Single Room :</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" name="Luxury_Single_Room" value="<%= room.getPriceOfType("Luxury Single Room") %>">
                  </div>
                </div>
                <div class="form-group row">
                  <label class="col-sm-5 col-form-label">Luxury Double Suite :</label>
                  <div class="col-sm-3">
                      <input type="text" class="form-control" name="Luxury_Double_Suite" value="<%= room.getPriceOfType("Luxury Double Suite") %>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-2">
                      <button type="submit" class="btn btn-primary btn-lg" value="submit">Update</button>
                  </div>
                </div>
              </form>
            </div>
        </div>
        <jsp:include page="/footer.jsp"/>

</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="styles/bootstrap-4.1.2/popper.js"></script>
<script src="styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/progressbar/progressbar.min.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/jquery-datepicker/jquery-ui.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
