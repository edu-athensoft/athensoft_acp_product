/** event-news-review-edit.js */

/* event news review - button:save change,update */
function updateNewsReview() {
    
	//alert("updateNewsReview()");
	
	var p1 = $("#eventUUID").val();
	var p2 = $("#reviewUUID").val();
	var p3 = $("#reviewContent").val();
	var p4 = $("#customerId").val();
	
	//alert("reviewUUID="+p2);
	
    var reviewObject = {
    	eventUUID 		: p1,
    	reviewUUID 		: p2,
    	reviewContent 	: p3,
    	customerId		: p4
    };
    
   //alert(JSON.stringify(reviewObject));
    
    //execute saving
    $.ajax({
        type    :    "post",
        url        : "updateNewsReview?itemJSONString="+JSON.stringify(reviewObject),
        dataType:    "html",
        timeout :     30000,
        
        success:function(msg){
        	var tabId = "#tab_reviews";
            location.href="eventsNewsEdit?eventUUID="+p1+tabId;
        },
        error:function(){
            alert("ERROR: News review updating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/* event news review - button:save change and continue ,update */
function updateNewsReviewAndContinue(){
	alert("TODO: updateNewsReviewAndContinue()");
}


/* event news review - button:back */
function backToNewsEdit(){
	var p1 = $("#eventUUID").val();
	var tabId = "#tab_reviews";
	location.href = "/acp/events/eventsNewsEdit?eventUUID="+p1+tabId;
}


/* event news review - button:reset */
function resetNewsReview(){
//	alert("resetNewsReview()");
	
	var p1 = $("#globalId").val("");
    var p2 = $("#eventUUID").val("");        
    var p3 = $("#title").val("");
    var p4 = $("#author").val("");
    var p4 = $("#author").val("");
    
}