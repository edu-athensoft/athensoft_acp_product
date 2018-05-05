/**
 * Ajax to get the data from database
 * to initialize the drop down menu of parent node
 * 
 * 
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

function createCategory(){
	  var itemCategory = getBusinessObject();
	 
	    var dd=JSON.stringify(itemCategory);
	   alert(dd);
	  // dd='{"itemCategory" :'+dd+'}';
	   console.log(dd);
	    //execute saving
	    $.ajax({
	    	type    :    "post",
	        url        : "newCreateCategory",
	        contentType	:'application/json;charset=utf-8',
	        data 		:dd,
	        dataType:    "json",
//	        timeout :     30000,
	        
	        success:function(msg){
	        	location.href="categoryList";
	        },
	        error:function(){
	            alert("ERROR: News creating failed.");     
	        },            
	        complete: function(XMLHttpRequest, textStatus){
	            //reset to avoid duplication
	        }        
	    });
	
}