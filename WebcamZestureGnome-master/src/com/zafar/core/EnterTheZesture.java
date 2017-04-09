package com.zafar.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.sarxos.webcam.Webcam;
import com.zafar.core.GestureRecogniser;

public class EnterTheZesture {
	
	private LinkedBlockingQueue<BufferedImage> video = new LinkedBlockingQueue<BufferedImage>();

	private GestureRecogniser recogniser = new GestureRecogniser();

	public EnterTheZesture() {
		recogniser.setVideo(video);
	}

	public static void main(String[] args) {
		EnterTheZesture gesture = new EnterTheZesture();
		new Thread(gesture.recogniser).start();
		int cameraNumber=0;
		if(args!=null && args.length>0)
			cameraNumber=Integer.parseInt(args[0]);
		gesture.readFromCam(cameraNumber);
	}

	public void readFromCam(int cameraNumber) {
		Webcam webcam=null;
		BufferedImage image;
		boolean status=false;
		try {
			List<Webcam> webcams=Webcam.getWebcams();
			if(cameraNumber!=0 && webcams.size()>1)
			{	
				webcam=webcams.get(cameraNumber);
				webcams=new ArrayList<Webcam>();
				webcams.add(webcam);
			}
			for(Webcam cam:webcams){
				try{
					webcam = cam;
					System.out.println("Trying capturing "+webcam.getName());
					
					//now that we have added command asynchronously, we may be able to do recognition on the original feed
					//webcam.setViewSize(new Dimension(320, 240));//cranking up the resolution makes the recognition slow, so keep it at 320*340
					if(status=webcam.open()){
						break;
					}
				}
				catch (Exception e) {
					System.out.println("Your camera "+webcam.getName()+" may be blocked / in use");
					e.printStackTrace();
				}
			}
			if(!status)
				return;
			while(!Thread.interrupted()) {
				image = webcam.getImage();
				if(image!=null){
					video.put(image);
					
				}
			}

			// ImageIO.write(image, "PNG", new File("motion"+i+".png"));


		} catch (Exception e) {
			System.out.println("Some error occurred "+video.size());
			e.printStackTrace();
		}
		finally{
			webcam.close();
		}
	}

}
