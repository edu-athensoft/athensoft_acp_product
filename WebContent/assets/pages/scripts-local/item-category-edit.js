/** item-category-edit.jsp */

/* edit product - button:save change,update */
function editCategory() {
    var businessObject = getBusinessObjectCateEdit();
    //alert(businessObject);
    //execute saving
    $.ajax({      
    	
    	type    :    "post",
        url        : "categoryUpdate?itemJSONString="+JSON.stringify(businessObject),
        dataType:    "json",
        //timeout :     30000,
        
        success:function(msg){
            location.href="categoryList?lang="+$("#selectLang").val();
        },
        error:function(){
            alert("ERROR:Category updating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}



/*edit product - button:save and continue */
function updateCategoryAndContinue() {
	var productObject = getProductObject();
    //execute saving
    $.ajax({
    	type    :    "post",
        url        : "categorytUpdate?itemJSONString="+JSON.stringify(productObject),
        dataType:    "json",
        //timeout :     30000,
        
        success:function(msg){
           // location.href="productList";
        },
        error:function(){
            alert("ERROR: News updating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


