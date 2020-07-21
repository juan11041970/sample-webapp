package com.jda

import groovy.util.slurpersupport.GPathResult

class GetASFJobResultsFromFiler {

    static int totalResponses = 0
    static int totalNotInDispute = 0
    static int totalASAQueueFull = 0
    static int totalSuccess = 0
    static int totalNoDescription = 0
    static def accountsWithNoErrorDescription = []
    static int totalTrackingIdsNoDescription = 0
    static def trackingIdsWithNoErrorDescription = []

    static void main(String... args) {

        def fileName = System.getProperty("fileName")
        def fileNameBaseDir = System.getProperty("fileNameBaseDir")


        println fileNameBaseDir + "\n"
        processResponse()

        println "\n\n************************************************************************************"

        println "Processed ${totalResponses} responses"
        println "${totalNotInDispute} credits are not in dispute state"
        println "${totalASAQueueFull} credits returned Code: 1 BILL-ASA QUEUE FUL"
        println "${totalSuccess} credits returned Code: 0"
        println "${totalNoDescription} credits returned Code: 1 NO DESCRIPTION"
        println "${totalTrackingIdsNoDescription} tracking ids returned Code: 1 NO DESCRIPTION"
        println accountsWithNoErrorDescription
        println trackingIdsWithNoErrorDescription

    }

    //TODO: Figure out a way to connect to filer URL
    static def processResponse() {

//        println url
        def baseDirForFilerJobs = System.getProperty("baseDirForFilerJobs")

        def baseDir = new File(baseDirForFilerJobs + "/response")
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
            def trackingId = content.ModifyAdjustment.AdjustmentIDInfo.TrackingId
            def code = content.AdjustmentResult.Code
            String description = content.AdjustmentResult.Description

            code == 0 ? codeZeroCount++ : codeOneCount++

            if(code == 1) {
                println "Found Code ${code} with description ${description}"

                if (description != null && description.contains("is not in DISPUTE state")) {

                    totalNotInDispute++;
                } else if (description != null && description.contains("BILL-ASA QUEUE FUL")) {

                    totalASAQueueFull++
                } else {
                    accountsWithNoErrorDescription << accountId
                    trackingIdsWithNoErrorDescription << trackingId
                    totalNoDescription++
                    totalTrackingIdsNoDescription++
                }
            } else if (code == 0) {
                totalSuccess++
            }

            totalResponses++
        }

//        println "Processed file ${file}"
        println "For file ${file.getName()} there are ${codeZeroCount} Code 0 and ${codeOneCount} Code 1"

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
