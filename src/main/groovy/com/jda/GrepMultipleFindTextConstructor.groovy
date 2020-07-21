package com.jda

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection

class GrepMultipleFindTextConstructor {

    static void main (String ... args) {

        File sourceFile = new File("/Users/juaalvarado/pg_tracking_id.txt")
        def content = sourceFile.collect {it}
        def contentSize = content.size()

        assert (content instanceof  java.util.ArrayList)

        def strBuiler = new StringBuilder()
        strBuiler.append("/usr/xpg4/bin/grep E -e '")

        sourceFile.eachLine ( { line, nb ->
//            println line

            if (nb != contentSize) {
                strBuiler.append(line).append("|")
            }
        })

        strBuiler.append("'")

        def grepCommand = strBuiler.toString()

        //Copy to clipboard
        Toolkit toolkit = Toolkit.getDefaultToolkit()
        Clipboard clipboard = toolkit.getSystemClipboard()
        StringSelection strSel =  new StringSelection(grepCommand)
        clipboard.setContents(strSel, null)
    }
}
