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
        btn = liTags[i].getElementsByTagName('button')[0];
    var obj = {
        "name": text.innerHTML,
        "removeSelf": function(that){ return function () { that.parentNode.removeChild(that); }}(liTags[i])
        // closure
    };
    user_list.push(obj);
    
    // closure
    btn.onclick = function(str){
        return function() {
            addFriend(str);
        };
    }(text.innerHTML);
}

function addFriend(str) {
    window.alert("The apply to " + str + " for friend has been sent successfully!");
    window.location="AddFriend?friendname=" + str;
}