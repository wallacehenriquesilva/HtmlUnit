package main;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Robo {


    private static final String url = "http://www.facebook.com";

    public static void main(String[] args) {
        //Desativa as advertências do log
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
        //Desativa as advertências do log

        try {
            WebClient webClient = new WebClient();
            HtmlPage pagina = null;

            //Desativa o javaScript
            webClient.getOptions().setJavaScriptEnabled(false);
            //Desativa CSS
            webClient.getOptions().setCssEnabled(false);

            pagina = webClient.getPage(url);
            //Pega o titulo da página
            System.out.println("Titulo da página: " + pagina.getTitleText());

            //Pega os textos da página
            //System.out.println("Pagina elementos" + pagina.asText());

            //Pega o HTML da página toda
            //System.out.println("" + pagina.asXml());

            //Pega anchor <a id='x' href='/home' ...
            //HtmlAnchor anchor = pagina.getAnchorByHref("/home");
            //System.out.println(anchor);

            //Evento de clique
            //pagina = anchor.click();

            //Pega uma imagem
            //HtmlImage imgElement = pagina.getHtmlElementById("img_logo");

            //Pega o source da imagem
            //System.out.println(imgElement.getAttribute("src"));


            //Elemento via xpath --- O get(0) primeiro item
            //HtmlElement element = (HtmlElement) pagina.getByXPath("//a[@class='tit']").get(0);
            //System.out.println("Texto do elemento: " + element.asText());

            //Lista de elementos
            List<HtmlElement> listElementos = new ArrayList<HtmlElement>();
      
            for(int i = 0; i <= 5; i++){
                HtmlElement element = (HtmlElement) pagina.getByXPath("//a[@class='tit']").get(i);
                listElementos.add(element);
            }
            System.out.println(listElementos.size());

            for(HtmlElement e : listElementos){
                System.out.println(e.getChildNodes());
            }


            //Input
           /* HtmlInput email = pagina.getElementByName("email");
            email.setValueAttribute("wallace_25@hotmail.com");

            HtmlInput senha = pagina.getElementByName("pass");
            email.setValueAttribute("991492376wallace");

            //Botão input
            HtmlSubmitInput submitBtn = (HtmlSubmitInput)pagina.getElementById("u_0_r");
            pagina = submitBtn.click();
            System.out.println(pagina.getTitleText());*/



        } catch (IOException e) {
            System.out.println("Erro --> " + e);
            e.printStackTrace();
        }

    }
}
