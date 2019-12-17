var audio = document.getElementById('audio');
var totalProgress = $('.totalProgress');
var currentProgress = $('.currentProgress');
var currentTime = $('.currentTime');
var totalTime = $('.totalTime');
var timer;

$('.btn').on('click', function () {
    if (audio.paused) {
        audio.play();
        $('.play').css({'display': 'none'});
        $('.pause').css({'display': 'block'});
        timer = setInterval(function () {
            if (audio.ended) {
                $('.play').css({'display': 'block'});
                $('.pause').css({'display': 'none'});
            } else {
                currentTime.text(formatTime(audio.currentTime));
                totalTime.text(formatTime(audio.duration));
                var ratio = audio.currentTime / audio.duration;
                currentProgress.css({'width': ratio * 100 + '%'});
            }
        }, 100)
    } else {
        audio.pause();
        $('.play').css({'display': 'block'});
        $('.pause').css({'display': 'none'});
    }
});


totalProgress.on('click', function (ev) {
    var ratio = getRatio(ev);
    currentProgress.css({'width': ratio * 100 + '%'});
    audio.currentTime = audio.duration * ratio;
});

function getRatio(ev) {
    var totalWidth = totalProgress[0].offsetWidth;
    var totalX = totalProgress.offset().left;
    var mouseX = ev.clientX;
    var ratio = (mouseX - totalX) / totalWidth;
    return ratio;
}
function formatTime(time) {

    time = ~~time;
    var formatTime;
    if (time < 10) {
        formatTime = '00:0' + time;
    } else if (time < 60) {
        formatTime = '00:' + time;
    } else {
        var m = ~~(time / 60);
        if (m < 10) {
            m = '0' + m;
        }
        var s = time % 60;
        if (s < 10) {
            s = '0' + s;
        }
        formatTime = m + ':' + s;
    }
    return formatTime;
}



$(document).on("click","#volume",function(){
    document.getElementById("audio").volume = this.value/100;
});
$(document).on('click','tr',function(){
    //id="audio"
    var v=($(this).find("td").eq(2).text());
    $("#audio").attr("src",v);
});