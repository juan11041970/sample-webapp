package com.jda

class ParseJdkUtilScript {

    static void main(String... argss) {
        println 'Beginning read...'

        ParseJdkUtilScript parser = new ParseJdkUtilScript()

        parser.readAllJavaFiles()

        println 'Done processing files'
    }

    def readAllJavaFiles() {


        File javaFiles = new File('/Users/juaalvarado/Documents/GitHub/csapimigration/SharedBillingDomain/src/main/java')
        javaFiles.eachDirRecurse { dir ->

            dir.eachFileMatch(~/.*.java/) { file ->

                processFile(file)
            }
        }
    }

    def processFile(File inFile) {

        //String source = 'Logger.getInstance(JdkUtil.forceInit(RtpRuleEngineCompiledImpl.class))'
        //File inFile =  new File('/Users/juaalvarado/Documents/GitHub/csapimigration/SharedBillingDomain/src/main/java/com/ebay/domain/sharedbilling/svc/paypal/api/PayPalCNPaymentNotifier.java')
        String source =  inFile.getText('UTF-8').trim()
        String regexpPattern = "JdkUtil.forceInit\\(([a-zA-Z_0-9]*.class)\\)"
        String replaced = source.replaceFirst(regexpPattern, '$1')

        File out = new File(inFile.getAbsolutePath()).withWriter('UTF-8') { writer ->

            writer.writeLine(replaced)
        }
    }
}
