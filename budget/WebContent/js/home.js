jQuery.fn.outerHTML = function() {
	return jQuery('<div />').append(this.eq(0).clone()).html();
};
$(document).ready(function() {
	var d, m, y;
	function load() {
		currentMonth();
		$(".uname").html("Gane");
	}
	function currentMonth() {
		var dt = new Date();
		y = dt.getFullYear();
		m = dt.getMonth();
		d = dt.getDate();
		generateCalendar("calBody");
	}
	function generateCalendar(ele) {
		var date = new Date(y + "-" + (m + 1) + "-01");
		var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
		var days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29];
		var start = 0 - date.getDay(), end = (y % 4 == 0 && m == 1) ? days[12] : days[m];
		$(".calYear").html(y);
		$(".calMonth").html(months[m]);
		var calHtml = $("<table>");
		calHtml.append($("<tr>").append($("<th>").html("Sun")).append($("<th>").html("Mon"))
							.append($("<th>").html("Tue")).append($("<th>").html("Wed"))
							.append($("<th>").html("Thu")).append($("<th>").html("Fri"))
							.append($("<th>").html("Sat")));
		var c = 0;
		var calRow;
		while(start++ < end) {
			if(++c == 1) {
				calRow = $("<tr>"); //((start > 0) ? start : " ")
				calHtml.append(calRow);
			}
			if(start > 0) {
				var dd = "" + y + "-" + ((m < 10) ? "0" + m : "") + "-" + ((start < 10) ? "0" + start  	: start);
				calRow.append($("<td>").append(getDateSection(dd)));
			} else {
				calRow.append($("<td>"));
			}
			if(c == 7) {
				c = 0;
			}
		}
		$("." + ele).html(calHtml);
		
		$(".addExpense").click(function() {
			showAddExpensePopup($(this).parent());
		});

		$(".showExpenses").click(function() {
			showTodayExpensesPopup($(this).parent());
		});
	}
	var showAddExpensePopup = function(ele) {
		alert("add Clicked: " + ele.attr("id"));
	};
	var showTodayExpensesPopup = function(ele) {
		alert("Show Clicked: " + ele.attr("id"));
	};
	var getDateSection = function(date) {
		var dateHtml = $("<div>",{id: date, class: "calDay"});
		dateHtml.append($("<div>", {class: "calDate", title: date}).html(date.substr(8)));
		dateHtml.append($("<div>", {class: "dateButton dayExpense", title: 12000}).html("12000"));
		dateHtml.append($("<div>", {class: "dateButton addExpense", title: "Add Expense"}).html("+"));
		dateHtml.append($("<div>", {class: "dateButton showExpenses", title: "Show Today's Expenses"}).html("o"));
		return dateHtml;
	};
	var getHamMenu = function() {
		var menu = $("<div>", {});
		menu.append($("<div>", {class: "hamMenuItem", text: "Add transaction"}));
		menu.append($("<div>", {class: "hamMenuItem", text: "Categories"}));
		menu.append($("<div>", {class: "hamMenuItem", text: "DashBoard"}));
		return menu.html();
	};
	$(".hamMenu").hover(function() {
		$(".hamMenuBox").show();
		$(".hamMenuBox").html(getHamMenu());
	}, function() {
		$(".hamMenuBox").hide();
	});
	$(".hamMenuBox").hover(function() {
		$(".hamMenuBox").show();
		$(".hamMenuBox").html(getHamMenu());
	}, function() {
		$(".hamMenuBox").hide();
	});
	$(".nextMonth").click(function() {
		console.log("nextM");
		m++;
		if(m > 11) {
			m = 0; y++;
		}
		generateCalendar("calBody");
	});
	$(".previousMonth").click(function() {
		console.log("preM");
		m--;
		if(m < 0) {
			m = 11; y--;
		}
		generateCalendar("calBody");
	});
	$(".nextYear").click(function() {
		console.log("nextY");
		y++;
		generateCalendar("calBody");
	});
	$(".previousYear").click(function() {
		console.log("preY");
		y--;
		generateCalendar("calBody");
	});

	//on page load
	load();
});