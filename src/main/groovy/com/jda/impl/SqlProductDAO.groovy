package com.jda.impl

import com.jda.bo.GroovyProduct
import com.jda.bo.JavaProduct
import com.jda.dao.ProductDAO
import groovy.sql.Sql

class SqlProductDAO implements ProductDAO {

    Sql sql = Sql.newInstance("jdbc:mysql://localhost:3306/billtools", 'root', 'tobi2000')

    SqlProductDAO() {

        println "BEGINNING"

        sql.execute '''

        create table if not exists product (
          id int primary key AUTO_INCREMENT,
          name varchar(25),
          price double
        )
     '''

        sql.execute """

            insert into product (name, price) values
            ('baseball', 4.99),
            ( 'football', 14.95),
            ('basketball', 14.99)
        """

        println "DONE!!!"
    }

    static void main(String[] args) {

        SqlProductDAO dao = new SqlProductDAO()
        JavaProduct product = new JavaProduct('Basketball Net', 9.99)
        dao.insertProduct(product)

        def rows = dao.getAllProducts()
        println rows

    }

    List<JavaProduct> getAllProducts() {

        String sqlQuery = 'select * from product'

        def people = sql.rows( sqlQuery).collect { row ->
            new JavaProduct(row.collectEntries { k, v -> [k.toLowerCase(), v]})
        }

        people = sql.rows(sqlQuery).collect { it -> new GroovyProduct(it) }

        println "Done with get all products\n ${people}"
    }

    JavaProduct findProductById(int id) {
        return null
    }

    void insertProduct(JavaProduct p) {

        def params = [p.name,  p.price]
        sql.execute('insert into product(name, price) values(?, ?)', params)

        def row = sql.firstRow('select * from product where id = ?', 16)

        def pr = new JavaProduct(
                row.collectEntries { k, v ->  [ k.toLowerCase(), v]  }
        )

        println pr

    }

    void deleteProduct(int id) {

    }
}
