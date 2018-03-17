function getSSToORMETBResponse() {

	$
			.ajax({
				url : "http://localhost:8090/getEmpDetails",
				type : "GET",
				contentType : "application/json",
				accepts : "application/json",
				cache : false,
				dataType : 'json',
				success : function(response) {

						createTableFromJSON(response);

				}
			});
}
function createTableFromJSON(tableDataInJson) {
	var divContainer = document.getElementById("employeeDiv");
	divContainer.innerHTML = "";

	// EXTRACT VALUE FOR HTML HEADER.
	var col = [];
	for (var i = 0; i < tableDataInJson.length; i++) {
		for ( var key in tableDataInJson[i]) {
			if (col.indexOf(key) === -1) {
				col.push(key);
				// alert(key);
			}
		}
	}
	var table = document.createElement("table");
	table.setAttribute("class", "table table-striped");

	// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.
	var tr = table.insertRow(-1);
	for (var i = 0; i < col.length; i++) {
		var th = document.createElement("th");
		th.innerHTML = col[i];
		tr.appendChild(th);
	}

	// ADD JSON DATA TO THE TABLE
	for (var i = 0; i < tableDataInJson.length; i++) {
		tr = table.insertRow(-1);
		for (var j = 0; j < col.length; j++) {
			var tabCell = tr.insertCell(-1);
			tabCell.innerHTML = tableDataInJson[i][col[j]];
		}
	}
	table.className = 'table table-bordered table-striped';

	// ADDING THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
	divContainer.appendChild(table);
}