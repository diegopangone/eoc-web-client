$(document).ready(function(){

/*
    $('#slider_home').bxSlider({
        auto: true,
        autoControls: false,
        pause: 10000
    });
*/

    $('#carouselTopo').carousel({
        interval: 4000,
        pause: false
    });

     $('#slider_ofertas').bxSlider({
         auto: true,
         autoControls: false,
         pager: false,
         pause: 5000,
         slideWidth: 290,
         minSlides: 1,
         maxSlides: 4,
         slideMargin: 40,
         responsive: true
     });
});

