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
    	  
     	/*console.log("The selected nodes are:");
            console.log(data.selected);
		    var i, j, r = [];
		    for(i = 0, j = data.selected.length; i < j; i++) {
		      r.push(data.instance.get_node(data.selected[i]).text);
		    }*/
		  }) 
		  var _tree3 = $("#tree_3 ul");
        $('#tree_3').bind("loaded.jstree", function (e, data) {
        	var datas= data.instance._model.data;
        	$.each(datas,function(i,val){
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

function categoryIterator(level){
	debugger;
	for(var i=0;i<level.length;i++){

    	console.log(i);
    	var keyz =level[i].state.key;
    	if(keyz==categoryCode){

  		  $('#tree_3').bind("loaded.jstree", function (e, data) {
          	  $('#tree_3').jstree('select_node', 'j1_96');
          });
          
    	}
    	if(level[i].children!=undefined){
    		
    		var secondLevel=level[i].children;
    		categoryIterator(secondLevel);
        	

    	}
    	
    
        
        
    }
}