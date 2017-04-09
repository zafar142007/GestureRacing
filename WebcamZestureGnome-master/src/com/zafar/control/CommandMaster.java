package com.zafar.control;

import java.io.IOException;
import java.util.Properties;


public class CommandMaster {

	private Dictionary dictionary=new Dictionary();
	private ControlScreen controller=new ControlScreen();
	private Properties gestureMapper=new Properties();
	private static int UP_COMMAND_MULTIPLICITY, DOWN_COMMAND_MULTIPLICITY, RIGHT_COMMAND_MULTIPLICITY, LEFT_COMMAND_MULTIPLICITY;
	public CommandMaster(){
		try {
			gestureMapper.load(CommandMaster.class.getClassLoader().getResourceAsStream("gestureMapper.properties"));
			UP_COMMAND_MULTIPLICITY=Integer.parseInt((String) gestureMapper.get("UP_COMMAND_MULTIPLICITY"));
			DOWN_COMMAND_MULTIPLICITY=Integer.parseInt((String) gestureMapper.get("DOWN_COMMAND_MULTIPLICITY"));
			RIGHT_COMMAND_MULTIPLICITY=Integer.parseInt((String) gestureMapper.get("RIGHT_COMMAND_MULTIPLICITY"));
			LEFT_COMMAND_MULTIPLICITY=Integer.parseInt((String) gestureMapper.get("LEFT_COMMAND_MULTIPLICITY"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public String sanitize(String string)
	{
		return string.replace(' ', '_');
	}
	public Command interpret(String command) throws CommandNotFoundException
	{
		Command[] commands=null;

		commands=dictionary.getCommands(sanitize(command));
		if(System.getProperty("os.name").toLowerCase().indexOf("win")>=0)
		{
			for(int i=0;i<commands.length;i++)
				if(commands[i].getPlatform().toString().equals("win"))				
					return commands[i];
		}
		else
			if(System.getProperty("os.name").toLowerCase().indexOf("nux")>=0)
			{
				for(int i=0;i<commands.length;i++)
					if(commands[i].getPlatform().toString().equals("nix"))				
						return commands[i];					
			}

		return null;

	}
	public void executeCommand(String gesture){
		String command=(String) gestureMapper.get(gesture);
		Runnable job=()->{
				try {
					int multiplicity=0;
					switch(gesture){
						case "up":
							multiplicity=UP_COMMAND_MULTIPLICITY;
							break;
						case "down":
							multiplicity=DOWN_COMMAND_MULTIPLICITY;
							break;
						case "left":
							multiplicity=LEFT_COMMAND_MULTIPLICITY;
							break;
						case "right":
							multiplicity=RIGHT_COMMAND_MULTIPLICITY;
					}
							
					for(int i=0;i<multiplicity; i++)
						controller.execute(interpret(command));
				} catch (CommandNotFoundException e) {
					e.printStackTrace();
				}
		};
		new Thread(job).start();
	}
}
