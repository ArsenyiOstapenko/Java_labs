import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMFactory {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(new File("XmlExRates.aspx.xml"));

        NodeList currencyNodeList = document.getElementsByTagName("Currency"); // Получение списка всех элементов employee внутри корневого элемента
        ArrayList<Currency> currencyList = new ArrayList<>(); // создаем список валют на основе описанного уже нами класса
        Element currElement = (Element) document.getElementsByTagName("DailyExRates").item(0);
        String date = currElement.getAttribute("Date");
        System.out.println("Date = " + date);


        for (int i = 0; i < currencyNodeList.getLength(); i++) {
            if (currencyNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element curElement = (Element) currencyNodeList.item(i);


                Currency currency = new Currency(); // создаем объект класса
                Element cuElement = (Element) document.getElementsByTagName("Currency").item(0); // достаем значение элемента Currency, чтобы добраться до атрибута Id
                currency.setId(Integer.parseInt(cuElement.getAttribute("Id")));


                NodeList currencyNodes = curElement.getChildNodes();
                for (int j = 0; j < currencyNodes.getLength(); j++) {
                    if (currencyNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element currencyElement = (Element) currencyNodes.item(j);
                        switch (currencyElement.getNodeName()) {
                            case "NumCode": {
                                currency.setNumCode(currencyElement.getTextContent()); // получение текстового контента
                            }
                            break;
                            case "CharCode": {
                                currency.setCharCode(currencyElement.getTextContent());
                            }
                            break;
                            case "Scale": {
                                currency.setScale(currencyElement.getTextContent());
                            }
                            break;
                            case "Name": {
                                currency.setName(currencyElement.getTextContent());
                            }
                            break;
                            case "Rate": {
                                currency.setRate(currencyElement.getTextContent());
                            }

                        }

                    }

                }
                currencyList.add(currency);

            }

        }
        currencyList.forEach(System.out::println);


    }

}
