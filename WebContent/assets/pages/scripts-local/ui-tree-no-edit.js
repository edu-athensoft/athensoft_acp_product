var UITree = function () {


    var contextualMenuSample = function() {
    	
    	$("#tree_search_input").keyup(function() {

            var searchString = $(this).val();
            $('#tree_3').jstree('search', searchString);
        });
    	
        $("#tree_3").jstree({
            "core" : {
                "themes" : {
                    "responsive": false
                }, 
                // so that create works
                "check_callback" : true,
               
                'data':jsTreeData
              
            },
           "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            },
            "state" : { "key" : "demo2" },
            "search": {
                "case_insensitive": true,
                "show_only_matches" : true
            },
            "plugins" : [ "state", "types", "search" ]
        })
       .on('changed.jstree', function (e, data) {
//        	alert($("#tree_3").jstree().get_selected(true)[0].text); //ok
    	    stateInfo=data.instance.get_node(data.selected[0]).state
    	   
    	   if(stateInfo!= undefined){
    		   alert(JSON.stringify(stateInfo)) 
    			key = stateInfo.key 
    			text = data.instance.get_node(data.selected[0]).text
    	   }
    	  
     	console.log("The selected nodes are:");
            console.log(data.selected);
		    var i, j, r = [];
		    for(i = 0, j = data.selected.length; i < j; i++) {
		      r.push(data.instance.get_node(data.selected[i]).text);
		    }
//		    $('#event_result').html('Selected: ' + r.join(', '));
		  }) 
		
    }

    return {
        //main function to initiate the module
        init: function () {
            contextualMenuSample();
        }

    };

}();

if (App.isAngularJsApp() === false) {
    jQuery(document).ready(function() {    
       UITree.init();
      
    });
}