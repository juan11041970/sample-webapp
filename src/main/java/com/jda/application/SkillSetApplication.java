package com.jda.application;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SkillSetApplication {

    public SkillSetApplication() {

    }

    public static void main(String... args) throws IOException {
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("/Users/juaalvarado/Downloads/skill_sets.xml"));

            JAXBContext jc = JAXBContext.newInstance(SkillSets.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<SkillSets> je = unmarshaller.unmarshal(xsr, SkillSets.class);

            System.out.println(je.getName());
            System.out.println(je.getValue());
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//
//        String dataXml = FileUtils.readFileToString(new File("/Users/juaalvarado/Downloads/soap_response.xml"));
//
//        XStream xStream = new XStream();
//        xStream.processAnnotations(LoginResult.class);
//        LoginResult loginResult = new LoginResult();
//        loginResult.setErrorMessage("Error");
//        loginResult.setStatus("SUCCESS");

        //String dataXml = xStream.toXML(loginResult);

//        Object loginResult = xStream.fromXML(dataXml);

//        System.out.println(dataXml);
    }

    public static void print(final int number) {

        System.out.println("I am printing: " + number);
    }
}
