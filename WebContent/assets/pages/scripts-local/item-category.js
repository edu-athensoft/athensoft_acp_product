/**
 * Package:	content
 * Module:  event-news system
 */

/* event news - global variables and functions*/
function getBusinessObject(){	
//	create a json object
    var p1 = $("#parentId").val();
    	p1=p1.split(",")[0];
    var p2 = $("#categoryName").val();        
    var p3 = $("#categoryDesc").val();
    var p4 = $("#categoryLevel").val();
    var p5 = $("#categoryStatus").val();
    var p6 = $("#parentId").val().split(",")[1];

    
    
    var businessObject =
    {
    		
    		parentId    :    p1,
    		categoryName   :    p2,
    		categoryDesc    	:    p3,
    		categoryLevel    	:    p4,
    		categoryStatus    	:    p5,
    		categoryCode 	:	p6
    };
    
    return businessObject;
}
