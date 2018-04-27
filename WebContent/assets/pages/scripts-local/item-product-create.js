/** item_product_create.jsp */


/* create news - button:back */
function backToProductList(){
	location.href = "/acp/item/productList";
}


/* create news - button:save change,create */
function createProduct() {
    var itemProductObject = getProductObject();
    /* validating by business rule */
    //event title
   // var prodSeqNo = itemProductObject.prodSeqNo;
  /*  if(isEmptyString(prodSeqNo)){
    	alert("WARNING:product sequence number  must not be empty!");
    	return;
    }
    var proBizId = itemProductObject.bizId;
    if(isEmptyString(bizId)){
    	alert("WARNING: business ID must not be empty!");
    	return;
    }
    alert("asdads");*/
    var dd=JSON.stringify(itemProductObject);
   
    //execute saving
    $.ajax({
    	type    :    "post",
    	
        url        : "newCreateProduct",
        contentType	:'application/json;charset=utf-8',
        data 		:dd,
        dataType:    "json",
//        timeout :     30000,
        
        success:function(msg){
        	location.href="productList";
        },
        error:function(){
            alert("ERROR: News creating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/* create news - button:reset */
function resetCreateNews(){
	var p1 = $("#globalId").val("");
    var p2 = $("#eventUUID").val("");        
    var p3 = $("#title").val("");
    var p4 = $("#author").val("");
    //var p5 = $("#postDatetime").val("");
    var p6 = $("#viewNum").val(0);
    var p7 = $("#descShort").val("");
    var p8 = $("#descLong").val("");
    var p9 = $("#eventClass").val(0);
    var p10 = $("#eventStatus").val(0);
}