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
var ref = database.ref('Teams');

var team;
ref.on('value',gotdata,errdata);
var sel1 = document.getElementById('sel1');
var sel2 = document.getElementById('sel2');
function gotdata(data){
    //console.log(data.val());
    
   team = data.val();
    keys = Object.keys(team);
    console.log(keys);
    for(var i = 0;i<keys.length;i++){
        
        var k = keys[i];
        var teamname = team[k].Name;
        var opt1 = document.createElement('option');
    opt1.innerHTML = teamname;
    opt1.value = teamname;
    sel1.appendChild(opt1);
    var opt2 = document.createElement('option');
    opt2.innerHTML = teamname;
    opt2.value = teamname;
    sel2.appendChild(opt2);    
   
    }
    
}

function errdata(data){
    console.log("error");
}


  function showImage1() {
      
     var img1 = document.getElementById('image1'); 
    keys = Object.keys(team);

        for(var i = 0;i<keys.length;i++){
        
        var k = keys[i];
        teamname = team[k].Name;
        teamimage = team[k].Image;
            if(sel1.value==teamname){
                console.log(teamimage);
                img1.src=teamimage;
                
            }
    
    }

    }


 function showImage2() {
      
     var img2 = document.getElementById('image2'); 
    keys = Object.keys(team);

        for(var i = 0;i<keys.length;i++){
        
        var k = keys[i];
        teamname = team[k].Name;
        teamimage = team[k].Image;
            if(sel2.value==teamname){
                console.log(teamimage);
                img2.src=teamimage;
                
            }
    
    }

    }