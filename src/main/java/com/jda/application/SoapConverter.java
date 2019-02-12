package com.jda.application;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.ws.rs.core.Response;
import javax.xml.bind.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.FileReader;

public class SoapConverter {
    public static void main(String[] args) throws Exception{
//        XMLInputFactory xif = XMLInputFactory.newFactory();
//        XMLStreamReader xsr =
//                xif.createXMLStreamReader(new FileReader("/Users/juaalvarado/Downloads/soap_response2.xml"));
//        xsr.nextTag(); // Advance to Envelope tag
//        xsr.nextTag(); // Advance to Body tag
//        xsr.nextTag(); // Advance to getNumberResponse tag
//        System.out.println(xsr.getNamespaceContext().getNamespaceURI("ns"));
//
//        JAXBContext jc = JAXBContext.newInstance(Response.class);
//        Unmarshaller unmarshaller = jc.createUnmarshaller();
//        JAXBElement<Response> je = unmarshaller.unmarshal(xsr, Response.class);
//        System.out.println(je.getName());
//        System.out.println(je.getValue());

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.parse(new File("/Users/juaalvarado/Downloads/soap_response2.xml"));

        NodeList nList = d.getElementsByTagName("errorMessage");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            System.out.println("\nCurrent Element: " + nNode.getNodeName());
        }

//        JAXBContext jc = JAXBContext.newInstance(Response.class);
//        Unmarshaller unmarshaller = jc.createUnmarshaller();
//        JAXBElement<Response> je = unmarshaller.unmarshal(new DOMSource(getNumberResponseElt), Response.class);
//        System.out.println(je.getName());
//        System.out.println(je.getValue());
    }

}
