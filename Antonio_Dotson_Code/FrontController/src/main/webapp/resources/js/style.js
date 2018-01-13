// JavaScript Document

$(function() {
  "use strict";

  function closeMenu(){
    $("body").addClass("menu-closed");
  }

  function openMenu(){
    $("body").removeClass("menu-closed");
  }



/////////////////////// ready
  $(document).on('ready', function() {

    // Accordion.
    var o = $( ".accordion" );
    if (o.length > 0) {
      o.accordion({
        heightStyle: "content"
      });
    }

    // Menu.
    $( document ).on('click', ".arrow1", function() {
      closeMenu();
    });

    $( document ).on('click', ".arrow2", function() {
      openMenu();
    });


    /*----------------------------------------------------*/
    // Appear
   /* 
    $('.animated').appear(function() {
      // console.log("111111111111");
      var elem = $(this);
      var animation = elem.data('animation');
      if ( !elem.hasClass('visible') ) {
        var animationDelay = elem.data('animation-delay');
        if ( animationDelay ) {
          setTimeout(function(){
            elem.addClass( animation + " visible" );
          }, animationDelay);
        } else {
          elem.addClass( animation + " visible" );
        }
      }
    });

    // Carousels.
    var oa = $("#sl").find(".carousel.main ul");
    if (oa.length > 0) {
      oa.carouFredSel({
        auto: {
          timeoutDuration: 8000
        },
        responsive: true,
        prev: '.sl_prev',
        next: '.sl_next',
        width: '100%',
        scroll: {
          items: 1,
          duration: 1000,
          easing: "easeOutExpo"
        },
        items: {
          width: '2000',
          height: 'variable', //  optionally resize item-height
          visible: {
            min: 1,
            max: 1
          }
        },
        mousewheel: false,
        swipe: {
          onMouse: true,
          onTouch: true
        }
      });
    }



    $(window).on('bind', "resize",updateSizes_vat).on('bind', "load",updateSizes_vat);
    function updateSizes_vat(){
      oa.trigger("updateSizes");
    }
    updateSizes_vat();
*/




  });


});