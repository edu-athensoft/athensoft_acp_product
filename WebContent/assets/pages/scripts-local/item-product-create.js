/** item_product_create.jsp */


/* create news - button:back */
function backToProductList(){
	location.href = "/acp/item/productList";
}

/**
 * Ajax to get the data from database
 * to initialize the drop down menu of parent node
 * */

var jsTreeData;
$().ready(function(){
	
	var promise =$.ajax({
    	type    :    "post",
    	async: false,
    //	dataType:    "json",
        url        : "getAllCategoryParent",
        
        success:function(data){
        	//alert(data['data'][0]);
        	jsTreeData=data['jsTreeData'];
        	jsTreeData=JSON.parse(jsTreeData);
        	
        },
        error:function(xhr){alert(xhr.responseText)},            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
})



/* create news - button:save change,create */
function createProduct() {
    var itemProductObject = getProductObject();
  
    
    var dd=JSON.stringify(itemProductObject);
	  // alert(dd);

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
            alert("ERROR: Product creating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}

