package nz.ac.massey.cs.sdc.parserss;

import java.io.*;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

class main {
    public static void main(String[] args) throws JAXBException {
        parsing();
    }
    public static void parsing() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("nz.ac.massey.cs.sdc.parserss");
        Unmarshaller parser = jc.createUnmarshaller();
        File file = new File("nzhrsscid_000000005.xml");
        Rss rss = (Rss) parser.unmarshal(file);
        RssChannel rssChannel = rss.getChannel();
        List<RssItem> list = rssChannel.getItem();
        for (RssItem item : list) {

            List list1 = item.getTitleOrDescriptionOrLink();
            for (Object o : list1) {
                JAXBElement element = (JAXBElement) o;
                String string = element.getName().getLocalPart();
                if (string.equals("title")) {
                    System.out.println("title:" + element.getValue());
                } else if (string.equals("link")) {
                    System.out.println("link" + element.getValue());
                } else if (string.equals("description")) {
                    System.out.println("description" + element.getValue());
                    System.out.println();
                }


            }
        }
    }
}
