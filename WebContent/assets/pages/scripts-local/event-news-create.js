/** event_news_create.jsp */


/* create news - button:back */
function backToNewsList(){
	location.href = "/acp/events/eventsNewsList";
}


/* create news - button:save change,create */
function createNews() {
    //alert(JSON.stringify(businessObject));
    var businessObject = getBusinessObject();
    
    /* validating by business rule */
    //event title
    var eventTitle = businessObject.title;
    if(isEmptyString(eventTitle)){
    	alert("WARNING: event title must not be empty!");
    	return;
    }
    var author = businessObject.author;
    if(isEmptyString(author)){
    	alert("WARNING: author must not be empty!");
    	return;
    }
    
    //execute saving
    $.ajax({
        type    :    "post",
        url        : "createNews?itemJSONString="+JSON.stringify(businessObject),
        dataType:    "html",
        timeout :     30000,
        
        success:function(msg){
        	location.href="eventsNewsList";
        },
        error:function(){
            alert("ERROR: News creating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/* create news - button:reset */
function resetCreateNews(){
	var p1 = $("#globalId").val("");
    var p2 = $("#eventUUID").val("");        
    var p3 = $("#title").val("");
    var p4 = $("#author").val("");
    //var p5 = $("#postDatetime").val("");
    var p6 = $("#viewNum").val(0);
    var p7 = $("#descShort").val("");
    var p8 = $("#descLong").val("");
    var p9 = $("#eventClass").val(0);
    var p10 = $("#eventStatus").val(0);
}