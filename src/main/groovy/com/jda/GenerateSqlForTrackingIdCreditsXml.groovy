package com.jda

import groovy.util.slurpersupport.GPathResult
import org.hibernate.pretty.Formatter

class GenerateSqlForTrackingIdCreditsXml {

    def static querySql = """
                select account_no, tracking_id, request_status, transact_date, review_date, 
                    supervisor_name, last_reviewed_name, total_amt 
                from adj 
                where tracking_id in (inClauseValues) 
                and (last_reviewed_name = 'LAST_REVIEW' or  last_reviewed_name = 'yeligb')
                """
    def static  lastReviewer
    def static trackingIds
    def static fileNameBaseDir
    def static fileNameBase

    static void main(String... args) {

        this.fileNameBaseDir = System.getProperty("fileNameBaseDir")
        this.fileNameBase = System.getProperty("fileNameBase")

        println "***Processing all tracking ids***\n"
        processAllTrackingIds()

//        println "***Processing bad tracking ids***\n"
//        processBadTrackingIds()
    }

    static void processAllTrackingIds() {

//        String fullFilePath = this.fileNameBaseDir + fileNameBase + ".xml"
//        String xmlSource = new File(fullFilePath).text

        def fileNameBaseDir = System.getProperty("fileNameBaseDir")
        def baseDir = new File(fileNameBaseDir + "/request")
        def files = baseDir.listFiles()

        files.each { f ->

            if (f.name.endsWith(".xml")) {

                def xmlSource = f.getText()
                GPathResult xmlContent = new XmlSlurper().parseText(xmlSource)
                assert xmlContent instanceof groovy.util.slurpersupport.GPathResult
                def xmlContentSize = xmlContent.ModifyAdjustment.size()
                println "Processing: ${xmlContentSize} tracking ids"

                def xmlRange = 0..xmlContentSize - 1

                groovy.util.slurpersupport.NodeChildren csrId = xmlContent.CsrId
                lastReviewer = csrId.text()

                def inClauseValues = new StringBuilder()
                for (n in xmlRange) {
                    def currTrackingId = xmlContent.ModifyAdjustment[n].AdjustmentIDInfo.TrackingId
                    inClauseValues.append("$currTrackingId").append(",")
                }

                trackingIds = inClauseValues.toString()
                generateSqlForTrackingIds(f.getName(), baseDir)
            }
        }
        println "\n"
    }

    static void generateSqlForTrackingIds(fileName, baseDir) {

        //format the sql
        querySql = new Formatter(querySql).format()
        trackingIds = trackingIds.replaceAll(",\$", "")
        querySql = querySql.replaceAll("LAST_REVIEW", lastReviewer)

        def baseDirPath = baseDir.getPath()
        File newFile = new File(baseDirPath  + "/" +  fileName.substring(0, fileName.indexOf(".")) + ".sql")

        String sqlContent = querySql.replaceAll("inClauseValues", trackingIds)

        newFile.append(fileName.getBytes())
        newFile.append(sqlContent.getBytes())

        newFile.createNewFile()

    }

    static void processBadTrackingIds() {

        String fullFilePath = this.fileNameBaseDir + fileNameBase + ".csv"
        String csvSource = new File(fullFilePath).text
        //println csvSource

        def trackIds = trackingIds.tokenize(",")
        def listSize = trackIds.size()
        def listRange = 0..listSize - 1
        def inClauseValues = new StringBuilder()

        for (n in listRange) {

            def pos = csvSource.indexOf(trackIds[n])
            if (pos == -1) {

                def currTrackingId = trackIds[n]
//                println "Found bad tracking id: "  + currTrackingId
                inClauseValues.append(currTrackingId).append(",")
            }
        }
        trackingIds = inClauseValues.toString()
        generateSqlForTrackingIds()

        println "\n"
    }
}
