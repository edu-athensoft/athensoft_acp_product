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
    var p12 = text;
    //alert(key+","+text);
  /*  var p10 = $("#eventStatus").val();*/
   // alert(initLoc);
    var p13 = initLoc;
    var p14 =$("#productImg").attr("src");
  //  alert(p13);
   // alert(p14)
    if( p4==0|| p5==0|| p6==0|| p7.trim()==""|| p8.trim()==""||p9.trim()==""||  p10.trim()==""){
    	alert("please fill out all columns");
    	
    	return false;
    }
    
    if(p11=="ROOT"){
    	alert("category can not be ROOT");
    	return false; 
    }
    if(p11==null){
    	alert("Must choose a category!");
    	return false;
    }
    if(p14==undefined){
    	alert("Must upload a image for the product!");
    	return false;
    }
    var businessObject =
    {
    		prodId   		 	:    p1,
    		prodBizId  		 	:    p2,
    		prodSeqNo    		:    p3,
    		prodType        	:    p4,
    		prodStatus			:    p5,            
    		prodSaleType    	:    p6,            
    		itemProductI18n		:	{prodDesc   :    p7,prodDescLong	:    p8,
        						  	prodName		:	p9,prodNameAlias	:	p10},
        	categoryCode   		: p11,
        	categoryName 		: p12,
        	langNo 				: p13,
        	prodImgUrl			: p14
    		
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


function upload_cover(obj) {
    ajax_upload(obj.id, function(data) { 
        var isrc = data.relatPath.replace(/\/\//g, '/'); 
        $('#productImg').attr('src', "/acp"+isrc).data('img-src', isrc); 
    });
}
function ajax_upload(feid, callback) {
    if (image_check(feid)) { 
        $.ajaxFileUpload({
            fileElementId: feid,    
            url:'uploadProductImg', 
            type: 'post',   
            dataType: 'json',   
            secureuri: false,   
            async : true,   
            success: function(data) {   
                if (callback) callback.call(this, data);
            },
            error: function(data, status, e) {  
                console.error(e);
            }
        });
    }
}
function image_check(feid) { 
    var img = document.getElementById(feid);
    return /.(jpg|png|gif|bmp)$/.test(img.value)?true:(function() {
        alert('图片格式仅支持jpg、png、gif、bmp格式，且区分大小写。');
        return false;
    })();
}