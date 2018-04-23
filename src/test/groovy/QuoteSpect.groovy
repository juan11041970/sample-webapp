import spock.lang.Specification

class QuoteSpect extends Specification {

    String quote = """I am endeavoring, ma'am, to construct a
        mnemonic memory circuit, using stone knives and bear skins."""

    List<String> strings

    def setup() {
        strings = quote.tokenize(" ,.")
    }

    def "adding a word increases total by 1"() {
        when: strings << 'Fascinating'
        then: strings.size() == old(strings.size() + 1)
    }
}
