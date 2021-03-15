package com.mall.huitop.utils;

import com.mall.huitop.model.SerachContent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;

/**
 * 解析页面 ，爬虫
 */
public class HtmlParseUtil {
    public static void main(String[] args) throws Exception{
        new HtmlParseUtil().serachContents("裤子").forEach(System.out::println);
    }

    public ArrayList<SerachContent> serachContents(String keywords)throws Exception{
        if ("".equals(keywords) || keywords == null){
            return null;
        }
        //获取请求
        String url = "https://search.jd.com/Search?keyword=" + keywords +"&enc=utf-8";
        Document document = Jsoup.parse(new URL(url), 20000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        ArrayList<SerachContent> goodList = new ArrayList<>();
        for (Element el : elements) {
            String img = "";
            img = el.getElementsByTag("img").eq(0).attr("source-data-lazy-img");
            if ("".equals(img) || img == null){
                img = el.getElementsByTag("img").eq(0).attr("src");
            }
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            if (title.isEmpty()){
                title = el.getElementsByClass("p-name").eq(0).attr("title");
            }
            String shop = el.getElementsByClass("p-shop").eq(0).text();
            //bug 有些商品的店铺标签不为p-shop
            if (shop.isEmpty()){
                shop = el.getElementsByClass("p-shopnum").eq(0).text();
            }
            SerachContent content = new SerachContent();
            content.setTitle(title);
            content.setPrice(price);
            content.setImg(img);
            content.setShop(shop);
            goodList.add(content);
        }
        return goodList;
    }
}
