/** item_product_list.jsp */

/* list product - init */
var productList = function () {

    var initPickers = function () {
        //init date pickers
        $('.date-picker').datepicker({
//            rtl: Metronic.isRTL(),
            rtl: App.isRTL(),
            autoclose: true
        });
    }

    var handleProducts = function() {
        var grid = new Datatable();

        grid.init({
            src: $("#datatable_productList"),
            onSuccess: function (grid) {
            	//alert("success");
            },
            onError: function (grid) {
                // execute some code on network or other general error
            	alert("onError");
            },
            loadingMessage: 'Loading ...',
            dataTable: { // here you can define a typical datatable settings from http://datatables.net/usage/options 

                // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
                // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/scripts/datatable.js). 
                // So when dropdowns used the scrollable div should be removed. 
                //"dom": "<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'<'table-group-actions pull-right'>>r>t<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'>>",

                "lengthMenu": [
                    [2,10, 20, 50, 100, 150, 200],
                    [2,10, 20, 50, 100, 150, 200] // change per page values here 
                ],
                "pageLength": 10, // default record count per page
                "ajax": {
                    "url": "/acp/item/productListData", // ajax source
                    //"url": "http://localhost:8080/acp/events/eventsNewsListData?length=3", // ajax source
                },
                "order": [
                    [5, "desc"]	//set to date post as default sorting column, modified by Athens on 2017-06-07
                ] // set first column as a default sort by asc
            }
        });

         // handle group action submit button click
        grid.getTableWrapper().on('click', '.table-group-action-submit', function (e) {
        	//alert("getTableWrapper");
            e.preventDefault();
            var action = $(".table-group-action-input", grid.getTableWrapper());
            
            //alert(action.val());
            
            if (action.val() != "" && grid.getSelectedRowsCount() > 0) {
                grid.setAjaxParam("customActionType", "group_action");
                grid.setAjaxParam("customActionName", action.val());
                grid.setAjaxParam("id", grid.getSelectedRows());
                
                //modified by Athens
                var prodIdArray = grid.getSelectedRows();
                var productStatus = action.val();
                groupUpdateStatus(prodIdArray,productStatus);
                //end-of-modified
                
                //grid.getDataTable().ajax.reload();
                //grid.getDataTable().ajax.url("/acp/events/eventsNewsListData").load();
                //grid.getDataTable().ajax.reload();
                grid.clearAjaxParams();
                
                
            } else if (action.val() == "") {
                Metronic.alert({
                    type: 'danger',
                    icon: 'warning',
                    message: 'Please select an action',
                    container: grid.getTableWrapper(),
                    place: 'prepend'
                });
            } else if (grid.getSelectedRowsCount() === 0) {
                Metronic.alert({
                    type: 'danger',
                    icon: 'warning',
                    message: 'No record selected',
                    container: grid.getTableWrapper(),
                    place: 'prepend'
                });
            }
        });
    }

    return {

        //main function to initiate the module
        init: function () {
            handleProducts();
            initPickers(); 
        }

    };

}();


/* list product - button:group update status */
function groupUpdateStatus(productIDArray,prodStatus){
	alert("groupUpdateStatus()");
    alert(productIDArray+":"+prodStatus);
	alert("initLoc "+ initLoc);
	//execute saving
    $.ajax({
        type    :    "post",
        url        : "updateProductGroup?productIDArray="+productIDArray+"&prodStatus="+prodStatus,
        dataType:    "json",
        timeout :     30000,
        
        success:function(msg){
            location.href="productList?lang="+initLoc;
        	//alert("INFO: News status updated.");
        },
        error:function(){
            alert("ERROR: News updating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/* list news - datatable:button:filter search */
function filterSearch(){
	
//	alert("do filterSearch()");
//	create a json object
		
		//var p1 = $("#prodId").val();
	    var p2 = $("#prodBizId").val();        
	    var p3 = $("#prodSeqNo").val();
	    var p4 = $("#prodType").val();
	    var p5 = $("#prodStatus").val();
	    var p6 = $("#prodSaleType").val();
	    
	    
	    var p7 = $("#createDatetimeFrom").val();
	    	p7=p7+",";
	    var p8 = $("#createDatetimeTo").val();
			p7=p7+p8;
		
	    var p9 = $("#prodName").val();
	    var p10 = $("#categoryName").val();
	  //  alert(p10);
    var businessObject =
    {
    		//prodId    :    p2,
    		prodBizId   :    p2,
    		prodSeqNo    	:    p3,
    		prodType    	:    p4,
    		prodStatus:    p5,            
    		prodSaleType    	:   p6,  
    		prodCreaterDatetime:p7,
    		itemProductI18n		:{ prodName		:	p9},
    		categoryName 		: p10
    		
           
    //		descShort   :    p7,
    //		descLong	:    p8,
      	/*	eventClass  :    p9,
    		eventStatus	:    p10*/
    };
    var d=JSON.stringify( businessObject );
     var dt = $("#datatable_productList").DataTable();
   /* var dt = $("#datatable_productList").DataTable( {
    			"destroy": true,
    			"ajax": {
    			type    :    "post",
    			url: "getDataProductByFilter",
    		    contentType: "application/json; charset=utf-8",
    		    data: d,
    		    dataType: "json"
    		  }
    		} );*/
   var x = dt.ajax.url("getDataProductByFilter?itemJSONString="+JSON.stringify(businessObject)).load();
}


function deleteProduct(prodId){
	  $.ajax({
	    	type    :    "post",
	    	
	        url        : "deleteProduct?prodId="+prodId,
//	        timeout :     30000,
	        
	        success:function(msg){
	        	alert("product deleted!")
	        	location.href="productList";
	        },
	        error:function(){
	            alert("ERROR: product delete failed.");     
	        },            
	        complete: function(XMLHttpRequest, textStatus){
	            //reset to avoid duplication
	        }        
	    });
	///acp/item/deleteProduct?prodId="+listProduct.get(i).getProdId()+"' 
}