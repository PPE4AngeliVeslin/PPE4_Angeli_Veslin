package com.example.mangeli.m2lgestitiondesequipes;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import metier.categorie;
import metier.licencie;

public class LitXml {

	private List<categorie> LesCategories;
	private List<licencie> LesLicencies;
	
	public LitXml(Context context)  {
		try {
			MaSaxHandler handler = new MaSaxHandler();
			Resources resources = context.getResources();
			InputStream inputStream = resources.openRawResource(R.raw.m2l);
			handler.parse(inputStream);
	        LesCategories = handler.getLesCategories();
			LesLicencies = handler.getLeslicencies();
		} catch (Exception e) {
			Log.i("litxml", "erreur");
		}
	}
	
	public List<String> donneServices(){
		List<String> liste = new ArrayList<String>();
		for (categorie uneCategorie : LesCategories) {
			liste.add(uneCategorie.toString());
		}
		return liste;
	}
}
