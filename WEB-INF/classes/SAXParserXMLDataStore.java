

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXParserXMLDataStore extends DefaultHandler {
    Product product;
    static HashMap<String, Product> products;
    Phone phone;
    static HashMap<String, Phone> phones;
    Smartwatch smartwatch;
    static HashMap<String, Smartwatch> smartwatches;
    Speaker speaker;
    static HashMap<String, Speaker> speakers;
    Headphone headphone;
    static HashMap<String, Headphone> headphones;
    Estorage storage;
    static HashMap<String, Estorage> storages;
    Accessory accessory;
    static HashMap<String, Accessory> accessories;
    HashMap<String, String> accessoryHashMap;
    String consoleXmlFileName;
    String elementValueRead;
    String currProd;


    public SAXParserXMLDataStore(String consoleXmlFileName) {
        this.consoleXmlFileName = consoleXmlFileName;
        products = new HashMap<String, Product>();
        phones = new HashMap<String, Phone>();
        smartwatches = new HashMap<String, Smartwatch>();
        speakers = new HashMap<String, Speaker>();
        headphones = new HashMap<String, Headphone>();
        storages = new HashMap<String, Estorage>();
        accessories = new HashMap<String, Accessory>();
        accessoryHashMap= new HashMap<String, String>();
        parseDocument();

    }


    private void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(consoleXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }







    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("laptop")) {
            product = new Product();
            product.setId(attributes.getValue("id"));
            product.setRetailer(attributes.getValue("retailer"));
              product.setType("laptop");
            currProd = "product";
        }

        if (elementName.equalsIgnoreCase("phone")) {
          product = new Product();
            product.setId(attributes.getValue("id"));
            product.setRetailer(attributes.getValue("retailer"));
            product.setType("phone");
            currProd = "product";
        }

        if (elementName.equalsIgnoreCase("watch")) {
          product = new Product();
            product.setId(attributes.getValue("id"));
            product.setRetailer(attributes.getValue("retailer"));
            product.setType("watch");
            currProd = "product";
        }

        if (elementName.equalsIgnoreCase("speaker")) {
          product = new Product();
            product.setId(attributes.getValue("id"));
            product.setRetailer(attributes.getValue("retailer"));
            product.setType("speaker");
            currProd = "product";
        }

        if (elementName.equalsIgnoreCase("headphone")) {
          product = new Product();
            product.setId(attributes.getValue("id"));
            product.setRetailer(attributes.getValue("retailer"));
            product.setType("headphone");
            currProd = "product";
        }

        if (elementName.equalsIgnoreCase("storage")) {
          product = new Product();
            product.setId(attributes.getValue("id"));
            product.setRetailer(attributes.getValue("retailer"));
            product.setType("storage");
            currProd = "product";
        }
        if (elementName.equalsIgnoreCase("separator")) {
          currProd="separator";
        }
        if (elementName.equalsIgnoreCase("accessory") && !currProd.equals("product") ) {
            accessory = new Accessory();
            accessory.setId(attributes.getValue("id"));
            accessory.setRetailer(attributes.getValue("retailer"));
              accessory.setType("accessory");
              System.out.println("accessory field loading");
            currProd = "accessory";
        }


    }

    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {


        if (element.equalsIgnoreCase("laptop")) {
            products.put(product.getId(),product);
	          return;
        }
        if (element.equalsIgnoreCase("phone")){
            products.put(product.getId(),product);
            return;
        }
        if (element.equalsIgnoreCase("watch")){
            products.put(product.getId(),product);
            return;
        }
        if (element.equalsIgnoreCase("speaker")){
            products.put(product.getId(),product);
            return;
        }
        if (element.equalsIgnoreCase("headphone")){
            products.put(product.getId(),product);
            return;
        }
        if (element.equalsIgnoreCase("storage")){
            products.put(product.getId(),product);
            return;
        }
        if (element.equalsIgnoreCase("separator")){
            return;
        }
        if (element.equalsIgnoreCase("accessory") && currProd.equalsIgnoreCase("accessory")){
              accessories.put(accessory.getId(),accessory);
          System.out.println(accessory.getId());
            return;
        }

        if(element.equalsIgnoreCase("accessory") && currProd.equalsIgnoreCase("product")){
          accessoryHashMap.put(elementValueRead,elementValueRead);
          System.out.println("accessory");
        }
        if(element.equalsIgnoreCase("accessories") && currProd.equalsIgnoreCase("product")){
          product.setAccessories(accessoryHashMap);
          accessoryHashMap=new HashMap<String,String>();
          return;
        }
      /*  if(element.equalsIgnoreCase("accessory") && currProd.equalsIgnoreCase("phone")){
          accessoryHashMap.put(elementValueRead,elementValueRead);
        }
        if(element.equalsIgnoreCase("accessories") && currProd.equalsIgnoreCase("phone")){
          phone.setAccessories(accessoryHashMap);
          accessoryHashMap=new HashMap<String,String>();
          return;
        }
        if(element.equalsIgnoreCase("accessory") && currProd.equalsIgnoreCase("watch")){
          accessoryHashMap.put(elementValueRead,elementValueRead);
        }
        if(element.equalsIgnoreCase("accessories") && currProd.equalsIgnoreCase("watch")){
          smartwatch.setAccessories(accessoryHashMap);
          accessoryHashMap=new HashMap<String,String>();
          return;
        }
        if(element.equalsIgnoreCase("accessory") && currProd.equalsIgnoreCase("speaker")){
          accessoryHashMap.put(elementValueRead,elementValueRead);
        }
        if(element.equalsIgnoreCase("accessories") && currProd.equalsIgnoreCase("speaker")){
          speaker.setAccessories(accessoryHashMap);
          accessoryHashMap=new HashMap<String,String>();
          return;
        }
        if(element.equalsIgnoreCase("accessory") && currProd.equalsIgnoreCase("headphone")){
          accessoryHashMap.put(elementValueRead,elementValueRead);
        }
        if(element.equalsIgnoreCase("accessories") && currProd.equalsIgnoreCase("headphone")){
          headphone.setAccessories(accessoryHashMap);
          accessoryHashMap=new HashMap<String,String>();
          return;
        }
        if(element.equalsIgnoreCase("accessory") && currProd.equalsIgnoreCase("storage")){
          accessoryHashMap.put(elementValueRead,elementValueRead);
        }
        if(element.equalsIgnoreCase("accessories") && currProd.equalsIgnoreCase("storage")){
          storage.setAccessories(accessoryHashMap);
          accessoryHashMap=new HashMap<String,String>();
          return;
        }*/


        if (element.equalsIgnoreCase("image")) {
          if(currProd.equals("product"))
            product.setImage(elementValueRead);
          /*if(currProd.equals("phone"))
            phone.setImage(elementValueRead);
          if(currProd.equals("watch"))
            smartwatch.setImage(elementValueRead);
          if(currProd.equals("speaker"))
            speaker.setImage(elementValueRead);
          if(currProd.equals("headphone"))
            headphone.setImage(elementValueRead);
          if(currProd.equals("storage"))
            storage.setImage(elementValueRead);*/
          if(currProd.equals("accessory"))
              accessory.setImage(elementValueRead);

	    return;
        }
        if (element.equalsIgnoreCase("name")) {
          if(currProd.equals("product"))
            product.setName(elementValueRead);
          /*if(currProd.equals("phone"))
            phone.setName(elementValueRead);
          if(currProd.equals("watch"))
            smartwatch.setName(elementValueRead);
          if(currProd.equals("speaker"))
            speaker.setName(elementValueRead);
          if(currProd.equals("headphone"))
            headphone.setName(elementValueRead);
          if(currProd.equals("storage"))
            storage.setName(elementValueRead);*/
          if(currProd.equals("accessory"))
            accessory.setName(elementValueRead);
	    return;
        }


  /*      if(element.equalsIgnoreCase("accessory")){
          if(currProd.equals("laptop"))
           laptop.getAccessories().add(elementValueRead);
           if(currProd.equals("phone"))
             phone.getAccessories().add(elementValueRead);

	    return;
    }*/
        if(element.equalsIgnoreCase("price")){
          if(currProd.equals("product"))
            product.setPrice(Double.parseDouble(elementValueRead));
          /*if(currProd.equals("phone"))
            phone.setPrice(Double.parseDouble(elementValueRead));
          if(currProd.equals("watch"))
            smartwatch.setPrice(Double.parseDouble(elementValueRead));
          if(currProd.equals("speaker"))
            speaker.setPrice(Double.parseDouble(elementValueRead));
          if(currProd.equals("headphone"))
            headphone.setPrice(Double.parseDouble(elementValueRead));
          if(currProd.equals("storage"))
            storage.setPrice(Double.parseDouble(elementValueRead));*/
          if(currProd.equals("accessory"))
                accessory.setPrice(Double.parseDouble(elementValueRead));
	    return;
    }

    if(element.equalsIgnoreCase("quantity")){
          if(currProd.equals("product"))
            product.setQty(Integer.parseInt(elementValueRead));
          /*if(currProd.equals("phone"))
            phone.setQty(Integer.parseInt(elementValueRead));
          if(currProd.equals("watch"))
            smartwatch.setQty(Integer.parseInt(elementValueRead));
          if(currProd.equals("speaker"))
            speaker.setQty(Integer.parseInt(elementValueRead));
          if(currProd.equals("headphone"))
            headphone.setQty(Integer.parseInt(elementValueRead));
          if(currProd.equals("storage"))
            storage.setQty(Integer.parseInt(elementValueRead));*/
          if(currProd.equals("accessory"))
                accessory.setQty(Integer.parseInt(elementValueRead));
	    return;
    }

    if (element.equalsIgnoreCase("rebate")) {
          if(currProd.equals("product"))
            product.setRebate(elementValueRead);
          /*if(currProd.equals("phone"))
            phone.setRebate(elementValueRead);
          if(currProd.equals("watch"))
            smartwatch.setRebate(elementValueRead);
          if(currProd.equals("speaker"))
            speaker.setRebate(elementValueRead);
          if(currProd.equals("headphone"))
            headphone.setRebate(elementValueRead);
          if(currProd.equals("storage"))
            storage.setRebate(elementValueRead);*/
          if(currProd.equals("accessory"))
            accessory.setRebate(elementValueRead);
	    return;
        }

       if (element.equalsIgnoreCase("sale")) {
          if(currProd.equals("product"))
            product.setSale(elementValueRead);
          /*if(currProd.equals("phone"))
            phone.setSale(elementValueRead);
          if(currProd.equals("watch"))
            smartwatch.setSale(elementValueRead);
          if(currProd.equals("speaker"))
            speaker.setSale(elementValueRead);
          if(currProd.equals("headphone"))
            headphone.setSale(elementValueRead);
          if(currProd.equals("storage"))
            storage.setSale(elementValueRead);*/
          if(currProd.equals("accessory"))
            accessory.setSale(elementValueRead);
      //currProd=" ";
	    return;
        }





    }

    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }



    public static void addHashMap() {
        String TOMCAT_HOME = System.getProperty("catalina.home");
        new SAXParserXMLDataStore(TOMCAT_HOME+"\\webapps\\csj\\ProductCatalog.xml");

    }

}
