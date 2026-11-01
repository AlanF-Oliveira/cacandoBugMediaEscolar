import spock.lang.Specification

class BoletimSpec extends Specification {
    private final script = new GroovyShell().parse(
        new File('src/main/groovy/Boletim.groovy')
    )

    def "calcula a média considerando todas as notas"() {
        expect:
        script.calcularMedia([8.0, 7.5, 9.0]) == 8.166666666666667
    }

    def "aprova média exatamente igual à nota de aprovação"() {
        expect:
        script.situacao(7.0, 7.0, 5.0) == 'Aprovado'
    }

    def "classifica média exatamente igual ao limite como recuperação"() {
        expect:
        script.situacao(5.0, 7.0, 5.0) == 'Recuperação'
    }
}
