import com.jda.Department
import com.jda.Employee
import com.jda.SmartPhone
import org.junit.Test
import spock.lang.*

class DepartmentTest extends Specification {

    private Department dept

    def setup() {
        dept = new Department(name: 'IT')
    }

    def "add employee to dept should increase total by 1"() {

        given: Employee fred = new Employee(name: 'Fred', id: 1)

        when: dept = dept + fred

        then:
        dept.employees.size() == old(dept.employees.size() + 1)
    }

    def "add two employees via chained plus"() {

        given:
        Employee fred = new Employee(name: 'Fred', id: 1)
        Employee barney = new Employee(name: 'Barney', id: 2)

        when:
        dept = dept + fred + barney

        then:
        dept.getEmployees().size() == 2

    }

    def "remove two employees vi chained minus"() {

        given:
        Employee fred = new Employee(name: 'Fred', id: 1)
        Employee barney = new Employee(name: 'Barney', id: 2)

        when: dept = dept - fred - barney

        then: dept.employees.size() == 0
    }

    def "left shift should increase employee total by 1"() {

        given:
        Employee fred = new Employee(name: 'Fred', id: 1)

        when:
        dept = dept << fred

        then:
        dept.employees.size() == old(dept.employees.size() + 1)
    }

    def "add two employees with left shift"() {

        given:
        Employee fred = new Employee(name: 'Fred', id: 1)
        Employee barney = new Employee(name: 'Barney', id: 2)

        when:
        dept = dept << fred << barney

        then:
        dept.employees.size() == old(dept.employees.size() + 2)


    }
}
