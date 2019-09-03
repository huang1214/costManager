<!doctype html>
<html>
	<head>
	<meta charset="utf-8">
	<title>Video</title>
        <script src="${ctx!}/css/video-js.css"></script>
	<link href="${ctx!}/css/video-js.css" rel="stylesheet">
	<style>
body {
	background-color: #191919
}
.m {
	width: 740px;
	height: 400px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 100px;
}
</style>
	</head>
	<body>
    <div class="m">
	<video id="my-video" class="video-js vjs-default-skin" controls preload="none"  width="740" height="400" data-setup="{}">
		<source src="${url}" type="video/mp4">
	</video>
	<script src="${ctx!}/js/video.min.js"></script>
      <script type="text/javascript">
			var myPlayer = videojs('my-video');
			videojs("my-video").ready(function(){
				var myPlayer = this;
				myPlayer.play();
			});
		</script> 
    </div>
</body>
</html>
