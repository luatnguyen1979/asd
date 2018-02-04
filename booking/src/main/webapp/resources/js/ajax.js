// pathname is contextRoot/path/path/ so we want to get [1] 
// that is where contextRoot is
// [0] has "" as a result of split 
var contextRoot = "/" + window.location.pathname.split('/')[1];

function searchRoute() {
	var dataToSend = JSON.stringify(serializeObject($('#bookingSearch')));
	var dataObj = serializeObject($('#bookingSearch'));
	// var dataToSend = serializeObject($('#bookingSearch'));

	var trip = $("#trip").val();
	var fromport = $("#fromport").val();
	var toport = $("#toport").val();
	var departdate = $("#departdate").val();
	var returndate = $("#returndate").val();
	var travelernumber = $("#travelernumber").val();
	$('#content').html("");
	$("<form id='continue' action='continuingbooking' method='POST'>").appendTo($("#content"));
	var $table = $("<table width=1024px border=1>").appendTo($("#continue"));

	$("<tr>").appendTo($table).append(
			$("<td colspan=\"9\" class=\"section\">").text(
					"List Of Available Trains:"));
	$("<tr class=\"tableheader\">").appendTo($table).append(
			$("<td>").text("No")).append($("<td>").text("Train")).append(
			$("<td>").text("Class")).append($("<td>").text("From")).append(
			$("<td>").text("To")).append($("<td>").text("Depart Time")).append(
			$("<td>").text("Arrival Time")).append(
			$("<td>").text("Price One Way / Roud Trip")).append(
			$("<td>").text("Selection"));
	$.ajax({
		type : 'GET',
		url : contextRoot + '/searchschedule?trip=' + trip + '&fromport='
				+ fromport + '&fromport=' + fromport + '&toport=' + toport
				+ '&departdate=' + departdate + '&returndate=' + returndate
				+ '&travelernumber=' + travelernumber,
		dataType : "json", // Accept header
		// data:dataToSend,
		contentType : 'application/json', // Sends - Content-type
		success : function(routes) {
			for (var i = 0; i < routes.length; i++) {
				let dhour = routes[i].departureDate.time.hour;
				dhour = dhour > 9 ? dhour : ("0" + dhour);
				let dminute = routes[i].departureDate.time.minute;
				dminute = dminute > 9 ? dminute : ("0" + dminute);
				let dsecond = routes[i].departureDate.time.second;
				dsecond = dsecond > 9 ? dsecond : ("0" + dsecond);
				let ahour = routes[i].arrivalDate.time.hour;
				ahour = ahour > 9 ? ahour : ("0" + ahour);
				let aminute = routes[i].arrivalDate.time.minute;
				aminute = aminute > 9 ? aminute : ("0" + aminute);
				let asecond = routes[i].arrivalDate.time.second;
				asecond = asecond > 9 ? asecond : ("0" + asecond);
				$("<tr>").appendTo($table).append($("<td>").text(i + 1))
						.append($("<td>").text(routes[i].train.name)).append(
								$("<td>").text(routes[i].train.type)).append(
								$("<td>").text(routes[i].source.name)).append(
								$("<td>").text(routes[i].destination.name))
						.append(
								$("<td>").text(dhour + ":" + dminute + ":" + dsecond))
						.append(
								$("<td>").text(ahour + ":" + aminute + ":" + asecond))
						.append(
								$("<td>").text(
										routes[i].priceOneWay + "/"
												+ routes[i].priceRoundWay))
						.append(
								$("<td>").html(
										"<input align=center type=\"radio\" name=\"selection\" value=\""
												+ routes[i].id + "\">"));
			}
			//$("<br/>").appendTo($("#continue"));
			$("<tr>").appendTo($table).append($("<td colspan=9 align=right class=bottomBorderLess>").html("<input type='submit' value='Continue' onclick='veriryContinuingBook();return false;'/>"));
					
		},

		error : function(errorObject) {
			alert("error");
		}
	});
}

function veriryContinuingBook() {
	var trip = $("name=selection").val();
	if (trip !== "") {
		alert("Continue")
	} else {
		alert("Please select one route before continuing");
	}
}


make_hidden = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'none';
}

make_visible = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'block';
}

// Translate form to array
// Then put in JSON format
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};

