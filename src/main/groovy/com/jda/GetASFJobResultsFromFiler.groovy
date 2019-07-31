package com.jda

import groovy.util.slurpersupport.GPathResult

class GetASFJobResultsFromFiler {

    static int totalResponses

    static void main(String... args) {

        def fileName = System.getProperty("fileName")
        def fileNameBaseDir = System.getProperty("fileNameBaseDir")
        def fullPath = fileNameBaseDir + fileName


        println fileNameBaseDir + "\n"
        println fullPath + "\n"
        processResponse()

        println "Processed ${totalResponses} responses"

    }

    //TODO: Figure out a way to connect to filer URL
    static def processResponse() {

//        println url
        def baseDirForFilerJobs = System.getProperty("baseDirForFilerJobs")

        def baseDir = new File(baseDirForFilerJobs)
        def files = baseDir.listFiles()

        println "There are ${files.length} files to process"


        files.each { f ->
            processFile(f)
        }
    }

    static def processFile(file) {

        def fileContent = file.getText()


        GPathResult xmlContent = new XmlSlurper().parseText(fileContent)
        assert xmlContent instanceof groovy.util.slurpersupport.GPathResult

        def adjResultsCount = xmlContent.ModifyAdjustmentResult.size()
        def totalRequestCount = 0
        def codeZeroCount = 0
        def codeOneCount = 0

        //println "There are ${adjResultsCount} to process"

        xmlContent.ModifyAdjustmentResult.each { content ->

            //processContent(content)
            def accountId = content.ModifyAdjustment.AccountIdentity.Id
            def code = content.AdjustmentResult.Code
            def description = content.AdjustmentResult.Description

            code == 0 ? codeZeroCount++ : codeOneCount++

            if(code == 0) {
//                println "Account ID: ${accountId} has Code ${code} with description ${description}"
            }

            totalResponses++
        }

//        println "Processed file ${file}"
        println "For file ${file.getName()} there are ${codeZeroCount} Code 0 (SUCCESS) and ${codeOneCount} Code 1 (FAILURE)"

    }

    static def processContent(modifyAdjResultTag) {

        def accountId = modifyAdjResultTag.ModifyAdjustment.AccountIdentity.Id
        def code = modifyAdjResultTag.AdjustmentResult.Code
        def description = modifyAdjResultTag.AdjustmentResult.Description


        println """
            Account ID: ${accountId} - Code: ${code} Description: ${description}
            """
    }
}
