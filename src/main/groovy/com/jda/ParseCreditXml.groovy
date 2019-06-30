package com.jda

import groovy.util.slurpersupport.GPathResult
import org.hibernate.pretty.Formatter

class ParseCreditXml {

    static void main(String... args) {


        String xmlSource = new File("/Users/juaalvarado/Desktop/filer-jobs/Request938600944_301921974.xml").text

        GPathResult xmlContent = new XmlSlurper().parseText(xmlSource)
        assert xmlContent instanceof groovy.util.slurpersupport.GPathResult
        //assert xmlContent.ModifyAdjustment[0].AdjustmentIDInfo.TrackingId == '339675096'

        def xmlContentSize = xmlContent.ModifyAdjustment.size()

        def xmlRange = 0..xmlContentSize - 1
        def querySql = """
                select account_no, tracking_id, request_status, transact_date, review_date, supervisor_name, last_reviewed_name, total_amt from adj where tracking_id in (inClauseValues)
                """
        def inClauseValues = new StringBuilder()
        for (n in xmlRange) {
            def currTrackingId = xmlContent.ModifyAdjustment[n].AdjustmentIDInfo.TrackingId
            inClauseValues.append("$currTrackingId").append(",")
        }

        def allTrackingIds = inClauseValues.toString()
        allTrackingIds = allTrackingIds.replaceAll(",\$", "")

        //format the sql
        querySql = new Formatter(querySql).format()
        println querySql.replaceAll("inClauseValues", allTrackingIds)
    }
}
