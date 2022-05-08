package me.communitygames.multiplugin;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UpdateChecker 
{
	private multiplugin plugin;
	private URL filesFeed;
	
	private String version;
	private String link;
	
	public UpdateChecker(multiplugin plugin, String url)
	{
		this.plugin = plugin;
		try 
		{
			this.filesFeed = new URL(url);
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public boolean updateNeeded()
	{
		try 
		{
			InputStream input = this.filesFeed.openConnection().getInputStream();
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
	
			Node latestfile = document.getElementsByTagName("item").item(0);
			NodeList children = latestfile.getChildNodes();
			
			this.version = children.item(1).getTextContent().replaceAll("a-zA-Z", "");
			this.link = children.item(3).getTextContent();
			
			if(!plugin.getDescription().getVersion().equals(this.version))
				return true;
		}
		catch (Exception e) 
		{
			System.out.println("[multiplugin] Update Checker: Update - FAILED!\n" + e);
		}
		return false;
	}
	
	public String getVersion()
	{
		return this.version;
	}
	
	public String getLink()
	{
		return this.link;
	}
}
