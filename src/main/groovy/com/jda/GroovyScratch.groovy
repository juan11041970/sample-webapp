package com.jda

import java.awt.BorderLayout as BL
import javax.swing.WindowConstants as WC
import groovy.swing.SwingBuilder
import javax.swing.ImageIcon

class GroovyScratch {

    static void main(String[] args) {
        def strings = ['this','is','a','list','of','strings']
        Collections.sort(strings, {s1,s2 -> s2.size() - s1.size()} as Comparator)
        assert strings*.size() == [7, 4, 4, 2, 2, 1]

        print(strings)

        Collections.sort(strings);
        print("\n")
        print(strings)
        print("\n")

        strings.sort {it?.size() }
        println strings

        String base = 'http://chart.apis.google.com/chart?'
        def params = [cht:'p3',chs:'250x100',chd:'t:60,40',chl:'Hello|World']

       String queryString = params.collect { k,v -> "$k=$v" }.join('&')
        println queryString

        params.each { k,v ->
            assert queryString.contains("$k=$v")
        }

        SwingBuilder.edtBuilder {
            frame(title:'Hello, Chart!', pack: true,

                    visible:true, defaultCloseOperation:WC.EXIT_ON_CLOSE) {
                label(icon:new ImageIcon("$base$queryString".toURL()),

                        constraints:BL.CENTER)
            }
        }

    }
}

