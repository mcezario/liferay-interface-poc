AUI(cetelem).ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {

		// Replace text menu last item
		if(Liferay.Browser.isMobile()) {
			$('.nav-main__item:last-child .nav-main__link').text('Mais');
		}
	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);
