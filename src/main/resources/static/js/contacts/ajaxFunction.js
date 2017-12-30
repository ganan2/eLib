function pushToContacts(username) {
  var xhttp = new XMLHttpRequest();
  alert(username.toString());
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("add").innerHTML =
      this.responseText;
    }
  };
  xhttp.open("GET", "/add", true);
  xhttp.send();
}