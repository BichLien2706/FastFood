
<!DOCTYPE html>
<html>

<head>
	<script src="<c:url value=" /ckeditor/ckeditor.js" />"></script>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Edit User</title>
	<!-- BOOTSTRAP STYLES-->
	<link href="./css/bootstrap.css" rel="stylesheet" />
	<!-- FONTAWESOME STYLES-->
	<link href="./css/font-awesome.css" rel="stylesheet" />
	<!-- CUSTOM STYLES-->
	<link href="./css/custom.css" rel="stylesheet" />
	<!-- GOOGLE FONTS-->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<link href='./css/fontawesome-free-6.0.0-beta3-web/css/all.min.css' rel='stylesheet' type='text/css'>
</head>

<body>
	<div id="wrapper">

		<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="./admin">Dashboard</a>
			</div>
			<div style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				Welcome ${username } &nbsp; <a href="./logout"
					class="btn btn-danger square-btn-adjust">Logout</a>
			</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img src="./img/find_user.png" class="user-image img-responsive" />
					</li>


					<li><a class="active-menu" href="#"><i class="fa fa-dashboard fa-3x"></i> Dashboard</a></li>
					<li><a href="list-product.html"><i
								class="fa fa-desktop fa-3x"></i>
							Product Management</a></li>
					<li><a href="list-user.html"><i class="fa fa-qrcode fa-3x"></i>
							USER Management</a></li>
					<li><a href="list-order.html"><i
								class="fa fa-bar-chart-o fa-3x"></i> Order Management</a></li>
					<li><a href="table.html"><i class="fa fa-table fa-3x"></i>
							Table Examples</a></li>
					<li><a href="form.html"><i class="fa fa-edit fa-3x"></i>
							Forms </a></li>


					<li><a href="#"><i class="fa fa-sitemap fa-3x"></i>
							Multi-Level Dropdown<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#">Second Level Link</a></li>
							<li><a href="#">Second Level Link</a></li>
							<li><a href="#">Second Level Link<span class="fa arrow"></span></a>
								<ul class="nav nav-third-level">
									<li><a href="#">Third Level Link</a></li>
									<li><a href="#">Third Level Link</a></li>
									<li><a href="#">Third Level Link</a></li>

								</ul>
							</li>
						</ul>
					</li>
					<li><a href="blank.html"><i class="fa fa-square-o fa-3x"></i>
							Blank Page</a></li>
				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Add Product</h2>
						<h5>Add product you can sell</h5>
					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">Add Product</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<h3>User:</h3>
										<c:url value="/admin/product/edit" var="edit"></c:url>
										<form role="form" action="${edit }" method="post" enctype="multipart/form-data">
											<input name="id" value="${product.id }" hidden="">
											<div class="form-group">
												<label>Name:</label> <input class="form-control"
													value="${product.name }" name="name" />
											</div>
											<div class="form-group">
												<label>Price ($)</label> <input class="form-control"
													value="${product.price }" type="number" name="price" />
											</div>
											<div class="form-group">
												<label>Description </label> <br>
												<textarea rows="4" cols="50" name="des"
													id="editer">${product.des }</textarea>
											</div>

											<div class="form-group">
												<label>Category</label>
												<div class="checkbox">
													<select name="cate">
														<c:forEach items="${categories}" var="c">
															<option value="${c.name}">${c.name}</option>
														</c:forEach>
													</select>
												</div>

											</div>
											<div class="form-group">
												<label>image</label> <input type="file" name="image"
													value="${product.image }" />
											</div>
											<button type="submit" class="btn btn-default">Edit</button>
											<button type="reset" class="btn btn-primary">Reset</button>
										</form>


									</div>
								</div>
							</div>
						</div>
						<!-- End Form Elements -->
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-12"></div>
				</div>
				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="./js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="./js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="./js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="./js/custom.js"></script>
	<script type="text/javascript" language="javascript">
		CKEDITOR.replace('editer', { width: '700px', height: '300px' });
	</script>
</body>

</html>