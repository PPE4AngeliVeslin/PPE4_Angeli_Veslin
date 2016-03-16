package com.example.mangeli.m2lgestitiondesequipes;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import metier.categorie;
import metier.equipe;
import metier.licencie;
import metier.ligue;


public class MaSaxHandler extends DefaultHandler {

	   private categorie Categorie;
	   private licencie Licencie;
	   private ligue ligue;
	   private equipe equipe;
	   private List<categorie> lesCategories = new ArrayList<categorie>();
	   private List<licencie> leslicencies = new ArrayList<licencie>();
	   private List<ligue> lesLigues = new ArrayList<ligue>();
	   private List<equipe> lesEquipes = new ArrayList<equipe>();
	   private String valeur;

	   private String colonne;
	   private String table;

	   public void parse(InputStream is) throws ParserConfigurationException, SAXException, IOException{
		   SAXParserFactory factory = SAXParserFactory.newInstance();
		   SAXParser parser=factory.newSAXParser();
		   parser.parse(is,this);
	   }
	   public void startElement( String uri, String localName, String qName, Attributes attributes)
			   throws SAXException {
		   if (qName.equals("table")){
               if (attributes.getValue("name").equals("categorie")) {
				   Categorie = new categorie();
				   table = "categorie";
			   }
               else if (attributes.getValue("name").equals("licencie")){
                   Licencie = new licencie();
				   table = "licencie";
               }
           }
		   if (qName.equals("column")){
			   colonne = attributes.getValue("name");
			   if (table == "categorie"){
				   if (colonne == "libelle") {
					   Categorie.setLibelle(valeur);
					   String str = table + " : " + colonne;
					   Log.i("litxml", str);
				   }
				   if (colonne == "id") {
					   Categorie.setId(Integer.parseInt(valeur));
					   String str = table + " : " + colonne;
					   Log.i("litxml", str);
				   }
			   }
		   }
	   }
	   public void characters(char[] ch,int start, int length) throws SAXException{
			valeur = new String(ch,start,length);
	   }
	   public void endElement( String uri, String localName,String qName) throws SAXException {
	        if (localName.equals("table")) {
				if (table == "categorie") {
					lesCategories.add(Categorie);
					table = null;
				}
		    }
	    }
	   public List<categorie> getLesCategories() {
		return lesCategories;
	   }
	   public List<licencie> getLeslicencies() {
	    return leslicencies;
	   }
}
