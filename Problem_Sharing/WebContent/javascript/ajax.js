function performAjax(url, method, callback) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			if(callback) {
				callback(xhttp.responseText);
			}
		}
	};
	xhttp.open(method, url, true);
	xhttp.send();
}

function createURL(url, key, value) {
	if(!(url.substring(url.length-1, url.length) == "?")) {
		url += "?";
	}

	for(var i=0;i<key.length;i++) {
		if(i != 0) {
			url += "&";
		}		
		url += key[i] + "=" + value[i];
	}
	return url;
}