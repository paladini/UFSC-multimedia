<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<regionBase id="regionBase0">
			<region height="100.00%" id="rgTV" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="50.00%" id="rgVideo" left="25.00%" top="25.00%" width="50.00%" zIndex="2">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dscVideo" region="rgVideo">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="dscVideo" id="video" src="media/video1.mpg" type="video/mpeg">
		</media>
		<port component="video" id="port1">
		</port>
	</body>
</ncl>
