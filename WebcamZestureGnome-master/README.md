# Gesture based interaction for your computer

You can use hand gestures of 'up', 'right', 'left' and 'down' to control your desktop in any number of ways. These gestures can be assigned to keyboard shortcuts to perform different tasks of your convenience. 

The file gestureMapper.properties maps these 4 gestures to commands. For example, the 'up' gesture can be mapped to the keyboard action PAGE_UP. These keyboard actions are defined in dictionary.properties.

*To run this application, double click on WebcamZestureGnome-1.0-executable.jar in the target folder. If you have Java 8 or above installed, this should start working immediately.* 

To build this, run 'mvn clean install'. For this, you will need maven to be installed on your system. If you don't want to build it, but want to change command-gesture mapping, unzip the WebcamZestureGnome-1.0-executable.jar file into a folder. For example, if you want to map the gesture 'up' to the command 'volume_up', then change the entry of 'up' in file gestureMapper.properties to 'volume_up'. After saving the file, just zip to again and you are done.

Currently the application will work better if your background is not changing very frequently.
