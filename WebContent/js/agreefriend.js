function search () {
    var search_text = document.getElementById('content').value.match(/\S+/g);
     // get the single word
    for(var i = user_list.length - 1; i >= 0; -- i) {
        if (!containAmongArr(user_list[i].name, search_text)) {
            user_list[i].removeSelf();
        }
    }
}

function containAmongArr(str, arr) {
    for (var i = arr.length - 1; i >= 0; -- i) {
        if (str.indexOf(arr[i]) != -1) {
            return true;
        }
    }
    return false;
}

var liTags = document.getElementById('demo').children;
var user_list = []; // some objects in it to illustrate every user list
for (var i = liTags.length - 1; i >= 0; -- i) {
    var text = liTags[i].getElementsByTagName('text')[0],
        btn = liTags[i].getElementsByTagName('button')[0],
        refbtn = liTags[i].getElementsByTagName('button')[1];
    var obj = {
        "name": text.innerHTML,
        "removeSelf": function(that){ return function () { that.parentNode.removeChild(that); }}(liTags[i])
        // closure
    };
    user_list.push(obj);
    
    // closure
    btn.onclick = function(str){
        return function() {
        	agreeFriend(str);
        };
    }(text.innerHTML);
    
    refbtn.onclick = function(str){
        return function() {
        	refuseFriend(str);
        };
    }(text.innerHTML);
}

function agreeFriend(str) {
    window.alert("The reapply to " + str + " for friend has been sent successfully!");
    window.location="AgreeFriend?friendname=" + str;
}

function refuseFriend(str) {
    window.alert("The reapply to " + str + " for friend has been sent successfully!");
    window.location="RefuseFriend?friendname=" + str;
}