/** item_product_create.jsp */


/* create news - button:back */
function backToProductList(){
	location.href = "/acp/item/productList";
}

/**
 * Ajax to get the data from database
 * to initialize the drop down menu of parent node
 * */

$().ready(function(){
	
	$.ajax({
    	type    :    "post",
    	async: false,
    //	dataType:    "json",
        url        : "getAllCategoryParent",
  
        success:function(data){
        	//alert(data['data'][0]);
        	var listCategories =data['data'];
        	//alert(listCategories);
        	var  selectParent = $("#parentId");
        	for(i=0;i<listCategories.length;i++){
        		//alert(listCategories[i]);
        		
        		if(listCategories[i].categoryName=="ROOT"){
        			selectParent.append(
            				"<option selected value="+listCategories[i].categoryId+","+listCategories[i].categoryCode+">"+listCategories[i].categoryId+"---"+listCategories[i].categoryName+"</option>"
            		);
        		}else{
        			selectParent.append(
            				"<option value="+listCategories[i].categoryId+" >"+listCategories[i].categoryId+"---"+listCategories[i].categoryName+"</option>"
            		);
            		
        		}
        		
        	}
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
	   alert(dd);

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