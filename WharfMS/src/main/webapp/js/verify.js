function postData( _post ){
	if( !verify( _post['rules'] ) ){
		return;
	}
	var arr = _post['data'];
	var _data = {};
	for(var i=0; i<arr.length; i++){
		var _id = arr[i];
		var _obj = findObj( _id )
		_data[ _id ] = _obj.val();
	}	
	$.ajax(
   		{
   			url:_post['url'],
   			type:"post",
   			data:_data,
   			dataType:"json",
   			success:_post['success']
   		}
	 );
}



function clearSpan( rules ){
	for( var fldId in rules ){
		var obj = $( "#sp_"+fldId );
		if( obj.length==1 ){			
			obj.remove();
		}
	}
}


function findObj( fldId ){
	var fldObj = $("#"+ fldId);
	if( fldObj.size()==0 ){
		fldObj = $("[name='"+ fldId +"']");
	}
	return fldObj;
}

function verify( rules ){	
	clearSpan( rules );	
	var ret = true;
	var errs = 0;	
	for( var fldId in rules ){
		var pat = rules[ fldId ][0];
		var msg = rules[ fldId ][1];
		var fldObj = findObj( fldId );
		var val = fldObj.val();
		ret = pat.test( val );
		if( !ret ){
			if( val.length==0 ){
				msg = '请输入内容。';
			}
			makeSPAN( fldId, msg );			
			errs ++;
		}
	}
	return errs == 0;
}


function initVerify(){
	for( var fldId in gRules ){
		var o = findObj( fldId );
		o.change( 
			function(){
				var _id = this.id;
				_id = ( !_id )? this.name : _id;
				var _rule = gRules[ _id ];
				verifySigle( _rule, _id );
			}
		);
	}
}

function verifySigle( _rule, _fldId ){	
	$( "#sp_"+ _fldId ).remove();
	var ret = true;
	var pat = _rule[0];
	var msg = _rule[1];	
	var fldObj = findObj( _fldId );	
	var val = fldObj.val();
	ret = pat.test( val );
	if( !ret ){
		if( val.length==0 ){
			msg = '请输入内容。';
		}
		makeSPAN( _fldId, msg );
	}
}

function makeSPAN( _fldId, _msg ){
	var html = "<span id=\"sp_"+ _fldId
		+"\" class=\"err_sp\">"+
		_msg +"</span>";
	var fldObj = findObj( _fldId );
	fldObj.parent().append( html );
}
