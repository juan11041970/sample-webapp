import spock.lang.Specification
import spock.lang.Unroll

class HelloSpock extends Specification {

    @Unroll
    def "#name should be #length"() {

        expect:
        name.size() == length

        where:
        name    |   length
        "Spock" |   5
        "Kirk"  |   4
    }

    def "check lengths using arrays"() {

        expect: name.size() == length

        where:
        name << ["Spock", "Kirk", "Scotty"]
        length << [5, 4, 6]
    }

    def "check lenghts using pairs"() {

        expect: name.size() == length

        where:
        [name, length] << [["Spock", 5], ["Kirk", 4], ["Scotty", 6]]
    }

    def "test spock stack"() {
        def stack = new Stack()

        when:
        stack.pop()

        then:
        EmptyStackException e = thrown()
        e.cause == null
    }
}
