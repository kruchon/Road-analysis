var accidents = [];
//
// $.post('getAccidents').done(function (response) {
//     accidents = JSON.parse(response);
// });

var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -34.397, lng: 150.644},
        zoom: 8
    });
}