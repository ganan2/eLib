function pushToContacts(username) {
  var xhttp = new XMLHttpRequest();
  //alert(username);
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("add").innerHTML =
      this.responseText;
    }
  };
  xhttp.open("GET", "/add?username=" + username, true);
  xhttp.send();
}