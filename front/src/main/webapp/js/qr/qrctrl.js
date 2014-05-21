// sample of function that may be registered as Callback.
function actQR( msg ){
	// msg comes null if no code were detected
	if( msg === null ){ //expect a lot of nulls
		console.log("no QR were read at this time")
	} else {
		// a valid QR reading, do something with it
		console.log(msg)
		window.location.href="http://google.com";
		// ask flash to stop parsing, this saves processing as webcam reading stop
		QR.stop()
	}
}

// sampe of function to be called when something goes wrong
function noWebcam( msg ){
	alert("Err!"+msg)
}

// this setInterval is a safe measure, so we don't call flash function before it is loaded;
var registerQRCb = setInterval(function(){
	//var nomeDoFlash = "QR"
	if( QR ){
		clearInterval(registerQRCb)
		// first param is the function signature we want the SWF to call periodicaly
		// second param is the intervall we want it, in miliseconds (default: half-second)
		// third is an signature for callback if something goes wrong, aka, user has no Webcam (default: null)
		QR.start( "actQR", 200, "noWebcam" )
	}
}, 100)