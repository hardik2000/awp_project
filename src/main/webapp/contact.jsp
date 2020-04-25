<%-- 
    Document   : contact
    Created on : 25 Apr, 2020, 4:36:39 PM
    Author     : HARDIK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Contact</title>
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
    <link rel="stylesheet" type="text/css" href="styles/contact.css">
    <link rel="stylesheet" type="text/css" href="styles/contact_responsive.css">
    </head>
    <body>
        <jsp:include page="/header.jsp"/>

        
        <!-- Home -->

	<div class="home">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/contact.jpg" data-speed="0.8"></div>
		<div class="home_container d-flex flex-column align-items-center justify-content-center">
			<div class="home_title"><h1>Contact</h1></div>
		</div>
	</div>

	<!-- Booking -->

	<div class="booking">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="booking_container d-flex flex-row align-items-end justify-content-start">
						<form action="#" class="booking_form">
							<div class="booking_form_container d-flex flex-lg-row flex-column align-items-start justify-content-start flex-wrap">
								<div class="booking_form_inputs d-flex flex-row align-items-start justify-content-between flex-wrap">
									<div class="booking_dropdown"><input type="text" class="datepicker booking_input booking_input_a booking_in" placeholder="Check in" required="required"></div>
									<div class="booking_dropdown"><input type="text" class="datepicker booking_input booking_input_a booking_out" placeholder="Check out" required="required"></div>
									<div class="custom-select">
										<select>
											<option value="0">Adults</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>
									</div>
									<div class="custom-select">
										<select>
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
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Contact -->

	<div class="contact">
		<div class="contact_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="section_title text-center">
							<div>Ciao</div>
							<h1>Say Hello</h1>
						</div>
						<div class="contact_text text-center">
							<p>Maecenas sollicitudin tincidunt maximus. Morbi tempus malesuada erat sed pellentesque. Donec pharetra mattis nulla, id laoreet neque scelerisque at. Quisque eget sem non ligula consectetur ultrices in quis augue. Donec imperd iet leo eget tortor dictum, eget varius eros sagittis.</p>
						</div>
						<div class="contact_form_container">
							<form action="#" class="contact_form text-center">
								<div class="row">
									<div class="col-lg-6">
										<input type="text" class="contact_input" placeholder="Your name" required="required">
									</div>
									<div class="col-lg-6">
										<input type="email" class="contact_input" placeholder="Your email" required="required">
									</div>
								</div>
								<input type="text" class="contact_input" placeholder="Subject">
								<textarea class="contact_input" placeholder="Message" required="required"></textarea>
								<button class="contact_button">send message</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Map -->
		<div class="contact_map_container">
			<div class="map">
				<div id="google_map" class="google_map">
					<div class="map_container">
						<div id="map"></div>
					</div>
				</div>
			</div>

			<!-- Contact Map Content -->
			<div class="contact_map_content">
				<div class="d-flex flex-column align-items-center justify-content-center">
					<img class="contact_info_logo_1" src="images/logo_4.png" alt="">
					<img class="contact_info_logo_2" src="images/logo_2.png" alt="">
					<div class="contact_info_list">
						<ul class="text-center">
							<li>VNIT NAGPUR MAHARASTRA</li>
							<li>coder@gmail.com</li>
							<li>XXX-XXX-XXXX</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
        
        
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
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCIwF204lFZg1y4kPSIhKaHEXMLYxxuMhA"></script>
    <script src="js/contact.js"></script>
</body>
</html>
