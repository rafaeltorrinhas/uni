let map;
let selectedMarker = null;

function initMap() {
  const position = { lat: 40.633169, lng: -8.659486 };
  const position2 = { lat: 40.657661, lng: -7.914519 };
  const position3 = { lat: 41.178509, lng: -8.595379 };
  const position4 = { lat: 38.737298, lng: -9.138022 };
  map = new google.maps.Map(document.getElementById('map'), {
    zoom: 4,
    center: position,
  });
  const infowindow = new google.maps.InfoWindow({
    content: "Cacifo no Departamento de Eletrónica, Telecomunicações e Informática da Universidade de Aveiro",
    ariaLabel: "Cacifo1",
  });
  const infowindow2 = new google.maps.InfoWindow({
    content: "Cacifo na Câmara Municipal de Viseu",
    ariaLabel: "Cacifo2",
  });
  const infowindow3 = new google.maps.InfoWindow({
    content: "Cacifo no Departamento de Informática na Faculdade de Engenharia da Universidade do Porto",
    ariaLabel: "Cacifo3",
  });
  const infowindow4 = new google.maps.InfoWindow({
    content: "Cacifo no Departamento de Informática II no Instituto Superior Técnico da Universidade de Lisboa",
    ariaLabel: "Cacifo4",
  });

  const marker1 = new google.maps.Marker({
    position: position,
    map: map,
    title: "Cacifo1",
  });

  const marker2 = new google.maps.Marker({
    position: position2,
    map: map,
    title: "Cacifo2",
  });

  const marker3 = new google.maps.Marker({
    position: position3,
    map: map,
    title: "Cacifo3",
  });

  const marker4 = new google.maps.Marker({
    position: position4,
    map: map,
    title: "Cacifo4",
  });

  marker1.addListener("click", function () {
    selectMarker(marker1);
    infowindow.open(map, marker1);
  });

  marker2.addListener("click", function () {
    selectMarker(marker2);
    infowindow2.open(map, marker2);
  });

  marker3.addListener("click", function () {
    selectMarker(marker3);
    infowindow3.open(map, marker3);
  });

  marker4.addListener("click", function () {
    selectMarker(marker4);
    infowindow4.open(map, marker4);
  });
}

document.addEventListener('DOMContentLoaded', function () {
  const cacifosCheckbox = document.getElementById('cacifos');
  const mapContainer = document.getElementById('map-container');
  const addressContainer = document.getElementById('address-container');

  cacifosCheckbox.addEventListener('change', function () {
    if (this.checked) {
      // Show map container and hide address container
      mapContainer.style.display = 'block';
      addressContainer.style.display = 'none';
    } else {
      // Hide map container
      mapContainer.style.display = 'none';
    }
    
  });
});

function selectMarker(marker) {
  // Deselect the previously selected marker (if any)
  if (selectedMarker) {
    selectedMarker.setIcon(null); // Reset the icon to the default
  }
}