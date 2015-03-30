package boot;

import java.text.ParseException;
import java.util.*;
import java.io.*;


public class Hyperlink implements Serializable {
	
	String name;
	String metatag;
	String comment;
	String date;
	String datemod;
	
	public Hyperlink(String name, String metatag, String comment, String date, String datemod)
	{
		this.date = date;
		this.name = name;
		this.metatag = metatag;
		this.comment = comment;	
		this.datemod = datemod;

	}
	
	public static ArrayList<Integer> searchHyperlink(String string, ArrayList<Hyperlink> list, int type)
	{
		ArrayList<Integer> poslist = new ArrayList<Integer>();
		
		switch (type){
		case 1:	for(int i = 0;i<list.size();i++)
				{
					if(list.get(i).name.equals(string)) //searching
						poslist.add(i);		
				}
				return poslist; //EXCEPTION, CUIDADO
				
		case 2:	for(int i = 0;i<list.size();i++)
				{
					if(list.get(i).metatag.equals(string)) //searching
						poslist.add(i);
				}
				return poslist; //EXCEPTION, CUIDADO
		
		case 3:	for(int i = 0;i<list.size();i++)
				{
					if(list.get(i).comment.equals(string)) //searching
						poslist.add(i);
				}
				return poslist; //EXCEPTION, CUIDADO
		
		case 4:	for(int i = 0;i<list.size();i++)
				{
					if(list.get(i).date.equals(string)) //searching
						poslist.add(i);
				}
				return poslist; //EXCEPTION, CUIDADO
		case 5:	for(int i = 0;i<list.size();i++)
				{
					if(list.get(i).datemod.equals(string)) //searching
						poslist.add(i);
				}
				return poslist; //EXCEPTION, CUIDADO
		
		
		default: return poslist; //INVALID TYPE OR NO RESULTS
		}
	}
	
	public ArrayList<Hyperlink> editHyperlink(int pos, ArrayList<Hyperlink> list, int type, String edit)
	{
		switch (type){
		case 1: list.get(pos).name = edit;
				return list;
		case 2: list.get(pos).metatag = edit;
				return list;
		case 3: list.get(pos).comment = edit;
				return list;
		case 4: list.get(pos).date = edit;
				return list;
		case 5: list.get(pos).datemod = edit;
				return list;
		default: return list; //INVALID TYPE -> DO NOTHING
		
		}
	}
	
	public ArrayList<Hyperlink> addHyperlink(ArrayList<Hyperlink> list, Hyperlink hyperlink)
	{
		list.add(hyperlink);
		return list;
	}
	
	public static void Serialize (ArrayList<Hyperlink> list)
	{
	      try
	      {
	         FileOutputStream fileOut = new FileOutputStream("hyperlinks.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(list);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}

	public static ArrayList<Hyperlink> Load()
	{
		ArrayList<Hyperlink> list = new ArrayList<Hyperlink>();
	    try
	    {
	       FileInputStream fileIn = new FileInputStream("hyperlinks.ser");
	       ObjectInputStream in = new ObjectInputStream(fileIn);
	       list = (ArrayList<Hyperlink>) in.readObject();
	       in.close();
	       fileIn.close();
	       return list;
	    }catch(IOException i)
	    {
	       //i.printStackTrace();
	       return list;
	    }catch(ClassNotFoundException c)
	    {
	       //System.out.println("Hyperlink class not found");
	       //c.printStackTrace();
	       return list;
	    }
	}
		
}
