<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div id="carousel-example-generic" class="carousel slide"
	data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-slide-to="0"
			class="active"></li>
		<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		<li data-target="#carousel-example-generic" data-slide-to="3"></li>
		<li data-target="#carousel-example-generic" data-slide-to="4"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="/SummaryTask4/style/image/carousel_image_01.jpg" alt="...">
			<div class="carousel-caption">
				<mytag:message key="carousel.slide_first" />
			</div>
		</div>
		<div class="item">
			<img src="/SummaryTask4/style/image/carousel_image_02.jpg" alt="...">
			<div class="carousel-caption">
				<mytag:message key="carousel.slide_second" />
			</div>
		</div>
		<div class="item">
			<img src="/SummaryTask4/style/image/carousel_image_03.jpg" alt="...">
			<div class="carousel-caption">
				<mytag:message key="carousel.slide_third" />
			</div>
		</div>
		<div class="item">
			<img src="/SummaryTask4/style/image/carousel_image_04.jpg" alt="...">
			<div class="carousel-caption">
				<mytag:message key="carousel.slide_fourth" />
			</div>
		</div>
		<div class="item">
			<img src="/SummaryTask4/style/image/carousel_image_05.jpg" alt="...">
			<div class="carousel-caption">
				<mytag:message key="carousel.slide_fifth" />
			</div>
		</div>
	</div>
</div>

<!-- Controls -->
<a class="left carousel-control" href="#carousel-example-generic"
	role="button" data-slide="prev"> <span
	class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
	class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#carousel-example-generic"
	role="button" data-slide="next"> <span
	class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
	class="sr-only">Next</span>
</a>