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
    	dataType:    "json",
        url        : "getAllCategoryParent",
  
        success:function(data){
        	//alert(data['data'][0]);
        	var listCategories =data['data'];
        	var  selectParent = $("#parentId");
        	for(i=0;i<listCategories.length;i++){
        		//alert(listCategories[i]);
        		
        		selectParent.append("<option>"+listCategories[i]+"</option>");
        		
        	}
        },
        error:function(){
            alert("ERROR: News creating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
	
	
})