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
    var p11 = key;
    
   if( p4==0|| p5==0|| p6==0|| p7.trim()==""|| p8.trim()==""||p9.trim()==""||  p10.trim()==""){
   	alert("please fill out all columns");

    	return false;
    }
 
    if(p11=="ROOT"){
    	alert("category can not be ROOT");
    	return false;
    }
    
    
    
    var p12 = text;
    alert(key+","+text);
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
        						  prodName		:	p9,prodNameAlias	:	p10},
        	categoryCode   : p11,
        	categoryName : p12
    		
    		
    };
   // alert(businessObject);
    return businessObject;
}

function changeLang(selectElement){
	var paramPrefix="?lang=";
	var langValue = selectElement.value;
	//alert(langValue);
	window.location = paramPrefix+langValue; 
	
	//$("#selectLang").val(langValue);
}