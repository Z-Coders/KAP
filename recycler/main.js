var config = {
   apiKey: "AIzaSyCMa_B3hyAbDVIbQvsoophZt3R8SFq6doM",
    authDomain: "showdata-14add.firebaseapp.com",
    databaseURL: "https://showdata-14add.firebaseio.com",
    projectId: "showdata-14add",
    storageBucket: "showdata-14add.appspot.com",
    messagingSenderId: "1002472154548"
};
firebase.initializeApp(config);
var database = firebase.database();
var ref = database.ref('User_Details')




document.querySelector('#upload').addEventListener('click',function(){
    var team = document.querySelector('#team').value;
var imageUrl = document.querySelector('#ImageURL').value;
    var data;
    data = {
        Image_Title:team,
        Image_URL:imageUrl
    }
       var item = ref.push();
    item.setWithPriority(data, 0 - Date.now())
    console.log(data)
      });