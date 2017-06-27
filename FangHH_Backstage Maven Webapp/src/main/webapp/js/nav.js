angular
    .module('navigator', [])
    .controller('navigator', ['$scope', '$location', function($scope, $location){
        /*-----------------------------------------------------------------------------------*/
        /*  To get the correct viewport width based on  http://andylangton.co.uk/articles/javascript/get-viewport-size-javascript/
        /*-----------------------------------------------------------------------------------*/
        var getViewPort = function () {
                var e = window, a = 'inner';
                if (!('innerWidth' in window)) {
                    a = 'client';
                    e = document.documentElement || document.body;
                }
                return {
                    width: e[a + 'Width'],
                    height: e[a + 'Height']
                }
        }
        /*-----------------------------------------------------------------------------------*/
        /*  Sidebar & Main Content size match
        /*-----------------------------------------------------------------------------------*/
        var handleSidebarAndContentHeight = function () {
                var content = $('#content');
                var sidebar = $('#nav');
                var body = $('body');
                var height;

                if (body.hasClass('sidebar-fixed')) {
                    height = $(window).height() - $('#header').height() + 1;
                } else {
                    height = sidebar.height() + 20;
                }
                if (height >= content.height()) {
                    content.attr('style', 'min-height:' + height + 'px !important');
                }
        }
        /*-----------------------------------------------------------------------------------*/
        /*  Sidebar
        /*-----------------------------------------------------------------------------------*/
        var handleSidebar = function () {
                jQuery('.navigation .has-sub > a').click(function () {
                    var last = jQuery('.has-sub.open', $('.navigation'));
                    last.removeClass("open");
                    jQuery('.arrow', last).removeClass("open");
                    jQuery('.sub', last).slideUp(200);
                    
                    var thisElement = $(this);
                    var slideOffeset = -200;
                    var slideSpeed = 200;
                    
                    var sub = jQuery(this).next();
                    if (sub.is(":visible")) {
                        jQuery('.arrow', jQuery(this)).removeClass("open");
                        jQuery(this).parent().removeClass("open");
                        sub.slideUp(slideSpeed, function () {
                            if ($('#nav').hasClass('sidebar-fixed') == false) {
                                scrollTo(thisElement, slideOffeset);
                            }
                            handleSidebarAndContentHeight();
                        });
                    } else {
                        jQuery('.arrow', jQuery(this)).addClass("open");
                        jQuery(this).parent().addClass("open");
                        sub.slideDown(slideSpeed, function () {
                            if ($('#nav').hasClass('sidebar-fixed') == false) {
                               scrollTo(thisElement, slideOffeset);
                            }
                            handleSidebarAndContentHeight();
                        });
                    }
                });
                
                // Handle sub-sub menus
                jQuery('.navigation .has-sub .sub .has-sub-sub > a').click(function () {
                    var last = jQuery('.has-sub-sub.open', $('.navigation'));
                    last.removeClass("open");
                    jQuery('.arrow', last).removeClass("open");
                    jQuery('.sub', last).slideUp(200);
                        
                    var sub = jQuery(this).next();
                    if (sub.is(":visible")) {
                        jQuery('.arrow', jQuery(this)).removeClass("open");
                        jQuery(this).parent().removeClass("open");
                        sub.slideUp(200);
                    } else {
                        jQuery('.arrow', jQuery(this)).addClass("open");
                        jQuery(this).parent().addClass("open");
                        sub.slideDown(200);
                    }
                });
        }
        /*-----------------------------------------------------------------------------------*/
        /*  Responsive Sidebar Collapse
        /*-----------------------------------------------------------------------------------*/
        var responsiveSidebar = function () {
                //Handle sidebar collapse on screen width
                var width = $(window).width();
                if ( width < 768 ) {
                    is_mobile = true;
                    //Hide the sidebar completely
                    jQuery('#main-content').addClass("margin-left-0");
                }
                else {
                    is_mobile = false;
                    //Show the sidebar completely
                    jQuery('#main-content').removeClass("margin-left-0");
                    var menu = $('.sidebar');
                    if (menu.parent('.slimScrollDiv').size() === 1) { // destroy existing instance before resizing
                        menu.slimScroll({
                            destroy: true
                        });
                        menu.removeAttr('style');
                        $('#nav').removeAttr('style');
                    }
                }
        }
        /*-----------------------------------------------------------------------------------*/
        /*  Handle Fixed Sidebar
        /*-----------------------------------------------------------------------------------*/
        var handleFixedSidebar = function () {
                var menu = $('.navigation');

                if (menu.parent('.slimScrollDiv').size() === 1) { // destroy existing instance before updating the height
                    menu.slimScroll({
                        destroy: true
                    });
                    menu.removeAttr('style');
                    $('#nav').removeAttr('style');
                }

                if ($('.sidebar-fixed').size() === 0) {
                    handleSidebarAndContentHeight();
                    return;
                }

                var viewport = getViewPort();
                if (viewport.width >= 992) {
                    var sidebarHeight = $(window).height() - $('#header').height() + 1;

                    menu.slimScroll({
                        size: '7px',
                        color: '#a1b2bd',
                        opacity: .3,
                        height: sidebarHeight,
                        allowPageScroll: false,
                        disableFadeOut: false
                    });
                    handleSidebarAndContentHeight();
                }
        }

        /*-----------------------------------------------------------------------------------*/
        /*  Windows Resize function
        /*-----------------------------------------------------------------------------------*/
        jQuery(window).resize(function() {
            setTimeout(function () {
                handleSidebarAndContentHeight();
                responsiveSidebar();
                handleFixedSidebar();
            }, 50); // wait 50ms until window resize finishes.
        });

        //Initialise theme pages
        var init = function () {
            handleSidebar(); //Function to display the sidebar
            handleSidebarAndContentHeight();  //Function to hide sidebar and main content height
            responsiveSidebar();        //Function to handle sidebar responsively
        }

        init();

        $scope.pageNow = $location.url().split('/');

        $scope.$on('$locationChangeSuccess', function() {
            $scope.pageNow = $location.url().split('/');
        })
    }]);