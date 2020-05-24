<%-- 
    Document   : rooms
    Created on : 25 Apr, 2020, 4:28:56 PM
    Author     : HARDIK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Rooms</title>
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
<link rel="stylesheet" type="text/css" href="styles/rooms.css">
<link rel="stylesheet" type="text/css" href="styles/rooms_responsive.css">
</head>
<body>


	
    <jsp:include page="/header.jsp"/>
    
        <!-- Home -->

	<div class="home">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/rooms.jpg" data-speed="0.8"></div>
		<div class="home_container d-flex flex-column align-items-center justify-content-center">
			<div class="home_title"><h1>Rooms</h1></div>
		</div>
	</div>
	<!-- Booking -->
        <form action="Process_Rooms" method="Post" class="booking_form">
	<div class="booking">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="booking_container d-flex flex-row align-items-end justify-content-start">
							<div class="booking_form_container d-flex flex-lg-row flex-column align-items-start justify-content-start flex-wrap">
								<div class="booking_form_inputs d-flex flex-row align-items-start justify-content-between flex-wrap">
									<div class="booking_dropdown"><input type="text" class="datepicker booking_input booking_input_a booking_in" placeholder="Check in" required="required" name="check_in"></div>
									<div class="booking_dropdown"><input type="text" class="datepicker booking_input booking_input_a booking_out" placeholder="Check out" required="required" name="check_out"></div>
									<div class="custom-select">
										<select name="number_adults">
											<option value="0">Adults</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>
									</div>
									<div class="custom-select">
										<select name="number_children">
											<option value="0">Children</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>
									</div>
								</div>
								<button class="booking_form_button ml-lg-auto">book now</button>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Rooms -->
	<div class="rooms">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card-columns">
						
						<!-- Room -->
						<div class="card">
							<img class="card-img-top" src="images/room_1.jpg">
							<div class="card-body">
								<div class="rooms_title"><h2>Luxury Double Suite</h2></div>
								<div class="rooms_text">
									<p>Maecenas sollicitudin tincidunt maximus. Morbi tempus malesuada erat sed pellentesque. Donec pharetra mattis nulla, id laoreet neque scelerisque at. Quisque eget sem non ligula consectetur ultrices in quis augue. Donec imperd iet leo eget tortor dictum, eget varius eros sagittis. Curabitur tempor dignissim massa ut faucibus sollicitudin tinci dunt maximus. Morbi tempus malesuada erat sed pellentesque.</p>
								</div>
								<div class="rooms_list">
									<ul>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Morbi tempus malesuada erat sed</span>
										</li>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Tempus malesuada erat sed</span>
										</li>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Pellentesque vel neque finibus elit</span>
										</li>
									</ul>
								</div>
								<div class="rooms_price">$129/<span>Night</span></div>
                                                                <button type="submit" name="room_1" class="btn btn-success">Book Now</button>
							</div>
						</div>

						

						<!-- Room -->
						<div class="card">
							<img class="card-img-top" src="images/room_3.jpg" alt="Room image description">
							<div class="card-body">
								<div class="rooms_title"><h2>Luxury Single Room</h2></div>
								<div class="rooms_text">
									<p>Maecenas sollicitudin tincidunt maximus. Morbi tempus malesuada erat sed pellentesque. Donec pharetra mattis nulla, id laoreet neque scelerisque at.</p>
								</div>
								<div class="rooms_list">
									<ul>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Morbi tempus malesuada erat sed</span>
										</li>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Tempus malesuada erat sed</span>
										</li>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Pellentesque vel neque finibus elit</span>
										</li>
									</ul>
								</div>
								<div class="rooms_price">$129/<span>Night</span></div>
                                                                <button type="submit" name="room_2" class="btn btn-success">Book Now</button>
							</div>
						</div>

						<!-- Room -->
						<div class="card card-special">
							<img class="card-img-top" src="images/room_4.jpg" alt="Room image description">
							<div class="card-special-panel">special offer</div>
							<div class="card-body">
								<div class="rooms_title"><h2>Budget Suite</h2></div>
								<div class="rooms_text">
									<p>Maecenas sollicitudin tincidunt maximus. Morbi tempus malesuada erat sed pellentesque. Donec pharetra mattis nulla, id laoreet neque scelerisque at.</p>
								</div>
								<div class="rooms_list">
									<ul>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Morbi tempus malesuada erat sed</span>
										</li>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Tempus malesuada erat sed</span>
										</li>
										<li class="d-flex flex-row align-items-center justify-content-start">
											<img src="images/check.png" alt="">
											<span>Pellentesque vel neque finibus elit</span>
										</li>
									</ul>
								</div>
								<div class="rooms_price">$129/<span>Night</span></div>
                                                                <button type="submit" name="room_3" class="btn btn-success">Book Now</button>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>		
	</div>
    </form>
        <jsp:include page="/footer.jsp"/>



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
<script src="js/rooms.js"></script>
</body>
</html>