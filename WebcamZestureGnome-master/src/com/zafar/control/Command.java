package com.zafar.control;

public class Command {
	private String[] instructions=null;	
	private char[] sequence=null;
	private Platform platform;
	public Command()
	{
		
	}
	public void setPlatform(Platform platform)
	{
		this.platform=platform;
	}
	public Platform getPlatform()
	{
		return platform;
	}
	public Command(String[] instructions, char[] sequence)
	{
		this.instructions=instructions;
		this.sequence=sequence;
	}
	public char[] getSequence() {
		return sequence;
	}
	public void setSequence(char[] sequence) {
		this.sequence = sequence;
	}
	void setInstructions(String [] instructions)
	{
		this.instructions=instructions;
	}
	public String[] getInstructions()
	{
		return instructions;
	}
	
}
