<%@ page contentType="text/html; charset=utf-8" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>

<!-- global variables settings -->
<c:set var="webapp_name" value="/acp"/>

<!-- page variables  -->
<c:set var="inc_dir" value="../inc"/>


<c:set var="loc" value="en_US"/>
<c:if test="${!(empty param.lang)}" >
  <c:set var="loc" value="${param.lang}"/>
</c:if>
<fmt:setLocale value="${loc}" />
<!-- ENDS page variables -->

<!DOCTYPE html> 
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.7
Version: 4.7.5
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html >
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <meta charset="utf-8" />
        <title>Athensoft | Item - Product Listing</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta content="" name="description" />
        <meta content="" name="author" />
        
        <meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
        
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" />
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/datatables/datatables.min.css"/>
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css"/>
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/plugins/fancybox/source/jquery.fancybox.css"/>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/css/components.min.css" id="style_components"/>
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/global/css/plugins.min.css"/>
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/layouts/layout2/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/layouts/layout2/css/themes/blue.min.css"id="style_color" />
        <link rel="stylesheet" type="text/css" href="${webapp_name}/assets/layouts/layout2/css/custom.min.css"/>
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="${webapp_name}/assets/global/plugins/datatables/media/images/favicon.ico"/>
    </head>
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid">
        <!-- BEGIN HEADER -->
        <div class="page-header navbar navbar-fixed-top">
            <!-- BEGIN HEADER INNER -->
            <div class="page-header-inner ">
                <!-- BEGIN LOGO -->
                <jsp:include page="${inc_dir}/page-logo.jsp"></jsp:include>
                <!-- END LOGO -->
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
                <!-- END RESPONSIVE MENU TOGGLER -->
                <!-- BEGIN PAGE ACTIONS -->
                <!-- DOC: Remove "hide" class to enable the page header actions -->
                <jsp:include page="${inc_dir}/page-action.jsp"></jsp:include>
                <!-- END PAGE ACTIONS -->
                <!-- BEGIN PAGE TOP -->
                <jsp:include page="${inc_dir}/page-top.jsp"></jsp:include>
                <!-- END PAGE TOP -->
            </div>
            <!-- END HEADER INNER -->
        </div>
        <!-- END HEADER -->
        <!-- BEGIN HEADER & CONTENT DIVIDER -->
        <div class="clearfix"> </div>
        <!-- END HEADER & CONTENT DIVIDER -->
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <!-- BEGIN SIDEBAR -->
            <jsp:include page="${inc_dir}/page-sidebar.jsp"></jsp:include>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="page-content-wrapper">
                <!-- BEGIN CONTENT BODY -->
                <div class="page-content">
                    <!-- BEGIN PAGE HEADER-->
                    <!-- BEGIN THEME PANEL -->
                    <jsp:include page="${inc_dir}/theme-panel.jsp"></jsp:include>
                    <!-- END THEME PANEL -->
                    <h1 class="page-title"><spring:message code="itemSystem"/><small><spring:message code="manage"/><spring:message code="products"/></small></h1>
                    <div class="page-bar">
                        <ul class="page-breadcrumb">
							<li>
								<i class="fa fa-home"></i>
								<a href="#"><spring:message code="home"/></a>
								<i class="fa fa-angle-right"></i>
							</li>
							<li>
								<a href="itemDashBoard"><spring:message code="item"/></a>
								<i class="fa fa-angle-right"></i>
							</li>
							<li>
								<a href="#"><spring:message code="Product"/></a>
							</li>
						</ul>
                        <div class="page-toolbar">
                            <div class="btn-group pull-right">
                                <button type="button" class="btn btn-fit-height grey-salt dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true"> <spring:message code="Actions"/>
                                    <i class="fa fa-angle-down"></i>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu">
                                    <li><a href="#"><i class="icon-bell"></i> <spring:message code="manage"/></a></li>
                                    <li><a href="#"><i class="icon-shield"></i> <spring:message code="manage"/></a></li>
                                    <li><a href="#"><i class="icon-user"></i> <spring:message code="manage"/></a></li>
                                    <li class="divider"> </li>
                                    <li><a href="#"><i class="icon-bag"></i> <spring:message code="manage"/></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- END PAGE HEADER-->
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Begin: life time stats -->
                            <div class="portlet light">
                                <div class="portlet-title">
                                    <div class="caption">
                                        <i class="fa fa-shopping-cart"></i><spring:message code="Product"/><spring:message code="Listing"/> <span class="caption-helper"><spring:message code="titel"/> </span></div>
                                    <div class="actions">
                                        <a href="itemProductCreate?lang=${loc }" class="btn btn-circle btn-info">
                                            <i class="fa fa-plus"></i><span class="hidden-xs"> <spring:message code="Create"/> <spring:message code="Product"/> </span>
                                        </a>
                                        <div class="btn-group">
                                            <a class="btn btn-circle btn-default dropdown-toggle" href="javascript:;" data-toggle="dropdown">
                                                <i class="fa fa-share"></i>
                                                <span class="hidden-xs"> <spring:message code="Tools"/>  </span>
                                                <i class="fa fa-angle-down"></i>
                                            </a>
                                            <ul class="dropdown-menu pull-right">
                                                <li><a href="exportProductExcel"><spring:message code="Export"/>  Excel </a></li>
                                                <li><a href="javascript:;"> <spring:message code="Export"/>  CSV </a></li>
                                                <li><a href="javascript:;"><spring:message code="Export"/> XML </a></li>
                                                <li class="divider"></li>
                                                <li><a href="javascript:;"> <spring:message code="PrintInvoice"/>  </a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="portlet-body">
                                    <div class="table-container">
                                        <div class="table-actions-wrapper">
                                            <span> </span>
                                            <select class="table-group-action-input form-control input-inline input-small input-sm" name="groupOption">
                                                <option value=""><spring:message code="Select"/> </option>
												<option value="1"><spring:message code="Publish"/> </option>
												<option value="2"><spring:message code="Waittopost"/> </option>
												<option value="3"><spring:message code="Delete"/> </option>
												<option value="4"><spring:message code="OutOfDate"/> </option>
												<option value="5"><spring:message code="Suspend"/> </option>
                                            </select>
                                            <button class="btn btn-sm yellow table-group-action-submit"><i class="fa fa-check"></i> <spring:message code="Submit"/> </button>
                                        </div>
                                        <table class="table table-striped table-bordered table-hover table-checkable" id="datatable_productList">
                                            <thead>
                                                <tr role="row" class="heading">
                                                    <th width="1%">
                                                        <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
                                                            <!-- <input type="checkbox" class="group-checkable" data-set="#sample_2 .checkboxes" />  -->
                                                            <input type="checkbox" class="group-checkable">
                                                            <span></span>
                                                        </label>
                                                    </th>
								        <!--                                             
										String field0 = "";	//check box
										String field1 = "";	//product biz id
										String field2 = "";	//product sequence no
										String field3 = "";	//prodcut type
										String field4 = "";	//product Sale Type
										String field5 = "";	//post datetime
										String field6 = "";	//view num
										String field7 = "";	//event status
										String field8 = "";	//action -->
                                                    <th width="8%"><spring:message code="ID"/> </th>
													<th width="10%"><spring:message code="SequenceNumber"/> </th>
													<th width="10%"><spring:message code="ProductType"/> </th>
													<th width="10%"><spring:message code="ProductSaleType"/> </th>
													<th width="15%"><spring:message code="ProductName"/> </th>
													<th width="15%"><spring:message code="CategoryName"/> </th>
													<th width="18%"><spring:message code="CreatedDate"/> </th>
													<th width="8%"><spring:message code="Status"/> </th>
													<th width="14%"><spring:message code="Actions"/> </th>
                                                </tr>
                                                <tr role="row" class="filter">
													<td><input type="hidden" class="form-control form-filter input-sm" name="prodId" id="prodId"></td>
													<td><input type="text" class="form-control form-filter input-sm" name="prodBizId" id="prodBizId"></td>
													<td><input type="text" class="form-control form-filter input-sm" name="prodSeqNo" id="prodSeqNo"></td>
													<td>
													<select class="form-control form-filter input-sm" name="prodType" id="prodType">
															<option value="0"><spring:message code="Select"/></option>
															<option value="1"><spring:message code="Product"/></option>
															<option value="2"><spring:message code="Digital"/></option>
															<option value="3"><spring:message code="Service"/></option>
														</select>
													
													</td>
													<td>
														<select class="form-control form-filter input-sm" name="prodSaleType" id="prodSaleType">
															<option value="0"><spring:message code="Select"/></option>
															<option value="1"><spring:message code="online"/></option>
															<option value="2"><spring:message code="outlet"/></option>
															<option value="3"><spring:message code="both"/></option>
														</select>
													</td>
													<td>
														
														
														<input type="text" class="form-control form-filter input-sm" name="prodName" placeholder="search" id="prodName"/>
													</td>
													
													<td>
														
														
														<input type="text" class="form-control form-filter input-sm" name="categoryName" placeholder="search" id="categoryName"/>
													</td>
													<td>
													<div class="input-group date date-picker margin-bottom-5" data-date-format="yyyy-mm-dd">
															<input type="text" class="form-control form-filter input-sm" readonly name="prodCreaterDatetime" placeholder="From" id="createDatetimeFrom">
															<span class="input-group-btn">
															<button class="btn btn-sm default" type="button"><i class="fa fa-calendar"></i></button>
															</span>
														</div>								
													<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
															<input type="text" class="form-control form-filter input-sm" readonly name="prodCreaterDatetime" placeholder="To" id="createDatetimeTo">
															<span class="input-group-btn">
															<button class="btn btn-sm default" type="button"><i class="fa fa-calendar"></i></button>
															</span>
														</div>
														
													</td>
													<td>
														<select class="form-control form-filter input-sm" name="prodStatus" id="prodStatus">
															<option value="0">Select...</option>
															<option value="1">New</option>
															<option value="2">Published</option>
															<option value="3">Unpublished</option>
															<option value="4">Deleted</option>
														</select>
													</td>
													<td>
														<div class="margin-bottom-5">
														<button class="btn btn-sm yellow filter-submit1 margin-bottom" onclick="filterSearch();"><i class="fa fa-search"></i> Search</button>
														</div>
														<button class="btn btn-sm red filter-cancel1" onclick="filterReset();"><i class="fa fa-times"></i> Reset</button>
													</td>
												</tr>
                                            </thead>
                                            <tbody> </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- End: life time stats -->
                        </div>
                    </div>
                </div>
                <!-- END CONTENT BODY -->
            </div>
            <!-- END CONTENT -->
            <!-- BEGIN ${webapp_name} SIDEBAR -->
            <!-- Removed to quick_sidebar.html -->
            <!-- END QUICK SIDEBAR -->
        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->
        <jsp:include page="${inc_dir}/page-footer.jsp"></jsp:include>
        <!-- END FOOTER -->
            
<!--[if lt IE 9]>
<script src="${webapp_name}/assets/global/plugins/respond.min.js"></script>
<script src="${webapp_name}/assets/global/plugins/excanvas.min.js"></script> 
<script src="${webapp_name}/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<script src="${webapp_name}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script>
var initLoc = "${loc}";
</script>
<script src="${webapp_name}/assets/global/scripts/datatable.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<!-- <script src="${webapp_name}/assets/global/scripts/app.min.js" type="text/javascript"></script> -->
<script src="${webapp_name}/assets/global/scripts/app.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/item-product.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/global-validate.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/item-product-list.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="${webapp_name}/assets/layouts/layout2/scripts/layout.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/layouts/layout2/scripts/demo.min.js" type="text/javascript"></script>

<!-- 
<script type="text/javascript" src="${webapp_name}/assets/layouts/global/scripts/quick-sidebar.min.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/layouts/global/scripts/quick-nav.min.js"></script>
 -->
<!-- END THEME LAYOUT SCRIPTS -->
<script>
productList.init();
//$("#menu-myevents").addClass("selected");
//alert("page just loaded in "+initLoc);

$("#selectLang").val(initLoc);

</script>
</body>

</html>