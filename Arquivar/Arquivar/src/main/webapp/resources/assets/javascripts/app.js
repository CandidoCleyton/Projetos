var AW = AW || {};

$(function() {
	$('.js-toggle').bind('click', function(event) {
		$('.js-sidebar, .js-content').toggleClass('is-toggled');
		event.preventDefault();
	});
	
	if (AW.init) {
	    AW.init();
	  }

	  AW.initMenu();

});

AW.onMenuGroupClick = function(event) {
	  var subItems = $(this).parent().find('ul');

	  if (subItems.length) {
	    event.preventDefault();
	    $(this).parent().toggleClass('is-expanded');
	  }
	};

	AW.initMenu = function() {
	  $('.js-menu > ul > li > a').bind('click', AW.onMenuGroupClick);
	  $('.aw-menu__item .is-active').parents('.aw-menu__item').addClass('is-expanded is-active');
	};
