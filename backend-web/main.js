var config = {
  apiKey: "AIzaSyACMQ-svYix_njUCsVpy8k9zq_2ILamEGc",
  authDomain: "fireit-2d2fb.firebaseapp.com",
  databaseURL: "https://fireit-2d2fb.firebaseio.com",
  projectId: "fireit-2d2fb",
  storageBucket: "fireit-2d2fb.appspot.com",
  messagingSenderId: "222536224576"
};
firebase.initializeApp(config);
// var config = {
//     apiKey: "AIzaSyBPi2aTFGkheZThGXL8ar-grP7Dy8Zz4Uk",
//     authDomain: "projectkap-f30c0.firebaseapp.com",
//     databaseURL: "https://projectkap-f30c0.firebaseio.com",
//     projectId: "projectkap-f30c0",
//     storageBucket: "projectkap-f30c0.appspot.com",
//     messagingSenderId: "924041609143"
//   };
//   firebase.initializeApp(config);

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
  });
