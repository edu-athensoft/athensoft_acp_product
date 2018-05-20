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
Z
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
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <head>
        <meta charset="utf-8" />
        <title>Athensoft |</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #2 for edit product" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="${webapp_name}/assets/global/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/pages/css/wind.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="${webapp_name}/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="${webapp_name}/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="${webapp_name}/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="${webapp_name}/assets/layouts/layout2/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/layouts/layout2/css/themes/blue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="${webapp_name}/assets/layouts/layout2/css/custom.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="favicon.ico" /> </head>
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
                    <h1 class="page-title"><spring:message code="itemSystem"/> <small><spring:message code="manage"/><spring:message code="products"/></small></h1>
                    <div class="page-bar">
                        <ul class="page-breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="#"><spring:message code="home"/></a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="itemDashboard"><spring:message code="item"/></a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#"><spring:message code="Product"/></a>
						</li>
					</ul>
                        <div class="page-toolbar">
                            <div class="btn-group pull-right">
                                <button type="button" class="btn btn-fit-height grey-salt dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true"> Actions
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
                            <form class="form-horizontal form-row-seperated" action="#">
                                <div class="portlet">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="fa fa-shopping-cart"></i><spring:message code="edit"/><spring:message code="Product"/><span class="caption-helper"> editing Product description, status, type etc.</span> </div>
                                        <div class="actions btn-set">
                                            <button type="button" name="back" class="btn btn-secondary-outline" onclick="backToProductList(); return false;">
                                                <i class="fa fa-angle-left"></i> <spring:message code="back"/></button>
                                            <button class="btn btn-secondary-outline"  type="reset" >
                                                <i class="fa fa-reply"></i> <spring:message code="reset"/></button>
                                            <button class="btn btn-success" type="button" onclick="updateProduct(); return false;">
                                                <i class="fa fa-check"></i> <spring:message code="save"/></button>
                                            <button class="btn btn-success" onclick="updateProductAndContinue(); return false;" >
                                                <i class="fa fa-check-circle"></i> <spring:message code="save"/> &amp;<spring:message code="continueEdit"/></button>
                                            <div class="btn-group">
                                                <a class="btn btn-success dropdown-toggle" href="javascript:;" data-toggle="dropdown">
                                                    <i class="fa fa-share"></i><spring:message code="more"/>

                                                    <i class="fa fa-angle-down"></i>
                                                </a>
                                                <div class="dropdown-menu pull-right">
                                                	<ul>
                                                    <li>
                                                        <a href="javascript:;"> <spring:message code="duplicate"/> </a>
                                                    </li>
                                                   	<li>
														<a href="javascript:;"  onclick="markNewsStatusDeleted('${newsObject.eventUUID}'); return false;">
														Mark Deleted </a>
													</li>
                                                    <li class="dropdown-divider"> </li>
                                                    <li>
                                                        <a href="javascript:;">  <spring:message code="print"/>  </a>
                                                    </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="tabbable-bordered" id="tabs_event">
                                           
                                            <div class="tab-content" >
                                                <div class="tab-pane active" id="tab_general">
                                                    <div class="form-body">
                                                     <div class="form-group">
														<label class="col-md-2 control-label">  <spring:message code="Category"/>: <span class="required">
														* </span>
														</label>
														
														
						<!--                         <div class="col-md-6"> -->
						                                
						                                    <div id="tree_3" class="tree-demo"> </div>
						<!--                              </div> -->
													</div>
                                                    
                                                    
                                                    
													<div class="form-group">
														<label class="col-md-2 control-label"><spring:message code="BusinessID"/>: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
														<input type="hidden" class="form-control" id="prodId" name="prod_id" placeholder="" disabled="disabled"  value="${productObject.prodId}">
															<input type="text" class="form-control" id="bizId" name="biz_id" placeholder="" disabled="disabled"  value="${productObject.prodBizId}">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label"><spring:message code="SequenceNumber"/>: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" name="prod_seq_no" id="prodSeqNo"  placeholder="" value="${productObject.prodSeqNo}" disabled="disabled">
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-md-2 control-label"><spring:message code="ProductName"/>: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="prodName" name="prodName" placeholder=""  value="${productObject.itemProductI18n.prodName}">
														</div>
													</div>
													<div class="form-group">
													     <label for="name"  class="col-md-2 control-label"><spring:message code="image"/></label>
													           <div class="col-sm-8">
													       <%--     ${productObject.prodImgUrl == '' ? '${webapp_name}/assets/pages/img/upload_img.png' :'"${productObject.productImg}"' } --%>
													                <img id="productImg" class="cover-radius"  src="${productObject.prodImgUrl }"
													                           width="500px" style="cursor: pointer; float:left" />
													                <input id="picture_upload" name="file" type="file" onchange="upload_cover(this)"
													                           style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; opacity: 0; cursor: pointer;"/>
													                <small class="help-block cover-tips" style="color: #dd4b39;display: none;">请上传图片</small>
													           </div>
													 </div>
														<div class="form-group">
														<label class="col-md-2 control-label"><spring:message code="ProductNameAlias"/>: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="prodNameAlias" name="prodNameAlias" placeholder=""  value="${productObject.itemProductI18n.prodNameAlias}">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label"><spring:message code="ProductType"/>: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<select class="table-group-action-input form-control input-medium" id="prodType" name="prod_type">
																<option value="0" ${productObject.prodType == '0' ? 'selected' : ''}><spring:message code="Select"/></option>
																<option value="1" ${productObject.prodType == '1' ? 'selected' : ''}><spring:message code="Product"/></option>
																<option value="2" ${productObject.prodType == '2' ? 'selected' : ''}><spring:message code="Digital"/></option>
																<option value="3" ${productObject.prodType == '3' ? 'selected' : ''}><spring:message code="Service"/></option>
															</select>
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-md-2 control-label">Product Status: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<select class="table-group-action-input form-control input-medium" id="prodStatus" name="prod_status">
																<option value="0" ${productObject.prodStatus == '0' ? 'selected' : ''}><spring:message code="Select"/></option>
																<option value="1" ${productObject.prodStatus == '1' ? 'selected' : ''}><spring:message code="newCreated"/></option>
																<option value="2" ${productObject.prodStatus == '2' ? 'selected' : ''}><spring:message code="Published"/></option>
																<option value="3" ${productObject.prodStatus == '3' ? 'selected' : ''}><spring:message code="Unpublished"/></option>
																<option value="4" ${productObject.prodStatus == '4' ? 'selected' : ''}><spring:message code="Deleted"/></option>
															</select>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Product Sale Type: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<select class="table-group-action-input form-control input-medium" id="prodSaleType" name="prod_sale_type">
																<option value="0" ${productObject.prodSaleType == '0' ? 'selected' : ''}><spring:message code="Select"/></option>
																<option value="1" ${productObject.prodSaleType == '1' ? 'selected' : ''}><spring:message code="online"/></option>
																<option value="2" ${productObject.prodSaleType == '2' ? 'selected' : ''}><spring:message code="outlet"/></option>
																<option value="3" ${productObject.prodSaleType == '3' ? 'selected' : ''}><spring:message code="both"/></option>
															</select>
														</div>
													</div>
													
													
													<div class="form-group">
														<label class="col-md-2 control-label"><spring:message code="ShortDescription"/>: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<textarea class="form-control" id="prodDesc" name="prodDesc">${productObject.itemProductI18n.prodDesc}</textarea>
															<span class="help-block">
														<!--	shown in product listing --></span>
														</div>
														
													</div>
													
															<div class="form-group">
														<label class="col-md-2 control-label"><spring:message code="LongDescription"/>: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<textarea class="form-control" id="prodDescLong" name="prodDescLong" rows="6">${productObject.itemProductI18n.prodDescLong}</textarea>
														</div>
														
													</div>
													
													
													
												
													<div class="form-group">
														<label class="col-md-2 control-label"><spring:message code="LongDescription"/>: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<div class="input-group input-large date-picker input-daterange" data-date="10/11/2012" data-date-format="mm/dd/yyyy hh:mm:ss">
																<input type="text" class="form-control" id="createDatetime" name="createDatetime"  value="${productObject.prodCreaterDatetime}" disabled="disabled">
															</div>
															<span class="help-block">
															availability daterange. </span>
														</div>
													</div>
												</div>
                                                </div>
                                                
                                                
                                                
                                                
                                               
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- END CONTENT BODY -->
            </div>
            <!-- END CONTENT -->
            <!-- BEGIN QUICK SIDEBAR -->
            <!-- Removed to quick_sidebar.html -->
            <!-- END QUICK SIDEBAR -->
        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->
        <jsp:include page="${inc_dir}/page-footer.jsp"></jsp:include>
        <!-- END FOOTER -->
        <!-- BEGIN QUICK NAV -->
        
        <!-- END QUICK NAV -->
<!--[if lt IE 9]>
<script src="${webapp_name}/assets/global/plugins/respond.min.js"></script>
<script src="${webapp_name}/assets/global/plugins/excanvas.min.js"></script> 
<script src="${webapp_name}/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<!-- <script src="${webapp_name}/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script> -->
<script src="${webapp_name}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${webapp_name}/assets/global/scripts/datatable.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/plupload/js/plupload.full.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<script>
var initLoc = "${loc}";
//alert(initLoc);
</script>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts/ajaxfileupload.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/item-product.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/item-product-list.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/item-product-list-edit.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="${webapp_name}/assets/global/scripts/app.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/scripts/app.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/pages/scripts-local/jstree.js" type="text/javascript"></script>            
<script src="${webapp_name}/assets/pages/scripts-local/ui-tree-no-edit.js" type="text/javascript"></script>       
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="${webapp_name}/assets/layouts/layout2/scripts/layout.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/layouts/layout2/scripts/demo.min.js" type="text/javascript"></script>
<!-- 
<script src="${webapp_name}/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
 -->
<!-- END THEME LAYOUT SCRIPTS -->
<script>

	var prodBizId = $("#bizId").val();
	productEdit.init(prodBizId);
	var productStatus = ${productObject.prodStatus};
	$("#prodStatus").val(productStatus);
	
var categoryCode ="${productObject.categoryCode}";
$("#selectLang").val(initLoc);

</script>
</body>

</html>