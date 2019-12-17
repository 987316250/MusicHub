<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>音乐播放器</title>
    <link rel="stylesheet" href="../css/audioPlayer.css"/>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body>
<div class="top-bar">
    <h1 class="logo">
        <a  >MUSIC HUB</a>
    </h1>
    <ul >
        <li><a href="" >Home</a></li>
        <li><a href="" >Explore</a></li>
        <li><a href="" >About</a></li>
    </ul>
</div>
<div class="container">
    <form >
        <input  type="text" placeholder="请输入歌名" value="" id="in"/>
        <button class="btn btn-primary" type="button" style="width: 100px" id="search">Search</button>
    </form>
</div>
<div class="User">
    <div class="pic">
        <img src="../images/user/head.jpg" >
    </div>
</div>
<div class="audioPlayer">
    <div class="time">
        <span class="currentTime">00:00</span>
        /
        <span class="totalTime">00:00</span>
    </div>
    <div class="btn">
        <img src="../images/play.png" class="play" alt=""/>
        <img src="../images/pause.png" class="pause" alt=""/>
    </div>
    <audio id="audio" ></audio>
    <!--        播放歌曲在这里-->
    <div class="totalProgress">
        <div class="currentProgress">
        </div>
    </div>

</div>
<div class="Voice">
    <input id="volume" type="range" min="0" max="100" value="40">
</div>
<div class="MusicList">
    <div>
        <table>
            <tr>
                <td width="200px">
                    <span>歌曲名</span>
                </td>
                <td width="100px">
                    <span>歌手</span>
                </td>
                <td style="display: none" width="100px">
                    <span>路径</span>
                </td>
                <td width="100px">
                    <span>歌曲种类</span>
                </td>
            </tr>
            <tbody id="tb">
            </tbody>


        </table>
    </div>
</div>
</body>
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="../js/audioPlayer.js"></script>
<script src="../js/loadMusic.js"></script>
</html>
