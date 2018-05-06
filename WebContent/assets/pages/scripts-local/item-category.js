/**
 * Package:	content
 * Module:  event-news system
 */

/* event news - global variables and functions*/
function getBusinessObject(){	
//	create a json object
    var p1 = key
    //alert("p1 "+p1)
   
    var p2 = $("#categoryName").val();        
    var p3 = $("#categoryDesc").val();
    var p5 = $("#categoryStatus").val();
    if(p2.trim()==""){
    	alert("Category Name can not be empty");
    	return false;
    }else if(p3.trim()==""){
    	alert("Category Description can not be empty");
    	return false;
    }
    else if(p5==0){
    	alert("Must choose a Status");
    	return false;
    }
    
    
    var businessObject =
    {
    		
    		categoryCode    :    p1,
    		categoryName   :    p2,
    		categoryDesc    	:    p3,
    	
    		categoryStatus    	:    p5,
    };
    
    return businessObject;
}
