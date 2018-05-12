var UITree = function () {


    var contextualMenuSample = function() {
    
    	//$.jstree.defaults.core.expand_selected_onload = false;

        $("#tree_3").jstree({
            "core" : {
            	"themes" : {
                    "responsive": false
                }, 
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
            
            "state" : { "key" : "demo1" },
            "plugins" : ["types", "search" ]
        })
       .on('changed.jstree', function (e, data) {
//        	alert($("#tree_3").jstree().get_selected(true)[0].text); //ok
    	    stateInfo=data.instance.get_node(data.selected[0]).state
    	   
    	   if(stateInfo!= undefined){
    		   console.log(data);
    		   //alert(JSON.stringify(stateInfo)+". "+data.selected) 
    			key = stateInfo.key 
    			text = data.instance.get_node(data.selected[0]).text
    	   }
    	  
		  }) 
		  var urlRequest = window.location.href;
      		if(urlRequest.indexOf("gotoCategoryEdit")!= -1) var flag=false;
      		
        $('#tree_3').bind("loaded.jstree", function (e, data) {
        	var datas= data.instance._model.data;
        	$.each(datas,function(i,val){
        		if(flag!=undefined)  disable( val.id );    
        		  
        			if(val.text==categoryName){
            			$('#tree_3').jstree('select_node', val.id);
        		}
        	})
        	
        	
        	
        });
        
      
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
function disable(node_id) {
	  var node = $("#tree_3").jstree().get_node( node_id );
	  $("#tree_3").jstree().disable_node(node); 
	  node.children.forEach( function(child_id) {            
	    disable( child_id );
	  })
	} 