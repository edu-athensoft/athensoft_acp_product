/**
 * Package:	content
 * Module:  event-news system
 */

/* event news - global variables and functions*/

function getBusinessObject(){	
//	create a json object
    var p1 = key
    //alert("p1 "+p1)
   
    var p2zh = $("#categoryNameZh").val();  
    var p2en = $("#categoryNameEn").val();  
    var p2fr = $("#categoryNameFr").val();  
    
    var p3zh = $("#categoryDescZh").val();
    var p3en = $("#categoryDescEn").val();
    var p3fr = $("#categoryDescFr").val();
    
    
    
    
    var p5 = $("#categoryStatus").val();
    if(p2zh.trim()==""||p2en.trim()==""||p2fr.trim()==""){
    	
    	alert("Category Name can not be empty");
    	return false;
    }else if(p3zh.trim()==""||p3en.trim()==""||p3fr.trim()==""){
    	alert("Category Description can not be empty");
    	return false;
    }
    else if(p5==0){
    	alert("Must choose a Status");
    	return false;
    }
    var p6 = $("#categoryId").val();
   
    var businessObject =
    {
    		
    		categoryCode    :    p1,
    		categoryName   :    p2zh+","+p2en+","+p2fr,
    		categoryDesc    	:   p3zh+","+p3en+","+p3fr,
    	
    		categoryStatus    	:    p5,
    		categoryId			: p6
    };
    
    return businessObject;
}

function getBusinessObjectCateEdit(){	
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
    var p6 = $("#categoryId").val();
   
    var businessObject =
    {
    		
    		categoryCode    :    p1,
    		categoryName   :    p2,
    		categoryDesc    	:    p3,
    	
    		categoryStatus    	:    p5,
    		categoryId			: p6
    };
    
    return businessObject;
}


function changeLang(selectElement){
	var paramPrefix="?lang=";
	 langValue = selectElement.value;
	//alert(langValue);
	window.location = paramPrefix+langValue; 
	
	//$("#selectLang").val(langValue);
}
