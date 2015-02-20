package fr.iutinfo.bins;

import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String author;
	private String content;
	//private ArrayList<ArrayList<Integer>> structuredContent;
	
	public Level() {
		this(0);
	}
	
	public Level(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		//syncrhonizeContents(content);
	}
	
	/*private void syncrhonizeContents(String content) {
		this.content = content;
		structuredContent = new ArrayList<ArrayList<Integer>>();
		String[] lines = content.split(",");
		for(String line : lines) {
			String[] cells = line.split("\\s+");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(String cell : cells) {
				list.add(Integer.parseInt(cell));
			}
			structuredContent.add(list);
		}
	}
	
	private void syncrhonizeContents(ArrayList<ArrayList<Integer>> structuredContent) {
		this.structuredContent = structuredContent;
		content = "";
		for(int i = 0 ; i < structuredContent.size() ; i++) {
			if(i != 0)
				content += ",";
			for(Integer cell : structuredContent.get(i)) {
				content += " " + cell;
			}
		}
	}*/
	
	private ArrayList<ArrayList<Integer>> parseLevel(String content) {
		ArrayList<ArrayList<Integer>> structuredContent = new ArrayList<ArrayList<Integer>>();
		String[] lines = content.split(",");
		for(String line : lines) {
			String[] cells = line.split("\\s+");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(String cell : cells) {
				list.add(Integer.parseInt(cell));
			}
			structuredContent.add(list);
		}
		return structuredContent;
	}
	
	private String serializeContent(ArrayList<ArrayList<Integer>> structuredContent) {
		String content = "";
		for(int i = 0 ; i < structuredContent.size() ; i++) {
			if(i != 0)
				content += ",";
			for(Integer cell : structuredContent.get(i)) {
				content += " " + cell;
			}
		}
		return content;
	}
	
	public void setStructuredContent(ArrayList<ArrayList<Integer>> structuredContent) {
		content = serializeContent(structuredContent);
	}

	public ArrayList<ArrayList<Integer>> getStructuredContent() {
		return parseLevel(content);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
