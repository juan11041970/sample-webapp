println "Hello Groovy"

String url = 'http://api.icndb.com/jokes/random?limitTo=[nerdy]'
String jsonTxt = url.toURL().text
println jsonTxt
