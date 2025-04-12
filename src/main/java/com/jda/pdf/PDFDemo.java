package com.jda.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.pdfcleanup.autosweep.CompositeCleanupStrategy;

import java.io.IOException;

public class PDFDemo {
    public static void main(String[] args) throws IOException {
        PdfReader reader = new PdfReader("/Users/juanalvarado/Downloads/last-paycheck.pdf");
        CompositeCleanupStrategy strategy = new CompositeCleanupStrategy();

        //PdfWriter writer = new PdfWriter("src/main/resources/baeldung-modified.pdf");
        //PdfDocument pdfDocument = new PdfDocument(reader, writer);
        //addContentToDocument(pdfDocument);
        //pdfDocument.close();

        assert  reader != null;
    }

}
