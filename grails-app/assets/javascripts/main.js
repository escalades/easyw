//= require jquery
//= require tabs/tabs_cookies
//= require fancybox/lib/jquery.mousewheel-3.0.6.pack
//= require fancybox/source/jquery.fancybox.pack
//= require_self

function onYouTubePlayerReady(playerId) {
    ytplayer = document.getElementById("ytplayer");
    console.log("sssssss");
    ytplayer.addEventListener("onStateChange", "onPlayerStateChange");

}
function onPlayerStateChange(newState) {
    alert("Player's new state: " + newState);
}
$(document).ready(function() {
    $(".fancybox").fancybox({
        closeBtn: true
    });
    return false
});