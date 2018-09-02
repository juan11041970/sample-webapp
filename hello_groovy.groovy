println "Hello Groovy"

String url = 'http://api.icndb.com/jokes/random?limitTo=[nerdy]'
String jsonTxt = url.toURL().text
println jsonTxt

def site = 'http://espn.com'.toURL().text
println "site is ${site}"

def num = Math.min(10, 100)
println "Number is ${num}"
