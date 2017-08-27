var config = {
   apiKey: "AIzaSyCMa_B3hyAbDVIbQvsoophZt3R8SFq6doM",
    authDomain: "showdata-14add.firebaseapp.com",
    databaseURL: "https://showdata-14add.firebaseio.com",
    projectId: "showdata-14add",
    storageBucket: "showdata-14add.appspot.com",
    messagingSenderId: "1002472154548"
};
firebase.initializeApp(config);

  firebase.auth().onAuthStateChanged(function(user) {
    if (user) {
      document.querySelector('#login').addEventListener('click',function(){
        var href='landing.html';
        window.open(href);
      });
console.log("user is logged in")

}

  });
  document.querySelector('#login').addEventListener('click', function(e) {
    e.preventDefault();
    e.stopPropagation();
    var email = document.querySelector('#email').value;
    var password = document.querySelector('#password').value
    var credential = firebase.auth.EmailAuthProvider.credential(email, password);
    var auth = firebase.auth();
    var currentUser = auth.currentUser;

firebase.auth().signInWithEmailAndPassword(email,password)
.catch(function (err) {
 console.log("error")

});
  });
    document.querySelector('#signout').addEventListener('click', function(e) {
    e.preventDefault();
    e.stopPropagation();
    firebase.auth().signOut();
        console.log("signedout")
  });
