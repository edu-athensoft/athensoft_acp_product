/**
 * Package:	content
 * Module:  item system
 */

/* item product - global variables and functions*/
function getProductObject(){	
//	create a json object
    var p1 = $("#prodId").val();
    var p2 = $("#prodBizId").val();        
    var p3 = $("#prodSeqNo").val();
    var p4 = $("#prodType").val();
    var p5 = $("#prodStatus").val();
    var p6 = $("#prodSaleType").val();
    var p7 = $("#prodDesc").val();
    var p8 = $("#prodDescLong").val();
    var p9 = $("#prodName").val();
    var p10 = $("#prodNameAlias").val();
  /*  var p10 = $("#eventStatus").val();*/
    
    var businessObject =
    {
    		prodId    :    p1,
    		prodBizId   :    p2,
    		prodSeqNo    	:    p3,
    		prodType    	:    p4,
    		prodStatus:    p5,            
    		prodSaleType    	:    p6,            
    		itemProductI18n		:{prodDesc   :    p7,prodDescLong	:    p8,
        						  prodName		:	p9,prodNameAlias	:	p10} 
    		
    		
    };
    
    return businessObject;
}
