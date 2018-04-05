<%@ page contentType="text/html; charset=utf-8" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- global variables settings -->
<c:set var="webapp_name" value="/acp"/>

<!-- page variables  -->
<c:set var="inc_dir" value="../inc"/>
<!-- ENDS page variables -->

<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.4
Version: 3.8.1
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>Athensoft | Event - News Edit</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/uniform/css/uniform.default.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/fancybox/source/jquery.fancybox.css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/css/components.css" id="style_components"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/css/plugins.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/admin/layout2/css/layout.css"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/admin/layout2/css/themes/grey.css" id="style_color"/>
<link rel="stylesheet" type="text/css" href="${webapp_name}/assets/admin/layout2/css/custom.css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>

<!-- CSS local -->
<style type="text/css">

table{
	table-layout:fixed
}

table tr td{
	word-wrap:break-all; 
	/* overflow:hidden; */
	
	text-overflow: ellipsis;  
  	overflow: hidden;  
  	white-space: nowrap;
}

</style>

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-boxed page-header-fixed page-container-bg-solid page-sidebar-closed-hide-logo ">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner container">
		<!-- BEGIN LOGO -->
			<jsp:include page="${inc_dir}/page-logo.jsp"></jsp:include>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN PAGE ACTIONS -->
		<!-- DOC: Remove "hide" class to enable the page header actions -->
		<div class="page-actions">
			<div class="btn-group ">
				<button type="button" class="btn btn-circle red-pink dropdown-toggle" data-toggle="dropdown">
				<i class="icon-bar-chart"></i>&nbsp;<span class="hidden-sm hidden-xs">New&nbsp;</span>&nbsp;<i class="fa fa-angle-down"></i>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li>
						<a href="javascript:;">
						<i class="icon-user"></i> New User </a>
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-present"></i> New Event <span class="badge badge-success">4</span>
						</a>
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-basket"></i> New order </a>
					</li>
					<li class="divider">
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-flag"></i> Pending Orders <span class="badge badge-danger">4</span>
						</a>
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-users"></i> Pending Users <span class="badge badge-warning">12</span>
						</a>
					</li>
				</ul>
			</div>
			<div class="btn-group hide">
				<button type="button" class="btn btn-circle green-haze dropdown-toggle" data-toggle="dropdown">
				<i class="icon-bell"></i>&nbsp;<span class="hidden-sm hidden-xs">Post&nbsp;</span>&nbsp;<i class="fa fa-angle-down"></i>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li>
						<a href="javascript:;">
						<i class="icon-docs"></i> New Post </a>
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-tag"></i> New Comment </a>
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-share"></i> Share </a>
					</li>
					<li class="divider">
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-flag"></i> Comments <span class="badge badge-success">4</span>
						</a>
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-users"></i> Feedbacks <span class="badge badge-danger">2</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- END PAGE ACTIONS -->
		<!-- BEGIN PAGE TOP -->
			<jsp:include page="${inc_dir}/page-top.jsp"></jsp:include>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<div class="container">
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
			<jsp:include page="${inc_dir}/page-sidebar.jsp"></jsp:include>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">
								 Widget settings form goes here
							</div>
							<div class="modal-footer">
								<button type="button" class="btn blue" onclick="updateNews(); return false;">Save changes</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<!-- BEGIN STYLE CUSTOMIZER -->
				<jsp:include page="${inc_dir}/page-stylecustomizer.jsp"/>
				<!-- END STYLE CUSTOMIZER -->
				<!-- BEGIN PAGE HEADER-->
				<h3 class="page-title">
				Event System <small> manage news</small>
				</h3>
				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="#">Home</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="eventsDashboard">Events</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">News</a>
						</li>
					</ul>
					<div class="page-toolbar">
						<div class="btn-group pull-right">
							<button type="button" class="btn btn-fit-height grey-salt dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true">
							Actions <i class="fa fa-angle-down"></i>
							</button>
							<ul class="dropdown-menu pull-right" role="menu">
								<li>
									<a href="#">Action</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">Separated link</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row">
					<div class="col-md-12">
						<form class="form-horizontal form-row-seperated" action="#">
							<div class="portlet light">
								<div class="portlet-title">
									<div class="caption">
										<i class="icon-basket font-green-sharp"></i>
										<span class="caption-subject font-green-sharp bold uppercase">
										Edit News </span>
										<span class="caption-helper">editing news details, associated medias, reviews, etc.</span>
									</div>
									<div class="actions btn-set">
										<button type="button" name="back" class="btn btn-default btn-circle" onclick="backToNewsList(); return false;"><i class="fa fa-angle-left"></i> Back</button>
										<button type="button" name="reset" class="btn btn-default btn-circle" onclick="resetNews(); return false;"><i class="fa fa-reply"></i> Reset</button>
										<button class="btn green-haze btn-circle" onclick="updateNews(); return false;"><i class="fa fa-check"></i> Save Change</button>
										<button class="btn green-haze btn-circle" onclick="updateNewsAndContinue(); return false;"><i class="fa fa-check-circle"></i> Save &amp; Continue Edit</button>
										<div class="btn-group">
											<a class="btn yellow btn-circle" href="javascript:;" data-toggle="dropdown">
											<i class="fa fa-share"></i> More <i class="fa fa-angle-down"></i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li>
													<a href="javascript:;">
													Duplicate </a>
												</li>
												<li>
													<a href="javascript:;"  onclick="markNewsStatusDeleted('${newsObject.eventUUID}'); return false;">
													Mark Deleted </a>
												</li>
												<li class="divider">
												</li>
												<li>
													<a href="javascript:;">
													Print </a>
												</li>
											</ul>
										</div>
									</div>
								</div>
								<div class="portlet-body">
									<div class="tabbable" id="tabs_event">
										<ul class="nav nav-tabs">
											<li class="active">
												<a href="#tab_general" data-toggle="tab">
												General </a>
											</li>
											<li>
												<a href="#tab_meta" data-toggle="tab">
												Meta </a>
											</li>
											<li>
												<a href="#tab_images" data-toggle="tab">
												Images </a>
											</li>
											<li>
												<a href="#tab_reviews" data-toggle="tab">
												Reviews <span class="badge badge-success">
												3 </span>
												</a>
											</li>
											<li>
												<a href="#tab_history" data-toggle="tab">
												History </a>
											</li>
										</ul>
										<div class="tab-content no-space">
											<div class="tab-pane active" id="tab_general">
												<div class="form-body">
													<div class="form-group">
														<label class="col-md-2 control-label">Global ID: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="globalId" name="globalId" placeholder="" disabled="disabled"  value="${newsObject.globalId}">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Event UUID: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="eventUUID" name="eventUUID"  placeholder="" value="${newsObject.eventUUID}" disabled="disabled">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Event Title: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="title" name="title" placeholder=""  value="${newsObject.title}">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Author: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="author" name="author" placeholder=""  value="${newsObject.author}">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Post Datetime: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<div class="input-group input-large date-picker input-daterange" data-date="10/11/2012" data-date-format="mm/dd/yyyy">
																<input type="text" class="form-control" id="postDatetime" name="postDatetime"  value="${newsObject.postDatetime}" disabled="disabled">
															</div>
															<span class="help-block">
															availability daterange. </span>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Number of Views: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="viewNum" name="viewNum" placeholder=""  value="${newsObject.viewNum}" disabled="disabled">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Short Description: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<textarea class="form-control" id="descShort" name="descShort">${newsObject.descShort}</textarea>
															<span class="help-block">
															shown in product listing </span>
														</div>
														
													</div>
													
															<div class="form-group">
														<label class="col-md-2 control-label">Long Description: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<textarea class="form-control" id="descLong" name="descLong" rows="6">${newsObject.descLong}</textarea>
														</div>
														
													</div>
													
													<div class="form-group">
														<label class="col-md-2 control-label">News Class: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<select class="table-group-action-input form-control input-medium" id="eventClass"  name="eventClass">
																<option value="0">Select...</option>
																<option value="1">Default</option>
																<option value="2">New</option>
																<option value="3">Hot</option>
															</select>
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-md-2 control-label">News Status: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<select class="table-group-action-input form-control input-medium" id="eventStatus" name="eventStatus">
																<option value="0">Select...</option>
																<option value="1">Published</option>
																<option value="2">Wait to post</option>
																<option value="3">Deleted</option>
																<option value="4">Out of date</option>
																<option value="5">Suspended</option>
															</select>
														</div>
													</div>
												</div>
											</div>
											<div class="tab-pane" id="tab_meta">
												<div class="form-body">
													<div class="form-group">
														<label class="col-md-2 control-label">Meta Title:</label>
														<div class="col-md-10">
															<input type="text" class="form-control maxlength-handler" name="product[meta_title]" maxlength="100" placeholder="">
															<span class="help-block">
															max 100 chars </span>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Meta Keywords:</label>
														<div class="col-md-10">
															<textarea class="form-control maxlength-handler" rows="8" name="product[meta_keywords]" maxlength="1000"></textarea>
															<span class="help-block">
															max 1000 chars </span>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Meta Description:</label>
														<div class="col-md-10">
															<textarea class="form-control maxlength-handler" rows="8" name="product[meta_description]" maxlength="255"></textarea>
															<span class="help-block">
															max 255 chars </span>
														</div>
													</div>
												</div>
											</div>
											<div class="tab-pane" id="tab_images">
												<div class="alert alert-success margin-bottom-10">
													<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
													<i class="fa fa-warning fa-lg"></i> Image type and information need to be specified.
												</div>
												<div id="tab_images_uploader_container" class="text-align-reverse margin-bottom-10">
													<a id="tab_images_uploader_pickfiles" href="javascript:;" class="btn yellow">
													<i class="fa fa-plus"></i> Select Files </a>
													<a id="tab_images_uploader_uploadfiles" href="javascript:;" class="btn green">
													<i class="fa fa-share"></i> Upload Files </a>
												</div>
												<div class="row">
													<div id="tab_images_uploader_filelist" class="col-md-6 col-sm-12">
													</div>
												</div>
												
												<div id="event-media-table">
												
												<table class="table table-bordered table-hover">
												<thead>
												<tr role="row" class="heading">
													<th width="8%">
														 Image
													</th>
													<th width="20%">
														 Label
													</th>
													<th width="8%">
														 Sort Number
													</th>
													<th width="15%">
														 Post Time
													</th>
													<th width="10%">
														 Primary Media
													</th>
													<th width="10%">
														Action
													</th>
												</tr>
												</thead>
												<tbody>
												
												<c:forEach items="${eventMediaList}" var="eventMedia">
													<tr>
													<td>
														<a href="/eventmedia/${eventMedia.mediaURL}${eventMedia.mediaName}" class="fancybox-button" data-rel="fancybox-button">
														<img class="img-responsive" src="/eventmedia/${eventMedia.mediaURL}${eventMedia.mediaName}" alt="">
														</a>
													</td>
													<td>
														<input type="text" class="form-control" name="mediaLabel" value="${eventMedia.mediaLabel}" onblur="changeMediaLabel(this,${eventMedia.mediaId},'${eventMedia.eventUUID}');">
													</td>
													<td>
														<input type="text" class="form-control" name="sortNumber" value="${eventMedia.sortNumber}" onblur="changeSortNumber(this,${eventMedia.mediaId},'${eventMedia.eventUUID}');">
													</td>
													
													<td>
														<input type="text" class="form-control" name="postTimestamp" value="${eventMedia.postTimestamp}">
													</td>
													<td>
														<input type="text" class="form-control" name="primaryMedia" value="${eventMedia.primaryMedia}" disabled="disabled">
														<div>
														<a href="javascript:;" onclick="setCoverMedia(${eventMedia.mediaId},'${eventMedia.eventUUID}');return false;" class="btn default btn-sm">
														<i class="fa fa-edit"></i> Set Cover </a>
														</div>
													</td>
													<td>
														<a href="javascript:test();" class="btn default btn-sm">
														<i class="fa fa-times"></i> Remove </a>
													</td>
												</tr>
												</c:forEach>
												
												
												</tbody>
												</table>
												</div>
											</div>
											<div class="tab-pane" id="tab_reviews">
												<div class="table-container">
													<table class="table table-striped table-bordered table-hover" id="datatable_reviews">
													<thead>
													<tr role="row" class="heading">
														<th width="5%">
															 Review&nbsp;#
														</th>
														<th width="10%">
															 Review&nbsp;Date
														</th>
														<th width="10%">
															 Customer
														</th>
														<th width="20%">
															 Review&nbsp;Content
														</th>
														<th width="10%">
															 Status
														</th>
														<th width="10%">
															 Actions
														</th>
													</tr>
													<tr role="row" class="filter">
														<td>
															<input type="text" class="form-control form-filter input-sm" name="event_review_no" id="event_review_no">
														</td>
														<td>
															<div class="input-group date date-picker margin-bottom-5" data-date-format="yyyy-mm-dd">
																<input type="text" class="form-control form-filter input-sm" readonly name="event_review_date_from" placeholder="From" id="event_review_date_from">
																<span class="input-group-btn">
																<button class="btn btn-sm default" type="button"><i class="fa fa-calendar"></i></button>
																</span>
															</div>
															<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
																<input type="text" class="form-control form-filter input-sm" readonly name="event_review_date_to" placeholder="To" id="event_review_date_to">
																<span class="input-group-btn">
																<button class="btn btn-sm default" type="button"><i class="fa fa-calendar"></i></button>
																</span>
															</div>
														</td>
														<td>
															<input type="text" class="form-control form-filter input-sm" name="event_review_customer" id="event_review_customer">
														</td>
														<td>
															<input type="text" class="form-control form-filter input-sm" name="event_review_content" id="event_review_content">
														</td>
														<td>
															<select name="event_review_status" class="form-control form-filter input-sm" id="event_review_status">
																<option value="0">Select...</option>
																<option value="1">Approved</option>
																<option value="2">Pending</option>
																<option value="3">Rejected</option>
															</select>
														</td>
														<td>
															<div class="margin-bottom-5">
																<button class="btn btn-sm yellow filter-submit margin-bottom" onclick="filterSearchReview();"><i class="fa fa-search"></i> Search</button>
															</div>
															<button class="btn btn-sm red filter-cancel"><i class="fa fa-times"></i> Reset</button>
														</td>
													</tr>
													</thead>
													<tbody>
													</tbody>
													</table>
												</div>
											</div>
											<div class="tab-pane" id="tab_history">
												<div class="table-container">
													<table class="table table-striped table-bordered table-hover" id="datatable_history">
													<thead>
													<tr role="row" class="heading">
														<th width="25%">
															 Datetime
														</th>
														<th width="55%">
															 Description
														</th>
														<th width="10%">
															 Notification
														</th>
														<th width="10%">
															 Actions
														</th>
													</tr>
													<tr role="row" class="filter">
														<td>
															<div class="input-group date datetime-picker margin-bottom-5" data-date-format="dd/mm/yyyy hh:ii">
																<input type="text" class="form-control form-filter input-sm" readonly name="product_history_date_from" placeholder="From">
																<span class="input-group-btn">
																<button class="btn btn-sm default date-set" type="button"><i class="fa fa-calendar"></i></button>
																</span>
															</div>
															<div class="input-group date datetime-picker" data-date-format="dd/mm/yyyy hh:ii">
																<input type="text" class="form-control form-filter input-sm" readonly name="product_history_date_to" placeholder="To">
																<span class="input-group-btn">
																<button class="btn btn-sm default date-set" type="button"><i class="fa fa-calendar"></i></button>
																</span>
															</div>
														</td>
														<td>
															<input type="text" class="form-control form-filter input-sm" name="product_history_desc" placeholder="To"/>
														</td>
														<td>
															<select name="product_history_notification" class="form-control form-filter input-sm">
																<option value="">Select...</option>
																<option value="pending">Pending</option>
																<option value="notified">Notified</option>
																<option value="failed">Failed</option>
															</select>
														</td>
														<td>
															<div class="margin-bottom-5">
																<button class="btn btn-sm yellow filter-submit margin-bottom"><i class="fa fa-search"></i> Search</button>
															</div>
															<button class="btn btn-sm red filter-cancel"><i class="fa fa-times"></i> Reset</button>
														</td>
													</tr>
													</thead>
													<tbody>
													</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
		</div>
		<!-- END CONTENT -->
		<!-- BEGIN QUICK SIDEBAR -->
		<!--Cooming Soon...-->
		<!-- END QUICK SIDEBAR -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
		<jsp:include page="${inc_dir}/page-footer.jsp"></jsp:include>
	<!-- END FOOTER -->
</div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${webapp_name}/assets/global/plugins/respond.min.js"></script>
<script src="${webapp_name}/assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/jquery.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/jquery-migrate.min.js"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/jquery.blockui.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/jquery.cokie.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/plugins/plupload/js/plupload.full.min.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="${webapp_name}/assets/global/scripts/metronic.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/admin/layout2/scripts/layout.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/admin/layout2/scripts/demo.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/global/scripts/datatable.js"></script>

<script type="text/javascript" src="${webapp_name}/assets/admin/pages/scripts-local/event-news.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/admin/pages/scripts-local/event-news-edit.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->

<script>
	jQuery(document).ready(function() {    
	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	Demo.init(); // init demo features
	//EventNewsEdit.init();
	var eventUUID = $("#eventUUID").val();
	EventNewsEdit.init(eventUUID);

//local
//select object for event class
	var eventClassValue = ${newsObject.eventClass};
	$("#eventClass").val(eventClassValue);

//select object for event status
	var eventStatusValue = ${newsObject.eventStatus};
	$("#eventStatus").val(eventStatusValue);
	
});

function resetNews(){
	
	//alert("resetNews");
	
	//object for reset
	//var p1 = ${newsObject.globalId};
	//var p2 = '${newsObject.eventUUID}';
	var p3 = '${newsObject.title}';
	var p4 = '${newsObject.author}';
	//var p5 = ${newsObject.postDatetime};
	var p6 = ${newsObject.viewNum};
	var p7 = '${newsObject.descShort}';
	var p8 = '${newsObject.descLong}';
	var p9 = ${newsObject.eventClass};
	var p10 = ${newsObject.eventStatus};
	
	//$("#globalId").val(p1);
	//$("#eventUUID").val(p2);
	$("#title").val(p3);
	$("#author").val(p4);
	//$("#postDatetime").val(p5);
	$("#viewNum").val(p6);
	$("#descShort").val(p7);
	$("#descLong").val(p8);
	$("#eventClass").val(p9);
	$("#eventStatus").val(p10);
}
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
