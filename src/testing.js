function httpGet(theUrl)
{
    var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl); // false for synchronous request
    xmlHttp.send();
    return xmlHttp.responseText;
}
// console.log(httpGet("https://google.com"))
console.log(httpGet("http://liuruiping.com:80"))
// console.log("abc")