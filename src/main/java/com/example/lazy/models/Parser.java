package com.example.lazy.models;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser  {
    private static ArrayList<String> books;
    private  Document getPage() throws IOException {
        String url = "https://enter.kg/computers/noutbuki_bishkek";
        org.jsoup.nodes.Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public  void Start() throws IOException {
        Document page = getPage();
        Element main = page.select("div[id=main]").first();
        Elements rows = main.select("div[class=row]");
        for(Element row : rows){
            String date = row.select("span[class=prouct_name]").text();
            books.add(date);
            System.out.println(date);
        }

        //Element rows = tabl.select("").first();
        //System.out.println(rows);

    }

}
