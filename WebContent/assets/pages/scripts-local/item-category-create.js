/**
 * Ajax to get the data from database
 * to initialize the drop down menu of parent node
 * 
 * 
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
	        	location.href="categoryListData";
	        },
	        error:function(){
	            alert("ERROR: News creating failed.");     
	        },            
	        complete: function(XMLHttpRequest, textStatus){
	            //reset to avoid duplication
	        }        
	    });
	
}