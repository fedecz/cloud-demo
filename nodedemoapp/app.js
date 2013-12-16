var http = require('http');
var os = require( 'os' );

function getIPAddress() {
   var networkInterfaces = os.networkInterfaces();
   for(var ni in networkInterfaces) {
      var niArray = networkInterfaces[ni];
      for (var i = 0; i < niArray.length; i++) {
         var niObj = niArray[i];
         if (niObj.internal === false) {
            return niObj.address;
         }
      }
   }
   throw "IP address not found :(";
}

http.createServer(function (req, res) {
   var ip = getIPAddress();
   res.writeHead(200, {"Content-Type": "text/plain"});
   res.end("Actual server ip = "+ip);
}).listen(3001);

console.log('Listening at port 3001');
