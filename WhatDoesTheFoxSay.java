/**
* This program takes in a user's input file which contains recordings of  
* animal sounds
* The sounds of animals that are in the input file are removed from the file and 
* then printed out
*
* @author Charles Tapia
* Date:   10-20-2020
*/
import java.util.*;
import java.io.*;
public class WhatDoesTheFoxSay 
{
	public static void main(String[] args)  throws IOException
	{
		// Created FileReader to read the input 
		BufferedReader in = new BufferedReader (new FileReader("InputFile.txt"));  
		ArrayList<String> HoldsSounds = new ArrayList<String>();
		int numberOfLines = Integer.parseInt(in.readLine()); 
		// Will hold the sounds that the animals make
		String animalSound;
		// Will put numberOfLines of sounds inside an arraylist
		for(int cnt = 0; cnt < numberOfLines; cnt++)
		{
			HoldsSounds.add(in.readLine());
		}	
			// Will read the first line with animal goes _ format
			// animalSound become just the animal sound
			animalSound = in.readLine();
			// Loop will continue until animalSound equals the phrase "what does the fox say?" 
			do
			{
				// index starts at one so first character can be read
				int index = 1;
				// index will keep increasing until aniamlSound contains "goes" 
				while(!animalSound.substring(0, index).contains("goes") && animalSound.contains("goes"))
				{
					index++;
				}
				// if animalSound contains "goes" then it will just become the animal sound 
				if(animalSound.contains("goes"))
				{
					// index + 1 will take care of the space after "goes"
					animalSound = animalSound.substring(index+1, animalSound.length());
				}
				// Will replace the current animal sound for each recording
				for(int cnt = 0; cnt < HoldsSounds.size(); cnt++)
				{
					// NewSound will contain the new recording with the animal sound removed
					String NewSound = HoldsSounds.get(cnt).replaceAll(animalSound, "");
					// The current recording is removed 
					HoldsSounds.remove(cnt);
					// The new recording is added to previous recording's position
					HoldsSounds.add(cnt, NewSound);
				}
				// animal sound will read the next animal goes _ in the file
				animalSound = in.readLine();
			}
			while(!animalSound.equals("what does the fox say?"));
			// Prints out "what does the fox say?"
			System.out.println(animalSound);
			System.out.println("The fox says:");
			// Makes sounds more readable by reducing spacing between sounds
			for(int cnt = 0; cnt < HoldsSounds.size(); cnt++)
			{
				String CurrentRecording = HoldsSounds.get(cnt);
				CurrentRecording = CurrentRecording.replaceAll("   ", " ");
;				HoldsSounds.remove(cnt);
				HoldsSounds.add(cnt, CurrentRecording);
			}
			// Fox saying is printed out
			for(int cnt = 0; cnt < HoldsSounds.size(); cnt++)
			{
				System.out.println(HoldsSounds.get(cnt));
			}
		}
}
//The quote is "The best ideas make come as jokes make your thinking as funny as possible"  David Ogilvy